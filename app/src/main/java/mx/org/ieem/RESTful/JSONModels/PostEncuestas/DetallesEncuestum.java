package mx.org.ieem.RESTful.JSONModels.PostEncuestas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class DetallesEncuestum {

    @SerializedName("id_cct")
    @Expose
    private String idCct;
    @SerializedName("id_random")
    @Expose
    private String idRandom;
    @SerializedName("id_encuesta")
    @Expose
    private Integer idEncuesta;
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

    /**
     * No args constructor for use in serialization
     *
     */
    public DetallesEncuestum() {
    }

    /**
     *
     * @param idAnio
     * @param idEstatusRespuesta
     * @param idMes
     * @param idEncuesta
     * @param idNivelEducativo
     * @param idIndicador
     * @param idRandom
     * @param idRespuesta
     * @param idCct
     */
    public DetallesEncuestum(String idCct, String idRandom, Integer idEncuesta, String idAnio, Integer idMes, Integer idNivelEducativo, Integer idIndicador, Integer idRespuesta, Integer idEstatusRespuesta) {
        super();
        this.idCct = idCct;
        this.idRandom = idRandom;
        this.idEncuesta = idEncuesta;
        this.idAnio = idAnio;
        this.idMes = idMes;
        this.idNivelEducativo = idNivelEducativo;
        this.idIndicador = idIndicador;
        this.idRespuesta = idRespuesta;
        this.idEstatusRespuesta = idEstatusRespuesta;
    }

    public String getIdCct() {
        return idCct;
    }

    public void setIdCct(String idCct) {
        this.idCct = idCct;
    }

    public String getIdRandom() {
        return idRandom;
    }

    public void setIdRandom(String idRandom) {
        this.idRandom = idRandom;
    }

    public Integer getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Integer idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

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

  //  @Override
  //  public String toString() {
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //return gson.toJson(this);
      // return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        //return new ToStringBuilder(this).append("idCct", idCct).append("idRandom", idRandom).append("idEncuesta", idEncuesta).append("idAnio", idAnio).append("idMes", idMes).append("idNivelEducativo", idNivelEducativo).append("idGradoEscolar", idGradoEscolar).append("idIndicador", idIndicador).append("idRespuesta", idRespuesta).append("idEstatusRespuesta", idEstatusRespuesta).toString();
   // }

}
