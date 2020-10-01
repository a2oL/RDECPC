
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddCPreguntaRespuestum implements Serializable
{

    @SerializedName("id_anio")
    @Expose
    private String idAnio;
    @SerializedName("id_pregunta")
    @Expose
    private String idPregunta;
    @SerializedName("id_respuesta")
    @Expose
    private Integer idRespuesta;
    @SerializedName("id_estatus_respuesta")
    @Expose
    private Integer idEstatusRespuesta;
    @SerializedName("respuesta")
    @Expose
    private String respuesta;
    private final static long serialVersionUID = 6578788225839300154L;

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

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Integer getIdEstatusRespuesta() {
        return idEstatusRespuesta;
    }

    public void setIdEstatusRespuesta(Integer idEstatusRespuesta) {
        this.idEstatusRespuesta = idEstatusRespuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}
