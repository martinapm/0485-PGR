package es.foc.ejercicios.graficos.javafx.figuras2d;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Esta clase denominada Figuras permite crear varias figuras en 2D con
 * diferentes formatos de presentación.
 */

public class Figuras2D extends Application {

    Line línea; // Atributo que define una línea
    Rectangle rectangulo1; // Atributo que define un rectángulo
    Rectangle rectangulo2;
    /* Atributo que define un rectángulo con bordes redondeados */
    Polygon paralelogramo; // Atributo que define un polígono
    Polyline hexagono; // Atributo que define una polilínea
    Circle círculo; // Atributo que define un círculo
    Ellipse elipse; // Atributo que define una elipse
    Arc arco; // Atributo que define un arco
    Text texto; // Atributo que define un texto

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
     */
    @Override
    public void start(Stage stage) {
        // Crea una línea amarilla de ancho 4.0 px
        línea = new Line(0, 0, 70, 70);
        línea.setStrokeWidth(4.0);
        línea.setStroke(Color.YELLOW);
        // Crea un rectángulo verde
        rectangulo1 = new Rectangle(100, 75);
        rectangulo1.setFill(Color.GREEN);
        // Crea un rectángulo agua con bordes redondeados
        rectangulo2 = new Rectangle(100, 75);
        rectangulo2.setFill(Color.AQUA);
        rectangulo2.setArcWidth(30);
        rectangulo2.setArcHeight(20);
        // Crea un paralelogramo rojo con borde negro
        paralelogramo = new Polygon();
        paralelogramo.getPoints().addAll(30.0, 0.0,
                130.0, 0.0,
                100.00, 75.0,
                0.0, 75.0);
        paralelogramo.setFill(Color.RED);
        paralelogramo.setStroke(Color.BLACK);
        // Crea un hexágono gris con borde negro
        hexagono = new Polyline(100.0, 0.0,
                120.0, 25.0,
                120.0, 50.0,
                100.0, 75.0,
                80.0, 50.0,
                80.0, 25.0,
                100.0, 0.0);
        hexagono.setFill(Color.GREY);
        hexagono.setStroke(Color.BLACK);
        // Crea un círculo azul con borde negro de ancho 3.0 px
        círculo = new Circle(40);
        círculo.setFill(Color.BLUE);
        círculo.setStroke(Color.BLACK);
        círculo.setStrokeWidth(3.0);
        // Crea una elipse amarilla con borde azul de ancho 3.0 px
        elipse = new Ellipse(50, 50, 50, 25);
        elipse.setFill(Color.YELLOW);
        elipse.setStroke(Color.BLUE);
        elipse.setStrokeWidth(3.0);
        // Crea un arco cerrado sin relleno y con borde naranja
        arco = new Arc(0, 0, 50, 80, 0, 120);
        arco.setFill(Color.TRANSPARENT);
        arco.setStroke(Color.ORANGE);
        arco.setType(ArcType.CHORD);
        // Crea un texto con el valor "JavaFX"
        texto = new Text(10, 10, "JavaFx");
        // Agrega las figuras a un HBox
        HBox root = new HBox(línea, rectangulo1, rectangulo2,
                paralelogramo, hexagono, círculo, elipse, arco, texto);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: brown;");
        Scene scene = new Scene(root); // Crea un escenario con el root
        stage.setScene(scene); // Establece la escena para el escenario
        stage.setTitle("Figuras 2D"); // Establece título del escenario
        stage.show(); // Muestra el escenario (ventana)
    }
}
