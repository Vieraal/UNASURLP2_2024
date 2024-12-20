package py.edu.unasur.resources;

import java.util.HashMap;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import py.edu.unasur.models.params.PostConBodyParam;
import py.edu.unasur.models.resutls.Respuesta;
import py.edu.unasur.models.resutls.TestResult;

@Path("/api/recursos-basicos")
public class RecursosBasicos {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Primer recurso basico";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String primerPost() {
        return "Primer post";
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String primerDelete() {
        return "Primer delete";
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String primerPut() {
        return "Primer put";
    }

    @GET
    @Path("/segundo-recurso")
    @Produces(MediaType.TEXT_PLAIN)
    public String segundoMetodoGet() {
        return "Primer get con pathextra";
    }

    @GET
    @Path("/tercer-recurso/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String tercerMetodoGet(@PathParam("id") Integer id) {
        return "Primer get con pathparam " + id;
    }

    @POST
    @Path("/con-body-hash")
    @Produces(MediaType.TEXT_PLAIN)
    public String segundoPostConBody(HashMap<String, Object> param) {
        System.out.println(param.get("test"));
        return "Primer post con body ";
    }

    @POST
    @Path("/con-body-param")
    @Produces(MediaType.TEXT_PLAIN)
    public String tercerPostConBody(PostConBodyParam param) {
        return "Primer post con body ";
    }

    @POST
    @Path("/con-body-param/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String cuartoPostConBody(PostConBodyParam param, @PathParam("id") Integer id) {
        return "Prime post con0 body ";
    }

    @GET
    @Path("/clase-especifica")
    @Produces(MediaType.APPLICATION_JSON)
    public TestResult getQueRetornaUnaClase() {
        TestResult respuesta = new TestResult();
        respuesta.setCode(200);
        respuesta.setMessage("EXITO");
        return respuesta;
    }

    // Cambié aquí la declaración de Respuesta para usar Respuesta<TestResult> correctamente
    @GET
    @Path("/clase-generica-single")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta<TestResult> getQueRetornaUnaClaseGenerica() {
        // Especificamos el tipo correctamente al instanciar Respuesta
        Respuesta<TestResult> respuesta = new Respuesta<TestResult>();
        respuesta.setCodigo(300);
        respuesta.setMensaje("EXITO");

        TestResult test = new TestResult();
        test.setCode(200);
        test.setMessage("MESSAGE FROM TEST RESULT");

        respuesta.setDato(test);
        return respuesta;
    }

    @GET
    @Path("/clase-generica-complex")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta<TestResult> getQueRetornaUnaClaseGenericaComplex() {
        // Especificamos el tipo correctamente al instanciar Respuesta
        Respuesta<TestResult> respuesta = new Respuesta<TestResult>();
        respuesta.setCodigo(300);
        respuesta.setMensaje("EXITO");

        TestResult test = new TestResult();
        test.setCode(200);
        test.setMessage("MESSAGE FROM TEST RESULT");

        respuesta.setDato(test);
        return respuesta;
    }
}
