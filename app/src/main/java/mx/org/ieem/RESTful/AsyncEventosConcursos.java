package mx.org.ieem.RESTful;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;

import mx.org.ieem.RESTful.Retrofit.RetrofitClient.RetrofitClient;
import mx.org.ieem.RESTful.Retrofit.interfaces.APIService;
import mx.org.ieem.activity.eventos.EventosActivity;
import mx.org.ieem.data.sqllite.DataBaseAppRed;
import mx.org.ieem.data.sqllite.models.eventos.trdd_concurso_o_evento;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsyncEventosConcursos extends AsyncTask<String, Void, Boolean>
{
    public static ArrayList<trdd_concurso_o_evento> eventosServidor = new ArrayList<trdd_concurso_o_evento>();
    private Activity activity;
    private Context context;
    DataBaseAppRed bd;
    Intent intentEventos;
    boolean hayEventos = false;

    public AsyncEventosConcursos(Context context, Activity activity){
        this.context = context;
        this.activity = activity;
        bd = new DataBaseAppRed(context);
        intentEventos = new Intent(context, EventosActivity.class);
    }

    @Override
    protected Boolean doInBackground(String... strings)
    {
        APIService apiService = null;
        try {
            apiService = RetrofitClient.getClient(context).create(APIService.class);
            getEventosServidor(apiService);
            Thread.sleep(5000); // Tiempo que esperara la conexion
            return true;
        } catch (CertificateException | IOException | KeyStoreException | NoSuchAlgorithmException | KeyManagementException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean)
    {
        if(aBoolean)
        {
            activity.startActivity(intentEventos);
            if(hayEventos)
            {
                Toast.makeText(context, "Mostrando eventos del servidor", Toast.LENGTH_LONG).show();
            }else
            {
                Toast.makeText(context, "Sin respuesta del servidor", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void getEventosServidor(APIService apiService)
    {
        final ArrayList<trdd_concurso_o_evento>[] eventosdelServidor = new ArrayList[]{new ArrayList<trdd_concurso_o_evento>()};
        Call<List<trdd_concurso_o_evento>> call = null;
        call = apiService.getEventos();
        call.enqueue(new Callback<List<trdd_concurso_o_evento>>() {
            @Override
            public void onResponse(Call<List<trdd_concurso_o_evento>> call, Response<List<trdd_concurso_o_evento>> response) {
                eventosdelServidor[0] = (ArrayList<trdd_concurso_o_evento>) response.body();
                revisarBDEventos(eventosdelServidor[0]);
                eventosServidor = bd.cargarEventosConcursosBDR();
                hayEventos = true;
            }
            @Override
            public void onFailure(Call<List<trdd_concurso_o_evento>> call, Throwable t) {
                eventosServidor = bd.cargarEventosConcursosBDR();
                hayEventos = false;
            }
        });
    }

    public void revisarBDEventos(ArrayList<trdd_concurso_o_evento> eventosServicioBD)
    {
        bd.deleteEventos();
        for(int nEvento = 0 ; nEvento < eventosServicioBD.size() ; nEvento++)
        {
            trdd_concurso_o_evento eventoNube = eventosServicioBD.get(nEvento);
            bd.insertEvento(eventoNube);
        }
    }

}
