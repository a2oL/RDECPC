package mx.org.ieem.data.sqllite.models;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_parametros_version implements Parcelable {
    private int id_Parametros;
    private String tabla;
    private int version;

    public trdd_parametros_version(int id_Parametros, String tabla, int version) {
        this.id_Parametros = id_Parametros;
        this.tabla = tabla;
        this.version = version;
    }

    protected trdd_parametros_version(Parcel in) {
        id_Parametros = in.readInt();
        tabla = in.readString();
        version = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_Parametros);
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
        return id_Parametros;
    }

    public void setId_Parametros(int id_Parametros) {
        this.id_Parametros = id_Parametros;
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
