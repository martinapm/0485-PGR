import java.sql.*;
public class HolaMundoBaseDatos {
    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver"); Connection conn = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/sample" ,"root","pass");

        Statement stmt =  conn.createStatement(); ResultSet rs = stmt.executeQuery(
                "SELECT titulo, precio FROM Libros WHERE precio> 2");

        while (rs.next()) {
            String name = rs.getString("titulo"); float price = rs.getFloat("precio");
            System.out.println(name + "\t" + price);
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}