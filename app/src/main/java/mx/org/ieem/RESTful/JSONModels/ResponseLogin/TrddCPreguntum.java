
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddCPreguntum implements Serializable
{

    @SerializedName("id_anio")
    @Expose
    private String idAnio;
    @SerializedName("id_pregunta")
    @Expose
    private String idPregunta;
    private final static long serialVersionUID = -1592428048552891267L;

    public String getIdAnio() {
        return idAnio;
    }

    public void setIdAnio(String idAnio) {
        this.idAnio = idAnio;
    }

    public String getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }

}
