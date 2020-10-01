
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddEstatusReporte implements Serializable
{

    @SerializedName("id_estatus_reporte")
    @Expose
    private Integer idEstatusReporte;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    private final static long serialVersionUID = 3105884884588644479L;

    public Integer getIdEstatusReporte() {
        return idEstatusReporte;
    }

    public void setIdEstatusReporte(Integer idEstatusReporte) {
        this.idEstatusReporte = idEstatusReporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
