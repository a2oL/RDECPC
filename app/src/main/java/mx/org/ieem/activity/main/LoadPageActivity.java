package mx.org.ieem.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import mx.org.ieem.RESTful.AsyncLoadPage;
import mx.org.ieem.R;

import static mx.org.ieem.R.drawable.ic_logo_ciudadanometro;
import static mx.org.ieem.R.drawable.ic_logo_encuesta_infantil;

public class LoadPageActivity extends AppCompatActivity
{
    ImageView logo;
    Button btn;
    private ProgressBar progressBar;
    TextView txt;
    Integer count =1;
    String enviadode;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_page);

        logo = (ImageView) findViewById(R.id.imageView_logo_load_page);
        txt = (TextView)findViewById(R.id.textView_enviando_load_page);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_load_page);
        btn = (Button)findViewById(R.id.button_aceptar_load_page);
        progressBar.setMax(10);

        Bundle parametros = this.getIntent().getExtras();
        enviadode =parametros.getString("enviadode");
        if (enviadode.equals("1"))
        {
            logo.setImageResource(ic_logo_encuesta_infantil);

        }else{
            logo.setImageResource(ic_logo_ciudadanometro);
        }
        count =1;
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(0);
        try {
            new AsyncLoadPage(this,progressBar,txt,count,btn,enviadode).execute(10);
        } catch (JSONException | IOException | CertificateException | NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            e.printStackTrace();
        }
        btn.setVisibility(View.GONE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(enviadode.contentEquals("1")){
                    onAceptarClick();
                }else{
                    onAceptar2Click();
                }

            }
        });
    }

    public void onAceptarClick(){
        Intent intent = new Intent(this, SelectActivity.class);
        startActivity(intent);
    }

    public void onAceptar2Click(){
        Intent intent = new Intent(this, SelectActivity.class);
        startActivity(intent);
    }

}
