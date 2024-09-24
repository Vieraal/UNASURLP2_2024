package py.edu.unasur;

public class Parcial Ejercicio 10 {
    import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/algorithms")
public class AlgorithmsResource {

    @POST
    @Path("/gcd")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculateGCD(GcdRequest request) {
        int a = request.getA();
        int b = request.getB();
        
        // Calcular el MCD usando el algoritmo de Euclides
        int gcd = gcd(a, b);
        
        return Response.ok(gcd).build();  // Retorna el MCD en formato JSON
    }

    // Método para calcular el MCD usando el algoritmo de Euclides
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);  // Retorna el MCD como un número positivo
    }
}

// Clase para el cuerpo de la solicitud POST
class GcdRequest {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
  
}
