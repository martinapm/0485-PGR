
package es.foc.ra09.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Autor {
    private int id;
    private String nombre;
    private String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public Autor(int autorId, String autorNombre, String autorNacionalidad) {
        this(autorNombre, autorNacionalidad);
        this.id = autorId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
}