package mx.org.ieem.data.sqllite.models.reportes;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_reporte implements Parcelable {
    private int id_reporte;
    private String nombre;
    private String descripcion;
    private String url;
    private int id_estatus_reporte;
    private int id_tipo_reporte;

    public trdd_reporte(int id_reporte, String nombre, String descripcion, String url, int id_estatus_reporte, int id_tipo_reporte) {
        this.id_reporte = id_reporte;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.id_estatus_reporte = id_estatus_reporte;
        this.id_tipo_reporte = id_tipo_reporte;
    }

    protected trdd_reporte(Parcel in) {
        id_reporte = in.readInt();
        nombre = in.readString();
        descripcion = in.readString();
        url = in.readString();
        id_estatus_reporte = in.readInt();
        id_tipo_reporte = in.readInt();
    }

    public static final Creator<trdd_reporte> CREATOR = new Creator<trdd_reporte>() {
        @Override
        public trdd_reporte createFromParcel(Parcel in) {
            return new trdd_reporte(in);
        }

        @Override
        public trdd_reporte[] newArray(int size) {
            return new trdd_reporte[size];
        }
    };

    public int getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(int id_reporte) {
        this.id_reporte = id_reporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId_estatus_reporte() {
        return id_estatus_reporte;
    }

    public void setId_estatus_reporte(int id_estatus_reporte) {
        this.id_estatus_reporte = id_estatus_reporte;
    }

    public int getId_tipo_reporte() {
        return id_tipo_reporte;
    }

    public void setId_tipo_reporte(int id_tipo_reporte) {
        this.id_tipo_reporte = id_tipo_reporte;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_reporte);
        dest.writeString(nombre);
        dest.writeString(descripcion);
        dest.writeString(url);
        dest.writeInt(id_estatus_reporte);
        dest.writeInt(id_tipo_reporte);
    }
}
