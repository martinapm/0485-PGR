
package es.foc.ejercicios.unidad05.Objetos;

import java.io.*;

// Clase Asignatura que implementa Serializable
public class Asignatura implements Serializable {
    private static final long serialVersionUID = 1L;

    private int codigo;
    private String nombre;
    private int creditos;

    // Constructor
    public Asignatura(int codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    // Método para imprimir los datos de la asignatura
    public void imprimir() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Créditos: " + creditos);
    }

    // Método para escribir la asignatura en un archivo
    public void escribirAsignatura(String archivo) {
        try (FileOutputStream fos = new FileOutputStream(archivo);
             ObjectOutputStream salida = new ObjectOutputStream(fos)) {
            salida.writeObject(this);
            System.out.println("Asignatura escrita en el archivo " + archivo);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Método para leer una asignatura desde un archivo
    public static Asignatura leerAsignatura(String archivo) {
        try (FileInputStream fis = new FileInputStream(archivo);
             ObjectInputStream entrada = new ObjectInputStream(fis)) {
            Asignatura asignatura = (Asignatura) entrada.readObject();
            System.out.println("Asignatura leída del archivo " + archivo);
            return asignatura;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer del archivo: " + e.getMessage());
            return null;
        }
    }
}
