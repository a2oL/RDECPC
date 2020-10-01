
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddEjMe implements Serializable
{

    @SerializedName("id_mes")
    @Expose
    private Integer idMes;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    private final static long serialVersionUID = -8261740888891936998L;

    public Integer getIdMes() {
        return idMes;
    }

    public void setIdMes(Integer idMes) {
        this.idMes = idMes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
