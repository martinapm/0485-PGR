
package es.foc.ejercicios.unidad05.Objetos;

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
        for (int i = 0; i < notas.size(); i++) {
            System.out.println(notas.get(i));
        }
    }

    public double calcularPromedio() {
        double suma = 0;
        for (int i = 0; i < notas.size(); i++) {
            suma += notas.get(i).getNota();
        }
        return notas.size() > 0 ? suma / notas.size() : 0;
    }

    private void guardarEnArchivo() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(notas);
            oos.close();
        } catch (IOException e) {
            System.err.println("Error al guardar notas: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public void cargarDesdeArchivo() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
            notas = (ArrayList<Nota>) ois.readObject();
            ois.close();
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
