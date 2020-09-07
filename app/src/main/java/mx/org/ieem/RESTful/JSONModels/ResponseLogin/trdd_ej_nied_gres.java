package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class trdd_ej_nied_gres {

    @SerializedName("id_nivel_educativo")
    @Expose
    private Integer idNivelEducativo;
    @SerializedName("id_grado_escolar")
    @Expose
    private Integer idGradoEscolar;

    public Integer getIdNivelEducativo() {
        return idNivelEducativo;
    }

    public void setIdNivelEducativo(Integer idNivelEducativo) {
        this.idNivelEducativo = idNivelEducativo;
    }

    public Integer getIdGradoEscolar() {
        return idGradoEscolar;
    }

    public void setIdGradoEscolar(Integer idGradoEscolar) {
        this.idGradoEscolar = idGradoEscolar;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        //return new ToStringBuilder(this).append("idNivelEducativo", idNivelEducativo).append("idGradoEscolar", idGradoEscolar).toString();
    }

}
