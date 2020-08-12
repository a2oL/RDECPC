package mx.org.ieem.data.sqllite.models.encuestaj;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_parametros_version implements Parcelable {
    private int id_parametros;
    private String tabla;
    private int version;

    public trdd_parametros_version(int id_parametros, String tabla, int version) {
        this.id_parametros = id_parametros;
        this.tabla = tabla;
        this.version = version;
    }

    protected trdd_parametros_version(Parcel in) {
        id_parametros = in.readInt();
        tabla = in.readString();
        version = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_parametros);
        dest.writeString(tabla);
        dest.writeInt(version);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<trdd_parametros_version> CREATOR = new Creator<trdd_parametros_version>() {
        @Override
        public trdd_parametros_version createFromParcel(Parcel in) {
            return new trdd_parametros_version(in);
        }

        @Override
        public trdd_parametros_version[] newArray(int size) {
            return new trdd_parametros_version[size];
        }
    };

    public int getId_Parametros() {
        return id_parametros;
    }

    public void setId_Parametros(int id_parametros) {
        this.id_parametros = id_parametros;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


}
