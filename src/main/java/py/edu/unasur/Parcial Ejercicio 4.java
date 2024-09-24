package py.edu.unasur;

public class Parcial Ejercicio 4 {
    import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Arrays;

@Path("/api/algorithms")
public class AlgorithmsResource {

    @POST
    @Path("/sort")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sortArray(NumbersRequest request) {
        int[] numbers = request.getNumbers();
        
        // Ordenar el arreglo usando Quicksort
        quicksort(numbers, 0, numbers.length - 1);
        
        return Response.ok(numbers).build();  // Retornar el arreglo ordenado en formato JSON
    }

    // Método para realizar QuickSort en el arreglo
    private void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quicksort(array, low, pi - 1);
            quicksort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

// Clase para el cuerpo de la solicitud POST
class NumbersRequest {
    private int[] numbers;

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}
    
}
