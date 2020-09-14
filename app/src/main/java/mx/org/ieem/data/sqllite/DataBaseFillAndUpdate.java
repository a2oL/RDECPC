package mx.org.ieem.data.sqllite;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import mx.org.ieem.RESTful.JSONModels.ResponseLogin.ResponseLogin;
import mx.org.ieem.data.sqllite.models.ciudadanometro.*;
import mx.org.ieem.data.sqllite.models.encuestaj.*;
import mx.org.ieem.data.sqllite.models.eventos.trdd_estatus_concurso_o_evento;

import static mx.org.ieem.data.sqllite.constants.ciudadanometro.CamposyTablasCiudadano.*;
import static mx.org.ieem.data.sqllite.constants.encuestasj.CamposyTablasEncuestas.*;

public class DataBaseFillAndUpdate {

    public DataBaseFillAndUpdate(String response, Context context) throws JSONException {
        cargarRespuestaVersiones(response.toString(), context);
    }

    public void cargarRespuestaVersiones(String response, Context contextActual ) throws JSONException
    {
        DataBaseAppRed ds = new DataBaseAppRed(contextActual);                //Instancia de la base de datos.

        JSONObject respuestaVersiones = new JSONObject(response);


        if(respuestaVersiones.has(TABLE_NAME_ESTATUS_CONCURSO_O_EVENTO))
        {
            ds.deleteEstatusEventos();
            JSONArray trdd_estatus_concurso_o_eventos = respuestaVersiones.getJSONArray(TABLE_NAME_ESTATUS_CONCURSO_O_EVENTO);
            for (int i = 0 ; i < trdd_estatus_concurso_o_eventos.length();i++)
            {
                JSONObject estatusEvento = trdd_estatus_concurso_o_eventos.getJSONObject(i);
                int id_municipio = estatusEvento.getInt("id_estatus_coneve");
                String nombre = estatusEvento.getString("nombre");
                ds.insertEstatusEvento(new trdd_estatus_concurso_o_evento(id_municipio,nombre));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_TMUNICIPIO))
        {
            ds.deleteMunicipio();
            JSONArray trdd_anio = respuestaVersiones.getJSONArray(TABLE_NAME_TMUNICIPIO);
            for (int i = 0 ; i< trdd_anio.length();i++)
            {
                JSONObject mes = trdd_anio.getJSONObject(i);
                int id_municipio = mes.getInt("id_municipio");
                String nombre = mes.getString("nombre");
                ds.insertMunicipioActual(new trdd_municipio(id_municipio,nombre));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_NIVEL_EDUCATIVO))
        {
            ds.deleteNivelEducativo();
            JSONArray trdd_anio = respuestaVersiones.getJSONArray(TABLE_NAME_NIVEL_EDUCATIVO);
            for (int i = 0 ; i< trdd_anio.length();i++)
            {
                JSONObject mes = trdd_anio.getJSONObject(i);
                int id_nivel_educativo = mes.getInt("id_nivel_educativo");
                String nombre = mes.getString("nombre");
                ds.insertNivelEducativoActual(new trdd_nivel_educativo(id_nivel_educativo,nombre));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_ANIOS))
        {
            ds.deleteAnios();
            JSONArray trdd_anio = respuestaVersiones.getJSONArray(TABLE_NAME_ANIOS);
            for (int i = 0 ; i< trdd_anio.length();i++)
            {
                JSONObject anio = trdd_anio.getJSONObject(i);
                String id_anio = anio.getString("id_anio");
                ds.insertAnios(new trdd_ej_anio(id_anio));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_MES))
        {
            ds.deleteMeses();
            JSONArray trdd_anio = respuestaVersiones.getJSONArray(TABLE_NAME_MES);
            for (int i = 0 ; i< trdd_anio.length();i++)
            {
                JSONObject mes = trdd_anio.getJSONObject(i);
                int id_mes = mes.getInt("id_mes");
                String nombre = mes.getString("nombre");
                ds.insertMeses(new trdd_ej_mes(id_mes,nombre));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_MES_ANIO))
        {
            ds.deleteAniosMeses();
            JSONArray trdd_anio = respuestaVersiones.getJSONArray(TABLE_NAME_MES_ANIO);
            for (int i = 0 ; i< trdd_anio.length();i++)
            {
                JSONObject anioMes = trdd_anio.getJSONObject(i);
                String id_anio = anioMes.getString("id_anio");
                int id_mes = anioMes.getInt("id_mes");
                ds.insertAniosMeses(new trdd_ej_anio_mes(id_anio,id_mes));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_GRADO_ESCOLAR))
        {
            ds.deleteGradoEscolar();
            JSONArray trdd_anio = respuestaVersiones.getJSONArray(TABLE_NAME_GRADO_ESCOLAR);
            for (int i = 0 ; i < trdd_anio.length() ; i++)
            {
                JSONObject gradoEscolar = trdd_anio.getJSONObject(i);
                int id_grado_escolar = gradoEscolar.getInt("id_grado_escolar");
                String nombre = gradoEscolar.getString("nombre");
                String siglas = gradoEscolar.getString("siglas");
                String grado = gradoEscolar.getString("grado");
                ds.insertGradoEscolar(new trdd_ej_grado_escolar(id_grado_escolar,nombre,siglas,grado));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_NIED_GRES))
        {
            ds.deleteNiedGres();
            JSONArray trdd_nied_gres = respuestaVersiones.getJSONArray(TABLE_NAME_NIED_GRES);
            for (int i = 0 ; i< trdd_nied_gres.length();i++)
            {
                JSONObject niedGres = trdd_nied_gres.getJSONObject(i);
                int id_nivel_educativo = niedGres.getInt("id_nivel_educativo");
                int id_grado_escolar = niedGres.getInt("id_grado_escolar");
                ds.insertNiedGres(new trdd_ej_nied_gres(id_nivel_educativo,id_grado_escolar));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_INDICADOR))
        {
            ds.deleteIndicador();
            JSONArray trdd_indicador = respuestaVersiones.getJSONArray(TABLE_NAME_INDICADOR);
            for (int i = 0 ; i< trdd_indicador.length();i++)
            {
                JSONObject indicador = trdd_indicador.getJSONObject(i);
                int id_nivel_educativo = indicador.getInt("id_indicador");
                String nombre = indicador.getString("nombre");
                ds.insertIndicador(new trdd_ej_indicador(id_nivel_educativo,nombre));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_NIV_IND))
        {
            ds.deleteNivEduIndicador();
            JSONArray trdd_nivedu_ind = respuestaVersiones.getJSONArray(TABLE_NAME_NIV_IND);
            for (int i = 0 ; i< trdd_nivedu_ind.length();i++)
            {
                JSONObject indicador = trdd_nivedu_ind.getJSONObject(i);
                int id_nivel_educativo = indicador.getInt("id_nivel_educativo");
                int id_indicador = indicador.getInt("id_indicador");
                ds.insertNivelIndicador(new trdd_ej_nivedu_ind(id_nivel_educativo,id_indicador));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_PREGUNTA))
        {
            ds.deletePreguntas();
            JSONArray trdd_pregunta = respuestaVersiones.getJSONArray(TABLE_NAME_PREGUNTA);
            for (int i = 0 ; i< trdd_pregunta.length();i++)
            {
                JSONObject pregunta = trdd_pregunta.getJSONObject(i);
                String id_anio = pregunta.getString("id_anio");
                int id_mes = pregunta.getInt("id_mes");
                int id_nivel_educativo = pregunta.getInt("id_nivel_educativo");
                int id_indicador = pregunta.getInt("id_indicador");
                String preguntaC = pregunta.getString("pregunta");
                ds.insertPregunta(new trdd_ej_pregunta(id_anio,id_mes,id_nivel_educativo,id_indicador,preguntaC));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_ESTATUS_RESPUESTA))
        {
            ds.deleteEstatusRespuesta();
            JSONArray trdd_estatus_respuesta = respuestaVersiones.getJSONArray(TABLE_NAME_ESTATUS_RESPUESTA);
            for (int i = 0 ; i< trdd_estatus_respuesta.length();i++)
            {
                JSONObject indicador = trdd_estatus_respuesta.getJSONObject(i);
                int id_estatus_respuesta = indicador.getInt("id_estatus_respuesta");
                String nombre = indicador.getString("nombre");
                ds.insertEstatusRespuesta(new trdd_ej_estatus_respuesta(id_estatus_respuesta,nombre));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_PREGUNTA_RESPUESTA))
        {
            ds.deletePreguntaRespuesta();
            JSONArray trdd_pregunta_respuesta = respuestaVersiones.getJSONArray(TABLE_NAME_PREGUNTA_RESPUESTA);
            for (int i = 0 ; i< trdd_pregunta_respuesta.length();i++)
            {
                JSONObject preguntaRespuesta = trdd_pregunta_respuesta.getJSONObject(i);
                String id_anio = preguntaRespuesta.getString("id_anio");
                int id_mes = preguntaRespuesta.getInt("id_mes");
                int id_nivel_educativo = preguntaRespuesta.getInt("id_nivel_educativo");
                int id_indicador = preguntaRespuesta.getInt("id_indicador");
                int id_respuesta = preguntaRespuesta.getInt("id_respuesta");
                int id_estatus_respuesta = preguntaRespuesta.getInt("id_estatus_respuesta");
                String respuesta = preguntaRespuesta.getString("respuesta");
                ds.insertPreguntaRespuesta(new trdd_ej_pregunta_respuesta(id_anio,id_mes,id_nivel_educativo,id_indicador,id_respuesta,id_estatus_respuesta,respuesta));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_GRADO_ESCOLAR_CIUDADANOMETRO))
        {
            ds.deleteGradoEscolarCiudadanometro();
            JSONArray trdd_c_grado_escolar_res = respuestaVersiones.getJSONArray(TABLE_NAME_GRADO_ESCOLAR_CIUDADANOMETRO);
            for (int i = 0 ; i < trdd_c_grado_escolar_res.length() ; i++)
            {
                JSONObject gradoEscolar = trdd_c_grado_escolar_res.getJSONObject(i);
                int id_grado_escolar = gradoEscolar.getInt("id_grado_escolar");
                String nombre = gradoEscolar.getString("nombre");
                String siglas = gradoEscolar.getString("siglas");
                String grado = gradoEscolar.getString("grado");
                ds.insertGradoEscolarCiudadanometro(new trdd_c_grado_escolar(id_grado_escolar,nombre,siglas,grado));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_NIED_GRES_CIUDADANOMETRO))
        {
            ds.deleteNiedGresCiudadanometro();
            JSONArray trdd_nied_gres = respuestaVersiones.getJSONArray(TABLE_NAME_NIED_GRES_CIUDADANOMETRO);
            for (int i = 0 ; i< trdd_nied_gres.length();i++)
            {
                JSONObject niedGres = trdd_nied_gres.getJSONObject(i);
                int id_nivel_educativo = niedGres.getInt("id_nivel_educativo");
                int id_grado_escolar = niedGres.getInt("id_grado_escolar");
                ds.insertNiedGresCiudadanometro(new trdd_c_nied_gres(id_nivel_educativo,id_grado_escolar));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_REALIZADOR_CIUDADANOMETRO))
        {
            ds.deleteRealizadorCiudadanometro();
            JSONArray trdd_Realizador_Encuesta = respuestaVersiones.getJSONArray(TABLE_NAME_REALIZADOR_CIUDADANOMETRO);
            for (int i = 0 ; i< trdd_Realizador_Encuesta.length();i++)
            {
                JSONObject realizadorEncuesta = trdd_Realizador_Encuesta.getJSONObject(i);
                int id_realizador = realizadorEncuesta.getInt("id_realizador");
                String nombre = realizadorEncuesta.getString("nombre");
                ds.insertRealizadorCiudadanometro(new trdd_c_realizador(id_realizador,nombre));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_ANIOS_CIUDADANOMETRO))
        {
            ds.deleteAniosCiudadanometro();
            JSONArray trdd_anio = respuestaVersiones.getJSONArray(TABLE_NAME_ANIOS_CIUDADANOMETRO);
            for (int i = 0 ; i< trdd_anio.length();i++)
            {
                JSONObject anio = trdd_anio.getJSONObject(i);
                String id_anio = anio.getString("id_anio");
                ds.insertAniosCiudadanometro(new trdd_c_anio(id_anio));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_PREGUNTAS_CIUDADANOMETRO))
        {
            ds.deletePreguntasCiudadanometro();
            JSONArray trdd_c_preguntas = respuestaVersiones.getJSONArray(TABLE_NAME_PREGUNTAS_CIUDADANOMETRO);
            for (int i = 0 ; i< trdd_c_preguntas.length();i++)
            {
                JSONObject anio = trdd_c_preguntas.getJSONObject(i);
                String id_anio = anio.getString("id_anio");
                String id_pregunta = anio.getString("id_pregunta");
                ds.insertPreguntasCiudadanometro(new trdd_c_pregunta(id_anio,id_pregunta));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_ESTATUSRESPUESTA_CIUDADANOMETRO))
        {
            ds.deleteEstatusRespuestaCiudadanometro();
            JSONArray trdd_estatus_respuesta = respuestaVersiones.getJSONArray(TABLE_NAME_ESTATUSRESPUESTA_CIUDADANOMETRO);
            for (int i = 0 ; i< trdd_estatus_respuesta.length();i++)
            {
                JSONObject indicador = trdd_estatus_respuesta.getJSONObject(i);
                int id_estatus_respuesta = indicador.getInt("id_estatus_respuesta");
                String nombre = indicador.getString("nombre");
                ds.insertEstatusRespuestaCiudadanometro(new trdd_c_estatus_respuesta(id_estatus_respuesta,nombre));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_PREGUNTARESPUESTA_CIUDADANOMETRO))
        {
            ds.deletePreguntaRespuestaCiudadanometro();
            JSONArray trdd_pregunta_respuesta = respuestaVersiones.getJSONArray(TABLE_NAME_PREGUNTARESPUESTA_CIUDADANOMETRO);
            for (int i = 0 ; i< trdd_pregunta_respuesta.length();i++)
            {
                JSONObject indicador = trdd_pregunta_respuesta.getJSONObject(i);
                String id_anio = indicador.getString("id_anio");
                String id_pregunta = indicador.getString("id_pregunta");
                int id_respuesta = indicador.getInt("id_respuesta");
                int id_estatus_respuesta = indicador.getInt("id_estatus_respuesta");
                String respuesta = indicador.getString("respuesta");
                ds.insertPreguntasRespuestaCiudadanometro(new trdd_c_pregunta_respuesta(id_anio,id_pregunta,id_respuesta,id_estatus_respuesta,respuesta));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_REALICADOREDAD_CIUDADANOMETRO))
        {
            ds.deleteRealicadorEdadCiudadanometro();
            JSONArray trdd_realicador_edad = respuestaVersiones.getJSONArray(TABLE_NAME_REALICADOREDAD_CIUDADANOMETRO);
            for (int i = 0 ; i< trdd_realicador_edad.length();i++)
            {
                JSONObject indicador = trdd_realicador_edad.getJSONObject(i);
                int id_edad = indicador.getInt("id_edad");
                String nombre = indicador.getString("nombre");
                ds.insertRealicadorEdadCiudadanometro(new trdd_c_realicador_edad(id_edad,nombre));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_REALICADORGENERO_CIUDADANOMETRO))
        {
            ds.deleteRealicadorGeneroCiudadanometro();
            JSONArray trdd_realicador_genero = respuestaVersiones.getJSONArray(TABLE_NAME_REALICADORGENERO_CIUDADANOMETRO);
            for (int i = 0 ; i< trdd_realicador_genero.length();i++)
            {
                JSONObject indicador = trdd_realicador_genero.getJSONObject(i);
                int id_genero = indicador.getInt("id_genero");
                String nombre = indicador.getString("nombre");
                ds.insertRealicadorGeneroCiudadanometro(new trdd_c_realicador_genero(id_genero,nombre));
            }
        }

        if (respuestaVersiones.has(TABLE_NAME_REALICADORESCOLARIDAD_CIUDADANOMETRO))
        {
            ds.deleteRealicadorEscolaridadCiudadanometro();
            JSONArray trdd_realicador_escolaridad = respuestaVersiones.getJSONArray(TABLE_NAME_REALICADORESCOLARIDAD_CIUDADANOMETRO);
            for (int i = 0 ; i< trdd_realicador_escolaridad.length();i++)
            {
                JSONObject indicador = trdd_realicador_escolaridad.getJSONObject(i);
                int id_escolaridad = indicador.getInt("id_escolaridad");
                String nombre = indicador.getString("nombre");
                ds.insertRealicadorEscolaridadCiudadanometro(new trdd_c_realicador_escolaridad(id_escolaridad,nombre));
            }
        }
    }
}
