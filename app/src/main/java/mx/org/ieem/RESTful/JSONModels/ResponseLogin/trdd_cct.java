package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class trdd_cct {

    @SerializedName("id_cct")
    @Expose
    private String idCct;
    @SerializedName("domicilio")
    @Expose
    private String domicilio;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("id_municipio")
    @Expose
    private String idMunicipio;
    @SerializedName("id_nivel_educativo")
    @Expose
    private String idNivelEducativo;

    public String getIdCct() {
        return idCct;
    }

    public void setIdCct(String idCct) {
        this.idCct = idCct;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getIdNivelEducativo() {
        return idNivelEducativo;
    }

    public void setIdNivelEducativo(String idNivelEducativo) {
        this.idNivelEducativo = idNivelEducativo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        //return "\"trdd_cct\":{\"id_cct\":\""+idCct+"\",\"domicilio\":\""+domicilio+"\",\"email\":\""+email+"\",\"nombre\":\""+nombre+"\",\"id_municipio\":\""+idMunicipio+"\",\"id_nivel_educativo\":\""+idNivelEducativo+"\"}";
        //return new ToStringBuilder(this).append("idCct", idCct).append("domicilio", domicilio).append("email", email).append("nombre", nombre).append("idMunicipio", idMunicipio).append("idNivelEducativo", idNivelEducativo).toString();
    }

}
