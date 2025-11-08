package modeloBancario;

public abstract class Cuenta {

// Atributos protegidos
    protected int numeroDeCuenta;
    protected double saldo;
    protected Cliente titular;

    // Constructor sin parámetros: inicializa cadenas a null y números a 0
    public Cuenta() {
        this.numeroDeCuenta = 0;
        this.saldo = 0;
        this.titular = null;
    }

    // Constructor con parámetros: inicializa cada atributo
    public Cuenta(int numeroDeCuenta, double saldo, Cliente titular) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.saldo = saldo;
        this.titular = titular;
    }

    // Métodos getter
    public int getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    // Métodos setter
    public void setNumeroDeCuenta(int numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    // Método para ingresar dinero
    public void ingresar(double cantidad) {
        this.saldo += cantidad;
    }

    // Método abstracto para retirar dinero
    public abstract void retirar(double cantidad);

    // Método abstracto para actualizar el saldo según el intereses
    public abstract void actualizarSaldo();
}
