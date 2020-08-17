package mx.org.ieem.data.sqllite.constants.encuestasj;

import mx.org.ieem.data.sqllite.DataBaseAppRed;

public class CamposyTablasEncuestas
{
    /** --------------------------------- Tablas y Campos ---------------------------------**/
    public static final String TABLE_NAME_TMUNICIPIO = "trdd_ej_municipio";
    public static final String COLUMN_NAME_ID_TMUNICIPIO = "id_municipio";
    public static final String COLUMN_NAME_NAME_TMUNICIPIO = "nombre";

    public static final String TABLE_NAME_ANIOS = "trdd_ej_anio";
    public static final String COLUMN_NAME_ID_ANIOS = "id_anio";

    public static final String TABLE_NAME_MES = "trdd_ej_mes";
    public static final String COLUMN_NAME_ID_MES = "id_mes";
    public static final String COLUMN_NAME_NAME_MES = "nombre";

    public static final String TABLE_NAME_MES_ANIO = "trdd_ej_anio_mes";
    public static final String COLUMN_NAME_ID_MES_ANIO = "id_anio";
    public static final String COLUMN_NAME_NAME_MES_ANIO = "id_mes";

    public static final String TABLE_NAME_NIVEL_EDUCATIVO = "trdd_ej_nivel_educativo";
    public static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO = "id_nivel_educativo";
    public static final String COLUMN_NAME_NAME_NIVEL_EDUCATIVO = "nombre";

    public static final String TABLE_NAME_GRADO_ESCOLAR = "trdd_ej_grado_escolar";
    public static final String COLUMN_NAME_ID_GRADO_ESCOLAR = "id_grado_escolar";
    public static final String COLUMN_NAME_NAME_GRADO_ESCOLAR = "nombre";
    public static final String COLUMN_NAME_SIGLAS_GRADO_ESCOLAR = "siglas";
    public static final String COLUMN_NAME_GRADO_GRADO_ESCOLAR = "grado";

    public static final String TABLE_NAME_NIED_GRES = "trdd_ej_nied_gres";
    public static final String COLUMN_NAME_NE_NIED_GRES = "id_nivel_educativo";
    public static final String COLUMN_NAME_GE_NIED_GRES = "id_grado_escolar";

    public static final String TABLE_NAME_INDICADOR = "trdd_ej_indicador";
    public static final String COLUMN_NAME_ID_INDICADOR = "id_indicador";
    public static final String COLUMN_NAME_NAME_INDICADOR = "nombre";

    public static final String TABLE_NAME_NIV_IND = "trdd_ej_nivedu_ind";
    public static final String COLUMN_NAME_NE_NIV_IND = "id_nivel_educativo";
    public static final String COLUMN_NAME_IN_NIV_IND = "id_indicador";

    public static final String TABLE_NAME_PREGUNTA = "trdd_ej_pregunta";
    public static final String COLUMN_NAME_ID_ANIO_PREGUNTA = "id_anio";
    public static final String COLUMN_NAME_ID_MES_PREGUNTA = "id_mes";
    public static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO_PREGUNTA = "id_nivel_educativo";
    public static final String COLUMN_NAME_ID_INDICADOR_PREGUNTA = "id_indicador";
    public static final String COLUMN_NAME_PREGUNTA = "pregunta";

    public static final String TABLE_NAME_ESTATUS_RESPUESTA = "trdd_ej_estatus_respuesta";
    public static final String COLUMN_NAME_ID_ESTATUS_RESPUESTA = "id_estatus_respuesta";
    public static final String COLUMN_NAME_NAME_ESTATUS_RESPUESTA = "nombre";

    public static final String TABLE_NAME_PREGUNTA_RESPUESTA = "trdd_ej_pregunta_respuesta";
    public static final String COLUMN_NAME_ID_ANIO_PREGUNTA_RESPUESTA = "id_anio";
    public static final String COLUMN_NAME_ID_MES_PREGUNTA_RESPUESTA = "id_mes";
    public static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO_PREGUNTA_RESPUESTA = "id_nivel_educativo";
    public static final String COLUMN_NAME_ID_INDICADOR_PREGUNTA_RESPUESTA = "id_indicador";
    public static final String COLUMN_NAME_ID_RESPUESTA_PREGUNTA_RESPUESTA = "id_respuesta";
    public static final String COLUMN_NAME_ID_ESTATUS_RESPUESTA_PREGUNTA_RESPUESTA = "id_estatus_respuesta ";
    public static final String COLUMN_NAME_RESPUESTA_PREGUNTA_RESPUESTA = "respuesta";

    public static final String TABLE_NAME_CCT_GENERAL = "trdd_cct";
    public static final String COLUMN_NAME_ID_CCT_GENERAL = "id_cct";
    public static final String COLUMN_NAME_NOMBRE_CCT_GENERAL = "nombre";
    public static final String COLUMN_NAME_DOMICILIO_CCT_GENERAL = "domicilio";
    public static final String COLUMN_NAME_EMAIL_CCT_GENERAL = "email";
    public static final String COLUMN_NAME_ID_MUNICIPIO_CCT_GENERAL = "id_municipio ";
    public static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO_CCT_GENERAL = "id_nivel_educativo";

    public static final String TABLE_NAME_ENCUESTA = "trdd_ej_encuesta";
    public static final String TABLE_NAME_DETALLE_ENCUESTA = "trdd_ej_detalle_encuesta";
    public static final String COLUMN_NAME_ID_CCT_ENCUESTA = "id_cct";
    public static final String COLUMN_NAME_ID_RANDOM_ENCUESTA = "id_random";
    public static final String COLUMN_NAME_ID_ENCUESTA_ENCUESTA = "id_encuesta";
    public static final String COLUMN_NAME_ID_ANIO_ENCUESTA = "id_anio";
    public static final String COLUMN_NAME_ID_MES_ENCUESTA = "id_mes";
    public static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO_ENCUESTA = "id_nivel_educativo";
    public static final String COLUMN_NAME_ID_GRADO_ESCOLAR_ENCUESTA = "id_grado_escolar";
    public static final String COLUMN_NAME_ID_INDICADOR_ENCUESTA = "id_indicador";
    public static final String COLUMN_NAME_ID_RESPUESTA_ENCUESTA = "id_respuesta";
    public static final String COLUMN_NAME_ID_ESTATUS_RESPUESTA_ENCUESTA = "id_estatus_respuesta";



}
