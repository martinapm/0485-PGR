package tema6_ejercicios;

public class Computador {

    private String marca;
    private int memoria; // en GB
    private String procesador;
    private String sistemaOperativo;
    private double precio;

    public Computador(String marca, int memoria, String procesador, String sistemaOperativo, double precio) {
        this.marca = marca;
        this.memoria = memoria;
        this.procesador = procesador;
        this.sistemaOperativo = sistemaOperativo;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public String toString() {
        return "Marca: " + marca + ", Memoria: " + memoria + "GB, Procesador: " + procesador
                + ", SO: " + sistemaOperativo + ", Precio: $" + precio;
    }
}
