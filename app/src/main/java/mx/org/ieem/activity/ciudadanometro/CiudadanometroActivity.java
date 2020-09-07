package mx.org.ieem.activity.ciudadanometro;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
    TextView texto;                                 // Aloja el elemento de la UI (textView_NumerodeCiudadanometro_Ciudadanometro) que mostrara cuantos Ciudadanometros se han realizado.

    Intent intentIniciar;                           // Intent que navegara desde CiudadanometroActivity hacia CalendarioAplicacionActivity.
    Intent intentEnviar;                            // Intent que navegara desde CiudadanometroActivity hacia LoadPageActivity.
    Intent intentLogout;                            // Intent que navegara desde CiudadanometroActivity hacia MainActivity.
    Intent intentRegresar;                          // Intent que navegara desde CiudadanometroActivity hacia  SelectActivity.
    DataBaseAppRed database;                        // Instancia de la base de datos utilizado para obtener el municipio de acuerdo a un objeto de tipo trdd_ej_cct.

    int ultimoRegistro = 0;

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
        texto = (TextView)findViewById(R.id.textView_NumerodeCiudadanometro_Ciudadanometro);
        intentIniciar = new Intent(this, CalendarioAplicacionActivity.class);
        intentEnviar = new Intent(this, LoadPageActivity.class);
        intentLogout = new Intent(this, MainActivity.class);
        intentRegresar = new Intent(this, SelectActivity.class);
        final AlertDialog.Builder dialogo2 = new AlertDialog.Builder(this);
        database = new DataBaseAppRed(getBaseContext());
        // Inicializacion de las variables (BOTTOM)


        Cursor dataCursor = database.getUltimoRegistroCiudadanometro();
        dataCursor.moveToNext();
        if(dataCursor.getCount() > 0)
        { // Obtiene el el numero de encuestas realizadas localmente (TOP).
            ultimoRegistro = dataCursor.getInt(0);
        } // Obtiene el el numero de encuestas realizadas localmente (BOTTOM).
        texto.setText("Ciudadanometros Realizados: " +  ultimoRegistro);
        // Click listeners de los botones definidos (TOP)
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentIniciar);
            }
        });

        // Mostrara un mensaje de advertencia antes de enviar las encuestas a organo central (TOP).
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle parametros = new Bundle();               // Ocupada para enviar valor al LoadPageActivity.
                parametros.putString("enviadode", "2");
                intentEnviar.putExtras(parametros);
                dialogo2.setTitle("Importante").setMessage("Estas por enviar los Ciudadanometros realizados!!!\n\nEsto requiere conexión a internet.");
                dialogo2.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(intentEnviar);
                    }
                });
                dialogo2.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialogo2.show();


            }
        });
        // Mostrara un mensaje de advertencia antes de enviar las encuestas a organo central (BOTTOM).

        // Logout del usuario (TOP).
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bolLogeado = false;
                database.logoutUsario();
                startActivity(intentLogout);
            }
        });
        // Logout del usuario (BOTTOM).

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
    { // Verifica que el usuario aun este logueado (TOP).
        super.onResume();
        if (!bolLogeado)
        { // Si el usuario ya nio esta logueado no permite regresar a esta activity (TOP)
            startActivity(intentLogout);
        } // Si el usuario ya nio esta logueado no permite regresar a esta activity (BOTTOM)
    } // Verifica que el usuario aun este logueado (BOTTOM).
}
