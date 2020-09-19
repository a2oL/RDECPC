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
import mx.org.ieem.activity.reportes.ReportesActivity;
import mx.org.ieem.data.sqllite.DataBaseAppRed;
import mx.org.ieem.data.sqllite.models.reportes.trdd_reporte;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsyncReportes extends AsyncTask<String, Void, Boolean> {

    private Activity activity;
    private Context context;
    private int reportesDe;
    DataBaseAppRed bd;
    Intent intentReportes;
    public static ArrayList<trdd_reporte> reportesaMostrar = new ArrayList<trdd_reporte>();
    private boolean hayReportes = false;

    public AsyncReportes(Activity activity, Context context, int reportesDe) {
        this.activity = activity;
        this.context = context;
        this.reportesDe = reportesDe;
        bd = new DataBaseAppRed(context);
        intentReportes = new Intent(context, ReportesActivity.class);
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        if(reportesDe == 1) {
            APIService apiService = null;
            try {
                apiService = RetrofitClient.getClient(context).create(APIService.class);
                getReportesEncuestasServidor(apiService);
                Thread.sleep(5000); // Tiempo que esperara la conexion
                return true;
            } catch (CertificateException | IOException | KeyStoreException | NoSuchAlgorithmException | KeyManagementException | InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }
        else{
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if(aBoolean)
        {
            activity.startActivity(intentReportes);
            if(hayReportes)
            {
                Toast.makeText(context, "Mostrando reportes del servidor", Toast.LENGTH_LONG).show();
            }else
            {
                Toast.makeText(context, "Sin respuesta del servidor", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void getReportesEncuestasServidor(APIService apiService)
    {
        final ArrayList<trdd_reporte>[] reportesdelServidor = new ArrayList[]{new ArrayList<trdd_reporte>()};
        Call<List<trdd_reporte>> call = null;
        call = apiService.getReportesEncuestas();
        call.enqueue(new Callback<List<trdd_reporte>>() {
            @Override
            public void onResponse(Call<List<trdd_reporte>> call, Response<List<trdd_reporte>> response) {
                reportesdelServidor[0] = (ArrayList<trdd_reporte>) response.body();
                insertarReportesBD(reportesdelServidor[0]);
                reportesaMostrar = bd.cargarReportesBDR(reportesDe);
                //Toast.makeText(context, "Mostrando reportes del servidor: "+reportesaMostrar.get(0).getDescripcion(), Toast.LENGTH_LONG).show();
                hayReportes = true;
            }
            @Override
            public void onFailure(Call<List<trdd_reporte>> call, Throwable t) {
                reportesaMostrar = bd.cargarReportesBDR(reportesDe);
                hayReportes = false;
            }
        });
    }

    public void insertarReportesBD(ArrayList<trdd_reporte> eventosServicioBD)
    {
        bd.deleteReportes(reportesDe);
        for(int nEvento = 0 ; nEvento < eventosServicioBD.size() ; nEvento++)
        {
            trdd_reporte eventoNube = eventosServicioBD.get(nEvento);
            bd.insertReporte(eventoNube);
        }
    }
}
