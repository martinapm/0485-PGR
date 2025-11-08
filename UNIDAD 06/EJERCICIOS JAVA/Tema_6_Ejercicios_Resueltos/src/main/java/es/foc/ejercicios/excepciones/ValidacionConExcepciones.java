package es.foc.ejercicios.excepciones;

import es.foc.ejercicios.excepciones.util.EquipoMaratonProgramacion;
import es.foc.ejercicios.excepciones.util.Programador;
import java.util.*;

public class ValidacionConExcepciones {

    /**
     * Método main que solicita ingresar por teclado el nombre del equipo, la
     * universidad, el lenguaje de programación, crea un equipo de maratón de
     * programación y luego solicita ingresar por teclado tres integrantes del
     * equipo, realizando las validaciones de datos.
     */
    public static void main(String args[]) throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Nombre del equipo = ");
        String nombre = teclado.next();
        System.out.println("Universidad = ");
        String universidad = teclado.next();
        System.out.println("Lenguaje de programación = ");
        String lenguaje = teclado.next();
        EquipoMaratonProgramacion equipo = new EquipoMaratonProgramacion(nombre, universidad, lenguaje);
        System.out.println("Datos de los integrantes del equipo");
        String nombreProgramador;
        String apellidosProgramador;
        for (int i = 0; i < 3; i++) {
            System.out.println("Nombre del integrante = ");
            nombreProgramador = teclado.next();
            EquipoMaratonProgramacion.validarCampo(nombreProgramador);
            /* Valida que el nombre del integrante sea correcto */
            System.out.println("Apellidos del integrante = ");
            apellidosProgramador = teclado.next();
            EquipoMaratonProgramacion.validarCampo(apellidosProgramador);
            /* Valida que el apellido sea correcto */
            Programador programador = new Programador(nombreProgramador,apellidosProgramador); // Crea un programador
            equipo.añadir(programador);
            /* Añade el programador al array de programadores */
        }
    }
}

