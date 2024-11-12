package py.edu.unasur.services; // Asegúrate de que el paquete esté correcto

import jakarta.enterprise.context.ApplicationScoped; // Cambié el import a jakarta
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped // Anotación CDI para marcar la clase como bean de aplicación
public class SegundoParcialService {

    public ResultadoPalindromos contarPalindromos(List<String> lista) {
        // Filtra la lista y recoge solo los palíndromos
        List<String> palindromos = lista.stream()
            .filter(this::esPalindromo) // Llama a esPalindromo para cada elemento
            .collect(Collectors.toList()); // Recoge los resultados en una nueva lista

        // Crea un objeto ResultadoPalindromos con el número total y la lista de palíndromos
        return new ResultadoPalindromos(palindromos.size(), palindromos);
    }

    private boolean esPalindromo(String texto) {
        // Elimina caracteres no alfabéticos y convierte a minúsculas
        String textoLimpio = texto.replaceAll("[^a-zA-Z]", "").toLowerCase();
        // Compara el texto limpio con su reverso
        return new StringBuilder(textoLimpio).reverse().toString().equals(textoLimpio);
    }
}

// Clase para almacenar el resultado del conteo de palíndromos
class ResultadoPalindromos {
    public int totalPalindromos; // Total de palíndromos encontrados
    public List<String> listaPalindromos; // Lista de palíndromos encontrados

    public ResultadoPalindromos(int totalPalindromos, List<String> listaPalindromos) {
        this.totalPalindromos = totalPalindromos; // Asigna el total
        this.listaPalindromos = listaPalindromos; // Asigna la lista
    }
}
