package co.edu.udec.poo.BellaBotello.modelo.entidades;

import co.edu.udec.poo.BellaBotello.util.JsonUtil;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    public String IdProveedor;
    public String Nit;
    public String nombre;
    public String Direccion;

    // Constructor
    public Proveedor(String IdProveedor, String Nit, String Direccion, String nombre) {
        this.IdProveedor = IdProveedor;
        this.Nit = Nit;
        this.Direccion = Direccion;
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getIdProveedor() { return IdProveedor; }
    public void setIdProveedor(String IdProveedor) { this.IdProveedor = IdProveedor; }

    public String getNit() { return Nit; }
    public void setNit(String Nit) { this.Nit = Nit; }

    public String getDireccion() { return Direccion; }
    public void setDireccion(String Direccion) { this.Direccion = Direccion; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Agregar proveedor
    public static void agregarProveedor(String IdProveedor, String Nit, String Direccion, String nombre) {
        List<Proveedor> proveedores;
        try {
            proveedores = JsonUtil.ReaderJson("proveedor.json", Proveedor.class);
        } catch (FileNotFoundException e) {
            proveedores = new ArrayList<>();
        }

        Proveedor nuevoProveedor = new Proveedor(IdProveedor, Nit, Direccion, nombre);
        proveedores.add(nuevoProveedor);
        JsonUtil.crearJson(proveedores, "proveedor.json");
    }

    // Mostrar todos
    public static void mostrarTodosProveedor() throws FileNotFoundException {
        List<Proveedor> proveedores = JsonUtil.ReaderJson("proveedor.json", Proveedor.class);
        if (proveedores != null && !proveedores.isEmpty()) {
            for (Proveedor a : proveedores) {
                mostrarProveedor(a);
                System.out.println("*-------------------------------------*\n");
            }
        } else {
            System.out.println("No hay proveedores registrados.");
        }
    }

    // Mostrar proveedor
    public static void mostrarProveedor(Proveedor a) {
        System.out.println("ID: " + a.getIdProveedor());
        System.out.println("NIT: " + a.getNit());
        System.out.println("Nombre: " + a.getNombre());
        System.out.println("Dirección: " + a.getDireccion());
    }

    // Filtrar proveedor (con coincidencias parciales)
    public static void filtrarProveedor(String filtrarPor, String valorBuscar) throws FileNotFoundException {
        List<Proveedor> proveedores = JsonUtil.ReaderJson("proveedor.json", Proveedor.class);
        if (proveedores != null) {
            boolean encontrado = false;
            String filtro = filtrarPor.toLowerCase();
            String valor = valorBuscar.toLowerCase();

            for (Proveedor a : proveedores) {
                switch (filtro) {
                    case "idproveedor" -> {
                        if (a.getIdProveedor().toLowerCase().contains(valor)) {
                            mostrarProveedor(a);
                            encontrado = true;
                        }
                    }
                    case "nombre" -> {
                        if (a.getNombre().toLowerCase().contains(valor)) {
                            mostrarProveedor(a);
                            encontrado = true;
                        }
                    }
                    case "nit" -> {
                        if (a.getNit().toLowerCase().contains(valor)) {
                            mostrarProveedor(a);
                            encontrado = true;
                        }
                    }
                    case "direccion" -> {
                        if (a.getDireccion().toLowerCase().contains(valor)) {
                            mostrarProveedor(a);
                            encontrado = true;
                        }
                    }
                    default -> {
                        System.out.println("Campo no reconocido: " + filtrarPor);
                        return;
                    }
                }
            }

            if (!encontrado) {
                System.out.println("No se encontró ningún proveedor con el valor especificado.");
            }
        }
    }
}
