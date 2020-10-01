
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddCRealicadorGenero implements Serializable
{

    @SerializedName("id_genero")
    @Expose
    private Integer idGenero;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    private final static long serialVersionUID = 7316692606045071654L;

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
