package mx.org.ieem.activity.encuestas;

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
import mx.org.ieem.data.DataBaseAppRed;
import mx.org.ieem.data.sqllite.trdd_grado_escolar;
import mx.org.ieem.data.sqllite.trdd_mes;

import static mx.org.ieem.RESTful.AsyncLogin.bolLogeado;

public class MesEncuestaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button btnIniciar;                                              // Aloja el elemento de la UI (button_Iniciar_MesEncuesta) del layout activity_mes_encuesta que acciona el intentPreguntas.
    Button btnLogout;                                               // Aloja el elemento de la UI (button_Logout_MesEncuesta) del layout activity_mes_encuesta que acciona el intentLogout.
    Button btnRegresar;                                             // Aloja el elemento de la UI (button_Atras_MesEncuesta) del layout activity_mes_encuesta que acciona el intentRegresar.
    Spinner spinnerMeses;                                           // Aloja el elemento de la UI (spinner_Meses_MesEncuesta) del layout activity_mes_encuesta que contiene los meses cargados de la bd.
    Spinner spinnerGrados;                                          // Aloja el elemento de la UI (spinner_Grado_MesEncuesta) del layout activity_mes_encuesta que contiene los grados cargados de la bd.
    Intent intentPreguntas;                                         // Intent que navegara desde MesEncuestaActivity hacia PreguntasEncuestaActivity.
    Intent intentLogout;                                            // Intent que navegara desde MesEncuestaActivity hacia MainActivity.
    Intent intentRegresar;                                          // Intent que navegara desde MesEncuestaActivity hacia InfoEncuestaActivity.
    DataBaseAppRed dataSource;                                      // Contiene una instancia de la base de datos para poder hacer consultas.
    Cursor cursor_MesEncuesta;                                      // Contiene el result set de querys realizados por los metodos cargarMeses() o cargarGrados().
    SimpleCursorAdapter simpleCursorAdapter_MesEncuesta;            // Determina la manera en la que seran mostrados los datos del cursor_MesEncuesta.
    TextView textViewNumerodeEncuestas;                             // Mostrara cuantas encuestas por mes y grado se han realizado.

    static trdd_mes trddmes_actual_final;                           // Contiene el mes que fue elegido por el usuario.
    static trdd_grado_escolar trddgradoescolar_actual_final;        // Contiene el grado seleccionado por el usuario.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_encuesta);

        // Inicializacion de las variables (TOP)
        btnIniciar = (Button)findViewById(R.id.button_Iniciar_MesEncuesta);
        btnLogout = (Button)findViewById(R.id.button_Logout_MesEncuesta);
        btnRegresar = (Button)findViewById(R.id.button_Atras_MesEncuesta);
        spinnerMeses = (Spinner) findViewById(R.id.spinner_Meses_MesEncuesta);
        spinnerGrados = (Spinner) findViewById(R.id.spinner_Grado_MesEncuesta);
        textViewNumerodeEncuestas = (TextView)findViewById(R.id.textView_NumerodeEncuestas_MesEncuesta);
        intentPreguntas = new Intent(this, PreguntasEncuestaActivity.class);
        intentLogout = new Intent(this, MainActivity.class);
        intentRegresar = new Intent(this, InfoEncuestaActivity.class);
        dataSource = new DataBaseAppRed(getBaseContext());
        spinnerMeses.setOnItemSelectedListener(this);
        spinnerMeses.setAdapter(cargarMeses());
        spinnerGrados.setOnItemSelectedListener(this);
        spinnerGrados.setAdapter(cargarGrados());
        // Inicializacion de las variables (BOTTOM)

        // Click listeners de los botones definidos (TOP)
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentPreguntas);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bolLogeado = false;
                dataSource.logoutUsario();
                startActivity(intentLogout);
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentRegresar);
            }
        });
        // Click listeners de los botones definidos (BOTTOM)
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
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // TODO Aqui ira la consulta de encuestas por mes y grado
        cursor_MesEncuesta = (Cursor)spinnerMeses.getSelectedItem();
        trddmes_actual_final = new trdd_mes(cursor_MesEncuesta.getInt(cursor_MesEncuesta.getColumnIndexOrThrow("_id")),cursor_MesEncuesta.getString(cursor_MesEncuesta.getColumnIndexOrThrow("nombre")));
        cursor_MesEncuesta = (Cursor) spinnerGrados.getSelectedItem();
        trddgradoescolar_actual_final = new trdd_grado_escolar(cursor_MesEncuesta.getInt(cursor_MesEncuesta.getColumnIndexOrThrow("_id")),cursor_MesEncuesta.getString(cursor_MesEncuesta.getColumnIndexOrThrow("nombre")),cursor_MesEncuesta.getString(cursor_MesEncuesta.getColumnIndexOrThrow("siglas")),cursor_MesEncuesta.getString(cursor_MesEncuesta.getColumnIndexOrThrow("grado")));

        textViewNumerodeEncuestas.setText("Se aplicaron " + dataSource.getNumerodeEncuestasPorMesyGrado(trddmes_actual_final.getId_mes(),trddgradoescolar_actual_final.getId_grado_escolar()) + " en el mes de " + trddmes_actual_final.getNombre() + " para el grado " + trddgradoescolar_actual_final.getNombre());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public SimpleCursorAdapter cargarMeses()
    { // Regresa los meses que se encuentran el la tabla trdd_mes (TOP)
        cursor_MesEncuesta=dataSource.getMesesBD();
        simpleCursorAdapter_MesEncuesta =new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor_MesEncuesta, new String[]{"nombre"}, new int[]{android.R.id.text1}, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        simpleCursorAdapter_MesEncuesta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return simpleCursorAdapter_MesEncuesta;
    } // Regresa los meses que se encuentran el la tabla trdd_mes (BOTTOM)

    public SimpleCursorAdapter cargarGrados()
    { // Regresa los grados que se encuentran en la tabla trdd_grado_escolar (TOP)
        cursor_MesEncuesta=dataSource.getGradosBD();
        simpleCursorAdapter_MesEncuesta =new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor_MesEncuesta, new String[]{"nombre"}, new int[]{android.R.id.text1}, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        simpleCursorAdapter_MesEncuesta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return simpleCursorAdapter_MesEncuesta;
    } // Regresa los grados que se encuentran en la tabla trdd_grado_escolar (BOTTOM)

}
