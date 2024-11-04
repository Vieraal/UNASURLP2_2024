// Importaciones necesarias
import javax.inject.Inject; // Para la inyección de dependencias
import javax.ws.rs.*; // Para las anotaciones de JAX-RS
import javax.ws.rs.core.MediaType; // Para definir el tipo de contenido
import javax.ws.rs.core.Response; // Para manejar respuestas HTTP
import java.util.List; // Para manejar listas de cadenas

@Path("/segundo-parcial") // Define la ruta del recurso REST
public class SegundoParcialResource {

    @Inject // Indica que Quarkus debe inyectar una instancia de SegundoParcialService aquí
    SegundoParcialService segundoParcialService;

    @POST // Indica que este método maneja solicitudes HTTP POST
    @Consumes(MediaType.APPLICATION_JSON) // Define que acepta JSON en el cuerpo de la solicitud
    @Produces(MediaType.APPLICATION_JSON) // Define que produce JSON en la respuesta
    public Response procesarLista(List<String> lista) {
        // Verifica si la lista es nula o está vacía
        if (lista == null || lista.isEmpty()) {
            // Devuelve un error 400 si la lista no es válida
            return Response.status(Response.Status.BAD_REQUEST).entity("La lista no puede estar vacía").build();
        }
        // Llama al servicio para contar los palíndromos en la lista
        var resultado = segundoParcialService.contarPalindromos(lista);
        // Devuelve la respuesta con los resultados
        return Response.ok(resultado).build();
    }
}
