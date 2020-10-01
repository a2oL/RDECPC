
package mx.org.ieem.RESTful.JSONModels.ResponseLogin;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrddCGradoEscolar implements Serializable
{

    @SerializedName("id_grado_escolar")
    @Expose
    private Integer idGradoEscolar;
    @SerializedName("grado")
    @Expose
    private String grado;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("siglas")
    @Expose
    private String siglas;
    private final static long serialVersionUID = 3864463270163754931L;

    public Integer getIdGradoEscolar() {
        return idGradoEscolar;
    }

    public void setIdGradoEscolar(Integer idGradoEscolar) {
        this.idGradoEscolar = idGradoEscolar;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

}
