
package es.foc.ra09.modelo;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    private int id;
    private String titulo;
    private int precio;
    private List<Autor> autores;

    public Libro(String titulo, int precio) {
        this.titulo = titulo;
        this.precio = precio;
        this.autores = new ArrayList<>();
    }

    public Libro(int id, String titulo, int precio) {
        this(titulo,precio);
        this.id = id;
    }
    
    
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrecio() {
        return precio;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void addAutor(Autor autor) {
        autores.add(autor);
    }
}
