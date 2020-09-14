package mx.org.ieem.data.sqllite.models.eventos;

import android.os.Parcel;
import android.os.Parcelable;

public class trdd_estatus_concurso_o_evento implements Parcelable {
    private int id_estatus_coneve;
    private String nombre;

    public trdd_estatus_concurso_o_evento(int id_estatus_coneve, String nombre) {
        this.id_estatus_coneve = id_estatus_coneve;
        this.nombre = nombre;
    }

    public int getId_estatus_coneve() {
        return id_estatus_coneve;
    }

    public void setId_estatus_coneve(int id_estatus_coneve) {
        this.id_estatus_coneve = id_estatus_coneve;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected trdd_estatus_concurso_o_evento(Parcel in) {
        id_estatus_coneve = in.readInt();
        nombre = in.readString();
    }

    public static final Creator<trdd_estatus_concurso_o_evento> CREATOR = new Creator<trdd_estatus_concurso_o_evento>() {
        @Override
        public trdd_estatus_concurso_o_evento createFromParcel(Parcel in) {
            return new trdd_estatus_concurso_o_evento(in);
        }

        @Override
        public trdd_estatus_concurso_o_evento[] newArray(int size) {
            return new trdd_estatus_concurso_o_evento[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_estatus_coneve);
        dest.writeString(nombre);
    }
}
