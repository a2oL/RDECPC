package mx.org.ieem.data.sqllite;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import mx.org.ieem.data.DataBaseAppRed;

public class CargarBD {
    Context contextActual;                                  // Contexto del activity que ejecuto la tarea en segundo plano (LoginActivity).
    DataBaseAppRed database;                    // Instancia de la base de datos utilizado para obtener el municipio de acuerdo a un objeto de tipo trdd_cct.

    public CargarBD(Context contextActuall) throws IOException, JSONException {
        this.contextActual = contextActuall;
        database = new DataBaseAppRed(contextActuall);
        cargartmunicipio();
    }

    public void cargartmunicipio() throws IOException, JSONException {
        BufferedReader r = new BufferedReader(new InputStreamReader(contextActual.getAssets().open("tmunicipio.txt")));
        StringBuilder total = new StringBuilder();
        for (String line; (line = r.readLine()) != null; ) {
            total.append(line).append('\n');
        }
        JSONArray jsonarray = new JSONArray(total.toString());
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            int id_municipio = jsonobject.getInt("id_municipio");
            String nombre = jsonobject.getString("nombre");
            database.insertarTMunicipio(id_municipio,nombre);
            Log.e("tmunicipio", "id: "+id_municipio+" nombre: "+nombre);
        }

    }
}
