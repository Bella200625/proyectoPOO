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
public class ServicioTecnico {
    public String IdServicio;
    public String NombreEmpresaYcodigo;
    public String NombreProductoYcodigo;
    public double PrecioServicioTecnico;
    public String FechaCompra;
    public String ServicioTecnicoRealizado;
    public String DetalleDelServicio;

    //constructor
    
    public ServicioTecnico(String IdServicio, String NombreEmpresaYcodigo, String NombreProductoYcodigo, double PrecioServicioTecnico, String FechaCompra, String ServicioTecnicoRealizado, String DetalleDelServicio) {
        this.IdServicio = IdServicio;
        this.NombreEmpresaYcodigo = NombreEmpresaYcodigo;
        this.NombreProductoYcodigo = NombreProductoYcodigo;
        this.PrecioServicioTecnico = PrecioServicioTecnico;
        this.FechaCompra = FechaCompra;
        this.ServicioTecnicoRealizado = ServicioTecnicoRealizado;
        this.DetalleDelServicio = DetalleDelServicio;
    }
    
    public String getIdServicio() { return IdServicio; }
        public void setIdServicio(String IdServicio) { this.IdServicio = IdServicio; }

public String getNombreEmpresaYCodigo() { return NombreEmpresaYcodigo; }
public void setNombreEmpresaYCodigo(String NombreEmpresaYCodigo) { this.NombreEmpresaYcodigo = NombreEmpresaYCodigo; }

public String getNombreProductoYCodigo() { return NombreProductoYcodigo; }
public void setNombreProductoYCodigo(String NombreProductoYCodigo) { this.NombreProductoYcodigo = NombreProductoYCodigo; }

public double getPrecioServicio() { return PrecioServicioTecnico; }
public void setPrecioServicio(double PrecioServicio) { this.PrecioServicioTecnico = PrecioServicio; }

public String getFechaCompra() { return FechaCompra; }
public void setFechaCompra(String FechaCompra) { this.FechaCompra = FechaCompra; }

public String getServicioRealizado() { return ServicioTecnicoRealizado; }
public void setServicioRealizado(String ServicioRealizado) { this.ServicioTecnicoRealizado = ServicioRealizado; }

public String getDetalleServicio() { return DetalleDelServicio; }
public void setDetalleServicio(String DetalleServicio) { this.DetalleDelServicio = DetalleServicio; 

}
    
 public static void agregarServicio(String IdServicio, String NombreEmpresaYcodigo, String NombreProductoYcodigo, double PrecioServicioTecnico, String FechaCompra, String ServicioTecnicoRealizado, String DetalleDelServicio) {
        List<ServicioTecnico> Servicio;
        try {
            Servicio = JsonUtil.ReaderJson("proveedor.json", ServicioTecnico.class);
        } catch (FileNotFoundException e) {
            Servicio = new ArrayList<>();
        }
//metodos
        ServicioTecnico nuevoServicio = new ServicioTecnico(IdServicio, NombreEmpresaYcodigo, NombreProductoYcodigo, PrecioServicioTecnico, FechaCompra, ServicioTecnicoRealizado, DetalleDelServicio);
        Servicio.add(nuevoServicio);
        JsonUtil.crearJson(Servicio, "servicios.json");
    }
 public static void mostrarServicios() throws FileNotFoundException {
        List<ServicioTecnico> todosLosServiciosTecnicos = JsonUtil.ReaderJson ("servicios.json", ServicioTecnico.class);
        
         if (todosLosServiciosTecnicos != null && !todosLosServiciosTecnicos.isEmpty()) {
            for (ServicioTecnico s : todosLosServiciosTecnicos) {
                System.out.println("ID: " + s.getIdServicio() + "\n" +
                                   "Nombre ya la empresa y codigo : " + s.getNombreEmpresaYcodigo() + "\n" +
                                   "Nombre del producto y codigo: " + s.getNombreProductoYCodigo() + "\n" +
                                   "Precio del servicio tecnico: " + s.getPrecioServicioTecnico() + "\n" + 
                                   "Fecha de la compra: " + s.getFechaCompra() + "\n" + 
                                   "Servicio tecnico que se realizo: " + s.getServicioRealizado() + "\n" + 
                                   "Detalles del servicio tecnico: " + s.getDetalleServicio() + "\n" + 
                                   "*-------------------------------------*\n");
            }
        } else {
            System.out.println("No hay informacion del servicio.");
        }
    }
public static void filtrarCliente(String filtrarPor, String valorBuscar) throws FileNotFoundException {
        List<ServicioTecnico> ServicioTecnicos = JsonUtil.ReaderJson ("servicios.json", ServicioTecnico.class);
        
         if (ServicioTecnicos != null) {
            boolean encontrado = false;

            for (ServicioTecnico s : ServicioTecnicos) {
                switch (filtrarPor.toLowerCase()) {
                    case "IdServicio":
                        if (valorBuscar.equals(s.getIdServicio())) {
                            mostrarServiciosTecnico (s);
                            encontrado = true;
                        }
                        break;
                    case "NombreEmpresaYcodigo":
                        if (valorBuscar.equals(s.getNombreEmpresaYcodigo())) {
                            mostrarServiciosTecnico(s);
                            encontrado = true;
                        }
                        break;
                    case "PrecioServicioTecnico":
                        if (valorBuscar.equals(s.getPrecioServicioTecnico())) {
                            mostrarServiciosTecnico(s);
                            encontrado = true;
                        }
                        break;
                    case "FechaCompra":
                        if (valorBuscar.equals(s.getFechaCompra())) {
                            mostrarServiciosTecnico(s);
                            encontrado = true;
                        }
                        break;
                        
                    case "ServicioRealizado":
                        if (valorBuscar.equals(s.getServicioRealizado())) {
                            mostrarServiciosTecnico(s);
                            encontrado = true;
                        }
                        break;
                    
                    case "DetalleServicio":
                        if (valorBuscar.equals(s.getDetalleServicio())) {
                            mostrarServiciosTecnico(s);
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
    public static void mostrarServiciosTecnico(ServicioTecnico s) {
        System.out.println("ID del servicio: " + s.getIdServicio() + "\n" +
                           "Nombre de la empresa fabricante: " + s.getNombreEmpresaYcodigo() + "\n" +
                           "Precio del servicio tecnico: " + s.getPrecioServicioTecnico() + "\n" +
                           "fecha de compra: " + s.getFechaCompra() + "\n" +
                           "Servicio realizado: " + s.getServicioRealizado() + "\n" + 
                           "Detalles del servicio: " + s.getDetalleServicio() + "\n" 

                );
    }

    private Object getNombreEmpresaYcodigo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Object getPrecioServicioTecnico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
         
         

}

    

