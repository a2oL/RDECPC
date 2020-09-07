package mx.org.ieem.activity.ciudadanometro;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.activity.main.MainActivity;
import mx.org.ieem.R;
import mx.org.ieem.data.sqllite.DataBaseAppRed;
import mx.org.ieem.data.sqllite.models.ciudadanometro.trdd_c_anio;
import mx.org.ieem.data.sqllite.models.ciudadanometro.trdd_c_grado_escolar;
import mx.org.ieem.data.sqllite.models.ciudadanometro.trdd_c_realizador;

import static mx.org.ieem.RESTful.AsyncLogin.bolLogeado;

import java.util.ArrayList;
import java.util.List;

public class CalendarioAplicacionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
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
    Cursor cursor_AnioEjercicioGrado;                                                               // Contiene el result set de querys realizados por los metodos cargarMeses() o cargarGrados().
    SimpleCursorAdapter simpleCursorAdapter_AnioEjercicioGrado;                                     // Determina la manera en la que seran mostrados los datos del cursor_MesEncuesta.
    DataBaseAppRed database;                                                                        // Instancia de la base de datos utilizado para obtener el municipio de acuerdo a un objeto de tipo trdd_ej_cct.
    String[] strAuxiliar;                                                                           // Auxiliar para poder cargar los anios ejercicio y grados a los spinners
    List<String> listAuxiliar = new ArrayList<>();                                                  // Auxiliar para mostrar los datos del strAuxiliar.

    public static trdd_c_anio anio_final_ciudadanometro;                                            // Contiene el anio de aplicacion del ciudadanometro.
    public static trdd_c_realizador ejercicio_final_ciudadanometro;                                 // Contiene a quien sera aplicado el ciudadanometro.
    public static trdd_c_grado_escolar grado_final_ciudadanometro;                                  // Contierne el grado al que sera aplicado el ciudadanometro.

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
        database = new DataBaseAppRed(getBaseContext());
        spinnerAnios.setOnItemSelectedListener(this);
        spinnerAnios.setAdapter(cargarAnios());
        spinnerEjercicio.setOnItemSelectedListener(this);
        spinnerEjercicio.setAdapter(cargarRealizador());
        spinnerGrado.setOnItemSelectedListener(this);
        spinnerGrado.setAdapter(cargarGrado());
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
                bolLogeado = false;
                database.logoutUsario();
                startActivity(intentLogout);
            }
        });
        // Inicializacion de las variables (BOTTOM)

    }

    // Adapatadores de los spinners (TOP)

    public SimpleCursorAdapter cargarAnios()
    { // Regresa los meses que se encuentran el la tabla trdd_c_anio (TOP)
        cursor_AnioEjercicioGrado=database.getAniosCiudadanometroBD();
        simpleCursorAdapter_AnioEjercicioGrado =new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor_AnioEjercicioGrado, new String[]{"_id"}, new int[]{android.R.id.text1}, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        simpleCursorAdapter_AnioEjercicioGrado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return simpleCursorAdapter_AnioEjercicioGrado;
    } // Regresa los meses que se encuentran el la tabla trdd_c_anio (BOTTOM)

    public SimpleCursorAdapter cargarRealizador()
    { // Regresa los meses que se encuentran el la tabla trdd_c_realizador (TOP)
        cursor_AnioEjercicioGrado=database.getRealizadorCiudadanometroBD();
        simpleCursorAdapter_AnioEjercicioGrado =new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor_AnioEjercicioGrado, new String[]{"nombre"}, new int[]{android.R.id.text1}, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        simpleCursorAdapter_AnioEjercicioGrado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return simpleCursorAdapter_AnioEjercicioGrado;
    } // Regresa los meses que se encuentran el la tabla trdd_c_realizador (BOTTOM)

    public SimpleCursorAdapter cargarGrado()
    { // Regresa los meses que se encuentran el la tabla trdd_c_grado_escolar (TOP)
        cursor_AnioEjercicioGrado=database.getGradosCiudadanometroBD();
        simpleCursorAdapter_AnioEjercicioGrado =new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor_AnioEjercicioGrado, new String[]{"nombre"}, new int[]{android.R.id.text1}, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        simpleCursorAdapter_AnioEjercicioGrado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return simpleCursorAdapter_AnioEjercicioGrado;
    } // Regresa los meses que se encuentran el la tabla trdd_c_grado_escolar (BOTTOM)

    // Adapatadores de los spinners (BOTTOM)

    @Override
    protected void onResume() {
        super.onResume();
        if (!bolLogeado)
        { // Si el usuario ya nio esta logueado no permite regresar a esta activity (TOP)
            startActivity(intentLogout);
        } // Si el usuario ya nio esta logueado no permite regresar a esta activity (BOTTOM)
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    { // Selecciona el Anio, Ejercicio y grado de aplicacion del ciudadanometro (TOP).
        cursor_AnioEjercicioGrado = (Cursor) spinnerAnios.getSelectedItem();
        anio_final_ciudadanometro = new trdd_c_anio(cursor_AnioEjercicioGrado.getString(cursor_AnioEjercicioGrado.getColumnIndexOrThrow("_id")));
        cursor_AnioEjercicioGrado = (Cursor) spinnerEjercicio.getSelectedItem();
        ejercicio_final_ciudadanometro = new trdd_c_realizador(cursor_AnioEjercicioGrado.getInt(cursor_AnioEjercicioGrado.getColumnIndexOrThrow("_id")),cursor_AnioEjercicioGrado.getString(cursor_AnioEjercicioGrado.getColumnIndexOrThrow("nombre")));
        cursor_AnioEjercicioGrado = (Cursor) spinnerGrado.getSelectedItem();
        grado_final_ciudadanometro = new trdd_c_grado_escolar(cursor_AnioEjercicioGrado.getInt(cursor_AnioEjercicioGrado.getColumnIndexOrThrow("_id")),cursor_AnioEjercicioGrado.getString(cursor_AnioEjercicioGrado.getColumnIndexOrThrow("nombre")),cursor_AnioEjercicioGrado.getString(cursor_AnioEjercicioGrado.getColumnIndexOrThrow("siglas")),cursor_AnioEjercicioGrado.getString(cursor_AnioEjercicioGrado.getColumnIndexOrThrow("grado")));

        // TODO Determinar con que se llenara el grdo en caso de que se seleccione Padres.
        if (!ejercicio_final_ciudadanometro.getNombre().contentEquals("Padres de familia o tutores"))
          {
              spinnerGrado.setVisibility(View.GONE);
              textViewGrado.setVisibility(View.GONE);
          }
        else
          {
              spinnerGrado.setVisibility(View.VISIBLE);
              textViewGrado.setVisibility(View.VISIBLE);
          }
    } // Selecciona el Anio, Ejercicio y grado de aplicacion del ciudadanometro (BOTTOM).

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}
