package es.foc.ejercicios.graficos.Nomina;

/**
 * Esta clase denominada Empleado modela un empleado de una empresa que tiene
 * como atributos su nombre, apellidos, género, cargo, salario por día, otros
 * ingresos, pagos por salud, aporte pensiones y días trabajados.
 *
 * @version 1.2/2020
 */
public class Empleado {

    private String nombre;
    /* Atributo que identifica el nombre de un empleado */
    private String apellidos;
    /* Atributo que identifica los apellidos de un empleado */
    private double salarioDia;
    /* Atributo que identifica el salario diario de un empleado */
    private double otrosIngresos;
    /* Atributo que identifica otros ingresos de un empleado */
    private double pagosSalud;
    /* Atributo que identifica los pagos por salud de un empleado */
    // Atributo que identifica el aporte de pensiones de un empleado
    private double aportePensiones;
    /* Atributo que identifica la cantidad de días trabajados por un empleado */
    private int díasTrabajados;
    private TipoCargo cargo;
    /* Atributo que identifica el cargo de un empleado */

    private TipoGenero genero;

    /* Atributo que identifica el gérero de un empleado */
    /**
     * Constructor de la clase Empleado
     *
     * @param nombre Parámetro que define el nombre de un empleado
     * @param apellidos Parámetro que define los apellidos de un empleado
     * @param cargo Parámetro que define el cargo de un empleado
     * @param género Parámetro que define el género de un empleado
     * @param salarioDía Parámetro que define el salario por día de un empleado
     * @param díasTrabajados Parámetro que define la cantidad de días trabajados
     * de un empleado
     * @param pagosSalud Parámetro que define los pagos por salud de un empleado
     * @param aportePensiones Parámetro que define el aporte de pensiones de un
     * empleado
     */
    public Empleado(String nombre, String apellidos, TipoCargo cargo,
            TipoGenero genero, double salarioDia, int díasTrabajados,
            double otrosIngresos, double pagosSalud,
            double aportePensiones) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.genero = genero;
        this.salarioDia = salarioDia;
        this.díasTrabajados = díasTrabajados;
        this.otrosIngresos = otrosIngresos;
        this.pagosSalud = pagosSalud;
        this.aportePensiones = aportePensiones;
    }

    /**
     * Método que obtiene el nombre de un empleado
     *
     * @return El nombre de un empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que obtiene los apellidos de un empleado
     *
     * @return Los apellidos de un empleado
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Método que obtiene el tipo de cargo de un empleado
     *
     * @return El tipo de cargo de un empleado
     */
    public TipoCargo getCargo() {
        return cargo;
    }

    /**
     * Método que obtiene el género de un empleado
     *
     * @return El género de un empleado
     */
    public TipoGenero getGenero() {
        return genero;
    }

    /**
     * Método que obtiene el salario por día de un empleado
     *
     * @return El salario por día de un empleado
     */
    public double getSalarioDia() {
        return salarioDia;
    }

    /**
     * Método que obtiene los días trabajados al mes de un empleado
     *
     * @return Días trabajados al mes de un empleado
     */
    public int getDíasTrabajados() {
        return díasTrabajados;
    }

    /**
     * Método que obtiene otros ingresos de un empleado
     *
     * @return Otros ingresos de un empleado
     */
    public double getOtrosIngresos() {
        return otrosIngresos;
    }

    /**
     * Método que obtiene los pagos por salud de un empleado
     *
     * @return Pagos por salud de un empleado
     */
    public double getPagosSalud() {
        return pagosSalud;
    }

    /**
     * Método que obtiene el aporte de pensiones de un empleado
     *
     * @return Aporte de pensiones de un empleado
     */
    public double getAportePensiones() {
        return aportePensiones;
    }

    /**
     * Método que calcula el salario mensual de un empleado
     *
     * @return Salario mensual de un empleado
     */
    public double calcularNomina() {
        return ((salarioDia * díasTrabajados) + otrosIngresos - pagosSalud - aportePensiones);
    }
}
