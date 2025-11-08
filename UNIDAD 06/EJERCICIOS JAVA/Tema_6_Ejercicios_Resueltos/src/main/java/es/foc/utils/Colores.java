package es.foc.utils;

public class Colores {
    // Códigos ANSI para restablecer y estilos
    public static final String RESET = "\u001B[0m";
    public static final String NEGRITA = "\u001B[1m";
    public static final String SUBRAYADO = "\u001B[4m";

    // Colores de texto
    public static final String NEGRO = "\u001B[30m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CIAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";

    // Colores de fondo
    public static final String FONDO_NEGRO = "\u001B[40m";
    public static final String FONDO_ROJO = "\u001B[41m";
    public static final String FONDO_VERDE = "\u001B[42m";
    public static final String FONDO_AMARILLO = "\u001B[43m";
    public static final String FONDO_AZUL = "\u001B[44m";
    public static final String FONDO_MAGENTA = "\u001B[45m";
    public static final String FONDO_CIAN = "\u001B[46m";
    public static final String FONDO_BLANCO = "\u001B[47m";

    // Método para aplicar un color al texto
    public static String colorear(String texto, String color) {
        return color + texto + RESET;
    }

    // Método para aplicar color de fondo
    public static String colorearFondo(String texto, String colorFondo) {
        return colorFondo + texto + RESET;
    }

    // Método para aplicar color y negrita
    public static String colorearNegrita(String texto, String color) {
        return NEGRITA + color + texto + RESET;
    }

    // Método para aplicar subrayado y color
    public static String colorearSubrayado(String texto, String color) {
        return SUBRAYADO + color + texto + RESET;
    }
}
