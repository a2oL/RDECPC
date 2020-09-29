package mx.org.ieem.activity.main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import mx.org.ieem.RESTful.AsyncEventosConcursos;
import mx.org.ieem.activity.eventos.EventosActivity;
import mx.org.ieem.activity.login.LoginActivity;

import mx.org.ieem.R;

import static mx.org.ieem.RESTful.AsyncLogin.actual_final;
import static mx.org.ieem.RESTful.AsyncLogin.id_cct_final;
import static mx.org.ieem.RESTful.AsyncLogin.bolLogeado;
import static mx.org.ieem.RESTful.AsyncLogin.id_random_final;

import mx.org.ieem.data.sqllite.DataBaseAppRed;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_cct;


public class MainActivity extends AppCompatActivity {

    Button btnEncuestasCiudadano;           // Aloja el elemento de la UI (button_EncuestasCiudadano_Main) del layout activity_main que activara el intentLogin.
    Button btnFacebook;                     // Aloja el elemento de la UI (button_Fb_Main) del layout activity_main contendra enlace a pagina de FACEBOOK.
    Button btnTwiter;                       // Aloja el elemento de la UI (button_Tw_Main) del layout activity_main contendra enlace a pagina de TWITER.
    Button btnInstagram;                    // Aloja el elemento de la UI (button_Insta_Main) del layout activity_main contendra enlace a pagina de INSTAGRAM.
    Button btnYoutube;                      // Aloja el elemento de la UI (button_Yt_Main) del layout activity_main contendra enlace a pagina de YOUTUBE.
    Button btnEventos;                      // Aloja el elemento de la UI (button_Eventos_Main) del layout activity_main contendra enlace a pagina de EVENTOS Y CONCURSOS.
    Button btnDpc;                          // Aloja el elemento de la UI (button_Dpc_Main) del layout activity_main contendra enlace a minisitio DPC.
    ProgressBar pb;                         // Aloja el elemto de la UI(progressBar_Main) que muestra el circulo girando al centro.
    Intent intentLogin;                     // Intent que navegara desde el MainActivity a el LoginActivity.
    Intent intentSelect;                    // Intent que navegara desde el MainActivity a el SelectActivity.
    Intent intentEventos;                   // Intent que navegara desde el MainActivity a el EventosActivity.


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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
        pb = (ProgressBar)findViewById(R.id.progressBar_Main);
        pb.setVisibility(View.GONE);

        intentLogin = new Intent(this, LoginActivity.class);
        intentSelect = new Intent(this, SelectActivity.class);
        intentEventos = new Intent(this, EventosActivity.class);
        // Inicializacion de las variables (BOTTOM)

        // Click listeners de los botones definidos (TOP)
        btnEncuestasCiudadano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usuarioExiste())
                  { // Si el usuario existe redirige a SelectActiviy. (TOP)
                      startActivity(intentSelect);
                  } // Si el usuario existe redirige a SelectActiviy. (BOTTOM)
                else
                  { // Si el usuario no existe redirige a LoginActiviy. (TOP)
                      startActivity(intentLogin);
                  } // Si el usuario no existe redirige a LoginActiviy. (BOTTOM)
            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/IEEMoficial"));
                startActivity(browserIntent);
            }
        });

        btnTwiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/ieem_mx"));
                startActivity(browserIntent);
            }
        });

        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/ieem_mx"));
                startActivity(browserIntent);
            }
        });

        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/YoshiVoto"));
                startActivity(browserIntent);
            }
        });

        btnEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncEventosConcursos(getApplicationContext(), MainActivity.this).execute();
                pb.setVisibility(View.VISIBLE);
            }
        });

        btnDpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ieem.org.mx/DPC/index.html"));
                startActivity(browserIntent);
            }
        });
        // Click listeners de los botones definidos (BOTTOM)
    }

    /**
     * Método que busca si hay algun usario logueado en la bd
     * y llena las variables globales para poder ser accedidas por las Activities que las ocupen.
     */
    public boolean usuarioExiste()
    {
        DataBaseAppRed ds = new DataBaseAppRed(this);       // Instancia de la bd.
        Cursor usuario = ds.getUsuarioLogueado();                   // ResultSet de la consulta  a la bd.
        usuario.moveToNext();
        if (usuario.getCount() > 0)
          { // Si existe algun registro en la bd (TOP)
              bolLogeado = true;
              actual_final = new trdd_cct(usuario.getString(0),usuario.getString(1),usuario.getString(2),usuario.getString(3),usuario.getInt(4),usuario.getInt(5),usuario.getString(6));
              id_cct_final = actual_final.getId_cct();
              id_random_final = ds.getIdRandomDispositivo();
              return  true;
          } // Si existe algun registro en la bd (BOTTOM)
        else
          { // Si no existe regresa falso para iniciar el proceso de logueo. (TOP)
              return false;
          } // Si no existe regresa falso para iniciar el proceso de logueo. (BOTTOM)
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        pb.setVisibility(View.GONE); // Oculta el progressBar Ciurcular
    }
}