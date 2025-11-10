package es.foc;

import es.foc.ui.TrianglePanel;
import es.foc.graphics.ColorPalette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Aplicación principal para mostrar el triángulo recursivo
 * @author tu nombre
 * @version 1.0
 */
public class Main extends JFrame {
    private static final String TITLE = "Triángulo Recursivo - Sierpinski Fractal";
    private TrianglePanel trianglePanel;

    public Main() {
        initializeFrame();
        createComponents();
        setupLayout();
        setupMenuBar();
    }

    /**
     * Configura la ventana principal
     */
    private void initializeFrame() {
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        // Centrar en pantalla
        setLocationRelativeTo(null);

        // Icono de la aplicación (opcional)
        try {
            // Si tienes un icono, descomenta esta línea
            // setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        } catch (Exception e) {
            System.out.println("No se pudo cargar el icono de la aplicación");
        }
    }

    /**
     * Crea los componentes principales
     */
    private void createComponents() {
        trianglePanel = new TrianglePanel();
    }

    /**
     * Configura el layout de la aplicación
     */
    private void setupLayout() {
        setLayout(new BorderLayout());

        // Panel principal con el triángulo
        add(trianglePanel, BorderLayout.CENTER);

        // Panel de control inferior
        JPanel controlPanel = createControlPanel();
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }

    /**
     * Crea el panel de controles
     */
    private JPanel createControlPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Controles"));

        // Slider para niveles de recursión
        JLabel levelLabel = new JLabel("Niveles:");
        JSlider levelSlider = new JSlider(1, 8, trianglePanel.getMaxLevels());
        levelSlider.setMajorTickSpacing(1);
        levelSlider.setPaintTicks(true);
        levelSlider.setPaintLabels(true);
        levelSlider.addChangeListener(e -> {
            trianglePanel.setMaxLevels(levelSlider.getValue());
        });

        // Botones para cambiar paletas
        JButton sierpinskiButton = new JButton("Paleta Sierpinski");
        sierpinskiButton.addActionListener(e -> {
            trianglePanel.setColorPalette(ColorPalette.createSierpinskiPalette());
        });

        JButton softButton = new JButton("Paleta Suave");
        softButton.addActionListener(e -> {
            trianglePanel.setColorPalette(ColorPalette.createSoftPalette());
        });

        // Botón de información
        JButton infoButton = new JButton("ℹ Info");
        infoButton.addActionListener(this::showInfoDialog);

        // Agregar componentes
        panel.add(levelLabel);
        panel.add(levelSlider);
        panel.add(new JSeparator(SwingConstants.VERTICAL));
        panel.add(sierpinskiButton);
        panel.add(softButton);
        panel.add(new JSeparator(SwingConstants.VERTICAL));
        panel.add(infoButton);

        return panel;
    }

    /**
     * Configura la barra de menú
     */
    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Menú Archivo
        JMenu fileMenu = new JMenu("Archivo");

        JMenuItem exportItem = new JMenuItem("Exportar como PNG");
        exportItem.addActionListener(this::exportTriangle);

        JMenuItem exitItem = new JMenuItem("Salir");
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(exportItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Menú Ayuda
        JMenu helpMenu = new JMenu("Ayuda");

        JMenuItem aboutItem = new JMenuItem("Acerca de");
        aboutItem.addActionListener(this::showAboutDialog);

        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

    /**
     * Muestra el diálogo de información
     */
    private void showInfoDialog(ActionEvent e) {
        String message = """
            <html>
            <h3>Triángulo de Sierpinski</h3>
            <p>Un fractal fascinante que muestra patrones autosimilares.</p>
            <br>
            <b>Controles:</b>
            <ul>
            <li>Clic izquierdo: Aumentar niveles de recursión</li>
            <li>Clic derecho: Cambiar paleta de colores</li>
            <li>Slider: Controlar niveles directamente</li>
            </ul>
            <br>
            <p><i>Proyecto desarrollado con Java y Swing</i></p>
            </html>
            """;

        JOptionPane.showMessageDialog(this, message, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra el diálogo "Acerca de"
     */
    private void showAboutDialog(ActionEvent e) {
        String message = """
            <html>
            <h3>Triángulo Recursivo v1.0</h3>
            <p>Una implementación interactiva del fractal de Sierpinski</p>
            <br>
            <p>Desarrollado con:</p>
            <ul>
            <li>Java 21</li>
            <li>Swing GUI</li>
            <li>Maven</li>
            </ul>
            <br>
            <p><i>© 2025 - Proyecto Educativo</i></p>
            </html>
            """;

        JOptionPane.showMessageDialog(this, message, "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Exporta el triángulo como imagen PNG
     */
    private void exportTriangle(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new java.io.File("triangulo_recursivo.png"));

        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                // Crear imagen del panel
                java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(
                        trianglePanel.getWidth(),
                        trianglePanel.getHeight(),
                        java.awt.image.BufferedImage.TYPE_INT_RGB
                );

                Graphics2D g2d = image.createGraphics();
                trianglePanel.paint(g2d);
                g2d.dispose();

                // Guardar imagen
                javax.imageio.ImageIO.write(image, "PNG", fileChooser.getSelectedFile());

                JOptionPane.showMessageDialog(this,
                        "Imagen exportada exitosamente",
                        "Exportación",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Error al exportar: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Punto de entrada de la aplicación
     */
    public static void main(String[] args) {
        // Configurar Look and Feel del sistema - CORRECCIÓN APLICADA
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("No se pudo establecer el Look and Feel del sistema");
        }

        // Crear y mostrar la aplicación en el Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            try {
                Main frame = new Main();
                frame.setSize(800, 600); // Tamaño inicial adecuado
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "Error al inicializar la aplicación: " + e.getMessage(),
                        "Error Fatal",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        });
    }
}