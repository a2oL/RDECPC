package mx.org.ieem.activity.ciudadanometro;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.R;
import mx.org.ieem.data.sqllite.DataBaseAppRed;

import static java.sql.Types.NULL;
import static mx.org.ieem.RESTful.AsyncLogin.actual_final;
import static mx.org.ieem.activity.ciudadanometro.CalendarioAplicacionActivity.anio_final_ciudadanometro;
import static mx.org.ieem.activity.ciudadanometro.CalendarioAplicacionActivity.ejercicio_final_ciudadanometro;
import static mx.org.ieem.activity.ciudadanometro.CalendarioAplicacionActivity.grado_final_ciudadanometro;
import static mx.org.ieem.activity.ciudadanometro.SegundaCiudadanoActivity.edad_realicador_final_ciudadanometro;
import static mx.org.ieem.activity.ciudadanometro.SegundaCiudadanoActivity.escolaridad_realicador_final_ciudadanometro;
import static mx.org.ieem.activity.ciudadanometro.SegundaCiudadanoActivity.genero_realicador_final_ciudadanometro;
import static mx.org.ieem.adapters.PrimeraCiudadanoAdapter.selectedIdAnios;
import static mx.org.ieem.adapters.PrimeraCiudadanoAdapter.selectedIdEstatusRespuesta;
import static mx.org.ieem.adapters.PrimeraCiudadanoAdapter.selectedIdPreguntas;
import static mx.org.ieem.adapters.PrimeraCiudadanoAdapter.selectedIdRespuesta;
import static mx.org.ieem.adapters.PrimeraCiudadanoAdapter.selectedRespuesta;

public class CuartaCiudadanoActivity extends AppCompatActivity {
    Button btnFinalizar;                                // Aloja el elemento de la UI (button_finalizar_four_ciudadano) del activity_cuarta_ciudadano que preguntara si se desea finalizar o no la encuesta.
    Intent intentSi;                                    // Intent que navegara desde CuartaCiudadanoActivity hacia PrimeraCiudadanoActivity.
    Intent intentNo;                                    // Intent que navegara desde CuartaCiudadanoActivity hacia CalendarioAplicacionActivity.
    DataBaseAppRed dataSource;                          // Instancia de la base de datos
    Cursor dataCursor;                                  // Cursor multiproposito para consultas de bd
    int ultimoRegistro = 0;                             // Variable que sera remplazada con el AUTO INCREMENT de la bd
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuarta_ciudadano);
        // Inicializacion de las variables (TOP)
        btnFinalizar = (Button)findViewById(R.id.button_finalizar_four_ciudadano);
        intentSi = new Intent(this, PrimeraCiudadanoActivity.class);
        intentNo = new Intent(this, CalendarioAplicacionActivity.class);
        final AlertDialog.Builder dialogo2 = new AlertDialog.Builder(this);
        dataSource = new DataBaseAppRed(getBaseContext());
        dataCursor=dataSource.getUltimoRegistroCiudadanometro();
        cargarNumeroEncuestasRealizadas();
        // Inicializacion de las variables (BOTTOM)

        // Click listeners de los botones definidos (TOP)
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo2.setTitle("Importante").setMessage("\nTus respuestas Fueron Guardadas\n\nDevuelve el dispositivo al aplicador!!!");
                dialogo2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        insertarEncuestaCiudadanometro();
                        startActivity(intentNo);
                    }
                });
                dialogo2.show();
            }
        });
        // Click listeners de los botones definidos (BOTTOM)
    }

    public void insertarEncuestaCiudadanometro(){
        for (int i = 0 ; i < selectedRespuesta.size() ; i++){
            dataSource.InsertDetalleEncuestaCiudadanometro(actual_final.getId_cct(),dataSource.getIdRandomDispositivo(),ultimoRegistro+1,selectedIdAnios.get(i),selectedIdPreguntas.get(i),Integer.valueOf(selectedIdRespuesta.get(i)),Integer.valueOf(selectedIdEstatusRespuesta.get(i)));
        }
        dataSource.InsertEncuestaCiudadanometro(actual_final.getId_cct(),dataSource.getIdRandomDispositivo(),ultimoRegistro+1,ejercicio_final_ciudadanometro.getId_realizador(), actual_final.getId_nivel_educativo(),grado_final_ciudadanometro.getId_grado_escolar(),edad_realicador_final_ciudadanometro.getId_edad(),genero_realicador_final_ciudadanometro.getId_genero(),escolaridad_realicador_final_ciudadanometro.getId_escolaridad());
    }

    /**
     * Metodo para saber que registro fue el ultimo, se sustituira pora el AUTO INCREMENT 
     *
     */
    public void cargarNumeroEncuestasRealizadas()
    {
        if (dataCursor.getCount() > 0)
          {//Si existen registros de encuestas (TOP)
              dataCursor.moveToNext();
              if (dataCursor.getInt(0) != NULL)
                { // Si encuentra algun registro se actualiza ultimoRegistro (TOP)
                    ultimoRegistro = dataCursor.getInt(0);
                } // Si encuentra algun registro se actualiza ultimoRegistro (BOTTOM)
          }//Si existen registros de encuestas (BOTTOM)
    }
}
