package mx.org.ieem.data.sqllite.models.encuestaj;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_ej_pregunta_respuesta implements Parcelable
{
    private String id_anio;
    private int id_mes;
    private int id_nivel_educativo;
    private int id_indicador;
    private int id_respuesta;
    private int id_estatus_respuesta;
    private String respuesta;

    public trdd_ej_pregunta_respuesta(String id_anio, int id_mes, int id_nivel_educativo, int id_indicador, int id_respuesta, int id_estatus_respuesta, String respuesta) {
        this.id_anio = id_anio;
        this.id_mes = id_mes;
        this.id_nivel_educativo = id_nivel_educativo;
        this.id_indicador = id_indicador;
        this.id_respuesta = id_respuesta;
        this.id_estatus_respuesta = id_estatus_respuesta;
        this.respuesta = respuesta;
    }

    protected trdd_ej_pregunta_respuesta(Parcel in) {
        id_anio = in.readString();
        id_mes = in.readInt();
        id_nivel_educativo = in.readInt();
        id_indicador = in.readInt();
        id_respuesta = in.readInt();
        id_estatus_respuesta = in.readInt();
        respuesta = in.readString();
    }

    public static final Creator<trdd_ej_pregunta_respuesta> CREATOR = new Creator<trdd_ej_pregunta_respuesta>() {
        @Override
        public trdd_ej_pregunta_respuesta createFromParcel(Parcel in) {
            return new trdd_ej_pregunta_respuesta(in);
        }

        @Override
        public trdd_ej_pregunta_respuesta[] newArray(int size) {
            return new trdd_ej_pregunta_respuesta[size];
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

    public int getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(int id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    public int getId_estatus_respuesta() {
        return id_estatus_respuesta;
    }

    public void setId_estatus_respuesta(int id_estatus_respuesta) {
        this.id_estatus_respuesta = id_estatus_respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
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
        dest.writeInt(id_respuesta);
        dest.writeInt(id_estatus_respuesta);
        dest.writeString(respuesta);
    }
}
