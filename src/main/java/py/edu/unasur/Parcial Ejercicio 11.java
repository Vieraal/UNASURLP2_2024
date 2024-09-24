package py.edu.unasur;

public class Parcial Ejercicio 11 {
    import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/algorithms")
public class AlgorithmsResource {

    @GET
    @Path("/armstrong/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response isArmstrong(@PathParam("number") int number) {
        boolean result = isArmstrongNumber(number);
        return Response.ok(result).build();  // Retorna true si es un número Armstrong, false si no
    }

    // Método que determina si un número es Armstrong
    private boolean isArmstrongNumber(int number) {
        int originalNumber = number;
        int sum = 0;
        int numberOfDigits = String.valueOf(number).length();

        // Calcular la suma de los dígitos elevados a la potencia del número de dígitos
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numberOfDigits);
            number /= 10;
        }

        // Un número es Armstrong si es igual a la suma calculada
        return originalNumber == sum;
    }
}
  
}
