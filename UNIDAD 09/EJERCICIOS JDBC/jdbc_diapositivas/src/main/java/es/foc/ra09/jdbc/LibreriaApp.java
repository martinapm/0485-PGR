package es.foc.ra09.jdbc;

import es.foc.ra09.DAO.LibreriaDAO;
import es.foc.ra09.modelo.Libro;
import es.foc.ra09.modelo.Autor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class LibreriaApp {

    private LibreriaUI ui;
    private LibreriaDAO dao;
    private Connection connection = null;
    
    public LibreriaApp() {        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/biblioteca", "biblioteca", "biblioteca");
            this.dao = new LibreriaDAO(connection);
            this.ui = new LibreriaUI();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        LibreriaApp app = new LibreriaApp();
        app.iniciar();      
        app.terminar(); // Aquí sí se cierra
    }
    
    public void iniciar() {
        int opcion;
        do {
            opcion = ui.mostrarMenu();
            switch (opcion) {
                case 1:
                    listarTodosLibros();
                    break;
                case 2:
                    buscarLibrosTitulo();
                    break;
                case 3:
                    buscarLibrosPrecio();
                    break;
                case 4:
                    insertarNuevoLibro();
                    break;
                case 5:
                    eliminarLibro();
                    break;
                case 6:
                    reducirPrecioLibros();
                    break;
                case 7:
                    insertarNuevoAutor();
                    break;
                case 0:
                    break;
            }
        } while (opcion != 0);
    }

    public void terminar() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close(); // Aquí se cierra la conexión al final
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
    
    public void buscarLibrosTitulo() {
        String titulo = ui.pedirTitulo();
        List<Libro> libros = dao.getLibrosTitulo(titulo);
        ui.muestraListadoLibros(libros);
    }

    public void buscarLibrosPrecio() {
        int precio = ui.pedirPrecio();
        List<Libro> libros = dao.getLibrosPrecio(precio);
        ui.muestraListadoLibros(libros);
    }

    public void listarTodosLibros() {
        List<Libro> libros = dao.getTodosLibros();
        ui.muestraListadoLibros(libros);
    }

    public void insertarNuevoLibro() {
        Libro libro = ui.pedirDatosLibro();
        int numAutores = ui.pedirNumeroAutores();
        for (int i = 0; i < numAutores; i++) {
            Autor autor = ui.pedirDatosAutor();
            int autorId = dao.insertarAutor(autor);
            if (autorId != -1) {
                autor.setId(autorId);
                libro.addAutor(autor);
            }
        }
        int libroId = dao.insertarLibro(libro);
        if (libroId != -1) {
            System.out.println("Libro y autores insertados correctamente.");
        } else {
            System.out.println("Error al insertar el libro y sus autores.");
        }
    }

    public void eliminarLibro() {
        int libroId = ui.pedirIdLibro();
        boolean exito = dao.eliminarLibro(libroId);
        if (exito) {
            System.out.println("Libro eliminado correctamente.");
        } else {
            System.out.println("Error al eliminar el libro.");
        }
    }

    public void reducirPrecioLibros() {
        dao.reducirPrecioLibrosMitad();
        System.out.println("El precio de todos los libros ha sido reducido a la mitad.");
    }

    public void insertarNuevoAutor() {
        Autor autor = ui.pedirDatosAutor();
        int autorId = dao.insertarAutorConResultSet(autor);
        if (autorId != -1) {
            System.out.println("Autor insertado correctamente con ID: " + autorId);
        } else {
            System.out.println("Error al insertar el autor.");
        }
    }    
    
}
