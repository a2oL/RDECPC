package mx.org.ieem.data.sqllite.models;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_pregunta implements Parcelable
{
    private String id_anio;
    private int id_mes;
    private int id_nivel_educativo;
    private int id_indicador;
    private String pregunta;

    public trdd_pregunta(String id_anio, int id_mes, int id_nivel_educativo, int id_indicador, String pregunta) {
        this.id_anio = id_anio;
        this.id_mes = id_mes;
        this.id_nivel_educativo = id_nivel_educativo;
        this.id_indicador = id_indicador;
        this.pregunta = pregunta;
    }

    protected trdd_pregunta(Parcel in) {
        id_anio = in.readString();
        id_mes = in.readInt();
        id_nivel_educativo = in.readInt();
        id_indicador = in.readInt();
        pregunta = in.readString();
    }

    public static final Creator<trdd_pregunta> CREATOR = new Creator<trdd_pregunta>() {
        @Override
        public trdd_pregunta createFromParcel(Parcel in) {
            return new trdd_pregunta(in);
        }

        @Override
        public trdd_pregunta[] newArray(int size) {
            return new trdd_pregunta[size];
        }
    };

    public String getId_anio() {
        return id_anio;
    }

    public void setId_anio(String id_anio) {
        this.id_anio = id_anio;
    }

    public int getId_mes() {
        return id_mes;
    }

    public void setId_mes(int id_mes) {
        this.id_mes = id_mes;
    }

    public int getId_nivel_educativo() {
        return id_nivel_educativo;
    }

    public void setId_nivel_educativo(int id_nivel_educativo) {
        this.id_nivel_educativo = id_nivel_educativo;
    }

    public int getId_indicador() {
        return id_indicador;
    }

    public void setId_indicador(int id_indicador) {
        this.id_indicador = id_indicador;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id_anio);
        dest.writeInt(id_mes);
        dest.writeInt(id_nivel_educativo);
        dest.writeInt(id_indicador);
        dest.writeString(pregunta);
    }
}
