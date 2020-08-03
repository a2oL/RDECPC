package mx.org.ieem.activity.ciudadanometro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class SegundaCiudadanoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerEdad,spinnerEres,spinnerEscolaridad;                                             // Contiene los elemetnos de los spinners de seleccion de edad genero y escolaridad.
    Button btnGuardar;                                                                              // Aloja el elemento de la UI (button_Guardar_Segundaciudadano) del layout activity_segunda_ciudadano que acciona intentTercera.
    Intent intentTercera;                                                                           // Intent que navegara desde SegundaCiudadanoActivity hacie TerceraCiudadanoActivity.
    String[] strAuxiliar;                                                                           // Auxiliar para poder cargar la edad genero y escolaridad a los spinners
    List<String> listAuxiliar = new ArrayList<>();                                                  // Auxiliar para mostrar los datos del strAuxiliar.

    static String stringEdadSeleccionado,stringEresSeleccionado,stringEscolaridadSeleccionado;      // Almacenan las respuestas seleccionadas

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_ciudadano);

        // Inicializacion de las variables (TOP)
        spinnerEdad = (Spinner) findViewById(R.id.spinner_Edad_Segundaciudadano);
        spinnerEres = (Spinner)findViewById(R.id.spinner_Eres_SegundaCiudadano);
        spinnerEscolaridad = (Spinner) findViewById(R.id.spinner_Escolaridad_Segundaciudadano);
        btnGuardar = (Button)findViewById(R.id.button_Guardar_Segundaciudadano);
        intentTercera = new Intent(this, TerceraCiudadanoActivity.class);
        spinnerEdad.setOnItemSelectedListener(this);
        spinnerEres.setOnItemSelectedListener(this);
        spinnerEscolaridad.setOnItemSelectedListener(this);
        spinnerEdad.setAdapter(spinEdad());
        spinnerEres.setAdapter(spinEres());
        spinnerEscolaridad.setAdapter(spinEscolaridad());
        // Inicializacion de las variables (BOTTOM)

        // Click listeners de los botones definidos (TOP)
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentTercera);
            }
        });
        // Inicializacion de las variables (BOTTOM)
    }

    // Adapatadores de los spinners (TOP)
    public ArrayAdapter<String> spinEdad()
    {
        // TODO Cambiar por elementos de la bd
        listAuxiliar = new ArrayList<>();
        strAuxiliar = new String[] {"1.- Menos de 18 años", "2.- De 18 a 29 años", "3.- De 30 a 45 años", "4.- De 46 a 60 años"};
        Collections.addAll(listAuxiliar, strAuxiliar);
        return new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, listAuxiliar);
    }

    public ArrayAdapter<String> spinEres()
    {
        // TODO Cambiar por elementos de la bd
        listAuxiliar = new ArrayList<>();
        strAuxiliar = new String[] {"1.- Mujer", "2.- Hombre", "3.- Otro"};
        Collections.addAll(listAuxiliar, strAuxiliar);
        return new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, listAuxiliar);
    }
    public ArrayAdapter<String> spinEscolaridad()
    {
        // TODO Cambiar por elementos de la bd
        listAuxiliar = new ArrayList<>();
        strAuxiliar = new String[] {"1.- Solo leer y escribir", "2.- Hasta primaria y/o secundaria", "3.- Hasta preparatoria","4.- Hasta licenciatura o postgrado"};
        Collections.addAll(listAuxiliar, strAuxiliar);
        return new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, listAuxiliar);
    }
    // Adapatadores de los spinners (BOTTOM)

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        stringEdadSeleccionado = spinnerEdad.getSelectedItem().toString();
        stringEresSeleccionado = spinnerEres.getSelectedItem().toString();
        stringEscolaridadSeleccionado = spinnerEscolaridad.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
