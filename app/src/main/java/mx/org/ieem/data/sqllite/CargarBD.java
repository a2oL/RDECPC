package mx.org.ieem.data.sqllite;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CargarBD {
    Context contextActual;                                  // Contexto del activity que ejecuto la tarea en segundo plano (LoginActivity).
    DataBaseAppRed database;                                // Instancia de la base de datos utilizado para obtener el municipio de acuerdo a un objeto de tipo trdd_cct.

    public CargarBD(Context contextActuall) throws IOException, JSONException {
        this.contextActual = contextActuall;
        database = new DataBaseAppRed(contextActuall);
        cargartmunicipio();
    }

    public void cargartmunicipio() throws IOException, JSONException {

        BufferedReader r = new BufferedReader(new InputStreamReader(contextActual.getAssets().open("bd.txt")));
        StringBuilder total = new StringBuilder();
        for (String line; (line = r.readLine()) != null; ) {
            total.append(line).append('\n');
        }
        JSONObject baseDeDatos = new JSONObject(total.toString());
        JSONArray tmunicipio = baseDeDatos.getJSONArray("tmunicipio");

        for (int i = 0; i < tmunicipio.length(); i++) {
            JSONObject jsonobject = tmunicipio.getJSONObject(i);
            int id_municipio = jsonobject.getInt("id_municipio");
            String nombre = jsonobject.getString("nombre");
            database.insertarTMunicipio(id_municipio,nombre);
            Log.e("tmunicipio", "id: "+id_municipio+" nombre: "+nombre);
        }

    }
}
