package mx.org.ieem.data.sqllite.models.encuestaj;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_ej_cct implements Parcelable {
    private String id_cct;
    private String nombre;
    private String domicilio;
    private String email;
    private int id_municipio;
    private int id_nivel_educativo;

    public trdd_ej_cct(String id_cct, String nombre, String domicilio, String email, int id_municipio, int id_nivel_educativo) {
        this.id_cct = id_cct;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.email = email;
        this.id_municipio = id_municipio;
        this.id_nivel_educativo = id_nivel_educativo;
    }

    protected trdd_ej_cct(Parcel in) {
        id_cct = in.readString();
        nombre = in.readString();
        domicilio = in.readString();
        email = in.readString();
        id_municipio = in.readInt();
        id_nivel_educativo = in.readInt();
    }

    public static final Creator<trdd_ej_cct> CREATOR = new Creator<trdd_ej_cct>() {
        @Override
        public trdd_ej_cct createFromParcel(Parcel in) {
            return new trdd_ej_cct(in);
        }

        @Override
        public trdd_ej_cct[] newArray(int size) {
            return new trdd_ej_cct[size];
        }
    };

    public String getId_cct() {
        return id_cct;
    }

    public void setId_cct(String id_cct) {
        this.id_cct = id_cct;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public int getId_nivel_educativo() {
        return id_nivel_educativo;
    }

    public void setId_nivel_educativo(int id_nivel_educativo) {
        this.id_nivel_educativo = id_nivel_educativo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id_cct);
        dest.writeString(nombre);
        dest.writeString(domicilio);
        dest.writeString(email);
        dest.writeInt(id_municipio);
        dest.writeInt(id_nivel_educativo);
    }
}
