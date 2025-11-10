/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad05.Archivos;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Clase EscribirArchivo: responsable de escribir en un archivo de texto.
 */
public class EscribirArchivo {

    public static void main(String[] args) {
        // Nombre del archivo
        String nombreArchivo = "prueba.txt";
        
        // Cantidad de líneas a escribir en el archivo
        int numeroLineas = 5; // Puedes ajustar este valor según sea necesario
        
        // Crear una instancia de la clase para escribir el archivo
        EscribirArchivo escribirArchivo = new EscribirArchivo();
        escribirArchivo.escribirEnArchivo(nombreArchivo, numeroLineas);
    }

    /**
     * Método para escribir en un archivo de texto utilizando FileWriter y PrintWriter.
     *
     * @param nombreArchivo Nombre del archivo a crear o escribir.
     * @param numeroLineas Número de líneas a escribir en el archivo.
     */
    public void escribirEnArchivo(String nombreArchivo, int numeroLineas) {
        try {
            // Crear un objeto FileWriter para manejar el archivo
            FileWriter fileWriter = new FileWriter(nombreArchivo);
            
            // Crear un objeto PrintWriter que depende de FileWriter
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            // Escribir líneas en el archivo
            for (int i = 1; i <= numeroLineas; i++) {
                printWriter.println("Línea " + i);
            }
            
            // Cerrar los flujos
            printWriter.close();
            fileWriter.close();

            System.out.println("Archivo escrito exitosamente: " + nombreArchivo);

        } catch (IOException e) {
            // Manejo de errores de entrada/salida
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
