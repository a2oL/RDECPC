package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class trdd_municipio {

    @SerializedName("id_municipio")
    @Expose
    private Integer idMunicipio;
    @SerializedName("nombre")
    @Expose
    private String nombre;

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        //return "{\"id_municipio\":\""+idMunicipio+"\",\"nombre\":\""+nombre+"\"}";
        //return new ToStringBuilder(this).append("idMunicipio", idMunicipio).append("nombre", nombre).toString();
    }
}
