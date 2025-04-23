/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.BellaBotello.modelo.entidades;
import co.edu.udec.poo.BellaBotello.util.JsonUtil;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mezab
 */
public class Alquiler {
    public String IdAlquiler;
    public String fechaDeAdquisicion;
    public double precioPorHora;
    public Cliente cliente;
    public String Producto;

     //constructor 

    public Alquiler(String IdAlquiler, String fechaDeAdquisicion, double precioPorHora, Cliente cliente, String Producto) {
        this.IdAlquiler = IdAlquiler;
        this.fechaDeAdquisicion = fechaDeAdquisicion;
        this.precioPorHora = precioPorHora;
        this.cliente = cliente;
        this.Producto = Producto;
    }
    public String getIdAlquiler() { return IdAlquiler; }
public void setIdAlquiler(String IdAlquiler) { this.IdAlquiler = IdAlquiler; }

public String getFechaDeAdquisicion() { return fechaDeAdquisicion; }
public void setFechaDeAdquisicion(String fechaDeAdquisicion) { this.fechaDeAdquisicion = fechaDeAdquisicion; }

public double getPrecioPorHora() { return precioPorHora; }
public void setPrecioPorHora(double precioPorHora) { this.precioPorHora = precioPorHora; }

public Cliente getCliente() { return cliente; }
public void setCliente(Cliente cliente) { this.cliente = cliente; }

public String getProducto() { return Producto; }
public void setProducto(String Producto) { this.Producto = Producto; 
    }
//metodos

 public static void agregarAlquiler(String IdAlquiler, String fechaDeAdquisicion, double precioPorHora, Cliente cliente, String Producto) {
        List<Alquiler> alquileres;
        try {
            alquileres = JsonUtil.ReaderJson("alquiler.json", Alquiler.class);
        } catch (FileNotFoundException e) {
            alquileres = new ArrayList<>();
        }

        Alquiler nuevoAlquiler = new Alquiler( IdAlquiler,  fechaDeAdquisicion,  precioPorHora,  cliente,  Producto);
        alquileres.add(nuevoAlquiler);
        JsonUtil.crearJson(alquileres, "proveedor.json");
    }
 public static void mostrarTodosEmpresas() throws FileNotFoundException {
        List<Alquiler> todosLosAlquileres = JsonUtil.ReaderJson ("alquiler.json", Alquiler.class);
        
         if (todosLosAlquileres != null && !todosLosAlquileres.isEmpty()) {
            for ( Alquiler q : todosLosAlquileres) {
                System.out.println("ID del alquiler: " + q.getIdAlquiler() + "\n" +
                                   "Nombre del alquiler : " + q.getFechaDeAdquisicion() + "\n" +
                                   "Precio del Precio por hora: " + q.getPrecioPorHora() + "\n" + 
                                   "Producto alquilado: " + q.getProducto() + "\n" + 

                                   "*-------------------------------------*\n");
            }
        } else {
            System.out.println("No hay informacion del servicio.");
        }
    }
        public static void filtrarCliente(String filtrarPor, String valorBuscar) throws FileNotFoundException {
        List<Alquiler> alquileres = JsonUtil.ReaderJson ("alquiler.json", Alquiler.class);
        
        
         if (alquileres != null) {
            boolean encontrado = false;

            for (Alquiler q : alquileres) {
                switch (filtrarPor.toLowerCase()) {
                    case "IdAlquiler":
                        if (valorBuscar.equals(q.getIdAlquiler())) {
                            mostrarAlquiler (q);
                            encontrado = true;
                        }
                        break;
                    case "FechaDeAdquisicion":
                        if (valorBuscar.equals(q.getFechaDeAdquisicion())) {
                            mostrarAlquiler(q);
                            encontrado = true;
                        }
                        break;
                    case "PrecioPorHora":
                        if (valorBuscar.equals(q.getPrecioPorHora())) {
                            mostrarAlquiler(q);
                            encontrado = true;
                        }
                        break;
                    
                        case "Producto":
                        if (valorBuscar.equals(q.getProducto())) {
                            mostrarAlquiler(q);
                            encontrado = true;
                        }
                        break;
                    
                    default:
                        System.out.println("No hay registros de la informacion: " + filtrarPor);
                        return;
                }
            }

            if (!encontrado) {
                System.out.println("No se encontró un Alquiler con el valor especificado.");
            }
        }
    }

    // Método para mostrar la información de un cliente
    public static void mostrarAlquiler(Alquiler q) {
        System.out.println("ID del alquiler: " + q.getIdAlquiler() + "\n" +
                           "fecha del alquiler: " + q.getFechaDeAdquisicion() + "\n" +
                           "precio por hora del alquiler: " + q.getPrecioPorHora() + "\n" +
                           "producto alquilado: " + q.getProducto() + "\n" 

        );
    }
         
         

}
  



    

