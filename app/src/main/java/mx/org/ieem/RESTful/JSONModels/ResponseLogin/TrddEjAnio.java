
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddEjAnio implements Serializable
{

    @SerializedName("id_anio")
    @Expose
    private String idAnio;
    private final static long serialVersionUID = 2901823669858010979L;

    public String getIdAnio() {
        return idAnio;
    }

    public void setIdAnio(String idAnio) {
        this.idAnio = idAnio;
    }

}
