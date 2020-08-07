package mx.org.ieem.RESTful;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import mx.org.ieem.RESTful.JSONModels.UsuarioJM;
import mx.org.ieem.data.sqllite.DataBaseAppRed;
import mx.org.ieem.data.sqllite.models.trdd_cct;

import com.google.gson.Gson;

import org.json.JSONArray;
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

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;


public class AsyncLogin extends AsyncTask<String, Void, Boolean> {

    private String stringEmail;                             //Guarda el valor de el email proporcionado por el usuario.
    private String stringContrasenia;                       // Guarda el valor de la contrasenia proporcionada por el usario.
    public static boolean bolLogeado = false;               // Nos dice si el usaurio sigue logueado o no.
    Context contextActual;                                  // Contexto del activity que ejecuto la tarea en segundo plano (LoginActivity).

    public static String id_cct_final = "";                 // En caso de que exista el usuario en el servidor llenara esta variable con el valor ddel id_cct.
    public static trdd_cct actual_final = null;             // Objeto de tipo trdd_cct que contendra los datos del usuario logueado.
    DataBaseAppRed database;                                // Instancia de la base de datos utilizado para obtener el municipio de acuerdo a un objeto de tipo trdd_cct.

    public AsyncLogin(Context context) { this.contextActual = context;database = new DataBaseAppRed(context);}

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

        UsuarioJM usuarioJM = new UsuarioJM(id,contrasenia);                                        // Contiene un objeto de tipo UsuarioJM creado a partir del email y contrasena proporcionado por el usuario.
        CertificateFactory cf = CertificateFactory.getInstance("X.509");                            // Se emplea para generar certificados.
        InputStream caInput = contextActual.getAssets().open("load-der.crt");              // Aloja el certificado que se encuentra dentro de el directorio Assets.
        Certificate ca;                                                                             // Certificado creado a partir de load-der.crt.
        OutputStreamWriter out;                                                                     // Datos que seran enviados por metodo POST.
        StringBuilder sb;                                                                           // Contiene la respuesta del servidor ya tratada.
        int HttpResult;                                                                             // Contiene el codigo de respuesta del servidor.
        BufferedReader br;                                                                          // contiene la respuesta del servidor sin tratar.
        String line;                                                                                // Auxiliar para leer la respuesta del servidor.
        URL url;                                                                                    // Contiene la url que proporciona el servicio.

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
        url = new URL("https://registro.ieem.org.mx:8443/redDigitalDpc/reddigitaldpc/obtenerUsuario");
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
        out.write(usuarioJM.toString());
        out.close();
        // POST
        // RESPONSE
        sb = new StringBuilder();
        HttpResult =urlConnection.getResponseCode();
        Log.e("CODE",String.valueOf(HttpResult));
        if (HttpResult == 200)
          { // Si el Codigo de respuesta es 200 (Si existe el usuario) (TOP)
              // TODO agregar metodo para editar login.txt por respuesta del servidor.
              actual_final = cargarRespuestaCCTLogin();
              DataBaseAppRed ds = new DataBaseAppRed(contextActual);                //Instancia de la base de datos.
              ds.insertCctActual(actual_final.getId_cct(),actual_final.getNombre(),actual_final.getDomicilio(),actual_final.getEmail(),actual_final.getId_municipio(),actual_final.getId_nivel_educativo());
              id_cct_final = actual_final.getId_cct();;
              bolLogeado = true;
          } // Si el Codigo de respuesta es 200 (Si existe el usuario) (BOTTOM)
        else
          { // Impide el logueo (TOP)
              bolLogeado = false;
          } // Impide el logueo (TOP)
        br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));
        line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();
        // RESPONSE
        Log.e("RESPONSE",sb.toString());
    } // Metodo sendPOST() (BOTTOM)

    /**
     * Método que covierte un string formato JSON a un objeto de tipo trd_dcct
     * @stringToJson se regresa.
     */

    public trdd_cct cargarRespuestaCCTLogin() throws IOException, JSONException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(contextActual.getAssets().open("login.txt")));
        StringBuilder total = new StringBuilder();
        for (String line; (line = r.readLine()) != null; ) {
            total.append(line).append('\n');
        }
        JSONObject respuestaLogin = new JSONObject(total.toString());
        JSONObject trdd_cct = respuestaLogin.getJSONObject("trdd_cct");
        String id_cct = trdd_cct.getString("id_cct");
        String nombre = trdd_cct.getString("nombre");
        String domicilio = trdd_cct.getString("domicilio");
        String email = trdd_cct.getString("email");
        int id_municipio = trdd_cct.getInt("id_municipio");
        int id_nivel_educativo = trdd_cct.getInt("id_nivel_educativo");
        return new trdd_cct(id_cct,nombre,domicilio,email,id_municipio,id_nivel_educativo);
    }
}
