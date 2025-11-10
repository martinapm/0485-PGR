package es.foc.ejercicios.unidad03;

import java.util.Scanner;

public class EjerciciosBloque3_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal;

        do {
            System.out.println("\n--- Menú de Figuras ---");
            System.out.println("1. Seleccionar figura");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1 -> seleccionarFigura(scanner);
                case 0 -> System.out.println("¡Gracias por usar el programa! ¡Hasta pronto!");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcionPrincipal != 0);

        scanner.close();
    }

    public static void seleccionarFigura(Scanner scanner) {
        System.out.print("\nIntroduce la cantidad de lados de la figura (3, 4 o 5): ");
        int lados = scanner.nextInt();

        if (lados == 3) {
            menuFigurasTriangulos(scanner);
        } else if (lados == 4) {
            menuFigurasCuadrilateros(scanner);
        } else if (lados == 5) {
            menuFigurasPentagonos(scanner);
        } else {
            System.out.println("Solo se admiten figuras con 3, 4 o 5 lados.");
        }
    }

    public static void menuFigurasTriangulos(Scanner scanner) {
        System.out.println("\n--- Figuras de Tres Lados (Triángulos) ---");
        System.out.println("1. Triángulo rectángulo");
        System.out.println("2. Triángulo equilátero");
        System.out.print("Elige una opción: ");
        int opcion = scanner.nextInt();

        boolean relleno = preguntarRelleno(scanner);
        char caracter = relleno ? preguntarCaracterRelleno(scanner) : '*';

        System.out.print("Introduce la altura del triángulo: ");
        int altura = scanner.nextInt();

        if (opcion == 1) {
            if (relleno) {
                dibujarTrianguloRectanguloRelleno(altura, caracter);
            } else {
                dibujarTrianguloRectanguloSinRelleno(altura, caracter);
            }
        } else if (opcion == 2) {
            if (relleno) {
                dibujarTrianguloEquilateroRelleno(altura, caracter);
            } else {
                dibujarTrianguloEquilateroSinRelleno(altura, caracter);
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }

    public static void menuFigurasCuadrilateros(Scanner scanner) {
        System.out.println("\n--- Figuras de Cuatro Lados (Cuadriláteros) ---");
        System.out.println("1. Cuadrado");
        System.out.println("2. Rectángulo");
        System.out.print("Elige una opción: ");
        int opcion = scanner.nextInt();

        boolean relleno = preguntarRelleno(scanner);
        char caracter = relleno ? preguntarCaracterRelleno(scanner) : '*';

        if (opcion == 1) {
            System.out.print("Introduce el lado del cuadrado: ");
            int lado = scanner.nextInt();

            if (relleno) {
                dibujarCuadradoRelleno(lado, caracter);
            } else {
                dibujarCuadradoSinRelleno(lado, caracter);
            }
        } else if (opcion == 2) {
            System.out.print("Introduce la base del rectángulo: ");
            int base = scanner.nextInt();
            System.out.print("Introduce la altura del rectángulo: ");
            int altura = scanner.nextInt();

            if (relleno) {
                dibujarRectanguloRelleno(base, altura, caracter);
            } else {
                dibujarRectanguloSinRelleno(base, altura, caracter);
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }

    public static void menuFigurasPentagonos(Scanner scanner) {
        System.out.println("\n--- Figuras de Cinco Lados (Pentágonos) ---");
        System.out.println("1. Pentágono Regular");
        System.out.print("Elige una opción: ");
        int opcion = scanner.nextInt();

        boolean relleno = preguntarRelleno(scanner);
        char caracter = relleno ? preguntarCaracterRelleno(scanner) : '*';

        if (opcion == 1) {
            System.out.print("Introduce el tamaño del lado del pentágono (altura aproximada): ");
            int altura = scanner.nextInt();

            if (relleno) {
                dibujarPentagonoRelleno(altura, caracter);
            } else {
                dibujarPentagonoSinRelleno(altura, caracter);
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }

    public static boolean preguntarRelleno(Scanner scanner) {
        System.out.print("¿Deseas que la figura tenga relleno? (S/N): ");
        char respuesta = scanner.next().toUpperCase().charAt(0);
        return respuesta == 'S';
    }

    public static char preguntarCaracterRelleno(Scanner scanner) {
        System.out.print("Introduce el carácter para el relleno: ");
        return scanner.next().charAt(0);
    }

    // Métodos para dibujar figuras (reutilizando lógica y adaptando)

    public static void dibujarTrianguloRectanguloRelleno(int altura, char caracter) {
        for (int i = 1; i <= altura; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(caracter + " ");
            }
            System.out.println();
        }
    }

    public static void dibujarTrianguloRectanguloSinRelleno(int altura, char caracter) {
        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i || i == altura) {
                    System.out.print(caracter + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void dibujarTrianguloEquilateroRelleno(int altura, char caracter) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < altura - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(caracter);
            }
            System.out.println();
        }
    }

    public static void dibujarTrianguloEquilateroSinRelleno(int altura, char caracter) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < altura - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                if (j == 0 || j == 2 * i || i == altura - 1) {
                    System.out.print(caracter);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void dibujarCuadradoRelleno(int lado, char caracter) {
        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {
                System.out.print(caracter + " ");
            }
            System.out.println();
        }
    }

    public static void dibujarCuadradoSinRelleno(int lado, char caracter) {
        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {
                if (i == 0 || i == lado - 1 || j == 0 || j == lado - 1) {
                    System.out.print(caracter + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void dibujarRectanguloRelleno(int base, int altura, char caracter) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                System.out.print(caracter + " ");
            }
            System.out.println();
        }
    }

    public static void dibujarRectanguloSinRelleno(int base, int altura, char caracter) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                if (i == 0 || i == altura - 1 || j == 0 || j == base - 1) {
                    System.out.print(caracter + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void dibujarPentagonoRelleno(int altura, char caracter) {
        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= altura - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(caracter);
            }
            System.out.println();
        }
        for (int i = 1; i <= altura; i++) {
            for (int j = 0; j < altura / 2; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= altura + 1; j++) {
                System.out.print(caracter);
            }
            System.out.println();
        }
    }

    public static void dibujarPentagonoSinRelleno(int altura, char caracter) {
        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= altura - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1) {
                    System.out.print(caracter);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 1; i <= altura; i++) {
            for (int j = 0; j < altura / 2; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= altura + 1; j++) {
                if (j == 1 || j == altura + 1) {
                    System.out.print(caracter);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
