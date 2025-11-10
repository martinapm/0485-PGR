/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.excepciones;

import es.foc.ejercicios.excepciones.util.Vendedor;
import java.util.Scanner;

public class LanzarExcepcion {

    /**
     * Método que solicita por teclado el nombre, apellidos y edad de un
     * vendedor. Luego, se verifica la edad. Si la edad no es correcta, se
     * generan las excepciones correspondientes.
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Nombre del vendedor = ");
        String n = teclado.next();
        System.out.println("Apellidos del vendedor = ");
        String a = teclado.next();
        Vendedor vendedor = new Vendedor(n, a);
        System.out.println("Edad del vendedor = ");
        int e = teclado.nextInt();
        vendedor.verificarEdad(e);
        vendedor.imprimir();
    }    
}
