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
public class HistorialDeCompras {
    public Cliente cliente;
    public String IdHistorial;
    public Producto producto;
    public String fechaDeAdquisicion;
    public double precio;

     //constructor 

    public HistorialDeCompras(Cliente cliente, String IdHistorial, Producto producto, String fechaDeAdquisicion, double precio) {
        this.cliente = cliente;
        this.IdHistorial = IdHistorial;
        this.producto = producto;
        this.fechaDeAdquisicion = fechaDeAdquisicion;
        this.precio = precio;
    }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public String getIdHistorial() { return IdHistorial; }
    public void setIdHistorial(String IdHistorial) { this.IdHistorial = IdHistorial; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public String getFechaDeAdquisicion() { return fechaDeAdquisicion; }
    public void setFechaDeAdquisicion(String fechaDeAdquisicion) { this.fechaDeAdquisicion = fechaDeAdquisicion; }

    public double getPrecio() { return precio; } 
    public void setPrecio(double precio) { this.precio = precio; }
    
    //metodo
     public static void agregarHistorial(Cliente cliente, String IdHistorial, Producto producto, String fechaDeAdquisicion, double precio) {
        List<HistorialDeCompras> historial;
        try {
            historial = JsonUtil.ReaderJson("historial.json", HistorialDeCompras.class);
        } catch (FileNotFoundException e) {
            historial = new ArrayList<>();
        }

        HistorialDeCompras nuevoHistorial = new HistorialDeCompras( cliente,  IdHistorial,  producto,  fechaDeAdquisicion,  precio);
        historial.add(nuevoHistorial );
        JsonUtil.crearJson(historial, "proveedor.json");
    }

    public static void mostrarTodosClientes() throws FileNotFoundException {
        List<HistorialDeCompras> todoElHistorial = JsonUtil.ReaderJson ("historial.json", HistorialDeCompras.class);
         
        if (todoElHistorial != null && !todoElHistorial.isEmpty()) {
            for (HistorialDeCompras h : todoElHistorial) {
                System.out.println("ID del historial: " + h.getIdHistorial() + "\n" +
                                   "Fecha: " + h.getFechaDeAdquisicion() + "\n" +
                                   "Precio: " + h.getPrecio() + "\n" +
                                   "*-------------------------------------*\n");
            }
        } else {
            System.out.println("No se encuentra en el historial.");
        }
    }
    public static void filtrarCliente(String filtrarPor, String valorBuscar) throws FileNotFoundException {
        List<HistorialDeCompras> historialDeCompras = JsonUtil.ReaderJson ("historial.json", HistorialDeCompras.class);
        
        if (historialDeCompras != null) {
            boolean encontrado = false;

            for (HistorialDeCompras h : historialDeCompras) {
                switch (filtrarPor.toLowerCase()) {
                    case "IdHistorial":
                        if (valorBuscar.equals(h.getIdHistorial())) {
                            mostrarHistorial (h);
                            encontrado = true;
                        }
                        break;
                    case "FechaDeAdquisicion":
                        if (valorBuscar.equals(h.getFechaDeAdquisicion())) {
                            mostrarHistorial(h);
                            encontrado = true;
                        }
                        break;
                    case "Precio":
                        if (valorBuscar.equals(h.getPrecio())) {
                            mostrarHistorial(h);
                            encontrado = true;
                        }
                        break;
                 
                    
                    default:
                        System.out.println("Campo no reconocido: " + filtrarPor);
                        return;
                }
            }

            if (!encontrado) {
                System.out.println("No se encontró un provedor con el valor especificado.");
            }
        }
    }

    // Método para mostrar la información de un cliente
    public static void mostrarHistorial(HistorialDeCompras h) {
        System.out.println("ID: " + h.getIdHistorial() + "\n" +
                           "NIF: " + h.getFechaDeAdquisicion() + "\n" +
                           "Direccion: " + h.getPrecio() + "\n"  );
    }
         
         

    
    
}

