package es.foc.ejercicios.graficos.javafx.banderas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Esta clase denominada Banderas muestra 5 banderas para las cuales hay que
 * asignarles el país correspondiente. El programa determinará la cantidad de
 * aciertos logrados.
 *
 */
public class Banderas extends Application {
    // Etiquetas de países

    Label etiqueta = new Label("Seleccione la bandera");
    Label belice = new Label("Belice:");
    Label eslovenia = new Label("Eslovenia:");
    Label sudáfrica = new Label("Sudáfrica:");
    Label spain = new Label("España:");
    Label australia = new Label("Australia:");
    // Campos de texto de las respuestas
    TextField respuesta1 = new TextField();
    TextField respuesta2 = new TextField();
    TextField respuesta3 = new TextField();
    TextField respuesta4 = new TextField();
    TextField respuesta5 = new TextField();
    // Etiquetas de números de banderas
    Label uno = new Label("1");
    Label dos = new Label("2");
    Label tres = new Label("3");
    Label cuatro = new Label("4");
    Label cinco = new Label("5");
    // Botón aceptar
    Button aceptar = new Button("Aceptar");
    // Texto de resultados
    Text puntaje = new Text();
    // Matriz de respuestas ingresadas
    String[] respuestasIngresadas;

    /**
     * Método que lanza la aplicación
     *
     * @param stage El escenario donde se ejecutará la aplicación
     * @throws java.io.FileNotFoundException
     */
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        GridPane grid = new GridPane();
        /* Define un grid de elementos gráficos */
        grid.setHgap(5); // Define espacio entre columnas
        grid.setVgap(5); // Define espacio entre filas // Define la imagen 1
        Image banderaAustralia = new Image(new FileInputStream("C:\\jfx\\BanderaAustralia.png"));
        ImageView imageView1 = new ImageView(banderaAustralia);
        imageView1.setX(50); // Posición x de la imagen 1
        imageView1.setY(25); // Posición y de la imagen 1
        imageView1.setFitHeight(200); // Define altura de la imagen 1
        imageView1.setFitWidth(100); // Define anchura de la imagen 1
        imageView1.setPreserveRatio(true); // Preserva radio de la imagen 1
        // Define la imagen 2
        Image banderaSudáfrica = new Image(new FileInputStream("C:\\jfx\\BanderaSudafrica.png"));
        ImageView imageView2 = new ImageView(banderaSudáfrica);
        imageView2.setX(50); // Posición x de la imagen 2
        imageView2.setY(125); // Posición y de la imagen 2
        imageView2.setFitHeight(200); // Define altura de la imagen 2
        imageView2.setFitWidth(100); // Define anchura de la imagen 2
        imageView2.setPreserveRatio(true); // Preserva radio de la imagen 2
        // Define la imagen 3
        Image banderaBelice = new Image(new FileInputStream("C:\\jfx\\BanderaBelice.png"));
        ImageView imageView3 = new ImageView(banderaBelice);
        imageView3.setX(50); // Posición x de la imagen 3
        imageView3.setY(225); // Posición y de la imagen 3
        imageView3.setFitHeight(200); // Define altura de la imagen 3
        imageView3.setFitWidth(100); // Define anchura de la imagen 3
        imageView3.setPreserveRatio(true); // Preserva radio de la imagen 3
        // Define la imagen 4
        Image banderaEslovenia = new Image(new FileInputStream("C:\\jfx\\BanderaEslovenia.jpg"));
        ImageView imageView4 = new ImageView(banderaEslovenia);
        imageView4.setX(50); // Posición x de la imagen 4
        imageView4.setY(325); // Posición y de la imagen 4
        imageView4.setFitHeight(200); // Define altura de la imagen 4
        imageView4.setFitWidth(100); // Define anchura de la imagen 4
        imageView4.setPreserveRatio(true); // Preserva radio de la imagen 4 // Define la imagen 5

        Image banderaSpain = new Image(new FileInputStream("C:\\jfx\\BanderaSpain.jpg"));
        ImageView imageView5 = new ImageView(banderaSpain);
        imageView5.setX(50); // Posición x de la imagen 5
        imageView5.setY(425); // Posición y de la imagen 5
        imageView5.setFitHeight(200); // Define altura de la imagen 5
        imageView5.setFitWidth(100); // Define anchura de la imagen 5
        imageView5.setPreserveRatio(true); // Preserva radio de la imagen 5
        // Agrega los componentes gráficos a un grid
        grid.add(etiqueta, 0, 0);
        grid.add(belice, 0, 1);
        grid.add(respuesta1, 1, 1);
        grid.add(uno, 2, 1);
        grid.add(imageView1, 3, 1);
        grid.add(eslovenia, 0, 2);
        grid.add(respuesta2, 1, 2);
        grid.add(dos, 2, 2);
        grid.add(imageView2, 3, 2);
        grid.add(sudáfrica, 0, 3);
        grid.add(respuesta3, 1, 3);
        grid.add(tres, 2, 3);
        grid.add(imageView3, 3, 3);
        grid.add(spain, 0, 4);
        grid.add(respuesta4, 1, 4);
        grid.add(cuatro, 2, 4);
        grid.add(imageView4, 3, 4);
        grid.add(australia, 0, 5);
        grid.add(respuesta5, 1, 5);
        grid.add(cinco, 2, 5);
        grid.add(imageView5, 3, 5);
        grid.add(aceptar, 0, 6);
        grid.add(puntaje, 0, 7);
        // Establece evento para el botón
        aceptar.setOnAction(e -> calcular());
        // Establece propiedes CSS para el grid
        grid.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: green;");
        Group root = new Group(grid);
        /* Crea grupo de componentes a partir del grid */
        Scene scene = new Scene(root, 480, 450);
        /* Crea escena con grupo especificando su tamaño */
        stage.setTitle("Banderas"); // Establece título de la escena
        stage.setScene(scene); // Establece la escena para el escenario
        stage.show(); // Muestra el escenario (ventana)
    }

    /**
     * Método main que lanza la aplicación
     *
     * @param args Parámetro que define los argumentos de la aplicación
     */
    public static void main(String args[]) {
        launch(args);
    }

    /**
     * Método que calcula el puntaje de aciertos obtenidos por el jugador
     */
    private void calcular() {
        respuestasIngresadas = new String[5]; // Crea un array
        // Asigna las respuestas ingresadas al array
        respuestasIngresadas[0] = respuesta1.getText();
        respuestasIngresadas[1] = respuesta2.getText();
        respuestasIngresadas[2] = respuesta3.getText();
        respuestasIngresadas[3] = respuesta4.getText();
        respuestasIngresadas[4] = respuesta5.getText();
        int total = 0;
        /* Evalúa si las respuestas fueron correctas, si lo son incrementa el total de aciertos */
        if (respuestasIngresadas[0].equals("3")) {
            total++;
        }
        if (respuestasIngresadas[1].equals("4")) {
            total++;
        }
        if (respuestasIngresadas[2].equals("2")) {
            total++;
        }
        if (respuestasIngresadas[3].equals("5")) {
            total++;
        }
        if (respuestasIngresadas[4].equals("1")) {
            total++;
        }
        puntaje.setText("Total : " + total + "/5");
        /* Muestra el total de aciertos en pantalla */
        puntaje.setFont(Font.font(24));
        /* Establece fuente del puntaje de aciertos obtenidos */
        puntaje.setEffect(new DropShadow());
        /* Establece efecto aplicado al texto del puntaje */
    }
}
