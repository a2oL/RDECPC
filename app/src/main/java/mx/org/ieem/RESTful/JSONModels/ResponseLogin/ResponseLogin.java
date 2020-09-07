package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class ResponseLogin {

    @SerializedName("trdd_cct")
    @Expose
    private trdd_cct trddcct;
    @SerializedName("trdd_municipio")
    @Expose
    private List<trdd_municipio> trddmunicipio = null;
    @SerializedName("trdd_nivel_educativo")
    @Expose
    private List<trdd_nivel_educativo> trddniveleducativo = null;
    @SerializedName("trdd_ej_anio")
    @Expose
    private List<trdd_ej_anio> trddejanio = null;
    @SerializedName("trdd_ej_mes")
    @Expose
    private List<trdd_ej_mes> trddejmes = null;
    @SerializedName("trdd_ej_anio_mes")
    @Expose
    private List<trdd_ej_anio_mes> trddejaniomes = null;
    @SerializedName("trdd_ej_grado_escolar")
    @Expose
    private List<trdd_ej_grado_escolar> trddejgradoescolar = null;
    @SerializedName("trdd_ej_nied_gres")
    @Expose
    private List<trdd_ej_nied_gres> trddejniedgres = null;
    @SerializedName("trdd_ej_indicador")
    @Expose
    private List<trdd_ej_indicador> trddejindicador = null;
    @SerializedName("trdd_ej_nivedu_ind")
    @Expose
    private List<trdd_ej_nivedu_ind> trddejniveduind = null;
    @SerializedName("trdd_ej_pregunta")
    @Expose
    private List<trdd_ej_pregunta> trddEjPregunta = null;
    @SerializedName("trdd_ej_estatus_respuesta")
    @Expose
    private List<trdd_ej_estatus_respuesta> trddEjEstatusRespuesta = null;
    @SerializedName("trdd_ej_pregunta_respuesta")
    @Expose
    private List<trdd_ej_pregunta_respuesta> trddEjPreguntaRespuesta = null;
    @SerializedName("trdd_c_grado_escolar")
    @Expose
    private List<trdd_c_grado_escolar> trddcgradoescolar = null;
    @SerializedName("trdd_c_nied_gres")
    @Expose
    private List<trdd_c_nied_gres> trddcniedgres = null;
    @SerializedName("trdd_c_realizador")
    @Expose
    private List<trdd_c_realizador> trddcrealizador = null;
    @SerializedName("trdd_c_anio")
    @Expose
    private List<trdd_c_anio> trddcanio = null;
    @SerializedName("trdd_c_pregunta")
    @Expose
    private List<trdd_c_pregunta> trddCPregunta = null;
    @SerializedName("trdd_c_estatus_respuesta")
    @Expose
    private List<trdd_c_estatus_respuesta> trddCEstatusRespuesta = null;
    @SerializedName("trdd_c_pregunta_respuesta")
    @Expose
    private List<trdd_c_pregunta_respuesta> trddCPreguntaRespuesta = null;
    @SerializedName("trdd_c_realicador_edad")
    @Expose
    private List<trdd_c_realicador_edad> trddcrealicadoredad = null;
    @SerializedName("trdd_c_realicador_genero")
    @Expose
    private List<trdd_c_realicador_genero> trddcrealicadorgenero = null;
    @SerializedName("trdd_c_realicador_escolaridad")
    @Expose
    private List<trdd_c_realicador_escolaridad> trddcrealicadorescolaridad = null;

    public trdd_cct getTrddcct() {
        return trddcct;
    }

    public void setTrddcct(trdd_cct trddcct) {
        this.trddcct = trddcct;
    }

    public List<trdd_municipio> getTrddmunicipio() {
        return trddmunicipio;
    }

    public void setTrddmunicipio(List<trdd_municipio> trddmunicipio) {
        this.trddmunicipio = trddmunicipio;
    }

    public List<trdd_nivel_educativo> getTrddniveleducativo() {
        return trddniveleducativo;
    }

    public void setTrddniveleducativo(List<trdd_nivel_educativo> trddniveleducativo) {
        this.trddniveleducativo = trddniveleducativo;
    }

    public List<trdd_ej_anio> getTrddejanio() {
        return trddejanio;
    }

    public void setTrddejanio(List<trdd_ej_anio> trddejanio) {
        this.trddejanio = trddejanio;
    }

    public List<trdd_ej_mes> getTrddejmes() {
        return trddejmes;
    }

    public void setTrddejmes(List<trdd_ej_mes> trddejmes) {
        this.trddejmes = trddejmes;
    }

    public List<trdd_ej_anio_mes> getTrddejaniomes() {
        return trddejaniomes;
    }

    public void setTrddejaniomes(List<trdd_ej_anio_mes> trddejaniomes) {
        this.trddejaniomes = trddejaniomes;
    }

    public List<trdd_ej_grado_escolar> getTrddejgradoescolar() {
        return trddejgradoescolar;
    }

    public void setTrddejgradoescolar(List<trdd_ej_grado_escolar> trddejgradoescolar) {
        this.trddejgradoescolar = trddejgradoescolar;
    }

    public List<trdd_ej_nied_gres> getTrddejniedgres() {
        return trddejniedgres;
    }

    public void setTrddejniedgres(List<trdd_ej_nied_gres> trddejniedgres) {
        this.trddejniedgres = trddejniedgres;
    }

    public List<trdd_ej_indicador> getTrddejindicador() {
        return trddejindicador;
    }

    public void setTrddejindicador(List<trdd_ej_indicador> trddejindicador) {
        this.trddejindicador = trddejindicador;
    }

    public List<trdd_ej_nivedu_ind> getTrddejniveduind() {
        return trddejniveduind;
    }

    public void setTrddejniveduind(List<trdd_ej_nivedu_ind> trddejniveduind) {
        this.trddejniveduind = trddejniveduind;
    }

    public List<trdd_ej_pregunta> getTrddEjPregunta() {
        return trddEjPregunta;
    }

    public void setTrddEjPregunta(List<trdd_ej_pregunta> trddEjPregunta) {
        this.trddEjPregunta = trddEjPregunta;
    }

    public List<trdd_ej_estatus_respuesta> getTrddEjEstatusRespuesta() {
        return trddEjEstatusRespuesta;
    }

    public void setTrddEjEstatusRespuesta(List<trdd_ej_estatus_respuesta> trddEjEstatusRespuesta) {
        this.trddEjEstatusRespuesta = trddEjEstatusRespuesta;
    }

    public List<trdd_ej_pregunta_respuesta> getTrddEjPreguntaRespuesta() {
        return trddEjPreguntaRespuesta;
    }

    public void setTrddEjPreguntaRespuesta(List<trdd_ej_pregunta_respuesta> trddEjPreguntaRespuesta) {
        this.trddEjPreguntaRespuesta = trddEjPreguntaRespuesta;
    }

    public List<trdd_c_grado_escolar> getTrddcgradoescolar() {
        return trddcgradoescolar;
    }

    public void setTrddcgradoescolar(List<trdd_c_grado_escolar> trddcgradoescolar) {
        this.trddcgradoescolar = trddcgradoescolar;
    }

    public List<trdd_c_nied_gres> getTrddcniedgres() {
        return trddcniedgres;
    }

    public void setTrddcniedgres(List<trdd_c_nied_gres> trddcniedgres) {
        this.trddcniedgres = trddcniedgres;
    }

    public List<trdd_c_realizador> getTrddcrealizador() {
        return trddcrealizador;
    }

    public void setTrddcrealizador(List<trdd_c_realizador> trddcrealizador) {
        this.trddcrealizador = trddcrealizador;
    }

    public List<trdd_c_anio> getTrddcanio() {
        return trddcanio;
    }

    public void setTrddcanio(List<trdd_c_anio> trddcanio) {
        this.trddcanio = trddcanio;
    }

    public List<trdd_c_pregunta> getTrddCPregunta() {
        return trddCPregunta;
    }

    public void setTrddCPregunta(List<trdd_c_pregunta> trddCPregunta) {
        this.trddCPregunta = trddCPregunta;
    }

    public List<trdd_c_estatus_respuesta> getTrddCEstatusRespuesta() {
        return trddCEstatusRespuesta;
    }

    public void setTrddCEstatusRespuesta(List<trdd_c_estatus_respuesta> trddCEstatusRespuesta) {
        this.trddCEstatusRespuesta = trddCEstatusRespuesta;
    }

    public List<trdd_c_pregunta_respuesta> getTrddCPreguntaRespuesta() {
        return trddCPreguntaRespuesta;
    }

    public void setTrddCPreguntaRespuesta(List<trdd_c_pregunta_respuesta> trddCPreguntaRespuesta) {
        this.trddCPreguntaRespuesta = trddCPreguntaRespuesta;
    }

    public List<trdd_c_realicador_edad> getTrddcrealicadoredad() {
        return trddcrealicadoredad;
    }

    public void setTrddcrealicadoredad(List<trdd_c_realicador_edad> trddcrealicadoredad) {
        this.trddcrealicadoredad = trddcrealicadoredad;
    }

    public List<trdd_c_realicador_genero> getTrddcrealicadorgenero() {
        return trddcrealicadorgenero;
    }

    public void setTrddcrealicadorgenero(List<trdd_c_realicador_genero> trddcrealicadorgenero) {
        this.trddcrealicadorgenero = trddcrealicadorgenero;
    }

    public List<trdd_c_realicador_escolaridad> getTrddcrealicadorescolaridad() {
        return trddcrealicadorescolaridad;
    }

    public void setTrddcrealicadorescolaridad(List<trdd_c_realicador_escolaridad> trddcrealicadorescolaridad) {
        this.trddcrealicadorescolaridad = trddcrealicadorescolaridad;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        //return new ReflectionToStringBuilder(this, new RecursiveToStringStyle()).toString();
        //return "{"+trddcct.toString()+",\"trdd_municipio\":"+trddmunicipio.toString()+",\"trdd_nivel_educativo\":"+trddniveleducativo.toString()+"}";
        //return new ToStringBuilder(this).append(trddcct).append("\"trdd_municipio\"",trddmunicipio).append(trddniveleducativo).append(trddejanio).append(trddejmes).append(trddejaniomes).append(trddejgradoescolar).append(trddejniedgres).append(trddejindicador).append(trddejniveduind).append(trddEjPregunta).append(trddEjEstatusRespuesta).append(trddEjPreguntaRespuesta).append(trddcgradoescolar).append(trddcniedgres).append(trddcrealizador).append(trddcanio).append(trddCPregunta).append(trddCEstatusRespuesta).append(trddCPreguntaRespuesta).append(trddcrealicadoredad).append(trddcrealicadorgenero).append(trddcrealicadorescolaridad).toString();
    }

}
