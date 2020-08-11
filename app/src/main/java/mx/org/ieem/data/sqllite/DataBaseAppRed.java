package mx.org.ieem.data.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import mx.org.ieem.data.sqllite.models.tmunicipio;
import mx.org.ieem.data.sqllite.models.trdd_anio;
import mx.org.ieem.data.sqllite.models.trdd_anio_mes;
import mx.org.ieem.data.sqllite.models.trdd_cct;
import mx.org.ieem.data.sqllite.models.trdd_estatus_respuesta;
import mx.org.ieem.data.sqllite.models.trdd_grado_escolar;
import mx.org.ieem.data.sqllite.models.trdd_indicador;
import mx.org.ieem.data.sqllite.models.trdd_mes;
import mx.org.ieem.data.sqllite.models.trdd_nied_gres;
import mx.org.ieem.data.sqllite.models.trdd_nivedu_ind;
import mx.org.ieem.data.sqllite.models.trdd_nivel_educativo;
import mx.org.ieem.data.sqllite.models.trdd_parametros_version;
import mx.org.ieem.data.sqllite.models.trdd_pregunta;
import mx.org.ieem.data.sqllite.models.trdd_pregunta_respuesta;

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
            COLUMN_NAME_ID_MES_ANIO + " TEXT NOT NULL,"+
            COLUMN_NAME_NAME_MES_ANIO +" INTEGER NOT NULL," +
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
            "CONSTRAINT trdd_nege_nivedu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_nivel_educativo (id_nivel_educativo)," +
            "CONSTRAINT trdd_nege_graesc_fk FOREIGN KEY (id_grado_escolar) REFERENCES trdd_grado_escolar (id_grado_escolar));";

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
            COLUMN_NAME_ID_RANDOM_ENCUESTA + " TEXT NOT NULL, " +
            COLUMN_NAME_ID_ENCUESTA_ENCUESTA + " INTEGER NOT NULL, " +
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
            COLUMN_NAME_VERSION_PARAMETROS + " INTEGER NOT NULL, " +
            "CONSTRAINT trdd_parametros_version_pk PRIMARY KEY (id_Parametros));";



    public Cursor querySQL(String sql) {
        Cursor regreso = null;
        open();
        regreso = database.rawQuery(sql,null);
        return regreso;
    }




    // Query utilizado para insertar los valores de las respuestas a las preguntas de la encuesta.
    public void InsertEncuesta(String insIdCct, String insIdRandom,int insIdEnc, String insIdAni, int insIdMes, int insIdNiE, int insIdGrE, int insIdInd, int insIdRes, int insIdEsR) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_CCT_ENCUESTA, (insIdCct));
        values.put(COLUMN_NAME_ID_RANDOM_ENCUESTA, (insIdRandom));
        values.put(COLUMN_NAME_ID_ENCUESTA_ENCUESTA, (insIdEnc));
        values.put(COLUMN_NAME_ID_ANIO_ENCUESTA, (insIdAni));
        values.put(COLUMN_NAME_ID_MES_ENCUESTA, (insIdMes));
        values.put(COLUMN_NAME_ID_NIVEL_EDUCATIVO_ENCUESTA, (insIdNiE));
        values.put(COLUMN_NAME_ID_GRADO_ESCOLAR_ENCUESTA, (insIdGrE));
        values.put(COLUMN_NAME_ID_INDICADOR_ENCUESTA, (insIdInd));
        values.put(COLUMN_NAME_ID_RESPUESTA_ENCUESTA, (insIdRes));
        values.put(COLUMN_NAME_ID_ESTATUS_RESPUESTA_ENCUESTA, (insIdEsR));
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

    public Cursor getVersionPorTabla(String nombreTabla){
        Cursor dataCursor = querySQL("SELECT * FROM " + TABLE_NAME_PARAMETROS + " WHERE tabla like '" + nombreTabla + "'");
        return dataCursor;
    }

    // Inserta un nuevo usuario logueado a la bd. (TOP)
    public void insertCctActual(trdd_cct actual)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_CCT, (actual.getId_cct()));
        values.put(COLUMN_NAME_NOMBRE_CCT, (actual.getNombre()));
        values.put(COLUMN_NAME_DOMICILIO_CCT, (actual.getDomicilio()));
        values.put(COLUMN_NAME_EMAIL_CCT, (actual.getEmail()));
        values.put(COLUMN_NAME_ID_MUNICIPIO_CCT, (actual.getId_municipio()));
        values.put(COLUMN_NAME_ID_NIVEL_EDUCATIVO_CCT, (actual.getId_nivel_educativo()));
        database.insert(TABLE_NAME_CCT,null,values);
        close();
    }

    public void insertMunicipioActual(tmunicipio actual)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_TMUNICIPIO, (actual.getId()));
        values.put(COLUMN_NAME_NAME_TMUNICIPIO, (actual.getNombre()));
        database.insert(TABLE_NAME_TMUNICIPIO,null,values);
        close();
    }

    public void insertNivelEducativoActual(trdd_nivel_educativo actual)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_NIVEL_EDUCATIVO, (actual.getId_nivel_educativo()));
        values.put(COLUMN_NAME_NAME_NIVEL_EDUCATIVO, (actual.getNombre()));
        database.insert(TABLE_NAME_NIVEL_EDUCATIVO,null,values);
        close();
    }

    public void insertVersiondeTabla(trdd_parametros_version actual)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_PARAMETROS, (actual.getId_Parametros()));
        values.put(COLUMN_NAME_TABLAS_PARAMETROS, (actual.getTabla()));
        values.put(COLUMN_NAME_VERSION_PARAMETROS, (actual.getVersion()));
        database.insert(TABLE_NAME_PARAMETROS,null,values);
        close();
    }
    // Inserta un nuevo usuario logueado a la bd. (BOTTOM)

    // Inserta nueva bd. (TOP)
    public void insertAnios(trdd_anio anio){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_ANIOS, (anio.getId_anio()));
        database.insert(TABLE_NAME_ANIOS,null,values);
        close();
    }

    public void insertMeses(trdd_mes mes){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_MES, (mes.getId_mes()));
        values.put(COLUMN_NAME_NAME_MES, (mes.getNombre()));
        database.insert(TABLE_NAME_MES,null,values);
        close();
    }

    public void insertAniosMeses(trdd_anio_mes anioMes){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_MES_ANIO, (anioMes.getId_anio()));
        values.put(COLUMN_NAME_NAME_MES_ANIO, (anioMes.getId_mes()));
        database.insert(TABLE_NAME_MES_ANIO,null,values);
        close();
    }

    public void insertGradoEscolar(trdd_grado_escolar gradoEscolar){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_GRADO_ESCOLAR, (gradoEscolar.getId_grado_escolar()));
        values.put(COLUMN_NAME_NAME_GRADO_ESCOLAR, (gradoEscolar.getNombre()));
        values.put(COLUMN_NAME_SIGLAS_GRADO_ESCOLAR, (gradoEscolar.getSiglas()));
        values.put(COLUMN_NAME_GRADO_GRADO_ESCOLAR, (gradoEscolar.getGrado()));
        database.insert(TABLE_NAME_GRADO_ESCOLAR,null,values);
        close();
    }

    public void insertNiedGres(trdd_nied_gres niedGres){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_NE_NIED_GRES, (niedGres.getId_nivel_educativo()));
        values.put(COLUMN_NAME_GE_NIED_GRES, (niedGres.getId_grado_escolar()));
        database.insert(TABLE_NAME_NIED_GRES,null,values);
        close();
    }

    public void insertIndicador(trdd_indicador indicador){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_INDICADOR, (indicador.getId_indicador()));
        values.put(COLUMN_NAME_NAME_INDICADOR, (indicador.getNombre()));
        database.insert(TABLE_NAME_INDICADOR,null,values);
        close();
    }

    public void insertNivelIndicador(trdd_nivedu_ind niveduIndicador){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_NE_NIV_IND, (niveduIndicador.getId_nivel_educativo()));
        values.put(COLUMN_NAME_IN_NIV_IND, (niveduIndicador.getId_indicador()));
        database.insert(TABLE_NAME_NIV_IND,null,values);
        close();
    }

    public void insertPregunta(trdd_pregunta pregunta){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_ANIO_PREGUNTA, (pregunta.getId_anio()));
        values.put(COLUMN_NAME_ID_MES_PREGUNTA, (pregunta.getId_mes()));
        values.put(COLUMN_NAME_ID_NIVEL_EDUCATIVO_PREGUNTA, (pregunta.getId_nivel_educativo()));
        values.put(COLUMN_NAME_ID_INDICADOR_PREGUNTA, (pregunta.getId_indicador()));
        values.put(COLUMN_NAME_PREGUNTA, (pregunta.getPregunta()));
        database.insert(TABLE_NAME_PREGUNTA,null,values);
        close();
    }

    public void insertEstatusRespuesta(trdd_estatus_respuesta estatusRespuesta){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_ESTATUS_RESPUESTA, (estatusRespuesta.getId_estatus_respuesta()));
        values.put(COLUMN_NAME_NAME_ESTATUS_RESPUESTA, (estatusRespuesta.getNombre()));
        database.insert(TABLE_NAME_ESTATUS_RESPUESTA,null,values);
        close();
    }

    public void insertPreguntaRespuesta(trdd_pregunta_respuesta preguntaRespuesta){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_ANIO_PREGUNTA_RESPUESTA, (preguntaRespuesta.getId_anio()));
        values.put(COLUMN_NAME_ID_MES_PREGUNTA_RESPUESTA, (preguntaRespuesta.getId_mes()));
        values.put(COLUMN_NAME_ID_NIVEL_EDUCATIVO_PREGUNTA_RESPUESTA, (preguntaRespuesta.getId_nivel_educativo()));
        values.put(COLUMN_NAME_ID_INDICADOR_PREGUNTA_RESPUESTA, (preguntaRespuesta.getId_indicador()));
        values.put(COLUMN_NAME_ID_RESPUESTA_PREGUNTA_RESPUESTA, (preguntaRespuesta.getId_respuesta()));
        values.put(COLUMN_NAME_ID_ESTATUS_RESPUESTA_PREGUNTA_RESPUESTA, (preguntaRespuesta.getId_estatus_respuesta()));
        values.put(COLUMN_NAME_RESPUESTA_PREGUNTA_RESPUESTA, (preguntaRespuesta.getRespuesta()));
        database.insert(TABLE_NAME_PREGUNTA_RESPUESTA,null,values);
        close();
    }

    public void deleteAnios(){
        open();
        database.execSQL("DELETE FROM "+TABLE_NAME_ANIOS);
        close();
    }

    public void deleteMeses(){
        open();
        database.execSQL("DELETE FROM "+TABLE_NAME_MES);
        close();
    }

    public void deleteAniosMeses(){
        open();
        database.execSQL("DELETE FROM "+TABLE_NAME_MES_ANIO);
        close();
    }

    public void deleteGradoEscolar(){
        open();
        database.execSQL("DELETE FROM "+TABLE_NAME_GRADO_ESCOLAR);
        close();
    }

    public void deleteNiedGres(){
        open();
        database.execSQL("DELETE FROM "+ TABLE_NAME_NIED_GRES);
        close();
    }

    public void deleteIndicador(){
        open();
        database.execSQL("DELETE FROM " + TABLE_NAME_INDICADOR);
        close();
    }

    public void deleteNivEduIndicador(){
        open();
        database.execSQL("DELETE FROM " + TABLE_NAME_NIV_IND);
        close();
    }

    public void deletePreguntas(){
        open();
        database.execSQL("DELETE FROM " + TABLE_NAME_PREGUNTA);
        close();
    }

    public void deleteEstatusRespuesta(){
        open();
        database.execSQL("DELETE FROM " + TABLE_NAME_ESTATUS_RESPUESTA);
        close();
    }

    public void deletePreguntaRespuesta(){
        open();
        database.execSQL("DELETE FROM " + TABLE_NAME_PREGUNTA_RESPUESTA);
        close();
    }

    // Inserta nueva bd. (BOTTOM)

    public Cursor isVersionVacia()
    {
        Cursor dataCursor = querySQL("SELECT * FROM trdd_parametros_version");
        return dataCursor;
    }

    // Elimina al usuario logueado actualmente.
    public void logoutUsario()
    {
        open();
        database.execSQL("DELETE FROM "+TABLE_NAME_CCT);
        database.execSQL("DELETE FROM "+TABLE_NAME_NIVEL_EDUCATIVO);
        database.execSQL("DELETE FROM "+TABLE_NAME_TMUNICIPIO);
        close();
    }

    public Cursor getUltimoRegistro() {
        Cursor dataCursor = querySQL("SELECT MAX(id_encuesta) FROM trdd_encuesta");
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
