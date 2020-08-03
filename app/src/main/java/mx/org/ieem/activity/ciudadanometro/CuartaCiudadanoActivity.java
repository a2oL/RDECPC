package mx.org.ieem.activity.ciudadanometro;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.R;

public class CuartaCiudadanoActivity extends AppCompatActivity {
    Button btnFinalizar;                                // Aloja el elemento de la UI (button_finalizar_four_ciudadano) del activity_cuarta_ciudadano que preguntara si se desea finalizar o no la encuesta.
    Intent intentSi;                                    // Intent que navegara desde CuartaCiudadanoActivity hacia PrimeraCiudadanoActivity.
    Intent intentNo;                                    // Intent que navegara desde CuartaCiudadanoActivity hacia CalendarioAplicacionActivity.
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuarta_ciudadano);

        // Inicializacion de las variables (TOP)
        btnFinalizar = (Button)findViewById(R.id.button_finalizar_four_ciudadano);
        intentSi = new Intent(this, PrimeraCiudadanoActivity.class);
        intentNo = new Intent(this, CalendarioAplicacionActivity.class);
        final AlertDialog.Builder dialogo2 = new AlertDialog.Builder(this);
        // Inicializacion de las variables (BOTTOM)

        // Click listeners de los botones definidos (TOP)
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogo2.setTitle("Importante").setMessage("\nDeseas Seguir aplicando el ciudadanometro?\n\n");
                dialogo2.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(intentSi);
                    }
                });
                dialogo2.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(intentNo);
                    }
                });
                dialogo2.show();
            }
        });
        // Click listeners de los botones definidos (BOTTOM)
    }
}
