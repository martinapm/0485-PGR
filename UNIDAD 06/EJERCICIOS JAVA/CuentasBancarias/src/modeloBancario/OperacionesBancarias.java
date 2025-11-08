package modeloBancario;

public interface OperacionesBancarias {
    // Método para transferir dinero a otra cuenta
    void transferir(double cantidad, Cuenta cuentaDestino);
    
    // Método para depositar dinero
    void depositar(double cantidad);
    
    // Método para consultar el saldo actual
    double consultarSaldo();
}
