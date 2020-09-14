package mx.org.ieem.data.sqllite.models.reportes;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_estatus_reporte implements Parcelable {
    private int id_estatus_reporte;
    private String nombre;

    public trdd_estatus_reporte(int id_estatus_reporte, String nombre) {
        this.id_estatus_reporte = id_estatus_reporte;
        this.nombre = nombre;
    }

    protected trdd_estatus_reporte(Parcel in) {
        id_estatus_reporte = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<trdd_estatus_reporte> CREATOR = new Creator<trdd_estatus_reporte>() {
        @Override
        public trdd_estatus_reporte createFromParcel(Parcel in) {
            return new trdd_estatus_reporte(in);
        }

        @Override
        public trdd_estatus_reporte[] newArray(int size) {
            return new trdd_estatus_reporte[size];
        }
    };

    public int getId_estatus_reporte() {
        return id_estatus_reporte;
    }

    public void setId_estatus_reporte(int id_estatus_reporte) {
        this.id_estatus_reporte = id_estatus_reporte;
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
        dest.writeInt(id_estatus_reporte);
        dest.writeString(nombre);
    }
}
