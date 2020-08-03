package mx.org.ieem.activity.ciudadanometro;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
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

import mx.org.ieem.adapters.FirstCiudadanoAdapter;
import mx.org.ieem.R;

import static mx.org.ieem.activity.ciudadanometro.CalendarioAplicacionActivity.anio_final_ciudadanometro;
import static mx.org.ieem.activity.ciudadanometro.CalendarioAplicacionActivity.ejercicio_final_ciudadanometro;
import static mx.org.ieem.activity.ciudadanometro.CalendarioAplicacionActivity.grado_final_ciudadanometro;

public class PrimeraCiudadanoActivity extends AppCompatActivity {

    String[] stringArrayPreguntas;                  // Contiene las preguntas del ciudadanometro.
    ListView listViewPreguntas;                     // Sirve para desplegar las preguntas con su respectiva respuesta.
    TextView textViewAnio;                          // Contiene el anio que se selecciono para el ciudadanometro.
    TextView textViewEjercicio;                     // Contiene el publico objetivo del ciudadanometro.
    TextView textViewGrado;                         // En caso de que el ejercicio sea realizado por padres de familia o tutores sera el grtado seleccionado.
    TextView textViewGradoText;                     // Sirve para desaparecer el texview de grado en caso de que no sea realizado por padre de familia o tutores.
    Button btnGuardar;                              // Aloja el elemento de la UI (button_siguiente_first_ciudadano) del layout activity_primera_ciudadano que acciona el intentSiguiente.
    FirstCiudadanoAdapter customAdapter;            // Adapatador de las preguntas y respuestas del ciudadanometro
    AlertDialog.Builder dialogoAuxiliar;            // Dialogo utilizado para informar si faltan preguntas por responder.
    Intent intentSiguiente;                         // Intent que navegara desde PrimeraCiudadanoActivity hacia SegundaCiudadanoActivity.
    Intent intentSalir;                             // Intent que navegara desde PrimeraCiudadanoActivity hacia CiudadanometroActivity.


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_ciudadano);
        cargarAnioEjercicioGrado();
        //TODO Regresar preguntas de bd.
        stringArrayPreguntas =  new String[]{"1.\tPregunta (Se modifica cada año)  ", "2.\tPregunta (Se modifica cada año)  ","3.\tPregunta (Se modifica cada año)"
                ,"4.\tPregunta (Se modifica cada año)","5.\tPregunta (Se modifica cada año)","6.\tPregunta (Se modifica cada año)","7.\tPregunta (Se modifica cada año)","8.\tPregunta (Se modifica cada año)"};
        customAdapter = new FirstCiudadanoAdapter(getApplicationContext(), stringArrayPreguntas);
        cargarPreguntas();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_primera_ciudadano);
            cargarAnioEjercicioGrado();
            cargarPreguntas();
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_primera_ciudadano);
            cargarAnioEjercicioGrado();
            cargarPreguntas();
        }
    }

    /**
     * Método que coloca en pantalla el anio, publico objetivo y en su defecto el grado previamnete seleccionado
     */
    public void cargarAnioEjercicioGrado()
    { // cargarAnioEjercicioGrado() (TOP)
        // Inicializacion de las variables (TOP)
        textViewAnio = (TextView)findViewById(R.id.textView_AnioSeleccionado_PrimeraCiudadano);
        textViewEjercicio = (TextView)findViewById(R.id.textView_EjercicioSeleccionado_PrimeraCiudadano);
        textViewGrado = (TextView)findViewById(R.id.textView_GradoSeleccionado_PrimeraCiudadano);
        textViewGradoText = (TextView)findViewById(R.id.textView_gradotext_first_ciudadano);
        // Inicializacion de las variables (BOTTOM)

        // Poner en pantalla el anio, Publico objetivo y segun el caso el grado (TOP)
        textViewAnio.setText(anio_final_ciudadanometro);
        textViewEjercicio.setText(ejercicio_final_ciudadanometro);
        if (ejercicio_final_ciudadanometro.equals("1.- Padres de familio o tutores"))
        { // Si el ejercicio es aplicado a padres de familia o tutores (TOP)
            textViewGrado.setText(grado_final_ciudadanometro);
        } // Si el ejercicio es aplicado a padres de familia o tutores (BOTTOM)
        else
        { // Sino el grado desaparece (TOP)
            textViewGrado.setVisibility(View.GONE);
            textViewGradoText.setVisibility(View.GONE);
        } // Sino el grado desaparece (BOTTOM)
        // Poner en pantalla el anio, Publico objetivo y segun el caso el grado (BOTTOM)\

    } // cargarAnioEjercicioGrado() (BOTTOM)

    /**
     * Método que coloca en pantalla las preguntas con sus respectivas preguntas.
     */
    public void cargarPreguntas()
    { // cargarPreguntas() (TOP)
        // Inicializacion de las variables (TOP)
        listViewPreguntas = (ListView)findViewById(R.id.lista_preguntas_ciudadano);
        btnGuardar = (Button)findViewById(R.id.button_siguiente_first_ciudadano);
        dialogoAuxiliar = new AlertDialog.Builder(this);
        intentSiguiente = new Intent(this, SegundaCiudadanoActivity.class);
        intentSalir = new Intent(this, CiudadanometroActivity.class);
        listViewPreguntas.setAdapter(customAdapter);
        // Inicializacion de las variables (BOTTOM)

        // Click listeners de los botones definidos (TOP)
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensajeRespuestasError = "Tus respuestas:";                      // string que contendra el mensaje con las respuestas seleccionadas o la pregunta no respondida.
                boolean boolTodasLasPreguntasRespondidas = true;                        // Dice si todas las preguntas ya fueron respondidas.
                for (int i = 0; i < FirstCiudadanoAdapter.selectedAnswersCiudada.size(); i++)
                { // Revisa las respuestas selecciondas (TOP)
                    if (FirstCiudadanoAdapter.selectedAnswersCiudada.get(i).matches("Not Attempted"))
                      { // Si encuentra alguna que no ha sido respondida (TOP)
                          mensajeRespuestasError = "La pregunta: " + (i + 1) + " No fue respondida";
                          boolTodasLasPreguntasRespondidas = false;
                          break;
                      } // Si encuentra alguna que no ha sido respondida (BOTTOM)
                    else
                      { // Concatena las respuestas obtenidas (TOP)
                          mensajeRespuestasError = mensajeRespuestasError + "\n" + (i + 1) + " " + FirstCiudadanoAdapter.selectedAnswersCiudada.get(i);
                      } // Concatena las respuestas obtenidas (BOTTOM)
                } // Revisa las respuestas selecciondas (BOTTOM)
                if (boolTodasLasPreguntasRespondidas)
                  { // Si todas las preguntas fueron respondidas (TOP)
                      Toast.makeText(getApplicationContext(), mensajeRespuestasError, Toast.LENGTH_LONG).show();
                      startActivity(intentSiguiente);
                  } // Si todas las preguntas fueron respondidas (BOTTOM)
                else
                  { // Si falta por responder alguna pregunta (TOP)
                      dialogoAuxiliar.setTitle("Importante");
                      dialogoAuxiliar.setMessage("Faltan preguntas por responder\n\n" + mensajeRespuestasError + "\n\nDesea Responderla o salir del Ciudadanometro");
                      dialogoAuxiliar.setCancelable(false);
                      dialogoAuxiliar.setPositiveButton("Responderla", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                              Toast.makeText(getApplicationContext(), "Ok intentalo nuevamente", Toast.LENGTH_LONG).show();
                          }
                      });
                      dialogoAuxiliar.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                              startActivity(intentSalir);
                          }
                      });
                      dialogoAuxiliar.show();
                } // Si falta por responder alguna pregunta (BOTTOM)
            }
        });
        // Inicializacion de las variables (BOTTOM)
    } // cargarPreguntas() (BOTTOM)
}
