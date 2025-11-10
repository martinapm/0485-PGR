package es.foc;

/**
 * Clase modelo para representar un departamento
 */
public class Departamento {

    private int codigo;
    private String nombre;
    private int idLocalizacion;
    private int idManager;

    // Constructor vacío
    public Departamento() {
    }

    // Constructor con todos los campos
    public Departamento(int codigo, String nombre, int idLocalizacion, int idManager) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idLocalizacion = idLocalizacion;
        this.idManager = idManager;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(int idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", idLocalizacion=" + idLocalizacion +
                ", idManager=" + idManager +
                '}';
    }
}