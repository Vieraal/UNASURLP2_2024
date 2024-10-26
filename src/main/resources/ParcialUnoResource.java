
package py.edu.unasur.resources;

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


/*public class Parcial Ejercicio 1 {
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;*/

@Path("/api/algorithms")
public class AlgorithmsResource {
//ejercicio
    @GET
    @Path("/sum-digits/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sumDigits(@PathParam("number") int number) {
        int sum = 0;
        int num = Math.abs(number);  // Maneja números negativos
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return Response.ok(sum).build();  // Retorna la suma en formato JSON
    }
}


/*public class Parcial Ejercicio 3
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response; */

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



/*public class Parcial Ejercicio 4 {
    import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Arrays;*/

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
    



/*public class Parcial Ejercicio 4 {
    import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Arrays;*/

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
    




/*public class Parcila Ejercicio 5 {
    import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;*/

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

    




/*public class Parcial Ejercicio 6 {
    import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;*/

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

    



/*public class Parcial Ejercicio 7 {
    import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;*/

@Path("/api/algorithms")
public class AlgorithmsResource {

    @GET
    @Path("/perfect-number/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response isPerfectNumber(@PathParam("number") int number) {
        boolean result = isPerfect(number);
        return Response.ok(result).build();  // Retorna true si es perfecto, false si no
    }

    // Método que determina si un número es perfecto
    private boolean isPerfect(int number) {
        if (number <= 1) return false;

        int sumOfDivisors = 0;

        // Calcular la suma de los divisores propios
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sumOfDivisors += i;
            }
        }

        // Un número es perfecto si es igual a la suma de sus divisores propios
        return sumOfDivisors == number;
    }
}

  



/*public class Parcial Ejercicio 8 {
    import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;*/

@Path("/api/algorithms")
public class AlgorithmsResource {

    @GET
    @Path("/factorial/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculateFactorial(@PathParam("number") int number) {
        if (number < 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("El número debe ser no negativo").build();
        }

        long factorial = factorial(number);
        return Response.ok(factorial).build();  // Retorna el factorial en formato JSON
    }

    // Método para calcular el factorial de un número
    private long factorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}




/*public class Parcial Ejercicio 9 {
    import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;*/

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
  



/*public class Parcial Ejercicio 10 {
    import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;*/

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
  



/*public class Parcial Ejercicio 11 {
    import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;*/

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
  



/*public class Parcial Ejercico 12 {
    import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;*/

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
