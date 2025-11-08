package es.foc.ejercicios.unidad03;

import java.util.Scanner;

public class EjerciciosBloque1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Ejercicios ---");
            System.out.println("1. Mayor, menor y repeticiones de N números");
            System.out.println("2. Identificar números negativos y máximo de 10 números");
            System.out.println("3. Determinar cuántos dígitos tiene un número");
            System.out.println("4. Comprobar si un número es capicúa");
            System.out.println("5. Mostrar la tabla de multiplicar de un número");
            System.out.println("6. Sumar números hasta ingresar un valor menor o igual a cero");
            System.out.println("7. Invertir las cifras de un número");
            System.out.println("8. Dibujar cuadrados de lado 2 hasta N");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> ejercicio1(scanner);
                case 2 -> ejercicio2(scanner);
                case 3 -> ejercicio3(scanner);
                case 4 -> ejercicio4(scanner);
                case 5 -> ejercicio5(scanner);
                case 6 -> ejercicio6(scanner);
                case 7 -> ejercicio7(scanner);
                case 8 -> ejercicio8(scanner);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    // Ejercicio 1
    public static void ejercicio1(Scanner scanner) {
        System.out.print("Introduce la cantidad N: ");
        int n = scanner.nextInt();
        int[] numeros = new int[n];
        int mayor = Integer.MIN_VALUE, menor = Integer.MAX_VALUE;
        int contadorMayor = 0, contadorMenor = 0;

        System.out.println("Introduce " + n + " números:");
        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt();
            if (numeros[i] > mayor) {
                mayor = numeros[i];
                contadorMayor = 1;
            } else if (numeros[i] == mayor) {
                contadorMayor++;
            }
            if (numeros[i] < menor) {
                menor = numeros[i];
                contadorMenor = 1;
            } else if (numeros[i] == menor) {
                contadorMenor++;
            }
        }

        System.out.println("Mayor: " + mayor + " (aparece " + contadorMayor + " veces)");
        System.out.println("Menor: " + menor + " (aparece " + contadorMenor + " veces)");
    }

    // Ejercicio 2
    public static void ejercicio2(Scanner scanner) {
        int[] numeros = new int[10];
        int maximo = Integer.MIN_VALUE;
        boolean hayNegativos = false;

        System.out.println("Introduce 10 números:");
        for (int i = 0; i < 10; i++) {
            numeros[i] = scanner.nextInt();
            if (numeros[i] < 0) {
                hayNegativos = true;
            }
            if (numeros[i] > maximo) {
                maximo = numeros[i];
            }
        }

        if (hayNegativos) {
            System.out.println("Se ha introducido al menos un número negativo.");
        } else {
            System.out.println("No se han introducido números negativos.");
        }
        System.out.println("El valor máximo es: " + maximo);
    }

    // Ejercicio 3
    public static void ejercicio3(Scanner scanner) {
        System.out.print("Introduce un número: ");
        int numero = scanner.nextInt();
        int digitos = 0;

        if (numero == 0) {
            digitos = 1;
        } else {
            while (numero != 0) {
                numero /= 10;
                digitos++;
            }
        }

        System.out.println("El número tiene " + digitos + " dígitos.");
    }

    // Ejercicio 4
    public static void ejercicio4(Scanner scanner) {
        System.out.print("Introduce un número: ");
        int numero = scanner.nextInt();
        int ultimo = numero % 10;
        int primero = numero;

        while (primero >= 10) {
            primero /= 10;
        }

        if (primero == ultimo) {
            System.out.println("El número es capicúa.");
        } else {
            System.out.println("El número no es capicúa.");
        }
    }

    // Ejercicio 5
    public static void ejercicio5(Scanner scanner) {
        System.out.print("Introduce un número del 1 al 10: ");
        int numero = scanner.nextInt();

        if (numero < 1 || numero > 10) {
            System.out.println("Número fuera de rango.");
            return;
        }

        System.out.println("Tabla de multiplicar del " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }

    // Ejercicio 6
    public static void ejercicio6(Scanner scanner) {
        int suma = 0;
        int numero;

        System.out.println("Introduce números (se detendrá al ingresar un número menor o igual a 0):");
        while ((numero = scanner.nextInt()) > 0) {
            suma += numero;
        }

        System.out.println("La suma total es: " + suma);
    }

    // Ejercicio 7
    public static void ejercicio7(Scanner scanner) {
        System.out.print("Introduce un número: ");
        int numero = scanner.nextInt();
        int invertido = 0;

        while (numero != 0) {
            int digito = numero % 10;
            invertido = invertido * 10 + digito;
            numero /= 10;
        }

        System.out.println("El número invertido es: " + invertido);
    }

    // Ejercicio 8
    public static void ejercicio8(Scanner scanner) {
        System.out.print("Introduce el valor de N: ");
        int n = scanner.nextInt();

        for (int lado = 2; lado <= n; lado++) {
            char caracter = (char) ('0' + lado);
            for (int i = 0; i < lado; i++) {
                for (int j = 0; j < lado; j++) {
                    System.out.print(caracter + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
