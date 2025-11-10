package es.foc.ejercicios.graficos.swing.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimacionFiguras extends JPanel {
    private int xCirculo = 50, yCirculo = 100;
    private int xRectangulo = 200, yRectangulo = 150;
    private int xLineaInicio = 300, xLineaFin = 350;
    private int xPoligono = 150, yPoligono = 200;
    private int xHexagono = 400, yHexagono = 250;
    
    private int velocidadCirculo = 4;
    private int velocidadRectangulo = 3;
    private int velocidadLinea = 5;
    private int velocidadPoligono = 2;
    private int velocidadHexagono = 3;

    public AnimacionFiguras() {
        // Temporizador para actualizar la animación
        // Crear un temporizador que genera un evento cada 40 milisegundos
        Timer timer = new Timer(40, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                pintarFiguras();
            }
        }); 
        timer.start();
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar fondo
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Dibujar círculo
        g.setColor(Color.RED);
        g.fillOval(xCirculo, yCirculo, 50, 50);

        // Dibujar rectángulo
        g.setColor(Color.BLUE);
        g.fillRect(xRectangulo, yRectangulo, 80, 50);

        // Dibujar línea gruesa
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GREEN);
        g2.setStroke(new BasicStroke(5));  // Grosor de línea
        g2.drawLine(xLineaInicio, 200, xLineaFin, 250);

        // Dibujar triángulo (polígono de 3 lados)
        g.setColor(Color.MAGENTA);
        int[] xPuntosTriangulo = {xPoligono, xPoligono + 40, xPoligono + 20};
        int[] yPuntosTriangulo = {yPoligono, yPoligono, yPoligono - 50};
        g.fillPolygon(xPuntosTriangulo, yPuntosTriangulo, 3);

        // Dibujar hexágono
        g.setColor(Color.ORANGE);
        int[] xPuntosHexagono = {
            xHexagono, xHexagono + 30, xHexagono + 60,
            xHexagono + 60, xHexagono + 30, xHexagono
        };
        int[] yPuntosHexagono = {
            yHexagono + 20, yHexagono, yHexagono + 20,
            yHexagono + 50, yHexagono + 70, yHexagono + 50
        };
        g.fillPolygon(xPuntosHexagono, yPuntosHexagono, 6);

        // Dibujar texto
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Animación de Figuras", 200, 50);
    }

    public void pintarFiguras() {
        // Mover círculo horizontalmente
        xCirculo += velocidadCirculo;
        if (xCirculo > getWidth() - 50 || xCirculo < 0) {
            velocidadCirculo = -velocidadCirculo;
        }

        // Mover rectángulo verticalmente
        yRectangulo += velocidadRectangulo;
        if (yRectangulo > getHeight() - 50 || yRectangulo < 0) {
            velocidadRectangulo = -velocidadRectangulo;
        }

        // Mover la línea de lado a lado
        xLineaInicio += velocidadLinea;
        xLineaFin += velocidadLinea;
        if (xLineaFin > getWidth() || xLineaInicio < 0) {
            velocidadLinea = -velocidadLinea;
        }

        // Mover el triángulo en diagonal
        xPoligono += velocidadPoligono;
        yPoligono -= velocidadPoligono;
        if (xPoligono > getWidth() - 40 || xPoligono < 0 || yPoligono < 50 || yPoligono > getHeight()) {
            velocidadPoligono = -velocidadPoligono;
        }

        // Mover el hexágono horizontalmente
        xHexagono += velocidadHexagono;
        if (xHexagono > getWidth() - 60 || xHexagono < 0) {
            velocidadHexagono = -velocidadHexagono;
        }

        repaint();  // Redibujar la pantalla
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Animación de Figuras");
        AnimacionFiguras animacion = new AnimacionFiguras();

        ventana.add(animacion);
        ventana.setSize(600, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
