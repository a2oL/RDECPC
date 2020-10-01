
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddCRealicadorEdad implements Serializable
{

    @SerializedName("id_edad")
    @Expose
    private Integer idEdad;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    private final static long serialVersionUID = 7694435039907294L;

    public Integer getIdEdad() {
        return idEdad;
    }

    public void setIdEdad(Integer idEdad) {
        this.idEdad = idEdad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
