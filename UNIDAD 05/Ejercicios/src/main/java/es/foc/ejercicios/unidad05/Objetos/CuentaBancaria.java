/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad05.Objetos;

import java.io.*;
import java.util.ArrayList;

public class CuentaBancaria {
    private double saldo;
    private ArrayList<Transaccion> transacciones = new ArrayList<>();
    private final String archivo = "extracto_bancario.dat";

    public void consignar(double cantidad) {
        saldo += cantidad;
        transacciones.add(new Transaccion("Consignación", cantidad));
        guardarEnArchivo();
    }

    public void retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            transacciones.add(new Transaccion("Retiro", cantidad));
            guardarEnArchivo();
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }

    public void mostrarExtracto() {
        System.out.println("Saldo actual: " + saldo);
        for (int i = 0; i < transacciones.size(); i++) {
            System.out.println(transacciones.get(i));
        }
    }

    private void guardarEnArchivo() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            System.err.println("Error al guardar extracto: " + e.getMessage());
        }
    }

    public static CuentaBancaria cargarDesdeArchivo() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("extracto_bancario.dat"));
            CuentaBancaria cuenta = (CuentaBancaria) ois.readObject();
            ois.close();
            return cuenta;
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
