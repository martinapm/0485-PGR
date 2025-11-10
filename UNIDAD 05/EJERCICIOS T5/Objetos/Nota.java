/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad05.Objetos;

import java.io.Serializable;

public class Nota implements Serializable {
    private static final long serialVersionUID = 1L;

    private String asignatura;
    private double nota;

    public Nota(String asignatura, double nota) {
        this.asignatura = asignatura;
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return asignatura + ": " + nota;
    }
}
