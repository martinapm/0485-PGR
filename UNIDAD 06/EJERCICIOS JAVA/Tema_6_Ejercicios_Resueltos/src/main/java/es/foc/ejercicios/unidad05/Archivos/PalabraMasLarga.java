/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad05.Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PalabraMasLarga {
    public static void main(String[] args) {
        // Ruta del archivo de texto
        String filePath = "ruta/del/archivo.txt";

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            String longestWord = "";

            // Leer cada línea del archivo
            while (scanner.hasNext()) {
                String word = scanner.next();

                // Actualizar la palabra más larga si la palabra actual es más larga
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }

            scanner.close();

            // Mostrar la palabra más larga
            System.out.println("La palabra más larga es: " + longestWord);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }
}
