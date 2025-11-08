package Archivos;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Clase EscribirArchivo: responsable de escribir en un archivo de texto.
 */
public class EscribirArchivoUTF8 {

    public static void main(String[] args) {
        // Nombre del archivo
        String nombreArchivo = "prueba.txt";
        
        // Cantidad de líneas a escribir en el archivo
        int numeroLineas = 5; // Puedes ajustar este valor según sea necesario
        
        // Crear una instancia de la clase para escribir el archivo
        EscribirArchivoUTF8 escribirArchivo = new EscribirArchivoUTF8();
        escribirArchivo.escribirEnArchivo(nombreArchivo, numeroLineas);
    }

    /**
     * Método para escribir en un archivo de texto utilizando OutputStreamWriter con UTF-8.
     *
     * @param nombreArchivo Nombre del archivo a crear o escribir.
     * @param numeroLineas Número de líneas a escribir en el archivo.
     */
    public void escribirEnArchivo(String nombreArchivo, int numeroLineas) {
        try {
            // Crear un objeto OutputStreamWriter con codificación UTF-8
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                new FileOutputStream(nombreArchivo), "UTF-8"
            );
            
            // Crear un objeto PrintWriter que depende de OutputStreamWriter
            PrintWriter printWriter = new PrintWriter(outputStreamWriter);
            
            // Escribir líneas en el archivo
            for (int i = 1; i <= numeroLineas; i++) {
                printWriter.println("Línea " + i); // Ahora soporta caracteres especiales
            }
            
            // Cerrar los flujos
            printWriter.close();

            System.out.println("Archivo escrito exitosamente: " + nombreArchivo);

        } catch (IOException e) {
            // Manejo de errores de entrada/salida
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
