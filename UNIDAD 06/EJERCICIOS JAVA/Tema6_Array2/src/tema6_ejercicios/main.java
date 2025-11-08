package tema6_ejercicios;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creación de la tienda con capacidad para 5 computadores
        Tienda tienda = new Tienda("TechStore", "Carlos Pérez", "123456789", 5);

        int opcion;

        do {
            System.out.println("\n--- Menú Tienda de Computadores ---");
            System.out.println("1. Agregar computador");
            System.out.println("2. Eliminar computador por marca");
            System.out.println("3. Buscar computador por marca");
            System.out.println("4. Listar computadores");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            // Validación para evitar errores con la entrada del usuario
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                sc.next(); // Limpiar entrada incorrecta
            }
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Memoria (GB): ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Ingrese un número válido para la memoria.");
                        sc.next();
                    }
                    int memoria = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Procesador: ");
                    String procesador = sc.nextLine();
                    System.out.print("Sistema Operativo: ");
                    String so = sc.nextLine();
                    System.out.print("Precio: ");
                    while (!sc.hasNextDouble()) {
                        System.out.println("Ingrese un precio válido.");
                        sc.next();
                    }
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    Computador nuevo = new Computador(marca, memoria, procesador, so, precio);
                    tienda.agregarComputador(nuevo);
                    System.out.println("Computador agregado exitosamente.");
                    break;

                case 2:
                    System.out.print("Ingrese la marca del computador a eliminar: ");
                    String marcaEliminar = sc.nextLine();
                    tienda.eliminarComputador(marcaEliminar);
                    break;

                case 3:
                    System.out.print("Ingrese la marca del computador a buscar: ");
                    String marcaBuscar = sc.nextLine();
                    tienda.buscarComputador(marcaBuscar);
                    break;

                case 4:
                    tienda.listarComputadores();
                    break;

                case 5:
                    System.out.println("Gracias por usar el sistema. Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
