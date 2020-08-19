package mx.org.ieem.data.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static mx.org.ieem.data.sqllite.DataBaseAppRed.*;
import static mx.org.ieem.data.sqllite.constants.ciudadanometro.CamposyTablasCiudadano.*;
import static mx.org.ieem.data.sqllite.constants.ciudadanometro.QueryCiudadano.*;
import static mx.org.ieem.data.sqllite.constants.encuestasj.QueryEncuestasJ.*;
import static mx.org.ieem.data.sqllite.constants.encuestasj.CamposyTablasEncuestas.*;

import static mx.org.ieem.data.sqllite.constants.general.CamposyTablasGeneral.TABLE_NAME_PARAMETROS;

import static mx.org.ieem.data.sqllite.constants.general.CamposyTablasGeneral.TABLE_NAME_TIPOSISTEMA;
import static mx.org.ieem.data.sqllite.constants.general.QueryGeneral.CParametros;
import static mx.org.ieem.data.sqllite.constants.general.QueryGeneral.CTipodeSistema;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, DataBaseName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // Creacion de las tablas de la base de datos DataBaseAppRed (TOP)
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
        db.execSQL(CCT);
        db.execSQL(CEncuesta);
        db.execSQL(CDetalleEncuesta);

        // Creacion de las tablas de la base de datos DataBaseAppRed (TOP)
        db.execSQL(CiuGradoEscolar);
        db.execSQL(CiuNiedGres);
        db.execSQL(CiuRealizador);
        db.execSQL(CiuAnios);
        db.execSQL(CiuPreguntas);
        db.execSQL(CiuEstatusRespuesta);
        db.execSQL(CiuPreguntaRespuesta);
        db.execSQL(CiuRealicadorEdad);
        db.execSQL(CiuRealicadorGenero);
        db.execSQL(CiuRealicadorEscolaridad);
        db.execSQL(CiuEncuesta);
        db.execSQL(CiuDetalleEncuesta);

        db.execSQL(CTipodeSistema);
        db.execSQL(CParametros);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    { // CUando cambie la estructura de las tablas de la base de datos (TOP)
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ENCUESTA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_DETALLE_ENCUESTA);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_GRADO_ESCOLAR_CIUDADANOMETRO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_NIED_GRES_CIUDADANOMETRO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_REALIZADOR_CIUDADANOMETRO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ANIOS_CIUDADANOMETRO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PREGUNTAS_CIUDADANOMETRO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ESTATUSRESPUESTA_CIUDADANOMETRO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PREGUNTARESPUESTA_CIUDADANOMETRO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_REALICADOREDAD_CIUDADANOMETRO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_REALICADORGENERO_CIUDADANOMETRO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_REALICADORESCOLARIDAD_CIUDADANOMETRO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ENCUESTA_CIUDADANOMETRO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_DETALLEENCUESTA_CIUDADANOMETRO);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CCT_GENERAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PARAMETROS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_TIPOSISTEMA);


        onCreate(db);
    } // CUando cambie la estructura de las tablas de la base de datos (TOP)
}