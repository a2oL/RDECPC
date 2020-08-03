package mx.org.ieem.activity.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.R;
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
    AlertDialog.Builder dialogoUsuarioNoEncontrado;         // Dialogo de alerta de error de autenticacion

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializacion de las variables (TOP)
        btnLogin = (Button) findViewById(R.id.button_Iniciar_Login);
        btnContraseniaOlvidada = (Button) findViewById(R.id.button_UsuarioOlvidado_Login);
        editTextEmail = (EditText) findViewById(R.id.editText_Usuario_Login);
        editTextContrasenia = (EditText) findViewById(R.id.editText_Contrasenia_Login);
        dialogoUsuarioNoEncontrado = new AlertDialog.Builder(this);
        intentContraseniaOlvidada = new Intent(this, RecovPassActivity.class);
        intentUsuarioEncontrado = new Intent(this, SelectActivity.class);
        // Inicializacion de las variables (BOTTOM)

        // Click listeners de los botones definidos (TOP)
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncLogin as = (AsyncLogin) new AsyncLogin(getApplicationContext());
                as.execute(editTextEmail.getText().toString(), editTextContrasenia.getText().toString());
                try
                { // Espera 1seg a que se reciba respuesta del AsyncLogin (TOP)
                    as.get(6000, TimeUnit.MILLISECONDS);
                    if (bolLogeado)
                      { // Si el usuario fue encontrado navega a SelectActivity (TOP)
                          Toast.makeText(getApplicationContext(), "Bienvenido!!!", Toast.LENGTH_SHORT).show();
                          startActivity(intentUsuarioEncontrado);
                      } // Si el usuario fue encontrado navega a SelectActivity (BOTTOM)
                    else
                      { // Mensaje de Error de usuario no encontrado (TOP)
                          dialogoUsuarioNoEncontrado.setTitle("Importante").setMessage("El usuario no existe").setCancelable(false).setPositiveButton("Confirmar", new DialogInterface.OnClickListener()
                          {
                              @Override
                              public void onClick(DialogInterface dialog, int which) {}
                          }).show();
                      } // Mensaje de Error de usuario no encontrado (BOTTOM)
                } // Espera 1seg a que se reciba respuesta del AsyncLogin (BOTTOM)
                catch (ExecutionException | InterruptedException | TimeoutException e)
                { // Exception lanzada de la anulacion del AsyncLogin o cuando el hilo esta esperando,durmiendo u ocupado o cuando se agota el tiempo de espera(TOP)
                    e.printStackTrace();
                } // Exception lanzada de la anulacion del AsyncLogin o cuando el hilo esta esperando,durmiendo u ocupado o cuando se agota el tiempo de espera(BOTTOM)
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
}