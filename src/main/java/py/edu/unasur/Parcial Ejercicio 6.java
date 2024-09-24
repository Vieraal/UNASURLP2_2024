package py.edu.unasur;

public class Parcial Ejercicio 6 {
    import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/algorithms")
public class AlgorithmsResource {

    @POST
    @Path("/power")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculatePower(PowerRequest request) {
        int base = request.getBase();
        int exponent = request.getExponent();
        
        // Calcular la potencia
        double result = Math.pow(base, exponent);
        
        return Response.ok(result).build();  // Retorna el resultado en formato JSON
    }
}

// Clase para el cuerpo de la solicitud POST
class PowerRequest {
    private int base;
    private int exponent;

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }
}

    
}
