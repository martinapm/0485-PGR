package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {

    public void crearTablaSiNoExiste() {
        String sql = "CREATE TABLE IF NOT EXISTS Departamentos (" +
                "codigo INT PRIMARY KEY," +
                "nombre VARCHAR(50)," +
                "id_localizacion INT," +
                "id_manager INT" +
                ")";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabla Departamentos creada o ya existente");

        } catch (SQLException e) {
            System.err.println("Error al crear la tabla: " + e.getMessage());
        }
    }

    public boolean insertar(Departamento departamento) {
        String sql = "INSERT INTO Departamentos (codigo, nombre, id_localizacion, id_manager) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, departamento.getCodigo());
            pstmt.setString(2, departamento.getNombre());
            pstmt.setInt(3, departamento.getIdLocalizacion());
            pstmt.setInt(4, departamento.getIdManager());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar departamento: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Departamento departamento) {
        String sql = "UPDATE Departamentos SET nombre = ?, id_localizacion = ?, id_manager = ? WHERE codigo = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, departamento.getNombre());
            pstmt.setInt(2, departamento.getIdLocalizacion());
            pstmt.setInt(3, departamento.getIdManager());
            pstmt.setInt(4, departamento.getCodigo());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar departamento: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int codigo) {
        String sql = "DELETE FROM Departamentos WHERE codigo = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, codigo);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar departamento: " + e.getMessage());
            return false;
        }
    }

    public Departamento buscarPorCodigo(int codigo) {
        String sql = "SELECT * FROM Departamentos WHERE codigo = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, codigo);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Departamento dep = new Departamento();
                    dep.setCodigo(rs.getInt("codigo"));
                    dep.setNombre(rs.getString("nombre"));
                    dep.setIdLocalizacion(rs.getInt("id_localizacion"));
                    dep.setIdManager(rs.getInt("id_manager"));
                    return dep;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar departamento por código: " + e.getMessage());
        }

        return null;
    }

    public List<Departamento> buscarPorNombre(String nombre) {
        List<Departamento> departamentos = new ArrayList<>();
        String sql = "SELECT * FROM Departamentos WHERE nombre LIKE ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + nombre + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Departamento dep = new Departamento();
                    dep.setCodigo(rs.getInt("codigo"));
                    dep.setNombre(rs.getString("nombre"));
                    dep.setIdLocalizacion(rs.getInt("id_localizacion"));
                    dep.setIdManager(rs.getInt("id_manager"));
                    departamentos.add(dep);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar departamentos por nombre: " + e.getMessage());
        }

        return departamentos;
    }

    public List<Departamento> obtenerTodos() {
        List<Departamento> departamentos = new ArrayList<>();
        String sql = "SELECT * FROM Departamentos";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Departamento dep = new Departamento();
                dep.setCodigo(rs.getInt("codigo"));
                dep.setNombre(rs.getString("nombre"));
                dep.setIdLocalizacion(rs.getInt("id_localizacion"));
                dep.setIdManager(rs.getInt("id_manager"));
                departamentos.add(dep);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los departamentos: " + e.getMessage());
        }

        return departamentos;
    }
}