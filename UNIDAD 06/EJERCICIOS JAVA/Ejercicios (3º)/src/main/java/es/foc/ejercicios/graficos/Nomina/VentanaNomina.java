package es.foc.ejercicios.graficos.Nomina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase denominada VentanaNómina define una interfaz gráfica que permitirá
 * consultar la lista de empleados y la nómina total.
 *
 * @version 1.2/2020
 */

public class VentanaNomina extends JFrame {

    private Container contenedor;
    /* Un contenedor de elementos gráficos */
    private ListaEmpleados lista; // Lista de empleados de la empresa
    private JLabel empleados, nomina;
    /* Etiquetas estáticas empleados y nómina total */
    private JTable tabla;

    /* Tabla para mostrar datos de la lista de empleados */
    /**
     * Constructor de la clase VentanaNómina
     */
    public VentanaNomina(ListaEmpleados lista) {
        this.lista = lista;
        inicio();
        setTitle("Nómina de Empleados"); // Establece el título de la ventana
        setSize(350, 250); // Establece el tamaño de la ventana
        setLocationRelativeTo(null);
        /* La ventana se posiciona en el centro de la pantalla */
        setResizable(false);
        /* Establece que la ventana no puede cambiar de tamaño */
    }

    /**
     * Método que crea la ventana con sus diferentes componentes gráficos
     */
    public void inicio() {
        contenedor = getContentPane();
        /* Obtiene el panel de contenidos de la ventana */
        contenedor.setLayout(null);
        /* Establece que el contenedor no tiene un layout */
        // Establece la etiqueta lista de empleados
        empleados = new JLabel();
        empleados.setText("Lista de empleados:");
        // Establece la posición de la etiqueta lista de empleados
        empleados.setBounds(20, 10, 135, 23);
        String[][] datos = lista.obtenerMatriz();
        /* Convierte la lista de empleados a una matriz */
        String[] titulos = {"NOMBRE", "APELLIDOS", "SUELDO"};
        // Define cabecera de la tabla
        // Crea un modelo de tabla con su cabecera y matriz
        DefaultTableModel model = new DefaultTableModel(datos, titulos);
        tabla = new JTable(model); // Asocia el modelo a la tabla
        tabla.setBounds(20, 50, 310, 100);
        /* Establece la posición de la tabla de empleados */
        // Establece la etiqueta de total nómina mensual
        nomina = new JLabel();
        // Presenta el total de la nómina formateado
        nomina.setText("Total nómina mensual = $ " + String.format("%.2f", lista.totalNomina));
        // Establece la posición de la etiqueta total nómina mensual
        nomina.setBounds(20, 160, 250, 23);
        // Se añade cada componente gráfico al contenedor de la ventana
        contenedor.add(empleados);
        contenedor.add(tabla);
        contenedor.add(nomina);
    }
}
