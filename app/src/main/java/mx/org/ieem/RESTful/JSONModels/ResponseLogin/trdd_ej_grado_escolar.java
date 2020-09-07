package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class trdd_ej_grado_escolar {

    @SerializedName("id_grado_escolar")
    @Expose
    private Integer idGradoEscolar;
    @SerializedName("grado")
    @Expose
    private String grado;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("siglas")
    @Expose
    private String siglas;

    public Integer getIdGradoEscolar() {
        return idGradoEscolar;
    }

    public void setIdGradoEscolar(Integer idGradoEscolar) {
        this.idGradoEscolar = idGradoEscolar;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        //return new ToStringBuilder(this).append("idGradoEscolar", idGradoEscolar).append("grado", grado).append("nombre", nombre).append("siglas", siglas).toString();
    }

}