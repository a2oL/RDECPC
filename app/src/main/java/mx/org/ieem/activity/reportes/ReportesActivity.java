package mx.org.ieem.activity.reportes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.R;
import mx.org.ieem.activity.main.MainActivity;
import mx.org.ieem.activity.main.SelectActivity;
import mx.org.ieem.adapters.EventosAdapter;
import mx.org.ieem.adapters.ReportesAdapter;

import static mx.org.ieem.RESTful.AsyncEventosConcursos.eventosServidor;

import static mx.org.ieem.RESTful.AsyncReportes.reportesaMostrar;

public class ReportesActivity extends AppCompatActivity
{
    ReportesAdapter customAdapter;
    ListView listReportes;
    Button atras;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);

        atras = (Button) findViewById(R.id.button_regresar_reportes);

        customAdapter = new ReportesAdapter(this);
        listReportes = (ListView)findViewById(R.id.listView_reportes);
        listReportes.setAdapter(customAdapter);

        listReportes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (reportesaMostrar.get(position).getId_estatus_reporte() == 2)
                {
                    Toast.makeText(getApplicationContext(), "El reporte deseado ha expirado intenta con otro", Toast.LENGTH_LONG).show();
                }else
                {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(reportesaMostrar.get(position).getUrl()));
                    startActivity(browserIntent);
                }
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent =  new Intent(v.getContext(), SelectActivity.class);
                startActivity(browserIntent);
            }
        });
    }
}
