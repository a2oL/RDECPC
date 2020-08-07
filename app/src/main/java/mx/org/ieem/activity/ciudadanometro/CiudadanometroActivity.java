package mx.org.ieem.activity.ciudadanometro;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import mx.org.ieem.R;
import mx.org.ieem.activity.main.LoadPageActivity;
import mx.org.ieem.activity.main.MainActivity;
import mx.org.ieem.activity.main.SelectActivity;
import mx.org.ieem.data.sqllite.DataBaseAppRed;

import static mx.org.ieem.RESTful.AsyncLogin.bolLogeado;


public class CiudadanometroActivity extends AppCompatActivity
{
    Button btnIniciar;                              // Aloja el elemento de la UI (button_Iniciar_Ciudadanometro) del layout activity_Ciudadanometro que acciona el intentIniciar.
    Button btnEnviar;                               // Aloja el elemento de la UI (button_Enviar_Ciudadanometro) del layout activity_Ciudadanometro que acciona el intentEnviar.
    Button btnLogout;                               // Aloja el elemento de la UI (button_Logout_Ciudadanometro) del layout activity_Ciudadanometro que acciona el intentLogout.
    Button btnRegresar;                             // Aloja el elemento de la UI (button_Regresar_Ciudadanometro) del layout activity_Ciudadanometro que acciona el intentRegresar.

    Intent intentIniciar;                           // Intent que navegara desde CiudadanometroActivity hacia CalendarioAplicacionActivity.
    Intent intentEnviar;                            // Intent que navegara desde CiudadanometroActivity hacia LoadPageActivity.
    Intent intentLogout;                            // Intent que navegara desde CiudadanometroActivity hacia MainActivity.
    Intent intentRegresar;                          // Intent que navegara desde CiudadanometroActivity hacia  SelectActivity.
    DataBaseAppRed database;                        // Instancia de la base de datos utilizado para obtener el municipio de acuerdo a un objeto de tipo trdd_cct.


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudadanometro);

        // Inicializacion de las variables (TOP)
        btnIniciar = (Button)findViewById(R.id.button_Iniciar_Ciudadanometro);
        btnEnviar = (Button)findViewById(R.id.button_Enviar_Ciudadanometro);
        btnLogout = (Button)findViewById(R.id.button_Logout_Ciudadanometro);
        btnRegresar = (Button)findViewById(R.id.button_Regresar_Ciudadanometro);
        intentIniciar = new Intent(this, CalendarioAplicacionActivity.class);
        intentEnviar = new Intent(this, LoadPageActivity.class);
        intentLogout = new Intent(this, MainActivity.class);
        intentRegresar = new Intent(this, SelectActivity.class);
        database = new DataBaseAppRed(getBaseContext());
        // Inicializacion de las variables (BOTTOM)

        // Click listeners de los botones definidos (TOP)
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentIniciar);
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle parametros = new Bundle();               // Ocupada para enviar valor al LoadPageActivity.
                parametros.putString("enviadode", "2");
                intentEnviar.putExtras(parametros);
                startActivity(intentEnviar);
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

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentRegresar);
            }
        });
        // Click listeners de los botones definidos (BOTTOM)
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!bolLogeado)
        { // Si el usuario ya nio esta logueado no permite regresar a esta activity (TOP)
            startActivity(intentLogout);
        } // Si el usuario ya nio esta logueado no permite regresar a esta activity (BOTTOM)
    }
}
