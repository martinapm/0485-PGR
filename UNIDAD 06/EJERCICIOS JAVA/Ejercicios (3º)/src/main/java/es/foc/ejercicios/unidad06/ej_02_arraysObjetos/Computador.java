package es.foc.ejercicios.unidad06.ej_02_arraysObjetos;

/**
 * Esta clase denominada Computador modela un computador con los
 * atributos marca, cantidad de memoria, características del procesador,
 * sistema operativo y precio.
 */
public class Computador {
    String marca; // Atributo que define la marca del computador
    int cantidadMemoria; /* Atributo que define la cantidad de memoria del computador */
    /* Atributo que define las características del procesador del computador */
    String característicasProcesador;
    String sistemaOperativo; /* Atributo que define el sistema operativo del computador */
    double precio; // Atributo que define el precio del computador

    /**
     * Constructor de la clase Computador
     *
     * @param marca                     Parámetro que define la marca de un computador
     * @param cantidadMemoria           Parámetro que define la cantidad de
     *                                  memoria de un computador
     * @param característicasProcesador Parámetro que define las
     *                                  características del procesador
     * @param sistemaOperativo          Parámetro que define el sistema
     *                                  operativo de un computador
     * @param precio                    Parámetro que define el precio de un computador
     */
    public Computador(String marca, int cantidadMemoria, String
            característicasProcesador, String sistemaOperativo, double precio) {
        this.marca = marca;
        this.cantidadMemoria = cantidadMemoria;
        this.característicasProcesador = característicasProcesador;
        this.sistemaOperativo = sistemaOperativo;
        this.precio = precio;
    }
}