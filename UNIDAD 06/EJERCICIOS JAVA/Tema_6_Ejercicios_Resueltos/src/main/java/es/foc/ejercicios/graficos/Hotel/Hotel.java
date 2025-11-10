package es.foc.ejercicios.graficos.Hotel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Esta clase denominada Hotel define un hotel que contiene diez habitaciones a
 * ser ocupadas y liberadas por diferentes huéspedes en fechas determinadas.
 *
 */
public class Hotel {
    // Atributo que establece el conjunto de habitaciones del hotel

    public static Vector<Habitacion> listaHabitaciones;

    /**
     * Constructor de la clase Hotel
     */
    public Hotel() {
        listaHabitaciones = new Vector<Habitacion>();
        /* Crea el vector de habitaciones */
 /* Crea cada habitación con un número de habitación, disponibilidad inicial y precio por día */
        Habitacion habitacion1 = new Habitacion(1, true, 120000);
        Habitacion habitacion2 = new Habitacion(2, true, 120000);
        Habitacion habitacion3 = new Habitacion(3, true, 120000);
        Habitacion habitacion4 = new Habitacion(4, true, 120000);
        Habitacion habitacion5 = new Habitacion(5, true, 120000);
        Habitacion habitacion6 = new Habitacion(6, true, 160000);
        Habitacion habitacion7 = new Habitacion(7, true, 160000);
        Habitacion habitacion8 = new Habitacion(8, true, 160000);
        Habitacion habitacion9 = new Habitacion(9, true, 160000);
        Habitacion habitacion10 = new Habitacion(10, true, 160000);
        // Se agrega cada habitación al vector de habitaciones del hotel
        listaHabitaciones.add(habitacion1);
        listaHabitaciones.add(habitacion2);
        listaHabitaciones.add(habitacion3);
        listaHabitaciones.add(habitacion4);
        listaHabitaciones.add(habitacion5);
        listaHabitaciones.add(habitacion6);
        listaHabitaciones.add(habitacion7);
        listaHabitaciones.add(habitacion8);
        listaHabitaciones.add(habitacion9);
        listaHabitaciones.add(habitacion10);
    }

    /**
     * Método que dado un número de habitación, busca la fecha de ingreso de un
     * huésped a dicha habitación
     *
     * @param número Número de habitación a buscar
     * @return Fecha de ingreso a la habitación
     */
    public String buscarFechaIngresoHabitacion(int número) {
        for (int i = 0; i < listaHabitaciones.size(); i++) {
            /* Recorre el vector de habitaciones */
            // Obtiene un elemento del vector
            Habitacion habitacion = (Habitacion) listaHabitaciones.elementAt(i);
            if (habitacion.getNumeroHabitacion() == número) {
                /* Si el número buscado es encontrado */
                // Se obtiene la fecha de ingreso
                Date fecha = habitacion.getHuesped().getFechaIngreso();
                // Se le da formato a la fecha de ingreso
                DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
                return formatoFecha.format(fecha);
                /* Devuelve la fecha de ingreso */
            }
        }
        return ""; // En caso de no encontrar la habitación
    }

    /**
     * Método que dado un número de habitación, devuelve si la habitación está
     * ocupada o no
     *
     * @param número Número de habitación a buscar
     * @return Valor booleano con la disponibilidad de la habitación buscada
     */
    public boolean buscarHabitacionOcupada(int numero) {
        for (int i = 0; i < listaHabitaciones.size(); i++) {
            /* Recorre el vector de habitaciones */
            // Obtiene un elemento del vector
            Habitacion habitacion = (Habitacion) listaHabitaciones.elementAt(i);
            if (habitacion.getNumeroHabitacion() == numero && !habitacion.getDisponible()) {
                // Si la habitación está disponible
                return true;
            }
        }
        return false; // Si la habitación no está disponible
    }
}
