
package es.foc.ejercicios.graficos.javafx.pie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class GraficoPie {

    /**
     * Método estático que define y obtiene los datos del PieChart
     *
     * @return Los datos del PieChart
     */
    public static ObservableList<PieChart.Data> obtenerDatos() {
        // Crea una lista de datos para el PieChart
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        // Añade los datos al PieChart
        data.add(new PieChart.Data("Phyton", 25.7));
        data.add(new PieChart.Data("JavaScript", 17.8));
        data.add(new PieChart.Data("Go", 15));
        data.add(new PieChart.Data("TypeScript", 14.6));
        data.add(new PieChart.Data("Kotlin2", 11));
        data.add(new PieChart.Data("Otros", 15.8));
        return data;
    }
}
