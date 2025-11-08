
package es.foc.ejercicios.unidad06.EJ_06;

import java.util.*;

public class AgendaContactos {


    private Map<String, String> contactos;


    public AgendaContactos() {
        contactos = new LinkedHashMap<>();
    }

    // Método para agregar un contacto
    public void agregarContacto(String nombre, String telefono) {
        // Convierte el nombre a minúsculas para evitar duplicados sensibles a mayúsculas
        if (!contactos.containsKey(nombre.toLowerCase())) {
            contactos.put(nombre.toLowerCase(), telefono);
            System.out.println("Contacto " + nombre + " agregado.");
        } else {
            System.out.println("El contacto " + nombre + " ya existe.");
        }
    }

    // Método para mostrar todos los contactos
    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos guardados.");
        } else {
            System.out.println("Contactos guardados:");
            for (Map.Entry<String, String> entry : contactos.entrySet()) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    // Método para buscar un contacto por nombre
    public void buscarContacto(String nombre) {
        String telefono = contactos.get(nombre.toLowerCase());
        if (telefono != null) {
            System.out.println("Teléfono de " + nombre + ": " + telefono);
        } else {
            System.out.println("El contacto " + nombre + " no existe.");
        }
    }

    // Método para eliminar un contacto por nombre
    public void eliminarContacto(String nombre) {
        if (contactos.remove(nombre.toLowerCase()) != null) {
            System.out.println("Contacto " + nombre + " eliminado.");
        } else {
            System.out.println("El contacto " + nombre + " no se encuentra.");
        }
    }

    // Método para editar un contacto existente
    public void editarContacto(String nombre, String nuevoTelefono) {
        if (contactos.containsKey(nombre.toLowerCase())) {
            contactos.put(nombre.toLowerCase(), nuevoTelefono);
            System.out.println("Teléfono de " + nombre + " actualizado.");
        } else {
            System.out.println("El contacto " + nombre + " no existe.");
        }
    }

    // Menú interactivo
    public static void main(String[] args) {
        AgendaContactos agenda = new AgendaContactos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1. Agregar contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Editar contacto");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombreAgregar = scanner.nextLine();
                    System.out.print("Ingrese el teléfono: ");
                    String telefonoAgregar = scanner.nextLine();
                    agenda.agregarContacto(nombreAgregar, telefonoAgregar);
                    break;

                case 2:
                    agenda.mostrarContactos();
                    break;

                case 3:
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    agenda.buscarContacto(nombreBuscar);
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    agenda.eliminarContacto(nombreEliminar);
                    break;

                case 5:
                    System.out.print("Ingrese el nombre del contacto a editar: ");
                    String nombreEditar = scanner.nextLine();
                    System.out.print("Ingrese el nuevo teléfono: ");
                    String telefonoEditar = scanner.nextLine();
                    agenda.editarContacto(nombreEditar, telefonoEditar);
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
