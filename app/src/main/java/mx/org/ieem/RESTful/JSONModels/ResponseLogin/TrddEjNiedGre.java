
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TrddEjNiedGre implements Serializable
{

    @SerializedName("id_nivel_educativo")
    @Expose
    private Integer idNivelEducativo;
    @SerializedName("id_grado_escolar")
    @Expose
    private Integer idGradoEscolar;
    private final static long serialVersionUID = 2728379685795299650L;

    public Integer getIdNivelEducativo() {
        return idNivelEducativo;
    }

    public void setIdNivelEducativo(Integer idNivelEducativo) {
        this.idNivelEducativo = idNivelEducativo;
    }

    public Integer getIdGradoEscolar() {
        return idGradoEscolar;
    }

    public void setIdGradoEscolar(Integer idGradoEscolar) {
        this.idGradoEscolar = idGradoEscolar;
    }

}
