/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.excepciones.util;

/**
 * Esta clase denominada EquipoMaratónProgramación modela un equipo de
 * programadores que participará en una maratón de programación. Un equipo
 * cuenta con un nombre, la universidad a la que pertenece, el lenguaje de
 * programación que utilizará en la competición, el tamaño del equipo y un array
 * de programadores.
 */
public class EquipoMaratonProgramacion {

    /* Atributo que define el nombre el equipo de la maratón de programación */
    String nombreEquipo;
    /* Atributo que define el nombre de la universidad a la que pertenece el equipo de la maratón de programación */
    String universidad;
    /* Atributo que define el lenguaje de programación utilizado por el equipo de la maratón de programación */
    String lenguajeProgramación;
    /* Atributo que define los programadores que conforman el equipo de la maratón de programación */
    Programador[] programadores;
    /* Atributo que define el tamaño del equipo de la maratón de programación */
    int tamañoEquipo;

    /**
     * Constructor de la clase EquipoMaratónProgramación
     *
     * @param nombreEquipo Parámetro que define el nombre del equipo de la
     * maratón de programación
     * @param universidad Parámetro que define la universidad a la que pertenece
     * el equipo de la maratón de programación
     * @param lenguajeProgramación Parámetro que define el lenguaje de
     * programación que utilizará el equipo de la maratón de programación
     */
    public EquipoMaratonProgramacion(String nombreEquipo, String universidad, String lenguajeProgramación) {
        this.nombreEquipo = nombreEquipo;
        this.universidad = this.universidad;
        this.lenguajeProgramación = this.lenguajeProgramación;
        this.programadores = this.programadores;
        tamañoEquipo = 0; // El tamaño del equipo inicialmente es cero
        programadores = new Programador[3];
        /* Crea un array con tres programadores */
    }

    /**
     * Método que determina si el array de programadores del equipo está lleno o
     * no
     *
     * @return Valor boolean que determina si el array de programadores está
     * lleno o no
     */
    public boolean estáLleno() {
        return tamañoEquipo == programadores.length;
    }

    /**
     * Método que permite añadir un programador al array de programadores
     *
     * @param programador Parámetro que define el programador a agregar al array
     * de programadores
     * @throws Exception Excepción que indica que el equipo de programación está
     * completo
     */
    public void añadir(Programador programador) throws Exception {
        if (estáLleno()) {
            /* Si el array está lleno, se genera la excepción correspondiente */
            throw new Exception("El equipo está completo. No se pudo agregar programador.");
        }
        // Se asigna el programador al array de programadores
        programadores[tamañoEquipo] = programador;
        tamañoEquipo++; // Se incrementa el tamaño del equipo
    }

    /**
     * Método que permite validar un campo evaluando si el campo no tiene
     * dígitos y su longitud no debe ser superior a 20 caracteres. Si no cumple
     * estos criterios, se generan las excepciones correspondientes
     *
     * @param campo Parámetro que define el campo a validar
     * @throws Exception Excepción que indica que el nombre ingresado no puede
     * tener dígitos o que la longitud no debe ser superior a 20 caracteres
     */
    public static void validarCampo(String campo) throws Exception {
        for (int j = 0; j < campo.length(); j++) {
            char c = campo.charAt(j);
            if (Character.isDigit(c)) {
                /* Si el caracter es un dígito se genera la excepción correspondiente */
                throw new Exception("El nombre no puede tener dígitos.");
            }
        }
        /* Si la longitud del campo es mayor que 20 caracateres, se genera una excepción */
        if (campo.length() > 20) {
            throw new Exception("La longitud no debe ser superior a 20 caracteres.");
        }
    }
}
