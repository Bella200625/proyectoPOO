package co.edu.udec.poo.BellaBotello.modelo.entidades;

import co.edu.udec.poo.BellaBotello.util.JsonUtil;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Producto {
    public String IdProducto;
    public String Nombre;
    public String Modelo;
    public String FechaFabricacion;
    public String PaisOrigen;
    public String IdEmpresa;
    public boolean AltaTecnologia = false;
    public String ResolucionMaxima; 
    public String MemoriaPrincipal;
    public String VelocidadDeImpresion;
    public String fechaDeAquisicion;
    public String idProveedor;

    // Constructor
    public Producto(String id, String nombre, String modelo, String memoria, String velocidad, String resolucion,
                    boolean altaTecnologia, String fechaFab, String pais, String idEmpresa, String idProveedor, String fechaDeAquisicion) {
        this.IdProducto = id;
        this.Nombre = nombre;
        this.Modelo = modelo;
        this.MemoriaPrincipal = memoria;
        this.VelocidadDeImpresion = velocidad;
        this.ResolucionMaxima = resolucion;
        this.AltaTecnologia = altaTecnologia;
        this.fechaDeAquisicion = fechaDeAquisicion;

        if (altaTecnologia) {
            this.FechaFabricacion = fechaFab;
            this.PaisOrigen = pais;
            this.IdEmpresa = idEmpresa;
        }

        this.idProveedor = idProveedor;
    }

    // Métodos getter y setter
    public String getIdProducto() { return IdProducto; }
    public void setIdProducto(String IdProducto) { this.IdProducto = IdProducto; }

    public String getNombre() { return Nombre; }
    public void setNombre(String Nombre) { this.Nombre = Nombre; }

    public String getModelo() { return Modelo; }
    public void setModelo(String Modelo) { this.Modelo = Modelo; }

    public String getFechaDeFabricacion() { return FechaFabricacion; }
    public void setFechaDeFabricacion(String FechaDeFabricacion) { this.FechaFabricacion = FechaDeFabricacion; }

    public String getPaisDeOrigen() { return PaisOrigen; }
    public void setPaisDeOrigen(String PaisDeOrigen) { this.PaisOrigen = PaisDeOrigen; }

    public String getIdEmpresa() { return IdEmpresa; }
    public void setIdEmpresa(String IdEmpresa) { this.IdEmpresa = IdEmpresa; }

    public boolean getAltaTecnologia() { return AltaTecnologia; }
    public void setAltaTecnologia(boolean AltaTecnologia) { this.AltaTecnologia = AltaTecnologia; }

    public String getVelocidadDeImpresion() { return VelocidadDeImpresion; }
    public void setVelocidadDeImpresion(String VelocidadDeImpresion) { this.VelocidadDeImpresion = VelocidadDeImpresion; }

    public String getResolucionMaxima() { return ResolucionMaxima; }
    public void setResolucionMaxima(String ResolucionMaxima) { this.ResolucionMaxima = ResolucionMaxima; }

    public String getMemoriaPrincipal() { return MemoriaPrincipal; }
    public void setMemoriaPrincipal(String MemoriaPrincipal) { this.MemoriaPrincipal = MemoriaPrincipal; }
    
        public String getFechaDeAquisicion() { return fechaDeAquisicion; }
    public void setFechaDeAquisicion(String fechaDeAquisicion) { this.fechaDeAquisicion = fechaDeAquisicion; }

    // Método estático para agregar un producto
    public static void agregarProducto(String IdProducto, String Nombre, String Modelo, 
                                       String FechaFabricacion, String PaisOrigen, String IdEmpresa, 
                                       boolean AltaTecnologia, String MemoriaPrincipal, 
                                       String VelocidadDeImpresion, String ResolucionMaxima, 
                                       String idProveedor, String fechaDeAquisicion) {
        List<Producto> productos;

        try {
            productos = JsonUtil.ReaderJson("producto.json", Producto.class);
        } catch (FileNotFoundException e) {
            productos = new ArrayList<>();
        }

        Producto nuevoProducto;
        
        if (AltaTecnologia) {
            nuevoProducto = new Producto(IdProducto, Nombre, Modelo, MemoriaPrincipal, VelocidadDeImpresion, 
                                          ResolucionMaxima, AltaTecnologia, FechaFabricacion, PaisOrigen, 
                                          IdEmpresa, idProveedor, fechaDeAquisicion);
        } else {
            nuevoProducto = new Producto(IdProducto, Nombre, Modelo, MemoriaPrincipal, VelocidadDeImpresion, 
                                          ResolucionMaxima, AltaTecnologia, "", "", "", idProveedor, fechaDeAquisicion);
        }
        
        productos.add(nuevoProducto);
        JsonUtil.crearJson(productos, "producto.json");
    }

    // Método para listar productos
    public void listarProductos() {
        System.out.println("idProducto: " + IdProducto);
        System.out.println("nombre: " + Nombre);
        System.out.println("modelo: " + Modelo);
        System.out.println("fecha Fabricacion: " + FechaFabricacion);
        System.out.println("paisOrigen: " + PaisOrigen);
        System.out.println("Memoria Principal: " + MemoriaPrincipal);
        System.out.println("Velocidad de impresion: " + VelocidadDeImpresion);
        System.out.println("Producto de alta tecnologia: " + AltaTecnologia);
        System.out.println("Id de Empresa: " + IdEmpresa);
        System.out.println("Resolucion Maxima" + ResolucionMaxima);
        System.out.println("Proveedor: " + idProveedor);
        System.out.println("Proveedor: " + fechaDeAquisicion);
    };

    // Método para mostrar todos los productos
    public static void mostrarTodosProductos() throws FileNotFoundException {
        List<Producto> todosLosProductos = JsonUtil.ReaderJson("producto.json", Producto.class);  

        if (todosLosProductos != null && !todosLosProductos.isEmpty()) {
            for (Producto p : todosLosProductos) {
                System.out.println("ID: " + p.getIdProducto() + "\n" +
                                   "Nombre: " + p.getNombre() + "\n" +
                                   "Modelo: " + p.getModelo() + "\n" +
                                   "Id Empresa: " + p.getIdEmpresa() + "\n" +
                                   "Alta de tecnologia: " + p.getAltaTecnologia() + "\n" +
                                   "Resolucion Maxima: " + p.getResolucionMaxima() + "\n" +
                                   "Velocidad de impresion: " + p.getVelocidadDeImpresion() + "\n" +
                                   "Memoria Principal: " + p.getMemoriaPrincipal() + "\n" + 
                                   "Fecha de fabricacion: " + p.getFechaDeFabricacion() + "\n" +
                                   "PaisDeOrigen: " + p.getPaisDeOrigen() + "\n" +
                                   "Fecha de adquisicion: " + p.getFechaDeAquisicion() + "\n" +
                                   "*-------------------------------------*\n");
            }
        } else {
            System.out.println("No hay productos registrados.");
        }
    }

    // Método para filtrar productos
   public static void filtrarProducto(String filtrarPor, String valorBuscar) throws FileNotFoundException {
    List<Producto> productos = JsonUtil.ReaderJson("producto.json", Producto.class);     

    if (productos != null) {
        boolean encontrado = false;

        for (Producto p : productos) {
            switch (filtrarPor.toLowerCase()) {
                case "idproducto" -> {
                    if (valorBuscar.equals(p.getIdProducto())) {
                        mostrarProducto(p);
                        encontrado = true;
                    }
                }
                case "nombre" -> {
                    if (valorBuscar.equals(p.getNombre())) {
                        mostrarProducto(p);
                        encontrado = true;
                    }
                }
                case "modelo" -> {
                    if (valorBuscar.equals(p.getModelo())) {
                        mostrarProducto(p);
                        encontrado = true;
                    }
                }
                case "idempresa" -> {
                    if (valorBuscar.equals(p.getIdEmpresa())) {
                        mostrarProducto(p);
                        encontrado = true;
                    }
                }
                case "altatecnologia" -> {
                    boolean buscar = Boolean.parseBoolean(valorBuscar);
                    if (buscar == p.getAltaTecnologia()) {
                        mostrarProducto(p);
                        encontrado = true;
                    }
                }
                case "fechadefabricacion" -> {
                    if (valorBuscar.equals(p.getFechaDeFabricacion())) {
                        mostrarProducto(p);
                        encontrado = true;
                    }
                }
                case "paisdeorigen" -> {
                    if (valorBuscar.equals(p.getPaisDeOrigen())) {
                        mostrarProducto(p);
                        encontrado = true;
                    }
                }
                case "fechaAdquisicion" -> {
                    if (valorBuscar.equals(p.getFechaDeAquisicion())) {
                        mostrarProducto(p);
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
            System.out.println("No se encontró un producto con el valor especificado.");
        }
    }
}


    // Método para mostrar un producto
    public static void mostrarProducto(Producto p) {
        System.out.println("ID: " + p.getIdProducto() + "\n" +
                           "nombre: " + p.getNombre() + "\n" +
                           "modelo: " + p.getModelo() + "\n" +
                           "Id Empresa: " + p.getIdEmpresa() + "\n" +
                           "Alta Tecnologia: " + p.getAltaTecnologia() + "\n" +
                           "fecha de fabricacion: " + p.getFechaDeFabricacion() + "\n" +
                           "fecha de fabricacion: " + p.getFechaDeAquisicion() + "\n" +
                           "pais de origen: " + p.getPaisDeOrigen() + "\n");
    }
}
