package mx.org.ieem.RESTful;


import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;

import mx.org.ieem.RESTful.JSONModels.UsuarioJM;
import mx.org.ieem.data.sqllite.DataBaseAppRed;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_ej_anio_mes;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_ej_estatus_respuesta;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_ej_mes;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_ej_municipio;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_ej_anio;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_ej_cct;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_ej_nied_gres;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_ej_nivedu_ind;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_ej_nivel_educativo;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_ej_pregunta;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_ej_grado_escolar;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_ej_indicador;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_ej_pregunta_respuesta;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_parametros_version;

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


import static mx.org.ieem.data.sqllite.constants.encuestasj.constantesEncuestas.*;


public class AsyncLogin extends AsyncTask<String, Void, Boolean> {

    private String stringEmail;                             // Guarda el valor de el email proporcionado por el usuario.
    private String stringContrasenia;                       // Guarda el valor de la contrasenia proporcionada por el usario.
    public static boolean bolLogeado = false;               // Nos dice si el usaurio sigue logueado o no.
    public static Context contextActual;                    // Contexto del activity que ejecuto la tarea en segundo plano (LoginActivity).
    public static String id_cct_final = "";                 // En caso de que exista el usuario en el servidor llenara esta variable con el valor ddel id_cct.
    public static trdd_ej_cct actual_final = null;          // Objeto de tipo trdd_ej_cct que contendra los datos del usuario logueado.
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

        JSONObject trdd_cct = respuestaLogin.getJSONObject(TABLE_NAME_CCT);
        String id_cct = trdd_cct.getString("id_cct");
        String nombre = trdd_cct.getString("nombre");
        String domicilio = trdd_cct.getString("domicilio");
        String email = trdd_cct.getString("email");
        int id_municipio = trdd_cct.getInt("id_municipio");
        int id_nivel_educativo = trdd_cct.getInt("id_nivel_educativo");
        actual_final = new trdd_ej_cct(id_cct,nombre,domicilio,email,id_municipio,id_nivel_educativo);

        JSONObject tmunicipio = respuestaLogin.getJSONObject(TABLE_NAME_TMUNICIPIO);
        int id_municipio2 = tmunicipio.getInt("id_municipio");
        String nombre2 = tmunicipio.getString("nombre");

        JSONObject trdd_nivel_educativo = respuestaLogin.getJSONObject(TABLE_NAME_NIVEL_EDUCATIVO);
        int id_nivel_educativo3 = trdd_nivel_educativo.getInt("id_nivel_educativo");
        String nombre3 = trdd_nivel_educativo.getString("nombre");


        ds.insertCctActual(actual_final);
        ds.insertMunicipioActual(new trdd_ej_municipio(id_municipio2,nombre2));
        ds.insertNivelEducativoActual(new trdd_ej_nivel_educativo(id_nivel_educativo3,nombre3 ));
        id_cct_final = actual_final.getId_cct();;

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
                int id_parametros = tabla.getInt("id_parametros");
                String tablan = tabla.getString("tabla");
                int version = tabla.getInt("version");
                porPedir.put(tabla);
                ds.insertVersiondeTabla(new trdd_parametros_version(id_parametros,tablan,version));
            }

            JSONObject parametrosPeticionOBJ = new JSONObject();
            parametrosPeticionOBJ.put(TABLE_NAME_PARAMETROS, porPedir);
            Log.e("JSON DE PETICION: ",parametrosPeticionOBJ.toString());
            //TODO Solicitar todas las tablas.
            cargarRespuestaVersiones(RESPUESTA_SIMULADA_VERSIONES);



        }
    }


    public void cargarRespuestaVersiones(String response) throws JSONException
    {
        DataBaseAppRed ds = new DataBaseAppRed(contextActual);                //Instancia de la base de datos.

        JSONObject respuestaVersiones = new JSONObject(response);

        if (respuestaVersiones.has(TABLE_NAME_ANIOS))
          {
              ds.deleteAnios();
              JSONArray trdd_anio = respuestaVersiones.getJSONArray(TABLE_NAME_ANIOS);
              for (int i = 0 ; i< trdd_anio.length();i++)
              {
                  JSONObject anio = trdd_anio.getJSONObject(i);
                  String id_anio = anio.getString("id_anio");
                  ds.insertAnios(new trdd_ej_anio(id_anio));
              }
          }

        if (respuestaVersiones.has(TABLE_NAME_MES))
        {
            ds.deleteMeses();
            JSONArray trdd_anio = respuestaVersiones.getJSONArray(TABLE_NAME_MES);
            for (int i = 0 ; i< trdd_anio.length();i++)
            {
                JSONObject mes = trdd_anio.getJSONObject(i);
                int id_mes = mes.getInt("id_mes");
                String nombre = mes.getString("nombre");
                ds.insertMeses(new trdd_ej_mes(id_mes,nombre));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_MES_ANIO))
        {
            ds.deleteAniosMeses();
            JSONArray trdd_anio = respuestaVersiones.getJSONArray(TABLE_NAME_MES_ANIO);
            for (int i = 0 ; i< trdd_anio.length();i++)
            {
                JSONObject anioMes = trdd_anio.getJSONObject(i);
                String id_anio = anioMes.getString("id_anio");
                int id_mes = anioMes.getInt("id_mes");
                ds.insertAniosMeses(new trdd_ej_anio_mes(id_anio,id_mes));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_GRADO_ESCOLAR))
        {
            ds.deleteGradoEscolar();
            JSONArray trdd_anio = respuestaVersiones.getJSONArray(TABLE_NAME_GRADO_ESCOLAR);
            for (int i = 0 ; i < trdd_anio.length() ; i++)
            {
                JSONObject gradoEscolar = trdd_anio.getJSONObject(i);
                int id_grado_escolar = gradoEscolar.getInt("id_grado_escolar");
                String nombre = gradoEscolar.getString("nombre");
                String siglas = gradoEscolar.getString("siglas");
                String grado = gradoEscolar.getString("grado");
                ds.insertGradoEscolar(new trdd_ej_grado_escolar(id_grado_escolar,nombre,siglas,grado));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_NIED_GRES))
        {
            ds.deleteNiedGres();
            JSONArray trdd_nied_gres = respuestaVersiones.getJSONArray(TABLE_NAME_NIED_GRES);
            for (int i = 0 ; i< trdd_nied_gres.length();i++)
            {
                JSONObject niedGres = trdd_nied_gres.getJSONObject(i);
                int id_nivel_educativo = niedGres.getInt("id_nivel_educativo");
                int id_grado_escolar = niedGres.getInt("id_grado_escolar");
                ds.insertNiedGres(new trdd_ej_nied_gres(id_nivel_educativo,id_grado_escolar));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_INDICADOR))
        {
            ds.deleteIndicador();
            JSONArray trdd_indicador = respuestaVersiones.getJSONArray(TABLE_NAME_INDICADOR);
            for (int i = 0 ; i< trdd_indicador.length();i++)
            {
                JSONObject indicador = trdd_indicador.getJSONObject(i);
                int id_nivel_educativo = indicador.getInt("id_indicador");
                String nombre = indicador.getString("nombre");
                ds.insertIndicador(new trdd_ej_indicador(id_nivel_educativo,nombre));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_NIV_IND))
        {
            ds.deleteNivEduIndicador();
            JSONArray trdd_nivedu_ind = respuestaVersiones.getJSONArray(TABLE_NAME_NIV_IND);
            for (int i = 0 ; i< trdd_nivedu_ind.length();i++)
            {
                JSONObject indicador = trdd_nivedu_ind.getJSONObject(i);
                int id_nivel_educativo = indicador.getInt("id_nivel_educativo");
                int id_indicador = indicador.getInt("id_indicador");
                ds.insertNivelIndicador(new trdd_ej_nivedu_ind(id_nivel_educativo,id_indicador));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_PREGUNTA))
        {
            ds.deletePreguntas();
            JSONArray trdd_pregunta = respuestaVersiones.getJSONArray(TABLE_NAME_PREGUNTA);
            for (int i = 0 ; i< trdd_pregunta.length();i++)
            {
                JSONObject pregunta = trdd_pregunta.getJSONObject(i);
                String id_anio = pregunta.getString("id_anio");
                int id_mes = pregunta.getInt("id_mes");
                int id_nivel_educativo = pregunta.getInt("id_nivel_educativo");
                int id_indicador = pregunta.getInt("id_indicador");
                String preguntaC = pregunta.getString("pregunta");
                ds.insertPregunta(new trdd_ej_pregunta(id_anio,id_mes,id_nivel_educativo,id_indicador,preguntaC));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_ESTATUS_RESPUESTA))
        {
            ds.deleteEstatusRespuesta();
            JSONArray trdd_estatus_respuesta = respuestaVersiones.getJSONArray(TABLE_NAME_ESTATUS_RESPUESTA);
            for (int i = 0 ; i< trdd_estatus_respuesta.length();i++)
            {
                JSONObject indicador = trdd_estatus_respuesta.getJSONObject(i);
                int id_estatus_respuesta = indicador.getInt("id_estatus_respuesta");
                String nombre = indicador.getString("nombre");
                ds.insertEstatusRespuesta(new trdd_ej_estatus_respuesta(id_estatus_respuesta,nombre));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_PREGUNTA_RESPUESTA))
        {
            ds.deletePreguntaRespuesta();
            JSONArray trdd_pregunta_respuesta = respuestaVersiones.getJSONArray(TABLE_NAME_PREGUNTA_RESPUESTA);
            for (int i = 0 ; i< trdd_pregunta_respuesta.length();i++)
            {
                JSONObject preguntaRespuesta = trdd_pregunta_respuesta.getJSONObject(i);
                String id_anio = preguntaRespuesta.getString("id_anio");
                int id_mes = preguntaRespuesta.getInt("id_mes");
                int id_nivel_educativo = preguntaRespuesta.getInt("id_nivel_educativo");
                int id_indicador = preguntaRespuesta.getInt("id_indicador");
                int id_respuesta = preguntaRespuesta.getInt("id_respuesta");
                int id_estatus_respuesta = preguntaRespuesta.getInt("id_estatus_respuesta");
                String respuesta = preguntaRespuesta.getString("respuesta");
                ds.insertPreguntaRespuesta(new trdd_ej_pregunta_respuesta(id_anio,id_mes,id_nivel_educativo,id_indicador,id_respuesta,id_estatus_respuesta,respuesta));
            }
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
