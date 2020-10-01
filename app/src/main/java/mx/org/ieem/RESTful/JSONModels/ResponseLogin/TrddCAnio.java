
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddCAnio implements Serializable
{

    @SerializedName("id_anio")
    @Expose
    private String idAnio;
    private final static long serialVersionUID = -6759226487788801993L;

    public String getIdAnio() {
        return idAnio;
    }

    public void setIdAnio(String idAnio) {
        this.idAnio = idAnio;
    }

}
