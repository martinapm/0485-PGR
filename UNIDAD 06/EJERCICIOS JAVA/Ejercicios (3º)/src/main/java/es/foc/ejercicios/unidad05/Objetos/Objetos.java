/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad05.Objetos;

public class Objetos {
    public static void main(String[] args) {
        // Crear un objeto Asignatura
        Asignatura poo = new Asignatura(4100547, "Programación Orientada a Objetos", 4);

        // Escribir el objeto en un archivo
        String archivo = "asignatura.dat";
        poo.escribirAsignatura(archivo);

        // Leer el objeto desde el archivo
        Asignatura asignaturaLeida = Asignatura.leerAsignatura(archivo);
        if (asignaturaLeida != null) {
            asignaturaLeida.imprimir();
        }
    }
}
