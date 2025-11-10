/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.excepciones;

/**
 *
 * @author Alexis Toledo
 */
public class PruebaExcepcionesII {

    public static void main(String args[]) {
        try {
            String texto = "Programación";
            char caracter = texto.charAt(14);
            System.out.println(caracter);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Indice de string por fuera del límite");
        }

        try {
            int número = Integer.parseInt("Número");
            System.out.println(número);
        } catch (NumberFormatException e) {
            System.out.println("Excepción de formato de número");
        } finally {
            System.out.println("Ingresando al finally");
        }

    }
}
