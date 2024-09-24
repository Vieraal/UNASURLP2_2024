package py.edu.unasur;

public class Parcial Ejercicio 3 {
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/algorithms")
public class AlgorithmsResource {

    @GET
    @Path("/fibonacci/{n}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFibonacciSequence(@PathParam("n") int n) {
        List<Integer> fibonacciSequence = new ArrayList<>();
        
        // Generar la secuencia de Fibonacci
        for (int i = 0; i < n; i++) {
            fibonacciSequence.add(fibonacci(i));
        }

        return Response.ok(fibonacciSequence).build();  // Retorna la secuencia en formato JSON
    }

    // Método para calcular el número de Fibonacci en la posición i
    private int fibonacci(int i) {
        if (i <= 1) return i;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }
}
}