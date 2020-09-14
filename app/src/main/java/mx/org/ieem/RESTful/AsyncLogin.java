package mx.org.ieem.RESTful;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import mx.org.ieem.RESTful.JSONModels.UsuarioJM;
import mx.org.ieem.data.sqllite.DataBaseAppRed;
import mx.org.ieem.data.sqllite.DataBaseFillAndUpdate;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_cct;

import static mx.org.ieem.data.sqllite.constants.encuestasj.CamposyTablasEncuestas.TABLE_NAME_CCT_GENERAL;


public class AsyncLogin extends AsyncTask<String, Void, Boolean>
{

    private String stringEmail;                             // Guarda el valor de el email proporcionado por el usuario.
    private String stringContrasenia;                       // Guarda el valor de la contrasenia proporcionada por el usario.
    private ProgressBar btnLogin;
    public static boolean bolLogeado = false;               // Nos dice si el usaurio sigue logueado o no.
    public static Context contextActual;                    // Contexto del activity que ejecuto la tarea en segundo plano (LoginActivity).
    public static String id_cct_final = "";                 // En caso de que exista el usuario en el servidor llenara esta variable con el valor ddel id_cct.
    public static trdd_cct actual_final = null;             // Objeto de tipo trdd_ej_cct que contendra los datos del usuario logueado.
    public static String id_random_final = "";              // Variable que contiene el id_RANDOM
    boolean booleanIsBdVacia;                               // Dice si la bd esta vacia para asi pedir las tablas al servidor
    DataBaseAppRed database;                                // Instancia de la base de datos utilizado para obtener el municipio de acuerdo a un objeto de tipo trdd_ej_cct.

    public AsyncLogin(Context context, ProgressBar btn) { this.contextActual = context;database = new DataBaseAppRed(context);this.btnLogin = btn;}


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(String... strings)
    { // Hilo en segundo plano (TOP)
        this.stringEmail = strings[0];
        this.stringContrasenia = strings[1];
        try
          { // Intenta realizar una conexion con el servidor (TOP)
              sendPost(stringEmail,stringContrasenia);
          } // Intenta realizar una conexion con el servidor (BOTTOM)
        catch (IOException | CertificateException | KeyStoreException | NoSuchAlgorithmException | KeyManagementException | JSONException e)
          { // Muestra cualquier error relacionado con la conexion (TOP)
              Log.e("Error",e.toString());
          } // Muestra cualquier error relacionado con la conexion (BOTTOM)
        return null;
    } // Hilo en segundo plano (BOTTOM)

    public void sendPost(String id, String contrasenia) throws IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException, JSONException { // Metodo sendPOST() (TOP)

        String obtenerCatalogos = "true";
        UsuarioJM usuarioJM = new UsuarioJM(id,contrasenia,obtenerCatalogos);                                        // Contiene un objeto de tipo UsuarioJM creado a partir del email y contrasena proporcionado por el usuario.
        CertificateFactory cf = CertificateFactory.getInstance("X.509");                            // Se emplea para generar certificados.
        InputStream caInput = contextActual.getAssets().open("load-der.crt");              // Aloja el certificado que se encuentra dentro de el directorio Assets.
        Certificate ca;                                                                             // Certificado creado a partir de load-der.crt.
        OutputStreamWriter out;                                                                     // Datos que seran enviados por metodo POST.
        int HttpResult;                                                                             // Contiene el codigo de respuesta del servidor.
        URL url;                                                                                    // Contiene la url que proporciona el servicio.
        String responseHttp;
        try
          { //Intenta generar el certificado (TOP)
              ca = cf.generateCertificate(caInput);
              Log.e("ca=", ""+((X509Certificate) ca).getSubjectDN());
          } //Intenta generar el certificado (BOTTOM)
        finally
          { // Cierra el inputStream (TOP)
              caInput.close();
          } // Cierra el inputStream (BOTTOM)

        // Creacion del KeyStore con el certificado load-der.crt (TOP)
        String keyStoreType = KeyStore.getDefaultType();
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(null, null);
        keyStore.setCertificateEntry("ca", ca);
        // Creacion del KeyStore con el certificado load-der.crt (BOTTOM)

        // Creacion del TrustManager que confiara en lo que este en nuestro keystore (TOP)
        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
        tmf.init(keyStore);
        // Creacion del TrustManager que confiara en lo que este en nuestro keystore (BOTTOM)

        // Creacion de un SSLContext que usara nuestra TrustManager (TOP)
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, tmf.getTrustManagers(), null);
        // Creacion de un SSLContext que usara nuestra TrustManager (BOTTOM)

        // Configuracion de la conexion (TOP)
        url = new URL("https://registro.ieem.org.mx:8443/redDigitalDpc/login");
        HttpsURLConnection urlConnection = (HttpsURLConnection)url.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        urlConnection.setSSLSocketFactory(context.getSocketFactory());
        urlConnection.setConnectTimeout(10000);
        urlConnection.setReadTimeout(10000);
        urlConnection.setRequestProperty("Content-Type","application/json");
        urlConnection.connect();
        // Configuracion de la conexion (BOTTOM)

        // POST
        out = new OutputStreamWriter(urlConnection.getOutputStream());
        // TODO Aqui se comprueban los datos de la bd para saber si se pediran las tablas o no
        //if(ds.checkTablas()){

        //}
        Log.e("ENVIO",usuarioJM.toString());
        out.write(usuarioJM.toString());
        out.close();
        // POST
        // RESPONSE

        HttpResult =urlConnection.getResponseCode();
        responseHttp = respuestaServidor(urlConnection); // Se carga la respuesta del servidor
        Log.e("RESPUESTA",responseHttp);
        Log.e("CODE", String.valueOf(HttpResult));
        if (HttpResult == 200)
          { // Si el Codigo de respuesta es 200 (Si existe el usuario) (TOP)
              cargarVersionYCctLogin(responseHttp);
              bolLogeado = true;
          } // Si el Codigo de respuesta es 200 (Si existe el usuario) (BOTTOM)
        else
          { // Impide el logueo (TOP)
              bolLogeado = false;
          } // Impide el logueo (TOP)
        // RESPONSE
    } // Metodo sendPOST() (BOTTOM)

    /**
     * Método que covierte un string formato JSON a un objeto de tipo trd_dcct
     * @stringToJson se regresa.
     */
    public String respuestaServidor(HttpsURLConnection urlConnec) throws IOException {
        StringBuilder sb;                                                                           // Contiene la respuesta del servidor ya tratada.
        BufferedReader br;                                                                          // contiene la respuesta del servidor sin tratar.
        String line;                                                                                // Auxiliar para leer la respuesta del servidor.
        sb = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(urlConnec.getInputStream(),"utf-8"));
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();
        //Log.e("RESPONSE",sb.toString());
        return sb.toString();
    }

    public void cargarVersionYCctLogin(String response) throws IOException, JSONException
    {
        DataBaseAppRed ds = new DataBaseAppRed(contextActual);                //Instancia de la base de datos.
        JSONObject respuestaLogin = new JSONObject(response);
        JSONObject trdd_cct_res = respuestaLogin.getJSONObject(TABLE_NAME_CCT_GENERAL);
        String id_cct = trdd_cct_res.getString("id_cct");
        String nombre = trdd_cct_res.getString("nombre");
        String domicilio = trdd_cct_res.getString("domicilio");
        String email = trdd_cct_res.getString("email");
        int id_municipio = trdd_cct_res.getInt("id_municipio");
        int id_nivel_educativo = trdd_cct_res.getInt("id_nivel_educativo");
        String contrasenia = "";
        actual_final = new trdd_cct(id_cct,nombre,domicilio,email,id_municipio,id_nivel_educativo,contrasenia);
        ds.insertCctActual(actual_final);
        id_cct_final = actual_final.getId_cct();;
        if(ds.getIdRandomDispositivo().equals("vacio"))
        {
            //TODO metodo que genere numero aleatorio
            id_random_final = generarIdRandom();
            ds.insertIdRandomDispositivo(id_random_final);
        }
        else{
            id_random_final = ds.getIdRandomDispositivo();
        }

        if(ds.checkTablas())
        {
            new DataBaseFillAndUpdate(response,contextActual);
        }
    }


    public String generarIdRandom(){
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        String auxiliar = "";
        for (int i = 0 ; i < 8 ; i++)
        {
            int intAletorio = rnd.nextInt(9);
            auxiliar = auxiliar + String.valueOf(intAletorio);
        }
        return auxiliar;
    }
}
