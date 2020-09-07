package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class trdd_c_realizador {

    @SerializedName("id_realizador")
    @Expose
    private Integer idRealizador;
    @SerializedName("nombre")
    @Expose
    private String nombre;

    public Integer getIdRealizador() {
        return idRealizador;
    }

    public void setIdRealizador(Integer idRealizador) {
        this.idRealizador = idRealizador;
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
        //return new ToStringBuilder(this).append("idRealizador", idRealizador).append("nombre", nombre).toString();
    }

}
