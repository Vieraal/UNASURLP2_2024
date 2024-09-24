package py.edu.unasur;

public class Parcial Ejercicio 9 {
    import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/algorithms")
public class AlgorithmsResource {

    @POST
    @Path("/sum-array")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculateSum(SumRequest request) {
        int[] numbers = request.getNumbers();
        
        // Calcular la sumatoria
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        
        return Response.ok(sum).build();  // Retorna la sumatoria en formato JSON
    }
}

// Clase para el cuerpo de la solicitud POST
class SumRequest {
    private int[] numbers;

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}
  
}
