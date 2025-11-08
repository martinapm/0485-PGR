package es.foc.ejercicios.unidad06.arraysDiapositivas;

import es.foc.utils.Colores;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayEjercicios {


    // Método para contar la cantidad de veces que aparece un número en un array
    public static int contarApariciones(int[] array, int valor) {
        int contador = 0;
        for (int num : array) {
            if (num == valor) {
                contador++;
            }
        }
        return contador;
    }

    // Método para encontrar la cadena más larga en un array de Strings
    public static String cadenaMasLarga(String[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        String masLarga = array[0];
        for (String str : array) {
            if (str.length() > masLarga.length()) {
                masLarga = str;
            }
        }
        return masLarga;
    }

    // Método para encontrar los valores máximos entre dos arrays
    public static int[] maximosEntreArrays(int[] array1, int[] array2) {
        int maxLength = Math.max(array1.length, array2.length);
        int[] maximos = new int[maxLength];

        for (int i = 0; i < maxLength; i++) {
            int valor1 = (i < array1.length) ? array1[i] : Integer.MIN_VALUE;
            int valor2 = (i < array2.length) ? array2[i] : Integer.MIN_VALUE;
            maximos[i] = Math.max(valor1, valor2);
        }

        return maximos;
    }

    // Método para crear una matriz de tamaño n x n
    public static int[][] crearMatriz(int n) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[n][n];

        System.out.println("Ingrese los valores de la matriz de " + n + "x" + n + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        return matriz;
    }

    // Método para imprimir la matriz
    public static void imprimirMatriz(int[][] m) {
        for (int[] fila : m) {
            for (int num : fila) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    // Método para imprimir la diagonal principal de la matriz
    public static void imprimirDiagonal(int[][] m) {
        System.out.println("Diagonal principal:");
        for (int i = 0; i < m.length; i++) {
            System.out.print(m[i][i] + " ");
        }
        System.out.println();
    }

    // Método para imprimir la diagonal invertida de la matriz
    public static void imprimirDiagonalInvertida(int[][] m) {
        System.out.println("Diagonal invertida:");
        for (int i = 0; i < m.length; i++) {
            System.out.print(m[i][m.length - 1 - i] + " ");
        }
        System.out.println();
    }

    // Método para comparar dos matrices y obtener una con los valores máximos
    public static int[][] compararMatrices(int[][] A, int[][] B) {
        if (!sonMatricesIguales(A, B)) {
            System.out.println("Las matrices no tienen el mismo tamaño, no se pueden comparar.");
            return null;
        }

        int[][] M = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                M[i][j] = Math.max(A[i][j], B[i][j]);
            }
        }
        return M;
    }

    // Método para verificar si dos matrices tienen el mismo tamaño
    public static boolean sonMatricesIguales(int[][] A, int[][] B) {
        if (A.length != B.length) return false;
        for (int i = 0; i < A.length; i++) {
            if (A[i].length != B[i].length) return false;
        }
        return true;
    }

    // Método para generar una matriz cuadrada aleatoria
    public static int[][] generarMatrizCuadrada(int tamaño, int maxValor) {
        Random random = new Random();
        int[][] matriz = new int[tamaño][tamaño];
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                matriz[i][j] = random.nextInt(maxValor + 1);
            }
        }
        return matriz;
    }

    // Método para generar una matriz irregular aleatoria
    public static int[][] generarMatrizIrregular(int minFilas, int maxFilas, int minColumnas, int maxColumnas, int maxValor) {
        Random random = new Random();
        int filas = random.nextInt(maxFilas - minFilas + 1) + minFilas;
        int[][] matriz = new int[filas][];

        for (int i = 0; i < filas; i++) {
            int columnas = random.nextInt(maxColumnas - minColumnas + 1) + minColumnas;
            matriz[i] = new int[columnas];
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(maxValor + 1);
            }
        }
        return matriz;
    }

    // Método para obtener los valores máximos por columnas
    public static int[] maximosPorColumnas(int[][] matriz) {
        int columnas = matriz[0].length;
        int[] maximos = new int[columnas];

        for (int j = 0; j < columnas; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < matriz.length; i++) {
                if (j < matriz[i].length && matriz[i][j] > max) {
                    max = matriz[i][j];
                }
            }
            maximos[j] = max;
        }
        return maximos;
    }

    // Método para obtener los valores máximos por filas
    public static int[] maximosPorFilas(int[][] matriz) {
        int[] maximos = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int num : matriz[i]) {
                if (num > max) {
                    max = num;
                }
            }
            maximos[i] = max;
        }
        return maximos;
    }

    // Método para transponer una matriz
    public static int[][] transponerMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] transpuesta = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;
    }
     
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n" + Colores.colorear("Seleccione una opción:", Colores.CIAN));
            System.out.println(Colores.colorear("1.", Colores.VERDE) + " Contar apariciones de un número en un array");
            System.out.println(Colores.colorear("2.", Colores.VERDE) + " Encontrar la cadena más larga en un array de Strings");
            System.out.println(Colores.colorear("3.", Colores.VERDE) + " Encontrar los valores máximos entre dos arrays");
            System.out.println(Colores.colorear("4.", Colores.VERDE) + " Crear y cargar una matriz n x n");
            System.out.println(Colores.colorear("5.", Colores.VERDE) + " Imprimir la diagonal de una matriz");
            System.out.println(Colores.colorear("6.", Colores.VERDE) + " Imprimir la diagonal invertida de una matriz");
            System.out.println(Colores.colorear("7.", Colores.VERDE) + " Comparar dos matrices y obtener una con los valores máximos");
            System.out.println(Colores.colorear("8.", Colores.VERDE) + " Generar una matriz cuadrada aleatoria");
            System.out.println(Colores.colorear("9.", Colores.VERDE) + " Generar una matriz irregular aleatoria");
            System.out.println(Colores.colorear("10.", Colores.VERDE) + " Obtener valores máximos por columnas y filas");
            System.out.println(Colores.colorear("11.", Colores.VERDE) + " Transponer una matriz");
            System.out.println(Colores.colorear("12.", Colores.ROJO) + " Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    int[] numeros = {1, 2, 3, 4, 1, 2, 1, 3, 1};
                    System.out.println("Ingrese el número a buscar:");
                    int valorBuscado = scanner.nextInt();
                    System.out.println(Arrays.toString(numeros)); //metodo de la clase java.util.Arrays.
                    System.out.println("El número " + valorBuscado + " aparece " +
                            contarApariciones(numeros, valorBuscado) + " veces.");
                    break;
                case 2:
                    String[] palabras = {"casa", "automovil", "sol", "bicicleta", "mar"};
                    System.out.println(Arrays.toString(palabras));
                    System.out.println("La palabra más larga es: " + cadenaMasLarga(palabras));
                    break;
                case 3:
                    int[] array1 = {1, 4, 3, 7};
                    int[] array2 = {2, 5, 1};
                    int[] maximos = maximosEntreArrays(array1, array2);
                    System.out.println(Arrays.toString(array1));
                    System.out.println(Arrays.toString(array2));
                    System.out.print("Array de valores máximos: ");
                    for (int num : maximos) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Ingrese el tamaño de la matriz:");
                    int n = scanner.nextInt();
                    int[][] matriz = crearMatriz(n);
                    imprimirMatriz(matriz);
                    break;
                case 5:
                    System.out.println("Ingrese el tamaño de la matriz:");
                    int n1 = scanner.nextInt();
                    int[][] matriz1 = crearMatriz(n1);
                    System.out.println("Matriz:");
                    imprimirMatriz(matriz1);
                    System.out.println("Diagonal:");
                    imprimirDiagonal(matriz1);
                    break;
                case 6:
                    System.out.println("Ingrese el tamaño de la matriz:");
                    int n2 = scanner.nextInt();
                    int[][] matriz2 = crearMatriz(n2);
                    System.out.println("Matriz:");
                    imprimirMatriz(matriz2);
                    System.out.println("Diagonal invertida:");                   
                    imprimirDiagonalInvertida(matriz2);
                    break;
                case 7:
                    System.out.println("Ingrese el tamaño de las matrices:");
                    int n3 = scanner.nextInt();
                    System.out.println("Ingrese los valores de la primera matriz:");
                    int[][] A = crearMatriz(n3);
                    System.out.println("Ingrese los valores de la segunda matriz:");
                    int[][] B = crearMatriz(n3);
                    int[][] M = compararMatrices(A, B);
                    if (M != null) {
                        System.out.println("Matriz1");
                        imprimirMatriz(A);
                        System.out.println("Matriz2");
                        imprimirMatriz(B);
                        System.out.println("Matriz resultante con valores máximos:");
                        imprimirMatriz(M);
                    }
                    break;
                case 8:
                    System.out.println("Ingrese el tamaño de la matriz cuadrada:");
                    int tamaño = scanner.nextInt();
                    System.out.println("Ingrese el valor máximo:");
                    int maxValor = scanner.nextInt();
                    int[][] matrizCuadrada = generarMatrizCuadrada(tamaño, maxValor);
                    imprimirMatriz(matrizCuadrada);
                    break;
                case 9:
                    System.out.println("Ingrese el número mínimo de filas:");
                    int minFilas = scanner.nextInt();
                    System.out.println("Ingrese el número máximo de filas:");
                    int maxFilas = scanner.nextInt();
                    System.out.println("Ingrese el número mínimo de columnas:");
                    int minColumnas = scanner.nextInt();
                    System.out.println("Ingrese el número máximo de columnas:");
                    int maxColumnas = scanner.nextInt();
                    System.out.println("Ingrese el valor máximo:");
                    int maxVal = scanner.nextInt();
                    int[][] matrizIrregular = generarMatrizIrregular(minFilas, maxFilas, minColumnas, maxColumnas, maxVal);
                    imprimirMatriz(matrizIrregular);
                    break;
                case 10:
                    System.out.println("Ingrese el tamaño de la matriz:");
                    int tam = scanner.nextInt();
                    System.out.println("Ingrese el valor máximo:");
                    int maxV = scanner.nextInt();
                    int[][] matrizDatos = generarMatrizCuadrada(tam, maxV);
                    imprimirMatriz(matrizDatos);
                    int[] maxCol = maximosPorColumnas(matrizDatos);
                    int[] maxFil = maximosPorFilas(matrizDatos);
                    System.out.println("Máximos por columna:");
                    for (int max : maxCol) {
                        System.out.print(max + " ");
                    }
                    System.out.println("\nMáximos por fila:");
                    for (int max : maxFil) {
                        System.out.print(max + " ");
                    }
                    System.out.println();
                    break;
                case 11:
                    System.out.println("Ingrese el tamaño de la matriz:");
                    int size = scanner.nextInt();
                    System.out.println("Ingrese el valor máximo:");
                    int maximo = scanner.nextInt();
                    int[][] original = generarMatrizCuadrada(size, maximo);
                    System.out.println("Matriz original:");
                    imprimirMatriz(original);
                    int[][] transpuesta = transponerMatriz(original);
                    System.out.println("Matriz transpuesta:");
                    imprimirMatriz(transpuesta);
                    break;
                case 12:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}

