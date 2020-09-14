package mx.org.ieem.activity.login;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.R;
import mx.org.ieem.activity.main.MainActivity;
import mx.org.ieem.activity.main.SelectActivity;
import mx.org.ieem.RESTful.AsyncLogin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static mx.org.ieem.RESTful.AsyncLogin.bolLogeado;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;                                        // Aloja el elemento de la UI (button_Iniciar_Login) del layout activity_login que sirve para iniciar el proceso de logueado.
    Button btnContraseniaOlvidada;                          // Aloja el elemento de la UI (button_UsuarioOlvidado_Login) del layout activity_login que sirve para inciciar el RecovPassActivity.
    EditText editTextEmail;                                 // Aloja el email escrito por el usuario del elemento (editText_Usuario_Login) del layout activity_login
    EditText editTextContrasenia;                           // Aloja el email escrito por el usuario del elemento (editText_Contrasenia_Login) del layout activity_login
    Intent intentContraseniaOlvidada;                       // Intent que navegara desde LoginActivity hacia RecovPassActivity.
    Intent intentUsuarioEncontrado;                         // Intent que navegara desde LoginActivity hacie SelectActivity.
    Intent usuarioLogeado;                                  // Intent que navegara desde LoginActivity hacie MainActivity.
    //AlertDialog.Builder dialogoUsuarioNoEncontrado;         // Dialogo de alerta de error de autenticacion
    ProgressBar pbLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializacion de las variables (TOP)
        btnLogin = (Button) findViewById(R.id.button_Iniciar_Login);
        btnContraseniaOlvidada = (Button) findViewById(R.id.button_UsuarioOlvidado_Login);
        editTextEmail = (EditText) findViewById(R.id.editText_Usuario_Login);
        editTextContrasenia = (EditText) findViewById(R.id.editText_Contrasenia_Login);
       // dialogoUsuarioNoEncontrado = new AlertDialog.Builder(this);
        intentContraseniaOlvidada = new Intent(this, RecovPassActivity.class);
        intentUsuarioEncontrado = new Intent(this, SelectActivity.class);
        usuarioLogeado = new Intent(this, MainActivity.class);
        pbLogin = (ProgressBar) findViewById(R.id.progressBarLogind);
        pbLogin.setVisibility(View.GONE);
        // Inicializacion de las variables (BOTTOM)
        // Click listeners de los botones definidos (TOP)
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                final boolean hayinternet = isOnlineNet();
                final boolean[] hayConexion = {true};
                final boolean[] usarioEncontrado = {true};
                pbLogin.setVisibility(View.VISIBLE);
                new Thread(new Runnable()
                {
                    @Override
                    public void run() {
                        if (hayinternet)
                        {
                            AsyncLogin as = (AsyncLogin) new AsyncLogin( getApplicationContext(), pbLogin );
                            as.execute(editTextEmail.getText().toString(), editTextContrasenia.getText().toString());
                            try { // Espera 1seg a que se reciba respuesta del AsyncLogin (TOP)
                                as.get(10000, TimeUnit.MILLISECONDS);
                                if (bolLogeado)
                                { // Si el usuario fue encontrado navega a SelectActivity (TOP)
                                    startActivity(intentUsuarioEncontrado);
                                } // Si el usuario fue encontrado navega a SelectActivity (BOTTOM)
                                else
                                    { // Mensaje de Error de usuario no encontrado (TOP)
                                    usarioEncontrado[0] = false;
                                } // Mensaje de Error de usuario no encontrado (BOTTOM)
                            } // Espera 1seg a que se reciba respuesta del AsyncLogin (BOTTOM)
                            catch (TimeoutException e) { // Exception lanzada de la anulacion del AsyncLogin o cuando el hilo esta esperando,durmiendo u ocupado o cuando se agota el tiempo de espera(TOP)
                                hayConexion[0] = false;
                            } // Exception lanzada de la anulacion del AsyncLogin o cuando el hilo esta esperando,durmiendo u ocupado o cuando se agota el tiempo de espera(BOTTOM)
                            catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }
                        }
                        else{

                            //
                        }

                        runOnUiThread(new Runnable() {
                            public void run() {
                                if (!hayinternet)
                                {
                                    pbLogin.setVisibility(View.GONE);
                                    Toast.makeText(LoginActivity.this, "No hay conexion a internet", Toast.LENGTH_SHORT).show();
                                }else
                                {
                                    if(!hayConexion[0])
                                    {
                                        pbLogin.setVisibility(View.GONE);
                                        Toast.makeText(LoginActivity.this, "Comprueba tu conexion a internet\n Servidor no responde", Toast.LENGTH_SHORT).show();
                                    }else
                                    {
                                        if(!usarioEncontrado[0])
                                        {
                                            pbLogin.setVisibility(View.GONE);
                                            Toast.makeText(LoginActivity.this, "El usuario no fue encontrado", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }
                        });
                    }


                }).start();
            }
        });

        btnContraseniaOlvidada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentContraseniaOlvidada);
            }
        });
        // Click listeners de los botones definidos (BOTTOM)
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (bolLogeado){
            startActivity(usuarioLogeado);
        }
    }

    public Boolean isOnlineNet() {
        ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        Log.e("Is connected",Boolean.toString(isConnected));
        return isConnected;
    }

    public void mostrarMensaje(Context con,String title, String Message, String positiveMessage)
    {
        AlertDialog.Builder dialogoUsuarioNoEncontrado;
         dialogoUsuarioNoEncontrado = new AlertDialog.Builder(con);
         dialogoUsuarioNoEncontrado.setTitle(title).setMessage(Message).setCancelable(false).setPositiveButton(positiveMessage, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        }).show();
    }
}