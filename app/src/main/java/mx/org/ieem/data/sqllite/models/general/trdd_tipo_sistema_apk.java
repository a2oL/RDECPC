package mx.org.ieem.data.sqllite.models.general;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_tipo_sistema_apk implements Parcelable
{
    private int id_sistema_apk;
    private String nombre;

    public trdd_tipo_sistema_apk(int id_sistema_apk, String nombre) {
        this.id_sistema_apk = id_sistema_apk;
        this.nombre = nombre;
    }

    protected trdd_tipo_sistema_apk(Parcel in) {
        id_sistema_apk = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<trdd_tipo_sistema_apk> CREATOR = new Creator<trdd_tipo_sistema_apk>() {
        @Override
        public trdd_tipo_sistema_apk createFromParcel(Parcel in) {
            return new trdd_tipo_sistema_apk(in);
        }

        @Override
        public trdd_tipo_sistema_apk[] newArray(int size) {
            return new trdd_tipo_sistema_apk[size];
        }
    };

    public int getId_sistema_apk() {
        return id_sistema_apk;
    }

    public void setId_sistema_apk(int id_sistema_apk) {
        this.id_sistema_apk = id_sistema_apk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id_sistema_apk);
        parcel.writeString(nombre);
    }
}
