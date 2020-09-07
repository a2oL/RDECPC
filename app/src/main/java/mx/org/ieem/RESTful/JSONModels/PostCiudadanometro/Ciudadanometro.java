package mx.org.ieem.RESTful.JSONModels.PostCiudadanometro;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Ciudadanometro {

    @SerializedName("id_cct")
    @Expose
    private String idCct;
    @SerializedName("id_random")
    @Expose
    private String idRandom;
    @SerializedName("id_encuesta")
    @Expose
    private int idEncuesta;
    @SerializedName("id_realizador")
    @Expose
    private int idRealizador;
    @SerializedName("id_realizador_edad")
    @Expose
    private int idRealizadorEdad;
    @SerializedName("id_realizador_escolaridad")
    @Expose
    private int idRealizadorEscolaridad;
    @SerializedName("id_realizador_genero")
    @Expose
    private int idRealizadorGenero;
    @SerializedName("id_realizador_grad_esc")
    @Expose
    private int idRealizadorGradEsc;
    @SerializedName("id_realizador_niv_edu")
    @Expose
    private int idRealizadorNivEdu;
    @SerializedName("detallesEncuesta")
    @Expose
    private List<DetallesEncuestaC> detallesEncuesta = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Ciudadanometro() {
    }

    /**
     *
     * @param detallesEncuesta
     * @param idRealizadorEscolaridad
     * @param idRealizadorGenero
     * @param idRealizadorGradEsc
     * @param idEncuesta
     * @param idRandom
     * @param idRealizador
     * @param idRealizadorEdad
     * @param idRealizadorNivEdu
     * @param idCct
     */
    public Ciudadanometro(String idCct, String idRandom, int idEncuesta, int idRealizador, int idRealizadorEdad, int idRealizadorEscolaridad, int idRealizadorGenero, int idRealizadorGradEsc, int idRealizadorNivEdu, List<DetallesEncuestaC> detallesEncuesta) {
        super();
        this.idCct = idCct;
        this.idRandom = idRandom;
        this.idEncuesta = idEncuesta;
        this.idRealizador = idRealizador;
        this.idRealizadorEdad = idRealizadorEdad;
        this.idRealizadorEscolaridad = idRealizadorEscolaridad;
        this.idRealizadorGenero = idRealizadorGenero;
        this.idRealizadorGradEsc = idRealizadorGradEsc;
        this.idRealizadorNivEdu = idRealizadorNivEdu;
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

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public int getIdRealizador() {
        return idRealizador;
    }

    public void setIdRealizador(int idRealizador) {
        this.idRealizador = idRealizador;
    }

    public int getIdRealizadorEdad() {
        return idRealizadorEdad;
    }

    public void setIdRealizadorEdad(int idRealizadorEdad) {
        this.idRealizadorEdad = idRealizadorEdad;
    }

    public int getIdRealizadorEscolaridad() {
        return idRealizadorEscolaridad;
    }

    public void setIdRealizadorEscolaridad(int idRealizadorEscolaridad) {
        this.idRealizadorEscolaridad = idRealizadorEscolaridad;
    }

    public int getIdRealizadorGenero() {
        return idRealizadorGenero;
    }

    public void setIdRealizadorGenero(int idRealizadorGenero) {
        this.idRealizadorGenero = idRealizadorGenero;
    }

    public int getIdRealizadorGradEsc() {
        return idRealizadorGradEsc;
    }

    public void setIdRealizadorGradEsc(int idRealizadorGradEsc) {
        this.idRealizadorGradEsc = idRealizadorGradEsc;
    }

    public int getIdRealizadorNivEdu() {
        return idRealizadorNivEdu;
    }

    public void setIdRealizadorNivEdu(int idRealizadorNivEdu) {
        this.idRealizadorNivEdu = idRealizadorNivEdu;
    }

    public List<DetallesEncuestaC> getDetallesEncuesta() {
        return detallesEncuesta;
    }

    public void setDetallesEncuesta(List<DetallesEncuestaC> detallesEncuesta) {
        this.detallesEncuesta = detallesEncuesta;
    }

    //@Override
    //public String toString() {
    //    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    //    return gson.toJson(this);
       // return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        //return new ToStringBuilder(this).append("idCct", idCct).append("idRandom", idRandom).append("idEncuesta", idEncuesta).append("idRealizador", idRealizador).append("idRealizadorEdad", idRealizadorEdad).append("idRealizadorEscolaridad", idRealizadorEscolaridad).append("idRealizadorGenero", idRealizadorGenero).append("idRealizadorGradEsc", idRealizadorGradEsc).append("idRealizadorNivEdu", idRealizadorNivEdu).append("detallesEncuesta", detallesEncuesta).toString();
    //}

}
