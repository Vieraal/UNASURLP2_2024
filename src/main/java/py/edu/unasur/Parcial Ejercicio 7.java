package py.edu.unasur;

public class Parcial Ejercicio 7 {
    import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/algorithms")
public class AlgorithmsResource {

    @GET
    @Path("/perfect-number/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response isPerfectNumber(@PathParam("number") int number) {
        boolean result = isPerfect(number);
        return Response.ok(result).build();  // Retorna true si es perfecto, false si no
    }

    // Método que determina si un número es perfecto
    private boolean isPerfect(int number) {
        if (number <= 1) return false;

        int sumOfDivisors = 0;

        // Calcular la suma de los divisores propios
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sumOfDivisors += i;
            }
        }

        // Un número es perfecto si es igual a la suma de sus divisores propios
        return sumOfDivisors == number;
    }
}

  
}
