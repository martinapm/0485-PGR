
package es.foc.ejercicios.graficos.NotasManejador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;


class ManejadorEventos implements ActionListener {

    private VentanaPrincipal ventana;

    public ManejadorEventos(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        JButton source = (JButton) evento.getSource();
        if (source.getText().equals("Calcular")) {
            Notas notas = new Notas();
            

            notas.listaNotas[0] = Double.parseDouble(ventana.getCampoNota1().getText());
            notas.listaNotas[1] = Double.parseDouble(ventana.getCampoNota2().getText());
            notas.listaNotas[2] = Double.parseDouble(ventana.getCampoNota3().getText());
            notas.listaNotas[3] = Double.parseDouble(ventana.getCampoNota4().getText());
            notas.listaNotas[4] = Double.parseDouble(ventana.getCampoNota5().getText());

            ventana.getPromedio().setText("Promedio = " + String.format("%.2f", notas.calcularPromedio()));
            ventana.getDesviacion().setText("Desviación estándar = " + String.format("%.2f", notas.calcularDesviacion()));
            ventana.getMayor().setText("Nota mayor = " + notas.calcularMayor());
            ventana.getMenor().setText("Nota menor = " + notas.calcularMenor());
        } else if (source.getText().equals("Limpiar")) {
            ventana.getCampoNota1().setText("");
            ventana.getCampoNota2().setText("");
            ventana.getCampoNota3().setText("");
            ventana.getCampoNota4().setText("");
            ventana.getCampoNota5().setText("");
        }
    }
}