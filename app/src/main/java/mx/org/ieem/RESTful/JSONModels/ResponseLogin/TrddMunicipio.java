
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddMunicipio implements Serializable
{

    @SerializedName("id_municipio")
    @Expose
    private Integer idMunicipio;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    private final static long serialVersionUID = -1044186113439099777L;

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

}
