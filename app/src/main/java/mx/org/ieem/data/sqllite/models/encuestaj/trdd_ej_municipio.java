package mx.org.ieem.data.sqllite.models.encuestaj;


import android.os.Parcel;
import android.os.Parcelable;

public class trdd_ej_municipio implements Parcelable {
    private int id;
    private String nombre;

    public trdd_ej_municipio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    protected trdd_ej_municipio(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<trdd_ej_municipio> CREATOR = new Creator<trdd_ej_municipio>() {
        @Override
        public trdd_ej_municipio createFromParcel(Parcel in) {
            return new trdd_ej_municipio(in);
        }

        @Override
        public trdd_ej_municipio[] newArray(int size) {
            return new trdd_ej_municipio[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nombre);
    }
}
