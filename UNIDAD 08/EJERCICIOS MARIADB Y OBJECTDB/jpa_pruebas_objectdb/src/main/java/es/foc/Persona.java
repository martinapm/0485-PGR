package es.foc;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

import java.util.ArrayList;

@Entity
@Table(name="persona")
@NamedQuery(name = "Persona.buscarPorNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre")
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private int edad;

    @OneToMany( mappedBy = "persona")
    private List<Domicilio> domicilios = new ArrayList<>(); // Inicialización

    @OneToMany(mappedBy = "persona")
    private List<Telefono> telefonos = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "persona_proyecto",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "proyecto_id")
    )
    private List<Proyecto> proyectos = new ArrayList<>();

    // Constructor
    public Persona() {}

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.domicilios = new ArrayList<>();
        this.telefonos = new ArrayList<>();
        this.proyectos = new ArrayList<>();
    }

    // Getters y Setters
    public List<Domicilio> getDomicilios() { return domicilios; }
    public void setDomicilios(List<Domicilio> domicilios) { this.domicilios = domicilios; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
}
