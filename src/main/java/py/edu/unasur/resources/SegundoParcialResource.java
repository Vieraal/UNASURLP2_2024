package py.edu.unasur.resources;

import java.util.List;
import jakarta.inject.Inject; // Para la inyección de dependencias
import jakarta.ws.rs.*; // Para las anotaciones de JAX-RS
import jakarta.ws.rs.core.MediaType; // Para definir el tipo de contenido
import jakarta.ws.rs.core.Response; // Para manejar respuestas HTTP
import py.edu.unasur.services.SegundoParcialService; // Asegúrate de que esta clase esté en el paquete correcto

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
