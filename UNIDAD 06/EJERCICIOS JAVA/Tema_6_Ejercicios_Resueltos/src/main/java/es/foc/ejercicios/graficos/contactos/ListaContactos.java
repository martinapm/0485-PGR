package es.foc.ejercicios.graficos.contactos;

import java.util.ArrayList;

/**
 * Esta clase denominada ListaContactos define una lista de objetos de tipo
 * Contacto.
 *
 */
public class ListaContactos {

    ArrayList<Contacto> lista;

    /**
     * Constructor de la clase ListaContactos
     */
    public ListaContactos() {
        lista = new ArrayList<>(); // Crea un vector
    }

    /**
     * Método que agrega un contacto a la lista de contactos
     *
     * @param contacto Parámetro que define el contacto a agregar
     */
    public void agregarContacto(Contacto contacto) {
        lista.add(contacto);
    }
}
