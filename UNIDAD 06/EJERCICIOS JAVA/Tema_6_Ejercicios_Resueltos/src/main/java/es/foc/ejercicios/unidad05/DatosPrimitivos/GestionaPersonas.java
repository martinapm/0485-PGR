package es.foc.ejercicios.unidad05.DatosPrimitivos;

import java.io.*;
import java.util.Scanner;

public class GestionaPersonas {

    private static final String nombreArchivo = "personas.dat";

    public static void escribirDatos() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(nombreArchivo))) {
            dos.writeUTF("Juan Pérez");
            dos.writeInt(30);
            dos.writeDouble(1.75);

            dos.writeUTF("Ana Gómez");
            dos.writeInt(25);
            dos.writeDouble(1.68);

            System.out.println("Datos escritos correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir los datos: " + e.getMessage());
        }
    }

    public static void leerDatos() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(nombreArchivo))) {
            while (dis.available() > 0) {
                String nombre = dis.readUTF();
                int edad = dis.readInt();
                double altura = dis.readDouble();

                System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Altura: " + altura);
            }
        } catch (IOException e) {
            System.err.println("Error al leer los datos: " + e.getMessage());
        }
    }

    public static void escribirDatosDesdeTeclado() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(nombreArchivo))) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("¿Cuántas personas desea registrar?");
            int numPersonas = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea pendiente

            for (int i = 0; i < numPersonas; i++) {
                System.out.println("Ingrese el nombre:");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese la edad:");
                int edad = scanner.nextInt();
                System.out.println("Ingrese la altura:");
                double altura = scanner.nextDouble();
                scanner.nextLine(); // Consumir la línea pendiente

                dos.writeUTF(nombre);
                dos.writeInt(edad);
                dos.writeDouble(altura);
            }
            System.out.println("Datos escritos correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir los datos: " + e.getMessage());
        }
    }

    public static void buscarPorNombre(String nombreBuscado) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(nombreArchivo))) {
            boolean encontrado = false;
            while (dis.available() > 0) {
                String nombre = dis.readUTF();
                int edad = dis.readInt();
                double altura = dis.readDouble();

                if (nombre.equalsIgnoreCase(nombreBuscado)) {
                    System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Altura: " + altura);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Persona no encontrada.");
            }
        } catch (IOException e) {
            System.err.println("Error al leer los datos: " + e.getMessage());
        }
    }

    public static void calcularPromedioEdad() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(nombreArchivo))) {
            int sumaEdades = 0;
            int contador = 0;

            while (dis.available() > 0) {
                dis.readUTF(); // Leer y descartar el nombre
                int edad = dis.readInt();
                dis.readDouble(); // Leer y descartar la altura

                sumaEdades += edad;
                contador++;
            }

            if (contador > 0) {
                double promedio = (double) sumaEdades / contador;
                System.out.println("El promedio de edad es: " + promedio);
            } else {
                System.out.println("No hay datos para calcular el promedio.");
            }
        } catch (IOException e) {
            System.err.println("Error al leer los datos: " + e.getMessage());
        }
    }

    public static void respaldarEnArchivoTexto(String archivoTexto) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(nombreArchivo)); PrintWriter pw = new PrintWriter(new FileWriter(archivoTexto))) {

            while (dis.available() > 0) {
                String nombre = dis.readUTF();
                int edad = dis.readInt();
                double altura = dis.readDouble();

                pw.println("Nombre: " + nombre + ", Edad: " + edad + ", Altura: " + altura);
            }
            System.out.println("Respaldo realizado correctamente en " + archivoTexto);
        } catch (IOException e) {
            System.err.println("Error al realizar el respaldo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        escribirDatosDesdeTeclado();
        leerDatos();
        buscarPorNombre("Ana López");
        calcularPromedioEdad();
        respaldarEnArchivoTexto("respaldo.txt");
    }
}
