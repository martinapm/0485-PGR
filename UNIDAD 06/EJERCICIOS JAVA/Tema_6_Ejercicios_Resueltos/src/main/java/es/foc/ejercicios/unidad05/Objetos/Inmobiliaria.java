/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad05.Objetos;

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
        for (int i = 0; i < inmuebles.size(); i++) {
            if (inmuebles.get(i).getDireccion().equals(direccion)) {
                inmuebles.remove(i);
                break;
            }
        }
        guardarEnArchivo();
    }

    public void listarInmuebles() {
        for (int i = 0; i < inmuebles.size(); i++) {
            System.out.println(inmuebles.get(i));
        }
    }

    private void guardarEnArchivo() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(inmuebles);
            oos.close();
        } catch (IOException e) {
            System.err.println("Error al guardar en archivo: " + e.getMessage());
        }
    }

    public void cargarDesdeArchivo() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
            inmuebles = (ArrayList<Inmueble>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Archivo no encontrado o vacío. Se iniciará un nuevo listado.");
        }
    }

    public static void main(String[] args) {
        Inmobiliaria inmobiliaria = new Inmobiliaria();
        inmobiliaria.cargarDesdeArchivo();

        inmobiliaria.agregarInmueble(new Inmueble("Calle 123", "Ciudad A", "venta"));
        inmobiliaria.agregarInmueble(new Inmueble("Avenida 45", "Ciudad B", "arriendo"));

        inmobiliaria.listarInmuebles();

        inmobiliaria.eliminarInmueble("Calle 123");
        inmobiliaria.listarInmuebles();
    }
}
