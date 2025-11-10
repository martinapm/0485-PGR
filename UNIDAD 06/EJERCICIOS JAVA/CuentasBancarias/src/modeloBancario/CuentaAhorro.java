package modeloBancario;

public class CuentaAhorro extends Cuenta implements OperacionesBancarias {

    // Atributos propios de CuentaAhorro
    protected double interesVariable;
    protected double saldoMinimo;

    // Composición: cada CuentaCorriente contiene un objeto HistorialTransacciones
    private HistorialTransacciones historial;

    // Constructor con parámetros
    public CuentaAhorro(int numeroDeCuenta, double saldo, Cliente titular, double interesVariable, double saldoMinimo) {
        super(numeroDeCuenta, saldo, titular);
        this.interesVariable = interesVariable;
        this.saldoMinimo = saldoMinimo;
        historial = new HistorialTransacciones(); // Inicia de la composición
    }

    // Implementación del método retirar
    @Override
    public void retirar(double cantidad) {
        // Solo permite retirar si tras la operación el saldo es mayor o igual que el saldo mínimo
        if (saldo - cantidad >= saldoMinimo) {
            saldo -= cantidad;
            // Registro en historial
        } else {
            System.out.println("No se puede retirar, se alcanzaría por debajo del saldo mínimo.");
        }
    }

    // Implementación del método actualizarSaldo
    @Override
    public void actualizarSaldo() {
        // Se actualiza el saldo aplicando el interés variable
        saldo += saldo * interesVariable;
    }

    // Métodos de la interfaz OperacionesBancarias
    @Override
    public void transferir(double cantidad, Cuenta cuentaDestino) {
        if (saldo - cantidad >= saldoMinimo) {
            retirar(cantidad);
            cuentaDestino.ingresar(cantidad);
            // Registro en historial
        } else {
            System.out.println("Transferencia no realizada: saldo insuficiente tras mantener el saldo mínimo.");
        }
    }

    @Override
    public void depositar(double cantidad) {
        ingresar(cantidad);
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }
    // Método para obtener el historial de transacciones

    public HistorialTransacciones getHistorial() {
        return historial;
    }
}
