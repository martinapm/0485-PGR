
package tarea5swing;

import javax.swing.SwingUtilities;

public class Tarea5Swing {

    public static void main(String[] args) {
        // SwingUtilities.invokeLater asegura que la interfaz se cree en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            new ProductManagerFrame().setVisible(true);
        });
    }
}
