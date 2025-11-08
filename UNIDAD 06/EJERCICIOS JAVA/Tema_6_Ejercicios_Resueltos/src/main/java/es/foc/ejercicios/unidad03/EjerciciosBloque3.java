
package es.foc.ejercicios.unidad03;

import java.util.Scanner;

public class EjerciciosBloque3 {

public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Figuras con Asteriscos ---");
            System.out.println("1. Dibujar un cuadrado relleno");
            System.out.println("2. Dibujar un cuadrado sin relleno");
            System.out.println("3. Dibujar un rectángulo relleno");
            System.out.println("4. Dibujar un rectángulo sin relleno");
            System.out.println("5. Dibujar un triángulo rectángulo relleno");
            System.out.println("6. Dibujar un triángulo rectángulo sin relleno");
            System.out.println("7. Dibujar un triángulo equilátero relleno");
            System.out.println("8. Dibujar un triángulo equilátero sin relleno");
            System.out.println("9. Dibujar un triángulo invertido relleno");
            System.out.println("10. Dibujar un triángulo invertido sin relleno");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> cuadradoRelleno(scanner);
                case 2 -> cuadradoSinRelleno(scanner);
                case 3 -> rectanguloRelleno(scanner);
                case 4 -> rectanguloSinRelleno(scanner);
                case 5 -> trianguloRectanguloRelleno(scanner);
                case 6 -> trianguloRectanguloSinRelleno(scanner);
                case 7 -> trianguloEquilateroRelleno(scanner);
                case 8 -> trianguloEquilateroSinRelleno(scanner);
                case 9 -> trianguloInvertidoRelleno(scanner);
                case 10 -> trianguloInvertidoSinRelleno(scanner);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    // 1. Cuadrado relleno
    public static void cuadradoRelleno(Scanner scanner) {
        System.out.print("Introduce el lado del cuadrado: ");
        int lado = scanner.nextInt();

        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 2. Cuadrado sin relleno
    public static void cuadradoSinRelleno(Scanner scanner) {
        System.out.print("Introduce el lado del cuadrado: ");
        int lado = scanner.nextInt();

        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {
                if (i == 0 || i == lado - 1 || j == 0 || j == lado - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // 3. Rectángulo relleno
    public static void rectanguloRelleno(Scanner scanner) {
        System.out.print("Introduce la base del rectángulo: ");
        int base = scanner.nextInt();
        System.out.print("Introduce la altura del rectángulo: ");
        int altura = scanner.nextInt();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 4. Rectángulo sin relleno
    public static void rectanguloSinRelleno(Scanner scanner) {
        System.out.print("Introduce la base del rectángulo: ");
        int base = scanner.nextInt();
        System.out.print("Introduce la altura del rectángulo: ");
        int altura = scanner.nextInt();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                if (i == 0 || i == altura - 1 || j == 0 || j == base - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // 5. Triángulo rectángulo relleno
    public static void trianguloRectanguloRelleno(Scanner scanner) {
        System.out.print("Introduce la altura del triángulo: ");
        int altura = scanner.nextInt();

        for (int i = 1; i <= altura; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 6. Triángulo rectángulo sin relleno
    public static void trianguloRectanguloSinRelleno(Scanner scanner) {
        System.out.print("Introduce la altura del triángulo: ");
        int altura = scanner.nextInt();

        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i || i == altura) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // 7. Triángulo equilátero relleno
    public static void trianguloEquilateroRelleno(Scanner scanner) {
        System.out.print("Introduce la altura del triángulo: ");
        int altura = scanner.nextInt();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < altura - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 8. Triángulo equilátero sin relleno
    public static void trianguloEquilateroSinRelleno(Scanner scanner) {
        System.out.print("Introduce la altura del triángulo: ");
        int altura = scanner.nextInt();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < altura - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                if (j == 0 || j == 2 * i || i == altura - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    
    // 9. Triángulo invertido relleno
    public static void trianguloInvertidoRelleno(Scanner scanner) {
        System.out.print("Introduce la altura del triángulo: ");
        int altura = scanner.nextInt();
        System.out.print("Introduce el carácter para el dibujo: ");
        String caracter = scanner.next();

        for (int i = altura; i > 0; i--) {
            for (int j = 0; j < altura - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print(caracter);
            }
            System.out.println();
        }
    }

    // 10. Triángulo invertido sin relleno
    public static void trianguloInvertidoSinRelleno(Scanner scanner) {
        System.out.print("Introduce la altura del triángulo: ");
        int altura = scanner.nextInt();
        System.out.print("Introduce el carácter para el dibujo: ");
        String caracter = scanner.next();
        System.out.print("Introduce el grosor del borde (1 o 2): ");
        int grosor = scanner.nextInt();

        for (int i = altura; i > 0; i--) {
            for (int j = 0; j < altura - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                if (j < grosor || j >= 2 * i - 1 - grosor || i == altura || i == 1) {
                    System.out.print(caracter);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }    
    
}
