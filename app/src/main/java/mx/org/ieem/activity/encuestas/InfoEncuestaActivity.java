package mx.org.ieem.activity.encuestas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.activity.main.MainActivity;
import mx.org.ieem.R;
import mx.org.ieem.data.sqllite.DataBaseAppRed;

import static mx.org.ieem.RESTful.AsyncLogin.bolLogeado;

public class InfoEncuestaActivity extends AppCompatActivity {

    Button btnSiguiente;                    // Aloja el elemento de la UI (button_Siguiente_InfoEncuesta) del layout activity_info_encuesta que acciona el intentSiguiente.
    Button btnLogout;                       // Aloja el elemento de la UI (button_Logout_InfoEncuesta) del layout activity_info_encuesta que cierra la session del usuario.
    Button btnAtras;                        // Aloja el elemento de la UI (button_Regresar_InfoEncuesta) del layout activity_info_encuesta que acciona el intentAtras.
    Intent intentSiguiente;                 // Intent que navegara desde InfoEncuestaActivity hacie MesEncuestaActivity.
    Intent intentLogout;                    // Intent que navegara desde InfoEncuestaActivity hacie MainActivity.
    Intent intentAtras;                     // Intent que navegara desde InfoEncuestaActivity hacie EncuestasActivity.
    DataBaseAppRed database;                        // Instancia de la base de datos utilizado para obtener el municipio de acuerdo a un objeto de tipo trdd_ej_cct.


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_encuesta);

        // Inicializacion de las variables (TOP)
        btnSiguiente = (Button) findViewById(R.id.button_Siguiente_InfoEncuesta);
        btnLogout = (Button) findViewById(R.id.button_Logout_InfoEncuesta);
        btnAtras = (Button) findViewById(R.id.button_Regresar_InfoEncuesta);
        intentSiguiente = new Intent(this, MesEncuestaActivity.class);
        intentLogout = new Intent(this, MainActivity.class);
        intentAtras = new Intent(this, EncuestasActivity.class);
        database = new DataBaseAppRed(getBaseContext());
        // Inicializacion de las variables (BOTTOM)

        // Click listeners de los botones definidos (TOP)
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentSiguiente);
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

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentAtras);
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
}
