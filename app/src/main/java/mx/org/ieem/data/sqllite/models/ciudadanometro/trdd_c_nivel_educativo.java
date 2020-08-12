package mx.org.ieem.data.sqllite.models.ciudadanometro;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_c_nivel_educativo implements Parcelable
{
    private int id_nivel_educativo;
    private String nombre;

    public trdd_c_nivel_educativo(int id_nivel_educativo, String nombre) {
        this.id_nivel_educativo = id_nivel_educativo;
        this.nombre = nombre;
    }

    protected trdd_c_nivel_educativo(Parcel in) {
        id_nivel_educativo = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<trdd_c_nivel_educativo> CREATOR = new Creator<trdd_c_nivel_educativo>() {
        @Override
        public trdd_c_nivel_educativo createFromParcel(Parcel in) {
            return new trdd_c_nivel_educativo(in);
        }

        @Override
        public trdd_c_nivel_educativo[] newArray(int size) {
            return new trdd_c_nivel_educativo[size];
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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id_nivel_educativo);
        parcel.writeString(nombre);
    }
}
