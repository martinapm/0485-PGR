/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad05.Objetos;

import java.io.*;

public class Inmueble implements Serializable {
    private static final long serialVersionUID = 1L;

    private String direccion;
    private String ciudad;
    private String tipo; // "arriendo" o "venta"

    public Inmueble(String direccion, String ciudad, String tipo) {
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Dirección: " + direccion + ", Ciudad: " + ciudad + ", Tipo: " + tipo;
    }
}
