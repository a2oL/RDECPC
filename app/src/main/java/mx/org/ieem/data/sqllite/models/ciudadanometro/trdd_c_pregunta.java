package mx.org.ieem.data.sqllite.models.ciudadanometro;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_c_pregunta implements Parcelable
{
    private String id_anio;
    private String id_pregunta;

    public trdd_c_pregunta(String id_anio, String id_pregunta) {
        this.id_anio = id_anio;
        this.id_pregunta = id_pregunta;
    }

    protected trdd_c_pregunta(Parcel in) {
        id_anio = in.readString();
        id_pregunta = in.readString();
    }

    public static final Creator<trdd_c_pregunta> CREATOR = new Creator<trdd_c_pregunta>() {
        @Override
        public trdd_c_pregunta createFromParcel(Parcel in) {
            return new trdd_c_pregunta(in);
        }

        @Override
        public trdd_c_pregunta[] newArray(int size) {
            return new trdd_c_pregunta[size];
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id_anio);
        parcel.writeString(id_pregunta);
    }
}
