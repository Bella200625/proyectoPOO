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
public class Empresa {
    public String IdEmpresa;
    public String NombreEmpresa;
    public String Direccion;
    public int NumeroEmpleados;

    public Empresa(String IdEmpresa, String NombreEmpresa, String Direccion, int NumeroEmpleados) {
        this.IdEmpresa = IdEmpresa;
        this.NombreEmpresa = NombreEmpresa;
        this.Direccion = Direccion;
        this.NumeroEmpleados = NumeroEmpleados;
    }
    
    public String getIdEmpresa() { return IdEmpresa; }
        public void setIdEmpresa(String IdEmpresa) { this.IdEmpresa = IdEmpresa; }

    public String getNombreEmpresa() { return NombreEmpresa; }
        public void setNombreEmpresa(String NombreEmpresa) { this.NombreEmpresa = NombreEmpresa; }

    public String getDireccion() { return Direccion; }
        public void setDireccion(String Direccion) { this.Direccion = Direccion; }

    public int getNumeroEmpleados() { return NumeroEmpleados; }
        public void setNumeroEmpleados(int NumeroEmpleados) { this.NumeroEmpleados = NumeroEmpleados; 
        
        }
        //metodos
        
         public static void agregarEmpresa(String IdEmpresa, String NombreEmpresa, String Direccion, int NumeroEmpleados) {
        List<Empresa> Empresas;
        try {
            Empresas = JsonUtil.ReaderJson("empresas.json", Empresa.class);
        } catch (FileNotFoundException e) {
            Empresas = new ArrayList<>();
        }

        Empresa nuevaEmpresa = new Empresa( IdEmpresa,  NombreEmpresa,  Direccion,  NumeroEmpleados);
        Empresas.add(nuevaEmpresa);
        JsonUtil.crearJson(Empresas, "empresas.json");
    }
        public static void mostrarTodosEmpresas() throws FileNotFoundException {
        List<Empresa> todasLasEmpresas = JsonUtil.ReaderJson ("empresas.json", Empresa.class);
        
        if (todasLasEmpresas != null && !todasLasEmpresas.isEmpty()) {
            for (Empresa e : todasLasEmpresas) {
                System.out.println("ID: " + e.getIdEmpresa() + "\n" +
                                   "Nif: " + e.getNombreEmpresa() + "\n" +
                                   "Direccion: " + e.getDireccion() + "\n" +
                                   "Fecha de adquisicion: " + e.getNumeroEmpleados() + "\n" + 
                                   "*-------------------------------------*\n");
            }
        } else {
            System.out.println("No hay provedor registrado.");
        }
    }
public static void filtrarCliente(String filtrarPor, String valorBuscar) throws FileNotFoundException {
        List<Empresa> empresas = JsonUtil.ReaderJson ("empresas.json", Empresa.class);
        
         if (empresas != null) {
            boolean encontrado = false;

            for (Empresa e : empresas) {
                switch (filtrarPor.toLowerCase()) {
                    case "IdEmpresa":
                        if (valorBuscar.equals(e.getIdEmpresa())) {
                            mostrarEmpresa (e);
                            encontrado = true;
                        }
                        break;
                    case "NombreEmpresa":
                        if (valorBuscar.equals(e.getNombreEmpresa())) {
                            mostrarEmpresa(e);
                            encontrado = true;
                        }
                        break;
                    case "Direccion":
                        if (valorBuscar.equals(e.getDireccion())) {
                            mostrarEmpresa(e);
                            encontrado = true;
                        }
                        break;
                    case "NumeroEmpleados":
                        if (valorBuscar.equals(e.getNumeroEmpleados())) {
                            mostrarEmpresa(e);
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
    public static void mostrarEmpresa(Empresa e) {
        System.out.println("ID de empresa: " + e.getIdEmpresa() + "\n" +
                           "NIF: " + e.getNombreEmpresa() + "\n" +
                           "Direccion: " + e.getDireccion() + "\n" +
                           "fecha de adquiscion: " + e.getNumeroEmpleados() + "\n" );
    }
         
         

}
  

