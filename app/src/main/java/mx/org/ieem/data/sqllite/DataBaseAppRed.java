package mx.org.ieem.data.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import mx.org.ieem.data.sqllite.models.tmunicipio;
import mx.org.ieem.data.sqllite.models.trdd_cct;

import static mx.org.ieem.RESTful.AsyncLogin.actual_final;
import static mx.org.ieem.data.sqllite.constants.Constantes.*;


public class DataBaseAppRed
{
    /** --------------------------------- Variables y Helpers ----------------------------------**/
    public DBHelper helper;
    public SQLiteDatabase database;
    public Context context;

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

    /** --------------------------------- Declaración de Tablas ----------------------------------**/
    public static final String CMunicipios = "CREATE TABLE " + TABLE_NAME_TMUNICIPIO + " (" +
            COLUMN_NAME_ID_TMUNICIPIO + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_TMUNICIPIO + " TEXT NOT NULL," +
            "CONSTRAINT trpc_municipio_pk PRIMARY KEY (id_municipio));";

    public static final String CAnios = "CREATE TABLE " + TABLE_NAME_ANIOS + " (" +
            COLUMN_NAME_ID_ANIOS + " TEXT NOT NULL," +
            "CONSTRAINT trdd_anio_pk PRIMARY KEY (id_anio));";

    public static final String CMeses = "CREATE TABLE " + TABLE_NAME_MES + " (" +
            COLUMN_NAME_ID_MES + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_MES + " TEXT NOT NULL," +
            "CONSTRAINT trdd_mes_pk PRIMARY KEY (id_mes));";

    public static final String CMesesAnios = "CREATE TABLE "+ TABLE_NAME_MES_ANIO + " (" +
            COLUMN_NAME_ID_MES_ANIO + " INTEGER NOT NULL,"+
            COLUMN_NAME_NAME_MES_ANIO +" TEXT," +
            "CONSTRAINT trdd_anio_mes_pk PRIMARY KEY (id_anio, id_mes)," +
            "CONSTRAINT trdd_anio_fk FOREIGN KEY (id_anio) REFERENCES trdd_anio (id_anio)," +
            "CONSTRAINT trdd_mes_fk FOREIGN KEY (id_mes) REFERENCES trdd_mes (id_mes));";

    public static final String CNivelEducativo = "CREATE TABLE " + TABLE_NAME_NIVEL_EDUCATIVO + " (" +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_NIVEL_EDUCATIVO + " TEXT NOT NULL," +
            "CONSTRAINT trdd_nivel_educativo_pk PRIMARY KEY (id_nivel_educativo));";

    public static final String CGradoEscolar = "CREATE TABLE " + TABLE_NAME_GRADO_ESCOLAR + " (" +
            COLUMN_NAME_ID_GRADO_ESCOLAR + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_GRADO_ESCOLAR + " TEXT NOT NULL, " +
            COLUMN_NAME_SIGLAS_GRADO_ESCOLAR + " TEXT NOT NULL, " +
            COLUMN_NAME_GRADO_GRADO_ESCOLAR + " TEXT NOT NULL," +
            "CONSTRAINT trdd_grado_escolar_pk PRIMARY KEY (id_grado_escolar));";

    public static final String CNiedGres = "CREATE TABLE " + TABLE_NAME_NIED_GRES + " (" +
            COLUMN_NAME_NE_NIED_GRES + " INTEGER NOT NULL, " +
            COLUMN_NAME_GE_NIED_GRES + " INTEGER NOT NULL," +
            "CONSTRAINT trdd_nege_pk PRIMARY KEY (id_nivel_educativo, id_grado_escolar)," +
            "CONSTRAINT trpd_nege_nivedu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_nivel_educativo (id_nivel_educativo)," +
            "CONSTRAINT trpd_nege_graesc_fk FOREIGN KEY (id_grado_escolar) REFERENCES trdd_grado_escolar (id_grado_escolar));";

    public static final String CIndicador = "CREATE TABLE " + TABLE_NAME_INDICADOR + " (" +
            COLUMN_NAME_ID_INDICADOR + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_INDICADOR + " TEXT NOT NULL," +
            "CONSTRAINT trdd_indicador_pk PRIMARY KEY (id_indicador));";

    public static final String CNivInd = "CREATE TABLE " + TABLE_NAME_NIV_IND + " (" +
            COLUMN_NAME_NE_NIV_IND + " INTEGER NOT NULL, " +
            COLUMN_NAME_IN_NIV_IND + " INTEGER NOT NULL," +
            "CONSTRAINT trdd_nei_nei_pk PRIMARY KEY (id_nivel_educativo, id_indicador)," +
            "CONSTRAINT trdd_nei_nivedu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_nivel_educativo (id_nivel_educativo)," +
            "CONSTRAINT trdd_nei_indicador_fk FOREIGN KEY (id_indicador) REFERENCES trdd_indicador (id_indicador));";

    public static final String CPregunta = "CREATE TABLE " + TABLE_NAME_PREGUNTA + " (" +
            COLUMN_NAME_ID_ANIO_PREGUNTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_MES_PREGUNTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO_PREGUNTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_INDICADOR_PREGUNTA + " INTEGER NOT NULL," +
            COLUMN_NAME_PREGUNTA + " TEXT NOT NULL," +
            "CONSTRAINT trdd_pre_pregunta_pk PRIMARY KEY (id_anio, id_mes, id_nivel_educativo, id_indicador)," +
            "CONSTRAINT trdd_pre_animes_fk FOREIGN KEY (id_anio, id_mes) REFERENCES trdd_anio_mes (id_anio, id_mes)," +
            "CONSTRAINT trdd_pre_niveduind_fk FOREIGN KEY (id_nivel_educativo, id_indicador) REFERENCES trdd_nivedu_ind (id_nivel_educativo, id_indicador));";

    public static final String CEstatusRespuesta = "CREATE TABLE " + TABLE_NAME_ESTATUS_RESPUESTA + " (" +
            COLUMN_NAME_ID_ESTATUS_RESPUESTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_NAME_ESTATUS_RESPUESTA + " TEXT NOT NULL," +
            "CONSTRAINT trdd_estatus_respuesta_pk PRIMARY KEY (id_estatus_respuesta));";

    public static final String CPreguntaRespuesta = "CREATE TABLE " + TABLE_NAME_PREGUNTA_RESPUESTA + " (" +
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

    public static final String CCCT = "CREATE TABLE " + TABLE_NAME_CCT + " (" +
            COLUMN_NAME_ID_CCT + " TEXT NOT NULL, " +
            COLUMN_NAME_NOMBRE_CCT + " TEXT NOT NULL, " +
            COLUMN_NAME_DOMICILIO_CCT + " TEXT NOT NULL, " +
            COLUMN_NAME_EMAIL_CCT + " TEXT NOT NULL," +
            COLUMN_NAME_ID_MUNICIPIO_CCT + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO_CCT + " INTEGER NOT NULL," +
            "CONSTRAINT trdd_cct_pk PRIMARY KEY (id_cct)," +
            "CONSTRAINT trdd_cct_mun_fk FOREIGN KEY (id_municipio) REFERENCES tmunicipio (id_municipio)," +
            "CONSTRAINT trdd_cct_niv_edu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_nivel_educativo (id_nivel_educativo));";


    public static final String CEncuesta = "CREATE TABLE " + TABLE_NAME_ENCUESTA + " (" +
            COLUMN_NAME_ID_CCT_ENCUESTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_ENCUESTA_ENCUESTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_ANIO_ENCUESTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_MES_ENCUESTA + " INTEGER NOT NULL, " +
            COLUMN_NAME_ID_NIVEL_EDUCATIVO_ENCUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_GRADO_ESCOLAR_ENCUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_INDICADOR_ENCUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_RESPUESTA_ENCUESTA + " INTEGER NOT NULL," +
            COLUMN_NAME_ID_ESTATUS_RESPUESTA_ENCUESTA + " INTEGER NOT NULL," +
            "CONSTRAINT trdd_enc_camnegeirer_pk PRIMARY KEY (id_cct, id_random, id_anio, id_mes, id_nivel_educativo, id_grado_escolar, id_indicador, id_respuesta, id_estatus_respuesta)," +
            "CONSTRAINT trdd_enc_cct_fk FOREIGN KEY (id_cct) REFERENCES trdd_cct (id_cct)," +
            "CONSTRAINT trdd_enc_amneirer_fk FOREIGN KEY (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta) REFERENCES trdd_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta)," +
            "CONSTRAINT trdd_niedgres_cct_fk FOREIGN KEY (id_nivel_educativo, id_grado_escolar) REFERENCES trdd_nied_gres (id_nivel_educativo, id_grado_escolar));";

    public static final String CParametros = "CREATE TABLE " + TABLE_NAME_PARAMETROS + " (" +
            COLUMN_NAME_ID_PARAMETROS+ " INTEGER NOT NULL, " +
            COLUMN_NAME_TABLAS_PARAMETROS + " TEXT NOT NULL, " +
            COLUMN_NAME_VERSION_PARAMETROS + " TEXT NOT NULL, " +
            "CONSTRAINT trdd_parametros_version_pk PRIMARY KEY (id_Parametros));";


    /** --------------------------------- Prellenado de bd ----------------------------------**/
    //public static final String CInsertDataMunicipio = "INSERT INTO tmunicipio (id_municipio, nombre) VALUES (1, 'TOLUCA');";
    public static final String CInsertDataAnio = "INSERT INTO trdd_anio (id_anio) VALUES('2020');";
    public static final String CInsertDataMes = "INSERT INTO trdd_mes (id_mes, nombre) VALUES (1,'Enero'),(2,'Febrero'),(3,'Marzo'),(4,'Abril'),(5,'Mayo'),(6,'Junio'),(7,'Julio'),(8,'Agosto'),(9,'Septiembre'),(10,'Octubre'),(11,'Noviembre'),(12,'Diciembre');";
    public static final String CInsertDataAnioMes = "INSERT INTO trdd_anio_mes (id_anio, id_mes) VALUES ('2020', 1),('2020', 2),('2020', 3),('2020', 4),('2020', 5),('2020', 6),('2020', 7),('2020', 8),('2020', 9),('2020', 10),('2020', 11),('2020', 12);";
    public static final String CInsertDataNivelEducativo = "INSERT INTO trdd_nivel_educativo(id_nivel_educativo, nombre) VALUES(1,'Primaria'),(2,'Secundaria');";
    public static final String CInsertDataGradoEscolar = "INSERT INTO trdd_grado_escolar (id_grado_escolar, nombre, siglas, grado) VALUES (1,'Primero', '1ero', '1º'),(2,'Segundo', '2do', '2º'),(3,'Tercero', '3ero', '3º'),(4,'Cuarto', '4to', '4º'),(5,'Quinto', '5to', '5º'),(6,'Sexto', '6to', '6º');";
    public static final String CInsertDataNiedGres = "INSERT INTO trdd_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(2,1),(2,2),(2,3);";
    public static final String CInsertDataIndicador = "INSERT INTO trdd_indicador (id_indicador, nombre) VALUES (1,'Determina si es niño o niña'),(2,'Identificación de los valores cívicos'),(3,'Actitudes cívicas'),(4,'Conocimiento del calendario cívico'),(5,'Identificación de las instituciones'),(6,'Identificación de los derechos de Niñas, Niños y Adolecentes (NNA)');";
    public static final String CInsertDataNivEdu = "INSERT INTO trdd_nivedu_ind (id_nivel_educativo, id_indicador) VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(2,1),(2,2),(2,3),(2,4),(2,5),(2,6);";
    public static final String CInsertDataPregunta = "INSERT INTO trdd_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador, pregunta) VALUES ('2020', 1, 1, 1, '¿Primis - Eres niña o niño?'),('2020', 1, 1, 2, '¿Primis - Pregunta 2?'),('2020', 1, 1, 3, '¿Primis - Pregunta 3?'),('2020', 1, 1, 4, '¿Primis - Pregunta 4?'),('2020', 1, 1, 5, '¿Primis - Pregunta 5?'),('2020', 1, 1, 6, '¿Primis - Pregunta 6?'),('2020', 1, 2, 1, '¿Secun - Eres niña o niño?'),('2020', 1, 2, 2, '¿Secun - Pregunta 2?'),('2020', 1, 2, 3, '¿Secun - Pregunta 3?'),('2020', 1, 2, 5, '¿Secun - Pregunta 5?'),('2020', 1, 2, 6, '¿Secun - Pregunta 6?');";
    public static final String CInsertDataEstatusRespuesta = "INSERT INTO trdd_estatus_respuesta(id_estatus_respuesta, nombre) VALUES (1,'Correcta'),(2,'Incorrecta');";
    public static final String CInsertDataPreguntaRespuesta = "INSERT INTO trdd_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES " +
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
    public static final String CInsertDataCCT = "INSERT INTO trdd_cct (id_cct, nombre, domicilio, email, id_municipio, id_nivel_educativo) VALUES(1, 'PRIMARIA AMADO NERVO', 'ESQUINA HERIBERTO HENRIQUEZ CON CEBORUCO','gvaldez@ieem.org.mx',1,1),(2, 'SECUNDARIA TÉCNICA #49 SAMUEL RAMOS', 'PRIVADA DE TLALOC #100','gvaldez@ieem.org.mx',1,2);";


    public Cursor querySQL(String sql) {
        Cursor regreso = null;
        open();
        regreso = database.rawQuery(sql,null);
        return regreso;
    }

    public void insertarTMunicipio(int id, String nombre){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_TMUNICIPIO, (id));
        values.put(COLUMN_NAME_NAME_TMUNICIPIO, (nombre));
        database.insert(TABLE_NAME_TMUNICIPIO,null,values);
        close();
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
        Cursor dataCursor = querySQL("SELECT * FROM " + TABLE_NAME_TMUNICIPIO + " WHERE " + COLUMN_NAME_ID_TMUNICIPIO+ " LIKE "+"'"+actual_final.getId_municipio()+"'");
        if (dataCursor != null && dataCursor.getCount() > 0){
            for (dataCursor.moveToFirst() ; !dataCursor.isAfterLast() ; dataCursor.moveToNext()){
                int id = dataCursor.getInt(dataCursor.getColumnIndex(COLUMN_NAME_ID_TMUNICIPIO));
                String name = dataCursor.getString(dataCursor.getColumnIndex(COLUMN_NAME_NAME_TMUNICIPIO));
                tmunicipios.add(new tmunicipio(id,name));
            }
        }
        close();
        return tmunicipios;
    }

    // Metodo que se utilizara para regresar el objeto de tipo cct segun el id_CCT
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

    public int getNumerodeEncuestasPorMesyGrado( int id_mes , int id_grado)
    {
        Cursor dataCursor = querySQL("SELECT * FROM " + TABLE_NAME_ENCUESTA + " WHERE " + COLUMN_NAME_ID_GRADO_ESCOLAR_ENCUESTA + " = " + id_grado + " AND " + COLUMN_NAME_ID_MES_ENCUESTA + " = " + id_mes);
        // TODO Cambiar el 6 por variable que cambie deacuerdo al numero de indicadores.
        return dataCursor.getCount()/6;
    }

    // Regresa el usuario que esta logueado actualmente.
    public Cursor getUsuarioLogueado() {
        Cursor dataCursor = querySQL("SELECT * FROM "+ TABLE_NAME_CCT);
        return dataCursor;
    }

    // Inserta un nuevo usuario logueado a la bd.
    public void insertCctActual(String insCct, String insNom, String insDom, String insMail, int insMun, int insNivE)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_CCT, (insCct));
        values.put(COLUMN_NAME_NOMBRE_CCT, (insNom));
        values.put(COLUMN_NAME_DOMICILIO_CCT, (insDom));
        values.put(COLUMN_NAME_EMAIL_CCT, (insMail));
        values.put(COLUMN_NAME_ID_MUNICIPIO_CCT, (insMun));
        values.put(COLUMN_NAME_ID_NIVEL_EDUCATIVO_CCT, (insNivE));
        database.insert(TABLE_NAME_CCT,null,values);
        close();
    }

    // Elimina al usuario logueado actualmente.
    public void logoutUsario()
    {
        open();
        database.execSQL("DELETE FROM "+TABLE_NAME_CCT);
        close();
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



}
