package es.foc.ejercicios.graficos.javafx.figuras3d;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 * Esta clase denominada Figuras3D permite crear varias figuras en tres
 * dimensiones y se muestran en diferentes formatos de presentación
 */
public class Figuras3D extends Application {

    Box caja; // Atributo que define un cubo
    PhongMaterial material1; // Atributo que el material del cubo
    Sphere esfera; // Atributo que define una esfera
    PhongMaterial material2; // Atributo que define el material de la esfera
    Cylinder cilindro; // Atributo que define un cilindro
    PointLight luz; // Atributo que define un punto de luz

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
        // Crea un Box de tamaño 100
        caja = new Box(100, 100, 100);
        // Se establece la posición del box
        caja.setTranslateX(150);
        caja.setTranslateY(0);
        caja.setTranslateZ(400);
        // Establece material del box
        material1 = new PhongMaterial();
        material1.setDiffuseColor(Color.YELLOW);
        caja.setMaterial(material1);
        // Crea una Sphere con radio de 60 y divisiones = 40
        esfera = new Sphere(60, 40);
        esfera.setDrawMode(DrawMode.LINE);
        // Se establece la posición de la esfera
        esfera.setTranslateX(300);
        esfera.setTranslateY(-5);
        esfera.setTranslateZ(400);
        // Establece material del cilindro
        material2 = new PhongMaterial();
        material2.setDiffuseColor(Color.ORANGE);
        material2.setSpecularColor(Color.ORANGE);
        // Crea un Cylinder de radio 75 y altura 100
        cilindro = new Cylinder(75, 100);
        // Se establece la posición del cilindro
        cilindro.setTranslateX(500);
        cilindro.setTranslateY(5);
        cilindro.setTranslateZ(500);
        cilindro.setMaterial(material2);
        // Crea un punto de luz y lo ubica en x=350, y= 100, z = 300
        luz = new PointLight();
        luz.setTranslateX(350);
        luz.setTranslateY(100);
        luz.setTranslateZ(300);
        Group root = new Group(caja, esfera, cilindro, luz);
        /* Agrega los elementos al grupo */
        // Crea una escena con buffer de profundidad habilitado
        Scene scene = new Scene(root, 400, 100, true);
        // Establece una cámara para ver figuras 3D
        PerspectiveCamera camera = new PerspectiveCamera(false);
        // Establece la posición de la cámara
        camera.setTranslateX(100);
        camera.setTranslateY(-50);
        camera.setTranslateZ(300);
        scene.setCamera(camera); // Agrega la cámara a la escena
        stage.setScene(scene); // Agrega la escena al escenario
        stage.setTitle("Figuras 3D"); // Establece título del escenario
        stage.show(); // Muestra el escenario (ventana)
    }
}