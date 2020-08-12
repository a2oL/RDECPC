package mx.org.ieem.data.sqllite.models.ciudadanometro;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_c_detalle_encuesta implements Parcelable
{
    private String id_cct;
    private String id_random;
    private int id_encuesta;
    private String id_anio;
    private String id_pregunta;
    private int id_respuesta;
    private int id_estatus_respuesta;

    public trdd_c_detalle_encuesta(String id_cct, String id_random, int id_encuesta, String id_anio, String id_pregunta, int id_respuesta, int id_estatus_respuesta) {
        this.id_cct = id_cct;
        this.id_random = id_random;
        this.id_encuesta = id_encuesta;
        this.id_anio = id_anio;
        this.id_pregunta = id_pregunta;
        this.id_respuesta = id_respuesta;
        this.id_estatus_respuesta = id_estatus_respuesta;
    }

    protected trdd_c_detalle_encuesta(Parcel in) {
        id_cct = in.readString();
        id_random = in.readString();
        id_encuesta = in.readInt();
        id_anio = in.readString();
        id_pregunta = in.readString();
        id_respuesta = in.readInt();
        id_estatus_respuesta = in.readInt();
    }

    public static final Creator<trdd_c_detalle_encuesta> CREATOR = new Creator<trdd_c_detalle_encuesta>() {
        @Override
        public trdd_c_detalle_encuesta createFromParcel(Parcel in) {
            return new trdd_c_detalle_encuesta(in);
        }

        @Override
        public trdd_c_detalle_encuesta[] newArray(int size) {
            return new trdd_c_detalle_encuesta[size];
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id_cct);
        parcel.writeString(id_random);
        parcel.writeInt(id_encuesta);
        parcel.writeString(id_anio);
        parcel.writeString(id_pregunta);
        parcel.writeInt(id_respuesta);
        parcel.writeInt(id_estatus_respuesta);
    }
}
