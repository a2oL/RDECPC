package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class trdd_ej_estatus_respuesta {

    @SerializedName("id_estatus_respuesta")
    @Expose
    private Integer idEstatusRespuesta;
    @SerializedName("nombre")
    @Expose
    private String nombre;

    public Integer getIdEstatusRespuesta() {
        return idEstatusRespuesta;
    }

    public void setIdEstatusRespuesta(Integer idEstatusRespuesta) {
        this.idEstatusRespuesta = idEstatusRespuesta;
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
        //return new ToStringBuilder(this).append("idEstatusRespuesta", idEstatusRespuesta).append("nombre", nombre).toString();
    }
}
