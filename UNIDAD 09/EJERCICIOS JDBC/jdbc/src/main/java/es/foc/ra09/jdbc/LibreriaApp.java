package es.foc.ra09.jdbc;

import es.foc.ra09.DAO.LibreriaDAO;
import es.foc.ra09.modelo.Libro;
import es.foc.ra09.modelo.Autor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class LibreriaApp {

    LibreriaUI ui;
    LibreriaDAO dao;
    Connection connection = null;

    static public void main(String[] args){
            LibreriaApp app = new LibreriaApp();
            app.iniciar();   
            app.terminar();
    }
    
    public LibreriaApp() {

        try {
            // Aquí se realiza la conexión a la base de datos
            // Esto es solo un ejemplo, debes configurar la conexión según tu entorno
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/sample", "root", "foc");
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

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 0:
                    break;
            }
        } while (opcion != 0);
    }

    public void terminar(){
        try {
            if (connection != null) {
                connection.close();
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

   
}
