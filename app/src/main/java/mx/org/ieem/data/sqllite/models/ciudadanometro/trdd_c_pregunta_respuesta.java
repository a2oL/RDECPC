package mx.org.ieem.data.sqllite.models.ciudadanometro;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_c_pregunta_respuesta implements Parcelable
{
    private String id_anio;
    private String id_pregunta;
    private int id_respuesta;
    private int id_estatus_respuesta;
    private String respuesta;

    public trdd_c_pregunta_respuesta(String id_anio, String id_pregunta, int id_respuesta, int id_estatus_respuesta, String respuesta) {
        this.id_anio = id_anio;
        this.id_pregunta = id_pregunta;
        this.id_respuesta = id_respuesta;
        this.id_estatus_respuesta = id_estatus_respuesta;
        this.respuesta = respuesta;
    }

    protected trdd_c_pregunta_respuesta(Parcel in) {
        id_anio = in.readString();
        id_pregunta = in.readString();
        id_respuesta = in.readInt();
        id_estatus_respuesta = in.readInt();
        respuesta = in.readString();
    }

    public static final Creator<trdd_c_pregunta_respuesta> CREATOR = new Creator<trdd_c_pregunta_respuesta>() {
        @Override
        public trdd_c_pregunta_respuesta createFromParcel(Parcel in) {
            return new trdd_c_pregunta_respuesta(in);
        }

        @Override
        public trdd_c_pregunta_respuesta[] newArray(int size) {
            return new trdd_c_pregunta_respuesta[size];
        }
    };

    public String getId_anio() {
        return id_anio;
    }

    public void setId_anio(String id_anio) {
        this.id_anio = id_anio;
    }

    public String getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(String id_pregunta) {
        this.id_pregunta = id_pregunta;
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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id_anio);
        parcel.writeString(id_pregunta);
        parcel.writeInt(id_respuesta);
        parcel.writeInt(id_estatus_respuesta);
        parcel.writeString(respuesta);
    }
}
