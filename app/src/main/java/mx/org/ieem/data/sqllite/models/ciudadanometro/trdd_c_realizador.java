package mx.org.ieem.data.sqllite.models.ciudadanometro;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_c_realizador implements Parcelable
{
    private int id_realizador;
    private String nombre;

    public trdd_c_realizador(int id_realizador, String nombre) {
        this.id_realizador = id_realizador;
        this.nombre = nombre;
    }

    protected trdd_c_realizador(Parcel in) {
        id_realizador = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<trdd_c_realizador> CREATOR = new Creator<trdd_c_realizador>() {
        @Override
        public trdd_c_realizador createFromParcel(Parcel in) {
            return new trdd_c_realizador(in);
        }

        @Override
        public trdd_c_realizador[] newArray(int size) {
            return new trdd_c_realizador[size];
        }
    };

    public int getId_realizador() {
        return id_realizador;
    }

    public void setId_realizador(int id_realizador) {
        this.id_realizador = id_realizador;
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
        parcel.writeInt(id_realizador);
        parcel.writeString(nombre);
    }
}
