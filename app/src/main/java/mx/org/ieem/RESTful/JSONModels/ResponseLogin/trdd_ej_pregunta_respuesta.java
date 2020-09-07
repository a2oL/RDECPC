package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class trdd_ej_pregunta_respuesta {

    @SerializedName("id_anio")
    @Expose
    private String idAnio;
    @SerializedName("id_mes")
    @Expose
    private Integer idMes;
    @SerializedName("id_nivel_educativo")
    @Expose
    private Integer idNivelEducativo;
    @SerializedName("id_indicador")
    @Expose
    private Integer idIndicador;
    @SerializedName("id_respuesta")
    @Expose
    private Integer idRespuesta;
    @SerializedName("id_estatus_respuesta")
    @Expose
    private Integer idEstatusRespuesta;
    @SerializedName("respuesta")
    @Expose
    private String respuesta;

    public String getIdAnio() {
        return idAnio;
    }

    public void setIdAnio(String idAnio) {
        this.idAnio = idAnio;
    }

    public Integer getIdMes() {
        return idMes;
    }

    public void setIdMes(Integer idMes) {
        this.idMes = idMes;
    }

    public Integer getIdNivelEducativo() {
        return idNivelEducativo;
    }

    public void setIdNivelEducativo(Integer idNivelEducativo) {
        this.idNivelEducativo = idNivelEducativo;
    }

    public Integer getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Integer idIndicador) {
        this.idIndicador = idIndicador;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        //return new ToStringBuilder(this).append("idAnio", idAnio).append("idMes", idMes).append("idNivelEducativo", idNivelEducativo).append("idIndicador", idIndicador).append("idRespuesta", idRespuesta).append("idEstatusRespuesta", idEstatusRespuesta).append("respuesta", respuesta).toString();
    }
}