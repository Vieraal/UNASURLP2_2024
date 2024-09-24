package py.edu.unasur;

public class Parcial Ejercicio 8 {
    import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/algorithms")
public class AlgorithmsResource {

    @GET
    @Path("/factorial/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculateFactorial(@PathParam("number") int number) {
        if (number < 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("El número debe ser no negativo").build();
        }

        long factorial = factorial(number);
        return Response.ok(factorial).build();  // Retorna el factorial en formato JSON
    }

    // Método para calcular el factorial de un número
    private long factorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}

}
