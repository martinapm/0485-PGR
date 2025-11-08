package es.foc.ejercicios.unidad06.EJ_05;

import java.util.*;

public class RegistroParticipantes {

    private Set<String> participantes;

    // Constructor
    public RegistroParticipantes() {
        participantes = new LinkedHashSet<>();
    }

    // Método para agregar un participante
    public void agregarParticipante(String nombre) {
        // Convierte el nombre a minúsculas para evitar duplicados sensibles a mayúsculas
        if (participantes.add(nombre.toLowerCase())) {
            System.out.println("Participante " + nombre + " agregado.");
        } else {
            System.out.println("El participante ya está registrado.");
        }
    }

    // Método para mostrar los participantes
    public void mostrarParticipantes() {
        if (participantes.isEmpty()) {
            System.out.println("No hay participantes registrados.");
        } else {
            System.out.println("Participantes registrados:");
            for (String participante : participantes) {
                System.out.println("- " + participante);
            }
        }
    }

    // Método para eliminar un participante
    public void eliminarParticipante(String nombre) {
        if (participantes.remove(nombre.toLowerCase())) {
            System.out.println("Participante " + nombre + " eliminado.");
        } else {
            System.out.println("El participante no se encuentra registrado.");
        }
    }

    // Método para contar los participantes
    public void contarParticipantes() {
        System.out.println("Número de participantes registrados: " + participantes.size());
    }

    // Método para verificar si un participante está registrado
    public void verificarParticipante(String nombre) {
        if (participantes.contains(nombre.toLowerCase())) {
            System.out.println("El participante " + nombre + " está registrado.");
        } else {
            System.out.println("El participante " + nombre + " no está registrado.");
        }
    }

    // Menú interactivo
    public static void main(String[] args) {
        RegistroParticipantes registro = new RegistroParticipantes();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1. Agregar participante");
            System.out.println("2. Mostrar participantes");
            System.out.println("3. Eliminar participante");
            System.out.println("4. Verificar participante");
            System.out.println("5. Contar participantes");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del participante: ");
                    String nombreAgregar = scanner.nextLine();
                    registro.agregarParticipante(nombreAgregar);
                    break;

                case 2:
                    registro.mostrarParticipantes();
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del participante a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    registro.eliminarParticipante(nombreEliminar);
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del participante a verificar: ");
                    String nombreVerificar = scanner.nextLine();
                    registro.verificarParticipante(nombreVerificar);
                    break;

                case 5:
                    registro.contarParticipantes();
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
