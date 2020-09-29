package mx.org.ieem.activity.ciudadanometro;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.R;
import mx.org.ieem.data.sqllite.DataBaseAppRed;
import mx.org.ieem.data.sqllite.models.ciudadanometro.trdd_c_realicador_edad;
import mx.org.ieem.data.sqllite.models.ciudadanometro.trdd_c_realicador_escolaridad;
import mx.org.ieem.data.sqllite.models.ciudadanometro.trdd_c_realicador_genero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class SegundaCiudadanoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerEdad,spinnerEres,spinnerEscolaridad;                                             // Contiene los elemetnos de los spinners de seleccion de edad genero y escolaridad.
    Button btnGuardar;                                                                              // Aloja el elemento de la UI (button_Guardar_Segundaciudadano) del layout activity_segunda_ciudadano que acciona intentTercera.
    Intent intentTercera;                                                                           // Intent que navegara desde SegundaCiudadanoActivity hacie TerceraCiudadanoActivity.
    Cursor cursor_EdadGeneroEscolaridad;                                                            // Contiene el result set de querys realizados por los metodos cargarMeses() o cargarGrados().
    SimpleCursorAdapter simpleCursorAdapter_EdadGeneroEscolaridad;                                  // Determina la manera en la que seran mostrados los datos del cursor_MesEncuesta.
    DataBaseAppRed database;                                                                        // Instancia de la bd.
    public static trdd_c_realicador_edad edad_realicador_final_ciudadanometro;                      // Final que contendra la edad del realizador.
    public static trdd_c_realicador_genero genero_realicador_final_ciudadanometro;                  // Final que contendra el genero del realizador.
    public static trdd_c_realicador_escolaridad escolaridad_realicador_final_ciudadanometro;        // Final que contendra la escolaridad del realizador.

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
        database = new DataBaseAppRed(getBaseContext());
        spinnerEdad.setOnItemSelectedListener(this);
        spinnerEres.setOnItemSelectedListener(this);
        spinnerEscolaridad.setOnItemSelectedListener(this);
        spinnerEdad.setAdapter(cargarEdadRealicador());
        spinnerEres.setAdapter(cargarGeneroRealicador());
        spinnerEscolaridad.setAdapter(cargarEscolaridadRealicador());
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

    public SimpleCursorAdapter cargarEdadRealicador()
    { // Regresa los meses que se encuentran el la tabla trdd_c_realicador_edad (TOP)
        cursor_EdadGeneroEscolaridad=database.getRealicadorEdadCiudadanometroBD();
        simpleCursorAdapter_EdadGeneroEscolaridad =new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor_EdadGeneroEscolaridad, new String[]{"nombre"}, new int[]{android.R.id.text1}, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        simpleCursorAdapter_EdadGeneroEscolaridad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return simpleCursorAdapter_EdadGeneroEscolaridad;
    } // Regresa los meses que se encuentran el la tabla trdd_c_realicador_edad (BOTTOM)


    public SimpleCursorAdapter cargarGeneroRealicador()
    { // Regresa los meses que se encuentran el la tabla trdd_c_realicador_genero (TOP)
        cursor_EdadGeneroEscolaridad=database.getRealicadorGeneroCiudadanometroBD();
        simpleCursorAdapter_EdadGeneroEscolaridad =new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor_EdadGeneroEscolaridad, new String[]{"nombre"}, new int[]{android.R.id.text1}, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        simpleCursorAdapter_EdadGeneroEscolaridad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return simpleCursorAdapter_EdadGeneroEscolaridad;
    } // Regresa los meses que se encuentran el la tabla trdd_c_realicador_genero (BOTTOM)

    public SimpleCursorAdapter cargarEscolaridadRealicador()
    { // Regresa los meses que se encuentran el la tabla trdd_c_realicador_escolaridad (TOP)
        cursor_EdadGeneroEscolaridad=database.getRealicadorEscolaridadCiudadanometroBD();
        simpleCursorAdapter_EdadGeneroEscolaridad =new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor_EdadGeneroEscolaridad, new String[]{"nombre"}, new int[]{android.R.id.text1}, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        simpleCursorAdapter_EdadGeneroEscolaridad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return simpleCursorAdapter_EdadGeneroEscolaridad;
    } // Regresa los meses que se encuentran el la tabla trdd_c_realicador_escolaridad (BOTTOM)

    // Adapatadores de los spinners (BOTTOM)

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    { // LLena las vairables q=estaticas que contendran la edad, genero y escolaridad del realizador (TOP).
        cursor_EdadGeneroEscolaridad = (Cursor) spinnerEdad.getSelectedItem();
        edad_realicador_final_ciudadanometro = new trdd_c_realicador_edad(cursor_EdadGeneroEscolaridad.getInt(cursor_EdadGeneroEscolaridad.getColumnIndexOrThrow("_id")),cursor_EdadGeneroEscolaridad.getString(cursor_EdadGeneroEscolaridad.getColumnIndexOrThrow("nombre")));
        cursor_EdadGeneroEscolaridad = (Cursor) spinnerEres.getSelectedItem();
        genero_realicador_final_ciudadanometro = new trdd_c_realicador_genero(cursor_EdadGeneroEscolaridad.getInt(cursor_EdadGeneroEscolaridad.getColumnIndexOrThrow("_id")),cursor_EdadGeneroEscolaridad.getString(cursor_EdadGeneroEscolaridad.getColumnIndexOrThrow("nombre")));
        cursor_EdadGeneroEscolaridad = (Cursor) spinnerEscolaridad.getSelectedItem();
        escolaridad_realicador_final_ciudadanometro = new trdd_c_realicador_escolaridad(cursor_EdadGeneroEscolaridad.getInt(cursor_EdadGeneroEscolaridad.getColumnIndexOrThrow("_id")),cursor_EdadGeneroEscolaridad.getString(cursor_EdadGeneroEscolaridad.getColumnIndexOrThrow("nombre")));
    } // LLena las vairables q=estaticas que contendran la edad, genero y escolaridad del realizador (BOTTOM).

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
