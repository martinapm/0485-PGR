/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.graficos.Hotel;

/**
 * Esta clase denominada Habitación define una habitación de un hotel a ser
 * ocupada y desocupada por un huésped.
 *
 * @version 1.2/2020
 */
public class Habitacion {

    private int numeroHabitacion;
    /* Atributo que indica el número de la habitación */
    private boolean disponible;
    /* Atributo que indica la disponibilidad de la habitación */
    private double precioDia;
    /* Atributo que indica el precio por día de la habitación */
    private Huesped huesped;

    /* Atributo que indica el huésped que ocupa la habitación */
    /**
     * Constructor de la clase Habitación
     *
     * @param númeroHabitación Parámetro que define el número de la habitación
     * @param disponible Parámetro que define la disponibilidad de la habitación
     * @param precioDía Parámetro que define el precio por día de la habitación
     */
    public Habitacion(int numeroHabitacion, boolean disponible,
            double precioDia) {
        this.numeroHabitacion = numeroHabitacion;
        this.disponible = disponible;
        this.precioDia = precioDia;
    }

    /**
     * Método que obtiene el número de habitación
     *
     * @return El número de habitación
     */
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    /**
     * Método que obtiene la disponibilidad de la habitación
     *
     * @return La disponibilidad de la habitación
     */
    public boolean getDisponible() {
        return disponible;
    }

    /**
     * Método que obtiene el precio por día de la habitación
     *
     * @return El precio por día de la habitación
     */
    public double getPrecioDia() {
        return precioDia;
    }

    /**
     * Método que obtiene el huésped de la habitación
     *
     * * @return El huésped de la habitación
     */
    public Huesped getHuesped() {
        return huesped;
    }

    /**
     * Método que establece el huésped de la habitación
     *
     * @param Parámetro que define el huésped de la habitación
     */
    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    /**
     * Método que establece la disponibilidad de la habitación
     *
     * @param Parámetro que define la disponibilidad de la habitación
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
