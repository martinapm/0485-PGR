package modeloBancario;
import java.util.ArrayList;
import java.util.List;

public class HistorialTransacciones {
    private List<String> transacciones;

    public HistorialTransacciones() {
        transacciones = new ArrayList<>();
    }

    public void agregarTransaccion(String transaccion) {
        transacciones.add(transaccion);
    }

    public List<String> getTransacciones() {
        return transacciones;
    }
}

