package mx.org.ieem.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.RESTful.AsyncLoadPage;
import mx.org.ieem.R;
import mx.org.ieem.activity.main.SelectActivity;

public class LoadPageActivity extends AppCompatActivity {





    // Falta por documentar ya que aun no hace nada solo usa un contador para simular un envio de datos







    Button btn;
    private ProgressBar progressBar;
    TextView txt;
    Integer count =1;
    String enviadode;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_page);
        Bundle parametros = this.getIntent().getExtras();
        enviadode=parametros.getString("enviadode");

        txt = (TextView)findViewById(R.id.textView_enviando_load_page);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_load_page);
        btn = (Button)findViewById(R.id.button_aceptar_load_page);
        progressBar.setMax(10);
        count =1;
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(0);
        new AsyncLoadPage(progressBar,txt,count,btn).execute(10);
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
