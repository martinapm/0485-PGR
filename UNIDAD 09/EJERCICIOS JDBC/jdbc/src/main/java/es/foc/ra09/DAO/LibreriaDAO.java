package es.foc.ra09.DAO;

import es.foc.ra09.modelo.Autor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import es.foc.ra09.modelo.Libro;

public class LibreriaDAO {

    private Connection connection;

    public LibreriaDAO(Connection connection) {
        this.connection = connection;
    }

    //para cerrar recursos que pudieran estar abiertos
    public void close() {
    }

    public List<Libro> getLibrosTitulo(String titulo) {
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT l.id, l.titulo, l.precio, a.id AS autor_id, a.nombre AS autor_nombre, a.nacionalidad AS autor_nacionalidad "
                + "FROM libro l "
                + "INNER JOIN relacionLibroAutor rla ON l.id = rla.id_libro "
                + "INNER JOIN autor a ON rla.id_autor = a.id "
                + "WHERE l.titulo = '" + titulo + "'";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int libroId = resultSet.getInt("id");
                String libroTitulo = resultSet.getString("titulo");
                int libroPrecio = resultSet.getInt("precio");

                int autorId = resultSet.getInt("autor_id");
                String autorNombre = resultSet.getString("autor_nombre");
                String autorNacionalidad = resultSet.getString("autor_nacionalidad");
                Autor autor = new Autor(autorId, autorNombre, autorNacionalidad);

                Libro libro = new Libro(libroId, libroTitulo, libroPrecio);
                libro.addAutor(autor);
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }

    public List<Libro> getLibrosPrecio(int precio) {
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT l.id, l.titulo, l.precio, a.id AS autor_id, a.nombre AS autor_nombre, a.nacionalidad AS autor_nacionalidad "
                + "FROM libro l "
                + "INNER JOIN relacionLibroAutor rla ON l.id = rla.id_libro "
                + "INNER JOIN autor a ON rla.id_autor = a.id "
                + "WHERE l.precio = " + precio;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int libroId = resultSet.getInt("id");
                String libroTitulo = resultSet.getString("titulo");
                int libroPrecio = resultSet.getInt("precio");

                int autorId = resultSet.getInt("autor_id");
                String autorNombre = resultSet.getString("autor_nombre");
                String autorNacionalidad = resultSet.getString("autor_nacionalidad");
                Autor autor = new Autor(autorId, autorNombre, autorNacionalidad);

                Libro libro = new Libro(libroId, libroTitulo, libroPrecio);
                libro.addAutor(autor);
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }

    public List<Libro> getTodosLibros() {
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT l.id, l.titulo, l.precio, a.id AS autor_id, a.nombre AS autor_nombre, a.nacionalidad AS autor_nacionalidad "
                + "FROM libro l "
                + "INNER JOIN relacionLibroAutor rla ON l.id = rla.id_libro "
                + "INNER JOIN autor a ON rla.id_autor = a.id";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int libroId = resultSet.getInt("id");
                String libroTitulo = resultSet.getString("titulo");
                int libroPrecio = resultSet.getInt("precio");

                int autorId = resultSet.getInt("autor_id");
                String autorNombre = resultSet.getString("autor_nombre");
                String autorNacionalidad = resultSet.getString("autor_nacionalidad");
                Autor autor = new Autor(autorId, autorNombre, autorNacionalidad);

                Libro libro = new Libro(libroId, libroTitulo, libroPrecio);
                libro.addAutor(autor);
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }

    public int insertarAutor(Autor autor) {
        String query = "INSERT INTO autor (nombre, nacionalidad) VALUES ('" + autor.getNombre() + "', '" + autor.getNacionalidad() + "')";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Devuelve un valor negativo en caso de error
    }

    public int insertarLibro(Libro libro) {
        String queryLibro = "INSERT INTO libro (titulo, precio) VALUES ('" + libro.getTitulo() + "', " + libro.getPrecio() + ")";
        String queryRelacionPlantilla = "INSERT INTO relacionLibroAutor (id_libro, id_autor) VALUES (%d, %d)";

        try {
            connection.setAutoCommit(false);

            int libroId = -1;
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(queryLibro, Statement.RETURN_GENERATED_KEYS);

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    libroId = generatedKeys.getInt(1);
                }

                if (libroId != -1) {
                    for (Autor autor : libro.getAutores()) {
                        String queryRelacion = String.format(queryRelacionPlantilla, libroId, autor.getId());
                        statement.executeUpdate(queryRelacion);
                    }
                }
            }

            connection.commit();
            return libroId;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1; // Devuelve un valor negativo en caso de error
    }
    
}
