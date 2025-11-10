package es.foc.ejercicios.unidad06.Genericidad;

class Tripleta<I, P, S> {

    private final I i;
    /* Atributo que identifica el primer elemento de la tripleta */
    private final P p;
    /* Atributo que identifica el segundo elemento de la tripleta */
    private final S s;

    /* Atributo que identifica el tercer elemento de la tripleta */

    public Tripleta(I valor1, P valor2, S valor3) {
        i = valor1;
        p = valor2;
        s = valor3;
    }

    public String toString() {
        return String.format(i + " - " + p + " - " + s);
    }

    public static void main(String[] args) {
        // Crea una tripleta conformada por un Integer y dos String
        Tripleta<Integer, String, String> tripleta1 = new Tripleta<Integer, String, String>(1, "Cálculo", "Cómputo, cuenta o investigación que se hace de algo por medio de operaciones matemáticas.");
        System.out.println(tripleta1);

        // Crea una tripleta conformada por tres String
        Tripleta<String, String, String> tripleta2 = new Tripleta<String, String, String>(
        "Real Madrid","Barcelona","3-3");
        System.out.println(tripleta2);
        
        // Crea una tripleta conformada por dos String y un Integer
        Tripleta<String, String, Integer> tripleta3 = new Tripleta<String, String, Integer>("Temperatura","Grados centígrados",18);
        System.out.println(tripleta3);
    }
}
