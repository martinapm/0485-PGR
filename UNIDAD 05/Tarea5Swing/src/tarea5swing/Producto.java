package tarea5swing;
public class Producto {
    private String codigo;
    private String nombre;
    private int cantidad;
    private double precio;
    private String descripcion;

    // Constructor
    public Producto(String codigo, String nombre, int cantidad, double precio, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidad() {
        return cantidad;
    }
    public double getPrecio() {
        return precio;
    }
    public String getDescripcion() {
        return descripcion;
    }

    // Sobrescribe el método heredado de Object para dar una representación legible de los datos del producto
    @Override
    public String toString() {
        return String.format("Código: %s, Nombre: %s, Cantidad: %d, Precio: %.2f, Descripción: %s",
                codigo, nombre, cantidad, precio, descripcion);
    }
}