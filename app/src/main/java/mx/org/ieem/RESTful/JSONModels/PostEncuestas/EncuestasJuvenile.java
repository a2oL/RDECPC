package mx.org.ieem.RESTful.JSONModels.PostEncuestas;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class EncuestasJuvenile {

    @SerializedName("id_cct")
    @Expose
    private String idCct;
    @SerializedName("id_random")
    @Expose
    private String idRandom;
    @SerializedName("id_encuesta")
    @Expose
    private Integer idEncuesta;
    @SerializedName("id_nivel_educativo")
    @Expose
    private Integer idNivelEductivo;
    @SerializedName("id_grado_escolar")
    @Expose
    private Integer idGradoEscolar;
    @SerializedName("detallesEncuesta")
    @Expose
    private List<DetallesEncuestum> detallesEncuesta = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public EncuestasJuvenile() {
    }

    /**
     *
     * @param detallesEncuesta
     * @param idEncuesta
     * @param idGradoEscolar
     * @param idRandom
     * @param idCct
     * @param idNivelEductivo
     */
    public EncuestasJuvenile(String idCct, String idRandom, Integer idEncuesta, Integer idNivelEductivo, Integer idGradoEscolar, List<DetallesEncuestum> detallesEncuesta) {
        super();
        this.idCct = idCct;
        this.idRandom = idRandom;
        this.idEncuesta = idEncuesta;
        this.idNivelEductivo = idNivelEductivo;
        this.idGradoEscolar = idGradoEscolar;
        this.detallesEncuesta = detallesEncuesta;
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

    public Integer getIdNivelEductivo() {
        return idNivelEductivo;
    }

    public void setIdNivelEductivo(Integer idNivelEductivo) {
        this.idNivelEductivo = idNivelEductivo;
    }

    public Integer getIdGradoEscolar() {
        return idGradoEscolar;
    }

    public void setIdGradoEscolar(Integer idGradoEscolar) {
        this.idGradoEscolar = idGradoEscolar;
    }

    public List<DetallesEncuestum> getDetallesEncuesta() {
        return detallesEncuesta;
    }

    public void setDetallesEncuesta(List<DetallesEncuestum> detallesEncuesta) {
        this.detallesEncuesta = detallesEncuesta;
    }

   // @Override
  // public String toString() {
       // Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //return gson.toJson(this);
  //      return new ToStringBuilder(this).append("idCct", idCct).append("idRandom", idRandom).append("idEncuesta", idEncuesta).append("idNivelEductivo", idNivelEductivo).append("idGradoEscolar", idGradoEscolar).append("detallesEncuesta", detallesEncuesta).toString();
  //  }

}
