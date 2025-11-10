package es.foc.ejercicios.unidad05;

import java.io.*;

public class LeerArchivoBytes {
    public static void main(String[] args) {
        // Ruta del archivo a leer
        String nombreArchivo = "prueba.txt";

        // Llamar al método para leer y mostrar el contenido del archivo
        leerArchivo(nombreArchivo);
    }

    public static void leerArchivo(String nombreArchivo) {
        try (FileInputStream fileInput = new FileInputStream(nombreArchivo)) {
            System.out.println("Contenido del archivo:");

            int byteLeido;
            // Leer byte por byte y mostrar el contenido en pantalla
            while ((byteLeido = fileInput.read()) != -1) {
                // Convertir el byte leído a carácter y mostrarlo
                System.out.print((char) byteLeido);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
