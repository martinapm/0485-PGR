package es.foc.ejercicios.unidad05;

import java.io.*;
import java.util.Scanner;

public class LeerArchivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el nombre del archivo por teclado
        System.out.print("Introduce el nombre del archivo (incluyendo su ruta si no está en el mismo directorio): ");
        String nombreArchivo = scanner.nextLine();

        System.out.print("¿Deseas que el contenido se muestre en mayúsculas? (sí/no): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();

        boolean mostrarEnMayusculas = respuesta.equals("sí") || respuesta.equals("si");
        
        
        
        // Llamar al método para mostrar el contenido del archivo en mayúsculas
        mostrarContenidoEnMayusculas(nombreArchivo, mostrarEnMayusculas);

        scanner.close();
    }

    public static void mostrarContenidoEnMayusculas(String nombreArchivo, boolean enMayusculas) {
        try (FileInputStream fileInput = new FileInputStream(nombreArchivo);
             InputStreamReader inputStream = new InputStreamReader(fileInput);
             BufferedReader bufferedReader = new BufferedReader(inputStream)) {

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                if(enMayusculas)
                    System.out.println(linea.toUpperCase());
                else
                    System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
