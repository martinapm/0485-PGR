/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad05.Objetos.Avanzado;

import java.io.*;
import java.util.ArrayList;

public class CuentaBancaria {
    private double saldo;
    private ArrayList<Transaccion> transacciones = new ArrayList<>();
    private final String archivo = "extracto_bancario.dat";

    public void consignar(double monto) {
        saldo += monto;
        transacciones.add(new Transaccion("Consignación", monto));
        guardarEnArchivo();
    }

    public void retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            transacciones.add(new Transaccion("Retiro", monto));
            guardarEnArchivo();
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }

    public void mostrarExtracto() {
        System.out.println("Saldo actual: " + saldo);
        transacciones.forEach(System.out::println);
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.err.println("Error al guardar extracto: " + e.getMessage());
        }
    }

    public static CuentaBancaria cargarDesdeArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("extracto_bancario.dat"))) {
            return (CuentaBancaria) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Creando nueva cuenta...");
            return new CuentaBancaria();
        }
    }

    public static void main(String[] args) {
        CuentaBancaria cuenta = CuentaBancaria.cargarDesdeArchivo();
        cuenta.consignar(500);
        cuenta.retirar(200);
        cuenta.mostrarExtracto();
    }
}
