package py.edu.unasur.resource;

public class Ejercicio 1 {
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/algorithms")
public class AlgorithmsResource {

    @GET
    @Path("/sum-digits/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sumDigits(@PathParam("number") int number) {
        int sum = 0;
        int num = Math.abs(number);  // Maneja números negativos
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return Response.ok(sum).build();  // Retorna la suma en formato JSON
    }
}
