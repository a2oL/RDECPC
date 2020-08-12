package mx.org.ieem.data.sqllite.models.ciudadanometro;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_c_realicador_edad implements Parcelable
{
    private int id_edad;
    private String nombre;

    public trdd_c_realicador_edad(int id_edad, String nombre) {
        this.id_edad = id_edad;
        this.nombre = nombre;
    }

    protected trdd_c_realicador_edad(Parcel in) {
        id_edad = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<trdd_c_realicador_edad> CREATOR = new Creator<trdd_c_realicador_edad>() {
        @Override
        public trdd_c_realicador_edad createFromParcel(Parcel in) {
            return new trdd_c_realicador_edad(in);
        }

        @Override
        public trdd_c_realicador_edad[] newArray(int size) {
            return new trdd_c_realicador_edad[size];
        }
    };

    public int getId_edad() {
        return id_edad;
    }

    public void setId_edad(int id_edad) {
        this.id_edad = id_edad;
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
        parcel.writeInt(id_edad);
        parcel.writeString(nombre);
    }
}
