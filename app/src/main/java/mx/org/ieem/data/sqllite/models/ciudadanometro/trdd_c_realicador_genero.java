package mx.org.ieem.data.sqllite.models.ciudadanometro;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_c_realicador_genero implements Parcelable
{
    private int id_genero;
    private String nombre;

    public trdd_c_realicador_genero(int id_genero, String nombre) {
        this.id_genero = id_genero;
        this.nombre = nombre;
    }

    protected trdd_c_realicador_genero(Parcel in) {
        id_genero = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<trdd_c_realicador_genero> CREATOR = new Creator<trdd_c_realicador_genero>() {
        @Override
        public trdd_c_realicador_genero createFromParcel(Parcel in) {
            return new trdd_c_realicador_genero(in);
        }

        @Override
        public trdd_c_realicador_genero[] newArray(int size) {
            return new trdd_c_realicador_genero[size];
        }
    };

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
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
        parcel.writeInt(id_genero);
        parcel.writeString(nombre);
    }
}
