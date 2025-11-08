package es.foc.ejercicios.unidad06.ej_01_arrays;

/**
 * Esta clase denominada Tienda modela una tienda de computadores
 * con los atributos nombre de la tienda, nombre de su propietario, un
 * identificador tributario, su fabricante y un array de computadores
 *
 */

public class Tienda {
    String nombre; // Atributo que define el nombre de la tienda
    String propietario; // Atributo que define el propietario de la tienda
    int identificadorTributario; /* Atributo que define el identificador tributario de la tienda */
    Computador[] computadores; /* Atributo que define un array de computadores de la tienda */
    /* Atributo que define la cantidad de computadores que tiene la     tienda */
    static int numeroComputadores;

    /**
     * Constructor de la clase Tienda
     *
     * @param nombre                  Parámetro que define el nombre de la tienda
     * @param propietario             Parámetro que define el nombre del
     *                                propietario de la tienda
     * @param identificadorTributario Parámetro que define un
     *                                identificador tributario para la tienda
     * @param tamanyo                 Parámetro que define la cantidad de computadores
     *                                que tiene la tienda
     */

    public Tienda(String nombre, String propietario, int identificadorTributario,
                  int tamanyo) {
        if (tamanyo < 1) { // Si el tamanyo es menor que 1, es insuficiente
            System.out.println("Cantidad de computadores insuficientes.");
        } else {
            this.nombre = nombre;
            this.propietario = this.propietario;
            this.identificadorTributario = identificadorTributario;
            computadores = new Computador[tamanyo]; /* Se crea el array de computadores */
            numeroComputadores = 0;
        }
    }

    /**
     * Método que determina si la tienda está llena, es decir, si su array
     * de computadores completó su tamaño
     *
     * @return Valor booleano que determina si el array de computadores
     * está lleno
     */
    public boolean tiendaLlena() {
        return numeroComputadores == computadores.length;
    }

    /**
     * Método que determina si la tienda está vacía, es decir, si su array
     * de computadores no tiene elementos
     *
     * @return Valor booleano que determina si el array de
     * computadores está vacío
     */
    public boolean tiendaVacía() {
        return numeroComputadores == 0;
    }

    /**
     * Método que añade un computador a la tienda
     *
     * @param computador Parámetro que define el computador que se
     *                   agregará al array de computadores de la tienda
     */
    public void anyadir(Computador computador) {
        // Si la tienda está llena, no se puede agregar el computador
        if (tiendaLlena()) {
            System.out.println("La tienda está llena.No se puede añadir elemento.");
        } else {
            computadores[numeroComputadores] = computador;
            numeroComputadores++; /* Se incrementa el contador de computadores */
        }
    }

    /**
     * Método que elimina un computador del array de computadores de
     * la tienda
     *
     * @param marcaComputador Parámetro que define la marca de un
     *                        computador que se eliminará del array de computadores de la
     *                        tienda
     * @return Valor booleano que determina si un computador se pudo
     * eliminar o no del array de computadores
     */
    public boolean eliminar(String marcaComputador) {
        // Se busca el computador en el array
        int pos = buscar(marcaComputador);
        if (pos < 0) {
            return false; /* Si no encuentra al computador, devuelve un valor boolean con false */
        }
        /* Si el computador se encuentra, se elimina el computador
        de su posición y se mueven las posiciones de los demás
        elementos en el array */
        for (int i = pos; i < numeroComputadores; i++) {
            computadores[i] = computadores[i + 1];
        }
        numeroComputadores--; /* Decrementa la cantidad de computadores */
        return true;
    }

    /**
     * Método que busca un determinado computador en el array de
     * computadores
     *
     * @param marcaComputador Parámetro que define la marca de un
     *                        computador que se buscará en el array de computadores de la
     *                        tienda
     * @return Valor entero que determina si un computador se encontró
     * o no en el array de computadores
     */
    public int buscar(String marcaComputador) {
        for (int i = 0; i < numeroComputadores; i++) { /* Recorre el array de computadores */
            if (computadores[i].marca.equals(marcaComputador))
                // Si se encuentra el computador buscado
                return i; /* Retorna la posición del computador buscado en el array */
        }
        return -1; // Si no encontró el computador en el array
    }

    /**
     * Método que imprime en pantalla los datos del array de
     * computadores de la tienda
     */
    public void imprimir() {
        for (int i = 0; i < numeroComputadores; i++) {
            System.out.println("Computador " + i);
            System.out.println("Marca = " + computadores[i].marca);
            System.out.println("Cantidad de memoria = " + computadores[i].cantidadMemoria);
            System.out.println("Características del procesador = " + computadores[i].característicasProcesador);
            System.out.println("Sistema operativo = " + computadores[i].sistemaOperativo);
            System.out.println("Precio = " + computadores[i].precio);
        }
    }
}