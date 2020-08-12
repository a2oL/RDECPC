package mx.org.ieem.data.sqllite.models.encuestaj;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_ej_grado_escolar implements Parcelable {
    private int id_grado_escolar;
    private String nombre;
    private String siglas;
    private String grado;

    public trdd_ej_grado_escolar(int id_grado_escolar, String nombre, String siglas, String grado) {
        this.id_grado_escolar = id_grado_escolar;
        this.nombre = nombre;
        this.siglas = siglas;
        this.grado = grado;
    }

    protected trdd_ej_grado_escolar(Parcel in) {
        id_grado_escolar = in.readInt();
        nombre = in.readString();
        siglas = in.readString();
        grado = in.readString();
    }

    public static final Creator<trdd_ej_grado_escolar> CREATOR = new Creator<trdd_ej_grado_escolar>() {
        @Override
        public trdd_ej_grado_escolar createFromParcel(Parcel in) {
            return new trdd_ej_grado_escolar(in);
        }

        @Override
        public trdd_ej_grado_escolar[] newArray(int size) {
            return new trdd_ej_grado_escolar[size];
        }
    };

    public int getId_grado_escolar() {
        return id_grado_escolar;
    }

    public void setId_grado_escolar(int id_grado_escolar) {
        this.id_grado_escolar = id_grado_escolar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_grado_escolar);
        dest.writeString(nombre);
        dest.writeString(siglas);
        dest.writeString(grado);
    }
}
