package es.foc.ejercicios.graficos.fx.ventanacontacto;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ListView;
import java.time.LocalDate;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import es.foc.ejercicios.graficos.contactos.ListaContactos;
import es.foc.ejercicios.graficos.contactos.Contacto;

/**
 * Esta clase denominada VentanaContacto crea una ventana que permite agregar un
 * contacto.
 *
  */
public class VentanaContacto extends Application {

    // Etiquetas
    Label nombres = new Label("Nombres:");
    Label apellidos = new Label("Apellidos:");
    Label fechaNacimiento = new Label("Fecha nacimiento:");
    Label direccion = new Label("Dirección");
    Label correo = new Label("Correo");
    Label telefono = new Label("Teléfono");

    // Campos de texto
    TextField campoNombres = new TextField();
    TextField campoApellidos = new TextField();
    DatePicker campoFechaNacimiento = new DatePicker();

    // Componente gráfico calendario
    TextField campoDireccion = new TextField();
    TextField campoCorreo = new TextField();
    TextField campoTelefono = new TextField();
    ListView<String> lista = new ListView<>();

    /* Componente gráfico con lista de elementos */
    // Botón
    Button agregar = new Button("Agregar");

    /**
     * Método main que lanza la aplicación
     *
     * @param args Parámetro que define los argumentos de la aplicación
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Método start que inicia la aplicación
     *
     * @param stage El escenario donde se ejecutará la aplicación
     * @throws java.lang.Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Establece un grid para los componentes gráficos
        GridPane grid = new GridPane();
        /* Establece espacios horizontales y verticales entre filas y columnas */
        grid.setHgap(5);
        grid.setVgap(5);
        // Coloca los controles en el grid
        grid.add(nombres, 0, 0); // columna=0, fila=0
        grid.add(apellidos, 0, 1); // columna=0, fila=1
        grid.add(fechaNacimiento, 0, 2); // columna=0, fila=2
        grid.add(direccion, 0, 3); // columna=0, fila=3
        grid.add(telefono, 0, 4); // columna=0, fila=4
        grid.add(correo, 0, 5); // columna=0, fila=5
        grid.add(campoNombres, 1, 0); // columna=1, fila=0
        grid.add(campoApellidos, 1, 1); // columna=1, fila=1
        grid.add(campoFechaNacimiento, 1, 2); // columna=1, fila=2
        grid.add(campoDireccion, 1, 3); // columna=1, fila=3
        grid.add(campoTelefono, 1, 4); // columna=1, fila=4
        grid.add(campoCorreo, 1, 5); // columna=1, fila=5
        grid.add(lista, 2, 0, 1, 7);
        /* columna=2, fila=0, colspan=1, rowspan=7 */
        // Agrega el botón
        VBox buttonBox = new VBox(agregar);
        agregar.setMaxWidth(Double.MAX_VALUE);
        grid.add(buttonBox, 0, 6, 1, 2);
        /* columna=0, fila=6, colspan=1, rowspan=2 */
        // Muestra los datos en el área de texto al presionar botón salvar
        agregar.setOnAction(e -> mostrarDatos());
        // Establece un CSS para el GridPane
        grid.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: green ;");

        Scene scene = new Scene(grid, 600, 300);

        /* Crea una escena con el tamaño definido */
        stage.setScene(scene); // Establece para el escenario una escena

        stage.setTitle("Detalles del contacto");
        /* Establece el título del escenario */
        stage.sizeToScene();

        stage.show(); // Muestra el escenario (ventana)
    }

    /**
     * Método que captura los datos ingresados de un contacto, crea un contacto,
     * lo añade a la lista de contactos y a la lista gráfica
     */
    private void mostrarDatos() {
        // Captura los datos ingresados
        String a = campoNombres.getText();
        String b = campoApellidos.getText();
        LocalDate c = campoFechaNacimiento.getValue();
        String d = campoDireccion.getText();
        String e = campoTelefono.getText();
        String f = campoCorreo.getText();
        // Evalua que los campos no estén vacíos
        if (a.equals("") || b.equals("") || d.equals("") || e.equals("") || f.equals("")) {
            // Si los campos están vacíos, se genera una alerta
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Mensaje");
            mensaje.setHeaderText("Error en ingreso de datos");
            mensaje.setContentText("No se permiten campos vacíos");
            mensaje.showAndWait();
        } else {
            // Si los datos se han ingresado correctamente
            Contacto contacto = new Contacto(a, b, c, d, e, f);
            /*Crea un contaco */
            ListaContactos listaContactos = new ListaContactos();
            /* Crea la lista de contactos */
            listaContactos.agregarContacto(contacto);
            /* Añade el contacto a la lista */
            String data = a + "-" + b + "-" + c + "-" + d + "-" + e + "-" + f;
            lista.getItems().add(data);
            /* Añade el contacto a la lista gráfica */
            /* Todos los campos quedan vacíos para ingresar un nuevo contacto */
            campoNombres.setText("");
            campoApellidos.setText("");
            campoFechaNacimiento.setValue(null);
            campoDireccion.setText("");
            campoTelefono.setText("");
            campoCorreo.setText("");
        }
    }
}
