package mx.org.ieem.data.sqllite.constants.encuestasj;

import static mx.org.ieem.data.sqllite.constants.encuestasj.CamposyTablasEncuestas.*;

public class QueryEncuestasJ
{

    public static final String CMunicipios = "CREATE TABLE " + TABLE_NAME_TMUNICIPIO + " (" +
            COLUMN_NAME_ID_TMUNICIPIO + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_TMUNICIPIO + " TEXT NOT NULL," +
            "CONSTRAINT trdd_municipio_pk PRIMARY KEY (id_municipio));";

    public static final String CAnios = "CREATE TABLE " + TABLE_NAME_ANIOS + " (" +
            COLUMN_NAME_ID_ANIOS + " TEXT NOT NULL," +
            "CONSTRAINT trdd_ej_anio_pk PRIMARY KEY (id_anio));";

    public static final String CMeses = "CREATE TABLE " + TABLE_NAME_MES + " (" +
            COLUMN_NAME_ID_MES + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_MES + " TEXT NOT NULL," +
            "CONSTRAINT trdd_ej_mes_pk PRIMARY KEY (id_mes));";

    public static final String CMesesAnios = "CREATE TABLE "+ TABLE_NAME_MES_ANIO + " (" +
            COLUMN_NAME_ID_MES_ANIO + " TEXT NOT NULL,"+
            COLUMN_NAME_NAME_MES_ANIO +" INTEGER NOT NULL," +
            "CONSTRAINT trdd_ej_anio_mes_pk PRIMARY KEY (id_anio, id_mes)," +
            "CONSTRAINT trdd_ej_anio_fk FOREIGN KEY (id_anio) REFERENCES trdd_ej_anio (id_anio)," +
            "CONSTRAINT trdd_ej_mes_fk FOREIGN KEY (id_mes) REFERENCES trdd_ej_mes (id_mes));";

    public static final String CNivelEducativo = "CREATE TABLE " + TABLE_NAME_NIVEL_EDUCATIVO + " (" +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_NIVEL_EDUCATIVO + " TEXT NOT NULL," +
            "CONSTRAINT trdd_nivel_educativo_pk PRIMARY KEY (id_nivel_educativo));";

    public static final String CGradoEscolar = "CREATE TABLE " + TABLE_NAME_GRADO_ESCOLAR + " (" +
            COLUMN_NAME_ID_GRADO_ESCOLAR + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_GRADO_ESCOLAR + " TEXT NOT NULL, " +
            COLUMN_NAME_SIGLAS_GRADO_ESCOLAR + " TEXT NOT NULL, " +
            COLUMN_NAME_GRADO_GRADO_ESCOLAR + " TEXT NOT NULL," +
            "CONSTRAINT trdd_ej_grado_escolar_pk PRIMARY KEY (id_grado_escolar));";

    public static final String CNiedGres = "CREATE TABLE " + TABLE_NAME_NIED_GRES + " (" +
            COLUMN_NAME_NE_NIED_GRES + " INTEGER NOT NULL, " +
            COLUMN_NAME_GE_NIED_GRES + " INTEGER NOT NULL," +
            "CONSTRAINT trdd_ej_nege_pk PRIMARY KEY (id_nivel_educativo, id_grado_escolar)," +
            "CONSTRAINT trpd_ej_nege_nivedu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_nivel_educativo (id_nivel_educativo)," +
            "CONSTRAINT trpd_ej_nege_graesc_fk FOREIGN KEY (id_grado_escolar) REFERENCES trdd_ej_grado_escolar (id_grado_escolar));";

    public static final String CIndicador = "CREATE TABLE " + TABLE_NAME_INDICADOR + " (" +
            COLUMN_NAME_ID_INDICADOR + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_INDICADOR + " TEXT NOT NULL," +
            "CONSTRAINT trdd_ej_indicador_pk PRIMARY KEY (id_indicador));";

    public static final String CNivInd = "CREATE TABLE " + TABLE_NAME_NIV_IND + " (" +
            COLUMN_NAME_NE_NIV_IND + " INTEGER NOT NULL, " +
            COLUMN_NAME_IN_NIV_IND + " INTEGER NOT NULL," +
            "CONSTRAINT trdd_ej_nei_nei_pk PRIMARY KEY (id_nivel_educativo, id_indicador)," +
            "CONSTRAINT trdd_ej_nei_nivedu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_nivel_educativo (id_nivel_educativo)," +
            "CONSTRAINT trdd_ej_nei_indicador_fk FOREIGN KEY (id_indicador) REFERENCES trdd_ej_indicador (id_indicador));";

    public static final String CPregunta = "CREATE TABLE " + TABLE_NAME_PREGUNTA + " (" +
            COLUMN_NAME_ID_ANIO_PREGUNTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_MES_PREGUNTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO_PREGUNTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_INDICADOR_PREGUNTA + " INTEGER NOT NULL," +
            COLUMN_NAME_PREGUNTA + " TEXT NOT NULL," +
            "CONSTRAINT trdd_ej_pre_pregunta_pk PRIMARY KEY (id_anio, id_mes, id_nivel_educativo, id_indicador)," +
            "CONSTRAINT trdd_ej_pre_animes_fk FOREIGN KEY (id_anio, id_mes) REFERENCES trdd_ej_anio_mes (id_anio, id_mes)," +
            "CONSTRAINT trdd_ej_pre_niveduind_fk FOREIGN KEY (id_nivel_educativo, id_indicador) REFERENCES trdd_ej_nivedu_ind (id_nivel_educativo, id_indicador));";

    public static final String CEstatusRespuesta = "CREATE TABLE " + TABLE_NAME_ESTATUS_RESPUESTA + " (" +
            COLUMN_NAME_ID_ESTATUS_RESPUESTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_ESTATUS_RESPUESTA + " TEXT NOT NULL," +
            "CONSTRAINT trdd_ej_estatus_respuesta_pk PRIMARY KEY (id_estatus_respuesta));";

    public static final String CPreguntaRespuesta = "CREATE TABLE " + TABLE_NAME_PREGUNTA_RESPUESTA + " (" +
            COLUMN_NAME_ID_ANIO_PREGUNTA_RESPUESTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_MES_PREGUNTA_RESPUESTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO_PREGUNTA_RESPUESTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_INDICADOR_PREGUNTA_RESPUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_RESPUESTA_PREGUNTA_RESPUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_ESTATUS_RESPUESTA_PREGUNTA_RESPUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_RESPUESTA_PREGUNTA_RESPUESTA + " TEXT NOT NULL," +
            "CONSTRAINT trdd_ej_prre_amneirer_pk PRIMARY KEY (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta)," +
            "CONSTRAINT trdd_ej_prre_amnei_fk FOREIGN KEY (id_anio, id_mes, id_nivel_educativo, id_indicador) REFERENCES trdd_ej_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador)," +
            "CONSTRAINT trdd_ej_prre_estres_fk FOREIGN KEY (id_estatus_respuesta) REFERENCES trdd_ej_estatus_respuesta (id_estatus_respuesta));";

    public static final String CCT = "CREATE TABLE " + TABLE_NAME_CCT_GENERAL + " (" +
            COLUMN_NAME_ID_CCT_GENERAL + " TEXT NOT NULL, " +
            COLUMN_NAME_NOMBRE_CCT_GENERAL + " TEXT NOT NULL, " +
            COLUMN_NAME_DOMICILIO_CCT_GENERAL + " TEXT NOT NULL, " +
            COLUMN_NAME_EMAIL_CCT_GENERAL + " TEXT NOT NULL," +
            COLUMN_NAME_ID_MUNICIPIO_CCT_GENERAL + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO_CCT_GENERAL + " INTEGER NOT NULL," +
            COLUMN_NAME_CONTRASENIA_CCT_GENERAL + " TEXT NOT NULL," +
            "CONSTRAINT trdd_cct_pk PRIMARY KEY (id_cct)," +
            "CONSTRAINT trdd_cct_mun_fk FOREIGN KEY (id_municipio) REFERENCES trdd_municipio (id_municipio)," +
            "CONSTRAINT trdd_cct_niv_edu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_nivel_educativo (id_nivel_educativo));";

    public static final String CEncuesta = "CREATE TABLE " + TABLE_NAME_ENCUESTA + " (" +
            COLUMN_NAME_ID_CCT_ENCUESTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_RANDOM_ENCUESTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_ENCUESTA_ENCUESTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO_ENCUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_GRADO_ESCOLAR_ENCUESTA + " INTEGER NOT NULL," +
            "CONSTRAINT trdd_ej_enc_camnegeirer_pk PRIMARY KEY (id_cct, id_random, id_encuesta, id_nivel_educativo)," +
            "CONSTRAINT trdd_ej_enc_cct_fk FOREIGN KEY (id_cct) REFERENCES trdd_cct (id_cct)," +
            "CONSTRAINT trdd_ej_enc_niedgres_cct_fk FOREIGN KEY (id_nivel_educativo, id_grado_escolar) REFERENCES trdd_ej_nied_gres (id_nivel_educativo, id_grado_escolar));";


    public static final String CDetalleEncuesta = "CREATE TABLE " + TABLE_NAME_DETALLE_ENCUESTA + " (" +
            COLUMN_NAME_ID_CCT_ENCUESTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_RANDOM_ENCUESTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_ENCUESTA_ENCUESTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_ANIO_ENCUESTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_MES_ENCUESTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO_ENCUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_GRADO_ESCOLAR_ENCUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_INDICADOR_ENCUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_RESPUESTA_ENCUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_ESTATUS_RESPUESTA_ENCUESTA + " INTEGER NOT NULL," +
            "CONSTRAINT trdd_ej_detenc_creamneirer_pk PRIMARY KEY (id_cct, id_random, id_encuesta, id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta)," +
            "CONSTRAINT trdd_ej_detenc_crene_fk FOREIGN KEY (id_cct, id_random, id_encuesta, id_nivel_educativo) REFERENCES trdd_ej_encuesta (id_cct, id_random, id_encuesta, id_nivel_educativo)," +
            "CONSTRAINT trdd_ej_detenc_amneirer_fk FOREIGN KEY (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta) REFERENCES trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta));";

    public static final String CDispositivos = "CREATE TABLE " + TABLE_NAME_DISPOSITIVOS + " (" +
            COLUMN_NAME_ID_RANDOM_DISPOSITIVOS + " TEXT NOT NULL," +
            "CONSTRAINT trdd_dispositivo_pk PRIMARY KEY (id_random));";

    public static final String CEstatusConcursosEventos = "CREATE TABLE " + TABLE_NAME_ESTATUS_CONCURSO_O_EVENTO + " (" +
            COLUMN_NAME_ID_ESTATUS_CONEVE + " INTEGER NOT NULL," +
            COLUMN_NAME_NOMBRE_ESTATUS_CONEVE + " TEXT NOT NULL, " +
            "CONSTRAINT trdd_estconeve_pk PRIMARY KEY (id_estatus_coneve));";

    public static final String CConcursosEventos = "CREATE TABLE " + TABLE_NAME_CONCURSO_O_EVENTO + " (" +
            COLUMN_NAME_ID_CONEVE + " INTEGER NOT NULL," +
            COLUMN_NAME_NOMBRE_CONEVE + " TEXT NOT NULL, " +
            COLUMN_NAME_DESCRIPCION_CONEVE + " TEXT NOT NULL, " +
            COLUMN_NAME_URL_CONEVE + " TEXT NOT NULL, " +
            COLUMN_NAME_URL_IMAGE_CONEVE + " TEXT NOT NULL, " +
            COLUMN_NAME_IDESTATUSCONEVE_CONEVE + " INTEGER NOT NULL, " +
            "CONSTRAINT trdd_coneve_pk PRIMARY KEY (id_con_eve)," +
            "CONSTRAINT trdd_coneve_ece_fk FOREIGN KEY (id_estatus_coneve) REFERENCES trdd_estatus_concurso_o_evento (id_estatus_coneve));";

    public static final String CEstatusReportes = "CREATE TABLE " + TABLE_NAME_ESTATUS_REPORTE + " (" +
            COLUMN_NAME_ID_ESTATUS_REPORTE + " INTEGER NOT NULL," +
            COLUMN_NAME_NOMBRE_REPORTE + " TEXT NOT NULL, " +
            "CONSTRAINT trdd_estatus_reporte_pk PRIMARY KEY (id_estatus_reporte));";

    public static final String CReportes = "CREATE TABLE " + TABLE_NAME_REPORTES + " (" +
            COLUMN_NAME_ID_REPORTES + " INTEGER NOT NULL," +
            COLUMN_NAME_NOMBRE_REPORTES + " TEXT NOT NULL, " +
            COLUMN_NAME_DESCRIPCION_REPORTES + " TEXT NOT NULL, " +
            COLUMN_NAME_URL_REPORTES + " TEXT NOT NULL, " +
            COLUMN_NAME_IDESTATUS_REPORTES + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_TIPO_REPORTE+ " INTEGER NOT NULL,"+
            "CONSTRAINT trdd_reporte_pk PRIMARY KEY (id_reporte)," +
            "CONSTRAINT trdd_reporte_estrep_fk FOREIGN KEY (id_estatus_reporte) REFERENCES trdd_estatus_reporte (id_estatus_reporte)," +
            "CONSTRAINT trdd_reporte_tiprep_fk FOREIGN KEY (id_tipo_reporte) REFERENCES trdd_tipo_reporte (id_tipo_reporte));";

    public static final String CTipoReportes = "CREATE TABLE " + TABLE_NAME_TIPO_REPORTE + " (" +
            COLUMN_NAME_ID_TIPO_REPORTE_TABLE + " INTEGER NOT NULL," +
            COLUMN_NAME_NOMBRE_TIPO_REPORTE + " TEXT NOT NULL, " +
            "CONSTRAINT trdd_tipo_reporte_pk PRIMARY KEY (id_tipo_reporte));";


}
