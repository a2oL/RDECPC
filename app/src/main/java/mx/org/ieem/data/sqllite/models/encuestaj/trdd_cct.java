package mx.org.ieem.data.sqllite.models.encuestaj;

import android.os.Parcel;
import android.os.Parcelable;


public class trdd_cct implements Parcelable {
    private String id_cct;
    private String nombre;
    private String domicilio;
    private String email;
    private int id_municipio;
    private int id_nivel_educativo;
    private String contrasenia;

    public trdd_cct(String id_cct, String nombre, String domicilio, String email, int id_municipio, int id_nivel_educativo, String contrasenia) {
        this.id_cct = id_cct;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.email = email;
        this.id_municipio = id_municipio;
        this.id_nivel_educativo = id_nivel_educativo;
        this.contrasenia = contrasenia;
    }

    protected trdd_cct(Parcel in) {
        id_cct = in.readString();
        nombre = in.readString();
        domicilio = in.readString();
        email = in.readString();
        id_municipio = in.readInt();
        id_nivel_educativo = in.readInt();
        contrasenia = in.readString();
    }

    public static final Creator<trdd_cct> CREATOR = new Creator<trdd_cct>() {
        @Override
        public trdd_cct createFromParcel(Parcel in) {
            return new trdd_cct(in);
        }

        @Override
        public trdd_cct[] newArray(int size) {
            return new trdd_cct[size];
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id_cct);
        parcel.writeString(nombre);
        parcel.writeString(domicilio);
        parcel.writeString(email);
        parcel.writeInt(id_municipio);
        parcel.writeInt(id_nivel_educativo);
        parcel.writeString(contrasenia);
    }
}
