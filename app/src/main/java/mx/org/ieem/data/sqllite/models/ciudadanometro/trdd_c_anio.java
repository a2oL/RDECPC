package mx.org.ieem.data.sqllite.models.ciudadanometro;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_c_anio implements Parcelable
{
    private String id_anio;

    public trdd_c_anio(String id_anio) {
        this.id_anio = id_anio;
    }

    protected trdd_c_anio(Parcel in) {
        id_anio = in.readString();
    }

    public static final Creator<trdd_c_anio> CREATOR = new Creator<trdd_c_anio>() {
        @Override
        public trdd_c_anio createFromParcel(Parcel in) {
            return new trdd_c_anio(in);
        }

        @Override
        public trdd_c_anio[] newArray(int size) {
            return new trdd_c_anio[size];
        }
    };

    public String getId_anio() {
        return id_anio;
    }

    public void setId_anio(String id_anio) {
        this.id_anio = id_anio;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id_anio);
    }
}
