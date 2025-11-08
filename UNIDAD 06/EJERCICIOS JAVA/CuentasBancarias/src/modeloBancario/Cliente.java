package modeloBancario;

public class Cliente {

    // Atributos
    private int idCliente;
    private String nombre;
    private String direccion;
    private String telefono;

    // Constructor sin parámetros: inicializa cadenas a null y números a 0
    public Cliente() {
        this.idCliente = 0;
        this.nombre = null;
        this.direccion = null;
        this.telefono = null;
    }

    // Constructor con parámetros: inicializa cada atributo
    public Cliente(int idCliente, String nombre, String direccion, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
