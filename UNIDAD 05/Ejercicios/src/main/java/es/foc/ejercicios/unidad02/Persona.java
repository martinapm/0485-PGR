package es.foc.ejercicios.unidad02;

public class Persona {
    // Atributos de la clase Persona
    private String nombre;
    private String apellido;
    private String documentoIdentidad;
    private int anioNacimiento;

    // Constructor para inicializar los atributos
    public Persona(String nombre, String apellido, String documentoIdentidad, int anioNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documentoIdentidad = documentoIdentidad;
        this.anioNacimiento = anioNacimiento;
    }

    // Método para imprimir los valores de los atributos
    public void imprimirInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Documento de Identidad: " + documentoIdentidad);
        System.out.println("Año de Nacimiento: " + anioNacimiento);
        System.out.println();
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        // Crear dos objetos Persona
        Persona persona1 = new Persona("Mariano", "Gómez", "12345678A", 1990);
        Persona persona2 = new Persona("Jaimito", "López", "87654321B", 1985);

        // Mostrar los valores de los atributos de las personas
        System.out.println("Información de Persona 1:");
        persona1.imprimirInformacion();

        System.out.println("Información de Persona 2:");
        persona2.imprimirInformacion();
    }
}
