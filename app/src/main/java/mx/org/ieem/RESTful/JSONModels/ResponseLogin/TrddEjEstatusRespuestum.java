
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddEjEstatusRespuestum implements Serializable
{

    @SerializedName("id_estatus_respuesta")
    @Expose
    private Integer idEstatusRespuesta;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    private final static long serialVersionUID = 4769162972939595870L;

    public Integer getIdEstatusRespuesta() {
        return idEstatusRespuesta;
    }

    public void setIdEstatusRespuesta(Integer idEstatusRespuesta) {
        this.idEstatusRespuesta = idEstatusRespuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
