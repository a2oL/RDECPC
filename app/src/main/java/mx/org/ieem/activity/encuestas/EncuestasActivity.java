package mx.org.ieem.activity.encuestas;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.activity.main.LoadPageActivity;

import mx.org.ieem.activity.main.MainActivity;
import mx.org.ieem.activity.main.SelectActivity;
import mx.org.ieem.data.sqllite.DataBaseAppRed;

import mx.org.ieem.R;

import static java.sql.Types.NULL;
import static mx.org.ieem.RESTful.AsyncLogin.bolLogeado;

public class EncuestasActivity extends AppCompatActivity {

    Button btnIniciar;                              // Aloja el elemento de la UI (button_Iniciar_Encuestas) del layout activity_encuestas que acciona el intentIniciar.
    Button btnEnviar;                               // Aloja el elemento de la UI (button_Enviar_Encuestas) del layout activity_encuestas que acciona el intentEnviar.
    Button btnLogout;                               // Aloja el elemento de la UI (button_Logout_Encuestas) del layout activity_encuestas que acciona el intentLogout.
    Button btnRegresar;                             // Aloja el elemento de la UI (button_Regresar_Encuestas) del layout activity_encuestas que acciona el intentRegresar.
    TextView textViewNumeroEncuestas;               // Aloja el elemento de la UI (textView_NumerodeEncuestas_Encuestas) del layout activity_encuestas que muestra el numero de encuestas aplicadas..
    Intent intentIniciar;                           // Intent que navegara desde EncuestasActivity hacia InfoEncuestaActivity.
    Intent intentEnviar;                            // Intent que navegara desde EncuestasActivity hacia LoadPageActivity.
    Intent intentLogout;                            // Intent que navegara desde EncuestasActivity hacia MainActivity.
    Intent intentRegresar;                          // Intent que navegara desde EncuestasActivity hacia  SelectActivity.
    DataBaseAppRed database;                        // Instancia de la base de datos utilizado para obtener el municipio de acuerdo a un objeto de tipo trdd_cct.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    { // Creacion de la vista (TOP)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuestas);

        // Inicializacion de las variables (TOP)
        btnIniciar = (Button) findViewById(R.id.button_Iniciar_Encuestas);
        btnEnviar = (Button) findViewById(R.id.button_Enviar_Encuestas);
        btnLogout = (Button) findViewById(R.id.button_Logout_Encuestas);
        btnRegresar = (Button) findViewById(R.id.button_Regresar_Encuestas);
        textViewNumeroEncuestas = (TextView) findViewById(R.id.textView_NumerodeEncuestas_Encuestas);
        intentIniciar = new Intent(this, InfoEncuestaActivity.class);
        intentEnviar = new Intent(this, LoadPageActivity.class);
        intentLogout = new Intent(this, MainActivity.class);
        intentRegresar = new Intent(this, SelectActivity.class);
        database = new DataBaseAppRed(getBaseContext());

        Cursor dataCursor = database.getUltimoRegistro();
        dataCursor.moveToNext();
        // Inicializacion de las variables (BOTTOM)

        // Texto informativo de cuantas encuestas se han realizado
        // TODO Agregar una tabla o un metodo para contar encuestas Nota: Hasta que este la version final de la bd.
        textViewNumeroEncuestas.setText("Encuestas Realizadas: " + dataCursor.getString(0) );

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
                parametros.putString("enviadode", "1");
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


} // Creacion de la vista (BOTTOM)