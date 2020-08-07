package mx.org.ieem.data.sqllite.constants;

import mx.org.ieem.data.sqllite.DataBaseAppRed;

public class Constantes {
    public static String TAG = DataBaseAppRed.class.getSimpleName();
    /** --------------------------------- Nombre de Base de Datos -------------------------------------**/
    public static final String DataBaseName = "DPCDataBase";
    /** --------------------------------- Version de Base de Datos ---------------------------------**/
    public static final int version = 22;
    /** --------------------------------- Tablas y Campos ---------------------------------**/
    public static final String TABLE_NAME_TMUNICIPIO = "tmunicipio";
    public static final String COLUMN_NAME_ID_TMUNICIPIO = "id_municipio";
    public static final String COLUMN_NAME_NAME_TMUNICIPIO = "nombre";

    public static final String TABLE_NAME_ANIOS = "trdd_anio";
    public static final String COLUMN_NAME_ID_ANIOS = "id_anio";

    public static final String TABLE_NAME_MES = "trdd_mes";
    public static final String COLUMN_NAME_ID_MES = "id_mes";
    public static final String COLUMN_NAME_NAME_MES = "nombre";

    public static final String TABLE_NAME_MES_ANIO = "trdd_anio_mes";
    public static final String COLUMN_NAME_ID_MES_ANIO = "id_anio";
    public static final String COLUMN_NAME_NAME_MES_ANIO = "id_mes";

    public static final String TABLE_NAME_NIVEL_EDUCATIVO = "trdd_nivel_educativo";
    public static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO = "id_nivel_educativo";
    public static final String COLUMN_NAME_NAME_NIVEL_EDUCATIVO = "nombre";

    public static final String TABLE_NAME_GRADO_ESCOLAR = "trdd_grado_escolar";
    public static final String COLUMN_NAME_ID_GRADO_ESCOLAR = "id_grado_escolar";
    public static final String COLUMN_NAME_NAME_GRADO_ESCOLAR = "nombre";
    public static final String COLUMN_NAME_SIGLAS_GRADO_ESCOLAR = "siglas";
    public static final String COLUMN_NAME_GRADO_GRADO_ESCOLAR = "grado";

    public static final String TABLE_NAME_NIED_GRES = "trdd_nied_gres";
    public static final String COLUMN_NAME_NE_NIED_GRES = "id_nivel_educativo";
    public static final String COLUMN_NAME_GE_NIED_GRES = "id_grado_escolar";

    public static final String TABLE_NAME_INDICADOR = "trdd_indicador";
    public static final String COLUMN_NAME_ID_INDICADOR = "id_indicador";
    public static final String COLUMN_NAME_NAME_INDICADOR = "nombre";

    public static final String TABLE_NAME_NIV_IND = "trdd_nivedu_ind";
    public static final String COLUMN_NAME_NE_NIV_IND = "id_nivel_educativo";
    public static final String COLUMN_NAME_IN_NIV_IND = "id_indicador";

    public static final String TABLE_NAME_PREGUNTA = "trdd_pregunta";
    public static final String COLUMN_NAME_ID_ANIO_PREGUNTA = "id_anio";
    public static final String COLUMN_NAME_ID_MES_PREGUNTA = "id_mes";
    public static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO_PREGUNTA = "id_nivel_educativo";
    public static final String COLUMN_NAME_ID_INDICADOR_PREGUNTA = "id_indicador";
    public static final String COLUMN_NAME_PREGUNTA = "pregunta";

    public static final String TABLE_NAME_ESTATUS_RESPUESTA = "trdd_estatus_respuesta";
    public static final String COLUMN_NAME_ID_ESTATUS_RESPUESTA = "id_estatus_respuesta";
    public static final String COLUMN_NAME_NAME_ESTATUS_RESPUESTA = "nombre";

    public static final String TABLE_NAME_PREGUNTA_RESPUESTA = "trdd_pregunta_respuesta";
    public static final String COLUMN_NAME_ID_ANIO_PREGUNTA_RESPUESTA = "id_anio";
    public static final String COLUMN_NAME_ID_MES_PREGUNTA_RESPUESTA = "id_mes";
    public static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO_PREGUNTA_RESPUESTA = "id_nivel_educativo";
    public static final String COLUMN_NAME_ID_INDICADOR_PREGUNTA_RESPUESTA = "id_indicador";
    public static final String COLUMN_NAME_ID_RESPUESTA_PREGUNTA_RESPUESTA = "id_respuesta";
    public static final String COLUMN_NAME_ID_ESTATUS_RESPUESTA_PREGUNTA_RESPUESTA = "id_estatus_respuesta ";
    public static final String COLUMN_NAME_RESPUESTA_PREGUNTA_RESPUESTA = "respuesta";

    public static final String TABLE_NAME_CCT = "trdd_cct";
    public static final String TABLE_NAME_CCT_ACTUAL = "trdd_cct_actual";
    public static final String COLUMN_NAME_ID_CCT = "id_cct";
    public static final String COLUMN_NAME_NOMBRE_CCT = "nombre";
    public static final String COLUMN_NAME_DOMICILIO_CCT = "domicilio";
    public static final String COLUMN_NAME_EMAIL_CCT = "email";
    public static final String COLUMN_NAME_ID_MUNICIPIO_CCT = "id_municipio ";
    public static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO_CCT = "id_nivel_educativo";

    public static final String TABLE_NAME_ENCUESTA = "trdd_encuesta";
    public static final String COLUMN_NAME_ID_CCT_ENCUESTA = "id_cct";
    public static final String COLUMN_NAME_ID_ENCUESTA_ENCUESTA = "id_random";
    public static final String COLUMN_NAME_ID_ANIO_ENCUESTA = "id_anio";
    public static final String COLUMN_NAME_ID_MES_ENCUESTA = "id_mes";
    public static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO_ENCUESTA = "id_nivel_educativo";
    public static final String COLUMN_NAME_ID_GRADO_ESCOLAR_ENCUESTA = "id_grado_escolar";
    public static final String COLUMN_NAME_ID_INDICADOR_ENCUESTA = "id_indicador";
    public static final String COLUMN_NAME_ID_RESPUESTA_ENCUESTA = "id_respuesta";
    public static final String COLUMN_NAME_ID_ESTATUS_RESPUESTA_ENCUESTA = "id_estatus_respuesta";

    public static final String TABLE_NAME_PARAMETROS = "trdd_parametros_version";
    public static final String COLUMN_NAME_ID_PARAMETROS = "id_Parametros";
    public static final String COLUMN_NAME_TABLAS_PARAMETROS = "tabla";
    public static final String COLUMN_NAME_VERSION_PARAMETROS = "version";


}
