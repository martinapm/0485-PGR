/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad05.Archivos;

import java.io.File;

public class LeerDirectorio {
    public static void main(String[] args) {
        // Especifica el directorio que deseas listar
        String rutaDirectorio = "C:\\Users\\Usuario\\Documents"; // Cambia esta ruta según tu sistema

        // Crear un objeto File para el directorio
        File directorio = new File(rutaDirectorio);

        // Verificar si el objeto representa un directorio válido
        if (directorio.exists() && directorio.isDirectory()) {
            // Obtener la lista de archivos y directorios dentro del directorio especificado
            String[] contenido = directorio.list();

            // Verificar si el directorio no está vacío
            if (contenido != null && contenido.length > 0) {
                System.out.println("Contenido del directorio: " + rutaDirectorio);
                for (String elemento : contenido) {
                    System.out.println(elemento);
                }
            } else {
                System.out.println("El directorio está vacío.");
            }
        } else {
            System.out.println("La ruta especificada no es un directorio válido.");
        }
    }
}