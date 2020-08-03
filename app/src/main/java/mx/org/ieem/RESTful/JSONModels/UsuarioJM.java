package mx.org.ieem.RESTful.JSONModels;
import java.io.Serializable;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// Se utilizo http://www.jsonschema2pojo.org/
// para generar este objeto

public class UsuarioJM implements Serializable
{


    @SerializedName("contrasenia")
    @Expose
    private String contrasenia;
    @SerializedName("id")
    @Expose
    private String id;
    private final static long serialVersionUID = 8683430536036435598L;

    /**
     * No args constructor for use in serialization
     *
     */
    public UsuarioJM() {
    }

    /**
     * @param id
     * @param contrasenia
     *
     */
    public UsuarioJM(String id, String contrasenia) {
        this.id = id;
        this.contrasenia = contrasenia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "{\"id\":\""+id+"\",\"contrasenia\":\""+contrasenia+"\"}";
    }
}
