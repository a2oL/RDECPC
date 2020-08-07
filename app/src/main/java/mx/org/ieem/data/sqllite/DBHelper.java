package mx.org.ieem.data.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static mx.org.ieem.data.sqllite.DataBaseAppRed.*;
import static mx.org.ieem.data.sqllite.constants.Constantes.*;

public class DBHelper extends SQLiteOpenHelper {

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
        db.execSQL(CParametros);
        //Llenado de la bd
        //db.execSQL(CInsertDataMunicipio);
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
        //db.execSQL(CInsertDataCCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_TMUNICIPIO);
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CCT_ACTUAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ENCUESTA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PARAMETROS);
        onCreate(db);
    }
}