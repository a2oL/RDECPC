package mx.org.ieem.data.sqllite.models.encuestaj;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_ej_indicador implements Parcelable
{
    private int id_indicador;
    private String nombre;

    public trdd_ej_indicador(int id_indicador, String nombre) {
        this.id_indicador = id_indicador;
        this.nombre = nombre;
    }

    protected trdd_ej_indicador(Parcel in) {
        id_indicador = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<trdd_ej_indicador> CREATOR = new Creator<trdd_ej_indicador>() {
        @Override
        public trdd_ej_indicador createFromParcel(Parcel in) {
            return new trdd_ej_indicador(in);
        }

        @Override
        public trdd_ej_indicador[] newArray(int size) {
            return new trdd_ej_indicador[size];
        }
    };

    public int getId_indicador() {
        return id_indicador;
    }

    public void setId_indicador(int id_indicador) {
        this.id_indicador = id_indicador;
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
        dest.writeInt(id_indicador);
        dest.writeString(nombre);
    }
}
