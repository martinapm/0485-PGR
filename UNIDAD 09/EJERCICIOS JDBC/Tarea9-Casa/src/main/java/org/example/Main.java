package org.example;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Clase principal para iniciar la aplicación
 * @author Martina Pérez Muñoz
 */
public class Main {


    public static void main(String[] args) {
        // Ejecutar la aplicación en el Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Intentar usar el Look and Feel del sistema
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    System.err.println("Error al establecer Look and Feel: " + e.getMessage());
                }

                // Crear y mostrar la interfaz
                InterfazApp app = new InterfazApp();
                app.setVisible(true);
            }
        });
    }
}