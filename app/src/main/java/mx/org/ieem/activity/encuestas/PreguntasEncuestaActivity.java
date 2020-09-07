package mx.org.ieem.activity.encuestas;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.activity.main.MainActivity;
import mx.org.ieem.adapters.PreguntasEncuestaAdapter;
import mx.org.ieem.R;
import mx.org.ieem.data.sqllite.DataBaseAppRed;


import static mx.org.ieem.RESTful.AsyncLogin.bolLogeado;
import static mx.org.ieem.RESTful.AsyncLogin.id_random_final;
import static mx.org.ieem.activity.encuestas.MesEncuestaActivity.trddgradoescolar_actual_final;
import static mx.org.ieem.activity.encuestas.MesEncuestaActivity.trddmes_actual_final;

import static mx.org.ieem.RESTful.AsyncLogin.actual_final;
import static mx.org.ieem.RESTful.AsyncLogin.id_cct_final;
import static java.sql.Types.NULL;

public class PreguntasEncuestaActivity extends AppCompatActivity
{
    Button btnGuardar;                                       // Aloja el elemento de la UI (button_Guardar_PreguntasEncuesta) del layout activity_preguntas_encuesta verificando que las preguntas hayan sido respondidas, para posteriormente insertarlas a la bd
    TextView textViewmes;                                    // Aloja el elemento de la UI (textView_Mes_PreguntasEncuesta) del activity_preguntas_encuesta que muestra el mes seleccionado.
    TextView textViewgrado;                                  // Aloja el elemento de la UI (textView_Grado_PreguntasEncuesta) del activity_preguntas_encuesta que muestra el grado seleccionado.
    ListView listPreguntas;                                  // Aloja el elemento de la UI (listView_PreguntasEncuesta) del activity_preguntas_encuesta que muestra las preguntas que se encuentran en la bd.
    PreguntasEncuestaAdapter customAdapter;                  // Contiene el adaptador para mostrar las preguntas y respuestas de la encuesta.
    Intent intentSalirEncuesta;                              // Intent que navegara desde PreguntasEncuestaActivity hacia MesEncuestaActivity.
    Intent intentSeguirEncuesta;                             // Intent que navegara desde PreguntasEncuestaActivity hacia PreguntasEncuestaActivity.
    Intent intentLogout;

    String message = "";                                     // Mensaje que dira que pregunta no ha sido respondida.
    int ultimoRegistro = 0;                                  // Contiene el numero del ultimo registro de encuesta.
    boolean booleanPreguntasRespondidas = true;              // Verdadero si todas las preguntas han sido respondidas falso si falta de responder alguna.

    DataBaseAppRed dataSource;                               // Instancia de la bd para poder insertar o consultar registros de la bd.
    Cursor dataCursor;                                       // Contiene el result Set de consultas a la bd.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas_encuesta);

        // Inicializacion de las variables (TOP)
        dataSource = new DataBaseAppRed(getApplicationContext());
        dataCursor=dataSource.getUltimoRegistro();
        customAdapter = new PreguntasEncuestaAdapter(getApplicationContext());
        intentSalirEncuesta = new Intent(this, MesEncuestaActivity.class);
        intentSeguirEncuesta = new Intent(this, PreguntasEncuestaActivity.class);
        intentLogout = new Intent(this, MainActivity.class);

        // Inicializacion de las variables (BOTTOM)

        cargarNumeroEncuestasRealizadas();
        cargarMesGradoPreguntas();
        cargarGuardar();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if (!bolLogeado)
        { // Si el usuario ya nio esta logueado no permite regresar a esta activity (TOP)
            startActivity(intentLogout);
        } // Si el usuario ya nio esta logueado no permite regresar a esta activity (BOTTOM)
    }

    /**
     * Método utilizado para detectar la rotacion de la pantalla y evitar que las elementos se vuelvan a crear.
     */
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
          { // Si la orientacion cambia a landscape (TOP)
              setContentView(R.layout.activity_preguntas_encuesta);
              cargarMesGradoPreguntas();
              cargarGuardar();
          } // Si la orientacion cambia a landscape (BOTTOM)
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
          { // Si la orientacion cambia a portrait (TOP)
              setContentView(R.layout.activity_preguntas_encuesta);
              cargarMesGradoPreguntas();
              cargarGuardar();
          } // Si la orientacion cambia a portrait (BOTTOM)
    }

    /**
     * Método que coloca en los textView el valor correpondiente tanto de grado como de Mes
     */
    public void cargarMesGradoPreguntas()
    {
        // Inicializacion de las variables (TOP)
        textViewmes = (TextView)findViewById(R.id.textView_Mes_PreguntasEncuesta);
        textViewgrado = (TextView)findViewById(R.id.textView_Grado_PreguntasEncuesta);
        listPreguntas = (ListView)findViewById(R.id.listView_PreguntasEncuesta);
        textViewmes.setText(trddmes_actual_final.getNombre());
        textViewgrado.setText(trddgradoescolar_actual_final.getNombre());
        listPreguntas.setAdapter(customAdapter);
        // Inicializacion de las variables (BOTTOM)
    }

    /**
     * Método que encuentra preguntas sin responder y de lo contrario inserta las respuestas en la bd
     */
    public void cargarGuardar()
    {
        // Inicializacion de las variables (TOP)
        btnGuardar = (Button)findViewById(R.id.button_Guardar_PreguntasEncuesta);
        final AlertDialog.Builder dialogo2 = new AlertDialog.Builder(this);         // Dialogo utilizado para mostrar diversos mensajes (Respuestas guardadas, REspuestas faltantes)
        // Inicializacion de las variables (BOTTOM)

        // Click listeners de los botones definidos (TOP)
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < PreguntasEncuestaAdapter.selectedRespuestas.size(); i++)
                   { // Revisa si falta responder alguna pregunta (TOP)
                        if (PreguntasEncuestaAdapter.selectedRespuestas.get(i).matches("Not Attempted"))
                          { // Si alguna pregunta no fue respondida cambia el estado de booleanPreguntasRespondidas (TOP)
                              message = "La pregunta: "+(i + 1)+" No fue respondida";
                              booleanPreguntasRespondidas= false;
                              break;
                          } // Si alguna pregunta no fue respondida cambia el estado de booleanPreguntasRespondidas (BOTTOM)
                   } // Revisa si falta responder alguna pregunta (BOTTOM)
                if (booleanPreguntasRespondidas)
                  { // Si todas las preguntas fueron respondidas (TOP)
                      for (int i = 0; i < PreguntasEncuestaAdapter.selectedRespuestas.size(); i++)
                         {//Inserta las respuestas en trdd_encuestas (TOP)
                              dataSource.InsertDetalleEncuesta
                              (
                                  id_cct_final,
                                  id_random_final,
                                  ultimoRegistro+1,
                                  "2020",
                                  trddmes_actual_final.getId_mes(),
                                  actual_final.getId_nivel_educativo(),
                                  trddgradoescolar_actual_final.getId_grado_escolar(),
                                  Integer.parseInt(PreguntasEncuestaAdapter.selectedIndicador.get(i)),
                                  Integer.parseInt(PreguntasEncuestaAdapter.selectedIdRespuesta.get(i)),
                                  Integer.parseInt(PreguntasEncuestaAdapter.selectedEstatus.get(i))
                              );
                         }//Inserta las respuestas en trdd_encuestas (BOTTOM)
                      dataSource.InsertEncuesta
                          (
                                  id_cct_final,
                                  id_random_final,
                                  ultimoRegistro+1,
                                  actual_final.getId_nivel_educativo(),
                                  trddgradoescolar_actual_final.getId_grado_escolar()
                          );
                      dialogo2.setTitle("Importante").setMessage("Tus respuestas fueron Guardadas!!!\n\nRegresa la tableta al encargado.");
                      dialogo2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(intentSalirEncuesta);
                          }
                      });
                      dialogo2.setNegativeButton("", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {
                          }
                      });
                      dialogo2.show();
                  } // Si todas las preguntas fueron respondidas (BOTTOM)
                else
                  { // SI faltan respuestas por responder (TOP)
                    dialogo2.setTitle("Importante").setMessage(message+"\n\nDeseas responderla  o salir de la encuesta\n\n");
                    dialogo2.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(intentSalirEncuesta);
                        }
                    });
                    dialogo2.setNegativeButton("Responderla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            booleanPreguntasRespondidas= true;
                            Toast.makeText(getApplicationContext(), "Perfecto intentalo nuevamente!!!", Toast.LENGTH_LONG).show();
                        }
                    });
                    dialogo2.show();
                  } // SI faltan respuestas por responder (BOTTOM)

            }
        });
        // Click listeners de los botones definidos (BOTTOM)
    }

    /**
     * Método que busca si hay alguna encuesta ya realizada en la bd y de ser asi
     * @ultimoRegistro se modifica para que asi guarde el numero de encuestas existentes en la bd.
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
