package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class trdd_nivel_educativo {

    @SerializedName("id_nivel_educativo")
    @Expose
    private Integer idNivelEducativo;
    @SerializedName("nombre")
    @Expose
    private String nombre;

    public Integer getIdNivelEducativo() {
        return idNivelEducativo;
    }

    public void setIdNivelEducativo(Integer idNivelEducativo) {
        this.idNivelEducativo = idNivelEducativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        //return "{\"id_nivel_educativo\":\""+idNivelEducativo+"\",\"nombre\":\""+nombre+"\"}";
        //return new ToStringBuilder(this).append("idNivelEducativo", idNivelEducativo).append("nombre", nombre).toString();
    }

}
