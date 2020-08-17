package mx.org.ieem.data.sqllite.constants.ciudadanometro;

import static mx.org.ieem.data.sqllite.constants.ciudadanometro.CamposyTablasCiudadano.*;


public class QueryCiudadano
{
    public static final String CiuMunicipio = "CREATE TABLE " + TABLE_NAME_TMUNICIPIO_CIUDADANOMETRO + " (" +
            COLUMN_NAME_ID_TMUNICIPIO_CIUDADANOMETRO + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_TMUNICIPIO_CIUDADANOMETRO + " TEXT NOT NULL," +
            "CONSTRAINT trdd_c_municipio_pk PRIMARY KEY (id_municipio));";

    public static final String CiuNivelEducativo = "CREATE TABLE " + TABLE_NAME_NIVEL_EDUCATIVO_CIUDADANOMETRO + " (" +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO_CIUDADANOMETRO + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_NIVEL_EDUCATIVO_CIUDADANOMETRO + " TEXT NOT NULL," +
            "CONSTRAINT trdd_c_nivel_educativo_pk PRIMARY KEY (id_nivel_educativo));";

    public static final String CiuGradoEscolar = "CREATE TABLE " + TABLE_NAME_GRADO_ESCOLAR_CIUDADANOMETRO+ " (" +
            COLUMN_NAME_ID_GRADO_ESCOLAR_CIUDADANOMETRO + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_GRADO_ESCOLAR_CIUDADANOMETRO + " TEXT NOT NULL, " +
            COLUMN_NAME_SIGLAS_GRADO_ESCOLAR_CIUDADANOMETRO + " TEXT NOT NULL, " +
            COLUMN_NAME_GRADO_GRADO_ESCOLAR_CIUDADANOMETRO + " TEXT NOT NULL," +
            "CONSTRAINT trdd_c_grado_escolar_pk PRIMARY KEY (id_grado_escolar));";

    public static final String CiuNiedGres = "CREATE TABLE " + TABLE_NAME_NIED_GRES_CIUDADANOMETRO + " (" +
            COLUMN_NAME_NE_NIED_GRES_CIUDADANOMETRO + " INTEGER NOT NULL, " +
            COLUMN_NAME_GE_NIED_GRES_CIUDADANOMETRO + " INTEGER NOT NULL," +
            "CONSTRAINT trdd_c_nege_pk PRIMARY KEY (id_nivel_educativo, id_grado_escolar)," +
            "CONSTRAINT trpd_c_nege_nivedu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_c_nivel_educativo (id_nivel_educativo)," +
            "CONSTRAINT trpd_c_nege_graesc_fk FOREIGN KEY (id_grado_escolar) REFERENCES trdd_c_grado_escolar (id_grado_escolar));";

    public static final String CiuRealizador = "CREATE TABLE " + TABLE_NAME_REALIZADOR_CIUDADANOMETRO + " (" +
            COLUMN_NAME_ID_REALIZADOR_CIUDADANOMETRO + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_REALIZADOR_CIUDADANOMETRO + " TEXT NOT NULL," +
            "CONSTRAINT trdd_c_realizador_pk PRIMARY KEY (id_realizador));";


    public static final String CiuAnios = "CREATE TABLE " + TABLE_NAME_ANIOS_CIUDADANOMETRO + " (" +
            COLUMN_NAME_ID_ANIOS_CIUDADANOMETRO + " TEXT NOT NULL," +
            "CONSTRAINT trdd_c_anio_pk PRIMARY KEY (id_anio));";

    public static final String CiuPreguntas = "CREATE TABLE " + TABLE_NAME_PREGUNTAS_CIUDADANOMETRO + " (" +
            COLUMN_NAME_ID_ANIO_PREGUNTAS_CIUDADANOMETRO + " TEXT NOT NULL," +
            COLUMN_NAME_ID_PREGUNTA_PREGUNTAS_CIUDADANOMETRO+ " TEXT NOT NULL, " +
            "CONSTRAINT trdd_c_pre_pregunta_pk PRIMARY KEY (id_anio, id_pregunta), " +
            "CONSTRAINT trdd_c_pre_anio_fk FOREIGN KEY (id_anio) REFERENCES trdd_c_anio (id_anio));";

    public static final String CiuEstatusRespuesta = "CREATE TABLE " + TABLE_NAME_ESTATUSRESPUESTA_CIUDADANOMETRO + " (" +
            COLUMN_NAME_ID_ESTATUSRESPUESTA_CIUDADANOMETRO+ " INTEGER NOT NULL," +
            COLUMN_NAME_NOMBRE_ESTATUSRESPUESTA_CIUDADANOMETRO+ " TEXT NOT NULL," +
            "CONSTRAINT trdd_c_estatus_respuesta_pk PRIMARY KEY (id_estatus_respuesta));";

    public static final String CiuPreguntaRespuesta = "CREATE TABLE " + TABLE_NAME_PREGUNTARESPUESTA_CIUDADANOMETRO + " (" +
            COLUMN_NAME_ID_ANIO_PREGUNTARESPUESTA_CIUDADANOMETRO+ " TEXT NOT NULL," +
            COLUMN_NAME_ID_PREGUNTA_PREGUNTARESPUESTA_CIUDADANOMETRO+ " TEXT NOT NULL," +
            COLUMN_NAME_ID_RESPUESTA_PREGUNTARESPUESTA_CIUDADANOMETRO+ " INTEGER NOT NULL," +
            COLUMN_NAME_ID_ESTATUSRESPUESTA_PREGUNTARESPUESTA_CIUDADANOMETRO+ " INTEGER NOT NULL," +
            COLUMN_NAME_RESPUESTA_PREGUNTARESPUESTA_CIUDADANOMETRO+ " TEXT NOT NULL," +
            "CONSTRAINT trdd_c_prre_anipreresesrres_pk PRIMARY KEY (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta)," +
            "CONSTRAINT trdd_c_prre_anipre_fk FOREIGN KEY (id_anio, id_pregunta) REFERENCES trdd_c_pregunta (id_anio, id_pregunta)," +
            "CONSTRAINT trdd_c_prre_estres_fk FOREIGN KEY (id_estatus_respuesta) REFERENCES trdd_c_estatus_respuesta (id_estatus_respuesta));";

    public static final String CiuRealicadorEdad = "CREATE TABLE " + TABLE_NAME_REALICADOREDAD_CIUDADANOMETRO + " (" +
            COLUMN_NAME_ID_EDAD_REALICADOREDAD_CIUDADANOMETRO+ " INTEGER NOT NULL," +
            COLUMN_NAME_NOMBRE_REALICADOREDAD_CIUDADANOMETRO+ " TEXT NOT NULL," +
            "CONSTRAINT trdd_c_realizador_edad_pk PRIMARY KEY (id_edad));";

    public static final String CiuRealicadorGenero = "CREATE TABLE " + TABLE_NAME_REALICADORGENERO_CIUDADANOMETRO + " (" +
            COLUMN_NAME_ID_GENERO_REALICADORGENERO_CIUDADANOMETRO+ " INTEGER NOT NULL," +
            COLUMN_NAME_NOMBRE_REALICADORGENERO_CIUDADANOMETRO+ " TEXT NOT NULL," +
            "CONSTRAINT trdd_c_realizador_genero_pk PRIMARY KEY (id_genero));";

    public static final String CiuRealicadorEscolaridad = "CREATE TABLE " + TABLE_NAME_REALICADORESCOLARIDAD_CIUDADANOMETRO + " (" +
            COLUMN_NAME_ID_ESCOLARIDAD_REALICADORESCOLARIDAD_CIUDADANOMETRO+ " INTEGER NOT NULL," +
            COLUMN_NAME_NOMBRE_REALICADORESCOLARIDAD_CIUDADANOMETRO+ " TEXT NOT NULL," +
            "CONSTRAINT trdd_c_realizador_escolaridad_pk PRIMARY KEY (id_escolaridad));";

    public static final String CiuEncuesta = "CREATE TABLE " + TABLE_NAME_ENCUESTA_CIUDADANOMETRO + " (" +
            COLUMN_NAME_ID_CCT_ENCUESTA_CIUDADANOMETRO + " TEXT NOT NULL," +
            COLUMN_NAME_ID_RANDOM_ENCUESTA_CIUDADANOMETRO + " TEXT NOT NULL," +
            COLUMN_NAME_ID_ENCUESTA_ENCUESTA_CIUDADANOMETRO + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_REALIZADOR_ENCUESTA_CIUDADANOMETRO + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_REALIZADORNIVEDU_ENCUESTA_CIUDADANOMETRO + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_REALIZADORGRESC_ENCUESTA_CIUDADANOMETRO + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_REALIZADOREDAD_ENCUESTA_CIUDADANOMETRO + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_REALIZADORGENERO_ENCUESTA_CIUDADANOMETRO + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_REALIZADORESCOLARIDAD_ENCUESTA_CIUDADANOMETRO + " INTEGER NOT NULL," +
            "CONSTRAINT trdd_c_enc_cctramenc_pk PRIMARY KEY (id_cct, id_random)," +
            "CONSTRAINT trdd_c_enc_cct_fk FOREIGN KEY (id_cct) REFERENCES trdd_cct (id_cct)," +
            "CONSTRAINT trdd_c_enc_realizador_fk FOREIGN KEY (id_realizador) REFERENCES trdd_c_realizador (id_realizador)," +
            "CONSTRAINT trdd_c_enc_rea_nivedugraest_fk FOREIGN KEY (id_realizador_niv_edu, id_realizador_grad_esc) REFERENCES trdd_c_nied_gres (id_nivel_educativo, id_grado_escolar)," +
            "CONSTRAINT trdd_c_enc_rea_edad_fk FOREIGN KEY (id_realizador_edad) REFERENCES trdd_c_realicador_edad (id_edad)," +
            "CONSTRAINT trdd_c_enc_rea_genero_fk FOREIGN KEY (id_realizador_genero) REFERENCES trdd_c_realicador_genero (id_genero)," +
            "CONSTRAINT trdd_c_enc_rea_escolaridad_fk FOREIGN KEY (id_realizador_escolaridad) REFERENCES trdd_c_realicador_escolaridad (id_escolaridad));";

    public static final String CiuDetalleEncuesta = "CREATE TABLE " + TABLE_NAME_DETALLEENCUESTA_CIUDADANOMETRO + " (" +
            COLUMN_NAME_ID_CCT_DETALLEENCUESTA_CIUDADANOMETRO + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_RANDOM_DETALLEENCUESTA_CIUDADANOMETRO + " TEXT NOT NULL," +
            COLUMN_NAME_ID_ENCUESTA_DETALLEENCUESTA_CIUDADANOMETRO + " TEXT NOT NULL," +
            COLUMN_NAME_ID_ANIO_DETALLEENCUESTA_CIUDADANOMETRO + " TEXT NOT NULL," +
            COLUMN_NAME_ID_PREGUNTA_DETALLEENCUESTA_CIUDADANOMETRO + " TEXT NOT NULL," +
            COLUMN_NAME_ID_RESPUESTA_DETALLEENCUESTA_CIUDADANOMETRO + " TEXT NOT NULL," +
            COLUMN_NAME_ID_ESTATUSRESPUESTA_DETALLEENCUESTA_CIUDADANOMETRO + " TEXT NOT NULL," +
            "CONSTRAINT trdd_c_detenc_camnegeirer_pk PRIMARY KEY (id_cct, id_random, id_encuesta, id_anio, id_pregunta, id_respuesta, id_estatus_respuesta)," +
            "CONSTRAINT trdd_c_detenc_cctramenc_fk FOREIGN KEY (id_cct, id_random, id_encuesta) REFERENCES trdd_c_encuesta (id_cct, id_random, id_encuesta)," +
            "CONSTRAINT trdd_c_detenc_amneirer_fk FOREIGN KEY (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta) REFERENCES trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta));";
}
