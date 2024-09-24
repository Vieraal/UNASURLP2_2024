package py.edu.unasur;

public class Parcila Ejercicio 5 {
    import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/algorithms")
public class AlgorithmsResource {

    @GET
    @Path("/palindrome/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response isPalindrome(@PathParam("number") int number) {
        boolean result = isPalindromeNumber(number);
        return Response.ok(result).build();  // Retorna true si es capicúa, false si no
    }

    // Método que determina si un número es capicúa (palíndromo)
    private boolean isPalindromeNumber(int number) {
        int originalNumber = Math.abs(number);  // Para manejar números negativos
        int reversedNumber = 0;
        int temp = originalNumber;

        while (temp > 0) {
            int lastDigit = temp % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            temp /= 10;
        }

        return originalNumber == reversedNumber;
    }
}

    
}
