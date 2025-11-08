package es.foc.ejercicios.unidad06.ej_01_arrays;

import java.util.Scanner;


public class Application {

     /**
     * Método main que crea una tienda de computadores que contiene
     * tres computadores. Luego se solicita ingresar por teclado la marca
     * de un computador a buscar en la tienda
     */
    public static void main(String [] args) {
        Tienda tienda = new Tienda("Tienda Cuántica","Pepito Pérez",123456, 5);
        Computador computador1 = new Computador("Acer", 50, "Intel iCore 7", "Windows", 18500000);
        Computador computador2 = new Computador("Toshiba", 80,
                "Intel iCore 5", "Windows", 15500000);
        Computador computador3 = new Computador("Mac", 100,
                "Intel iCore 7", "Mac", 2500000);
        tienda.anyadir(computador1);
        tienda.anyadir(computador2);
        tienda.anyadir(computador3);
        System.out.println("Introduce la marca del computador a buscar:");
        Scanner sc = new Scanner(System.in);
        String marca = sc.next();
        System.out.println("El computador a buscar: " + marca + " se encuentra en la posición " + tienda.buscar(marca));
        tienda.imprimir();
    }
}