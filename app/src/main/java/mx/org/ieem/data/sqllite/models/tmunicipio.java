package mx.org.ieem.data.sqllite.models;


import android.os.Parcel;
import android.os.Parcelable;

public class tmunicipio implements Parcelable {
    private int id;
    private String nombre;

    public tmunicipio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    protected tmunicipio(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<tmunicipio> CREATOR = new Creator<tmunicipio>() {
        @Override
        public tmunicipio createFromParcel(Parcel in) {
            return new tmunicipio(in);
        }

        @Override
        public tmunicipio[] newArray(int size) {
            return new tmunicipio[size];
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
