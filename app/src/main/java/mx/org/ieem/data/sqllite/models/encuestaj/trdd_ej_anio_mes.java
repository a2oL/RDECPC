package mx.org.ieem.data.sqllite.models.encuestaj;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_ej_anio_mes implements Parcelable
{
    private String id_anio;
    private int id_mes;

    public trdd_ej_anio_mes(String id_anio, int id_mes) {
        this.id_anio = id_anio;
        this.id_mes = id_mes;
    }

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

    protected trdd_ej_anio_mes(Parcel in) {
        id_anio = in.readString();
        id_mes = in.readInt();
    }

    public static final Creator<trdd_ej_anio_mes> CREATOR = new Creator<trdd_ej_anio_mes>() {
        @Override
        public trdd_ej_anio_mes createFromParcel(Parcel in) {
            return new trdd_ej_anio_mes(in);
        }

        @Override
        public trdd_ej_anio_mes[] newArray(int size) {
            return new trdd_ej_anio_mes[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id_anio);
        dest.writeInt(id_mes);
    }
}
