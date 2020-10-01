
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddCRealizador implements Serializable
{

    @SerializedName("id_realizador")
    @Expose
    private Integer idRealizador;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    private final static long serialVersionUID = 4561294223144072485L;

    public Integer getIdRealizador() {
        return idRealizador;
    }

    public void setIdRealizador(Integer idRealizador) {
        this.idRealizador = idRealizador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
