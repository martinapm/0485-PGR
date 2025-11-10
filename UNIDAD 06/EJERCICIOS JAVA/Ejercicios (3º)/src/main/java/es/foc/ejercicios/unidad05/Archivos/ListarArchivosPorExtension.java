/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad05.Archivos;

import java.io.File;
import java.util.Scanner;

public class ListarArchivosPorExtension {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el directorio al usuario
        System.out.print("Ingrese la ruta del directorio: ");
        String rutaDirectorio = scanner.nextLine();

        // Solicitar la extensión al usuario
        System.out.print("Ingrese la extensión de los archivos (por ejemplo, .txt): ");
        String extension = scanner.nextLine();

        // Crear un objeto File para el directorio
        File directorio = new File(rutaDirectorio);

        // Validar si la ruta proporcionada es un directorio
        if (directorio.isDirectory()) {
            // Obtener la lista de archivos que coinciden con la extensión
            File[] archivos = directorio.listFiles((dir, nombre) -> nombre.endsWith(extension));

            // Verificar si hay archivos encontrados
            if (archivos != null && archivos.length > 0) {
                System.out.println("Archivos con la extensión " + extension + ":");
                for (File archivo : archivos) {
                    System.out.println(archivo.getName());
                }
            } else {
                System.out.println("No se encontraron archivos con la extensión " + extension);
            }
        } else {
            System.out.println("La ruta proporcionada no es un directorio válido.");
        }

        scanner.close();
    }
}
