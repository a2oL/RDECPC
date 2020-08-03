package mx.org.ieem.activity.ciudadanometro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.activity.main.MainActivity;
import mx.org.ieem.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalendarioAplicacionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinnerAnios;                                                                           // Aloja el elemento de la UI (spinner_Anios_CalendarioAplicacion) del layout activity_calendario_aplicacion que contiene los anios de aplicacion.
    Spinner spinnerEjercicio;                                                                       // Aloja el elemento de la UI (spinner_Ejercicios_CalendarioAplicacion) del layout activity_calendario_aplicacion que contiene el publico objetivo.
    Spinner spinnerGrado;                                                                           // Aloja el elemento de la UI (spinner_Grado_CalendarioAplicacion) del layout activity_calendario_aplicacion que contiene los grados disponibles para padres o tutores.
    Button btnIniciar;                                                                              // Aloja el elemento de la UI (button_Iniciar_CalendarioAplicacion) del layout activity_calendario_aplicacion que acciona el intentPrimera.
    Button btnRegresar;                                                                             // Aloja el elemento de la UI (button_Regresar_CalendarioAplicacion) del layout activity_calendario_aplicacion que acciona el intentRegresar.
    Button btnLogout;                                                                               // Aloja el elemento de la UI (button_Logout_CalendarioAplicacion) del layout activity_calendario_aplicacion que acciona el intentLogout.
    TextView textViewGrado;                                                                         // Aloja el elemento de la UI (textView_grado_calendario_aplicacion) del layout activity_calendario_aplicacion que solo servira para desaparecer el elemento en caso de padres o tutores.

    Intent intentPrimera;                                                                           // Intent que navegara desde CalendarioAplicacionActivity hacie PrimeraCiudadanoActivity.
    Intent intentRegresar;                                                                          // Intent que navegara desde CalendarioAplicacionActivity hacie CiudadanometroActivity.
    Intent intentLogout;                                                                            // Intent que navegara desde CalendarioAplicacionActivity hacie MainActivity.

    String[] strAuxiliar;                                                                           // Auxiliar para poder cargar los anios ejercicio y grados a los spinners
    List<String> listAuxiliar = new ArrayList<>();                                                  // Auxiliar para mostrar los datos del strAuxiliar.

    static String anio_final_ciudadanometro = "";                                                   // Contiene el anio de aplicacion del ciudadanometro.
    static String ejercicio_final_ciudadanometro = "1.- Padres de familio o tutores";               // Contiene a quien sera aplicado el ciudadanometro.
    static String grado_final_ciudadanometro = "";                                                  // Contierne el grado al que sera aplicado el ciudadanometro.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario_aplicacion);

        // Inicializacion de las variables (TOP)
        spinnerAnios = (Spinner) findViewById(R.id.spinner_Anios_CalendarioAplicacion);
        spinnerEjercicio = (Spinner) findViewById(R.id.spinner_Ejercicios_CalendarioAplicacion);
        spinnerGrado = (Spinner) findViewById(R.id.spinner_Grado_CalendarioAplicacion);
        textViewGrado = (TextView)findViewById(R.id.textView_grado_calendario_aplicacion);
        btnIniciar = (Button)findViewById(R.id.button_Iniciar_CalendarioAplicacion);
        btnRegresar = (Button)findViewById(R.id.button_Regresar_CalendarioAplicacion);
        btnLogout = (Button)findViewById(R.id.button_Logout_CalendarioAplicacion);
        spinnerAnios.setOnItemSelectedListener(this);
        spinnerAnios.setAdapter(spinAnios());
        spinnerEjercicio.setOnItemSelectedListener(this);
        spinnerEjercicio.setAdapter(spinEjercicio());
        spinnerGrado.setOnItemSelectedListener(this);
        spinnerGrado.setAdapter(spinGrado());
        intentPrimera = new Intent(this, PrimeraCiudadanoActivity.class);
        intentRegresar = new Intent(this, CiudadanometroActivity.class);
        intentLogout = new Intent(this, MainActivity.class);
        // Inicializacion de las variables (BOTTOM)

        // Click listeners de los botones definidos (TOP)
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentPrimera);
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentRegresar);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentLogout);
            }
        });
        // Inicializacion de las variables (BOTTOM)

    }

    // Adapatadores de los spinners (TOP)
    public ArrayAdapter<String> spinAnios()
    {
        // TODO Cambiar por la bd de Ciudadanometro
        strAuxiliar = new String[] {"2020", "2021", "2022", "2023", "2024"};
        Collections.addAll(listAuxiliar, strAuxiliar);
        return new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, listAuxiliar);
    }

    public ArrayAdapter<String> spinEjercicio()
    {
        // TODO Cambiar por la bd de Ciudadanometro
        listAuxiliar = new ArrayList<>();
        strAuxiliar = new String[] {"1.- Padres de familio o tutores", "2.- Docentes", "3.- Directivos/Administrativos", "4.- Otros"};
        Collections.addAll(listAuxiliar, strAuxiliar);
        return new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, listAuxiliar);
    }

    public ArrayAdapter<String> spinGrado()
    {
        // TODO Cambiar por la bd de Ciudadanometro
        listAuxiliar = new ArrayList<>();
        strAuxiliar = new String[] {"1 ero de Secundaria", "2 do de Secundaria", "3 ero de Secundaria"};
        Collections.addAll(listAuxiliar, strAuxiliar);
        return new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, listAuxiliar);
    }
    // Adapatadores de los spinners (BOTTOM)

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        anio_final_ciudadanometro = spinnerAnios.getSelectedItem().toString();
        ejercicio_final_ciudadanometro = spinnerEjercicio.getSelectedItem().toString();
        grado_final_ciudadanometro = spinnerGrado.getSelectedItem().toString();

        if (!ejercicio_final_ciudadanometro.contentEquals("1.- Padres de familio o tutores"))
          {
              spinnerGrado.setVisibility(View.GONE);
              textViewGrado.setVisibility(View.GONE);
          }
        else
          {
              spinnerGrado.setVisibility(View.VISIBLE);
              textViewGrado.setVisibility(View.VISIBLE);
          }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}
