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
public class SoporteTecnico {
    
    public String IdSoporte;
    public String NombreSoporte;
    public double PrecioSoporte;
    public Empresa empresa;

    //constructor 
    
    public SoporteTecnico(String IdSoporte, String NombreSoporte, double PrecioSoporte, Empresa empresa) {
        this.IdSoporte = IdSoporte;
        this.NombreSoporte = NombreSoporte;
        this.PrecioSoporte = PrecioSoporte;
        this.empresa = empresa;
    }
public String getIdSoporte() { return IdSoporte; }
public void setId(String IdSoporte) { this.IdSoporte = IdSoporte; }

public String getNombreSoporte() { return NombreSoporte; }
public void setNombreSoporte(String NombreSoporte) { this.NombreSoporte = NombreSoporte; }

public double getPrecioSoporte() { return PrecioSoporte; }
public void setPrecioSoporte(double PrecioSoporte) { this.PrecioSoporte = PrecioSoporte; 
};
//metodos
 public static void agregarSoporte(String IdSoporte, String NombreSoporte, double PrecioSoporte, Empresa empresa) {
        List<SoporteTecnico> Soportes;
        try {
            Soportes = JsonUtil.ReaderJson ("soporte.json", SoporteTecnico.class);
        } catch (FileNotFoundException e) {
            Soportes = new ArrayList<>();
        }

        SoporteTecnico nuevoSoporte = new SoporteTecnico( IdSoporte,  NombreSoporte,  PrecioSoporte,  empresa);
        Soportes.add(nuevoSoporte);
        JsonUtil.crearJson(Soportes, "proveedor.json");
    }

public static void mostrarTodosSoportes() throws FileNotFoundException {
        List<SoporteTecnico> todosLosSoportes = JsonUtil.ReaderJson ("soporte.json", SoporteTecnico.class);
 
            if (todosLosSoportes != null && !todosLosSoportes.isEmpty()) {
            for (SoporteTecnico t : todosLosSoportes) {
                System.out.println("ID del soporte: " + t.getIdSoporte() + "\n" +
                                   "Nombre del soporte : " + t.getNombreSoporte() + "\n" +
                                   "Precio del soporte: " + t.getPrecioSoporte() + "\n" + 
                                   "*-------------------------------------*\n");
            }
        } else {
            System.out.println("No hay informacion del servicio.");
        }
    }

    public static void filtrarSoporte(String filtrarPor, String valorBuscar) throws FileNotFoundException {
        List<SoporteTecnico> SoporteTecnicos = JsonUtil.ReaderJson ("soporte.json", SoporteTecnico.class);
         if (SoporteTecnicos != null) {
            boolean encontrado = false;

            for (SoporteTecnico t : SoporteTecnicos) {
                switch (filtrarPor.toLowerCase()) {
                    case "IdSoporte":
                        if (valorBuscar.equals(t.getIdSoporte())) {
                            mostrarSoporte (t);
                            encontrado = true;
                        }
                        break;
                    case "NombreSoporte":
                        if (valorBuscar.equals(t.getNombreSoporte())) {
                            mostrarSoporte(t);
                            encontrado = true;
                        }
                        break;
                    case "PrecioSoporte":
                        if (valorBuscar.equals(t.getPrecioSoporte())) {
                            mostrarSoporte(t);
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
    public static void mostrarSoporte(SoporteTecnico t) {
        System.out.println("ID del soporte: " + t.getIdSoporte() + "\n" +
                           "Nombre del soporte: " + t.getNombreSoporte() + "\n" +
                           "Precio del soporte: " + t.getPrecioSoporte() + "\n" );
    }
         
}