/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad05.Objetos.Avanzado;

import java.io.*;
import java.util.ArrayList;

public class PromedioNotas {
    private ArrayList<Nota> notas = new ArrayList<>();
    private final String archivo = "notas_estudiante.dat";

    public void agregarNota(Nota nota) {
        notas.add(nota);
        guardarEnArchivo();
    }

    public void mostrarNotas() {
        notas.forEach(System.out::println);
    }

    public double calcularPromedio() {
        return notas.stream().mapToDouble(Nota::getNota).average().orElse(0);
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(notas);
        } catch (IOException e) {
            System.err.println("Error al guardar notas: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void cargarDesdeArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            notas = (ArrayList<Nota>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Archivo vacío o no encontrado, iniciando nuevo listado.");
        }
    }

    public static void main(String[] args) {
        PromedioNotas promedioNotas = new PromedioNotas();
        promedioNotas.cargarDesdeArchivo();

        promedioNotas.agregarNota(new Nota("Matemáticas", 4.5));
        promedioNotas.agregarNota(new Nota("Programación", 3.8));

        promedioNotas.mostrarNotas();
        System.out.println("Promedio final: " + promedioNotas.calcularPromedio());
    }
}
