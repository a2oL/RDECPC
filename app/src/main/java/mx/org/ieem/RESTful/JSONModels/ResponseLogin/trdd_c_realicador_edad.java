package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class trdd_c_realicador_edad {

    @SerializedName("id_edad")
    @Expose
    private Integer idEdad;
    @SerializedName("nombre")
    @Expose
    private String nombre;

    public Integer getIdEdad() {
        return idEdad;
    }

    public void setIdEdad(Integer idEdad) {
        this.idEdad = idEdad;
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
        //return new ToStringBuilder(this).append("idEdad", idEdad).append("nombre", nombre).toString();
    }

}