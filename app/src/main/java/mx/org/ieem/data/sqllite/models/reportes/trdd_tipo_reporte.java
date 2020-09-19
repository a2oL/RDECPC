package mx.org.ieem.data.sqllite.models.reportes;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_tipo_reporte implements Parcelable {
    private int id_tipo_reporte;
    private String nombre;

    public trdd_tipo_reporte(int id_tipo_reporte, String nombre) {
        this.id_tipo_reporte = id_tipo_reporte;
        this.nombre = nombre;
    }

    protected trdd_tipo_reporte(Parcel in) {
        id_tipo_reporte = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<trdd_tipo_reporte> CREATOR = new Creator<trdd_tipo_reporte>() {
        @Override
        public trdd_tipo_reporte createFromParcel(Parcel in) {
            return new trdd_tipo_reporte(in);
        }

        @Override
        public trdd_tipo_reporte[] newArray(int size) {
            return new trdd_tipo_reporte[size];
        }
    };

    public int getId_tipo_reporte() {
        return id_tipo_reporte;
    }

    public void setId_tipo_reporte(int id_tipo_reporte) {
        this.id_tipo_reporte = id_tipo_reporte;
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
        dest.writeInt(id_tipo_reporte);
        dest.writeString(nombre);
    }
}
