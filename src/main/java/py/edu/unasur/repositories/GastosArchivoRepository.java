package py.edu.unasur.repositories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import py.edu.unasur.models.GastosArchivo;

@ApplicationScoped
public class GastosArchivoRepository {

    private static final String FILE_PATH = "src/main/resources/data.json"; // Asegúrate de que este path sea correcto
    private ObjectMapper mapper;
    private List<GastosArchivo> lista;

    public GastosArchivoRepository() {
        mapper = new ObjectMapper();
        this.lista = cargarDato(); // Carga los datos al iniciar el repositorio
    }

    // Carga los datos desde el archivo JSON, si existe
    public List<GastosArchivo> cargarDato() {
        File dataFile = new File(FILE_PATH);
        if (dataFile.exists()) {
            try {
                return mapper.readValue(dataFile, new TypeReference<List<GastosArchivo>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>(); // Si no existe el archivo, retorna una lista vacía
    }

    // Guarda un nuevo dato en la lista y persiste el archivo
    public void guardarDato(GastosArchivo param) {
        GastosArchivo existingGasto = findById(param.getId());
        if (existingGasto == null) {  // Si no existe un gasto con el mismo ID
            lista.add(param); // Agrega el nuevo gasto a la lista
            persistirDatos(); // Guarda la lista actualizada en el archivo
        }
    }

    // Encuentra un gasto por ID
    public GastosArchivo findById(Integer id) {
        return lista.stream()
            .filter(gasto -> gasto.getId().equals(id))
            .findFirst()
            .orElse(null); // Devuelve null si no se encuentra el gasto
    }

    // Devuelve todos los gastos
    public List<GastosArchivo> findAll() {
        return new ArrayList<>(lista); // Retorna una copia de la lista
    }

    // Elimina un gasto por ID
    public void delete(Integer id) {
        lista = lista.stream()
            .filter(gasto -> !gasto.getId().equals(id)) // Filtra los gastos que no tienen el ID a eliminar
            .collect(Collectors.toList());
        persistirDatos(); // Guarda la lista actualizada en el archivo
    }

    // Método privado para persistir la lista de gastos en el archivo
    private void persistirDatos() {
        try {
            File dataFile = new File(FILE_PATH);
            // Asegúrate de que el directorio existe
            if (!dataFile.getParentFile().exists()) {
                dataFile.getParentFile().mkdirs();
            }
            mapper.writeValue(dataFile, lista); // Escribe la lista de gastos en el archivo
        } catch (IOException e) {
            e.printStackTrace(); // Maneja la excepción adecuadamente
        }
    }
}
