package es.foc.ra09.jdbc;

import es.foc.ra09.modelo.Autor;
import es.foc.ra09.modelo.Libro;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class LibreriaUI {

    private Scanner scanner;

    public LibreriaUI() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Listar todos los libros");
        System.out.println("2. Buscar libros por título");
        System.out.println("3. Buscar libros por precio");
        System.out.println("4. Insertar nuevo libro");
        System.out.println("5. Eliminar libro");
        System.out.println("6. Reducir precio de todos los libros a la mitad");
        System.out.println("7. Insertar nuevo autor");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return pedirEntero();
    }

    public void muestraListadoLibros(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros.");
        } else {
            System.out.println("Listado de libros:");
            for (Libro libro : libros) {
                muestraLibro(libro);
            }
        }
    }

    private void muestraLibro(Libro libro) {
        System.out.println("Título: " + libro.getTitulo());
        System.out.println("Precio: " + libro.getPrecio());
        System.out.print("Autores: ");
        for (Autor autor : libro.getAutores()) {
            System.out.print(autor.getNombre() + ", ");
        }
        System.out.println();
    }

    public String pedirTitulo() {
        System.out.print("Introduzca el título del libro: ");
        return pedirCadena();
    }

    public int pedirPrecio() {
        System.out.print("Introduzca el precio del libro: ");
        return pedirEntero();
    }

    public Libro pedirDatosLibro() {
        System.out.print("Introduzca el título del libro: ");
        String titulo = pedirCadena();
        System.out.print("Introduzca el precio del libro: ");
        int precio = pedirEntero();
        return new Libro(titulo, precio);
    }

    public int pedirNumeroAutores() {
        System.out.print("Introduzca el número de autores: ");
        return pedirEntero();
    }

    public Autor pedirDatosAutor() {
        System.out.print("Introduzca el nombre del autor: ");
        String nombre = pedirCadena();
        System.out.print("Introduzca la nacionalidad del autor: ");
        String nacionalidad = pedirCadena();
        return new Autor(nombre, nacionalidad);
    }
        
    public int pedirIdLibro() {
        System.out.print("Introduzca el ID del libro a eliminar: ");
        return pedirEntero();
    }    
    
    private int pedirEntero() {
        int entero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                entero = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, introduzca un número entero.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }

        scanner.nextLine(); // Consumir la línea vacía
        return entero;
    }

    private String pedirCadena() {
        return scanner.nextLine();
    }
}
