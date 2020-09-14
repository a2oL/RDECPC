package mx.org.ieem.data.sqllite.models.eventos;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_concurso_o_evento implements Parcelable {
    private int id_con_eve;
    private String nombre;
    private String descripcion;
    private String url;
    private String url_image;
    private int id_estatus_coneve;

    public trdd_concurso_o_evento(int id_con_eve, String nombre, String descripcion, String url, String url_image, int id_estatus_coneve) {
        this.id_con_eve = id_con_eve;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.url_image = url_image;
        this.id_estatus_coneve = id_estatus_coneve;
    }

    public int getId_con_eve() {
        return id_con_eve;
    }

    public void setId_con_eve(int id_con_eve) {
        this.id_con_eve = id_con_eve;
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

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public int getId_estatus_coneve() {
        return id_estatus_coneve;
    }

    public void setId_estatus_coneve(int id_estatus_coneve) {
        this.id_estatus_coneve = id_estatus_coneve;
    }

    protected trdd_concurso_o_evento(Parcel in) {
        id_con_eve = in.readInt();
        nombre = in.readString();
        descripcion = in.readString();
        url = in.readString();
        url_image = in.readString();
        id_estatus_coneve = in.readInt();
    }

    public static final Creator<trdd_concurso_o_evento> CREATOR = new Creator<trdd_concurso_o_evento>() {
        @Override
        public trdd_concurso_o_evento createFromParcel(Parcel in) {
            return new trdd_concurso_o_evento(in);
        }

        @Override
        public trdd_concurso_o_evento[] newArray(int size) {
            return new trdd_concurso_o_evento[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_con_eve);
        dest.writeString(nombre);
        dest.writeString(descripcion);
        dest.writeString(url);
        dest.writeString(url_image);
        dest.writeInt(id_estatus_coneve);
    }
}
