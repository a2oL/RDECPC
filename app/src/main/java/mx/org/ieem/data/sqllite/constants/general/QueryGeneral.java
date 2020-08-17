package mx.org.ieem.data.sqllite.constants.general;



import static mx.org.ieem.data.sqllite.constants.general.CamposyTablasGeneral.*;

public class QueryGeneral
{
    public static final String CParametros = "CREATE TABLE " + TABLE_NAME_PARAMETROS + " (" +
            COLUMN_NAME_ID_PARAMETROS+ " INTEGER NOT NULL, " +
            COLUMN_NAME_TABLAS_PARAMETROS + " TEXT NOT NULL, " +
            COLUMN_NAME_VERSION_PARAMETROS + " INTEGER NOT NULL, " +
            "CONSTRAINT trdd_version_tabla_cct_pk PRIMARY KEY (id_tabla),"+
            "CONSTRAINT trdd_tipsisapk_fk FOREIGN KEY (id_sistema_apk) REFERENCES trdd_tipo_sistema_apk (id_sistema_apk));";

    public static final String CTipodeSistema = "CREATE TABLE " + TABLE_NAME_TIPOSISTEMA + " (" +
            COLUMN_NAME_ID_TIPOSISTEMA+ " INTEGER NOT NULL, " +
            COLUMN_NAME_NOMBRE_TIPOSISTEMA + " TEXT NOT NULL, " +
            "CONSTRAINT trdd_tipo_sistema_apk_pk PRIMARY KEY (id_sistema_apk));";
}
