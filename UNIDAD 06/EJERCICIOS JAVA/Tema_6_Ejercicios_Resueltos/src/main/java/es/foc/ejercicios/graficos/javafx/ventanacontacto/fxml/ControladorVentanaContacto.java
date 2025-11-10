package es.foc.ejercicios.graficos.javafx.ventanacontacto.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

import es.foc.ejercicios.graficos.contactos.*;


public class ControladorVentanaContacto {

    @FXML
    private TextField campoNombres;
    @FXML
    private TextField campoApellidos;
    @FXML
    private DatePicker campoFechaNacimiento;
    @FXML
    private TextField campoDireccion;
    @FXML
    private TextField campoTelefono;
    @FXML
    private TextField campoCorreo;
    @FXML
    private ListView<String> lista;

    private ListaContactos listaContactos = new ListaContactos();

    @FXML
    private void agregarContacto() {
        String nombres = campoNombres.getText();
        String apellidos = campoApellidos.getText();
        LocalDate fecha = campoFechaNacimiento.getValue();
        String direccion = campoDireccion.getText();
        String telefono = campoTelefono.getText();
        String correo = campoCorreo.getText();

        if (nombres.isEmpty() || apellidos.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Mensaje");
            mensaje.setHeaderText("Error en ingreso de datos");
            mensaje.setContentText("No se permiten campos vacíos");
            mensaje.showAndWait();
        } else {
            Contacto contacto = new Contacto(nombres, apellidos, fecha, direccion, telefono, correo);
            listaContactos.agregarContacto(contacto);
            lista.getItems().add(nombres + " - " + apellidos + " - " + fecha + " - " + direccion + " - " + telefono + " - " + correo);
            limpiarCampos();
        }
    }

    @FXML
    private void limpiarCampos() {
        campoNombres.clear();
        campoApellidos.clear();
        campoFechaNacimiento.setValue(null);
        campoDireccion.clear();
        campoTelefono.clear();
        campoCorreo.clear();
    }
}
