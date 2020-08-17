package mx.org.ieem.RESTful;


import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;

import mx.org.ieem.RESTful.JSONModels.UsuarioJM;
import mx.org.ieem.data.sqllite.DataBaseAppRed;
import mx.org.ieem.data.sqllite.DataBaseFillAndUpdate;
import mx.org.ieem.data.sqllite.models.ciudadanometro.trdd_c_municipio;
import mx.org.ieem.data.sqllite.models.ciudadanometro.trdd_c_nivel_educativo;

import mx.org.ieem.data.sqllite.models.encuestaj.trdd_ej_municipio;

import mx.org.ieem.data.sqllite.models.encuestaj.trdd_ej_nivel_educativo;

import mx.org.ieem.data.sqllite.models.general.trdd_tipo_sistema_apk;
import mx.org.ieem.data.sqllite.models.general.trdd_version_tabla;
import mx.org.ieem.data.sqllite.models.general.trdd_cct;

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
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;


import static mx.org.ieem.data.sqllite.constants.RespuestasSimuladas.RESPUESTA_SIMULADA_A;
import static mx.org.ieem.data.sqllite.constants.RespuestasSimuladas.RESPUESTA_SIMULADA_VERSIONES;
import static mx.org.ieem.data.sqllite.constants.ciudadanometro.CamposyTablasCiudadano.TABLE_NAME_NIVEL_EDUCATIVO_CIUDADANOMETRO;
import static mx.org.ieem.data.sqllite.constants.ciudadanometro.CamposyTablasCiudadano.TABLE_NAME_TMUNICIPIO_CIUDADANOMETRO;
import static mx.org.ieem.data.sqllite.constants.encuestasj.CamposyTablasEncuestas.*;
import static mx.org.ieem.data.sqllite.constants.general.CamposyTablasGeneral.TABLE_NAME_PARAMETROS;
import static mx.org.ieem.data.sqllite.constants.general.CamposyTablasGeneral.TABLE_NAME_TIPOSISTEMA;


public class AsyncLogin extends AsyncTask<String, Void, Boolean> {

    private String stringEmail;                             // Guarda el valor de el email proporcionado por el usuario.
    private String stringContrasenia;                       // Guarda el valor de la contrasenia proporcionada por el usario.
    public static boolean bolLogeado = false;               // Nos dice si el usaurio sigue logueado o no.
    public static Context contextActual;                    // Contexto del activity que ejecuto la tarea en segundo plano (LoginActivity).
    public static String id_cct_final = "";                 // En caso de que exista el usuario en el servidor llenara esta variable con el valor ddel id_cct.
    public static trdd_cct actual_final = null;          // Objeto de tipo trdd_ej_cct que contendra los datos del usuario logueado.
    public static String id_random_final = "";              // Variable que contiene el id_RANDOM
    DataBaseAppRed database;                                // Instancia de la base de datos utilizado para obtener el municipio de acuerdo a un objeto de tipo trdd_ej_cct.

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

        HttpResult =urlConnection.getResponseCode();
        responseHttp = respuestaServidor(urlConnection); // Se carga la respuesta del servidor
        Log.e("CODE",String.valueOf(HttpResult));
        if (HttpResult == 200)
          { // Si el Codigo de respuesta es 200 (Si existe el usuario) (TOP)
              //id_random_final = generarIdRandom();
              //actual_final = cargarRespuestaCCTLogin(responseHttp); Es la respuesta real del servidor
              String respuestaSimulada;
              if(id.equals("a"))
              {
                  respuestaSimulada = RESPUESTA_SIMULADA_A;
              }else{
                  respuestaSimulada = "";
              }
              cargarVersionYCctLogin(respuestaSimulada);
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
        Log.e("RESPONSE",sb.toString());
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
        actual_final = new trdd_cct(id_cct,nombre,domicilio,email,id_municipio,id_nivel_educativo);

        JSONObject tmunicipio = respuestaLogin.getJSONObject(TABLE_NAME_TMUNICIPIO);
        int id_municipio2 = tmunicipio.getInt("id_municipio");
        String nombre2 = tmunicipio.getString("nombre");

        JSONObject tmunicipio3 = respuestaLogin.getJSONObject(TABLE_NAME_TMUNICIPIO_CIUDADANOMETRO);
        int id_municipio3 = tmunicipio3.getInt("id_municipio");
        String nombre33 = tmunicipio3.getString("nombre");

        JSONObject trdd_nivel_educativo = respuestaLogin.getJSONObject(TABLE_NAME_NIVEL_EDUCATIVO);
        int id_nivel_educativo3 = trdd_nivel_educativo.getInt("id_nivel_educativo");
        String nombre3 = trdd_nivel_educativo.getString("nombre");

        JSONObject trdd_nivel_educativo2 = respuestaLogin.getJSONObject(TABLE_NAME_NIVEL_EDUCATIVO_CIUDADANOMETRO);
        int id_nivel_educativo34 = trdd_nivel_educativo2.getInt("id_nivel_educativo");
        String nombre34 = trdd_nivel_educativo2.getString("nombre");


        ds.insertCctActual(actual_final);
        ds.insertMunicipioActual(new trdd_ej_municipio(id_municipio2,nombre2),new trdd_c_municipio(id_municipio3,nombre33));
        ds.insertNivelEducativoActual(new trdd_ej_nivel_educativo(id_nivel_educativo3,nombre3) , new trdd_c_nivel_educativo(id_nivel_educativo34,nombre34) );
        id_cct_final = actual_final.getId_cct();;

        JSONArray trdd_tipo_de_sistema = respuestaLogin.getJSONArray(TABLE_NAME_TIPOSISTEMA);
        ds.deleteTipodeTabla();
        for (int i = 0; i < trdd_tipo_de_sistema.length();i++)
        {
            JSONObject tabla2 = trdd_tipo_de_sistema.getJSONObject(i);
            int id_sistema_apk = tabla2.getInt("id_sistema_apk");
            String nombre334 = tabla2.getString("nombre");
            ds.inserttipodetabla(new trdd_tipo_sistema_apk(id_sistema_apk,nombre334));
        }

        //Aqui se revisa si la tabla de parametros esta vacia de ser asi la llena con las versiones del servidor
        // y le pide al servidor todas las tablas, de no estar vacias revisara cada version de tabla del servidor con la version local.
        Cursor tablaDeParametros = ds.isVersionVacia();
        JSONArray trdd_parametros_version = respuestaLogin.getJSONArray(TABLE_NAME_PARAMETROS);

        JSONArray porPedir = new JSONArray();
        if (tablaDeParametros.getCount() > 0)
        {
            for(int j = 0 ; j < trdd_parametros_version.length() ; j++)
            {
                JSONObject tabla = trdd_parametros_version.getJSONObject(j);
                Cursor tablaVersion = ds.getVersionPorTabla(tabla.getString("tabla"));
                tablaVersion.moveToNext();
                if(tabla.getInt("version") != tablaVersion.getInt(2))
                {
                    porPedir.put(tabla);
                }

            }
            if(porPedir.length() > 0)
            {
                JSONObject parametrosPeticionOBJ = new JSONObject();
                parametrosPeticionOBJ.put(TABLE_NAME_PARAMETROS, porPedir);
                Log.e("JSON DE PETICION: ",parametrosPeticionOBJ.toString());
                // TODO HACER LA PETICION CON ESTE JSON para pedir las tablas modificadas
            }
        }
        else
        {

            for (int i = 0; i < trdd_parametros_version.length();i++)
            {
                JSONObject tabla = trdd_parametros_version.getJSONObject(i);
                int id_sistema = tabla.getInt("id_sistema_apk");
                String tablan = tabla.getString("id_tabla");
                int version = tabla.getInt("version");
                porPedir.put(tabla);
                ds.insertVersiondeTabla(new trdd_version_tabla(id_sistema,tablan,version));
            }

            JSONObject parametrosPeticionOBJ = new JSONObject();
            parametrosPeticionOBJ.put(TABLE_NAME_PARAMETROS, porPedir);
            Log.e("JSON DE PETICION: ",parametrosPeticionOBJ.toString());
            //TODO Solicitar todas las tablas.
            new DataBaseFillAndUpdate(RESPUESTA_SIMULADA_VERSIONES, contextActual);

        }
    }


    public String generarIdRandom(){
        String auxiliar = null;
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        for (int i = 0 ; i < 8 ; i++)
        {
            int intAletorio = rnd.nextInt(9);
            auxiliar = auxiliar + String.valueOf(intAletorio);
        }
        return auxiliar;
    }
}
