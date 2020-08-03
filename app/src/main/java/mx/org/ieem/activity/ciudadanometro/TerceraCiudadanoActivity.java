package mx.org.ieem.activity.ciudadanometro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.R;

public class TerceraCiudadanoActivity extends AppCompatActivity
{
    TextView textViewRetro;                     // Contiene el texto que se mostrara como retroalimentacion.
    Button btnSiguiente;                        // Aloja el elemto de la UI (button_siguiente_third_ciudadano) que sirve para accionar el intentCuarta.
    Intent intentCuarta;                        // Intent que navegara desde TerceraCiudadanoActivity hacia  CuartaActivity.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera_ciudadano);

        // Inicializacion de las variables (TOP)
        textViewRetro = (TextView)findViewById(R.id.textRetroalimentacion);
        btnSiguiente = (Button)findViewById(R.id.button_siguiente_third_ciudadano);
        textViewRetro.setText("El ejercicio de tu ciudadanía se ubica en un nivel básico, ¡Descubre cómo incrementarlo!\n" +
                "La construcción de una sociedad más justa y pacífica es una aspiración de todas y todos, así como lograr la atención de los problemas que aquejan a nuestra comunidad y mejorar nuestra calidad de vida, lo cual es posible mediante el cumplimiento de la ley, el voto, el derecho de acceso a la información pública, participar en espacios públicos de diálogo, ejercer el derecho de petición, de denuncia y actuar de forma organizada; descubre cómo puedes lograrlo.\n" +
                "En el mini sitio de la Dirección de Participación Ciudadana del Instituto Electoral del Estado de México te brindamos más información y acceso a diversos sitios electrónicos que te permitirán saber cómo puedes ejercer de forma real y efectiva tus derechos, así como acceso a portales de denuncia, atención ciudadana y de contacto con diversas instancias de protección.\n");
        intentCuarta = new Intent(this, CuartaCiudadanoActivity.class);
        // Inicializacion de las variables (BOTTOM)

        // Click listeners de los botones definidos (TOP)
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCuarta);
            }
        });
        // Click listeners de los botones definidos (BOTTOM)
    }
}
