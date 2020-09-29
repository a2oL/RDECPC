package mx.org.ieem.RESTful.Retrofit.interfaces;

import java.util.List;

import mx.org.ieem.RESTful.JSONModels.PostCiudadanometro.Ciudadanometro;
import mx.org.ieem.RESTful.JSONModels.PostEncuestas.EncuestasJuvenile;
import mx.org.ieem.RESTful.JSONModels.ResponseLogin.ResponseLogin;
import mx.org.ieem.RESTful.JSONModels.UsuarioJM;
import mx.org.ieem.data.sqllite.models.eventos.trdd_concurso_o_evento;
import mx.org.ieem.data.sqllite.models.reportes.trdd_reporte;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @POST("/redDigitalDpc/login")
    Call<ResponseLogin> createUser(@Body UsuarioJM userJM);

    @Headers("Content-Type: application/json")
    @POST("/redDigitalDpc/encuesta-juvenil/encuestas")
    Call<List<EncuestasJuvenile>> insertEncuestas(@Body List<EncuestasJuvenile> sendEncuestas);

    @Headers("Content-Type: application/json")
    @POST("/redDigitalDpc/ciudadanometro/encuestas")
    Call<List<Ciudadanometro>> insertCiudadanometros(@Body List<Ciudadanometro> sendCiudadano);

    @Headers("Content-Type: application/json")
    @POST("/redDigitalDpc/eventos_y_concursos_vigentes")
    Call<List<trdd_concurso_o_evento>> getEventos();

    @Headers("Content-Type: application/json")
    @POST("/redDigitalDpc/reportes/encuesta_juvenil")
    Call<List<trdd_reporte>> getReportesEncuestas();

    @Headers("Content-Type: application/json")
    @POST("/redDigitalDpc/reportes/ciudadanometro")
    Call<List<trdd_reporte>> getReportesCiudadanometro();
}
