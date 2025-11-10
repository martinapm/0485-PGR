package es.foc.ejercicios.unidad06.Libreria.Comparadores.Clientes;

import es.foc.ejercicios.unidad06.Libreria.Cliente;
import java.util.Comparator;

    public class ComparadorPorNombre implements Comparator<Cliente> {

        public int compare(Cliente p1, Cliente p2) {
            return p1.getNombre().compareTo(p2.getNombre());
        }
    }

