
package es.foc.ejercicios.unidad05.Objetos.Avanzado;

import java.io.*;
import java.time.LocalDateTime;

public class Transaccion implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tipo; // "Consignación" o "Retiro"
    private double monto;
    private LocalDateTime fecha;

    public Transaccion(String tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return fecha + " - " + tipo + ": " + monto;
    }
}
