/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad05;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Factura {
    // Atributos de la clase
    private String[] nombresProductos;
    private int[] precios;
    private int[] unidades;

    // Constructor
    public Factura(String[] nombresProductos, int[] precios, int[] unidades) {
        this.nombresProductos = nombresProductos;
        this.precios = precios;
        this.unidades = unidades;
    }

    // Método para escribir la factura en un archivo
    public void escribirFacturaEnArchivo(String rutaArchivo) {
        try {
            // Crear el archivo y el objeto PrintWriter
            FileWriter archivo = new FileWriter(rutaArchivo);
            PrintWriter impresor = new PrintWriter(archivo);

            // Escribir el encabezado de la factura
            impresor.println("---------- FACTURA ----------");
            impresor.printf("%-15s %-10s %-10s %-10s\n", "Producto", "Precio", "Unidades", "Subtotal");
            impresor.println("-------------------------------------------");

            // Calcular y escribir cada línea de la factura
            int total = 0;
            for (int i = 0; i < nombresProductos.length; i++) {
                int subtotal = precios[i] * unidades[i];
                total += subtotal;
                impresor.printf("%-15s %-10d %-10d %-10d\n", nombresProductos[i], precios[i], unidades[i], subtotal);
            }

            // Escribir el total
            impresor.println("-------------------------------------------");
            impresor.printf("%-35s %-10d\n", "TOTAL:", total);

            // Cerrar el archivo
            archivo.close();
            System.out.println("Factura escrita correctamente en el archivo: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        // Ejemplo de datos
        String[] productos = {"Camiseta", "Cuaderno", "Lapicero"};
        int[] precios = {30000, 5000, 10000};
        int[] unidades = {12, 10, 12};

        // Crear la instancia de Factura
        Factura factura = new Factura(productos, precios, unidades);

        // Escribir la factura en un archivo
        String rutaArchivo = "factura.txt"; // Nombre del archivo
        factura.escribirFacturaEnArchivo(rutaArchivo);
    }
}
