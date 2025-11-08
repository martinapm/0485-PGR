package es.foc.ejercicios.graficos.NotasManejador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Esta clase denominada VentanaPrincipal define una interfaz gráfica que
 * permitirá crear un array de notas. Luego, se puede calcular el promedio de
 * notas, la desviación, la nota mayor y la nota menor del array.
 *
 */
public class VentanaPrincipal extends JFrame {

    // Un contenedor de elementos gráficos
    private Container contenedor;
    // Etiquetas estáticas de cada nota
    private JLabel nota1, nota2, nota3, nota4, nota5, promedio, desviacion, mayor, menor;
    // Campos de ingreso de cada nota
    private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
    // Botones para realizar cálculos y para borrar las notas
    private JButton calcular, limpiar;

    /**
     * Constructor de la clase VentanaPrincipal
     */
    public VentanaPrincipal() {
        inicio();

        setTitle("Notas"); // Establece el título de la ventana
        setSize(280, 380); // Establece el tamaño de la ventana
        setLocationRelativeTo(null);
        /* La ventana se posiciona en el centro de la pantalla */
        // Establece que el botón de cerrar permitirá salir de la aplicación
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        /* Establece que el tamaño de la ventana no se puede cambiar */
    }

    /**
     * Método que crea la ventana con sus diferentes componentes gráficos
     */
    private void inicio() {
        contenedor = getContentPane();
        /* Obtiene el panel de contenidos de la ventana */
        contenedor.setLayout(null);
        /* Establece que el contenedor no tiene un layout */
        // Establece la etiqueta y el campo de texto de la nota 1
        nota1 = new JLabel();
        nota1.setText("Nota 1:");
        nota1.setBounds(20, 20, 135, 23);
        /* Establece la posición de la etiqueta nota 1 */
        campoNota1 = new JTextField();
        // Establece la posición del campo de texto de la nota 1
        campoNota1.setBounds(105, 20, 135, 23);
        // Establece la etiqueta y el campo de texto de la nota 2
        nota2 = new JLabel();
        nota2.setText("Nota 2:");
        nota2.setBounds(20, 50, 135, 23);
        /* Establece la posición de la etiqueta nota 2 */
        campoNota2 = new JTextField();
        // Establece la posición del campo de texto de la nota 2
        campoNota2.setBounds(105, 50, 135, 23);
        // Establece la etiqueta y el campo de texto de la nota 3
        nota3 = new JLabel();
        nota3.setText("Nota 3:");
        nota3.setBounds(20, 80, 135, 23);
        /* Establece la posición de la etiqueta nota 3*/
        campoNota3 = new JTextField();

        // Establece la posición del campo de texto de la nota 3
        campoNota3.setBounds(105, 80, 135, 23);
        // Establece la etiqueta y el campo de texto de la nota 4
        nota4 = new JLabel();
        nota4.setText("Nota 4:");
        nota4.setBounds(20, 110, 135, 23);
        /* Establece la posición de la etiqueta nota 4 */
        campoNota4 = new JTextField();
        // Establece la posición del campo de texto de la nota 4
        campoNota4.setBounds(105, 110, 135, 23);
        // Establece la etiqueta y el campo de texto de la nota 5
        nota5 = new JLabel();
        nota5.setText("Nota 5:");
        nota5.setBounds(20, 140, 135, 23);
        /* Establece la posición de la etiqueta nota 5 */
        campoNota5 = new JTextField();
        // Establece la posición del campo de texto de la nota 5
        campoNota5.setBounds(105, 140, 135, 23);
        // Establece el botón Calcular
        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(20, 170, 100, 23);
        /* Establece la posición del botón Calcular */
        /* Agrega al botón un ActionListener para que gestione eventos del botón */
        calcular.addActionListener(new ManejadorEventos(this));
        // Establece el botón Limpiar
        limpiar = new JButton();
        limpiar.setText("Limpiar");
        limpiar.setBounds(125, 170, 80, 23);
        /* Establece la posición del botón Limpiar */
        /* Agrega al botón un ActionListener para que gestione eventos del botón */
        limpiar.addActionListener(new ManejadorEventos(this));
        // Establece la etiqueta del promedio con su valor numérico
        promedio = new JLabel();
        promedio.setText("Promedio = ");
        promedio.setBounds(20, 210, 135, 23);
        /* Establece la posición de la etiqueta promedio */

        // Establece la etiqueta de la desviación con su valor numérico
        desviacion = new JLabel();
        desviacion.setText("Desviaci�n = ");
        desviacion.setBounds(20, 240, 200, 23);
        /* Establece la posición de la etiqueta desviación */
        // Establece la etiqueta de la nota mayor con su valor numérico
        mayor = new JLabel();
        mayor.setText("Nota mayor = ");
        mayor.setBounds(20, 270, 120, 23);
        /* Establece la posición de la etiqueta nota mayor */
        // Establece la etiqueta de la nota menor con su valor numérico
        menor = new JLabel();
        menor.setText("Nota menor = ");
        menor.setBounds(20, 300, 120, 23);
        /* Establece la posición de la etiquete nota menor */
        // Se añade cada componente gráfico al contenedor de la ventana
        contenedor.add(nota1);
        contenedor.add(campoNota1);
        contenedor.add(nota2);
        contenedor.add(campoNota2);
        contenedor.add(nota3);
        contenedor.add(campoNota3);
        contenedor.add(nota4);
        contenedor.add(campoNota4);
        contenedor.add(nota5);
        contenedor.add(campoNota5);
        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(promedio);
        contenedor.add(desviacion);
        contenedor.add(mayor);
        contenedor.add(menor);
    }

    public Container getContenedor() {
        return contenedor;
    }

    public void setContenedor(Container contenedor) {
        this.contenedor = contenedor;
    }

    public JLabel getNota1() {
        return nota1;
    }

    public void setNota1(JLabel nota1) {
        this.nota1 = nota1;
    }

    public JLabel getNota2() {
        return nota2;
    }

    public void setNota2(JLabel nota2) {
        this.nota2 = nota2;
    }

    public JLabel getNota3() {
        return nota3;
    }

    public void setNota3(JLabel nota3) {
        this.nota3 = nota3;
    }

    public JLabel getNota4() {
        return nota4;
    }

    public void setNota4(JLabel nota4) {
        this.nota4 = nota4;
    }

    public JLabel getNota5() {
        return nota5;
    }

    public void setNota5(JLabel nota5) {
        this.nota5 = nota5;
    }

    public JLabel getPromedio() {
        return promedio;
    }

    public void setPromedio(JLabel promedio) {
        this.promedio = promedio;
    }

    public JLabel getDesviacion() {
        return desviacion;
    }

    public void setDesviacion(JLabel desviacion) {
        this.desviacion = desviacion;
    }

    public JLabel getMayor() {
        return mayor;
    }

    public void setMayor(JLabel mayor) {
        this.mayor = mayor;
    }

    public JLabel getMenor() {
        return menor;
    }

    public void setMenor(JLabel menor) {
        this.menor = menor;
    }

    public JTextField getCampoNota1() {
        return campoNota1;
    }

    public void setCampoNota1(JTextField campoNota1) {
        this.campoNota1 = campoNota1;
    }

    public JTextField getCampoNota2() {
        return campoNota2;
    }

    public void setCampoNota2(JTextField campoNota2) {
        this.campoNota2 = campoNota2;
    }

    public JTextField getCampoNota3() {
        return campoNota3;
    }

    public void setCampoNota3(JTextField campoNota3) {
        this.campoNota3 = campoNota3;
    }

    public JTextField getCampoNota4() {
        return campoNota4;
    }

    public void setCampoNota4(JTextField campoNota4) {
        this.campoNota4 = campoNota4;
    }

    public JTextField getCampoNota5() {
        return campoNota5;
    }

    public void setCampoNota5(JTextField campoNota5) {
        this.campoNota5 = campoNota5;
    }

    public JButton getCalcular() {
        return calcular;
    }

    public void setCalcular(JButton calcular) {
        this.calcular = calcular;
    }

    public JButton getLimpiar() {
        return limpiar;
    }

    public void setLimpiar(JButton limpiar) {
        this.limpiar = limpiar;
    }


    
}