package es.foc;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Telefono implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private String tipo; // Ejemplo: "Móvil", "Casa", "Trabajo"

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public Telefono() {}

    public Telefono(String numero, String tipo, Persona persona) {
        this.numero = numero;
        this.tipo = tipo;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters y setters...
}