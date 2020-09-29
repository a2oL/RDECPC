package mx.org.ieem.activity.encuestas;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.RESTful.AsyncReportes;
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
    Button btnReportes;                             // Aloja el elemento de la UI que permite acceder a el ReportesActivity.
    TextView textViewNumeroEncuestas;               // Aloja el elemento de la UI (textView_NumerodeEncuestas_Encuestas) del layout activity_encuestas que muestra el numero de encuestas aplicadas..
    Intent intentIniciar;                           // Intent que navegara desde EncuestasActivity hacia InfoEncuestaActivity.
    Intent intentEnviar;                            // Intent que navegara desde EncuestasActivity hacia LoadPageActivity.
    Intent intentLogout;                            // Intent que navegara desde EncuestasActivity hacia MainActivity.
    Intent intentRegresar;                          // Intent que navegara desde EncuestasActivity hacia  SelectActivity.
    DataBaseAppRed database;                        // Instancia de la base de datos utilizado para obtener el municipio de acuerdo a un objeto de tipo trdd_ej_cct.
    ProgressBar pbSelect;                           // Elemnto de la UI que contiene la animacion al hacer click en el boton de reportes.
    int ultimoRegistro = 0;                         // Almacena el ultimo registro de las encuestas encontrado en la bd.

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
        btnReportes = (Button) findViewById(R.id.btn_reportes_encuestas);
        textViewNumeroEncuestas = (TextView) findViewById(R.id.textView_NumerodeEncuestas_Encuestas);
        intentIniciar = new Intent(this, InfoEncuestaActivity.class);
        intentEnviar = new Intent(this, LoadPageActivity.class);
        intentLogout = new Intent(this, MainActivity.class);
        intentRegresar = new Intent(this, SelectActivity.class);
        final AlertDialog.Builder dialogo2 = new AlertDialog.Builder(this);
        pbSelect = (ProgressBar)findViewById(R.id.progressBar_Select);
        database = new DataBaseAppRed(getBaseContext());
        pbSelect.setVisibility(View.GONE);

        Cursor dataCursor = database.getUltimoRegistro();
        dataCursor.moveToNext();
        if (dataCursor.getCount() > 0)
          { // Si existen registros en la BD. (TOP)
              ultimoRegistro = dataCursor.getInt(0);
          } // Si existen registros en la BD. (BOTTOM)
        // Inicializacion de las variables (BOTTOM)

        // Texto informativo de cuantas encuestas se han realizado
        // TODO Agregar una tabla o un metodo para contar encuestas Nota: Hasta que este la version final de la bd.
        textViewNumeroEncuestas.setText("Encuestas Realizadas: " + ultimoRegistro );

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
                parametros.putString("enviadode", "1");         // Envia un 1 para identificar las encuestas.
                intentEnviar.putExtras(parametros);
                    dialogo2.setTitle("Importante").setMessage("Estas por enviar las Encuestas realizadas!!!\n\nEsto requiere conexión a internet.");
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

        btnReportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbSelect.setVisibility(View.VISIBLE); // Muestra la animacion
                new AsyncReportes(EncuestasActivity.this,getApplicationContext(),1).execute();
            }
        });
        // Click listeners de los botones definidos (BOTTOM)
    } // Creacion de la vista (BOTTOM)

    @Override
    protected void onResume() {
        super.onResume();
        pbSelect.setVisibility(View.GONE);
        if (!bolLogeado)
          { // Si el usuario ya nio esta logueado no permite regresar a esta activity (TOP)
              startActivity(intentLogout);
          } // Si el usuario ya nio esta logueado no permite regresar a esta activity (BOTTOM)
    }
}