package mx.org.ieem.activity.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import mx.org.ieem.activity.login.LoginActivity;

import mx.org.ieem.R;


public class MainActivity extends AppCompatActivity {

    Button btnEncuestasCiudadano;           // Aloja el elemento de la UI (button_EncuestasCiudadano_Main) del layout activity_main que activara el intentLogin.
    Button btnFacebook;                     // Aloja el elemento de la UI (button_Fb_Main) del layout activity_main contendra enlace a pagina de FACEBOOK.
    Button btnTwiter;                       // Aloja el elemento de la UI (button_Tw_Main) del layout activity_main contendra enlace a pagina de TWITER.
    Button btnInstagram;                    // Aloja el elemento de la UI (button_Insta_Main) del layout activity_main contendra enlace a pagina de INSTAGRAM.
    Button btnYoutube;                      // Aloja el elemento de la UI (button_Yt_Main) del layout activity_main contendra enlace a pagina de YOUTUBE.
    Button btnEventos;                      // Aloja el elemento de la UI (button_Eventos_Main) del layout activity_main contendra enlace a pagina de EVENTOS Y CONCURSOS.
    Button btnDpc;                          // Aloja el elemento de la UI (button_Dpc_Main) del layout activity_main contendra enlace a minisitio DPC.
    Intent intentLogin;                     // Intent que navegara desde el MainActivity a el LoginActivity.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializacion de las variables (TOP)
        btnEncuestasCiudadano = (Button) findViewById(R.id.button_EncuestasCiudadano_Main);
        btnFacebook = (Button)findViewById(R.id.button_Fb_Main);
        btnTwiter = (Button)findViewById(R.id.button_Tw_Main);
        btnInstagram = (Button)findViewById(R.id.button_Insta_Main);
        btnYoutube = (Button)findViewById(R.id.button_Yt_Main);
        btnEventos = (Button)findViewById(R.id.button_Eventos_Main);
        btnDpc = (Button)findViewById(R.id.button_Dpc_Main);
        intentLogin = new Intent(this, LoginActivity.class);
        // Inicializacion de las variables (BOTTOM)

        // Click listeners de los botones definidos (TOP)
        btnEncuestasCiudadano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(intentLogin);
            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Toast.makeText(getApplicationContext(), "Pagina de facebook", Toast.LENGTH_SHORT).show();
            }
        });

        btnTwiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Toast.makeText(getApplicationContext(), "Pagina de twitter", Toast.LENGTH_SHORT).show();
            }
        });

        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Toast.makeText(getApplicationContext(), "Pagina de instagram", Toast.LENGTH_SHORT).show();
            }
        });

        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Toast.makeText(getApplicationContext(), "Pagina de youtube", Toast.LENGTH_SHORT).show();
            }
        });

        btnEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Toast.makeText(getApplicationContext(), "Pagina de eventos y concursos", Toast.LENGTH_SHORT).show();
            }
        });

        btnDpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Toast.makeText(getApplicationContext(), "Pagina de DPC", Toast.LENGTH_SHORT).show();
            }
        });
        // Click listeners de los botones definidos (BOTTOM)
    }
}