package es.foc;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "domicilio")
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private String ciudad;
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;


    // Constructor
    public Domicilio() {}

    public Domicilio(String calle, String ciudad, Persona persona) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.persona = persona;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}