package mx.org.ieem.data.sqllite.models.encuestaj;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_nivel_educativo implements Parcelable{
    private int id_nivel_educativo;
    private String nombre;

    public trdd_nivel_educativo(int id_nivel_educativo, String nombre) {
        this.id_nivel_educativo = id_nivel_educativo;
        this.nombre = nombre;
    }

    protected trdd_nivel_educativo(Parcel in) {
        id_nivel_educativo = in.readInt();
        nombre = in.readString();
    }

    public static final Parcelable.Creator<trdd_ej_mes> CREATOR = new Parcelable.Creator<trdd_ej_mes>() {
        @Override
        public trdd_ej_mes createFromParcel(Parcel in) {
            return new trdd_ej_mes(in);
        }

        @Override
        public trdd_ej_mes[] newArray(int size) {
            return new trdd_ej_mes[size];
        }
    };

    public int getId_nivel_educativo() {
        return id_nivel_educativo;
    }

    public void setId_nivel_educativo(int id_nivel_educativo) {
        this.id_nivel_educativo = id_nivel_educativo;
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
        dest.writeInt(id_nivel_educativo);
        dest.writeString(nombre);
    }
}
