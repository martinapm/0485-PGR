/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.foc.ejercicios.unidad06.Libreria.Comparadores.Clientes;

import es.foc.ejercicios.unidad06.Libreria.Cliente;
import java.util.Comparator;


    public class ComparadorPorAltura implements Comparator<Cliente> {

        public int compare(Cliente p1, Cliente p2) {
            return Double.compare(p1.getAltura(), p2.getAltura());
        }
    }
