
package es.foc.ejercicios.graficos.Personas;

/**
 * Esta clase denominada Persona modela una persona que cuenta con los
 * atributos: nombre, apellidos, teléfono y dirección.
 *
  */
public class Persona {

    String nombre; // Atributo que identifica el nombre de una persona
    String apellidos;
    /* Atributo que identifica los apellidos de una persona */
    String telefono; // Atributo que identifica el teléfono de una persona
    String direccion;

    /* Atributo que identifica la dirección de una persona */
    /**
     * Constructor de la clase Persona
     *
     * @param nombre Parámetro que define el nombre de una persona
     * @param apellidos Parámetro que define los apellidos de una persona
     * * @param teléfono Parámetro que define el teléfono de una persona
     * @param dirección Parámetro que define la dirección de una persona
     */
    public Persona(String nombre, String apellidos, String telefono, String dirección) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
    }
}
