package mx.org.ieem.data.sqllite.models.ciudadanometro;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_c_realicador_escolaridad implements Parcelable
{
    private int id_escolaridad;
    private String nombre;

    public trdd_c_realicador_escolaridad(int id_escolaridad, String nombre) {
        this.id_escolaridad = id_escolaridad;
        this.nombre = nombre;
    }

    protected trdd_c_realicador_escolaridad(Parcel in) {
        id_escolaridad = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<trdd_c_realicador_escolaridad> CREATOR = new Creator<trdd_c_realicador_escolaridad>() {
        @Override
        public trdd_c_realicador_escolaridad createFromParcel(Parcel in) {
            return new trdd_c_realicador_escolaridad(in);
        }

        @Override
        public trdd_c_realicador_escolaridad[] newArray(int size) {
            return new trdd_c_realicador_escolaridad[size];
        }
    };

    public int getId_escolaridad() {
        return id_escolaridad;
    }

    public void setId_escolaridad(int id_escolaridad) {
        this.id_escolaridad = id_escolaridad;
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
        parcel.writeInt(id_escolaridad);
        parcel.writeString(nombre);
    }
}
