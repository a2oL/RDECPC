package mx.org.ieem.RESTful;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;

import mx.org.ieem.RESTful.JSONModels.PostCiudadanometro.Ciudadanometro;
import mx.org.ieem.RESTful.JSONModels.PostCiudadanometro.DetallesEncuestaC;
import mx.org.ieem.RESTful.JSONModels.PostEncuestas.DetallesEncuestum;
import mx.org.ieem.RESTful.JSONModels.PostEncuestas.EncuestasJuvenile;
import mx.org.ieem.RESTful.Retrofit.RetrofitClient.RetrofitClient;
import mx.org.ieem.RESTful.Retrofit.interfaces.APIService;
import mx.org.ieem.data.sqllite.DataBaseAppRed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsyncLoadPage extends AsyncTask<Integer, Integer, String>
{

    // No se documento de igual manera porque no se si este sera el aspecto final de la manera en la que se mandan las encuestas a organo central

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
    }

    @Override
    protected String doInBackground(Integer... params)
    {
        APIService apiService = null;
        try {
            apiService = RetrofitClient.getClient(contextActual).create(APIService.class);
        } catch (CertificateException | IOException | KeyStoreException | NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
        if(enviadode.equals("1"))
        {
            sendEncuestas(apiService);
           // new Handler(Looper.getMainLooper()).post(new Runnable() {
         //       @Override
        //        public void run() {
        //            Log.e("UI thread", getEncuestasJuveniles().toString());
          //      }
       //     });
            animacionRetraso(params[0]);
        }else{
            sendCiudadanometros(apiService);
            //Corre en el hilo de ui para poder ver el logcat
            /*new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Log.e("UI thread", getCiudadanometros().toString());
                }
            });*/
            animacionRetraso(params[0]);
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

    public void animacionRetraso(int contadorRetraso){
        for (; count <= contadorRetraso; count++)
        {
            try {
                Thread.sleep(1000);
                publishProgress(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendEncuestas(APIService apiService){
        Call<List<EncuestasJuvenile>> call = null;
        call = apiService.insertEncuestas(getEncuestasJuveniles());
        call.enqueue(new Callback<List<EncuestasJuvenile>>() {
            @Override
            public void onResponse(Call<List<EncuestasJuvenile>> call, Response<List<EncuestasJuvenile>> response) {
                Toast.makeText(contextActual, "Codigo de respuesta Encuestas Juveniles:"+response.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<EncuestasJuvenile>> call, Throwable t) {
                Toast.makeText(contextActual, "Respuesta Negativa Encuestas Juveniles:"+t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void sendCiudadanometros(APIService apiService){
        Call<List<Ciudadanometro>> call = null;
        call = apiService.insertCiudadanometros(getCiudadanometros());
        call.enqueue(new Callback<List<Ciudadanometro>>() {
            @Override
            public void onResponse(Call<List<Ciudadanometro>> call, Response<List<Ciudadanometro>> response) {
                Toast.makeText(contextActual, "Codigo de respuesta Ciudadanometro:"+response.code(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Ciudadanometro>> call, Throwable t) {
                Toast.makeText(contextActual, "Respuesta de respuesta Ciudadanometro:"+t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public List<EncuestasJuvenile> getEncuestasJuveniles()
    {
        Cursor encuestas = database.getEncuestasJuvenilesBD();
        List<EncuestasJuvenile> encuestasRealizadas = new ArrayList<EncuestasJuvenile>();
        int idcctColumn = encuestas.getColumnIndex("id_cct");
        int idrandomColumn = encuestas.getColumnIndex("id_random");
        int idencuestaColumn = encuestas.getColumnIndex("id_encuesta");
        int idniveleducativoColumn = encuestas.getColumnIndex("id_nivel_educativo");
        int idgradoescolarColumn = encuestas.getColumnIndex("id_grado_escolar");

        for(encuestas.moveToFirst(); !encuestas.isAfterLast(); encuestas.moveToNext())
        {
            String id_cct = encuestas.getString(idcctColumn);
            String id_random = encuestas.getString(idrandomColumn);
            int id_encuesta = encuestas.getInt(idencuestaColumn);
            int id_nivel_educativo = encuestas.getInt(idniveleducativoColumn);
            int id_grado_escolar = encuestas.getInt(idgradoescolarColumn);
            List<DetallesEncuestum> id_encuesta_array = getDetalleEncuesta(encuestas.getInt(idencuestaColumn));
            EncuestasJuvenile encuestaJuvenil = new EncuestasJuvenile(id_cct,id_random,id_encuesta,id_nivel_educativo,id_grado_escolar,id_encuesta_array);
            encuestasRealizadas.add(encuestaJuvenil);
        }
        return encuestasRealizadas;
    }

    public List<DetallesEncuestum> getDetalleEncuesta(int id_encuestas)
    {
        Cursor detalleencuestas = database.getDetallesEncuestasBD(id_encuestas);
        List<DetallesEncuestum> detallesDeEncuesta = new ArrayList<DetallesEncuestum>();
        int idcctColumn = detalleencuestas.getColumnIndex("id_cct");
        int idrandomColumn = detalleencuestas.getColumnIndex("id_random");
        int idencuestaColumn = detalleencuestas.getColumnIndex("id_encuesta");
        int idanioColumn = detalleencuestas.getColumnIndex("id_anio");
        int idmesColumn = detalleencuestas.getColumnIndex("id_mes");
        int idniveleducativoColumn = detalleencuestas.getColumnIndex("id_nivel_educativo");
        int idindicadorColumn = detalleencuestas.getColumnIndex("id_indicador");
        int idrespuestaColumn = detalleencuestas.getColumnIndex("id_respuesta");
        int idestatusrespuestaColumn = detalleencuestas.getColumnIndex("id_estatus_respuesta");

        for(detalleencuestas.moveToFirst(); !detalleencuestas.isAfterLast(); detalleencuestas.moveToNext())
        {
            String id_cct = detalleencuestas.getString(idcctColumn);
            String id_random = detalleencuestas.getString(idrandomColumn);
            int id_encuesta = detalleencuestas.getInt(idencuestaColumn);
            String id_anio = detalleencuestas.getString(idanioColumn);
            int id_mes = detalleencuestas.getInt(idmesColumn);
            int id_nivel_educativo = detalleencuestas.getInt(idniveleducativoColumn);
            int id_indicador = detalleencuestas.getInt(idindicadorColumn);
            int id_respuesta = detalleencuestas.getInt(idrespuestaColumn);
            int id_estatus_respuesta = detalleencuestas.getInt(idestatusrespuestaColumn);
            DetallesEncuestum detallePorEncuesta = new DetallesEncuestum(id_cct,id_random,id_encuesta,id_anio,id_mes,id_nivel_educativo,id_indicador,id_respuesta,id_estatus_respuesta);
            detallesDeEncuesta.add(detallePorEncuesta);
        }
        return detallesDeEncuesta;
    }

    public List<Ciudadanometro> getCiudadanometros()
    {
        Cursor ciudadanometros = database.getCiudadanometrosBD();
        List<Ciudadanometro> ciudadanometrosRealizados = new ArrayList<Ciudadanometro>();
        int idcctColumn = ciudadanometros.getColumnIndex("id_cct");
        int idrandomColumn = ciudadanometros.getColumnIndex("id_random");
        int idencuestaColumn = ciudadanometros.getColumnIndex("id_encuesta");
        int idrealizadorColumn = ciudadanometros.getColumnIndex("id_realizador");
        int idrealizadoredadColumn = ciudadanometros.getColumnIndex("id_realizador_edad");
        int idrealizadorescolaridad = ciudadanometros.getColumnIndex("id_realizador_escolaridad");
        int idrealizadorgenero = ciudadanometros.getColumnIndex("id_realizador_genero");
        int idrealizadorgradesc = ciudadanometros.getColumnIndex("id_realizador_grad_esc");
        int idrealizadornivedu = ciudadanometros.getColumnIndex("id_realizador_niv_edu");

        for(ciudadanometros.moveToFirst(); !ciudadanometros.isAfterLast(); ciudadanometros.moveToNext())
        {
            String id_cct = ciudadanometros.getString(idcctColumn);
            String id_random = ciudadanometros.getString(idrandomColumn);
            int id_encuesta = ciudadanometros.getInt(idencuestaColumn);
            int id_realizador = ciudadanometros.getInt(idrealizadorColumn);
            int id_realizador_edad = ciudadanometros.getInt(idrealizadoredadColumn);
            int id_realizador_escolaridad = ciudadanometros.getInt(idrealizadorescolaridad);
            int id_realizador_genero = ciudadanometros.getInt(idrealizadorgenero);
            int id_realizador_grad_esc = ciudadanometros.getInt(idrealizadorgradesc);
            int id_realizador_niv_edu = ciudadanometros.getInt(idrealizadornivedu);
            List<DetallesEncuestaC> id_ciudadanometro_array = getDetalleCiudadanometro(ciudadanometros.getInt(idencuestaColumn));
            Ciudadanometro ciudadanometro = new Ciudadanometro(id_cct,id_random,id_encuesta,id_realizador,id_realizador_edad,id_realizador_escolaridad,id_realizador_genero,id_realizador_grad_esc,id_realizador_niv_edu,id_ciudadanometro_array);
            ciudadanometrosRealizados.add(ciudadanometro);
        }
        return ciudadanometrosRealizados;
    }

    public List<DetallesEncuestaC> getDetalleCiudadanometro(int id_encuestap)
    {
        Cursor detalleciudadanometro = database.getDetallesCiudadanometrosBD(id_encuestap);
        List<DetallesEncuestaC> detallesDeCiudadanometro = new ArrayList<DetallesEncuestaC>();
        int idcctColumn = detalleciudadanometro.getColumnIndex("id_cct");
        int idrandomColumn = detalleciudadanometro.getColumnIndex("id_random");
        int idencuestaColumn = detalleciudadanometro.getColumnIndex("id_encuesta");
        int idanioColumn = detalleciudadanometro.getColumnIndex("id_anio");
        int idpreguntaColumn = detalleciudadanometro.getColumnIndex("id_pregunta");
        int idrespuestaColumn = detalleciudadanometro.getColumnIndex("id_respuesta");
        int idestatusrespuestaColumn = detalleciudadanometro.getColumnIndex("id_estatus_respuesta");

        for(detalleciudadanometro.moveToFirst(); !detalleciudadanometro.isAfterLast(); detalleciudadanometro.moveToNext())
        {
            String id_cct = detalleciudadanometro.getString(idcctColumn);
            String id_random = detalleciudadanometro.getString(idrandomColumn);
            int id_encuesta = detalleciudadanometro.getInt(idencuestaColumn);
            String id_anio = detalleciudadanometro.getString(idanioColumn);
            String id_pregunta = detalleciudadanometro.getString(idpreguntaColumn);
            int id_respuesta = detalleciudadanometro.getInt(idrespuestaColumn);
            int id_estatus_respuesta = detalleciudadanometro.getInt(idestatusrespuestaColumn);
            DetallesEncuestaC detallePorCiudadanometro = new DetallesEncuestaC(id_cct,id_random,id_encuesta,id_anio,id_pregunta,id_respuesta,id_estatus_respuesta);
            detallesDeCiudadanometro.add(detallePorCiudadanometro);
        }
        return detallesDeCiudadanometro;
    }
}
