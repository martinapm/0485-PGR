package es.foc.ejercicios.unidad03;

import java.util.Scanner;

public class EjerciciosBloque2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Ejercicios ---");
            System.out.println("1. Nombre con primera letra mayúscula");
            System.out.println("2. Letras separadas por espacios");
            System.out.println("3. Triángulo con las letras de una palabra");
            System.out.println("4. Cantidad de palabras y letras en una frase");
            System.out.println("5. Validar hora en formato HH:MM");
            System.out.println("6. Comprobar si una palabra es un palíndromo");
            System.out.println("7. Verificar si un String contiene solo letras");
            System.out.println("8. Eliminar espacios en blanco de una cadena");
            System.out.println("9. Mensaje personalizado con datos personales");
            System.out.println("10. Palabra más larga entre 10 palabras");
            System.out.println("11. Cambiar mayúsculas a minúsculas y viceversa");
            System.out.println("12. Letra más frecuente en una frase");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 ->
                    ejercicio1(scanner);
                case 2 ->
                    ejercicio2(scanner);
                case 3 ->
                    ejercicio3(scanner);
                case 4 ->
                    ejercicio4(scanner);
                case 5 ->
                    ejercicio5(scanner);
                case 6 ->
                    ejercicio6(scanner);
                case 7 ->
                    ejercicio7(scanner);
                case 8 ->
                    ejercicio8(scanner);
                case 9 ->
                    ejercicio9(scanner);
                case 10 ->
                    ejercicio10(scanner);
                case 11 ->
                    ejercicio11(scanner);
                case 12 ->
                    ejercicio12(scanner);
                case 0 ->
                    System.out.println("Saliendo...");
                default ->
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    // Ejercicio 1
    public static void ejercicio1(Scanner scanner) {
        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();
        String formateado = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
        System.out.println("Nombre formateado: " + formateado);
    }

    // Ejercicio 2
    public static void ejercicio2(Scanner scanner) {
        System.out.print("Introduce un nombre: ");
        String nombre = scanner.nextLine();
        String resultado = String.join(" ", nombre.split(""));
        System.out.println("Letras separadas: " + resultado);
    }

    // Ejercicio 3
    public static void ejercicio3(Scanner scanner) {
        System.out.print("Introduce una palabra: ");
        String palabra = scanner.nextLine();
        for (int i = 1; i <= palabra.length(); i++) {
            System.out.println(palabra.substring(0, i));
        }
    }

    // Ejercicio 4
    public static void ejercicio4(Scanner scanner) {
        System.out.print("Introduce una frase: ");
        String frase = scanner.nextLine();
        String[] palabras = frase.split(" ");
        int totalLetras = frase.replaceAll(" ", "").length();
        System.out.println("Cantidad de palabras: " + palabras.length);
        System.out.println("Cantidad de letras: " + totalLetras);
    }

    public static void ejercicio5(Scanner scanner) {
        System.out.print("Introduce una hora (HH:MM): ");
        String hora = scanner.nextLine();

        if (hora.length() != 5 || hora.charAt(2) != ':') {
            System.out.println("Formato de hora incorrecto.");
            return;
        }

        try {
            int horas = Integer.parseInt(hora.substring(0, 2));
            int minutos = Integer.parseInt(hora.substring(3, 5));

            if (horas >= 0 && horas < 24 && minutos >= 0 && minutos < 60) {
                System.out.println("La hora es válida.");
            } else {
                System.out.println("La hora no es válida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Formato de hora incorrecto.");
        }
    }

    // Ejercicio 6
    public static void ejercicio6(Scanner scanner) {
        System.out.print("Introduce una palabra: ");
        String palabra = scanner.nextLine().toLowerCase();
        String invertida = new StringBuilder(palabra).reverse().toString();
        if (palabra.equals(invertida)) {
            System.out.println("Es un palíndromo.");
        } else {
            System.out.println("No es un palíndromo.");
        }
    }

    // Ejercicio 7
    public static void ejercicio7(Scanner scanner) {
        System.out.print("Introduce un texto: ");
        String texto = scanner.nextLine();
        boolean soloLetras = true;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (!Character.isLetter(c)) {
                soloLetras = false;
                break;
            }
        }

        if (soloLetras) {
            System.out.println("El texto contiene solo letras.");
        } else {
            System.out.println("El texto contiene otros caracteres.");
        }
    }

    // Ejercicio 8
    public static void ejercicio8(Scanner scanner) {
        System.out.print("Introduce un texto: ");
        String texto = scanner.nextLine();
        String sinEspacios = texto.replaceAll(" ", "");
        System.out.println("Texto sin espacios: " + sinEspacios);
    }

    // Ejercicio 9
    public static void ejercicio9(Scanner scanner) {
        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce tus apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Introduce tu año de nacimiento: ");
        int anioNacimiento = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        int edad = 2024 - anioNacimiento;
        System.out.print("Introduce tu ciudad de residencia: ");
        String ciudad = scanner.nextLine();

        System.out.println("\n--- Mensaje Personalizado ---");
        System.out.println("Hola, " + nombre + " " + apellidos + ". Tienes " + edad + " años y vives en " + ciudad + ".");
    }

    // Ejercicio 10
    public static void ejercicio10(Scanner scanner) {
        String[] palabras = new String[10];
        System.out.println("Introduce 10 palabras:");
        for (int i = 0; i < 10; i++) {
            palabras[i] = scanner.nextLine();
        }
        String palabraMasLarga = "";
        for (String palabra : palabras) {
            if (palabra.length() > palabraMasLarga.length()) {
                palabraMasLarga = palabra;
            }
        }
        System.out.println("La palabra más larga es: " + palabraMasLarga);
    }

    // Ejercicio 11
    public static void ejercicio11(Scanner scanner) {
        System.out.print("Introduce un texto: ");
        String texto = scanner.nextLine();
        StringBuilder resultado = new StringBuilder();
        int cambios = 0;

        for (char c : texto.toCharArray()) {
            if (Character.isUpperCase(c)) {
                resultado.append(Character.toLowerCase(c));
                cambios++;
            } else if (Character.isLowerCase(c)) {
                resultado.append(Character.toUpperCase(c));
                cambios++;
            } else {
                resultado.append(c);
            }
        }

        System.out.println("Texto transformado: " + resultado);
        System.out.println("Número de cambios: " + cambios);
    }

    // Ejercicio 12
    public static void ejercicio12(Scanner scanner) {
        System.out.print("Introduce una frase: ");
        String frase = scanner.nextLine().replaceAll(" ", "");
        int[] frecuencias = new int[256];

        for (char c : frase.toCharArray()) {
            frecuencias[c]++;
        }

        char letraMasFrecuente = 0;
        int maxFrecuencia = 0;

        for (int i = 0; i < frecuencias.length; i++) {
            if (frecuencias[i] > maxFrecuencia) {
                maxFrecuencia = frecuencias[i];
                letraMasFrecuente = (char) i;
            }
        }

        System.out.println("Letra más frecuente: " + letraMasFrecuente + " (aparece " + maxFrecuencia + " veces)");
    }
}
