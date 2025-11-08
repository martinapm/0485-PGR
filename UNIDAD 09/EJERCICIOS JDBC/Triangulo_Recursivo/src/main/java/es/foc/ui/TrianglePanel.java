package es.foc.ui;

import es.foc.geometry.RecursiveTriangle;
import es.foc.graphics.ColorPalette;
import es.foc.graphics.TriangleRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Panel personalizado para mostrar el triángulo recursivo
 */
public class TrianglePanel extends JPanel {
    private static final int DEFAULT_MAX_LEVELS = 6;
    private static final int DEFAULT_MIN_SIZE = 10;

    private int maxLevels = DEFAULT_MAX_LEVELS;
    private ColorPalette currentPalette = ColorPalette.createSierpinskiPalette();
    private Point triangleCenter;
    private int triangleSize;

    public TrianglePanel() {
        setPreferredSize(new Dimension(800, 700));
        setBackground(new Color(245, 245, 245)); // Fondo gris muy claro

        // Agregar interactividad con el mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    // Clic izquierdo: incrementar niveles
                    maxLevels = Math.min(maxLevels + 1, 8);
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    // Clic derecho: cambiar paleta de colores
                    toggleColorPalette();
                }
                repaint();
            }
        });

        // Configurar tooltip
        setToolTipText("<html>Clic izquierdo: Más niveles<br>Clic derecho: Cambiar colores</html>");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        try {
            // Calcular dimensiones del triángulo
            calculateTriangleDimensions();

            // Crear puntos del triángulo equilátero
            Point[] trianglePoints = createEquilateralTriangle();

            // Crear renderer y triángulo recursivo
            TriangleRenderer renderer = new TriangleRenderer(g2d, currentPalette);
            RecursiveTriangle recursiveTriangle = new RecursiveTriangle(
                    renderer, maxLevels, DEFAULT_MIN_SIZE
            );

            // Dibujar el triángulo recursivo
            recursiveTriangle.draw(trianglePoints[0], trianglePoints[1], trianglePoints[2]);

            // Dibujar información en la esquina
            drawInfo(g2d);

        } finally {
            g2d.dispose();
        }
    }

    /**
     * Calcula las dimensiones del triángulo basado en el tamaño del panel
     */
    private void calculateTriangleDimensions() {
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        triangleSize = Math.min(panelWidth, panelHeight) - 100; // Margen de 50px por cada lado
        triangleCenter = new Point(panelWidth / 2, panelHeight / 2);
    }

    /**
     * Crea los puntos de un triángulo equilátero
     */
    private Point[] createEquilateralTriangle() {
        int halfSize = triangleSize / 2;
        int height = (int) (halfSize * Math.sqrt(3));

        Point top = new Point(triangleCenter.x, triangleCenter.y - height / 2);
        Point bottomLeft = new Point(triangleCenter.x - halfSize, triangleCenter.y + height / 2);
        Point bottomRight = new Point(triangleCenter.x + halfSize, triangleCenter.y + height / 2);

        return new Point[]{top, bottomLeft, bottomRight};
    }

    /**
     * Cambia entre paletas de colores
     */
    private void toggleColorPalette() {
        if (currentPalette.equals(ColorPalette.createSierpinskiPalette())) {
            currentPalette = ColorPalette.createSoftPalette();
        } else {
            currentPalette = ColorPalette.createSierpinskiPalette();
        }
    }

    /**
     * Dibuja información sobre el estado actual
     */
    private void drawInfo(Graphics2D g2d) {
        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(new Font("Arial", Font.BOLD, 12));

        String info = String.format("Niveles: %d | Paleta: %s",
                maxLevels,
                currentPalette.equals(ColorPalette.createSierpinskiPalette()) ? "Sierpinski" : "Suave"
        );

        g2d.drawString(info, 10, 20);
        g2d.drawString("Clic izq: +Niveles | Clic der: Cambiar colores", 10, getHeight() - 10);
    }

    // Métodos públicos para control externo
    public void setMaxLevels(int maxLevels) {
        this.maxLevels = Math.max(1, Math.min(maxLevels, 8));
        repaint();
    }

    public int getMaxLevels() {
        return maxLevels;
    }

    public void setColorPalette(ColorPalette palette) {
        this.currentPalette = palette;
        repaint();
    }
}