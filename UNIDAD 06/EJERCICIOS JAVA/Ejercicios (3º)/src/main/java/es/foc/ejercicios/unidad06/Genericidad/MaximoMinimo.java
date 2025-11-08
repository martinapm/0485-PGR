package es.foc.ejercicios.unidad06.Genericidad;

public class MaximoMinimo {

    /**
     * Método estático que extiende la interfaz Comparable que permite obtener
     * el mayor de dos valores sin importar su tipo
     *
     * @return Un valor genérico con el resultado del máximo de la comparación
     */
    public static <E extends Comparable<E>> E maximo(E x, E y) {
        // Compara x con y
        if (y.compareTo(x) > 0) {
            /* Si el resultado es mayor que cero, y es el elemento mayor */
            return y;
        } else {
            /* Si el resultado es menor o igual que cero, x es el elemento mayor */
            return x;
        }
    }

    /**
     * Método estático que extiende la interfaz Comparable que permite obtener
     * el menor de dos valores sin importar su tipo
     *
     * @return Un valor genérico con el resultado del mínimo de la comparación
     */
    public static <E extends Comparable<E>> E minimo(E x, E y) {
        // Compara x con y
        if (y.compareTo(x) < 0) {
            /* Si el resultado es menor que cero, y es el elemento menor */
            return y;
        } else {
            /* Si el resultado es menor o igual que cero, x es el elemento menor */
            return x;
        }
    }

    /**
     * Método main para probar los métodos genéricos para obtener el máximo y
     * mínimo de dos valores.
     */
    public static void main(String args[]) {
        // Obtiene el mayor de dos enteros
        System.out.printf("Máximo entre %d y %d es %d\n", 10, 20, maximo(10, 20));
        // Obtiene el mayor de dos float
        System.out.printf("Máximo entre %.2f y %.2f es %.2f\n", 12.56, 28.71, maximo(12.56, 28.71));
        // Obtiene el mayor de dos String
        System.out.printf("Máximo entre %s y %s es %s\n\n", "Tablet", "Computador", maximo("Tablet", "Computador"));
        // Obtiene el menor de dos enteros
        System.out.printf("Mínimo entre %d y %d es %d\n", 10, 20, minimo(10, 20));
        // Obtiene el menor de dos float
        System.out.printf("Mínimo entre %.2f y %.2f es %.2f\n", 12.56,28.71, minimo(12.56, 28.71));
        // Obtiene el menor de dos String
        System.out.printf("Mínimo entre %s y %s es %s\n", "Tablet", "Computador", minimo("Tableta", "Computador"));
        
        
        Persona persona1 = new Persona("Francisco", 25);
        Persona persona2 = new Persona("Manuel", 28);
        Persona persona3 = new Persona("Jose", 28);
        
        System.out.printf("Máximo entre %s y %s es %s\n",persona1.toString(), persona2.toString(), maximo(persona1,persona2));
        System.out.printf("Máximo entre %s y %s es %s\n",persona1.toString(), persona3.toString(), maximo(persona1,persona3));
        System.out.printf("Máximo entre %s y %s es %s\n",persona2.toString(), persona3.toString(), maximo(persona2,persona3));
        
        System.out.printf("Mínimo entre %s y %s es %s\n",persona1.toString(), persona2.toString(), minimo(persona1,persona2));
        System.out.printf("Mínimo entre %s y %s es %s\n",persona1.toString(), persona3.toString(), minimo(persona1,persona3));
        System.out.printf("Mínimo entre %s y %s es %s\n",persona2.toString(), persona3.toString(), minimo(persona2,persona3));

        
    }
}
