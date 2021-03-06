package mx.org.ieem.data.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import mx.org.ieem.data.sqllite.models.ciudadanometro.*;
import mx.org.ieem.data.sqllite.models.encuestaj.*;
import mx.org.ieem.data.sqllite.models.encuestaj.trdd_cct;
import mx.org.ieem.data.sqllite.models.eventos.trdd_concurso_o_evento;
import mx.org.ieem.data.sqllite.models.eventos.trdd_estatus_concurso_o_evento;
import mx.org.ieem.data.sqllite.models.reportes.trdd_reporte;
import mx.org.ieem.data.sqllite.models.reportes.trdd_tipo_reporte;

import static mx.org.ieem.RESTful.AsyncLogin.actual_final;
import static mx.org.ieem.data.sqllite.constants.ciudadanometro.CamposyTablasCiudadano.*;
import static mx.org.ieem.data.sqllite.constants.encuestasj.CamposyTablasEncuestas.*;


public class DataBaseAppRed
{
    public static String TAG = DataBaseAppRed.class.getSimpleName();
    /** --------------------------------- Nombre de Base de Datos -------------------------------------**/
    public static final String DataBaseName = "DPCDataBase";
    /** --------------------------------- Version de Base de Datos ---------------------------------**/
    public static final int version = 53;

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

    public Cursor querySQL(String sql) {
        Cursor regreso = null;
        open();
        regreso = database.rawQuery(sql,null);
        return regreso;
    }


    // Query utilizado para insertar los valores de las respuestas a las preguntas de la encuesta.
    public void InsertDetalleEncuesta(String insIdCct, String insIdRandom,int insIdEnc, String insIdAni, int insIdMes, int insIdNiE, int insIdGrE, int insIdInd, int insIdRes, int insIdEsR) {
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
        database.insert(TABLE_NAME_DETALLE_ENCUESTA,null,values);
        close();
    }

    public void InsertEncuesta(String insIdCct, String insIdRandom,int insIdEnc, int insIdNiE, int insIdGrE) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_CCT_ENCUESTA, (insIdCct));
        values.put(COLUMN_NAME_ID_RANDOM_ENCUESTA, (insIdRandom));
        values.put(COLUMN_NAME_ID_ENCUESTA_ENCUESTA, (insIdEnc));
        values.put(COLUMN_NAME_ID_NIVEL_EDUCATIVO_ENCUESTA, (insIdNiE));
        values.put(COLUMN_NAME_ID_GRADO_ESCOLAR_ENCUESTA, (insIdGrE));
        database.insert(TABLE_NAME_ENCUESTA,null,values);
        close();
    }



    public void InsertDetalleEncuestaCiudadanometro(String insIdCct, String insIdRandom, int insIdEnc, String insIdAnio, String insIdPreg, int indIdResp, int indIdEstRes) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_CCT_DETALLEENCUESTA_CIUDADANOMETRO, (insIdCct));
        values.put(COLUMN_NAME_ID_RANDOM_DETALLEENCUESTA_CIUDADANOMETRO, (insIdRandom));
        values.put(COLUMN_NAME_ID_ENCUESTA_DETALLEENCUESTA_CIUDADANOMETRO, (insIdEnc));
        values.put(COLUMN_NAME_ID_ANIO_DETALLEENCUESTA_CIUDADANOMETRO, (insIdAnio));
        values.put(COLUMN_NAME_ID_PREGUNTA_DETALLEENCUESTA_CIUDADANOMETRO, (insIdPreg));
        values.put(COLUMN_NAME_ID_RESPUESTA_DETALLEENCUESTA_CIUDADANOMETRO, (indIdResp));
        values.put(COLUMN_NAME_ID_ESTATUSRESPUESTA_DETALLEENCUESTA_CIUDADANOMETRO, (indIdEstRes));
        database.insert(TABLE_NAME_DETALLEENCUESTA_CIUDADANOMETRO,null,values);
        close();
    }

    public void InsertEncuestaCiudadanometro(String insIdCct, String insIdRandom, int insIdEnc, int insIdReali, int insIdRealiNiE, int insIdRealiGrE, int insIdRealiEdad, int insIdRealiGene, int insIdRealiEsc) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_CCT_ENCUESTA_CIUDADANOMETRO, (insIdCct));
        values.put(COLUMN_NAME_ID_RANDOM_ENCUESTA_CIUDADANOMETRO, (insIdRandom));
        values.put(COLUMN_NAME_ID_ENCUESTA_ENCUESTA_CIUDADANOMETRO, (insIdEnc));
        values.put(COLUMN_NAME_ID_REALIZADOR_ENCUESTA_CIUDADANOMETRO, (insIdReali));
        values.put(COLUMN_NAME_ID_REALIZADORNIVEDU_ENCUESTA_CIUDADANOMETRO, (insIdRealiNiE));
        values.put(COLUMN_NAME_ID_REALIZADORGRESC_ENCUESTA_CIUDADANOMETRO, (insIdRealiGrE));
        values.put(COLUMN_NAME_ID_REALIZADOREDAD_ENCUESTA_CIUDADANOMETRO, (insIdRealiEdad));
        values.put(COLUMN_NAME_ID_REALIZADORGENERO_ENCUESTA_CIUDADANOMETRO, (insIdRealiGene));
        values.put(COLUMN_NAME_ID_REALIZADORESCOLARIDAD_ENCUESTA_CIUDADANOMETRO, (insIdRealiEsc));
        database.insert(TABLE_NAME_ENCUESTA_CIUDADANOMETRO,null,values);
        close();
    }

    public trdd_municipio getMunicipio() {
        trdd_municipio trdd__municipios = null;
        Cursor dataCursor = querySQL("SELECT * FROM " + TABLE_NAME_TMUNICIPIO + " WHERE " + COLUMN_NAME_ID_TMUNICIPIO+ " LIKE "+"'"+actual_final.getId_municipio()+"'");
        if (dataCursor != null && dataCursor.getCount() > 0){
            for (dataCursor.moveToFirst() ; !dataCursor.isAfterLast() ; dataCursor.moveToNext()){
                int id = dataCursor.getInt(dataCursor.getColumnIndex(COLUMN_NAME_ID_TMUNICIPIO));
                String name = dataCursor.getString(dataCursor.getColumnIndex(COLUMN_NAME_NAME_TMUNICIPIO));
                trdd__municipios = new trdd_municipio(id,name);
            }
        }
        close();
        return trdd__municipios;
    }

    // Metodo que se utilizara para regresar el objeto de tipo cct segun el id_CCT


    public int getNumerodeEncuestasPorMesyGrado( int id_mes , int id_grado)
    {
        Cursor dataCursor = querySQL("SELECT * FROM " + TABLE_NAME_DETALLE_ENCUESTA + " WHERE " + COLUMN_NAME_ID_GRADO_ESCOLAR_ENCUESTA + " = " + id_grado + " AND " + COLUMN_NAME_ID_MES_ENCUESTA + " = " + id_mes);
        // TODO Cambiar el 6 por variable que cambie deacuerdo al numero de indicadores.
        return dataCursor.getCount()/6;
    }

    // Regresa el usuario que esta logueado actualmente.
    public Cursor getUsuarioLogueado() {
        Cursor dataCursor = querySQL("SELECT * FROM "+ TABLE_NAME_CCT_GENERAL);
        return dataCursor;
    }



    // Inserta un nuevo usuario logueado a la bd. (TOP)
    public void insertCctActual(trdd_cct actual)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_CCT_GENERAL, (actual.getId_cct()));
        values.put(COLUMN_NAME_NOMBRE_CCT_GENERAL, (actual.getNombre()));
        values.put(COLUMN_NAME_DOMICILIO_CCT_GENERAL, (actual.getDomicilio()));
        values.put(COLUMN_NAME_EMAIL_CCT_GENERAL, (actual.getEmail()));
        values.put(COLUMN_NAME_ID_MUNICIPIO_CCT_GENERAL, (actual.getId_municipio()));
        values.put(COLUMN_NAME_ID_NIVEL_EDUCATIVO_CCT_GENERAL, (actual.getId_nivel_educativo()));
        values.put(COLUMN_NAME_CONTRASENIA_CCT_GENERAL, (actual.getContrasenia()));
        database.insert(TABLE_NAME_CCT_GENERAL,null,values);
        close();
    }

    public void insertMunicipioActual(trdd_municipio actual)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_TMUNICIPIO, (actual.getId()));
        values.put(COLUMN_NAME_NAME_TMUNICIPIO, (actual.getNombre()));
        database.insert(TABLE_NAME_TMUNICIPIO,null,values);
        close();
    }

    public void insertEstatusEvento(trdd_estatus_concurso_o_evento actual)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_ESTATUS_CONEVE, (actual.getId_estatus_coneve()));
        values.put(COLUMN_NAME_NOMBRE_ESTATUS_CONEVE, (actual.getNombre()));
        database.insert(TABLE_NAME_ESTATUS_CONCURSO_O_EVENTO,null,values);
        close();
    }

    public void insertTipoReporte(trdd_tipo_reporte actual)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_TIPO_REPORTE_TABLE, (actual.getId_tipo_reporte()));
        values.put(COLUMN_NAME_NOMBRE_TIPO_REPORTE, (actual.getNombre()));
        database.insert(TABLE_NAME_TIPO_REPORTE,null,values);
        close();
    }

    public void insertIdRandomDispositivo(String id_random)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_RANDOM_DISPOSITIVOS, (id_random));
        database.insert(TABLE_NAME_DISPOSITIVOS,null,values);
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

    public boolean checkTablas(){
        return true;
    }

    // Inserta un nuevo usuario logueado a la bd. (BOTTOM)

    // Inserta nueva bd. (TOP)
    public void insertAnios(trdd_ej_anio anio){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_ANIOS, (anio.getId_anio()));
        database.insert(TABLE_NAME_ANIOS,null,values);
        close();
    }

    public void insertAniosCiudadanometro(trdd_c_anio anio){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_ANIOS_CIUDADANOMETRO, (anio.getId_anio()));
        database.insert(TABLE_NAME_ANIOS_CIUDADANOMETRO,null,values);
        close();
    }


    public void insertPreguntasCiudadanometro(trdd_c_pregunta preguntas){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_ANIO_PREGUNTAS_CIUDADANOMETRO, (preguntas.getId_anio()));
        values.put(COLUMN_NAME_ID_PREGUNTA_PREGUNTAS_CIUDADANOMETRO, (preguntas.getId_pregunta()));
        database.insert(TABLE_NAME_PREGUNTAS_CIUDADANOMETRO,null,values);
        close();
    }

    public void insertMeses(trdd_ej_mes mes){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_MES, (mes.getId_mes()));
        values.put(COLUMN_NAME_NAME_MES, (mes.getNombre()));
        database.insert(TABLE_NAME_MES,null,values);
        close();
    }

    public void insertAniosMeses(trdd_ej_anio_mes anioMes){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_MES_ANIO, (anioMes.getId_anio()));
        values.put(COLUMN_NAME_NAME_MES_ANIO, (anioMes.getId_mes()));
        database.insert(TABLE_NAME_MES_ANIO,null,values);
        close();
    }

    public void insertGradoEscolar(trdd_ej_grado_escolar gradoEscolar){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_GRADO_ESCOLAR, (gradoEscolar.getId_grado_escolar()));
        values.put(COLUMN_NAME_NAME_GRADO_ESCOLAR, (gradoEscolar.getNombre()));
        values.put(COLUMN_NAME_SIGLAS_GRADO_ESCOLAR, (gradoEscolar.getSiglas()));
        values.put(COLUMN_NAME_GRADO_GRADO_ESCOLAR, (gradoEscolar.getGrado()));
        database.insert(TABLE_NAME_GRADO_ESCOLAR,null,values);
        close();
    }

    public void insertGradoEscolarCiudadanometro(trdd_c_grado_escolar gradoEscolar){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_GRADO_ESCOLAR_CIUDADANOMETRO, (gradoEscolar.getId_grado_escolar()));
        values.put(COLUMN_NAME_NAME_GRADO_ESCOLAR_CIUDADANOMETRO, (gradoEscolar.getNombre()));
        values.put(COLUMN_NAME_SIGLAS_GRADO_ESCOLAR_CIUDADANOMETRO, (gradoEscolar.getSiglas()));
        values.put(COLUMN_NAME_GRADO_GRADO_ESCOLAR_CIUDADANOMETRO, (gradoEscolar.getGrado()));
        database.insert(TABLE_NAME_GRADO_ESCOLAR_CIUDADANOMETRO,null,values);
        close();
    }

    public void insertNiedGres(trdd_ej_nied_gres niedGres){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_NE_NIED_GRES, (niedGres.getId_nivel_educativo()));
        values.put(COLUMN_NAME_GE_NIED_GRES, (niedGres.getId_grado_escolar()));
        database.insert(TABLE_NAME_NIED_GRES,null,values);
        close();
    }

    public void insertNiedGresCiudadanometro(trdd_c_nied_gres niedGres){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_NE_NIED_GRES_CIUDADANOMETRO, (niedGres.getId_nivel_educativo()));
        values.put(COLUMN_NAME_GE_NIED_GRES_CIUDADANOMETRO, (niedGres.getId_grado_escolar()));
        database.insert(TABLE_NAME_NIED_GRES_CIUDADANOMETRO,null,values);
        close();
    }

    public void insertRealizadorCiudadanometro(trdd_c_realizador realizador){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_REALIZADOR_CIUDADANOMETRO, (realizador.getId_realizador()));
        values.put(COLUMN_NAME_NAME_REALIZADOR_CIUDADANOMETRO, (realizador.getNombre()));
        database.insert(TABLE_NAME_REALIZADOR_CIUDADANOMETRO,null,values);
        close();
    }

    public void insertIndicador(trdd_ej_indicador indicador){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_INDICADOR, (indicador.getId_indicador()));
        values.put(COLUMN_NAME_NAME_INDICADOR, (indicador.getNombre()));
        database.insert(TABLE_NAME_INDICADOR,null,values);
        close();
    }

    public void insertEvento(trdd_concurso_o_evento evento){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_CONEVE, evento.getId_con_eve());
        values.put(COLUMN_NAME_NOMBRE_CONEVE, evento.getNombre());
        values.put(COLUMN_NAME_DESCRIPCION_CONEVE, evento.getDescripcion());
        values.put(COLUMN_NAME_URL_CONEVE, evento.getUrl());
        values.put(COLUMN_NAME_URL_IMAGE_CONEVE, evento.getUrl_image());
        values.put(COLUMN_NAME_IDESTATUSCONEVE_CONEVE, evento.getId_estatus_coneve());
        database.insert(TABLE_NAME_CONCURSO_O_EVENTO,null,values);
        close();
    }

    public void insertReporte(trdd_reporte evento){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_REPORTES, evento.getId_reporte());
        values.put(COLUMN_NAME_NOMBRE_REPORTES, evento.getNombre());
        values.put(COLUMN_NAME_DESCRIPCION_REPORTES, evento.getDescripcion());
        values.put(COLUMN_NAME_URL_REPORTES, evento.getUrl());
        values.put(COLUMN_NAME_IDESTATUS_REPORTES, evento.getId_estatus_reporte());
        values.put(COLUMN_NAME_ID_TIPO_REPORTE,evento.getId_tipo_reporte());
        database.insert(TABLE_NAME_REPORTES,null,values);
        close();
    }

    public void updateEvento(trdd_concurso_o_evento evento)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_CONEVE, evento.getId_con_eve());
        values.put(COLUMN_NAME_NOMBRE_CONEVE, evento.getNombre());
        values.put(COLUMN_NAME_DESCRIPCION_CONEVE, evento.getDescripcion());
        values.put(COLUMN_NAME_URL_CONEVE, evento.getUrl());
        values.put(COLUMN_NAME_URL_IMAGE_CONEVE, evento.getUrl_image());
        values.put(COLUMN_NAME_IDESTATUSCONEVE_CONEVE, evento.getId_estatus_coneve());
        database.update(TABLE_NAME_CONCURSO_O_EVENTO, values, "id_con_eve = " + String.valueOf(evento.getId_con_eve()), null);
    }

    public void insertNivelIndicador(trdd_ej_nivedu_ind niveduIndicador){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_NE_NIV_IND, (niveduIndicador.getId_nivel_educativo()));
        values.put(COLUMN_NAME_IN_NIV_IND, (niveduIndicador.getId_indicador()));
        database.insert(TABLE_NAME_NIV_IND,null,values);
        close();
    }

    public void insertPregunta(trdd_ej_pregunta pregunta){
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

    public void insertEstatusRespuesta(trdd_ej_estatus_respuesta estatusRespuesta){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_ESTATUS_RESPUESTA, (estatusRespuesta.getId_estatus_respuesta()));
        values.put(COLUMN_NAME_NAME_ESTATUS_RESPUESTA, (estatusRespuesta.getNombre()));
        database.insert(TABLE_NAME_ESTATUS_RESPUESTA,null,values);
        close();
    }

    public void insertEstatusRespuestaCiudadanometro(trdd_c_estatus_respuesta estatusRespuesta){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_ESTATUSRESPUESTA_CIUDADANOMETRO, (estatusRespuesta.getId_estatus_respuesta()));
        values.put(COLUMN_NAME_NOMBRE_ESTATUSRESPUESTA_CIUDADANOMETRO, (estatusRespuesta.getNombre()));
        database.insert(TABLE_NAME_ESTATUSRESPUESTA_CIUDADANOMETRO,null,values);
        close();
    }

    public void insertRealicadorEdadCiudadanometro(trdd_c_realicador_edad estatusRespuesta){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_EDAD_REALICADOREDAD_CIUDADANOMETRO, (estatusRespuesta.getId_edad()));
        values.put(COLUMN_NAME_NOMBRE_REALICADOREDAD_CIUDADANOMETRO, (estatusRespuesta.getNombre()));
        database.insert(TABLE_NAME_REALICADOREDAD_CIUDADANOMETRO,null,values);
        close();
    }

    public void insertRealicadorGeneroCiudadanometro(trdd_c_realicador_genero estatusRespuesta){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_GENERO_REALICADORGENERO_CIUDADANOMETRO, (estatusRespuesta.getId_genero()));
        values.put(COLUMN_NAME_NOMBRE_REALICADORGENERO_CIUDADANOMETRO, (estatusRespuesta.getNombre()));
        database.insert(TABLE_NAME_REALICADORGENERO_CIUDADANOMETRO,null,values);
        close();
    }

    public void insertRealicadorEscolaridadCiudadanometro(trdd_c_realicador_escolaridad estatusRespuesta){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_ESCOLARIDAD_REALICADORESCOLARIDAD_CIUDADANOMETRO, (estatusRespuesta.getId_escolaridad()));
        values.put(COLUMN_NAME_NOMBRE_REALICADORESCOLARIDAD_CIUDADANOMETRO, (estatusRespuesta.getNombre()));
        database.insert(TABLE_NAME_REALICADORESCOLARIDAD_CIUDADANOMETRO,null,values);
        close();
    }

    public void insertPreguntasRespuestaCiudadanometro(trdd_c_pregunta_respuesta indicador){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_ANIO_PREGUNTARESPUESTA_CIUDADANOMETRO, (indicador.getId_anio()));
        values.put(COLUMN_NAME_ID_PREGUNTA_PREGUNTARESPUESTA_CIUDADANOMETRO, (indicador.getId_pregunta()));
        values.put(COLUMN_NAME_ID_RESPUESTA_PREGUNTARESPUESTA_CIUDADANOMETRO, (indicador.getId_respuesta()));
        values.put(COLUMN_NAME_ID_ESTATUSRESPUESTA_PREGUNTARESPUESTA_CIUDADANOMETRO, (indicador.getId_estatus_respuesta()));
        values.put(COLUMN_NAME_RESPUESTA_PREGUNTARESPUESTA_CIUDADANOMETRO, (indicador.getRespuesta()));
        database.insert(TABLE_NAME_PREGUNTARESPUESTA_CIUDADANOMETRO,null,values);
        close();
    }

    public void insertPreguntaRespuesta(trdd_ej_pregunta_respuesta preguntaRespuesta){
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

    public void deleteMunicipio(){
        open();
        database.execSQL("DELETE FROM "+TABLE_NAME_TMUNICIPIO);
        close();
    }

    public void deleteEventos(){
        open();
        database.execSQL("DELETE FROM "+TABLE_NAME_CONCURSO_O_EVENTO);
        close();
    }

    public void deleteReportes(int id_tipo_reporte){
        open();
        database.execSQL("DELETE FROM "+TABLE_NAME_REPORTES+" WHERE id_tipo_reporte = "+id_tipo_reporte);
        close();
    }

    public void deleteNivelEducativo(){
        open();
        database.execSQL("DELETE FROM "+TABLE_NAME_NIVEL_EDUCATIVO);
        close();
    }

    public void deleteAniosCiudadanometro(){
        open();
        database.execSQL("DELETE FROM "+TABLE_NAME_ANIOS_CIUDADANOMETRO);
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

    public void deleteEstatusEventos(){
        open();
        database.execSQL("DELETE FROM "+TABLE_NAME_ESTATUS_CONCURSO_O_EVENTO);
        close();
    }

    public void deleteTipoReporte(){
        open();
        database.execSQL("DELETE FROM "+TABLE_NAME_TIPO_REPORTE);
        close();
    }

    public void deleteGradoEscolar(){
        open();
        database.execSQL("DELETE FROM "+TABLE_NAME_GRADO_ESCOLAR);
        close();
    }

    public void deleteGradoEscolarCiudadanometro(){
        open();
        database.execSQL("DELETE FROM " + TABLE_NAME_GRADO_ESCOLAR_CIUDADANOMETRO);
        close();
    }

    public void deleteNiedGres(){
        open();
        database.execSQL("DELETE FROM "+ TABLE_NAME_NIED_GRES);
        close();
    }

    public void deleteNiedGresCiudadanometro(){
        open();
        database.execSQL("DELETE FROM "+ TABLE_NAME_NIED_GRES_CIUDADANOMETRO);
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

    public void deletePreguntasCiudadanometro(){
        open();
        database.execSQL("DELETE FROM " + TABLE_NAME_PREGUNTAS_CIUDADANOMETRO);
        close();
    }

    public void deleteEstatusRespuesta(){
        open();
        database.execSQL("DELETE FROM " + TABLE_NAME_ESTATUS_RESPUESTA);
        close();
    }

    public void deleteEstatusRespuestaCiudadanometro(){
        open();
        database.execSQL("DELETE FROM " + TABLE_NAME_ESTATUSRESPUESTA_CIUDADANOMETRO);
        close();
    }

    public void deleteRealicadorEdadCiudadanometro(){
        open();
        database.execSQL("DELETE FROM " + TABLE_NAME_REALICADOREDAD_CIUDADANOMETRO);
        close();
    }

    public void deleteRealicadorGeneroCiudadanometro(){
        open();
        database.execSQL("DELETE FROM " + TABLE_NAME_REALICADORGENERO_CIUDADANOMETRO);
        close();
    }

    public void deleteRealicadorEscolaridadCiudadanometro(){
        open();
        database.execSQL("DELETE FROM " + TABLE_NAME_REALICADORESCOLARIDAD_CIUDADANOMETRO);
        close();
    }

    public void deletePreguntaRespuestaCiudadanometro(){
        open();
        database.execSQL("DELETE FROM " + TABLE_NAME_PREGUNTARESPUESTA_CIUDADANOMETRO);
        close();
    }

    public void deletePreguntaRespuesta(){
        open();
        database.execSQL("DELETE FROM " + TABLE_NAME_PREGUNTA_RESPUESTA);
        close();
    }

    public void deleteRealizadorCiudadanometro(){
        open();
        database.execSQL("DELETE FROM " + TABLE_NAME_REALIZADOR_CIUDADANOMETRO);
        close();
    }

    // Inserta nueva bd. (BOTTOM)


    // Elimina al usuario logueado actualmente.
    public void logoutUsario()
    {
        open();
        database.execSQL("DELETE FROM "+TABLE_NAME_CCT_GENERAL);
        close();
    }

    public Cursor getEncuestasJuvenilesBD(){
        Cursor dataCursor = querySQL("SELECT * FROM " + TABLE_NAME_ENCUESTA);
        return dataCursor;
    }

    public Cursor getCiudadanometrosBD(){
        Cursor dataCursor = querySQL("SELECT * FROM " + TABLE_NAME_ENCUESTA_CIUDADANOMETRO);
        return dataCursor;
    }

    public Cursor getDetallesCiudadanometrosBD(int id_encuesta){
        Cursor dataCursor = querySQL("SELECT * FROM " + TABLE_NAME_DETALLEENCUESTA_CIUDADANOMETRO + " WHERE trdd_c_detalle_encuesta.id_encuesta = "+id_encuesta);
        return dataCursor;
    }

    public Cursor getDetallesEncuestasBD(int id_encuesta){
        Cursor dataCursor = querySQL("SELECT * FROM " + TABLE_NAME_DETALLE_ENCUESTA + " WHERE trdd_ej_detalle_encuesta.id_encuesta = "+id_encuesta);
        return dataCursor;
    }

    public Cursor getUltimoRegistro() {
        Cursor dataCursor = querySQL("SELECT MAX(id_encuesta) FROM " + TABLE_NAME_DETALLE_ENCUESTA);
        return dataCursor;
    }
    public Cursor getUltimoRegistroCiudadanometro() {
        Cursor dataCursor = querySQL("SELECT MAX(id_encuesta) FROM " + TABLE_NAME_DETALLEENCUESTA_CIUDADANOMETRO);
        return dataCursor;
    }

    public Cursor getMesesBD() {
        Cursor dataCursor = querySQL("SELECT trdd_ej_mes.id_mes as _id,trdd_ej_mes.nombre FROM " + TABLE_NAME_MES );
        return dataCursor;
    }

    public Cursor getAniosCiudadanometroBD() {
        Cursor dataCursor = querySQL("SELECT trdd_c_anio.id_anio as _id FROM " + TABLE_NAME_ANIOS_CIUDADANOMETRO );
        return dataCursor;
    }

    public Cursor getRealizadorCiudadanometroBD() {
        Cursor dataCursor = querySQL("SELECT trdd_c_realizador.id_realizador as _id ,trdd_c_realizador.nombre FROM " + TABLE_NAME_REALIZADOR_CIUDADANOMETRO );
        return dataCursor;
    }

    public Cursor getRealicadorEdadCiudadanometroBD() {
        Cursor dataCursor = querySQL("SELECT trdd_c_realicador_edad.id_edad as _id ,trdd_c_realicador_edad.nombre FROM " + TABLE_NAME_REALICADOREDAD_CIUDADANOMETRO );
        return dataCursor;
    }

    public Cursor getRealicadorGeneroCiudadanometroBD() {
        Cursor dataCursor = querySQL("SELECT trdd_c_realicador_genero.id_genero as _id ,trdd_c_realicador_genero.nombre FROM " + TABLE_NAME_REALICADORGENERO_CIUDADANOMETRO );
        return dataCursor;
    }

    public Cursor getRealicadorEscolaridadCiudadanometroBD() {
        Cursor dataCursor = querySQL("SELECT trdd_c_realicador_escolaridad.id_escolaridad as _id ,trdd_c_realicador_escolaridad.nombre FROM " + TABLE_NAME_REALICADORESCOLARIDAD_CIUDADANOMETRO );
        return dataCursor;
    }

    public Cursor getGradosCiudadanometroBD() {
        Cursor dataCursor = querySQL("SELECT trdd_c_grado_escolar.id_grado_escolar as _id,trdd_c_grado_escolar.nombre,trdd_c_grado_escolar.siglas,trdd_c_grado_escolar.grado FROM "+TABLE_NAME_NIED_GRES_CIUDADANOMETRO+" INNER JOIN "+TABLE_NAME_GRADO_ESCOLAR_CIUDADANOMETRO+" USING(id_grado_escolar) WHERE id_nivel_educativo = "+ actual_final.getId_nivel_educativo());
        return dataCursor;
    }

    public Cursor getGradosBD() {
        Cursor dataCursor = querySQL("SELECT trdd_ej_grado_escolar.id_grado_escolar as _id,trdd_ej_grado_escolar.nombre,trdd_ej_grado_escolar.siglas,trdd_ej_grado_escolar.grado FROM "+TABLE_NAME_NIED_GRES+" INNER JOIN "+TABLE_NAME_GRADO_ESCOLAR+" USING(id_grado_escolar) WHERE id_nivel_educativo = "+ actual_final.getId_nivel_educativo());
        return dataCursor;
    }

    public Cursor getPreguntasEncuestaBD() {
        Cursor dataCursor = querySQL("SELECT trdd_ej_pregunta.id_anio as _id,trdd_ej_pregunta.id_mes,trdd_ej_pregunta.id_nivel_educativo,trdd_ej_pregunta.id_indicador,trdd_ej_pregunta.pregunta FROM " + TABLE_NAME_PREGUNTA + " WHERE trdd_ej_pregunta.id_nivel_educativo = "+ actual_final.getId_nivel_educativo());
        return dataCursor;
    }

    public Cursor getPreguntasCiudadanometroBD() {
        Cursor dataCursor = querySQL("SELECT * FROM " + TABLE_NAME_PREGUNTAS_CIUDADANOMETRO);
        return dataCursor;
    }

    public Cursor getRespuestasEncuestaBD(int indicador) {
        Cursor dataCursor = querySQL("SELECT trdd_ej_pregunta_respuesta.id_anio as _id,trdd_ej_pregunta_respuesta.id_mes,trdd_ej_pregunta_respuesta.id_nivel_educativo,trdd_ej_pregunta_respuesta.id_indicador,trdd_ej_pregunta_respuesta.id_respuesta,trdd_ej_pregunta_respuesta.id_estatus_respuesta,trdd_ej_pregunta_respuesta.respuesta FROM " + TABLE_NAME_PREGUNTA_RESPUESTA + " WHERE trdd_ej_pregunta_respuesta.id_nivel_educativo = "+ actual_final.getId_nivel_educativo()+" AND trdd_ej_pregunta_respuesta.id_indicador = "+indicador);
        return dataCursor;
    }


    public Cursor getRespuestasCiudadanometroBD(String indicador) {
        Cursor dataCursor = querySQL("SELECT trdd_c_pregunta_respuesta.id_anio as _id,trdd_c_pregunta_respuesta.id_pregunta,trdd_c_pregunta_respuesta.id_respuesta,trdd_c_pregunta_respuesta.id_estatus_respuesta,trdd_c_pregunta_respuesta.respuesta FROM " + TABLE_NAME_PREGUNTARESPUESTA_CIUDADANOMETRO + " WHERE trdd_c_pregunta_respuesta.id_pregunta LIKE \'"+ indicador + "\'");
        return dataCursor;
    }

    public String getIdRandomDispositivo(){
        Cursor dataCursor = querySQL("SELECT trdd_dispositivo.id_random as _id FROM trdd_dispositivo");
        dataCursor.moveToNext();

        if(dataCursor.getCount() == 0)
        {
            return "vacio";
        }else{
            int indiceIdRandom = dataCursor.getColumnIndex("id_random");
            return dataCursor.getString(0);
        }
    }

    public ArrayList<trdd_concurso_o_evento> cargarEventosConcursosBDR()
    {
        Cursor dataEventos = querySQL("SELECT * FROM trdd_concurso_o_evento");
        ArrayList<trdd_concurso_o_evento> auxiliarEventos = new ArrayList<trdd_concurso_o_evento>();
        for(dataEventos.moveToFirst(); !dataEventos.isAfterLast(); dataEventos.moveToNext())
        {
            final int id_con_eve = dataEventos.getInt(dataEventos.getColumnIndex(COLUMN_NAME_ID_CONEVE));
            final String nombre = dataEventos.getString(dataEventos.getColumnIndex(COLUMN_NAME_NOMBRE_CONEVE));
            final String descripcion = dataEventos.getString(dataEventos.getColumnIndex(COLUMN_NAME_DESCRIPCION_CONEVE));
            final String url = dataEventos.getString(dataEventos.getColumnIndex(COLUMN_NAME_URL_CONEVE));
            final String url_image = dataEventos.getString(dataEventos.getColumnIndex(COLUMN_NAME_URL_IMAGE_CONEVE));
            final int id_estatus_coneve = dataEventos.getInt(dataEventos.getColumnIndex(COLUMN_NAME_IDESTATUSCONEVE_CONEVE));;
            trdd_concurso_o_evento eventoBD = new trdd_concurso_o_evento(id_con_eve,nombre,descripcion,url,url_image,id_estatus_coneve);
            auxiliarEventos.add(eventoBD);
        }
        return auxiliarEventos;
    }

    public ArrayList<trdd_reporte> cargarReportesBDR(int id_tipo_reporte)
    {
        Cursor dataEventos = querySQL("SELECT * FROM trdd_reporte WHERE id_tipo_reporte = "+id_tipo_reporte);
        ArrayList<trdd_reporte> auxiliarEventos = new ArrayList<trdd_reporte>();
        for(dataEventos.moveToFirst(); !dataEventos.isAfterLast(); dataEventos.moveToNext())
        {
            final int id_con_eve = dataEventos.getInt(dataEventos.getColumnIndex(COLUMN_NAME_ID_REPORTES));
            final String nombre = dataEventos.getString(dataEventos.getColumnIndex(COLUMN_NAME_NOMBRE_REPORTES));
            final String descripcion = dataEventos.getString(dataEventos.getColumnIndex(COLUMN_NAME_DESCRIPCION_REPORTES));
            final String url = dataEventos.getString(dataEventos.getColumnIndex(COLUMN_NAME_URL_REPORTES));
            final int id_estatus_coneve = dataEventos.getInt(dataEventos.getColumnIndex(COLUMN_NAME_IDESTATUS_REPORTES));;
            final int id_tipo_reportez = dataEventos.getInt(dataEventos.getColumnIndex(COLUMN_NAME_ID_TIPO_REPORTE));
            trdd_reporte eventoBD = new trdd_reporte(id_con_eve,nombre,descripcion,url,id_estatus_coneve,id_tipo_reportez);
            auxiliarEventos.add(eventoBD);
        }
        return auxiliarEventos;
    }

    public boolean existeEvento(int id_con_eve)
    {
        Cursor dataCursor = querySQL("SELECT trdd_concurso_o_evento.id_con_eve as _id FROM " + TABLE_NAME_CONCURSO_O_EVENTO + " WHERE trdd_concurso_o_evento.id_con_eve = "+ id_con_eve);
        if(dataCursor.getCount() > 0 )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
