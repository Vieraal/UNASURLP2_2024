package py.edu.unasur.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
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

    // Generar números primos
    @GET
    @Path("/algorithms/prime-numbers/{n}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrimeNumbers(@PathParam("n") int n) {
        if (n < 1) {
            return Response.status(Response.Status.BAD_REQUEST).entity("n debe ser mayor que 0").build();
        }

        List<Integer> primes = new ArrayList<>();
        int number = 2;
        while (primes.size() < n) {
            if (isPrime(number)) {
                primes.add(number);
            }
            number++;
        }
        return Response.ok(primes).build();
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Suma de Dígitos
    @GET
    @Path("/algorithms/sum-digits/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sumDigits(@PathParam("number") int number) {
        return Response.ok(calculateDigitSum(Math.abs(number))).build();
    }

    private int calculateDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // Secuencia de Fibonacci
    @GET
    @Path("/algorithms/fibonacci/{n}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFibonacci(@PathParam("n") int n) {
        if (n < 0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("n debe ser no negativo").build();
        }
        
        List<Integer> fibonacci = new ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            fibonacci.add(a);
            int next = a + b;
            a = b;
            b = next;
        }
        return Response.ok(fibonacci).build();
    }

    // Ordenar Arreglo
    @POST
    @Path("/algorithms/sort")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sortArray(Map<String, List<Integer>> body) {
        List<Integer> numbers = body.get("numbers");
        
        if (numbers == null || numbers.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("La lista no puede estar vacía").build();
        }
        
        Collections.sort(numbers);
        return Response.ok(numbers).build();
    }

    // Número Capicúa
    @GET
    @Path("/algorithms/palindrome/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response isPalindrome(@PathParam("number") int number) {
        String strNum = String.valueOf(Math.abs(number));
        String reversed = new StringBuilder(strNum).reverse().toString();
        boolean result = strNum.equals(reversed);
        return Response.ok(result).build();
    }

    // Potencia de un Número
    @POST
    @Path("/algorithms/power")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response power(Map<String, Integer> body) {
        Integer base = body.get("base");
        Integer exponent = body.get("exponent");

        if (base == null || exponent == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Faltan parámetros").build();
        }

        int result = (int) Math.pow(base, exponent);
        return Response.ok(result).build();
    }

    // Número Perfecto
    @GET
    @Path("/algorithms/perfect-number/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response isPerfectNumber(@PathParam("number") int number) {
        int sum = calculateDivisorSum(number);
        boolean result = (sum == number);
        return Response.ok(result).build();
    }

    private int calculateDivisorSum(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // Calcular Factorial
    @GET
    @Path("/algorithms/factorial/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response factorial(@PathParam("number") int number) {
        if (number < 0) return Response.status(Response.Status.BAD_REQUEST).entity("Número no puede ser negativo").build();
        long result = calculateFactorial(number);
        return Response.ok(result).build();
    }

    private long calculateFactorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    // Sumatoria de Arreglo
    @POST
    @Path("/algorithms/sum-array")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sumArray(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("La lista no puede estar vacía").build();
        }
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        return Response.ok(sum).build();
    }

    // Máximo Común Divisor (MCD)
    @POST
    @Path("/algorithms/gcd")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response gcd(Map<String, Integer> body) {
        Integer a = body.get("a");
        Integer b = body.get("b");

        if (a == null || b == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Faltan parámetros").build();
        }

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Response.ok(a).build();
    }

    // Número Armstrong
    @GET
    @Path("/algorithms/armstrong/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response isArmstrong(@PathParam("number") int number) {
        int original = number;
        int sum = calculateArmstrongSum(number);
        boolean result = (sum == original);
        return Response.ok(result).build();
    }

    private int calculateArmstrongSum(int number) {
        int sum = 0;
        int digits = String.valueOf(number).length();
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }
        return sum;
    }

    // Convertir Número a Binario
    @GET
    @Path("/algorithms/convert-to-binary/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertToBinary(@PathParam("number") int number) {
        String binary = Integer.toBinaryString(number);
        return Response.ok(binary).build();
    }
}