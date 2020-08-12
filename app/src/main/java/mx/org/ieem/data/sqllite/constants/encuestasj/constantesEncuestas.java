package mx.org.ieem.data.sqllite.constants.encuestasj;

import mx.org.ieem.data.sqllite.DataBaseAppRed;

public class constantesEncuestas
{
    public static String TAG = DataBaseAppRed.class.getSimpleName();
    /** --------------------------------- Nombre de Base de Datos -------------------------------------**/
    public static final String DataBaseName = "DPCDataBase";
    /** --------------------------------- Version de Base de Datos ---------------------------------**/
    public static final int version = 35;
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

    public static final String TABLE_NAME_CCT = "trdd_ej_cct";
    public static final String TABLE_NAME_CCT_ACTUAL = "trdd_cct_actual";
    public static final String COLUMN_NAME_ID_CCT = "id_cct";
    public static final String COLUMN_NAME_NOMBRE_CCT = "nombre";
    public static final String COLUMN_NAME_DOMICILIO_CCT = "domicilio";
    public static final String COLUMN_NAME_EMAIL_CCT = "email";
    public static final String COLUMN_NAME_ID_MUNICIPIO_CCT = "id_municipio ";
    public static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO_CCT = "id_nivel_educativo";

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

    public static final String TABLE_NAME_PARAMETROS = "trdd_ej_parametros_version";
    public static final String COLUMN_NAME_ID_PARAMETROS = "id_parametros";
    public static final String COLUMN_NAME_TABLAS_PARAMETROS = "tabla";
    public static final String COLUMN_NAME_VERSION_PARAMETROS = "version";


    public static final String RESPUESTA_SIMULADA_A = "{\n" +
            "     \"trdd_ej_cct\":\n" +
            "     {\n" +
            "         \"id_cct\": \"1\",\n" +
            "         \"nombre\": \"PRIMARIA AMADO NERVO\",\n" +
            "         \"domicilio\": \"ESQUINA HERIBERTO HENRIQUEZ CON CEBORUCO\",\n" +
            "         \"email\": \"gvaldez@ieem.org.mx\",\n" +
            "         \"id_municipio\": \"1\",\n" +
            "         \"id_nivel_educativo\": \"1\"\n" +
            "     },\n" +
            "\n" +
            "     \"trdd_ej_nivel_educativo\":\n" +
            "     {\n" +
            "         \"id_nivel_educativo\": \"1\",\n" +
            "         \"nombre\": \"Primaria\"\n" +
            "     },\n" +
            "\n" +
            "     \"trdd_ej_municipio\":\n" +
            "     {\n" +
            "         \"id_municipio\": \"1\",\n" +
            "         \"nombre\": \"TOLUCA\"\n" +
            "     },\n" +
            "     \"trdd_ej_parametros_version\":\n" +
            "     [\n" +
            "         {\n" +
            "             \"id_parametros\": \"1\",\n" +
            "             \"tabla\": \"trdd_ej_anio\",\n" +
            "             \"version\": \"1\"\n" +
            "         },\n" +
            "         {\n" +
            "             \"id_parametros\": \"2\",\n" +
            "             \"tabla\": \"trdd_ej_mes\",\n" +
            "             \"version\": \"1\"\n" +
            "         },\n" +
            "         {\n" +
            "             \"id_parametros\": \"3\",\n" +
            "             \"tabla\": \"trdd_ej_anio_mes\",\n" +
            "             \"version\": \"1\"\n" +
            "         },\n" +
            "         {\n" +
            "             \"id_parametros\": \"4\",\n" +
            "             \"tabla\": \"trdd_ej_grado_escolar\",\n" +
            "             \"version\": \"1\"\n" +
            "         },\n" +
            "         {\n" +
            "             \"id_parametros\": \"5\",\n" +
            "             \"tabla\": \"trdd_ej_nied_gres\",\n" +
            "             \"version\": \"1\"\n" +
            "         },\n" +
            "         {\n" +
            "             \"id_parametros\": \"6\",\n" +
            "             \"tabla\": \"trdd_ej_indicador\",\n" +
            "             \"version\": \"1\"\n" +
            "         },\n" +
            "         {\n" +
            "             \"id_parametros\": \"7\",\n" +
            "             \"tabla\": \"trdd_ej_nivedu_ind\",\n" +
            "             \"version\": \"1\"\n" +
            "         },\n" +
            "         {\n" +
            "             \"id_parametros\": \"8\",\n" +
            "             \"tabla\": \"trdd_ej_pregunta\",\n" +
            "             \"version\": \"1\"\n" +
            "         },\n" +
            "         {\n" +
            "             \"id_parametros\": \"9\",\n" +
            "             \"tabla\": \"trdd_ej_estatus_respuesta\",\n" +
            "             \"version\": \"1\"\n" +
            "         },\n" +
            "         {\n" +
            "             \"id_parametros\": \"10\",\n" +
            "             \"tabla\": \"trdd_ej_pregunta_respuesta\",\n" +
            "             \"version\": \"1\"\n" +
            "         }\n" +
            "\n" +
            "     ]\n" +
            "}";

    public static final String RESPUESTA_SIMULADA_VERSIONES = "{\n" +
            "\t\"trdd_ej_anio\":\n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\"\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\n" +
            "\t\"trdd_ej_mes\":\n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"nombre\":\"Enero\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_mes\":\"2\",\n" +
            "\t\t\t\"nombre\":\"Febrero\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_mes\":\"3\",\n" +
            "\t\t\t\"nombre\":\"Marzo\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_mes\":\"4\",\n" +
            "\t\t\t\"nombre\":\"Abril\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_mes\":\"5\",\n" +
            "\t\t\t\"nombre\":\"Mayo\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_mes\":\"6\",\n" +
            "\t\t\t\"nombre\":\"Junio\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_mes\":\"7\",\n" +
            "\t\t\t\"nombre\":\"Julio\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_mes\":\"8\",\n" +
            "\t\t\t\"nombre\":\"Agosto\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_mes\":\"9\",\n" +
            "\t\t\t\"nombre\":\"Septiembre\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_mes\":\"10\",\n" +
            "\t\t\t\"nombre\":\"Octubre\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_mes\":\"11\",\n" +
            "\t\t\t\"nombre\":\"Noviembre\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_mes\":\"12\",\n" +
            "\t\t\t\"nombre\":\"Diciembre\"\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\n" +
            "\t\"trdd_ej_anio_mes\":\n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"2\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"3\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"4\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"5\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"6\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"7\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"8\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"9\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"10\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"11\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"12\"\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\n" +
            "\t\"trdd_ej_nivel_educativo\":\n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"nombre\":\"Primaria\"\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\n" +
            "\t\"trdd_ej_grado_escolar\":\n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"id_grado_escolar\":\"1\",\n" +
            "\t\t\t\"nombre\":\"Primero\",\n" +
            "\t\t\t\"siglas\":\"1ero\",\n" +
            "\t\t\t\"grado\":\"1º\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_grado_escolar\":\"2\",\n" +
            "\t\t\t\"nombre\":\"Segundo\",\n" +
            "\t\t\t\"siglas\":\"2do\",\n" +
            "\t\t\t\"grado\":\"2º\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_grado_escolar\":\"3\",\n" +
            "\t\t\t\"nombre\":\"Tercero\",\n" +
            "\t\t\t\"siglas\":\"3ero\",\n" +
            "\t\t\t\"grado\":\"3º\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_grado_escolar\":\"4\",\n" +
            "\t\t\t\"nombre\":\"Cuarto\",\n" +
            "\t\t\t\"siglas\":\"4to\",\n" +
            "\t\t\t\"grado\":\"4º\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_grado_escolar\":\"5\",\n" +
            "\t\t\t\"nombre\":\"Quinto\",\n" +
            "\t\t\t\"siglas\":\"5to\",\n" +
            "\t\t\t\"grado\":\"5º\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_grado_escolar\":\"6\",\n" +
            "\t\t\t\"nombre\":\"Sexto\",\n" +
            "\t\t\t\"siglas\":\"6to\",\n" +
            "\t\t\t\"grado\":\"6º\"\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\n" +
            "\t\"trdd_ej_nied_gres\":\n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_grado_escolar\":\"1\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_grado_escolar\":\"2\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_grado_escolar\":\"3\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_grado_escolar\":\"4\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_grado_escolar\":\"5\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_grado_escolar\":\"6\"\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\n" +
            "\t\"trdd_ej_indicador\":\n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"id_indicador\":\"1\",\n" +
            "\t\t\t\"nombre\":\"Determina si es niño o niña\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_indicador\":\"2\",\n" +
            "\t\t\t\"nombre\":\"Identificación de los valores cívicos\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_indicador\":\"3\",\n" +
            "\t\t\t\"nombre\":\"Actitudes cívicas\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_indicador\":\"4\",\n" +
            "\t\t\t\"nombre\":\"Conocimiento del calendario cívico\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_indicador\":\"5\",\n" +
            "\t\t\t\"nombre\":\"Identificación de las instituciones\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_indicador\":\"6\",\n" +
            "\t\t\t\"nombre\":\"Identificación de los derechos de Niñas, Niños y Adolecentes (NNA)\"\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\n" +
            "\t\"trdd_ej_nivedu_ind\":\n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"1\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"2\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"3\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"4\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"5\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"6\"\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\n" +
            "\t\"trdd_ej_pregunta\":\n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"1\",\n" +
            "\t\t\t\"pregunta\":\"¿Primis - Eres niña o niño?\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"2\",\n" +
            "\t\t\t\"pregunta\":\"¿Primis - Pregunta 2?\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"3\",\n" +
            "\t\t\t\"pregunta\":\"¿Primis - Pregunta 3?\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"4\",\n" +
            "\t\t\t\"pregunta\":\"¿Primis - Pregunta 4?\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"5\",\n" +
            "\t\t\t\"pregunta\":\"¿Primis - Pregunta 5?\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"6\",\n" +
            "\t\t\t\"pregunta\":\"¿Primis - Pregunta 6?\"\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\n" +
            "\t\"trdd_ej_estatus_respuesta\":\n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"id_estatus_respuesta\":\"1\",\n" +
            "\t\t\t\"nombre\":\"Correcta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_estatus_respuesta\":\"2\",\n" +
            "\t\t\t\"nombre\":\"Incorrecta\"\n" +
            "\t\t}\n" +
            "\t],\n" +
            "\n" +
            "\t\"trdd_ej_pregunta_respuesta\":\n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"1\",\n" +
            "\t\t\t\"id_respuesta\":\"1\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"1\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P1/R1: Correcta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"1\",\n" +
            "\t\t\t\"id_respuesta\":\"2\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"2\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P1/R2: Incorrecta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"1\",\n" +
            "\t\t\t\"id_respuesta\":\"3\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"2\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P1/R3: Incorrecta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"2\",\n" +
            "\t\t\t\"id_respuesta\":\"1\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"1\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P2/R1: Correcta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"2\",\n" +
            "\t\t\t\"id_respuesta\":\"2\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"2\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P2/R2: Incorrecta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"2\",\n" +
            "\t\t\t\"id_respuesta\":\"3\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"2\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P2/R3: Incorrecta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"3\",\n" +
            "\t\t\t\"id_respuesta\":\"1\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"1\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P3/R1: Correcta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"3\",\n" +
            "\t\t\t\"id_respuesta\":\"2\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"2\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P3/R2: Incorrecta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"3\",\n" +
            "\t\t\t\"id_respuesta\":\"3\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"2\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P3/R3: Incorrecta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"4\",\n" +
            "\t\t\t\"id_respuesta\":\"1\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"1\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P4/R1: Correcta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"4\",\n" +
            "\t\t\t\"id_respuesta\":\"2\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"2\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P4/R2: Incorrecta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"4\",\n" +
            "\t\t\t\"id_respuesta\":\"3\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"2\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P4/R3: Incorrecta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"5\",\n" +
            "\t\t\t\"id_respuesta\":\"1\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"1\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P5/R1: Correcta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"5\",\n" +
            "\t\t\t\"id_respuesta\":\"2\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"2\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P5/R2: Incorrecta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"5\",\n" +
            "\t\t\t\"id_respuesta\":\"3\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"2\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P5/R3: Incorrecta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"6\",\n" +
            "\t\t\t\"id_respuesta\":\"1\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"1\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P6/R1: Correcta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"6\",\n" +
            "\t\t\t\"id_respuesta\":\"2\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"2\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P6/R2: Incorrecta\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id_anio\":\"2020\",\n" +
            "\t\t\t\"id_mes\":\"1\",\n" +
            "\t\t\t\"id_nivel_educativo\":\"1\",\n" +
            "\t\t\t\"id_indicador\":\"6\",\n" +
            "\t\t\t\"id_respuesta\":\"3\",\n" +
            "\t\t\t\"id_estatus_respuesta\":\"2\",\n" +
            "\t\t\t\"respuesta\":\"Primis/P6/R3: Incorrecta\"\n" +
            "\t\t}\n" +
            "\t]\n" +
            "\n" +
            "}";
}
