
package es.foc.ejercicios.unidad03;



import java.util.Scanner;

public class EjercicioBloque3Ampliacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Dibujos Geométricos ---");
            System.out.println("1. Cuadrado sin relleno alternando dígitos");
            System.out.println("2. Cruz con carácter");
            System.out.println("3. Paralelogramo con carácter");
            System.out.println("4. Cuadrado con patrón diagonal");
            System.out.println("5. Cuadrado con patrón de reflejo diagonal");
            System.out.println("6. Cuadrado con patrón reflejado");
            System.out.println("7. Cuadrado con patrón simétrico");
            System.out.println("8. Rombo relleno con carácter");
            System.out.println("9. Rombo sin relleno con carácter");
            System.out.println("10. Rombo con patrón numérico (ascendente-descendente)");
            System.out.println("11. Rombo con patrón numérico (reflejado)");
            System.out.println("12. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> dibujarCuadradoAlternado(sc);
                case 2 -> dibujarCruz(sc);
                case 3 -> dibujarParalelogramo(sc);
                case 4 -> dibujarCuadradoPatronDiagonal(sc);
                case 5 -> dibujarCuadradoPatronReflejoDiagonal(sc);
                case 6 -> dibujarCuadradoReflejado(sc);
                case 7 -> dibujarCuadradoSimetrico(sc);
                case 8 -> dibujarRomboRelleno(sc);
                case 9 -> dibujarRomboSinRelleno(sc);
                case 10 -> dibujarRomboPatronNumerico(sc);
                case 11 -> dibujarRomboPatronReflejado(sc);
                case 12 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida, intenta nuevamente.");
            }
        } while (opcion != 12);

        sc.close();
    }

    // Métodos para cada opción

    private static void dibujarCuadradoAlternado(Scanner sc) {
        System.out.print("Introduce el tamaño N del cuadrado: ");
        int N = sc.nextInt();
        System.out.print("Introduce el primer dígito: ");
        int d1 = sc.nextInt();
        System.out.print("Introduce el segundo dígito: ");
        int d2 = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                    System.out.print((j % 2 == 0 ? d1 : d2) + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private static void dibujarCruz(Scanner sc) {
        System.out.print("Introduce la altura N de la cruz (impar): ");
        int N = sc.nextInt();
        System.out.print("Introduce el carácter C: ");
        char C = sc.next().charAt(0);

        if (N % 2 == 0) {
            System.out.println("La altura debe ser impar.");
            return;
        }

        int mitad = N / 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == mitad || i == mitad) {
                    System.out.print(C + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private static void dibujarParalelogramo(Scanner sc) {
        System.out.print("Introduce la base del paralelogramo: ");
        int base = sc.nextInt();
        System.out.print("Introduce la altura del paralelogramo: ");
        int altura = sc.nextInt();
        System.out.print("Introduce el carácter C: ");
        char C = sc.next().charAt(0);

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < base; j++) {
                System.out.print(C + " ");
            }
            System.out.println();
        }
    }

    private static void dibujarCuadradoPatronDiagonal(Scanner sc) {
        System.out.print("Introduce el tamaño N del cuadrado: ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(Math.max(i + 1, j + 1) + " ");
            }
            System.out.println();
        }
    }

    private static void dibujarCuadradoPatronReflejoDiagonal(Scanner sc) {
        System.out.print("Introduce el tamaño N del cuadrado: ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = Math.min(Math.min(i + 1, j + 1), Math.min(N - i, N - j));
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void dibujarCuadradoReflejado(Scanner sc) {
        System.out.print("Introduce el tamaño N del cuadrado: ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((N - Math.abs(i - j)) + " ");
            }
            System.out.println();
        }
    }

    private static void dibujarCuadradoSimetrico(Scanner sc) {
        System.out.print("Introduce el tamaño N del cuadrado: ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = Math.min(Math.min(i + 1, j + 1), Math.min(N - i, N - j));
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void dibujarRomboRelleno(Scanner sc) {
        System.out.print("Introduce la altura N del rombo (impar): ");
        int N = sc.nextInt();
        System.out.print("Introduce el carácter C: ");
        char C = sc.next().charAt(0);

        int mitad = N / 2;
        for (int i = 0; i < N; i++) {
            int espacios = Math.abs(mitad - i);
            int caracteres = N - 2 * espacios;

            for (int j = 0; j < espacios; j++) System.out.print("  ");
            for (int j = 0; j < caracteres; j++) System.out.print(C + " ");
            System.out.println();
        }
    }

    private static void dibujarRomboSinRelleno(Scanner sc) {
        System.out.print("Introduce la altura N del rombo (impar): ");
        int N = sc.nextInt();
        System.out.print("Introduce el carácter C: ");
        char C = sc.next().charAt(0);

        int mitad = N / 2;
        for (int i = 0; i < N; i++) {
            int espacios = Math.abs(mitad - i);
            int caracteres = N - 2 * espacios;

            for (int j = 0; j < espacios; j++) System.out.print("  ");
            for (int j = 0; j < caracteres; j++) {
                if (j == 0 || j == caracteres - 1) System.out.print(C + " ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    private static void dibujarRomboPatronNumerico(Scanner sc) {
        System.out.print("Introduce la altura N del rombo (impar): ");
        int N = sc.nextInt();

        int mitad = N / 2;
        for (int i = 0; i < N; i++) {
            int espacios = Math.abs(mitad - i);
            int limite = N - 2 * espacios;

            for (int j = 0; j < espacios; j++) System.out.print("  ");
            for (int j = 1; j <= limite / 2 + 1; j++) System.out.print(j + " ");
            for (int j = limite / 2; j >= 1; j--) System.out.print(j + " ");
            System.out.println();
        }
    }

    private static void dibujarRomboPatronReflejado(Scanner sc) {
        System.out.print("Introduce la altura N del rombo (impar): ");
        int N = sc.nextInt();

        int mitad = N / 2;
        for (int i = 0; i < N; i++) {
            int espacios = Math.abs(mitad - i);
            int limite = N - 2 * espacios;

            for (int j = 0; j < espacios; j++) System.out.print("  ");
            for (int j = limite / 2; j >= 1; j--) System.out.print(j + " ");
            for (int j = 2; j <= limite / 2 + 1; j++) System.out.print(j + " ");
            System.out.println();
        }
    }
}

