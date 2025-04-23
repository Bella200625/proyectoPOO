package co.edu.udec.poo.BellaBotello.modelo.entidades;

import co.edu.udec.poo.BellaBotello.util.JsonUtil;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mezab
 */
public class Cliente {
    
    private String dni;
    private String idCliente;
    public String nombre;
    private String telefono;
    private String direccion;
    private String correo;
    
    // Constructor vacío
    public Cliente() {}

    // Constructor con parámetros
    public Cliente(String dni, String idCliente, String nombre, String telefono, String direccion, String correo) {
        this.dni = dni;
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    // Método estático para agregar un cliente a la lista
    public static void agregarCliente(String dni, String idCliente, String nombre, String telefono, String direccion, String correo) {
        List<Cliente> clientes = null;

        try {
            clientes = JsonUtil.ReaderJson("cliente.json", Cliente.class);
        } catch (FileNotFoundException e) {
            // Si no se encuentra el archivo, se crea una lista vacía
            clientes = new ArrayList<>();
        }
        
        // Crear el nuevo cliente
        Cliente nuevoCliente = new Cliente(dni, idCliente, nombre, telefono, direccion, correo);
        
        // Agregar el cliente a la lista
        clientes.add(nuevoCliente);
        
        // Guardar la lista actualizada en el archivo JSON
        JsonUtil.crearJson(clientes, "cliente.json");
    }

    // Métodos para obtener los datos del cliente
    public String getDni() {
        return dni;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    // Métodos para establecer los datos del cliente
    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Método para mostrar todos los clientes
    public static void mostrarTodosClientes() throws FileNotFoundException {
        List<Cliente> todosClientes = JsonUtil.ReaderJson("cliente.json", Cliente.class);

        if (todosClientes != null && !todosClientes.isEmpty()) {
            for (Cliente c : todosClientes) {
                System.out.println("ID: " + c.getIdCliente() + "\n" +
                                   "DNI: " + c.getDni() + "\n" +
                                   "Nombre: " + c.getNombre() + "\n" +
                                   "Teléfono: " + c.getTelefono() + "\n" +
                                   "Dirección: " + c.getDireccion() + "\n" +
                                   "Correo: " + c.getCorreo() + "\n" + 
                                   "*-------------------------------------*\n");
            }
        } else {
            System.out.println("No hay clientes registrados.");
        }
    }

    // Método para filtrar clientes según un campo y valor
    public static void filtrarCliente(String filtrarPor, String valorBuscar) throws FileNotFoundException {
        List<Cliente> clientes = JsonUtil.ReaderJson("cliente.json", Cliente.class);

        if (clientes != null) {
            boolean encontrado = false;

            for (Cliente c : clientes) {
                switch (filtrarPor.toLowerCase()) {
                    case "dni":
                        if (valorBuscar.equals(c.getDni())) {
                            mostrarCliente(c);
                            encontrado = true;
                        }
                        break;
                    case "idcliente":
                        if (valorBuscar.equals(c.getIdCliente())) {
                            mostrarCliente(c);
                            encontrado = true;
                        }
                        break;
                    case "nombre":
                        if (valorBuscar.equals(c.getNombre())) {
                            mostrarCliente(c);
                            encontrado = true;
                        }
                        break;
                    case "telefono":
                        if (valorBuscar.equals(c.getTelefono())) {
                            mostrarCliente(c);
                            encontrado = true;
                        }
                        break;
                    case "direccion":
                        if (valorBuscar.equals(c.getDireccion())) {
                            mostrarCliente(c);
                            encontrado = true;
                        }
                        break;
                    case "correo":
                        if (valorBuscar.equals(c.getCorreo())) {
                            mostrarCliente(c);
                            encontrado = true;
                        }
                        break;
                    default:
                        System.out.println("Campo no reconocido: " + filtrarPor);
                        return;
                }
            }

            if (!encontrado) {
                System.out.println("No se encontró un cliente con el valor especificado.");
            }
        }
    }

    // Método para mostrar la información de un cliente
    public static void mostrarCliente(Cliente c) {
        System.out.println("ID: " + c.getIdCliente() + "\n" +
                           "DNI: " + c.getDni() + "\n" +
                           "Nombre: " + c.getNombre() + "\n" +
                           "Teléfono: " + c.getTelefono() + "\n" +
                           "Dirección: " + c.getDireccion() + "\n" +
                           "Correo: " + c.getCorreo() + "\n");
    }
}
