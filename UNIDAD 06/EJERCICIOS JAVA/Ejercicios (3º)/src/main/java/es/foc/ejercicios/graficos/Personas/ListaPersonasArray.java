package es.foc.ejercicios.graficos.Personas;

/**
 * Esta clase denominada ListaPersonas define una lista de Personas usando un array.
 */
public class ListaPersonasArray {

    private Persona[] listaPersonas; // Atributo que identifica un array de personas
    private int cantidad; // Contador para saber cuántas personas hay en la lista
    private static final int CAPACIDAD_MAXIMA = 100; // Capacidad máxima del array

    /**
     * Constructor de la clase ListaPersonas
     */
    public ListaPersonasArray() {
        listaPersonas = new Persona[CAPACIDAD_MAXIMA]; // Crea el array con capacidad máxima
        cantidad = 0; // Inicialmente no hay elementos en la lista
    }

    /**
     * Método que permite agregar una persona al array de personas
     *
     * @param p Parámetro que define la persona a agregar al array de personas
     */
    public void añadirPersona(Persona p) {
        if (cantidad < CAPACIDAD_MAXIMA) {
            listaPersonas[cantidad] = p;
            cantidad++;
        } else {
            System.out.println("La lista de personas está llena.");
        }
    }

    /**
     * Método que permite eliminar una persona del array de personas
     *
     * @param i Parámetro que define la posición a eliminar en el array de personas
     */
    public void eliminarPersona(int i) {
        if (i >= 0 && i < cantidad) {
            for (int j = i; j < cantidad - 1; j++) {
                listaPersonas[j] = listaPersonas[j + 1]; // Desplaza los elementos hacia la izquierda
            }
            listaPersonas[cantidad - 1] = null; // Elimina la última referencia
            cantidad--;
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    /**
     * Método que permite eliminar todos los elementos del array de personas
     */
    public void borrarLista() {
        for (int i = 0; i < cantidad; i++) {
            listaPersonas[i] = null; // Limpia el array
        }
        cantidad = 0;
    }

    /**
     * Método que devuelve la cantidad de personas almacenadas en el array
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Método que obtiene una persona en una posición específica
     *
     * @param index Índice de la persona a obtener
     * @return La persona en la posición indicada o null si el índice no es válido
     */
    public Persona obtenerPersona(int index) {
        if (index >= 0 && index < cantidad) {
            return listaPersonas[index];
        }
        return null;
    }
}
