package es.foc.ejercicios.unidad06.Genericidad;

public class Persona implements Comparable<Persona>{
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int compareTo(Persona p) {
        if(this.edad > p.getEdad()){
            return 1;
        }
        else if(this.edad<p.getEdad()){
            return -1;
        }
        else return 0;
    }        

    @Override
    public String toString() {
        return nombre + "("+edad+")";
    }
 
    
    
}
