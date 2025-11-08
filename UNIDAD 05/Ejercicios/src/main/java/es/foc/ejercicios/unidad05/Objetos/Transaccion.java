/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad05.Objetos;

import java.io.*;
import java.util.Date;

public class Transaccion implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tipo; // "Consignación" o "Retiro"
    private double monto;
    private Date fecha;

    public Transaccion(String tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = new Date();
    }

    @Override
    public String toString() {
        return fecha + " - " + tipo + ": " + monto;
    }
}
