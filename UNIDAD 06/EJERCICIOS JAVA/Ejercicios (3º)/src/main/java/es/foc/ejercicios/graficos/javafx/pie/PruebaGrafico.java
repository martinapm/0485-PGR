package es.foc.ejercicios.graficos.javafx.pie;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Esta clase denominada PruebaGráfica crea una gráfica de torta para una serie
 * de datos
 *
 */
public class PruebaGrafico extends Application {

    PieChart grafica; // Atributo que define un gráfico de torta

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
        grafica = new PieChart(); // Crea la gráfica de torta
        grafica.setTitle("Utilización de lenguajes de programación en 2020"); // Establece título
        // Coloca una leyenda en el lado izquierdo
        grafica.setLegendSide(Side.LEFT);
        /* Establece la ubicación de la leyenda */
        // Inicializa los datos de la gráfica
        ObservableList<PieChart.Data> datosGráfica = GraficoPie.obtenerDatos();
        grafica.setData(datosGráfica); // Establece los datos del PieChart
        StackPane root = new StackPane(grafica);
        /* Agrega gráfica al contenedor */
        Scene scene = new Scene(root); // Crea escenario
        stage.setScene(scene); // Agrega escena al escenario
        stage.setTitle("Gráfica de torta"); // Establece título del escenario
        stage.show(); // Muestra el escenario (ventana)
    }
}
