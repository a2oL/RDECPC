package mx.org.ieem.data.sqllite.models.encuestaj;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_ej_nied_gres implements Parcelable
{
    private int id_nivel_educativo;
    private int id_grado_escolar;

    public trdd_ej_nied_gres(int id_nivel_educativo, int id_grado_escolar) {
        this.id_nivel_educativo = id_nivel_educativo;
        this.id_grado_escolar = id_grado_escolar;
    }

    protected trdd_ej_nied_gres(Parcel in) {
        id_nivel_educativo = in.readInt();
        id_grado_escolar = in.readInt();
    }

    public static final Creator<trdd_ej_nied_gres> CREATOR = new Creator<trdd_ej_nied_gres>() {
        @Override
        public trdd_ej_nied_gres createFromParcel(Parcel in) {
            return new trdd_ej_nied_gres(in);
        }

        @Override
        public trdd_ej_nied_gres[] newArray(int size) {
            return new trdd_ej_nied_gres[size];
        }
    };

    public int getId_nivel_educativo() {
        return id_nivel_educativo;
    }

    public void setId_nivel_educativo(int id_nivel_educativo) {
        this.id_nivel_educativo = id_nivel_educativo;
    }

    public int getId_grado_escolar() {
        return id_grado_escolar;
    }

    public void setId_grado_escolar(int id_grado_escolar) {
        this.id_grado_escolar = id_grado_escolar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_nivel_educativo);
        dest.writeInt(id_grado_escolar);
    }
}
