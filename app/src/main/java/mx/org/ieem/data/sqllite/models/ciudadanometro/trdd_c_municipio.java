package mx.org.ieem.data.sqllite.models.ciudadanometro;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_c_municipio implements Parcelable
{
    private int id_municipio;
    private String nombre;

    public trdd_c_municipio(int id_municipio, String nombre) {
        this.id_municipio = id_municipio;
        this.nombre = nombre;
    }

    protected trdd_c_municipio(Parcel in) {
        id_municipio = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<trdd_c_municipio> CREATOR = new Creator<trdd_c_municipio>() {
        @Override
        public trdd_c_municipio createFromParcel(Parcel in) {
            return new trdd_c_municipio(in);
        }

        @Override
        public trdd_c_municipio[] newArray(int size) {
            return new trdd_c_municipio[size];
        }
    };

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
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
        parcel.writeInt(id_municipio);
        parcel.writeString(nombre);
    }
}
