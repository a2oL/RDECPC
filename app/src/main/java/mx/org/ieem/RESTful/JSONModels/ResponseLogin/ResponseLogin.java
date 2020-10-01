
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin implements Serializable
{

    @SerializedName("trdd_cct")
    @Expose
    private TrddCct trddCct;
    @SerializedName("trdd_municipio")
    @Expose
    private List<TrddMunicipio> trddMunicipio = null;
    @SerializedName("trdd_nivel_educativo")
    @Expose
    private List<TrddNivelEducativo> trddNivelEducativo = null;
    @SerializedName("trdd_estatus_concurso_o_evento")
    @Expose
    private List<TrddEstatusConcursoOEvento> trddEstatusConcursoOEvento = null;
    @SerializedName("trdd_estatus_reporte")
    @Expose
    private List<TrddEstatusReporte> trddEstatusReporte = null;
    @SerializedName("trdd_tipo_reporte")
    @Expose
    private List<TrddTipoReporte> trddTipoReporte = null;
    @SerializedName("trdd_ej_anio")
    @Expose
    private List<TrddEjAnio> trddEjAnio = null;
    @SerializedName("trdd_ej_mes")
    @Expose
    private List<TrddEjMe> trddEjMes = null;
    @SerializedName("trdd_ej_anio_mes")
    @Expose
    private List<TrddEjAnioMe> trddEjAnioMes = null;
    @SerializedName("trdd_ej_grado_escolar")
    @Expose
    private List<TrddEjGradoEscolar> trddEjGradoEscolar = null;
    @SerializedName("trdd_ej_nied_gres")
    @Expose
    private List<TrddEjNiedGre> trddEjNiedGres = null;
    @SerializedName("trdd_ej_indicador")
    @Expose
    private List<TrddEjIndicador> trddEjIndicador = null;
    @SerializedName("trdd_ej_nivedu_ind")
    @Expose
    private List<TrddEjNiveduInd> trddEjNiveduInd = null;
    @SerializedName("trdd_ej_pregunta")
    @Expose
    private List<TrddEjPreguntum> trddEjPregunta = null;
    @SerializedName("trdd_ej_estatus_respuesta")
    @Expose
    private List<TrddEjEstatusRespuestum> trddEjEstatusRespuesta = null;
    @SerializedName("trdd_ej_pregunta_respuesta")
    @Expose
    private List<TrddEjPreguntaRespuestum> trddEjPreguntaRespuesta = null;
    @SerializedName("trdd_c_grado_escolar")
    @Expose
    private List<TrddCGradoEscolar> trddCGradoEscolar = null;
    @SerializedName("trdd_c_nied_gres")
    @Expose
    private List<TrddCNiedGre> trddCNiedGres = null;
    @SerializedName("trdd_c_realizador")
    @Expose
    private List<TrddCRealizador> trddCRealizador = null;
    @SerializedName("trdd_c_anio")
    @Expose
    private List<TrddCAnio> trddCAnio = null;
    @SerializedName("trdd_c_pregunta")
    @Expose
    private List<TrddCPreguntum> trddCPregunta = null;
    @SerializedName("trdd_c_estatus_respuesta")
    @Expose
    private List<TrddCEstatusRespuestum> trddCEstatusRespuesta = null;
    @SerializedName("trdd_c_pregunta_respuesta")
    @Expose
    private List<TrddCPreguntaRespuestum> trddCPreguntaRespuesta = null;
    @SerializedName("trdd_c_realicador_edad")
    @Expose
    private List<TrddCRealicadorEdad> trddCRealicadorEdad = null;
    @SerializedName("trdd_c_realicador_genero")
    @Expose
    private List<TrddCRealicadorGenero> trddCRealicadorGenero = null;
    @SerializedName("trdd_c_realicador_escolaridad")
    @Expose
    private List<TrddCRealicadorEscolaridad> trddCRealicadorEscolaridad = null;
    private final static long serialVersionUID = 2433514689862641575L;

    public TrddCct getTrddCct() {
        return trddCct;
    }

    public void setTrddCct(TrddCct trddCct) {
        this.trddCct = trddCct;
    }

    public List<TrddMunicipio> getTrddMunicipio() {
        return trddMunicipio;
    }

    public void setTrddMunicipio(List<TrddMunicipio> trddMunicipio) {
        this.trddMunicipio = trddMunicipio;
    }

    public List<TrddNivelEducativo> getTrddNivelEducativo() {
        return trddNivelEducativo;
    }

    public void setTrddNivelEducativo(List<TrddNivelEducativo> trddNivelEducativo) {
        this.trddNivelEducativo = trddNivelEducativo;
    }

    public List<TrddEstatusConcursoOEvento> getTrddEstatusConcursoOEvento() {
        return trddEstatusConcursoOEvento;
    }

    public void setTrddEstatusConcursoOEvento(List<TrddEstatusConcursoOEvento> trddEstatusConcursoOEvento) {
        this.trddEstatusConcursoOEvento = trddEstatusConcursoOEvento;
    }

    public List<TrddEstatusReporte> getTrddEstatusReporte() {
        return trddEstatusReporte;
    }

    public void setTrddEstatusReporte(List<TrddEstatusReporte> trddEstatusReporte) {
        this.trddEstatusReporte = trddEstatusReporte;
    }

    public List<TrddTipoReporte> getTrddTipoReporte() {
        return trddTipoReporte;
    }

    public void setTrddTipoReporte(List<TrddTipoReporte> trddTipoReporte) {
        this.trddTipoReporte = trddTipoReporte;
    }

    public List<TrddEjAnio> getTrddEjAnio() {
        return trddEjAnio;
    }

    public void setTrddEjAnio(List<TrddEjAnio> trddEjAnio) {
        this.trddEjAnio = trddEjAnio;
    }

    public List<TrddEjMe> getTrddEjMes() {
        return trddEjMes;
    }

    public void setTrddEjMes(List<TrddEjMe> trddEjMes) {
        this.trddEjMes = trddEjMes;
    }

    public List<TrddEjAnioMe> getTrddEjAnioMes() {
        return trddEjAnioMes;
    }

    public void setTrddEjAnioMes(List<TrddEjAnioMe> trddEjAnioMes) {
        this.trddEjAnioMes = trddEjAnioMes;
    }

    public List<TrddEjGradoEscolar> getTrddEjGradoEscolar() {
        return trddEjGradoEscolar;
    }

    public void setTrddEjGradoEscolar(List<TrddEjGradoEscolar> trddEjGradoEscolar) {
        this.trddEjGradoEscolar = trddEjGradoEscolar;
    }

    public List<TrddEjNiedGre> getTrddEjNiedGres() {
        return trddEjNiedGres;
    }

    public void setTrddEjNiedGres(List<TrddEjNiedGre> trddEjNiedGres) {
        this.trddEjNiedGres = trddEjNiedGres;
    }

    public List<TrddEjIndicador> getTrddEjIndicador() {
        return trddEjIndicador;
    }

    public void setTrddEjIndicador(List<TrddEjIndicador> trddEjIndicador) {
        this.trddEjIndicador = trddEjIndicador;
    }

    public List<TrddEjNiveduInd> getTrddEjNiveduInd() {
        return trddEjNiveduInd;
    }

    public void setTrddEjNiveduInd(List<TrddEjNiveduInd> trddEjNiveduInd) {
        this.trddEjNiveduInd = trddEjNiveduInd;
    }

    public List<TrddEjPreguntum> getTrddEjPregunta() {
        return trddEjPregunta;
    }

    public void setTrddEjPregunta(List<TrddEjPreguntum> trddEjPregunta) {
        this.trddEjPregunta = trddEjPregunta;
    }

    public List<TrddEjEstatusRespuestum> getTrddEjEstatusRespuesta() {
        return trddEjEstatusRespuesta;
    }

    public void setTrddEjEstatusRespuesta(List<TrddEjEstatusRespuestum> trddEjEstatusRespuesta) {
        this.trddEjEstatusRespuesta = trddEjEstatusRespuesta;
    }

    public List<TrddEjPreguntaRespuestum> getTrddEjPreguntaRespuesta() {
        return trddEjPreguntaRespuesta;
    }

    public void setTrddEjPreguntaRespuesta(List<TrddEjPreguntaRespuestum> trddEjPreguntaRespuesta) {
        this.trddEjPreguntaRespuesta = trddEjPreguntaRespuesta;
    }

    public List<TrddCGradoEscolar> getTrddCGradoEscolar() {
        return trddCGradoEscolar;
    }

    public void setTrddCGradoEscolar(List<TrddCGradoEscolar> trddCGradoEscolar) {
        this.trddCGradoEscolar = trddCGradoEscolar;
    }

    public List<TrddCNiedGre> getTrddCNiedGres() {
        return trddCNiedGres;
    }

    public void setTrddCNiedGres(List<TrddCNiedGre> trddCNiedGres) {
        this.trddCNiedGres = trddCNiedGres;
    }

    public List<TrddCRealizador> getTrddCRealizador() {
        return trddCRealizador;
    }

    public void setTrddCRealizador(List<TrddCRealizador> trddCRealizador) {
        this.trddCRealizador = trddCRealizador;
    }

    public List<TrddCAnio> getTrddCAnio() {
        return trddCAnio;
    }

    public void setTrddCAnio(List<TrddCAnio> trddCAnio) {
        this.trddCAnio = trddCAnio;
    }

    public List<TrddCPreguntum> getTrddCPregunta() {
        return trddCPregunta;
    }

    public void setTrddCPregunta(List<TrddCPreguntum> trddCPregunta) {
        this.trddCPregunta = trddCPregunta;
    }

    public List<TrddCEstatusRespuestum> getTrddCEstatusRespuesta() {
        return trddCEstatusRespuesta;
    }

    public void setTrddCEstatusRespuesta(List<TrddCEstatusRespuestum> trddCEstatusRespuesta) {
        this.trddCEstatusRespuesta = trddCEstatusRespuesta;
    }

    public List<TrddCPreguntaRespuestum> getTrddCPreguntaRespuesta() {
        return trddCPreguntaRespuesta;
    }

    public void setTrddCPreguntaRespuesta(List<TrddCPreguntaRespuestum> trddCPreguntaRespuesta) {
        this.trddCPreguntaRespuesta = trddCPreguntaRespuesta;
    }

    public List<TrddCRealicadorEdad> getTrddCRealicadorEdad() {
        return trddCRealicadorEdad;
    }

    public void setTrddCRealicadorEdad(List<TrddCRealicadorEdad> trddCRealicadorEdad) {
        this.trddCRealicadorEdad = trddCRealicadorEdad;
    }

    public List<TrddCRealicadorGenero> getTrddCRealicadorGenero() {
        return trddCRealicadorGenero;
    }

    public void setTrddCRealicadorGenero(List<TrddCRealicadorGenero> trddCRealicadorGenero) {
        this.trddCRealicadorGenero = trddCRealicadorGenero;
    }

    public List<TrddCRealicadorEscolaridad> getTrddCRealicadorEscolaridad() {
        return trddCRealicadorEscolaridad;
    }

    public void setTrddCRealicadorEscolaridad(List<TrddCRealicadorEscolaridad> trddCRealicadorEscolaridad) {
        this.trddCRealicadorEscolaridad = trddCRealicadorEscolaridad;
    }

}
