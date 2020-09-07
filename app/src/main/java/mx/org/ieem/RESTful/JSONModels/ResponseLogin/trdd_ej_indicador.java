package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class trdd_ej_indicador {

    @SerializedName("id_indicador")
    @Expose
    private Integer idIndicador;
    @SerializedName("nombre")
    @Expose
    private String nombre;

    public Integer getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Integer idIndicador) {
        this.idIndicador = idIndicador;
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
        //return new ToStringBuilder(this).append("idIndicador", idIndicador).append("nombre", nombre).toString();
    }
}
