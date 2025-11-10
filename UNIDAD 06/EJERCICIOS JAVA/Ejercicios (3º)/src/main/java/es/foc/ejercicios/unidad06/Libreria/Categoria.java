package es.foc.ejercicios.unidad06.Libreria;

public class Categoria implements Comparable<Categoria>{

    String nombre;
    String descripcion;
    int pasillo;
    int estanteria;
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPasillo() {
        return pasillo;
    }

    public void setPasillo(int pasillo) {
        this.pasillo = pasillo;
    }

    public int getEstanteria() {
        return estanteria;
    }

    public void setEstanteria(int estanteria) {
        this.estanteria = estanteria;
    }

    public Categoria(String nombre, String descripcion, int pasillo, int estanteria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.pasillo = pasillo;
        this.estanteria = estanteria;
    }

    @Override
    public int compareTo(Categoria cat) {
        return this.nombre.compareTo(cat.nombre);
    }

    @Override
    public String toString() {
        return "Categoria{" + "nombre=" + nombre + ", descripcion=" + descripcion +", pasillo=" + pasillo +", estanteria=" + estanteria +"}";
    }

    
}
