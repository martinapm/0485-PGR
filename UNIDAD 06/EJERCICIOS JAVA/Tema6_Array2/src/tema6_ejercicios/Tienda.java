package tema6_ejercicios;

public class Tienda {

    private String nombre;
    private String propietario;
    private String idTributario;
    private Computador[] computadores;
    private int cantidad; // Controla cuántos computadores hay

    public Tienda(String nombre, String propietario, String idTributario, int capacidad) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.idTributario = idTributario;
        this.computadores = new Computador[capacidad];
        this.cantidad = 0;
    }

    public boolean tiendaLlena() {
        return cantidad == computadores.length;
    }

    public boolean tiendaVacia() {
        return cantidad == 0;
    }

    public void agregarComputador(Computador c) {
        if (!tiendaLlena()) {
            computadores[cantidad] = c;
            cantidad++;
        } else {
            System.out.println("La tienda está llena. No se puede agregar más computadores.");
        }
    }

    public void eliminarComputador(String marca) {
        for (int i = 0; i < cantidad; i++) {
            if (computadores[i].getMarca().equalsIgnoreCase(marca)) {
                System.out.println("Computador eliminado: " + computadores[i]);
                for (int j = i; j < cantidad - 1; j++) {
                    computadores[j] = computadores[j + 1];
                }
                computadores[cantidad - 1] = null;
                cantidad--;
                return;
            }
        }
        System.out.println("No se encontró un computador con la marca: " + marca);
    }

    public void buscarComputador(String marca) {
        for (Computador c : computadores) {
            if (c != null && c.getMarca().equalsIgnoreCase(marca)) {
                System.out.println("Computador encontrado: " + c);
                return;
            }
        }
        System.out.println("No se encontró un computador con la marca: " + marca);
    }

    public void listarComputadores() {
        if (tiendaVacia()) {
            System.out.println("La tienda no tiene computadores.");
        } else {
            System.out.println("Lista de computadores en la tienda:");
            for (int i = 0; i < cantidad; i++) {
                System.out.println(computadores[i]);
            }
        }
    }
}
