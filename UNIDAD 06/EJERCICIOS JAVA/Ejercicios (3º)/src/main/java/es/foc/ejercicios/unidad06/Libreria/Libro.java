package es.foc.ejercicios.unidad06.Libreria;


public class Libro implements Comparable<Libro> {
    private String titulo;
    private Categoria categoria;

    public Libro(String titulo, Categoria categoria) {
        this.titulo = titulo;
        this.categoria = categoria;
    }

    
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + '}';
    }

    @Override
    public int compareTo(Libro obj) {
        int comparacion = this.categoria.compareTo(obj.categoria);
        if (comparacion == 0)
            comparacion = this.titulo.compareTo(obj.titulo);        
        
        
        return comparacion;
    }
    
    
}
