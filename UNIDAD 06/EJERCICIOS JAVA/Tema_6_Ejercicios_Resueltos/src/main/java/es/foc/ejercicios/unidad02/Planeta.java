package es.foc.ejercicios.unidad02;

/**
 * Clase que modela el concepto de un planeta del sistema solar
 */
public class Planeta {

    // Enumeración para el tipo de planeta
    public enum TipoPlaneta {
        GASEOSO, TERRESTRE, ENANO
    }

    // Atributos de la clase Planeta
    private String nombre = null;
    private int cantidadSatelites = 0;
    private double masa = 0.0; // En kilogramos
    private double volumen = 0.0; // En kilómetros cúbicos
    private int diametro = 0; // En kilómetros
    private int distanciaMediaSol = 0; // En millones de kilómetros
    private TipoPlaneta tipoPlaneta = null;
    private boolean observableSimpleVista = false;

    // Constructor para inicializar los valores de los atributos
    public Planeta(String nombre, int cantidadSatelites, double masa, double volumen, int diametro,
                   int distanciaMediaSol, TipoPlaneta tipoPlaneta, boolean observableSimpleVista) {
        this.nombre = nombre;
        this.cantidadSatelites = cantidadSatelites;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.distanciaMediaSol = distanciaMediaSol;
        this.tipoPlaneta = tipoPlaneta;
        this.observableSimpleVista = observableSimpleVista;
    }

    // Método para imprimir los valores de los atributos de un planeta
    public void imprimirInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad de Satélites: " + cantidadSatelites);
        System.out.println("Masa (kg): " + masa);
        System.out.println("Volumen (km³): " + volumen);
        System.out.println("Diámetro (km): " + diametro);
        System.out.println("Distancia Media al Sol (millones de km): " + distanciaMediaSol);
        System.out.println("Tipo de Planeta: " + tipoPlaneta);
        System.out.println("Observable a Simple Vista: " + observableSimpleVista);
    }

    // Método para calcular la densidad de un planeta
    public double calcularDensidad() {
        if (volumen == 0) {
            return 0; // Evitar división por cero
        }
        return masa / volumen;
    }

    // Método para determinar si el planeta es exterior
    public boolean esPlanetaExterior() {
        final double UA = 149597870; // 1 UA en kilómetros
        double distanciaEnUA = (distanciaMediaSol * 1_000_000) / UA; // Convertir distancia a UA
        return distanciaEnUA > 3.4;
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        // Crear dos objetos Planeta
        Planeta tierra = new Planeta(
                "Tierra", 1, 5.972E24, 1.08321E12, 12742, 149, TipoPlaneta.TERRESTRE, true);

        Planeta jupiter = new Planeta(
                "Júpiter", 79, 1.898E27, 1.43128E15, 139820, 778, TipoPlaneta.GASEOSO, true);

        // Mostrar información de los planetas
        System.out.println("Información del Planeta 1:");
        tierra.imprimirInformacion();
        System.out.println("Densidad: " + tierra.calcularDensidad() + " kg/km³");
        System.out.println("¿Es un planeta exterior?: " + tierra.esPlanetaExterior());
        System.out.println();

        System.out.println("Información del Planeta 2:");
        jupiter.imprimirInformacion();
        System.out.println("Densidad: " + jupiter.calcularDensidad() + " kg/km³");
        System.out.println("¿Es un planeta exterior?: " + jupiter.esPlanetaExterior());
    }
}
