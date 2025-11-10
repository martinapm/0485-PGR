package es.foc.ejercicios.unidad06.Libreria;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Libreria implements Iterable<Libro>{

    private String nombre; 
    private String direccion; 
    private List<Libro> libros; 
    private List<Cliente> clientes; 
    private Set<Categoria> categorias;

    public Libreria(String nombre, String direccion) { 
        this.nombre = nombre; 
        this.direccion = direccion; 
        this.libros = new ArrayList<>(); 
        this.clientes = new ArrayList<>();
        this.categorias = new HashSet<>();
    } 

    public void addLibro(Libro miLibro) { 
        this.libros.add(miLibro); 
    } 

    public void addCliente(Cliente cli) { 
        this.clientes.add(cli); 
    } 
    
    public void addCategoria(Categoria cat){
        this.categorias.add(cat);
       
    }
        
    
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    
    public Set<Categoria> getCategorias() {
        return categorias;
    }
    
    public Categoria buscarCategoriaPorNombre(String nombreCategoria) {
        for (Categoria categoria : this.categorias) {
            if (categoria.getNombre().equalsIgnoreCase(nombreCategoria)) {
                return categoria;
            }
        }
        return null;
    }
    
    
    @Override
    public Iterator<Libro> iterator() {
        return new miIterador();
    }

    // VER DOCUMENTACIÓN AL FINAL DEL FICHERO
    private class miIterador implements Iterator<Libro> { 
        private int currentIndex = 0; 

        @Override
        public boolean hasNext() {
            return currentIndex < libros.size(); 
        }

        @Override
        public Libro next() {            
            return libros.get(currentIndex++); 
            
        }
    }    
}

/*
Cuando se utiliza una clase definida dentro de otra clase de esta manera, se le llama Clase Interna o Inner Class. Las clases internas son útiles en Java por varias razones, incluyendo las siguientes:

    *Agrupación lógica: Permiten agrupar clases que pertenecen juntas, lo que hace tu código más legible y mantenible.
    *Encapsulación: Proporcionan una buena encapsulación. Pueden acceder a los miembros de la clase externa, incluso si estos son privados, lo que te permite ocultar detalles de implementación de otras partes de tu programa.
    *Reducción del ámbito de nombres: Ayudan a evitar conflictos de nombres ya que el ámbito de la clase interna está limitado a la clase externa.

Tipos de Clases Internas en Java

Hay cuatro tipos de clases internas en Java:

    *Clases Internas Miembro: Se definen al mismo nivel que los métodos miembro de una clase. Pueden ser static o no static.
    *Clases Internas Locales: Se definen dentro de un bloque de código, típicamente dentro de un método.
    *Clases Anónimas: Son un tipo especial de clases internas locales que no tienen un nombre.
    *Clases Internas Estáticas: Son declaradas como miembros estáticos de una clase externa.

Tu ejemplo muestra una Clase Interna Miembro que no es estática (miIterador). Esta clase interna tiene acceso a los campos y métodos de la instancia de la clase externa (Libreria en este caso), lo que le permite manipular directamente la colección libros que se asume es un miembro de Libreria.
*/