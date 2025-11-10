package es.foc.ejercicios.unidad06.Libreria;

import es.foc.ejercicios.unidad06.Libreria.Comparadores.Clientes.*;
import es.foc.ejercicios.unidad06.Libreria.Comparadores.Libro.ComparadorUbicacion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author PGR - ED
 */
public class AppLibreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Libreria libreria = new Libreria("Biblioteca Central", "Granada");

        agregarCategoriasALibreria(libreria);

        agregarLibrosALibreria(libreria);

        agregarClientesALibreria(libreria);
        System.out.println("\n\n-------------------- Impresión de libros por orden de inserción --------------------");
        imprimirLibreria(libreria);
        System.out.println("\n\n-------------------- Impresión de libros usando el iterado de libreria --------------------");
        Iterator<Libro> it = libreria.iterator();
        while (it.hasNext()) {
            Libro libro = it.next();
            System.out.println(libro);
        }
        
        System.out.println("\n\n-------------------- Imprimir librería ordenada usando metodo con un foreach --------------------");
        Collections.sort(libreria.getLibros());
        imprimirLibreria(libreria);
                

        System.out.println("\n\n-------------------- Imprimir con un metodo genérico --------------------");
        imprimirColeccion(libreria);
        
        System.out.println("\n\n-------------------- Datos de la libreria");
        System.out.println("Nombre de la biblioteca: " + libreria.getNombre());
        System.out.println("Ubicación: " + libreria.getDireccion());

        
        System.out.println("\n\n-------------------- COMPARADORES --------------------");
        // Ordenar por nombre 
        System.out.println("\n--------------------Ordenado por nombre:");
        Collections.sort(libreria.getClientes(), new ComparadorPorNombre());
        for (Cliente p : libreria.getClientes()) {
            System.out.println(p);
        }
        System.out.println();

        // Ordenar por edad 
        System.out.println("\n--------------------Ordenado por edad:");
        Collections.sort(libreria.getClientes(), new ComparadorPorEdad());
        for (Cliente p : libreria.getClientes()) {
            System.out.println(p);
        }
        System.out.println();

        // Ordenar por altura 
        System.out.println("\n--------------------Ordenado por altura:");
        Collections.sort(libreria.getClientes(), new ComparadorPorAltura());
        for (Cliente p : libreria.getClientes()) {
            System.out.println(p);
        }

        
        System.out.println("\n\n-------------------- COMPARADORES --------------------");
        System.out.println("\n\n-------------------- REPITIENDO IMPRESIÓN CON UN METODO GENÉRICO --------------------");
        System.out.println("\n--------------------Ordenado por nombre:");
        Collections.sort(libreria.getClientes(), new ComparadorPorNombre());       
        imprimirColeccion(libreria.getClientes());
        System.out.println("\n--------------------Ordenado por edad:");
        Collections.sort(libreria.getClientes(), new ComparadorPorEdad());
        imprimirColeccion(libreria.getClientes());
        System.out.println("\n--------------------Ordenado por altura:");
        Collections.sort(libreria.getClientes(), new ComparadorPorAltura());
        imprimirColeccion(libreria.getClientes());


        
        //**********************
        System.out.println("\n\n-------------- Ordenar por categoria y libro --------------");
        Collections.sort(libreria.getLibros(), new ComparadorUbicacion());
        
        for (Libro libro : libreria) {            
            System.out.println(libro.getCategoria() +"-->"+libro);
        }       
        
        System.out.println("\n\n-------------- Imprimir solo los libros --------------");
        imprimirColeccion(libreria.getLibros());
        
        System.out.println("\n\n-------------------- CATEGORIAS --------------------");
        imprimirColeccion(libreria.getCategorias());

        System.out.println("\n\n-------------------- CATEGORIAS ORDENADAS --------------------");             
        List<Categoria> categoriasOrdenadas = new ArrayList<>(libreria.getCategorias());
        Collections.sort(categoriasOrdenadas);        
        imprimirColeccion(categoriasOrdenadas);
        
        System.out.println("\n\n---------- CATEGORIAS ORDENADAS por pasillo, estanteria, nombre con comparador in situ --------");             
        System.out.println("---------- Utilización del concepto de clase ANONIMA --------");             
        Collections.sort(categoriasOrdenadas, new Comparator<Categoria>(){  //
            @Override
            public int compare(Categoria c1, Categoria c2) {
                int diferencia = c1.pasillo - c2.pasillo;
                if (diferencia == 0) {
                    diferencia = c1.estanteria - c2.estanteria;
                }
                if (diferencia == 0) {
                    diferencia = c1.compareTo(c2);
                }
                return diferencia;
            }                
        });
        
        imprimirColeccion(categoriasOrdenadas);
        
    }

    public static void imprimirLibreria(Libreria libreria) {
        for (Object libro : libreria) {
            System.out.println((Libro) libro);
        }
    }

    /* Metodo generico para imprimir cualquier ArrayList */
    public static void imprimirColeccion(Iterable<?> coleccion) {
        Iterator<?> it = coleccion.iterator();
        while (it.hasNext()) {
            Object elemento = it.next();
            System.out.println(elemento);
        }
    }

    private static void agregarCategoriasALibreria(Libreria libreria) {
        // Categorías existentes
        Categoria c1 = new Categoria("ciencia ficcion", "libros de ciencia ficcion", 2, 3);
        Categoria c2 = new Categoria("infantil", "libros de niños", 1, 2);
        Categoria c3 = new Categoria("fantasia", "libros de frikis", 1, 1);

        // Nuevas categorías
        Categoria c4 = new Categoria("historia", "libros de historia universal", 3, 2);
        Categoria c5 = new Categoria("biografías", "vidas inspiradoras", 4, 1);
        Categoria c6 = new Categoria("autoayuda", "mejora personal y profesional", 5, 3);
        Categoria c7 = new Categoria("cocina", "recetas y técnicas culinarias", 2, 4);
        Categoria c8 = new Categoria("viajes", "aventuras alrededor del mundo", 3, 1);
        Categoria c9 = new Categoria("tecnología", "últimos avances tecnológicos", 4, 2);
        Categoria c10 = new Categoria("arte", "desde la pintura hasta la escultura", 1, 5);

        // Añadir categorías a la librería
        libreria.addCategoria(c1);
        libreria.addCategoria(c2);
        libreria.addCategoria(c3);
        libreria.addCategoria(c4);
        libreria.addCategoria(c5);
        libreria.addCategoria(c6);
        libreria.addCategoria(c7);
        libreria.addCategoria(c8);
        libreria.addCategoria(c9);
        libreria.addCategoria(c10);

    }

    private static void agregarLibrosALibreria(Libreria libreria) {

        libreria.addLibro(new Libro("El principio", libreria.buscarCategoriaPorNombre("infantil")));
        libreria.addLibro(new Libro("Don Quijote de la Mancha", libreria.buscarCategoriaPorNombre("ciencia ficcion")));
        libreria.addLibro(new Libro("Danza de dragones", libreria.buscarCategoriaPorNombre("fantasia")));
        libreria.addLibro(new Libro("Sapiens: De animales a dioses", libreria.buscarCategoriaPorNombre("historia")));
        libreria.addLibro(new Libro("Steve Jobs", libreria.buscarCategoriaPorNombre("biografías")));
        libreria.addLibro(new Libro("El poder del ahora", libreria.buscarCategoriaPorNombre("autoayuda")));
        libreria.addLibro(new Libro("El arte de la fermentación", libreria.buscarCategoriaPorNombre("cocina")));
        libreria.addLibro(new Libro("En ruta por España y Portugal", libreria.buscarCategoriaPorNombre("viajes")));
        libreria.addLibro(new Libro("El futuro es ahora", libreria.buscarCategoriaPorNombre("tecnología")));
        libreria.addLibro(new Libro("Historia del arte", libreria.buscarCategoriaPorNombre("arte")));

    }

    private static void agregarClientesALibreria(Libreria libreria) {
        libreria.addCliente(new Cliente("Juan", 25, 1.75));
        libreria.addCliente(new Cliente("María", 30, 1.65));
        libreria.addCliente(new Cliente("Pedro", 20, 1.80));
        libreria.addCliente(new Cliente("Antonio", 20, 1.60));
        libreria.addCliente(new Cliente("Elena", 28, 1.70));
        libreria.addCliente(new Cliente("Lucas", 35, 1.75));
        libreria.addCliente(new Cliente("Sofía", 22, 1.60));
        libreria.addCliente(new Cliente("Miguel", 40, 1.82));
        libreria.addCliente(new Cliente("Laura", 33, 1.68));
        libreria.addCliente(new Cliente("Carlos", 29, 1.77));
        libreria.addCliente(new Cliente("Daniela", 26, 1.63));
        libreria.addCliente(new Cliente("Roberto", 37, 1.85));
    }

}

/* QUE SON LAS CLASES ANÓNIMA */
/*
Características de las Clases Anónimas:

    - No tienen nombre: No se les asigna un nombre de clase explícito.
    - Se instancian en su declaración: Se crean con el operador new seguido de una llamada al constructor de una clase o una interfaz, y luego se implementan los métodos necesarios entre llaves {}.
    - Pueden acceder a variables finales del ámbito externo: Pueden hacer uso de variables locales del método donde se definen, siempre que estas sean efectivamente finales o finales.
    - Uso limitado al ámbito donde se crean: Generalmente se utilizan en el lugar donde se definen y no se pueden instanciar de nuevo en otra parte del código.
*/