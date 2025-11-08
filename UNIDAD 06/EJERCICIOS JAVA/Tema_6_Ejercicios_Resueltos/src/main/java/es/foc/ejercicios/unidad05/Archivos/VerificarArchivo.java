/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad05.Archivos;

import java.io.File;
import java.util.Scanner;

public class VerificarArchivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese la ruta del archivo o directorio:");
        String ruta = scanner.nextLine();
        
        // Crear un objeto File con la ruta proporcionada
        File archivo = new File(ruta);
        
        // Verificar si el archivo o directorio existe
        if (archivo.exists()) {
            if (archivo.isFile()) {
                System.out.println("La ruta especificada corresponde a un archivo.");
            } else if (archivo.isDirectory()) {
                System.out.println("La ruta especificada corresponde a un directorio.");
            }
        } else {
            System.out.println("El archivo o directorio no existe.");
        }
        
        scanner.close();
    }
}
