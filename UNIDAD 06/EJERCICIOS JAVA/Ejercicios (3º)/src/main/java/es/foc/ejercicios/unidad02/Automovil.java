package es.foc.ejercicios.unidad02;

import es.foc.ejercicios.unidad02.automovil.enums.Color;
import es.foc.ejercicios.unidad02.automovil.enums.TipoAutomovil;
import es.foc.ejercicios.unidad02.automovil.enums.TipoCombustible;

/**
 * Clase que modela el concepto de un automóvil
 */
public class Automovil {

    // Atributos de la clase Automovil
    private String marca;
    private int modelo;
    private double motor; // Volumen en litros
    private TipoCombustible tipoCombustible;    
    private TipoAutomovil tipoAutomovil;
    private int numeroPuertas;    
    private int cantidadAsientos;
    private int velocidadMaxima; // En km/h
    private Color color;
    private int velocidadActual = 0; // En km/h

    // Constructor para inicializar los valores de los atributos
    public Automovil(String marca, int modelo, double motor, TipoCombustible tipoCombustible,
            TipoAutomovil tipoAutomovil, int numeroPuertas, int cantidadAsientos,
            int velocidadMaxima, Color color) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.tipoCombustible = tipoCombustible;
        this.tipoAutomovil = tipoAutomovil;
        this.numeroPuertas = numeroPuertas;
        this.cantidadAsientos = cantidadAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.color = color;
    }

    // Métodos get y set para los atributos
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public double getMotor() {
        return motor;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public TipoAutomovil getTipoAutomovil() {
        return tipoAutomovil;
    }

    public void setTipoAutomovil(TipoAutomovil tipoAutomovil) {
        this.tipoAutomovil = tipoAutomovil;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    // Métodos para modificar la velocidad
    public void acelerar(int incremento) {
        if (velocidadActual + incremento > velocidadMaxima) {
            System.out.println("No se puede acelerar más allá de la velocidad máxima permitida.");
        } else {
            velocidadActual += incremento;
            System.out.println("Velocidad actual: " + velocidadActual + " km/h");
        }
    }

    public void desacelerar(int decremento) {
        if (velocidadActual - decremento < 0) {
            System.out.println("No se puede desacelerar a una velocidad negativa.");
        } else {
            velocidadActual -= decremento;
            System.out.println("Velocidad actual: " + velocidadActual + " km/h");
        }
    }

    public void frenar() {
        velocidadActual = 0;
        System.out.println("El automóvil se ha detenido. Velocidad actual: " + velocidadActual + " km/h");
    }

    // Método para calcular el tiempo estimado de llegada
    public double calcularTiempoLlegada(double distancia) {
        if (velocidadActual == 0) {
            System.out.println("El vehículo está detenido. No se puede calcular el tiempo de llegada.");
            return -1;
        }
        return distancia / velocidadActual;
    }

    // Método para mostrar los valores de los atributos
    public void imprimirInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Motor: " + motor + " litros");
        System.out.println("Tipo de Combustible: " + tipoCombustible);
        System.out.println("Tipo de Automóvil: " + tipoAutomovil);
        System.out.println("Número de Puertas: " + numeroPuertas);
        System.out.println("Cantidad de Asientos: " + cantidadAsientos);
        System.out.println("Velocidad Máxima: " + velocidadMaxima + " km/h");
        System.out.println("Color: " + color);
        System.out.println("Velocidad Actual: " + velocidadActual + " km/h");
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        // Crear un automóvil
        Automovil miAuto = new Automovil(
                "Toyota", 2023, 2.0, TipoCombustible.GASOLINA, TipoAutomovil.SUV,
                5, 5, 180, Color.NEGRO);

        // Mostrar información inicial del automóvil
        System.out.println("Información inicial del automóvil:");
        miAuto.imprimirInformacion();
        System.out.println();

        // Colocar velocidad actual en 100 km/h
        miAuto.setVelocidadActual(100);
        System.out.println("Velocidad actual: " + miAuto.getVelocidadActual() + " km/h");

        // Aumentar velocidad en 20 km/h
        System.out.println("Acelerando en 20 km/h:");
        miAuto.acelerar(20);

        // Decrementar velocidad en 50 km/h
        System.out.println("Desacelerando en 50 km/h:");
        miAuto.desacelerar(50);

        // Frenar el automóvil
        System.out.println("Frenando el automóvil:");
        miAuto.frenar();
    }
}
