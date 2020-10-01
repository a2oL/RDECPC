
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddCRealicadorEscolaridad implements Serializable
{

    @SerializedName("id_escolaridad")
    @Expose
    private Integer idEscolaridad;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    private final static long serialVersionUID = -1231122398556465745L;

    public Integer getIdEscolaridad() {
        return idEscolaridad;
    }

    public void setIdEscolaridad(Integer idEscolaridad) {
        this.idEscolaridad = idEscolaridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
