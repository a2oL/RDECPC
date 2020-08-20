package mx.org.ieem.data.sqllite.models.eventos;

import android.os.Parcel;
import android.os.Parcelable;

public class eventos implements Parcelable {
    private String id_evento;
    private String nombre;
    private String url;
    private String image;

    public eventos(String id_evento, String nombre, String url, String image) {
        this.id_evento = id_evento;
        this.nombre = nombre;
        this.url = url;
        this.image = image;
    }

    protected eventos(Parcel in) {
        id_evento = in.readString();
        nombre = in.readString();
        url = in.readString();
        image = in.readString();
    }

    public static final Creator<eventos> CREATOR = new Creator<eventos>() {
        @Override
        public eventos createFromParcel(Parcel in) {
            return new eventos(in);
        }

        @Override
        public eventos[] newArray(int size) {
            return new eventos[size];
        }
    };

    public String getId_evento() {
        return id_evento;
    }

    public void setId_evento(String id_evento) {
        this.id_evento = id_evento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id_evento);
        parcel.writeString(nombre);
        parcel.writeString(url);
        parcel.writeString(image);
    }
}
