package es.foc.ejercicios.unidad06.ej_02_arraysObjetos;

import java.util.ArrayList;

public class Tienda {


    String nombre; /* Atributo que define el nombre de la tienda de computadores */
    String propietario; /* Atributo que define el propietario de la tienda de computadores */
    /* Atributo que define el identificador tributario de la tienda de         computadores */
    int identificadorTributario;
    ArrayList computadores; /* Atributo que define un vector de computadores */

    /**
     * Constructor de la clase Tienda2
     *
     * @param nombre                  Parámetro que define el nombre de la tienda
     * @param propietario             Parámetro que define el nombre del
     *                                propietario de la tienda
     * @param identificadorTributario Parámetro que define un
     *                                identificador tributario para la tienda
     */
    public Tienda(String nombre, String propietario, int identificadorTributario) {
        this.nombre = nombre;
        this.propietario = this.propietario;
        this.identificadorTributario = identificadorTributario;
        computadores = new ArrayList(); // Se crea el vector de computadores
    }

    /**
     * Método que determina si la tienda está llena, es decir, si su vector
     * de computadores completó su tamaño
     *
     * @return Valor booleano que determina si el vector de computadores
     * está lleno
     */
    public boolean tiendaLlena() {
        /* Un vector no tiene un tamaño predefinido, nunca está lleno, devuelve siempre false */
        return false;
    }

    /**
     * Método que determina si la tienda está vacía, es decir, si su vector
     * de computadores no tiene elementos
     *
     * @return Valor booleano que determina si el vector de computadores
     * está vacío
     */
    public boolean tiendaVacío() {
        return computadores.size() == 0; /* El método size determinar el tamaño del vector */
    }

    /**
     * Método que añade un computador a la tienda
     *
     * @param computador Parámetro que define el computador que se
     *                   agregará al vector de computadores de la tienda
     */
    public void anyadir(Computador computador) {
        computadores.add(computador); /* El método add agrega un elemento al vector */
    }

    /**
     * Método que elimina un computador del vector de computadores
     * de la tienda
     *
     * @param marcaComputador Parámetro que define la marca de un
     *                        computador que se eliminará del vector de computadores de la
     *                        tienda
     * @return Valor booleano que determina si un computador se pudo
     * eliminar o no del vector de computadores
     */
    public boolean eliminar(String marcaComputador) {
        int pos = buscar(marcaComputador); /* Busca el computador y devuelve su posición */
        if (pos < 0) { /* Si la posición es menor que cero, no encontró el computador */
            return false;
        }
        // Elimina el elemento que se encuentra en la posición pos
        computadores.remove(pos);
        return true;
    }

    /**
     * Método que busca un determinado computador en el vector de
     * computadores
     *
     * @param marcaComputador Parámetro que define la marca de un
     *                        computador que se buscará en el vector de computadores de la
     *                        tienda
     * @return Valor entero que determina si un computador se encontró
     * o no en el vector de computadores
     */
    public int buscar(String marcaComputador) {
        Computador computador;
        // Se busca el computador en el vector
        for (int i = 0; i < computadores.size(); i++) { /* Se recorre el vector de computadores */
            computador = (Computador) computadores.get(i);
            if (computador.marca.equals(marcaComputador))
                return i; /* Devuelve la posición donde se encontró el computador */
        }
        return -1; // Si no encontró el computador, retorna -1
    }

    /**
     * Método que muestra en pantalla los datos de los computadores de
     * la tienda
     */
    public void imprimir() {
        for (int i = 0; i < computadores.size(); i++) {
            System.out.println("Computador " + i);
            Computador computador = (Computador) computadores.get(i);
            System.out.println("Marca = " + computador.marca);
            System.out.println("Cantidad de memoria = " + computador.cantidadMemoria);
            System.out.println("Características del procesador = " + computador.característicasProcesador);
            System.out.println("Sistema operativo = " + computador.sistemaOperativo);
            System.out.println("Precio = " + computador.precio);
        }
    }
}
