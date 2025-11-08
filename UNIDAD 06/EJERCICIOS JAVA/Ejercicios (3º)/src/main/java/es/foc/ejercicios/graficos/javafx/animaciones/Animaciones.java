package es.foc.ejercicios.graficos.javafx.animaciones;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Esta clase denominada Animaciones crea un cuadrado verde y una elipse
 * amararilla. El cuadrado rotará con respecto a su centro en dos direcciones
 * consecutivas y la elipse tendrá cambio en su opacidad una cierta duración.
 */
public class Animaciones extends Application {

    Rectangle rectangulo; // Rectángulo animado presente en la ventana
    Ellipse elipse; // Elipse animada presente en la ventana

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
        rectangulo = new Rectangle(100, 100, Color.GREEN);
        // Inicializa una transición de rotación del rectángulo de duración 2 segundos 
        RotateTransition rt = new RotateTransition(Duration.seconds(2),rectangulo);
        rt.setFromAngle(0.0); // Establece ángulo de inicio de la rotación 
        rt.setToAngle(360.0);
        /* Establece ángulo de detención de la rotación */
        rt.setCycleCount(RotateTransition.INDEFINITE);
        /* Número de ciclos de rotación */
        rt.setAutoReverse(true);
        /* Invierte la dirección de rotación */
        rt.play(); 
        elipse = new Ellipse(50, 50, 50, 25); // Crea una elipse
        elipse.setFill(Color.YELLOW); // Color de relleno de la elipse
        elipse.setStroke(Color.BLUE); // Color de la línea de borde
        elipse.setStrokeWidth(3.0); // Anchura del borde
        /* Inicializa una transición de opacidad de la elipse por 2 segundos */
        FadeTransition fadeInOut = new FadeTransition(Duration.seconds(2), elipse);
        fadeInOut.setFromValue(1.0);
        /* Especifica el valor de inicio de la opacidad */
        fadeInOut.setToValue(.20);
        /* Especifica el valor de detención de la opacidad */
        // Establece el número de ciclos de opacidad
        fadeInOut.setCycleCount(FadeTransition.INDEFINITE);
        fadeInOut.setAutoReverse(true);
        /* Invierte la dirección de la opacidad */
        fadeInOut.play();
        // Establece un contenedor HBox con sus márgenes
        HBox.setMargin(rectangulo, new Insets(80));
        HBox.setMargin(elipse, new Insets(80));
        HBox root = new HBox(rectangulo, elipse);
        /* Crea un HBox con el rectángulo y la elipse */
        Scene escena = new Scene(root); // Crea una escena con el root
        stage.setScene(escena); // Establece la escena para el escenario
        stage.setTitle("Rotación"); // Establece título de la escena
        stage.show(); // Muestra la escena (ventana)
    }
}
