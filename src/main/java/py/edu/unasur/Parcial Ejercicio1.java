package py.edu.unasur;

public class Parcial Ejercicio 1 {
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api")
public class ParcialUnoResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hola desde LP2";
    }
    
    @GET
    @Path("/prime-numbers/{n}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrimeNumbers(@PathParam("n") int n) {
        List<Integer> primes = new ArrayList<>();
        int count = 0;
        int number = 2;
        while (count < n) {
            if (isPrime(number)) {
                primes.add(number);
                count++;
            }
            number++;
        }
        return Response.ok( primes).build();
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @GET
    @Path("/sum-digits/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sumDigits(@PathParam("number") int number) {
        int sum = 0;
        int num = Math.abs(number);
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return Response.ok( sum).build();
    }
}
}