package co.edu.udec.poo.BellaBotello.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

/**
 *
 * @author mezab
 */
public class JsonUtil {
    private static final Gson gson = new Gson();
    
    // Metodo para crear o guardar un JSON
    public static <T> void crearJson(List<T> lista, String archivo) {
        try (FileWriter writer = new FileWriter(archivo)) { 
            gson.toJson(lista, writer);
            System.out.println("Archivo " + archivo + " guardado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar JSON: " + e.getMessage());
        }
    }
    
    // Agregar un nuevo objeto a la lista en el archivo JSON
    public static <T> void guardarNuevoObjeto(T objetoNuevo, String archivo, Class<T> clase) throws FileNotFoundException {
        List<T> listaActual = ReaderJson(archivo, clase);
        listaActual.add(objetoNuevo);
        crearJson(listaActual, archivo);
    }
    
    // Metodo para leer el JSON
    public static <T> List<T> ReaderJson(String archivoJson, Class<T> clase) throws FileNotFoundException {
        File archivo = new File(archivoJson);
        if (!archivo.exists()) {
            // Si el archivo no existe, crea uno vacío
            crearJson(new ArrayList<>(), archivoJson);  // Crear un archivo vacío
            return new ArrayList<>();  // Retornar una lista vacía
        }
        
        try (FileReader reader = new FileReader(archivoJson)) {
            Type tipoLista = TypeToken.getParameterized(List.class, clase).getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
            return new ArrayList<>(); // Retorna una lista vacía si hay un error.
        }
    }
}
