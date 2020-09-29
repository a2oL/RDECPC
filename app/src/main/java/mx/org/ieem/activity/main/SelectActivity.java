package mx.org.ieem.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.R;
import mx.org.ieem.RESTful.AsyncReportes;
import mx.org.ieem.activity.ciudadanometro.CiudadanometroActivity;
import mx.org.ieem.activity.encuestas.EncuestasActivity;
import mx.org.ieem.data.sqllite.DataBaseAppRed;
import static mx.org.ieem.RESTful.AsyncLogin.actual_final;
import static mx.org.ieem.RESTful.AsyncLogin.bolLogeado;


public class SelectActivity extends AppCompatActivity{
    Button btnEncuesta;                         // Aloja el elemento de la UI (button_EntrarEncuesta_Select) del layout activity_select.
    Button btnCiudadanometro;                   // Aloja el elemento de la UI (button_EntrarCiudadanometro_Select) del layout activity_select.
    Button btnLogout;                           // Aloja el elemento de la UI (button_Logout_Select) del layout activity_select.
    Button btnHome;                             // Aloja el elemento de la UI (button_Home_Select) del layout activity_select.
    TextView textViewNombreEscuela;             // Aloja el elemento de la UI (textView_Escuela_Select) del layout activity_select.
    TextView textViewClaveEscuela;              // Aloja el elemento de la UI (textView_Clave_Select) del layout activity_select.
    TextView textViewMunicipioEscuela;          // Aloja el elemento de la UI (textView_Municipio_Select) del layout activity_select.
    Intent intentEncuestas;                     // Intent que navegara desde  SelectActivity hacia EncuestasActivity.
    Intent intentCiudadanometro;                // Intent que navegara desde  SelectActivity hacia CiudadanometroActivity.
    Intent intentLogout;                        // Intent que navegara desde  SelectActivity hacia MainActivity.
    Intent intentHome;                          // Intent que navegara desde SelectActivity hacia MainActivity Sin desloguear.
    DataBaseAppRed database;                    // Instancia de la base de datos utilizado para obtener el municipio de acuerdo a un objeto de tipo trdd_ej_cct.


    Button btnReportes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        // Inicializacion de las variables (TOP).
        btnEncuesta = (Button) findViewById(R.id.button_EntrarEncuesta_Select);
        btnCiudadanometro = (Button) findViewById(R.id.button_EntrarCiudadanometro_Select);
        btnLogout = (Button) findViewById(R.id.button_Logout_Select);
        btnHome = (Button) findViewById(R.id.button_Home_select);
        textViewNombreEscuela = (TextView) findViewById(R.id.textView_Escuela_Select);
        textViewClaveEscuela = (TextView) findViewById(R.id.textView_Clave_Select);
        textViewMunicipioEscuela = (TextView) findViewById(R.id.textView_Municipio_Select);
        intentEncuestas = new Intent(this, EncuestasActivity.class);
        intentCiudadanometro = new Intent(this, CiudadanometroActivity.class);
        intentLogout = new Intent(this, MainActivity.class);
        intentHome = new Intent(this, MainActivity.class);
        database = new DataBaseAppRed(getBaseContext());
        // Inicializacion de las variables (BOTTOM).

        // Obtencion de datos del usuario actual (TOP).
        textViewNombreEscuela.setText("Escuela: " + actual_final.getNombre());
        textViewClaveEscuela.setText("Con clave de CCT: " + actual_final.getId_cct());
        textViewMunicipioEscuela.setText("Del municipio de: " + database.getMunicipio().getNombre());
        // Obtencion de datos del usuario actual (BOTTOM).

        // Click listeners de los botones definidos (TOP).
        btnEncuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentEncuestas);
            }
        });
        btnCiudadanometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCiudadanometro);
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
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentHome);
            }
        });
        // Click listeners de los botones definidos (BOTTOM).
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
}
