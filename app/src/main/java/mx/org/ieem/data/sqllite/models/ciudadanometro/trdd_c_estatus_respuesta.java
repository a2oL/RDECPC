package mx.org.ieem.data.sqllite.models.ciudadanometro;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_c_estatus_respuesta implements Parcelable
{
    private int id_estatus_respuesta;
    private int nombre;

    public trdd_c_estatus_respuesta(int id_estatus_respuesta, int nombre) {
        this.id_estatus_respuesta = id_estatus_respuesta;
        this.nombre = nombre;
    }

    protected trdd_c_estatus_respuesta(Parcel in) {
        id_estatus_respuesta = in.readInt();
        nombre = in.readInt();
    }

    public static final Creator<trdd_c_estatus_respuesta> CREATOR = new Creator<trdd_c_estatus_respuesta>() {
        @Override
        public trdd_c_estatus_respuesta createFromParcel(Parcel in) {
            return new trdd_c_estatus_respuesta(in);
        }

        @Override
        public trdd_c_estatus_respuesta[] newArray(int size) {
            return new trdd_c_estatus_respuesta[size];
        }
    };

    public int getId_estatus_respuesta() {
        return id_estatus_respuesta;
    }

    public void setId_estatus_respuesta(int id_estatus_respuesta) {
        this.id_estatus_respuesta = id_estatus_respuesta;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id_estatus_respuesta);
        parcel.writeInt(nombre);
    }
}
