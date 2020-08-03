package mx.org.ieem.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.activity.main.MainActivity;
import mx.org.ieem.R;

public class RecovPassActivity extends AppCompatActivity {

    Button btnPrincipal;                 // Aloja el elemento de la UI (button_Logout_RecovPass) del layout activity_recov_pass que sirve para regresar a MainActivity.
    Button btnEnviar;                    // Aloja el elemento de la UI (button_Enviar_RecovPass) del layout activity_recov_pass que sirve para iniciar el proceso de recuperacion del usuario y cintrasenia.
    Intent intentRegresarMenu;           // Intent que navegara desde RecovPassActivity hacia MainActivity.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recov_pass);

        // Inicializacion de las variables (TOP)
        btnPrincipal = (Button)findViewById(R.id.button_Logout_RecovPass);
        btnEnviar = (Button)findViewById(R.id.button_Enviar_RecovPass);
        intentRegresarMenu = new Intent(this, MainActivity.class);
        // Inicializacion de las variables (BOTTOM)

        // Click listeners de los botones definidos (TOP)
        btnPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentRegresarMenu);
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Tus datos de acceso han sido enviados a tu correo", Toast.LENGTH_SHORT).show();
            }
        });
        // Click listeners de los botones definidos (BOTTOM)
    }
}
