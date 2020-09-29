package mx.org.ieem.activity.login;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
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
    ProgressBar pbLogin;                                    // Elemento de la UI que mostrara animacion despues de clickeado el boton Loguear.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
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
                final boolean hayinternet = isOnlineNet();          // Variable local que regresa un valor booleano deacuerdo a la existencia de conexion a internet
                final boolean[] hayConexion = {true};               // Variable local que nos dice si tenemos acceso a internet.
                final boolean[] usarioEncontrado = {true};          // Variable local que nos dice si el usaurio fue encontrado.
                pbLogin.setVisibility(View.VISIBLE);                // Se encarga de mostrar el Progressbar En la UI.
                new Thread(new Runnable()
                { // Tarea Asincrona para realizar el proceso de logueo. (TOP)
                    @Override
                    public void run() {
                        if (hayinternet)
                        { // Si hay internet entonces. (TOP)
                            AsyncLogin as = (AsyncLogin) new AsyncLogin(getApplicationContext(), pbLogin);
                            as.execute(editTextEmail.getText().toString(), editTextContrasenia.getText().toString());
                            try { // Espera 1seg a que se reciba respuesta del AsyncLogin (TOP)
                                as.get(10000, TimeUnit.MILLISECONDS);
                                if (bolLogeado) { // Si el usuario fue encontrado navega a SelectActivity (TOP)
                                    startActivity(intentUsuarioEncontrado);
                                } // Si el usuario fue encontrado navega a SelectActivity (BOTTOM)
                                else { // Mensaje de Error de usuario no encontrado (TOP)
                                    usarioEncontrado[0] = false;
                                } // Mensaje de Error de usuario no encontrado (BOTTOM)
                            } // Espera 1seg a que se reciba respuesta del AsyncLogin (BOTTOM)
                            catch (TimeoutException e) { // Exception lanzada de la anulacion del AsyncLogin o cuando el hilo esta esperando,durmiendo u ocupado o cuando se agota el tiempo de espera(TOP)
                                hayConexion[0] = false;
                            } // Exception lanzada de la anulacion del AsyncLogin o cuando el hilo esta esperando,durmiendo u ocupado o cuando se agota el tiempo de espera(BOTTOM)
                            catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }
                        } // Si hay internet entonces. (BOTTOM)
                        runOnUiThread(new Runnable() {
                            public void run() {
                                if (!hayinternet)
                                  { // Si no hay conexion a internet ya sea datos celulares o WIFI. (TOP)
                                      pbLogin.setVisibility(View.GONE);
                                      Toast.makeText(LoginActivity.this, "No hay conexion a internet", Toast.LENGTH_SHORT).show();
                                  } // Si no hay conexion a internet ya sea datos celulares o WIFI. (TOP)
                                else
                                  {
                                      if (!hayConexion[0])
                                        { // Si hay conexion a internet pero no hay acceso a internet. (TOP)
                                            pbLogin.setVisibility(View.GONE);
                                            Toast.makeText(LoginActivity.this, "Comprueba tu conexion a internet\n Servidor no responde", Toast.LENGTH_SHORT).show();
                                        } // Si hay conexion a internet pero no hay acceso a internet. (BOTTOM)
                                      else
                                        {
                                            if (!usarioEncontrado[0])
                                              { // Si hay conexion a internet y acceso a internet pero no se encontro el usuario. (TOP)
                                                  pbLogin.setVisibility(View.GONE);
                                                  Toast.makeText(LoginActivity.this, "El usuario no fue encontrado", Toast.LENGTH_SHORT).show();
                                              } // Si hay conexion a internet y acceso a internet pero no se encontro el usuario. (BOTTOM)
                                        }
                                  }
                            }
                        });
                    }
                    // Tarea Asincrona para realizar el proceso de logueo. (BOTTOM)
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
        if (bolLogeado)
          { // Si el usuario permanece logueado. (TOP)
              startActivity(usuarioLogeado);
          } // Si el usuario permanece logueado. (BOTTOM)
    }

    public Boolean isOnlineNet() {
        ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        Log.e("Is connected",Boolean.toString(isConnected));
        return isConnected;
    }
}