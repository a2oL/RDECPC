
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddTipoReporte implements Serializable
{

    @SerializedName("id_tipo_reporte")
    @Expose
    private Integer idTipoReporte;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    private final static long serialVersionUID = 5890823875887280728L;

    public Integer getIdTipoReporte() {
        return idTipoReporte;
    }

    public void setIdTipoReporte(Integer idTipoReporte) {
        this.idTipoReporte = idTipoReporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
