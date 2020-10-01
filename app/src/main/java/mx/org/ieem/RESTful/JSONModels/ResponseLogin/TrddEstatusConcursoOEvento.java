
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddEstatusConcursoOEvento implements Serializable
{

    @SerializedName("id_estatus_coneve")
    @Expose
    private Integer idEstatusConeve;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    private final static long serialVersionUID = 7582401930404610575L;

    public Integer getIdEstatusConeve() {
        return idEstatusConeve;
    }

    public void setIdEstatusConeve(Integer idEstatusConeve) {
        this.idEstatusConeve = idEstatusConeve;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
