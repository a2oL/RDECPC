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
import mx.org.ieem.activity.ciudadanometro.CiudadanometroActivity;
import mx.org.ieem.activity.encuestas.EncuestasActivity;
import mx.org.ieem.adapters.ReportesAdapter;

import static mx.org.ieem.RESTful.AsyncReportes.reportesaMostrar;

public class ReportesActivity extends AppCompatActivity
{
    ReportesAdapter customAdapter;                                  // Adaptador de la lista que contendra los reportes
    ListView listReportes;                                          // Objeto de la UI que muestra en formato los eventos del servidor o la BD.
    Button atras;                                                   // Objeto de la UI que responde al click regresando a la pantalla donde fue llamado (EncuestasActivity o CiudadanometroActivity).
    int enviadode;                                                  // Almacena un valor ya se 1 o 2 que dice de donde fue llamado ReportesActivity.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);

        // Busqueda de los elementos de la UI. (TOP)
        atras = (Button) findViewById(R.id.button_regresar_reportes);
        listReportes = (ListView)findViewById(R.id.listView_reportes);
        // Busqueda de los elementos de la UI. (BOTTOM)
        Bundle parametros = this.getIntent().getExtras();           // Obtiene los parametros que fueron enviados junto con el Intent.

        // Inicializacion de variables. (TOP)
        customAdapter = new ReportesAdapter(this);
        listReportes.setAdapter(customAdapter);
        enviadode = parametros.getInt("enviadode");
        // Inicializacion de variables. (BOTTOM)

        // CLick Listener de la Lista de reportes y del boton atras. (TOP)
        listReportes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (reportesaMostrar.get(position).getId_estatus_reporte() == 2)
                  { // Si el reporte Clickeado tienen el estatus 2 (inactivo). (TOP)
                      Toast.makeText(getApplicationContext(), "El reporte deseado ha expirado intenta con otro", Toast.LENGTH_LONG).show();
                  } // Si el reporte Clickeado tienen el estatus 2 (inactivo). (BOTTOM)
                else
                  { // Si el reporte Clickeado Tiene el estatus 1 (Activo). (TOP)
                      Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(reportesaMostrar.get(position).getUrl()));
                      startActivity(browserIntent);
                  } // Si el reporte Clickeado Tiene el estatus 1 (Activo). (BOTTOM)
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enviadode == 1)
                  { // Si el Intent fue accionado desde 1 (ENCUESTAS). (TOP)
                      Intent browserIntent =  new Intent(v.getContext(), EncuestasActivity.class);
                      startActivity(browserIntent);
                  } // Si el Intent fue accionado desde 1 (ENCUESTAS). (BOTTOM)
                else
                  { // Si el Intent fue accionado desde 2 (Ciudadanometro). (TOP)
                      Intent browserIntent =  new Intent(v.getContext(), CiudadanometroActivity.class);
                      startActivity(browserIntent);
                  } // Si el Intent fue accionado desde 2 (Ciudadanometro). (BOTTOM)
            }
        });
        // CLick Listener de la Lista de reportes y del boton atras. (BOTTOM)
    }
}
