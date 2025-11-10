package es.foc.ejercicios.unidad02;

import es.foc.ejercicios.unidad02.pelicula.enums.Genero;

public class Pelicula {

    // Atributos privados
    private String nombre;
    private String director;
    private Genero genero;
    private int duracion; // en minutos
    private int anio;
    private double calificacion;

    // Constructor
    public Pelicula(String nombre, String director, Genero genero, int duracion, int anio, double calificacion) {
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.anio = anio;
        this.calificacion = calificacion;
    }

    // Métodos get
    public String getNombre() {
        return nombre;
    }

    public String getDirector() {
        return director;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getAnio() {
        return anio;
    }

    public double getCalificacion() {
        return calificacion;
    }

    // Métodos set (privados)
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setDirector(String director) {
        this.director = director;
    }

    private void setGenero(Genero genero) {
        this.genero = genero;
    }

    private void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    private void setAnio(int anio) {
        this.anio = anio;
    }

    private void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    // Método imprimir
    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Director: " + director);
        System.out.println("Género: " + genero);
        System.out.println("Duración: " + duracion + " minutos");
        System.out.println("Año: " + anio);
        System.out.println("Calificación: " + calificacion);
    }

    // Método privado esPeliculaEpica()
    private boolean esPeliculaEpica() {
        return duracion >= 180;
    }

    // Método privado calcularValoracion()
    private String calcularValoracion() {
        if (calificacion >= 0 && calificacion <= 2) {
            return "Muy mala";
        } else if (calificacion > 2 && calificacion <= 5) {
            return "Mala";
        } else if (calificacion > 5 && calificacion <= 7) {
            return "Regular";
        } else if (calificacion > 7 && calificacion <= 8) {
            return "Buena";
        } else if (calificacion > 8 && calificacion <= 10) {
            return "Excelente";
        } else {
            return "Sin valoración válida";
        }
    }

    // Método privado esSimilar()
    private boolean esSimilar(Pelicula otraPelicula) {
        return this.genero == otraPelicula.genero
                && this.calcularValoracion().equals(otraPelicula.calcularValoracion());
    }

    // Método main
    public static void main(String[] args) {
        // Crear dos películas
        Pelicula pelicula1 = new Pelicula("Gandhi", "Richard Attenborough", Genero.DRAMA, 191, 1982, 8.1);
        Pelicula pelicula2 = new Pelicula("Thor", "Kenneth Branagh", Genero.ACCION, 115, 2011, 7.0);

        // Mostrar información de las películas
        System.out.println("Información de las películas:");
        System.out.println("Película 1:");
        pelicula1.imprimir();
        System.out.println("\nPelícula 2:");
        pelicula2.imprimir();
        System.out.println();

        // Determinar si son películas épicas
        System.out.println("¿Es película 1 épica?: " + pelicula1.esPeliculaEpica());
        System.out.println("¿Es película 2 épica?: " + pelicula2.esPeliculaEpica());

        // Calcular valoración subjetiva
        System.out.println("\nValoración subjetiva:");
        System.out.println("Película 1: " + pelicula1.calcularValoracion());
        System.out.println("Película 2: " + pelicula2.calcularValoracion());

        // Determinar si las películas son similares
        System.out.println("\n¿Son las películas similares?: " + pelicula1.esSimilar(pelicula2));

        // Crear una tercera película y ver si es similar a pelicual1 o pelicula2
        Pelicula pelicula3 = new Pelicula("The King's Speech", "Tom Hooper", Genero.DRAMA, 118, 2010, 8.2);

        System.out.println("\nPelícula 3:");
        pelicula3.imprimir();
        System.out.println("\n¿Es película 3 épica?: " + pelicula3.esPeliculaEpica());
        System.out.println("Valoración subjetiva de película 3: " + pelicula3.calcularValoracion());
        System.out.println("\n¿Película 3 es similar a película 1?: " + pelicula3.esSimilar(pelicula1));
        System.out.println("¿Película 3 es similar a película 2?: " + pelicula3.esSimilar(pelicula2));

    }
}
