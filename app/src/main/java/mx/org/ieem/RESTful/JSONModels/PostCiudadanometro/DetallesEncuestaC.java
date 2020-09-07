package mx.org.ieem.RESTful.JSONModels.PostCiudadanometro;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DetallesEncuestaC {

    @SerializedName("id_cct")
    @Expose
    private String idCct;
    @SerializedName("id_random")
    @Expose
    private String idRandom;
    @SerializedName("id_encuesta")
    @Expose
    private int idEncuesta;
    @SerializedName("id_anio")
    @Expose
    private String idAnio;
    @SerializedName("id_pregunta")
    @Expose
    private String idPregunta;
    @SerializedName("id_respuesta")
    @Expose
    private int idRespuesta;
    @SerializedName("id_estatus_respuesta")
    @Expose
    private int idEstatusRespuesta;

    /**
     * No args constructor for use in serialization
     *
     */
    public DetallesEncuestaC() {
    }

    /**
     *
     * @param idAnio
     * @param idEstatusRespuesta
     * @param idEncuesta
     * @param idRandom
     * @param idRespuesta
     * @param idCct
     * @param idPregunta
     */
    public DetallesEncuestaC(String idCct, String idRandom, int idEncuesta, String idAnio, String idPregunta, int idRespuesta, int idEstatusRespuesta) {
        super();
        this.idCct = idCct;
        this.idRandom = idRandom;
        this.idEncuesta = idEncuesta;
        this.idAnio = idAnio;
        this.idPregunta = idPregunta;
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

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

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

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public int getIdEstatusRespuesta() {
        return idEstatusRespuesta;
    }

    public void setIdEstatusRespuesta(int idEstatusRespuesta) {
        this.idEstatusRespuesta = idEstatusRespuesta;
    }

   // @Override
   // public String toString() {
 //       return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
       // return new ToStringBuilder(this).append("idCct", idCct).append("idRandom", idRandom).append("idEncuesta", idEncuesta).append("idAnio", idAnio).append("idPregunta", idPregunta).append("idRespuesta", idRespuesta).append("idEstatusRespuesta", idEstatusRespuesta).toString();
   // }

}