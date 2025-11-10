/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.excepciones;

import es.foc.ejercicios.excepciones.util.CalculosNumericos;
import java.util.Scanner;

/**
 *
 * @author Alexis Toledo
 */
public class MultiplesCatch {

    /**
     * Método main que solicita un valor numérico por teclado. Para dicho valor
     * se calcula el logaritmo neperiano y la raíz cuadrada. Si el valor
     * ingresado no es correcto, se generan las excepciones correspondientes.
     */
    public static void main(String args[]) {
        System.out.print("Valor numérico = ");
        Scanner teclado = new Scanner(System.in);
        double valor = teclado.nextDouble();
        
        // Ejemplo de cálculo de logaritmo neperiano
        CalculosNumericos.calcularLogaritmoNeperiano(10);
        CalculosNumericos.calcularLogaritmoNeperiano(-5); // Excepción

        // Ejemplo de cálculo de raíz cuadrada
        CalculosNumericos.calcularRaizCuadrada(16);
        CalculosNumericos.calcularRaizCuadrada(-4); // Excepción
        
        // Ejemplo de cálculo de pendiente de una recta
        CalculosNumericos.calcularPendiente(1, 2, 3, 6);
        CalculosNumericos.calcularPendiente(1, 2, 1, 6); // Excepción (división por cero)

        // Ejemplo de cálculo de punto medio de una recta
        CalculosNumericos.calcularPuntoMedio(1, 2, 3, 4);

        
        // Ejemplo 1: Convertir 255 a base 2
        char[] binario = CalculosNumericos.convertirBaseConArray(255, 2);
        System.out.println("255 en base 2: " + new String(binario));  // Resultado: 11111111

        // Ejemplo 2: Convertir 255 a base 16
        char[] hexadecimal = CalculosNumericos.convertirBaseConArray(255, 16);
        System.out.println("255 en base 16: " + new String(hexadecimal));  // Resultado: FF

        // Ejemplo 3: Convertir 255 a base 36
        char[] base36 = CalculosNumericos.convertirBaseConArray(255, 36);
        System.out.println("255 en base 36: " + new String(base36));  // Resultado: 73

        // Ejemplo 4: Convertir -255 a base 10
        char[] negativo = CalculosNumericos.convertirBaseConArray(-255, 10);
        System.out.println("-255 en base 10: " + new String(negativo));  // Resultado: -255

        // Ejemplo 5: Convertir 0 a base 10
        char[] cero = CalculosNumericos.convertirBaseConArray(0, 10);
        System.out.println("0 en base 10: " + new String(cero));  // Resultado: 0

        // Ejemplo 6: Convertir 12345 a base 5
        char[] base5 = CalculosNumericos.convertirBaseConArray(12345, 5);
        System.out.println("12345 en base 5: " + new String(base5));  // Resultado: 144220

        // Ejemplo 7: Convertir -12345 a base 2
        char[] base2Negativo = CalculosNumericos.convertirBaseConArray(-12345, 2);
        System.out.println("-12345 en base 2: " + new String(base2Negativo));  // Resultado: -11000000111001        
        

        // Ejemplo 8: Convertir -12345 a base 40
        char[] base2NegativoEx = CalculosNumericos.convertirBaseConArray(-12345, 2);
        System.out.println("-12345 en base 2: " + new String(base2Negativo));  // Excepcion >36

        
    }
}
