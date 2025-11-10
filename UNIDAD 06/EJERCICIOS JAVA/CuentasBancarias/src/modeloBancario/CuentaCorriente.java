package modeloBancario;

public class CuentaCorriente extends Cuenta implements OperacionesBancarias {

    // Atributo de interés fijo (constante)
    protected final double interesFijo = 0.15;

    // Composición: cada CuentaCorriente contiene un objeto HistorialTransacciones
    private HistorialTransacciones historial;

    // Constructor con parámetros
    public CuentaCorriente(int numeroDeCuenta, double saldo, Cliente titular) {
        super(numeroDeCuenta, saldo, titular);
        historial = new HistorialTransacciones(); // Inicia de la composición
    }

    // Implementación del método retirar
    @Override
    public void retirar(double cantidad) {
        // Se permite retirar si hay saldo suficiente
        if (saldo >= cantidad) {
            saldo -= cantidad;
            // Aquí se podría registrar la transacción en HistorialTransacciones
        } else {
            System.out.println("Saldo insuficiente para retirar.");
        }
    }

    // Implementación del método actualizarSaldo
    @Override
    public void actualizarSaldo() {
        // Se actualiza el saldo aplicando el interés fijo
        saldo += saldo * interesFijo;
    }

    // Métodos de la interfaz OperacionesBancarias
    @Override
    public void transferir(double cantidad, Cuenta cuentaDestino) {
        if (saldo >= cantidad) {
            retirar(cantidad);
            cuentaDestino.ingresar(cantidad);
            // Registro en historial
        } else {
            System.out.println("No se pudo realizar la transferencia: saldo insuficiente.");
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
