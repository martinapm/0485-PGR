package es.foc.ejercicios.excepciones.util;

import java.util.InputMismatchException;

/**
 * Esta clase denominada CálculosNuméricos permite realizar dos cálculos
 * matemáticos: calcular el logaritmo neperiano de un valor y calcular la raíz
 * cuadrada de un valor.
 */
public class CalculosNumericos {

    /**
     * Método que calcula el logaritmo neperiano de un valor numérico. Si el
     * valor pasado como parámetro no es correcto se genera la excepción
     * correspondiente
     *
     * @param valor Parámetro que define el valor al cual se le calculará el
     * logaritmo neperiano
     * @throws ArithmeticException Excepción aritmética que indica que el número
     * debe ser positivo
     * @throws InputMismatchException Excepción que indica que el valor
     * ingresado debe ser numérico
     */
    public static void calcularLogaritmoNeperiano(double valor) {
        try {
            if (valor < 0) {
                // Si el valor es negativo, se genera una excepción aritmética
                throw new ArithmeticException("El valor debe ser un número positivo");
            }
            // Si el valor es positivo, se calcula el algoritmo neperiano
            double resultado = Math.log(valor);
            System.out.println("Resultado = " + resultado);
        } catch (ArithmeticException e) {
            /* Si ocurre una excepción aritmética, se muestra un mensaje de error */
            System.out.println("El valor debe ser un número positivo para calcular el logaritmo");
        } catch (InputMismatchException e) {
            /* Si el valor a calcular no es numérico, se muestra un mensaje de error */
            System.out.println("El valor debe ser numérico para calcular el logaritmo");
        }
    }

    /**
     * Método que calcula la raíz cuadrada de un valor numérico. Si el valor
     * pasado como parámetro no es correcto se genera la excepción
     * correspondiente
     *
     * @param valor Parámetro que define el valor al cual se le calculará la
     * raíz cuadrada
     * @throws ArithmeticException Excepción aritmética que indica que el número
     * debe ser positivo
     * @throws InputMismatchException Excepción que indica que el valor
     * ingresado debe ser numérico
     */
    public static void calcularRaizCuadrada(double valor) {
        try {
            if (valor < 0) {
                // Si el valor es negativo, se genera una excepción aritmética
                throw new ArithmeticException("El valor debe ser un número positivo");
            }
            double resultado = Math.sqrt(valor);
            /* Si el valor es positivo,se calcula la raíz cuadrada */
            System.out.println("Resultado = " + resultado);
        } catch (ArithmeticException e) {
            /* Si ocurre una excepción aritmética, se muestra un mensaje de error */
            System.out.println("El valor debe ser un número positivo para calcular la raíz cuadrada");
        } catch (InputMismatchException e) {
            /* Si el valor a calcular no es numérico, se muestra un mensaje de error */
            System.out.println("El valor debe ser numérico para calcular la raíz cuadrada");
        }
    }

    /**
     * Método para calcular la pendiente de una recta dados dos puntos (x1, y1)
     * y (x2, y2).
     *
     * @param x1 Coordenada x del primer punto.
     * @param y1 Coordenada y del primer punto.
     * @param x2 Coordenada x del segundo punto.
     * @param y2 Coordenada y del segundo punto.
     * @throws ArithmeticException Si los puntos tienen la misma coordenada x
     * (división por cero).
     */
    public static void calcularPendiente(double x1, double y1, double x2, double y2) {
        try {
            if (x1 == x2) {
                throw new ArithmeticException("La pendiente no está definida porque x1 = x2 (división por cero)");
            }
            double pendiente = (y2 - y1) / (x2 - x1);
            System.out.println("La pendiente de la recta es: " + pendiente);
        } catch (ArithmeticException e) {
            System.out.println("Error al calcular la pendiente: " + e.getMessage());
        }
    }

    /**
     * Método para calcular el punto medio de una recta dados dos puntos (x1,
     * y1) y (x2, y2).
     *
     * @param x1 Coordenada x del primer punto.
     * @param y1 Coordenada y del primer punto.
     * @param x2 Coordenada x del segundo punto.
     * @param y2 Coordenada y del segundo punto.
     */
    public static void calcularPuntoMedio(double x1, double y1, double x2, double y2) {
        try {
            double puntoMedioX = (x1 + x2) / 2.0;
            double puntoMedioY = (y1 + y2) / 2.0;
            System.out.println("El punto medio de la recta es: (" + puntoMedioX + ", " + puntoMedioY + ")");
        } catch (Exception e) {
            System.out.println("Error al calcular el punto medio: " + e.getMessage());
        }
    }

    /**
     * Método para convertir un número en base 10 a una base b.
     *
     * @param numero Número en base 10.
     * @param base Base de destino (debe ser entre 2 y 36).
     * @throws ArithmeticException Si la base no está entre 2 y 36.
     */
    public static void convertirBase(int numero, int base) {
        try {
            // La base debe estar entre 2 y 36:
            // - Base mínima: 2 (binaria), ya que es la más pequeña que tiene sentido.
            // - Base máxima: 36, ya que utiliza los dígitos 0-9 y las letras A-Z (36 caracteres).
            // Bases mayores a 36 requerirían más símbolos, lo cual no es estándar.            
            if (base < 2 || base > 36) {
                throw new ArithmeticException("La base debe estar entre 2 y 36");
            }
            String resultado = Integer.toString(numero, base);
            System.out.println("El número " + numero + " en base " + base + " es: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error al convertir el número a la base " + base + ": " + e.getMessage());
        }
    }

    /**
     * Método para convertir un número de base 10 a otra base sin usar
     * Integer.toString.
     *
     * @param numero Número en base 10.
     * @param base Base de destino (debe estar entre 2 y 36).
     * @return Representación del número en la nueva base como una cadena.
     * @throws IllegalArgumentException Si la base no está entre 2 y 36.
     */
    public static String convertirBaseManual(int numero, int base) {
        if (base < 2 || base > 36) {
            throw new IllegalArgumentException("La base debe estar entre 2 y 36");
        }

        // Array de caracteres para las bases (0-9, A-Z)
        char[] caracteres = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        // Si el número es 0, directamente devolvemos "0"
        if (numero == 0) {
            return "0";
        }

        StringBuilder resultado = new StringBuilder();
        int numeroAbsoluto = Math.abs(numero);

        // Realizamos el proceso de división y obtenemos los residuos
        while (numeroAbsoluto > 0) {
            int residuo = numeroAbsoluto % base; // Obtenemos el residuo
            resultado.append(caracteres[residuo]); // Agregamos el dígito correspondiente
            numeroAbsoluto /= base; // Dividimos el número
        }

        // Si el número era negativo y la base es 10, añadimos el signo
        if (numero < 0 && base == 10) {
            resultado.append("-");
        }

        // Invertimos el resultado ya que lo generamos en orden inverso
        return resultado.reverse().toString();
    }

    /**
     * Método para convertir un número en base 10 a otra base usando un array.
     * Los dígitos se almacenan en el array desde el inicio y se invierte al
     * final.
     *
     * @param numero Número en base 10 que se desea convertir.
     * @param base Base de destino (debe estar entre 2 y 36).
     * @return Array de caracteres que representa el número en la nueva base.
     * @throws IllegalArgumentException Si la base no está entre 2 y 36.
     */
    public static char[] convertirBaseConArray(int numero, int base) {
        if (base < 2 || base > 36) {
            throw new IllegalArgumentException("La base debe estar entre 2 y 36");
        }

        // Array de caracteres para las bases (0-9, A-Z)
        char[] caracteres = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        // Si el número es 0, devolvemos un array con un solo dígito '0'
        if (numero == 0) {
            return new char[]{'0'};
        }

        int numeroAbsoluto = Math.abs(numero);

        // Creamos un array suficientemente grande para almacenar los dígitos
        char[] resultado = new char[35]; // Espacio máximo necesario para int más signo
        int indice = 0;  // Índice inicial del array

        // Proceso de conversión a la nueva base
        while (numeroAbsoluto > 0) {
            int residuo = numeroAbsoluto % base;         // Obtenemos el residuo
            resultado[indice++] = caracteres[residuo];  // Guardamos el dígito en el array
            numeroAbsoluto /= base;                     // Dividimos el número
        }

        // Si el número era negativo y la base es 10, agregamos el signo '-'
        if (numero < 0 && base == 10) {
            resultado[indice++] = '-';
        }

        // Invertir el array para obtener el resultado en orden correcto
        char[] resultadoFinal = new char[indice];
        for (int i = 0; i < indice; i++) {
            resultadoFinal[i] = resultado[indice - 1 - i];
        }

        return resultadoFinal;
    }

}
