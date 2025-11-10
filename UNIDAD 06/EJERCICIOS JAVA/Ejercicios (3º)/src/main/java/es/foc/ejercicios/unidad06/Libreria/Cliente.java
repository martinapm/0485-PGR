package es.foc.ejercicios.unidad06.Libreria;

import java.util.Comparator;

/**
 *
 * @author PGR - ED
 */
public class Cliente { 
    private String nombre; 
    private int edad; 
    private double altura; 
 
    public Cliente(String nombre, int edad, double altura) { 
        this.nombre = nombre; 
        this.edad = edad; 
        this.altura = altura; 
    } 
 
    public String getNombre() { 
        return nombre; 
    } 
 
    public int getEdad() { 
        return edad; 
    } 
 
    public double getAltura() { 
        return altura; 
    } 
 
    public String toString() { 
        return nombre + " (Edad: " + edad + ", Altura: " + altura + ")"; 
    } 
} 


 