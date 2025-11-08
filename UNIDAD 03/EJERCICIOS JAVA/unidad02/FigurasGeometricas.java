package es.foc.ejercicios.unidad02;

import es.foc.ejercicios.unidad02.figuras.Circulo;
import es.foc.ejercicios.unidad02.figuras.Cuadrado;
import es.foc.ejercicios.unidad02.figuras.Rectangulo;
import es.foc.ejercicios.unidad02.figuras.TrianguloRectangulo;

public class FigurasGeometricas {
    public static void main(String[] args) {
        // Crear las figuras
        Circulo circulo = new Circulo(5);
        Rectangulo rectangulo = new Rectangulo(4, 6);
        Cuadrado cuadrado = new Cuadrado(4);
        TrianguloRectangulo triangulo = new TrianguloRectangulo(3, 4);
        
        TrianguloRectangulo trianguloIsosceles = new TrianguloRectangulo(6, 6);  // Triángulo rectángulo tipo "Isósceles"
        TrianguloRectangulo trianguloEscaleno = new TrianguloRectangulo(3, 4);  // Triángulo rectángulo tipo "Escaleno"
     
        
        
        // Mostrar resultados
        System.out.println("Círculo:");
        System.out.println("Área: " + circulo.calcularArea());
        System.out.println("Perímetro: " + circulo.calcularPerimetro());
        
        System.out.println("\nRectángulo:");
        System.out.println("Área: " + rectangulo.calcularArea());
        System.out.println("Perímetro: " + rectangulo.calcularPerimetro());
        
        System.out.println("\nCuadrado:");
        System.out.println("Área: " + cuadrado.calcularArea());
        System.out.println("Perímetro: " + cuadrado.calcularPerimetro());
        
        System.out.println("\nTriángulo Rectángulo:");
        System.out.println("Área: " + triangulo.calcularArea());
        System.out.println("Perímetro: " + triangulo.calcularPerimetro());
        System.out.println("Hipotenusa: " + triangulo.calcularHipotenusa());
        System.out.println("Tipo: " + triangulo.determinarTipoTriangulo());
                
       
        System.out.println("\nTriángulo Rectángulo Isósceles:");
        System.out.println("Área: " + trianguloIsosceles.calcularArea());
        System.out.println("Perímetro: " + trianguloIsosceles.calcularPerimetro());
        System.out.println("Hipotenusa: " + trianguloIsosceles.calcularHipotenusa());
        System.out.println("Tipo: " + trianguloIsosceles.determinarTipoTriangulo());
        
        System.out.println("\nTriángulo Rectángulo Escaleno:");
        System.out.println("Área: " + trianguloEscaleno.calcularArea());
        System.out.println("Perímetro: " + trianguloEscaleno.calcularPerimetro());
        System.out.println("Hipotenusa: " + trianguloEscaleno.calcularHipotenusa());
        System.out.println("Tipo: " + trianguloEscaleno.determinarTipoTriangulo());        
    }
}

