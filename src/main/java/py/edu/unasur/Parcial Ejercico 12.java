package py.edu.unasur;

public class Parcial Ejercico 12 {
    import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/algorithms")
public class AlgorithmsResource {

    @GET
    @Path("/convert-to-binary/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertToBinary(@PathParam("number") int number) {
        String binaryRepresentation = Integer.toBinaryString(number);
        return Response.ok(binaryRepresentation).build();  // Retorna la representación binaria en formato JSON
    }

    @GET
    @Path("/convert-to-binary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertMultipleToBinary(MultipleNumbersRequest request) {
        int[] numbers = request.getNumbers();
        String[] binaryRepresentations = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            binaryRepresentations[i] = Integer.toBinaryString(numbers[i]);
        }

        return Response.ok(binaryRepresentations).build();  // Retorna las representaciones binarias en formato JSON
    }
}

// Clase para el cuerpo de la solicitud para múltiples números
class MultipleNumbersRequest {
    private int[] numbers;

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}

}
