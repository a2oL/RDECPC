package mx.org.ieem.data.sqllite.models;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_nivedu_ind implements Parcelable
{
    private int id_nivel_educativo;
    private int id_indicador;

    public trdd_nivedu_ind(int id_nivel_educativo, int id_indicador) {
        this.id_nivel_educativo = id_nivel_educativo;
        this.id_indicador = id_indicador;
    }

    protected trdd_nivedu_ind(Parcel in) {
        id_nivel_educativo = in.readInt();
        id_indicador = in.readInt();
    }

    public static final Creator<trdd_nivedu_ind> CREATOR = new Creator<trdd_nivedu_ind>() {
        @Override
        public trdd_nivedu_ind createFromParcel(Parcel in) {
            return new trdd_nivedu_ind(in);
        }

        @Override
        public trdd_nivedu_ind[] newArray(int size) {
            return new trdd_nivedu_ind[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_nivel_educativo);
        dest.writeInt(id_indicador);
    }
}
