package mx.org.ieem.data.sqllite.models.ciudadanometro;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_c_encuesta implements Parcelable
{
    private String id_cct;
    private String id_random;
    private int id_encuesta;
    private int id_realizador;
    private int id_realizador_niv_edu;
    private int id_realizador_grad_esc;
    private int id_realizador_edad;
    private int id_realizador_genero;
    private int id_realizador_escolaridad;

    public trdd_c_encuesta(String id_cct, String id_random, int id_encuesta, int id_realizador, int id_realizador_niv_edu, int id_realizador_grad_esc, int id_realizador_edad, int id_realizador_genero, int id_realizador_escolaridad) {
        this.id_cct = id_cct;
        this.id_random = id_random;
        this.id_encuesta = id_encuesta;
        this.id_realizador = id_realizador;
        this.id_realizador_niv_edu = id_realizador_niv_edu;
        this.id_realizador_grad_esc = id_realizador_grad_esc;
        this.id_realizador_edad = id_realizador_edad;
        this.id_realizador_genero = id_realizador_genero;
        this.id_realizador_escolaridad = id_realizador_escolaridad;
    }

    protected trdd_c_encuesta(Parcel in) {
        id_cct = in.readString();
        id_random = in.readString();
        id_encuesta = in.readInt();
        id_realizador = in.readInt();
        id_realizador_niv_edu = in.readInt();
        id_realizador_grad_esc = in.readInt();
        id_realizador_edad = in.readInt();
        id_realizador_genero = in.readInt();
        id_realizador_escolaridad = in.readInt();
    }

    public static final Creator<trdd_c_encuesta> CREATOR = new Creator<trdd_c_encuesta>() {
        @Override
        public trdd_c_encuesta createFromParcel(Parcel in) {
            return new trdd_c_encuesta(in);
        }

        @Override
        public trdd_c_encuesta[] newArray(int size) {
            return new trdd_c_encuesta[size];
        }
    };

    public String getId_cct() {
        return id_cct;
    }

    public void setId_cct(String id_cct) {
        this.id_cct = id_cct;
    }

    public String getId_random() {
        return id_random;
    }

    public void setId_random(String id_random) {
        this.id_random = id_random;
    }

    public int getId_encuesta() {
        return id_encuesta;
    }

    public void setId_encuesta(int id_encuesta) {
        this.id_encuesta = id_encuesta;
    }

    public int getId_realizador() {
        return id_realizador;
    }

    public void setId_realizador(int id_realizador) {
        this.id_realizador = id_realizador;
    }

    public int getId_realizador_niv_edu() {
        return id_realizador_niv_edu;
    }

    public void setId_realizador_niv_edu(int id_realizador_niv_edu) {
        this.id_realizador_niv_edu = id_realizador_niv_edu;
    }

    public int getId_realizador_grad_esc() {
        return id_realizador_grad_esc;
    }

    public void setId_realizador_grad_esc(int id_realizador_grad_esc) {
        this.id_realizador_grad_esc = id_realizador_grad_esc;
    }

    public int getId_realizador_edad() {
        return id_realizador_edad;
    }

    public void setId_realizador_edad(int id_realizador_edad) {
        this.id_realizador_edad = id_realizador_edad;
    }

    public int getId_realizador_genero() {
        return id_realizador_genero;
    }

    public void setId_realizador_genero(int id_realizador_genero) {
        this.id_realizador_genero = id_realizador_genero;
    }

    public int getId_realizador_escolaridad() {
        return id_realizador_escolaridad;
    }

    public void setId_realizador_escolaridad(int id_realizador_escolaridad) {
        this.id_realizador_escolaridad = id_realizador_escolaridad;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id_cct);
        parcel.writeString(id_random);
        parcel.writeInt(id_encuesta);
        parcel.writeInt(id_realizador);
        parcel.writeInt(id_realizador_niv_edu);
        parcel.writeInt(id_realizador_grad_esc);
        parcel.writeInt(id_realizador_edad);
        parcel.writeInt(id_realizador_genero);
        parcel.writeInt(id_realizador_escolaridad);
    }
}
