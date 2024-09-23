package py.edu.unasur;

import GET;
import Path;
import PathParam;
import Produces;
import MediaType;
import Response;
import java.util.ArrayList;
import java.util.List;

@Path("/api/algorithms/prime-numbers")
public class PrimeNumberResource {

    @GET
    @Path("/{n}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrimeNumbers(@PathParam("n") int n) {
        if (n <= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The value of n must be a positive integer.")
                    .build();
        }

        List<Integer> primes = generatePrimes(n);
        return Response.ok(primes).build();
    }

    // Método para generar los primeros n números primos
    private List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        int count = 0;
        int number = 2; // El primer número primo

        while (count < n) {
            if (isPrime(number)) {
                primes.add(number);
                count++;
            }
            number++;
        }
        return primes;
    }

    // Método para verificar si un número es primo
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
