package es.foc.ejercicios.graficos.javafx.transformaciones;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.transform.Shear;
import javafx.stage.Stage;

/**
 * Esta clase denominada Transformaciones crea varias figuras 2D a las cuales se
 * les realizará varias transformaciones
 *
  */
public class Transformaciones extends Application {

    Rectangle rectangulo1; // Atributo que define un rectángulo fijo
    Rectangle rectangulo2; // Atributo que define un rectángulo a trasladar
    Rectangle rectangulo3; // Atributo que define un rectángulo a rotar
    Rectangle rectangulo4; // Atributo que define un rectángulo a escalar
    Rectangle rectangulo5; // Atributo que define un rectángulo a cortar

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
        rectangulo1 = new Rectangle(100, 50, Color.DARKRED);
        rectangulo2 = new Rectangle(100, 50, Color.INDIGO);
        rectangulo3 = new Rectangle(100, 50, Color.YELLOW);
        rectangulo4 = new Rectangle(100, 50, Color.BLUE);
        rectangulo5 = new Rectangle(100, 50, Color.RED);
        // Aplica transformaciones al rectángulo2
        rectangulo2.setTranslateX(100); // Traslación en el eje x
        rectangulo2.setTranslateY(70); // Traslación en el eje y
        // Aplica transformaciones al rectángulo3
        rectangulo3.setTranslateX(170); // Traslación en el eje x
        rectangulo3.setTranslateY(160); // Traslación en el eje y
        rectangulo3.setRotate(45); // Rotación de 45 grados
        // Aplica transformaciones al rectángulo4
        rectangulo4.setTranslateX(250); // Traslación en el eje x
        rectangulo4.setTranslateY(260); // Traslación en el eje y
        rectangulo4.setScaleX(1.3); // Ampliación de escala en el eje x
        rectangulo4.setScaleY(1.3); // Ampliación de escala en el eje y
        // Aplica transformaciones al rectángulo5
        rectangulo5.setTranslateX(360); // Traslación en el eje x
        rectangulo5.setTranslateY(340); // Traslación en el eje y
        Shear shear = new Shear(0.5, 0.5);
        rectangulo5.getTransforms().addAll(shear);
        /* Establece recorte de la figura */
        // Agrega elementos gráficos al grupo
        Group root = new Group(rectangulo1, rectangulo2, rectangulo3,rectangulo4, rectangulo5);
        Scene scene = new Scene(root, 500, 450);
        /* Agrega el grupo a la escena */
        stage.setScene(scene); // Establece escena para el escenario
        stage.setTitle("Transformaciones"); /* Establece título del escenario */
        stage.show(); // Muestra el escenario (ventana)
    }
}