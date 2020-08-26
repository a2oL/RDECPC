package mx.org.ieem.RESTful;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import mx.org.ieem.RESTful.JSONModels.UsuarioJM;
import mx.org.ieem.data.sqllite.DataBaseAppRed;

public class AsyncLoadPage extends AsyncTask<Integer, Integer, String>
{
    private ProgressBar progressBar;
    private TextView txt;
    private int count;
    private Button btn;
    private String enviadode;
    DataBaseAppRed database;
    Context contextActual;

    public AsyncLoadPage(Context context, ProgressBar progressBar, TextView txt, int count, Button btn, String enviadode) throws JSONException, IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        this.progressBar = progressBar;
        this.txt = txt;
        this.count = count;
        this.btn = btn;
        this.enviadode = enviadode;
        this.contextActual = context;
        database = new DataBaseAppRed(context);
        if (enviadode.equals("1")){
            // TODO Cambiar la url para la insercion por metodo post.
            Log.e("JSON ENVIAR ENCUESTAS",getEncuestasJuveniles());


        }else{
            Log.e("JSON ENVIAR CIUDADANO","AQUI VA");
        }

    }

    @Override
    protected String doInBackground(Integer... params)
    {
        if(enviadode.equals("1"))
        {
            //Url de insercion de encuestas juveniles
            try {
                sendPost(new URL("https://registro.ieem.org.mx:8443/redDigitalDpc/encuesta-juvenil/encuestas"),getEncuestasJuveniles());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CertificateException e) {
                e.printStackTrace();
            } catch (KeyStoreException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            for (; count <= params[0]; count++)
            {
                try {
                    Thread.sleep(1000);
                    publishProgress(count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            //Url de insercion de ciudadanometros
            for (; count <= params[0]; count++) {
                try {
                    Thread.sleep(1000);
                    publishProgress(count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return "Task Completed.";
    }
    @Override
    protected void onPostExecute(String result) {
        progressBar.setVisibility(View.GONE);
        btn.setVisibility(View.VISIBLE);
    }
    @Override
    protected void onPreExecute() {
        txt.setText("Task Starting...");
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        txt.setText("Enviando..."+ values[0]);
        progressBar.setProgress(values[0]);
    }

    public String getEncuestasJuveniles() throws JSONException {
        Cursor encuestas = database.getEncuestasJuvenilesBD();
        int idcctColumn = encuestas.getColumnIndex("id_cct");
        int idrandomColumn = encuestas.getColumnIndex("id_random");
        int idencuestaColumn = encuestas.getColumnIndex("id_encuesta");
        int idniveleducativoColumn = encuestas.getColumnIndex("id_nivel_educativo");
        int idgradoescolarColumn = encuestas.getColumnIndex("id_grado_escolar");

        encuestas.moveToNext();
        JSONArray insercionsatos = new JSONArray();
        for(encuestas.moveToFirst(); !encuestas.isAfterLast(); encuestas.moveToNext())
        {
            JSONObject encuestaRealizada = new JSONObject();
            String id_cct = encuestas.getString(idcctColumn);
            String id_random = encuestas.getString(idrandomColumn);
            int id_encuesta = encuestas.getInt(idencuestaColumn);
            int id_nivel_educativo = encuestas.getInt(idniveleducativoColumn);
            int id_grado_escolar = encuestas.getInt(idgradoescolarColumn);
            JSONArray id_encuesta_array = getDetalleEncuesta(encuestas.getInt(idencuestaColumn));
            encuestaRealizada.put("id_cct",id_cct);
            encuestaRealizada.put("id_random",id_random);
            encuestaRealizada.put("id_encuesta",id_encuesta);
            encuestaRealizada.put("id_nivel_educativo",id_nivel_educativo);
            encuestaRealizada.put("id_grado_escolar",id_grado_escolar);
            encuestaRealizada.put("detallesEncuesta",id_encuesta_array);
            insercionsatos.put(encuestaRealizada);
        }
        return insercionsatos.toString();
    }

    public JSONArray getDetalleEncuesta(int id_encuestas) throws JSONException
    {
        Cursor detalleencuestas = database.getDetallesEncuestasBD(id_encuestas);
        int idcctColumn = detalleencuestas.getColumnIndex("id_cct");
        int idrandomColumn = detalleencuestas.getColumnIndex("id_random");
        int idencuestaColumn = detalleencuestas.getColumnIndex("id_encuesta");
        int idanioColumn = detalleencuestas.getColumnIndex("id_anio");
        int idmesColumn = detalleencuestas.getColumnIndex("id_mes");
        int idniveleducativoColumn = detalleencuestas.getColumnIndex("id_nivel_educativo");
        int idgradoescolarColumn = detalleencuestas.getColumnIndex("id_grado_escolar");
        int idindicadorColumn = detalleencuestas.getColumnIndex("id_indicador");
        int idrespuestaColumn = detalleencuestas.getColumnIndex("id_respuesta");
        int idestatusrespuestaColumn = detalleencuestas.getColumnIndex("id_estatus_respuesta");

        JSONArray detallesDeEncuesta = new JSONArray();

        for(detalleencuestas.moveToFirst(); !detalleencuestas.isAfterLast(); detalleencuestas.moveToNext())
        {
            JSONObject detalleEncuesta = new JSONObject();
            String id_cct = detalleencuestas.getString(idcctColumn);
            String id_random = detalleencuestas.getString(idrandomColumn);
            int id_encuesta = detalleencuestas.getInt(idencuestaColumn);
            String id_anio = detalleencuestas.getString(idanioColumn);
            int id_mes = detalleencuestas.getInt(idmesColumn);
            int id_nivel_educativo = detalleencuestas.getInt(idniveleducativoColumn);
            int id_grado_escolar = detalleencuestas.getInt(idgradoescolarColumn);
            int id_indicador = detalleencuestas.getInt(idindicadorColumn);
            int id_respuesta = detalleencuestas.getInt(idrespuestaColumn);
            int id_estatus_respuesta = detalleencuestas.getInt(idestatusrespuestaColumn);
            detalleEncuesta.put("id_cct",id_cct);
            detalleEncuesta.put("id_random",id_random);
            detalleEncuesta.put("id_encuesta",id_encuesta);
            detalleEncuesta.put("id_anio",id_anio);
            detalleEncuesta.put("id_mes",id_mes);
            detalleEncuesta.put("id_nivel_educativo",id_nivel_educativo);
            detalleEncuesta.put("id_indicador",id_indicador);
            detalleEncuesta.put("id_respuesta",id_respuesta);
            detalleEncuesta.put("id_estatus_respuesta",id_estatus_respuesta);
            detallesDeEncuesta.put(detalleEncuesta);
        }
        return detallesDeEncuesta;
    }

    public void sendPost(URL url, String post) throws IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException, JSONException { // Metodo sendPOST() (TOP)

        CertificateFactory cf = CertificateFactory.getInstance("X.509");                            // Se emplea para generar certificados.
        InputStream caInput = contextActual.getAssets().open("load-der.crt");              // Aloja el certificado que se encuentra dentro de el directorio Assets.
        Certificate ca;                                                                             // Certificado creado a partir de load-der.crt.
        OutputStreamWriter out;                                                                     // Datos que seran enviados por metodo POST.
        int HttpResult;                                                                             // Contiene el codigo de respuesta del servidor.
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
        out.write(post);
        out.close();
        // POST
        // RESPONSE

        HttpResult =urlConnection.getResponseCode();
        Log.e("CODE",String.valueOf(HttpResult));
        if (HttpResult == 200)
        { // Si los datos fueron insertados correctamente (TOP)

        } // Si los datos fueron insertados correctamente (TOP)
        // RESPONSE
    } // Metodo sendPOST() (BOTTOM)
}
