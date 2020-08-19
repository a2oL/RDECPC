package mx.org.ieem.data.sqllite.constants.ciudadanometro;

public class CamposyTablasCiudadano
{
    /** --------------------------------- Tablas y Campos ---------------------------------**/
    public static final String TABLE_NAME_GRADO_ESCOLAR_CIUDADANOMETRO = "trdd_c_grado_escolar";
    public static final String COLUMN_NAME_ID_GRADO_ESCOLAR_CIUDADANOMETRO = "id_grado_escolar";
    public static final String COLUMN_NAME_NAME_GRADO_ESCOLAR_CIUDADANOMETRO = "nombre";
    public static final String COLUMN_NAME_SIGLAS_GRADO_ESCOLAR_CIUDADANOMETRO = "siglas";
    public static final String COLUMN_NAME_GRADO_GRADO_ESCOLAR_CIUDADANOMETRO = "grado";

    public static final String TABLE_NAME_NIED_GRES_CIUDADANOMETRO = "trdd_c_nied_gres";
    public static final String COLUMN_NAME_NE_NIED_GRES_CIUDADANOMETRO = "id_nivel_educativo";
    public static final String COLUMN_NAME_GE_NIED_GRES_CIUDADANOMETRO = "id_grado_escolar";

    public static final String TABLE_NAME_REALIZADOR_CIUDADANOMETRO = "trdd_c_realizador";
    public static final String COLUMN_NAME_ID_REALIZADOR_CIUDADANOMETRO = "id_realizador";
    public static final String COLUMN_NAME_NAME_REALIZADOR_CIUDADANOMETRO = "nombre";

    public static final String TABLE_NAME_ANIOS_CIUDADANOMETRO = "trdd_c_anio";
    public static final String COLUMN_NAME_ID_ANIOS_CIUDADANOMETRO = "id_anio";

    public static final String TABLE_NAME_PREGUNTAS_CIUDADANOMETRO = "trdd_c_pregunta";
    public static final String COLUMN_NAME_ID_ANIO_PREGUNTAS_CIUDADANOMETRO = "id_anio";
    public static final String COLUMN_NAME_ID_PREGUNTA_PREGUNTAS_CIUDADANOMETRO = "id_pregunta";

    public static final String TABLE_NAME_ESTATUSRESPUESTA_CIUDADANOMETRO = "trdd_c_estatus_respuesta";
    public static final String COLUMN_NAME_ID_ESTATUSRESPUESTA_CIUDADANOMETRO = "id_estatus_respuesta";
    public static final String COLUMN_NAME_NOMBRE_ESTATUSRESPUESTA_CIUDADANOMETRO = "nombre";

    public static final String TABLE_NAME_PREGUNTARESPUESTA_CIUDADANOMETRO = "trdd_c_pregunta_respuesta";
    public static final String COLUMN_NAME_ID_ANIO_PREGUNTARESPUESTA_CIUDADANOMETRO = "id_anio";
    public static final String COLUMN_NAME_ID_PREGUNTA_PREGUNTARESPUESTA_CIUDADANOMETRO = "id_pregunta";
    public static final String COLUMN_NAME_ID_RESPUESTA_PREGUNTARESPUESTA_CIUDADANOMETRO = "id_respuesta";
    public static final String COLUMN_NAME_ID_ESTATUSRESPUESTA_PREGUNTARESPUESTA_CIUDADANOMETRO = "id_estatus_respuesta";
    public static final String COLUMN_NAME_RESPUESTA_PREGUNTARESPUESTA_CIUDADANOMETRO = "respuesta";

    public static final String TABLE_NAME_REALICADOREDAD_CIUDADANOMETRO = "trdd_c_realicador_edad";
    public static final String COLUMN_NAME_ID_EDAD_REALICADOREDAD_CIUDADANOMETRO = "id_edad";
    public static final String COLUMN_NAME_NOMBRE_REALICADOREDAD_CIUDADANOMETRO = "nombre";

    public static final String TABLE_NAME_REALICADORGENERO_CIUDADANOMETRO = "trdd_c_realicador_genero";
    public static final String COLUMN_NAME_ID_GENERO_REALICADORGENERO_CIUDADANOMETRO = "id_genero";
    public static final String COLUMN_NAME_NOMBRE_REALICADORGENERO_CIUDADANOMETRO = "nombre";

    public static final String TABLE_NAME_REALICADORESCOLARIDAD_CIUDADANOMETRO = "trdd_c_realicador_escolaridad";
    public static final String COLUMN_NAME_ID_ESCOLARIDAD_REALICADORESCOLARIDAD_CIUDADANOMETRO = "id_escolaridad";
    public static final String COLUMN_NAME_NOMBRE_REALICADORESCOLARIDAD_CIUDADANOMETRO = "nombre";

    public static final String TABLE_NAME_ENCUESTA_CIUDADANOMETRO = "trdd_c_encuesta";
    public static final String COLUMN_NAME_ID_CCT_ENCUESTA_CIUDADANOMETRO = "id_cct";
    public static final String COLUMN_NAME_ID_RANDOM_ENCUESTA_CIUDADANOMETRO = "id_random";
    public static final String COLUMN_NAME_ID_ENCUESTA_ENCUESTA_CIUDADANOMETRO = "id_encuesta";
    public static final String COLUMN_NAME_ID_REALIZADOR_ENCUESTA_CIUDADANOMETRO = "id_realizador";
    public static final String COLUMN_NAME_ID_REALIZADORNIVEDU_ENCUESTA_CIUDADANOMETRO = "id_realizador_niv_edu";
    public static final String COLUMN_NAME_ID_REALIZADORGRESC_ENCUESTA_CIUDADANOMETRO = "id_realizador_grad_esc";
    public static final String COLUMN_NAME_ID_REALIZADOREDAD_ENCUESTA_CIUDADANOMETRO = "id_realizador_edad";
    public static final String COLUMN_NAME_ID_REALIZADORGENERO_ENCUESTA_CIUDADANOMETRO = "id_realizador_genero";
    public static final String COLUMN_NAME_ID_REALIZADORESCOLARIDAD_ENCUESTA_CIUDADANOMETRO = "id_realizador_escolaridad";

    public static final String TABLE_NAME_DETALLEENCUESTA_CIUDADANOMETRO = "trdd_c_detalle_encuesta";
    public static final String COLUMN_NAME_ID_CCT_DETALLEENCUESTA_CIUDADANOMETRO = "id_cct";
    public static final String COLUMN_NAME_ID_RANDOM_DETALLEENCUESTA_CIUDADANOMETRO = "id_random";
    public static final String COLUMN_NAME_ID_ENCUESTA_DETALLEENCUESTA_CIUDADANOMETRO = "id_encuesta";
    public static final String COLUMN_NAME_ID_ANIO_DETALLEENCUESTA_CIUDADANOMETRO = "id_anio";
    public static final String COLUMN_NAME_ID_PREGUNTA_DETALLEENCUESTA_CIUDADANOMETRO = "id_pregunta";
    public static final String COLUMN_NAME_ID_RESPUESTA_DETALLEENCUESTA_CIUDADANOMETRO = "id_respuesta";
    public static final String COLUMN_NAME_ID_ESTATUSRESPUESTA_DETALLEENCUESTA_CIUDADANOMETRO = "id_estatus_respuesta";
}
