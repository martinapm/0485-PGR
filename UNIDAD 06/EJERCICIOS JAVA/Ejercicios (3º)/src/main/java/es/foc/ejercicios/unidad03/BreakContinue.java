
package es.foc.ejercicios.unidad03;

public class BreakContinue {

    public static void main(String[] args) {
        System.out.println("Ejecutando con bucle while:");
        int i = 1; // Inicialización del contador

        while (i <= 50) {
            // Si el número es divisible por 3, omitirlo
            if (i % 3 == 0) {
                i++; // Incrementar el contador antes de continuar
                continue;
            }
            // Si el número es mayor que 40, detener el bucle
            if (i > 40) {
                System.out.println("Se usó break al encontrar el número: " + i);
                break;
            }
            // Si el número es par, omitirlo. Nota adicional.
            if (i % 2 == 0) {
                i++; // Incrementar el contador antes de continuar
                continue;
            }
            // Imprimir el número
            System.out.println(i);

            i++; // Incrementar el contador
        }
    }

}
