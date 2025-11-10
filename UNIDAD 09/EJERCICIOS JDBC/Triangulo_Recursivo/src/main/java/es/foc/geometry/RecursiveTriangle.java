package es.foc.geometry;

import es.foc.graphics.TriangleRenderer;
import java.awt.*;

/**
 * Implementación del triángulo recursivo (Sierpinski-like)
 */
public class RecursiveTriangle {
    private final TriangleRenderer renderer;
    private final int maxLevels;
    private final int minSize;

    public RecursiveTriangle(TriangleRenderer renderer, int maxLevels, int minSize) {
        this.renderer = renderer;
        this.maxLevels = maxLevels;
        this.minSize = minSize;
    }

    /**
     * Inicia el proceso de dibujo recursivo
     */
    public void draw(Point p1, Point p2, Point p3) {
        drawRecursive(p1, p2, p3, 0);
    }

    /**
     * Método recursivo principal para dibujar el triángulo
     */
    private void drawRecursive(Point p1, Point p2, Point p3, int level) {
        // Condición de parada: nivel máximo alcanzado o triángulo muy pequeño
        if (level >= maxLevels || getTriangleSize(p1, p2, p3) < minSize) {
            return;
        }

        // Dibujar el triángulo actual
        Color triangleColor = renderer.getColorForLevel(level, maxLevels);
        renderer.drawTriangle(p1, p2, p3, triangleColor);

        // Calcular puntos medios de los lados
        Point mid12 = midpoint(p1, p2);
        Point mid23 = midpoint(p2, p3);
        Point mid31 = midpoint(p3, p1);

        // Crear tres triángulos más pequeños recursivamente
        drawRecursive(p1, mid12, mid31, level + 1);
        drawRecursive(mid12, p2, mid23, level + 1);
        drawRecursive(mid31, mid23, p3, level + 1);

        // Opcionalmente, dibujar el triángulo central invertido
        if (level < maxLevels - 2) { // Solo en niveles más profundos
            Color centralColor = renderer.getColorForLevel(level + maxLevels/2, maxLevels);
            renderer.drawTriangle(mid12, mid23, mid31, centralColor);
        }
    }

    /**
     * Calcula el punto medio entre dos puntos
     */
    private Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }

    /**
     * Calcula el tamaño aproximado del triángulo
     */
    private double getTriangleSize(Point p1, Point p2, Point p3) {
        double side1 = distance(p1, p2);
        double side2 = distance(p2, p3);
        double side3 = distance(p3, p1);
        return Math.max(Math.max(side1, side2), side3);
    }

    /**
     * Calcula la distancia entre dos puntos
     */
    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }
}