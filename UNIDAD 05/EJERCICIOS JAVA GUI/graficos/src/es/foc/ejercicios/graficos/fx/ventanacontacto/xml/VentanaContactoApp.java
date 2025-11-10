package es.foc.ejercicios.graficos.fx.ventanacontacto.xml;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VentanaContactoApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaContacto.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/es/foc/ejercicios/graficos/javafx/ventanacontacto/fxml/VentanaContacto.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource(""));        
        
        //File fxmlFile = new File("C:\\jfx\\VentanaContacto.fxml");
        File fxmlFile = new File("C:\\Users\\PGR - ED\\OneDrive - Instituto FOC\\codigo\\graficos\\src\\es\\foc\\ejercicios\\graficos\\fx\\ventanacontacto\\xml\\VentanaContacto.fxml");
        if(!fxmlFile.exists()){
            System.out.println("El archivo fxml no existe");
            return;
        }
        FXMLLoader loader = new FXMLLoader(fxmlFile.toURI().toURL());
        
        GridPane root = loader.load();
        Scene scene = new Scene(root, 600, 300);
        stage.setTitle("Detalles del contacto");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
