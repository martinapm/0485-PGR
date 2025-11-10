package es.foc.ejercicios.unidad06.Libreria.Comparadores.Clientes;
import es.foc.ejercicios.unidad06.Libreria.Cliente;

import java.util.Comparator;

    public class ComparadorPorEdad implements Comparator<Cliente> {

        public int compare(Cliente p1, Cliente p2) {
            int resultado =  p1.getEdad() - p2.getEdad();
            if(resultado == 0){
                resultado = p1.getNombre().compareTo(p2.getNombre());            
            }                
            return resultado;
        }
    }