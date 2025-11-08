package es.foc.graphics;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * Paleta de colores para el triángulo recursivo
 */
public class ColorPalette {
    private final List<Color> colors;

    /**
     * Paleta inspirada en la imagen proporcionada
     */
    public static ColorPalette createSierpinskiPalette() {
        return new ColorPalette(Arrays.asList(
                new Color(220, 20, 60),   // Rojo carmesí
                new Color(34, 139, 34),   // Verde bosque
                new Color(255, 140, 0),   // Naranja oscuro
                new Color(30, 144, 255),  // Azul dodger
                new Color(148, 0, 211),   // Violeta oscuro
                new Color(255, 215, 0),   // Dorado
                new Color(50, 205, 50),   // Verde lima
                new Color(220, 20, 60)    // Rojo carmesí (repetido para variación)
        ));
    }

    /**
     * Paleta de colores más suave
     */
    public static ColorPalette createSoftPalette() {
        return new ColorPalette(Arrays.asList(
                new Color(255, 182, 193), // Rosa claro
                new Color(173, 216, 230), // Azul claro
                new Color(144, 238, 144), // Verde claro
                new Color(255, 218, 185), // Melocotón
                new Color(221, 160, 221), // Ciruela claro
                new Color(250, 250, 210)  // Amarillo claro
        ));
    }

    public ColorPalette(List<Color> colors) {
        this.colors = colors;
    }

    /**
     * Obtiene un color basado en el nivel de recursión
     */
    public Color getColorForLevel(int level, int maxLevels) {
        if (colors.isEmpty()) {
            return Color.BLACK;
        }

        // Usar el nivel para determinar el color
        int colorIndex = level % colors.size();
        return colors.get(colorIndex);
    }

    /**
     * Obtiene un color con transparencia basado en el nivel
     */
    public Color getTransparentColorForLevel(int level, int maxLevels, int alpha) {
        Color baseColor = getColorForLevel(level, maxLevels);
        return new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), alpha);
    }
}