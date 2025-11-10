
package es.foc.ejercicios.unidad02.figuras;


public class Cuadrado {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double calcularArea() {
        return Math.pow(lado, 2);
    }

    public double calcularPerimetro() {
        return 4 * lado;
    }
}
