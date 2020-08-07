package mx.org.ieem.data.sqllite.models;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_anio implements Parcelable {
    private String id_anio;

    public trdd_anio(String id_anio) {
        this.id_anio = id_anio;
    }

    public String getId_anio() {
        return id_anio;
    }

    public void setId_anio(String id_anio) {
        this.id_anio = id_anio;
    }

    protected trdd_anio(Parcel in) {
        id_anio = in.readString();
    }

    public static final Creator<trdd_anio> CREATOR = new Creator<trdd_anio>() {
        @Override
        public trdd_anio createFromParcel(Parcel in) {
            return new trdd_anio(in);
        }

        @Override
        public trdd_anio[] newArray(int size) {
            return new trdd_anio[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id_anio);
    }
}
