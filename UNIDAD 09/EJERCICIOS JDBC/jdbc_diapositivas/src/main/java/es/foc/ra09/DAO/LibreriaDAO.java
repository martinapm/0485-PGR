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

    public void close() {
        //método para cerrar recursos que se usen en esta clase!!!
    }

    /** EJERCICIO 3 */    
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

    /** EJERCICIO 3 */    
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

    /** EJERCICIO 3 */    
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

    /** EJERCICIO 4 **/
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

    /** EJERCICIO 4 CON TRANSACCIONES (EJERCICIO 7) **/
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

    /** EJERCICIO 5 CON TRANSACCIONES (EJERCICIO 6) */
    public boolean eliminarLibro(int libroId) {
        String queryRelacion = "DELETE FROM relacionLibroAutor WHERE id_libro = ?";
        String queryLibro = "DELETE FROM libro WHERE id = ?";
        
        //try with resources
        try ( PreparedStatement statementRelacion = connection.prepareStatement(queryRelacion); 
              PreparedStatement statementLibro = connection.prepareStatement(queryLibro)
             ) {            
            connection.setAutoCommit(false);

            statementRelacion.setInt(1, libroId);
            statementRelacion.executeUpdate();

            statementLibro.setInt(1, libroId);
            int rowsAffected = statementLibro.executeUpdate();

            connection.commit();
            return rowsAffected > 0;
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
        return false;
    }

    /* EJERCICIO 8 */
    public void reducirPrecioLibrosMitad() {
        String query = "SELECT id, precio FROM libro";
        try (Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int precioActual = resultSet.getInt("precio");
                int nuevoPrecio = precioActual / 2;
                resultSet.updateInt("precio", nuevoPrecio);
                resultSet.updateRow();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
    
    /** EJERCICIO 8. FUNCIONALIDAD EXTRA */
    public int insertarAutorConResultSet(Autor autor) {
        String query = "SELECT * FROM autor WHERE id = -1"; // Consulta que no devuelve resultados
        try (Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.moveToInsertRow();
            resultSet.updateString("nombre", autor.getNombre());
            resultSet.updateString("nacionalidad", autor.getNacionalidad());
            resultSet.insertRow();
            resultSet.moveToCurrentRow();

            // Obtener el ID del autor recién insertado
            ResultSet generatedKeys = statement.executeQuery("SELECT LAST_INSERT_ID()");
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Devuelve un valor negativo en caso de error
    }    
    
}
