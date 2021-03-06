package mx.org.ieem.data.sqllite.models.encuestaj;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_ej_mes implements Parcelable {
    private int id_mes;
    private String nombre;

    public trdd_ej_mes(int id_mes, String nombre) {
        this.id_mes = id_mes;
        this.nombre = nombre;
    }

    protected trdd_ej_mes(Parcel in) {
        id_mes = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<trdd_ej_mes> CREATOR = new Creator<trdd_ej_mes>() {
        @Override
        public trdd_ej_mes createFromParcel(Parcel in) {
            return new trdd_ej_mes(in);
        }

        @Override
        public trdd_ej_mes[] newArray(int size) {
            return new trdd_ej_mes[size];
        }
    };

    public int getId_mes() {
        return id_mes;
    }

    public void setId_mes(int id_mes) {
        this.id_mes = id_mes;
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_mes);
        dest.writeString(nombre);
    }
}
