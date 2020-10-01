
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddEjIndicador implements Serializable
{

    @SerializedName("id_indicador")
    @Expose
    private Integer idIndicador;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    private final static long serialVersionUID = -1264888731187015083L;

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

}
