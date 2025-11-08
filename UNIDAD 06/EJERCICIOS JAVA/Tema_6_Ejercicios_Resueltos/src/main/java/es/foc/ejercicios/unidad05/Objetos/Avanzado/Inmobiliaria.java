/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad05.Objetos.Avanzado;

import java.io.*;
import java.util.ArrayList;

public class Inmobiliaria {
    private ArrayList<Inmueble> inmuebles = new ArrayList<>();
    private final String archivo = "inmuebles.dat";

    public void agregarInmueble(Inmueble inmueble) {
        inmuebles.add(inmueble);
        guardarEnArchivo();
    }

    public void eliminarInmueble(String direccion) {
        inmuebles.removeIf(inmueble -> inmueble.getDireccion().equals(direccion));
        guardarEnArchivo();
    }

    public void listarInmuebles() {
        inmuebles.forEach(System.out::println);
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(inmuebles);
        } catch (IOException e) {
            System.err.println("Error al guardar en archivo: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void cargarDesdeArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            inmuebles = (ArrayList<Inmueble>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Archivo no encontrado o vacío, creando uno nuevo...");
        }
    }

    public static void main(String[] args) {
        Inmobiliaria inmobiliaria = new Inmobiliaria();
        inmobiliaria.cargarDesdeArchivo();

        // Ejemplo de uso
        inmobiliaria.agregarInmueble(new Inmueble("Calle 123", "Ciudad A", "venta"));
        inmobiliaria.agregarInmueble(new Inmueble("Avenida 45", "Ciudad B", "arriendo"));
        inmobiliaria.listarInmuebles();
        inmobiliaria.eliminarInmueble("Calle 123");
        inmobiliaria.listarInmuebles();
    }
}
