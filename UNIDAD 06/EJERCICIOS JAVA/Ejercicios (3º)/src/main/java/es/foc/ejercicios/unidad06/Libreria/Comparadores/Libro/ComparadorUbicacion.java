
package es.foc.ejercicios.unidad06.Libreria.Comparadores.Libro;

import es.foc.ejercicios.unidad06.Libreria.Libro;
import java.util.Comparator;

/**
 *
 * @author PGR - ED
 */
public class ComparadorUbicacion implements Comparator<Libro> {

    @Override
    public int compare(Libro lib1, Libro lib2) {
        int comparacion;
        
        comparacion = lib1.getCategoria().getPasillo() - lib2.getCategoria().getPasillo();
        if(comparacion == 0){
            comparacion = lib1.getCategoria().getEstanteria()- lib2.getCategoria().getEstanteria();
        }
        
        if(comparacion == 0){
            comparacion = lib1.getTitulo().compareTo(lib2.getTitulo());
        }
        
        return comparacion;
    }
    
}
