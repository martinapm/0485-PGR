package es.foc.graphics;

import java.awt.*;

/**
 * Renderizador responsable de dibujar triángulos recursivos
 */
public class TriangleRenderer {
    private final Graphics2D graphics;
    private final ColorPalette colorPalette;

    public TriangleRenderer(Graphics2D graphics, ColorPalette colorPalette) {
        this.graphics = graphics;
        this.colorPalette = colorPalette;

        // Configuración para mejor calidad de renderizado
        this.graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
    }

    /**
     * Dibuja un triángulo relleno
     */
    public void drawTriangle(Point p1, Point p2, Point p3, Color color) {
        graphics.setColor(color);
        int[] xPoints = {p1.x, p2.x, p3.x};
        int[] yPoints = {p1.y, p2.y, p3.y};
        graphics.fillPolygon(xPoints, yPoints, 3);
    }

    /**
     * Dibuja el contorno de un triángulo
     */
    public void drawTriangleOutline(Point p1, Point p2, Point p3, Color color, int thickness) {
        graphics.setColor(color);
        graphics.setStroke(new BasicStroke(thickness));
        int[] xPoints = {p1.x, p2.x, p3.x};
        int[] yPoints = {p1.y, p2.y, p3.y};
        graphics.drawPolygon(xPoints, yPoints, 3);
    }

    /**
     * Obtiene el color basado en el nivel de recursión
     */
    public Color getColorForLevel(int level, int maxLevels) {
        return colorPalette.getColorForLevel(level, maxLevels);
    }
}