package modeloBancario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.util.*;

public class ModeloBancarioController {

    // Componentes FXML
    @FXML private TextField txtIdCliente, txtNombre, txtDireccion, txtTelefono;
    @FXML private ListView<Cliente> listaClientes;
    @FXML private ComboBox<String> cmbTipoCuenta, cmbOperacion;
    @FXML private TextField txtNumCuenta, txtSaldoInicial, txtCantidad, txtCuentaDestino;
    @FXML private ListView<Cuenta> listaCuentas;
    @FXML private TextArea txtHistorial;

    // Datos
    private final ObservableList<Cliente> clientesObservable = FXCollections.observableArrayList();
    private final ObservableList<Cuenta> cuentasObservable = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configurar ComboBox
        cmbTipoCuenta.getItems().addAll("Ahorro", "Corriente");
        cmbOperacion.getItems().addAll("Depositar", "Retirar", "Transferir");

        // Configurar ListViews
        listaClientes.setItems(clientesObservable);
        listaClientes.setCellFactory(param -> new ListCell<Cliente>() {
            @Override
            protected void updateItem(Cliente cliente, boolean empty) {
                super.updateItem(cliente, empty);
                setText(empty ? null : cliente.getIdCliente() + " - " + cliente.getNombre());
            }
        });

        listaCuentas.setItems(cuentasObservable);
        listaCuentas.setCellFactory(param -> new ListCell<Cuenta>() {
            @Override
            protected void updateItem(Cuenta cuenta, boolean empty) {
                super.updateItem(cuenta, empty);
                if (empty || cuenta == null) {
                    setText(null);
                } else {
                    setText(String.format("%d - %s (%s)",
                            cuenta.getNumeroDeCuenta(),
                            cuenta.getTitular().getNombre(),
                            cuenta.getClass().getSimpleName()));
                }
            }
        });

        // Listener para operaciones
        cmbOperacion.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            txtCuentaDestino.setVisible("Transferir".equals(newVal));
        });
    }

    @FXML
    private void crearCliente() {
        try {
            Cliente cliente = new Cliente(
                    Integer.parseInt(txtIdCliente.getText()),
                    txtNombre.getText(),
                    txtDireccion.getText(),
                    txtTelefono.getText()
            );
            clientesObservable.add(cliente);
            limpiarCamposCliente();
            mostrarAlerta("Cliente creado exitosamente.", AlertType.INFORMATION);
        } catch (Exception e) {
            mostrarAlerta("Error al crear cliente: " + e.getMessage(), AlertType.ERROR);
        }
    }

    @FXML
    private void crearCuenta() {
        try {
            Cliente titular = listaClientes.getSelectionModel().getSelectedItem();
            if (titular == null) throw new Exception("Seleccione un cliente de la lista.");

            Cuenta cuenta;
            int numero = Integer.parseInt(txtNumCuenta.getText());
            double saldo = Double.parseDouble(txtSaldoInicial.getText());

            if ("Ahorro".equals(cmbTipoCuenta.getValue())) {
                cuenta = new CuentaAhorro(numero, saldo, titular, 0.02, 100.0);
            } else {
                cuenta = new CuentaCorriente(numero, saldo, titular);
            }

            cuentasObservable.add(cuenta);
            limpiarCamposCuenta();
            mostrarAlerta("Cuenta creada exitosamente.", AlertType.INFORMATION);
        } catch (Exception e) {
            mostrarAlerta("Error al crear cuenta: " + e.getMessage(), AlertType.ERROR);
        }
    }

    @FXML
    private void realizarOperacion() {
        try {
            String operacion = cmbOperacion.getValue();
            Cuenta cuenta = listaCuentas.getSelectionModel().getSelectedItem();
            double cantidad = Double.parseDouble(txtCantidad.getText());

            if (cuenta == null) throw new Exception("Seleccione una cuenta.");

            switch (operacion) {
                case "Depositar":
                    ((OperacionesBancarias) cuenta).depositar(cantidad);
                    registrarTransaccion(cuenta, "Depósito: +" + cantidad);
                    break;

                case "Retirar":
                    if (cuenta.getSaldo() < cantidad) {
                        throw new Exception("Saldo insuficiente para retirar.");
                    }
                    cuenta.retirar(cantidad);
                    registrarTransaccion(cuenta, "Retiro: -" + cantidad);
                    break;

                case "Transferir":
                    int destinoNum = Integer.parseInt(txtCuentaDestino.getText());
                    Cuenta destino = cuentasObservable.stream()
                            .filter(c -> c.getNumeroDeCuenta() == destinoNum)
                            .findFirst()
                            .orElseThrow(() -> new Exception("Cuenta destino no existe."));

                    if (cuenta.getSaldo() < cantidad) {
                        throw new Exception("Saldo insuficiente para transferir.");
                    }
                    ((OperacionesBancarias) cuenta).transferir(cantidad, destino);
                    registrarTransaccion(cuenta, "Transferencia a " + destinoNum + ": -" + cantidad);
                    registrarTransaccion(destino, "Transferencia de " + cuenta.getNumeroDeCuenta() + ": +" + cantidad);
                    break;
            }

            // Aplicar interés si es una cuenta corriente
            if (cuenta instanceof CuentaCorriente) {
                double saldoAnterior = cuenta.getSaldo();
                cuenta.actualizarSaldo();
                double interes = cuenta.getSaldo() - saldoAnterior;
                registrarTransaccion(cuenta, "Interés aplicado: +" + interes);
            }

            actualizarHistorial();
            mostrarAlerta("Operación realizada exitosamente.", AlertType.INFORMATION);
        } catch (Exception e) {
            mostrarAlerta("Error en operación: " + e.getMessage(), AlertType.ERROR);
        }
    }

    // Métodos auxiliares
    private void registrarTransaccion(Cuenta cuenta, String detalle) {
        String transaccion = String.format("%s | Saldo: %.2f", detalle, cuenta.getSaldo());

        if (cuenta instanceof CuentaAhorro) {
            ((CuentaAhorro) cuenta).getHistorial().agregarTransaccion(transaccion);
        } else if (cuenta instanceof CuentaCorriente) {
            ((CuentaCorriente) cuenta).getHistorial().agregarTransaccion(transaccion);
        }
    }

    private void actualizarHistorial() {
        txtHistorial.clear();
        txtHistorial.appendText("═══════════════════════════════\n");

        cuentasObservable.forEach(cuenta -> {
            String tipo = (cuenta instanceof CuentaAhorro) ? "Ahorro" : "Corriente";
            txtHistorial.appendText(String.format("Cuenta %d (%s)\n", cuenta.getNumeroDeCuenta(), tipo));
            txtHistorial.appendText(String.format("Saldo actual: %.2f\n", cuenta.getSaldo()));

            List<String> transacciones = (cuenta instanceof CuentaAhorro)
                    ? ((CuentaAhorro) cuenta).getHistorial().getTransacciones()
                    : ((CuentaCorriente) cuenta).getHistorial().getTransacciones();

            if (!transacciones.isEmpty()) {
                txtHistorial.appendText("Historial:\n");
                transacciones.forEach(t -> txtHistorial.appendText(" • " + t + "\n"));
            }
            txtHistorial.appendText("═══════════════════════════════\n");
        });
    }

    private void limpiarCamposCliente() {
        txtIdCliente.clear();
        txtNombre.clear();
        txtDireccion.clear();
        txtTelefono.clear();
    }

    private void limpiarCamposCuenta() {
        txtNumCuenta.clear();
        txtSaldoInicial.clear();
    }

    private void mostrarAlerta(String mensaje, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(tipo == AlertType.ERROR ? "Error" : "Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}