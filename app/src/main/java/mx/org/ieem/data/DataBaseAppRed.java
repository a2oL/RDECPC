package mx.org.ieem.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import mx.org.ieem.data.sqllite.trdd_cct;
import mx.org.ieem.data.sqllite.tmunicipio;

import java.util.ArrayList;

import static mx.org.ieem.RESTful.AsyncLogin.actual_final;


public class DataBaseAppRed {


    // Se actualizara con la version final de la tabla trdd_encuesta y falta incluir la bd del ciudadanometro





    private static String TAG = DataBaseAppRed.class.getSimpleName();
    /** --------------------------------- Nombre de Base de Datos -------------------------------------**/
    private static final String DataBaseName = "DPCDataBase";
    /** --------------------------------- Version de Base de Datos ---------------------------------**/
    private static final int version = 16;
    /** --------------------------------- Tablas y Campos ---------------------------------**/
    private static final String TABLE_NAME = "tmunicipio";
    private static final String COLUMN_NAME_ID = "id_municipio";
    private static final String COLUMN_NAME_NAME = "nombre";

    private static final String TABLE_NAME_ANIOS = "trdd_anio";
    private static final String COLUMN_NAME_ID_ANIOS = "id_anio";

    private static final String TABLE_NAME_MES = "trdd_mes";
    private static final String COLUMN_NAME_ID_MES = "id_mes";
    private static final String COLUMN_NAME_NAME_MES = "nombre";

    private static final String TABLE_NAME_MES_ANIO = "trdd_anio_mes";
    private static final String COLUMN_NAME_ID_MES_ANIO = "id_anio";
    private static final String COLUMN_NAME_NAME_MES_ANIO = "id_mes";

    private static final String TABLE_NAME_NIVEL_EDUCATIVO = "trdd_nivel_educativo";
    private static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO = "id_nivel_educativo";
    private static final String COLUMN_NAME_NAME_NIVEL_EDUCATIVO = "nombre";

    private static final String TABLE_NAME_GRADO_ESCOLAR = "trdd_grado_escolar";
    private static final String COLUMN_NAME_ID_GRADO_ESCOLAR = "id_grado_escolar";
    private static final String COLUMN_NAME_NAME_GRADO_ESCOLAR = "nombre";
    private static final String COLUMN_NAME_SIGLAS_GRADO_ESCOLAR = "siglas";
    private static final String COLUMN_NAME_GRADO_GRADO_ESCOLAR = "grado";

    private static final String TABLE_NAME_NIED_GRES = "trdd_nied_gres";
    private static final String COLUMN_NAME_NE_NIED_GRES = "id_nivel_educativo";
    private static final String COLUMN_NAME_GE_NIED_GRES = "id_grado_escolar";

    private static final String TABLE_NAME_INDICADOR = "trdd_indicador";
    private static final String COLUMN_NAME_ID_INDICADOR = "id_indicador";
    private static final String COLUMN_NAME_NAME_INDICADOR = "nombre";

    private static final String TABLE_NAME_NIV_IND = "trdd_nivedu_ind";
    private static final String COLUMN_NAME_NE_NIV_IND = "id_nivel_educativo";
    private static final String COLUMN_NAME_IN_NIV_IND = "id_indicador";

    private static final String TABLE_NAME_PREGUNTA = "trdd_pregunta";
    private static final String COLUMN_NAME_ID_ANIO_PREGUNTA = "id_anio";
    private static final String COLUMN_NAME_ID_MES_PREGUNTA = "id_mes";
    private static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO_PREGUNTA = "id_nivel_educativo";
    private static final String COLUMN_NAME_ID_INDICADOR_PREGUNTA = "id_indicador";
    private static final String COLUMN_NAME_PREGUNTA = "pregunta";

    private static final String TABLE_NAME_ESTATUS_RESPUESTA = "trdd_estatus_respuesta";
    private static final String COLUMN_NAME_ID_ESTATUS_RESPUESTA = "id_estatus_respuesta";
    private static final String COLUMN_NAME_NAME_ESTATUS_RESPUESTA = "nombre";

    private static final String TABLE_NAME_PREGUNTA_RESPUESTA = "trdd_pregunta_respuesta";
    private static final String COLUMN_NAME_ID_ANIO_PREGUNTA_RESPUESTA = "id_anio";
    private static final String COLUMN_NAME_ID_MES_PREGUNTA_RESPUESTA = "id_mes";
    private static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO_PREGUNTA_RESPUESTA = "id_nivel_educativo";
    private static final String COLUMN_NAME_ID_INDICADOR_PREGUNTA_RESPUESTA = "id_indicador";
    private static final String COLUMN_NAME_ID_RESPUESTA_PREGUNTA_RESPUESTA = "id_respuesta";
    private static final String COLUMN_NAME_ID_ESTATUS_RESPUESTA_PREGUNTA_RESPUESTA = "id_estatus_respuesta ";
    private static final String COLUMN_NAME_RESPUESTA_PREGUNTA_RESPUESTA = "respuesta";

    private static final String TABLE_NAME_CCT = "trdd_cct";
    private static final String COLUMN_NAME_ID_CCT = "id_cct";
    private static final String COLUMN_NAME_NOMBRE_CCT = "nombre";
    private static final String COLUMN_NAME_DOMICILIO_CCT = "domicilio";
    private static final String COLUMN_NAME_EMAIL_CCT = "email";
    private static final String COLUMN_NAME_ID_MUNICIPIO_CCT = "id_municipio ";
    private static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO_CCT = "id_nivel_educativo";

    private static final String TABLE_NAME_ENCUESTA = "trdd_encuesta";
    private static final String COLUMN_NAME_ID_ENCUESTA_ENCUESTA = "id_Encuesta";
    private static final String COLUMN_NAME_ID_CCT_ENCUESTA = "id_cct";
    private static final String COLUMN_NAME_ID_ANIO_ENCUESTA = "id_anio";
    private static final String COLUMN_NAME_ID_MES_ENCUESTA = "id_mes";
    private static final String COLUMN_NAME_ID_NIVEL_EDUCATIVO_ENCUESTA = "id_nivel_educativo";
    private static final String COLUMN_NAME_ID_GRADO_ESCOLAR_ENCUESTA = "id_grado_escolar";
    private static final String COLUMN_NAME_ID_INDICADOR_ENCUESTA = "id_indicador";
    private static final String COLUMN_NAME_ID_RESPUESTA_ENCUESTA = "id_respuesta";
    private static final String COLUMN_NAME_ID_ESTATUS_RESPUESTA_ENCUESTA = "id_estatus_respuesta";

    /** --------------------------------- Declaración de Tablas ----------------------------------**/
    private static final String CMunicipios = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_NAME_ID + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME + " TEXT NOT NULL," +
            "CONSTRAINT trpc_municipio_pk PRIMARY KEY (id_municipio));";

    private static final String CAnios = "CREATE TABLE " + TABLE_NAME_ANIOS + " (" +
            COLUMN_NAME_ID_ANIOS + " TEXT NOT NULL," +
            "CONSTRAINT trdd_anio_pk PRIMARY KEY (id_anio));";

    private static final String CMeses = "CREATE TABLE " + TABLE_NAME_MES + " (" +
            COLUMN_NAME_ID_MES + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_MES + " TEXT NOT NULL," +
            "CONSTRAINT trdd_mes_pk PRIMARY KEY (id_mes));";

    private static final String CMesesAnios = "CREATE TABLE "+ TABLE_NAME_MES_ANIO + " (" +
            COLUMN_NAME_ID_MES_ANIO + " INTEGER NOT NULL,"+
            COLUMN_NAME_NAME_MES_ANIO +" TEXT," +
            "CONSTRAINT trdd_anio_mes_pk PRIMARY KEY (id_anio, id_mes)," +
            "CONSTRAINT trdd_anio_fk FOREIGN KEY (id_anio) REFERENCES trdd_anio (id_anio)," +
            "CONSTRAINT trdd_mes_fk FOREIGN KEY (id_mes) REFERENCES trdd_mes (id_mes));";

    private static final String CNivelEducativo = "CREATE TABLE " + TABLE_NAME_NIVEL_EDUCATIVO + " (" +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_NIVEL_EDUCATIVO + " TEXT NOT NULL," +
            "CONSTRAINT trdd_nivel_educativo_pk PRIMARY KEY (id_nivel_educativo));";

    private static final String CGradoEscolar = "CREATE TABLE " + TABLE_NAME_GRADO_ESCOLAR + " (" +
            COLUMN_NAME_ID_GRADO_ESCOLAR + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_GRADO_ESCOLAR + " TEXT NOT NULL, " +
            COLUMN_NAME_SIGLAS_GRADO_ESCOLAR + " TEXT NOT NULL, " +
            COLUMN_NAME_GRADO_GRADO_ESCOLAR + " TEXT NOT NULL," +
            "CONSTRAINT trdd_grado_escolar_pk PRIMARY KEY (id_grado_escolar));";

    private static final String CNiedGres = "CREATE TABLE " + TABLE_NAME_NIED_GRES + " (" +
            COLUMN_NAME_NE_NIED_GRES + " INTEGER NOT NULL, " +
            COLUMN_NAME_GE_NIED_GRES + " INTEGER NOT NULL," +
            "CONSTRAINT trdd_nege_pk PRIMARY KEY (id_nivel_educativo, id_grado_escolar)," +
            "CONSTRAINT trpd_nege_nivedu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_nivel_educativo (id_nivel_educativo)," +
            "CONSTRAINT trpd_nege_graesc_fk FOREIGN KEY (id_grado_escolar) REFERENCES trdd_grado_escolar (id_grado_escolar));";

    private static final String CIndicador = "CREATE TABLE " + TABLE_NAME_INDICADOR + " (" +
            COLUMN_NAME_ID_INDICADOR + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_INDICADOR + " TEXT NOT NULL," +
            "CONSTRAINT trdd_indicador_pk PRIMARY KEY (id_indicador));";

    private static final String CNivInd = "CREATE TABLE " + TABLE_NAME_NIV_IND + " (" +
            COLUMN_NAME_NE_NIV_IND + " INTEGER NOT NULL, " +
            COLUMN_NAME_IN_NIV_IND + " INTEGER NOT NULL," +
            "CONSTRAINT trdd_nei_nei_pk PRIMARY KEY (id_nivel_educativo, id_indicador)," +
            "CONSTRAINT trdd_nei_nivedu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_nivel_educativo (id_nivel_educativo)," +
            "CONSTRAINT trdd_nei_indicador_fk FOREIGN KEY (id_indicador) REFERENCES trdd_indicador (id_indicador));";

    private static final String CPregunta = "CREATE TABLE " + TABLE_NAME_PREGUNTA + " (" +
            COLUMN_NAME_ID_ANIO_PREGUNTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_MES_PREGUNTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO_PREGUNTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_INDICADOR_PREGUNTA + " INTEGER NOT NULL," +
            COLUMN_NAME_PREGUNTA + " TEXT NOT NULL," +
            "CONSTRAINT trdd_pre_pregunta_pk PRIMARY KEY (id_anio, id_mes, id_nivel_educativo, id_indicador)," +
            "CONSTRAINT trdd_pre_animes_fk FOREIGN KEY (id_anio, id_mes) REFERENCES trdd_anio_mes (id_anio, id_mes)," +
            "CONSTRAINT trdd_pre_niveduind_fk FOREIGN KEY (id_nivel_educativo, id_indicador) REFERENCES trdd_nivedu_ind (id_nivel_educativo, id_indicador));";

    private static final String CEstatusRespuesta = "CREATE TABLE " + TABLE_NAME_ESTATUS_RESPUESTA + " (" +
            COLUMN_NAME_ID_ESTATUS_RESPUESTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_ESTATUS_RESPUESTA + " TEXT NOT NULL," +
            "CONSTRAINT trdd_estatus_respuesta_pk PRIMARY KEY (id_estatus_respuesta));";

    private static final String CPreguntaRespuesta = "CREATE TABLE " + TABLE_NAME_PREGUNTA_RESPUESTA + " (" +
            COLUMN_NAME_ID_ANIO_PREGUNTA_RESPUESTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_MES_PREGUNTA_RESPUESTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO_PREGUNTA_RESPUESTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_INDICADOR_PREGUNTA_RESPUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_RESPUESTA_PREGUNTA_RESPUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_ESTATUS_RESPUESTA_PREGUNTA_RESPUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_RESPUESTA_PREGUNTA_RESPUESTA + " TEXT NOT NULL," +
            "CONSTRAINT trdd_prre_amneirer_pk PRIMARY KEY (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta)," +
            "CONSTRAINT trdd_prre_amnei_fk FOREIGN KEY (id_anio, id_mes, id_nivel_educativo, id_indicador) REFERENCES trdd_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador)," +
            "CONSTRAINT trdd_prre_estres_fk FOREIGN KEY (id_estatus_respuesta) REFERENCES trdd_estatus_respuesta (id_estatus_respuesta));";

    private static final String CCCT = "CREATE TABLE " + TABLE_NAME_CCT + " (" +
            COLUMN_NAME_ID_CCT + " TEXT NOT NULL, " +
            COLUMN_NAME_NOMBRE_CCT + " TEXT NOT NULL, " +
            COLUMN_NAME_DOMICILIO_CCT + " TEXT NOT NULL, " +
            COLUMN_NAME_EMAIL_CCT + " TEXT NOT NULL," +
            COLUMN_NAME_ID_MUNICIPIO_CCT + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO_CCT + " INTEGER NOT NULL," +
            "CONSTRAINT trdd_cct_pk PRIMARY KEY (id_cct)," +
            "CONSTRAINT trdd_cct_mun_fk FOREIGN KEY (id_municipio) REFERENCES tmunicipio (id_municipio)," +
            "CONSTRAINT trdd_cct_niv_edu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_nivel_educativo (id_nivel_educativo));";

    private static final String CEncuesta = "CREATE TABLE " + TABLE_NAME_ENCUESTA + " (" +
            COLUMN_NAME_ID_ENCUESTA_ENCUESTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_CCT_ENCUESTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_ANIO_ENCUESTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_MES_ENCUESTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO_ENCUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_GRADO_ESCOLAR_ENCUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_INDICADOR_ENCUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_RESPUESTA_ENCUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_ESTATUS_RESPUESTA_ENCUESTA + " INTEGER NOT NULL," +
            "CONSTRAINT trdd_enc_cct_fk FOREIGN KEY (id_cct) REFERENCES trdd_cct (id_cct)," +
            "CONSTRAINT trdd_enc_amneirer_fk FOREIGN KEY (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta) REFERENCES trdd_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta)," +
            "CONSTRAINT trdd_enc_cct_fk FOREIGN KEY (id_nivel_educativo, id_grado_escolar) REFERENCES trdd_nied_gres (id_nivel_educativo, id_grado_escolar));";

    /** --------------------------------- Prellenado de bd ----------------------------------**/
    private static final String CInsertDataMunicipio = "INSERT INTO tmunicipio (id_municipio, nombre) VALUES (1, 'TOLUCA');";
    private static final String CInsertDataAnio = "INSERT INTO trdd_anio (id_anio) VALUES('2020');";
    private static final String CInsertDataMes = "INSERT INTO trdd_mes (id_mes, nombre) VALUES (1,'Enero'),(2,'Febrero'),(3,'Marzo'),(4,'Abril'),(5,'Mayo'),(6,'Junio'),(7,'Julio'),(8,'Agosto'),(9,'Septiembre'),(10,'Octubre'),(11,'Noviembre'),(12,'Diciembre');";
    private static final String CInsertDataAnioMes = "INSERT INTO trdd_anio_mes (id_anio, id_mes) VALUES ('2020', 1),('2020', 2),('2020', 3),('2020', 4),('2020', 5),('2020', 6),('2020', 7),('2020', 8),('2020', 9),('2020', 10),('2020', 11),('2020', 12);";
    private static final String CInsertDataNivelEducativo = "INSERT INTO trdd_nivel_educativo(id_nivel_educativo, nombre) VALUES(1,'Primaria'),(2,'Secundaria');";
    private static final String CInsertDataGradoEscolar = "INSERT INTO trdd_grado_escolar (id_grado_escolar, nombre, siglas, grado) VALUES (1,'Primero', '1ero', '1º'),(2,'Segundo', '2do', '2º'),(3,'Tercero', '3ero', '3º'),(4,'Cuarto', '4to', '4º'),(5,'Quinto', '5to', '5º'),(6,'Sexto', '6to', '6º');";
    private static final String CInsertDataNiedGres = "INSERT INTO trdd_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(2,1),(2,2),(2,3);";
    private static final String CInsertDataIndicador = "INSERT INTO trdd_indicador (id_indicador, nombre) VALUES (1,'Determina si es niño o niña'),(2,'Identificación de los valores cívicos'),(3,'Actitudes cívicas'),(4,'Conocimiento del calendario cívico'),(5,'Identificación de las instituciones'),(6,'Identificación de los derechos de Niñas, Niños y Adolecentes (NNA)');";
    private static final String CInsertDataNivEdu = "INSERT INTO trdd_nivedu_ind (id_nivel_educativo, id_indicador) VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(2,1),(2,2),(2,3),(2,4),(2,5),(2,6);";
    private static final String CInsertDataPregunta = "INSERT INTO trdd_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador, pregunta) VALUES ('2020', 1, 1, 1, '¿Primis - Eres niña o niño?'),('2020', 1, 1, 2, '¿Primis - Pregunta 2?'),('2020', 1, 1, 3, '¿Primis - Pregunta 3?'),('2020', 1, 1, 4, '¿Primis - Pregunta 4?'),('2020', 1, 1, 5, '¿Primis - Pregunta 5?'),('2020', 1, 1, 6, '¿Primis - Pregunta 6?'),('2020', 1, 2, 1, '¿Secun - Eres niña o niño?'),('2020', 1, 2, 2, '¿Secun - Pregunta 2?'),('2020', 1, 2, 3, '¿Secun - Pregunta 3?'),('2020', 1, 2, 5, '¿Secun - Pregunta 5?'),('2020', 1, 2, 6, '¿Secun - Pregunta 6?');";
    private static final String CInsertDataEstatusRespuesta = "INSERT INTO trdd_estatus_respuesta(id_estatus_respuesta, nombre) VALUES (1,'Correcta'),(2,'Incorrecta');";
    private static final String CInsertDataPreguntaRespuesta = "INSERT INTO trdd_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES " +
            "('2020',1,1,1,1,1,'Primis/P1/R1: Correcta'),('2020',1,1,1,2,2,'Primis/P1/R2: Incorrecta'),('2020',1,1,1,3,2,'Primis/P1/R3: Incorrecta')," +
            "('2020',1,1,2,1,1,'Primis/P2/R1: Correcta'),('2020',1,1,2,2,2,'Primis/P2/R2: Incorrecta'),('2020',1,1,2,3,2,'Primis/P2/R3: Incorrecta')," +
            "('2020',1,1,3,1,1,'Primis/P3/R1: Correcta'),('2020',1,1,3,2,2,'Primis/P3/R2: Incorrecta'),('2020',1,1,3,3,2,'Primis/P3/R3: Incorrecta')," +
            "('2020',1,1,4,1,1,'Primis/P4/R1: Correcta'),('2020',1,1,4,2,2,'Primis/P4/R2: Incorrecta'),('2020',1,1,4,3,2,'Primis/P4/R3: Incorrecta')," +
            "('2020',1,1,5,1,1,'Primis/P5/R1: Correcta'),('2020',1,1,5,2,2,'Primis/P5/R2: Incorrecta'),('2020',1,1,5,3,2,'Primis/P5/R3: Incorrecta')," +
            "('2020',1,1,6,1,1,'Primis/P6/R1: Correcta'),('2020',1,1,6,2,2,'Primis/P6/R2: Incorrecta'),('2020',1,1,6,3,2,'Primis/P6/R3: Incorrecta')," +
            "('2020',1,2,1,1,1,'Secun/P1/R1: Correcta'),('2020',1,2,1,2,2,'Secun/P1/R2: Incorrecta'),('2020',1,2,1,3,2,'Secun/P1/R3: Incorrecta')," +
            "('2020',1,2,2,1,1,'Secun/P2/R1: Correcta'),('2020',1,2,2,2,2,'Secun/P2/R2: Incorrecta'),('2020',1,2,2,3,2,'Secun/P2/R3: Incorrecta')," +
            "('2020',1,2,3,1,1,'Secun/P3/R1: Correcta'),('2020',1,2,3,2,2,'Secun/P3/R2: Incorrecta'),('2020',1,2,3,3,2,'Secun/P3/R3: Incorrecta')," +
            "('2020',1,2,4,1,1,'Secun/P4/R1: Correcta'),('2020',1,2,4,2,2,'Secun/P4/R2: Incorrecta'),('2020',1,2,4,3,2,'Secun/P4/R3: Incorrecta')," +
            "('2020',1,2,5,1,1,'Secun/P5/R1: Correcta'),('2020',1,2,5,2,2,'Secun/P5/R2: Incorrecta'),('2020',1,2,5,3,2,'Secun/P5/R3: Incorrecta')," +
            "('2020',1,2,6,1,1,'Secun/P6/R1: Correcta'),('2020',1,2,6,2,2,'Secun/P6/R2: Incorrecta'),('2020',1,2,6,3,2,'Secun/P6/R3: Incorrecta');";
    private static final String CInsertDataCCT = "INSERT INTO trdd_cct (id_cct, nombre, domicilio, email, id_municipio, id_nivel_educativo) VALUES(1, 'PRIMARIA AMADO NERVO', 'ESQUINA HERIBERTO HENRIQUEZ CON CEBORUCO','gvaldez@ieem.org.mx',1,1),(2, 'SECUNDARIA TÉCNICA #49 SAMUEL RAMOS', 'PRIVADA DE TLALOC #100','gvaldez@ieem.org.mx',1,2);";
    /** --------------------------------- Variables y Helpers ----------------------------------**/
    private DBHelper helper;
    private SQLiteDatabase database;
    private Context context;

    public DataBaseAppRed(Context context) {
        this.context = context;
    }

    public DataBaseAppRed open(){
        helper = new DBHelper(context);
        database = helper.getWritableDatabase();
        return this;
    }

    public void close() {
        helper.close();
        database.close();
    }

    private Cursor querySQL(String sql) {
        Cursor regreso = null;
        open();
        regreso = database.rawQuery(sql,null);
        return regreso;
    }




    // Query utilizado para insertar los valores de las respuestas a las preguntas de la encuesta.
    public void InsertEncuesta(int insIdE, String insCct, String insAni, int insMes, int insNivE, int insGrE, int insInd, int insRes, int insEsR) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_ENCUESTA_ENCUESTA, (insIdE));
        values.put(COLUMN_NAME_ID_CCT_ENCUESTA, (insCct));
        values.put(COLUMN_NAME_ID_ANIO_ENCUESTA, (insAni));
        values.put(COLUMN_NAME_ID_MES_ENCUESTA, (insMes));
        values.put(COLUMN_NAME_ID_NIVEL_EDUCATIVO_ENCUESTA, (insNivE));
        values.put(COLUMN_NAME_ID_GRADO_ESCOLAR_ENCUESTA, (insGrE));
        values.put(COLUMN_NAME_ID_INDICADOR_ENCUESTA, (insInd));
        values.put(COLUMN_NAME_ID_RESPUESTA_ENCUESTA, (insRes));
        values.put(COLUMN_NAME_ID_ESTATUS_RESPUESTA_ENCUESTA, (insEsR));
        database.insert(TABLE_NAME_ENCUESTA,null,values);
        close();
    }
    public ArrayList<tmunicipio> getMunicipio() {
        ArrayList<tmunicipio> tmunicipios = new ArrayList<>();
        Cursor dataCursor = querySQL("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME_ID+ " LIKE "+"'"+actual_final.getId_municipio()+"'");
        if (dataCursor != null && dataCursor.getCount() > 0){
            for (dataCursor.moveToFirst() ; !dataCursor.isAfterLast() ; dataCursor.moveToNext()){
                int id = dataCursor.getInt(dataCursor.getColumnIndex(COLUMN_NAME_ID));
                String name = dataCursor.getString(dataCursor.getColumnIndex(COLUMN_NAME_NAME));
                tmunicipios.add(new tmunicipio(id,name));
            }
        }
        close();
        return tmunicipios;
    }

    // Metodo que se utilizara para regresar el objeto de tipo cct egun el id_CCCT
    public ArrayList<trdd_cct> getCCT(String cctSelect) {
        ArrayList<trdd_cct> trddcct = new ArrayList<>();
        Cursor dataCursor = querySQL("SELECT * FROM " + TABLE_NAME_CCT + " WHERE " + COLUMN_NAME_ID_CCT+ " LIKE "+"'"+cctSelect+"'");
        Log.d(TAG, ""+dataCursor.getCount());
        if (dataCursor != null && dataCursor.getCount() > 0){
            for (dataCursor.moveToFirst() ; !dataCursor.isAfterLast() ; dataCursor.moveToNext()){
                String id = dataCursor.getString(0);
                String nombre = dataCursor.getString(1);
                String domicilio = dataCursor.getString(2);
                String email = dataCursor.getString(3);
                int id_municipio = dataCursor.getInt(4);
                int id_nivel_educativo = dataCursor.getInt(5);
                trddcct.add(new trdd_cct(id,nombre,domicilio,email,id_municipio,id_nivel_educativo));
            }
        }
        close();
        return trddcct;
    }

    public Cursor getUltimoRegistro() {
        Cursor dataCursor = querySQL("SELECT max(trdd_encuesta.id_Encuesta) FROM trdd_encuesta");
        return dataCursor;
    }

    public Cursor getMesesBD() {
        Cursor dataCursor = querySQL("SELECT trdd_mes.id_mes as _id,trdd_mes.nombre FROM " + TABLE_NAME_MES );
        return dataCursor;
    }

    public Cursor getGradosBD() {
        Cursor dataCursor = querySQL("SELECT trdd_grado_escolar.id_grado_escolar as _id,trdd_grado_escolar.nombre,trdd_grado_escolar.siglas,trdd_grado_escolar.grado FROM trdd_grado_escolar");
        return dataCursor;
    }

    public Cursor getPreguntasEncuestaBD() {
        Cursor dataCursor = querySQL("SELECT trdd_pregunta.id_anio as _id,trdd_pregunta.id_mes,trdd_pregunta.id_nivel_educativo,trdd_pregunta.id_indicador,trdd_pregunta.pregunta FROM trdd_pregunta WHERE trdd_pregunta.id_nivel_educativo = "+ actual_final.getId_nivel_educativo());
        return dataCursor;
    }

    public Cursor getRespuestasEncuestaBD(int indicador) {
        Cursor dataCursor = querySQL("SELECT trdd_pregunta_respuesta.id_anio as _id,trdd_pregunta_respuesta.id_mes,trdd_pregunta_respuesta.id_nivel_educativo,trdd_pregunta_respuesta.id_indicador,trdd_pregunta_respuesta.id_respuesta,trdd_pregunta_respuesta.id_estatus_respuesta,trdd_pregunta_respuesta.respuesta FROM trdd_pregunta_respuesta WHERE trdd_pregunta_respuesta.id_nivel_educativo = "+ actual_final.getId_nivel_educativo()+" AND trdd_pregunta_respuesta.id_indicador = "+indicador);
        return dataCursor;
    }


    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DataBaseName, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CMunicipios);
            db.execSQL(CAnios);
            db.execSQL(CMeses);
            db.execSQL(CMesesAnios);
            db.execSQL(CNivelEducativo);
            db.execSQL(CGradoEscolar);
            db.execSQL(CNiedGres);
            db.execSQL(CIndicador);
            db.execSQL(CNivInd);
            db.execSQL(CPregunta);
            db.execSQL(CEstatusRespuesta);
            db.execSQL(CPreguntaRespuesta);
            db.execSQL(CCCT);
            db.execSQL(CEncuesta);
            //Llenado de la bd
            db.execSQL(CInsertDataMunicipio);
            db.execSQL(CInsertDataAnio);
            db.execSQL(CInsertDataMes);
            db.execSQL(CInsertDataAnioMes);
            db.execSQL(CInsertDataNivelEducativo);
            db.execSQL(CInsertDataGradoEscolar);
            db.execSQL(CInsertDataNiedGres);
            db.execSQL(CInsertDataIndicador);
            db.execSQL(CInsertDataNivEdu);
            db.execSQL(CInsertDataPregunta);
            db.execSQL(CInsertDataEstatusRespuesta);
            db.execSQL(CInsertDataPreguntaRespuesta);
            db.execSQL(CInsertDataCCT);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ANIOS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MES);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MES_ANIO);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_NIVEL_EDUCATIVO);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_GRADO_ESCOLAR);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_NIED_GRES);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_INDICADOR);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_NIV_IND);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PREGUNTA);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ESTATUS_RESPUESTA);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PREGUNTA_RESPUESTA);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CCT);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ENCUESTA);
            onCreate(db);
        }
    }
}
