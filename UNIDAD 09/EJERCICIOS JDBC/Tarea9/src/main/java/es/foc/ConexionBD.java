package es.foc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // URL actualizada para MariaDB
    private static final String URL = "jdbc:mariadb://localhost:3306/78003602E?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "foc"; // Contraseña actualizada

    private static Connection conexion = null;
    private static boolean driverCargado = false;

    public static Connection obtenerConexion() throws SQLException {
        if (!driverCargado) {
            try {
                // Controlador de MariaDB
                Class.forName("org.mariadb.jdbc.Driver");
                driverCargado = true;
                System.out.println("Driver JDBC cargado correctamente");
            } catch (ClassNotFoundException e) {
                System.err.println("Error al cargar el driver: " + e.getMessage());
                throw new SQLException("Error al cargar el driver JDBC", e);
            }
        }

        if (conexion == null || conexion.isClosed()) {
            try {
                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                System.out.println("Conexión establecida con éxito");
            } catch (SQLException e) {
                System.err.println("Error de conexión a la BD: " + e.getMessage());
                throw e;
            }
        }
        return conexion;
    }

    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            } finally {
                conexion = null;
            }
        }
    }
}