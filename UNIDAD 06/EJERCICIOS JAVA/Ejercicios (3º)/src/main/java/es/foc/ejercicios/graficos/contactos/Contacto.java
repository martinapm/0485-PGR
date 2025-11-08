package es.foc.ejercicios.graficos.contactos;

import java.time.LocalDate;

/**
 * Esta clase denominada Contacto define un contacto para una agenda de
 * contactos.
 *
 */
public class Contacto {

    String nombres; // Atributo que define los nombres de un contacto
    String apellidos; // Atributo que define los apellidos de un contacto
    LocalDate fechaNacimiento;
    /* Atributo que define la fecha de nacimiento de un contacto */
    String direccion; // Atributo que define la dirección de un contacto
    String telefono; // Atributo que define el teléfono de un contacto
    String correo; // Atributo que define el correo de un contacto

    /**
     * Constructor de la clase Contacto
     *
     * @param nombres Parámetro que define los nombres de un contacto
     * @param apellidos Parámetro que define los apellidos de un contacto
     * @param fechaNacimiento Parámetro que define la fecha de nacimiento de un
     * contacto
     * @param dirección Parámetro que define la dirección de un contacto
     * @param teléfono Parámetro que define el teléfono de un contacto
     * @param correo Parámetro que define el correo de un contacto
     */
    public Contacto(String nombres, String apellidos, LocalDate fechaNacimiento, String direccion, String telefono, String correo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }
}
