package es.foc.ejercicios.graficos.Nomina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase denominada VentanaAgregarEmpleado define una ventana para ingresar
 * los datos de un empleado y agregarlo a la lista de empleados.
 *
 */
public class VentanaAgregarEmpleado extends JFrame implements ActionListener {

    private Container contenedor;
    /* Un contenedor de elementos gr谩ficos */
    private ListaEmpleados lista; // La lista de empleados 
    // Etiquetas est谩ticas para indicar los datos a ingresar
    private JLabel nombre, apellidos, cargo, salarioDia, numeroDias,
            genero, otrosIngresos, aportesSalud, pensiones;
    // Campos de texto a ingresar de un empleado
    private JTextField campoNombre, campoApellidos,
            campoSalarioDi璦, campoOtrosIngresos, campoAportesSalud,
            campoPensiones;

    private ButtonGroup grupoGenero; // Grupo de botones de radio
    private JRadioButton masculino, femenino; // Botones de radios
    private JComboBox campoCargo; // Un combox
    private JSpinner campoNumeroDias; // Un selector de datos num茅rico
    private SpinnerNumberModel modeloSpinner;
    /* Modelo num茅rico para el selector num茅rico */
    /* Botones para agregar un empleado y para borrar la lista de empleados */
    private JButton agregar, limpiar;

    /**
     * Constructor de la clase VentanaAgregarEmpleado
     *
     * @param lista Par谩metro que define la lista de empleados
     */
    public VentanaAgregarEmpleado(ListaEmpleados lista) {
        this.lista = lista;
        inicio();
        setTitle("Agregar Empleado"); // Establece el t铆tulo de la ventana
        setSize(300, 400); // Establece el tama帽o de la ventana
        setLocationRelativeTo(null);
        /* La ventana se posiciona en el centro de la pantalla */
        setResizable(false);
        /* Establece que la ventana no puede cambiar de tama帽o */
    }

    /**
     * M茅todo que crea la ventana con sus diferentes componentes gr谩ficos
     */
    public void inicio() {
        contenedor = getContentPane();
        /* Obtiene el panel de contenidos de la ventana */
        contenedor.setLayout(null);
        /* Establece que el contenedor no tiene un layout */
        // Establece la etiqueta y el campo de texto nombre del empleado
        nombre = new JLabel();
        nombre.setText("Nombre:");
        // Establece la posici贸n de la etiqueta nombre del empleado
        nombre.setBounds(20, 20, 135, 23);
        campoNombre = new JTextField();
        // Establece la posici贸n del campo de texto nombre del empleado
        campoNombre.setBounds(160, 20, 100, 23);
        // Establece la etiqueta y el campo de texto apellidos del empleado
        apellidos = new JLabel();
        apellidos.setText("Apellidos:");
        // Establece la posici贸n de la etiqueta apellidos del empleado
        apellidos.setBounds(20, 50, 135, 23);
        campoApellidos = new JTextField();
        // Establece la posici贸n del campo de texto apellidos del empleado
        campoApellidos.setBounds(160, 50, 100, 23);
        // Establece la etiqueta y el combo box del cargo del empleado
        cargo = new JLabel();
        cargo.setText("Cargo:");
        cargo.setBounds(20, 80, 135, 23);
        /* Establece la posici贸n de la etiqueta cargo del empleado */
        campoCargo = new JComboBox();
        // Agrega los tres tipos de cargo de un empleado al combobox
        campoCargo.addItem("Directivo");
        campoCargo.addItem("Estrat間ico");
        campoCargo.addItem("Operativo");
        // Establece la posici贸n del combobox cargo del empleado
        campoCargo.setBounds(160, 80, 100, 23);
        /* Establece las etiquetas y el grupo de botones de radio para el g茅nero del empleado */
        genero = new JLabel();
        genero.setText("G閚ero:");
        // Establece la posici贸n de la etiqueta de g茅nero del empleado
        genero.setBounds(20, 110, 100, 30);
        grupoGenero = new ButtonGroup(); // Crea un grupo de botones
        masculino = new JRadioButton("Masculino", true);
        masculino.setBounds(160, 110, 100, 30);
        /* Establece la posici贸n del bot贸n de radio masculino */
        grupoGenero.add(masculino); // A帽ade el bot贸n al grupo
        femenino = new JRadioButton("Femenino");
        femenino.setBounds(160, 140, 100, 30);
        /* Establece la posici贸n del bot贸n de radio femenino */
        grupoGenero.add(femenino); // A帽ade el bot贸n al grupo
        /* Establece la etiqueta y el campo de texto salario por d铆a del empleado */
        salarioDia = new JLabel();
        salarioDia.setText("Salario por d憝a:");
        // Establece la posici贸n de la etiqueta salario por d铆a del empleado
        salarioDia.setBounds(20, 170, 135, 23);
        campoSalarioDi璦 = new JTextField();
        /* Establece la posici贸n del campo de texto salario por d铆a del empleado */
        campoSalarioDi璦.setBounds(160, 170, 100, 23);
        /* Establece la etiqueta y el campo de texto d铆as trabajados al mes del empleado */
        numeroDias = new JLabel();
        numeroDias.setText("D韆s trabajados al mes:");
        /* Establece la posici贸n de la etiqueta d铆as trabajados al mes del empleado */
        numeroDias.setBounds(20, 200, 135, 23);
        campoNumeroDias = new JSpinner(); // Crea un spinner
        modeloSpinner = new SpinnerNumberModel();
        /* Crea un modelo num茅rico para el spinner */
        // Define valor m铆nimo, m谩ximo y valor inicial para el spinner
        modeloSpinner.setMinimum(1);
        modeloSpinner.setMaximum(31);
        modeloSpinner.setValue(30);
        campoNumeroDias.setModel(modeloSpinner);
        /* Asocia el modelo num茅rico al spinner */
        campoNumeroDias.setBounds(160, 200, 40, 23);
        /* Establece la posici贸n del spinner */
        /* Establece la etiqueta y el campo de texto otros ingresos del empleado */
        otrosIngresos = new JLabel();
        otrosIngresos.setText("Otros ingresos:");
        // Establece la posici贸n de la etiqueta otro ingresos del empleado
        otrosIngresos.setBounds(20, 230, 135, 23);
        campoOtrosIngresos = new JTextField();
        /* Establece la posici贸n del campo de texto otros ingresos del empleado */
        campoOtrosIngresos.setBounds(160, 230, 100, 23);
        /* Establece la etiqueta y el campo de texto pagos por salud del empleado */
        aportesSalud = new JLabel();
        aportesSalud.setText("Pagos por salud:");
        // Establece la posici贸n de la etiqueta pagos por salud del empleado
        aportesSalud.setBounds(20, 260, 135, 23);
        campoAportesSalud = new JTextField();
        /* Establece la posici贸n del campo de texto pagos por salud del empleado */
        campoAportesSalud.setBounds(160, 260, 100, 23);
        /* Establece la etiqueta y el campo de texto aportes pensiones del empleado */
        pensiones = new JLabel();
        pensiones.setText("Aportes pensiones:");
        // Establece la posici贸n de la etiqueta aporte pensiones del empleado
        pensiones.setBounds(20, 290, 135, 23);
        campoPensiones = new JTextField();
        /* Establece la posici贸n del campo de texto aporte pensiones del empleado */
        campoPensiones.setBounds(160, 290, 100, 23);
        // Establece el bot贸n agregar empleado
        agregar = new JButton();
        agregar.setText("Agregar");
        agregar.setBounds(20, 320, 100, 23);
        /* Establece la posici贸n del bot贸n agregar */
        /* Agrega al bot贸n un ActionListener para que gestione eventos del bot贸n */
        agregar.addActionListener(this);
        // Establece el bot贸n borrar empleados
        limpiar = new JButton();
        limpiar.setText("Borrar");
        limpiar.setBounds(160, 320, 80, 23);
        /* Establece la posici贸n del bot贸n borrar empleados */
        /* Agrega al bot贸n un ActionListener para que gestione eventos del bot贸n */
        limpiar.addActionListener(this);
        // Se a帽ade cada componente gr谩fico al contenedor de la ventana
        contenedor.add(nombre);
        contenedor.add(campoNombre);
        contenedor.add(apellidos);
        contenedor.add(campoApellidos);
        contenedor.add(cargo);
        contenedor.add(campoCargo);
        contenedor.add(genero);
        contenedor.add(masculino);
        contenedor.add(femenino);
        contenedor.add(salarioDia);
        contenedor.add(campoSalarioDi璦);
        contenedor.add(numeroDias);
        contenedor.add(campoNumeroDias);
        contenedor.add(otrosIngresos);
        contenedor.add(campoOtrosIngresos);
        contenedor.add(aportesSalud);
        contenedor.add(campoAportesSalud);
        contenedor.add(pensiones);
        contenedor.add(campoPensiones);
        contenedor.add(agregar);
        contenedor.add(limpiar);
    }

    /**
     * M茅todo que borra los campos de texto ingresados en la ventana de agregar
     * empleado
     */
    public void limpiarCampos() {
        campoNombre.setText("");
        campoApellidos.setText("");
        campoSalarioDi璦.setText("");
        campoNumeroDias.setValue(0);
        campoOtrosIngresos.setText("");
        campoAportesSalud.setText("");
        campoPensiones.setText("");
    }

    /**
     * M茅todo que gestiona los eventos generados en la ventana principal
     */
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == agregar) {
            /* Se pulsa el bot贸n agregar empleado */
            anadirEmpleado();
        }
        if (evento.getSource() == limpiar) { // Se pulsa el bot贸n limpiar
            limpiarCampos();
        }
    }

    /**
     * M茅todo que agrega un empleado a la lista de empleados throws Exception
     * Excepci贸n de campo nulo o error en formato de numero
     */
    private void anadirEmpleado() {
        TipoCargo tipoC;
        // Obtiene el cargo seleccionado del combobox
        String itemSeleccionado = (String) campoCargo.
                getSelectedItem();
        /* De acuerdo al cargo seleccionado, se asigna el valor de atributo correspondiente */
        if (itemSeleccionado == "Directivo") {
            tipoC = TipoCargo.DIRECTIVO;
        } else if (itemSeleccionado == "Estrat間ico") {
            tipoC = TipoCargo.ESTRAT蒅ICO;
        } else {
            tipoC = TipoCargo.OPERATIVO;
        }
        TipoGenero tipoG;
        /* De acuerdo al g茅nero seleccionado, se asigna el valor de atributo correspondiente */
        if (masculino.isSelected()) {
            tipoG = TipoGenero.MASCULINO;
        } else {
            tipoG = TipoGenero.FEMENINO;
        }
        try {
            String valor1 = campoNombre.getText();
            /* Se obtiene el valor del campo de texto nombre */
            String valor2 = campoApellidos.getText();
            /* Se obtiene el valor del campo de texto apellidos */
            // Se obtiene y convierte el campo de texto salario
            double valor3 = Double.parseDouble(campoSalarioDi璦.getText());
            // Se obtiene el valor ingresado de d铆as trabajados
            int valor4 = (int) campoNumeroDias.getValue();
            // Se obtiene y convierte el campo de texto otros ingresos
            double valor5 = Double.parseDouble(campoOtrosIngresos.getText());
            // Se obtiene y convierte el campo de texto aportes salud
            double valor6 = Double.parseDouble(campoAportesSalud.getText());
            // Se obtiene y convierte el campo de texto pensiones
            double valor7 = Double.parseDouble(campoPensiones.getText());
            Empleado e = new Empleado(valor1, valor2, tipoC, tipoG,
                    valor3, valor4, valor5, valor6, valor7); // Se crea un empleado
            lista.agregarEmpleado(e);
            /* Se agrega un empleado a la lista de empleados */
            // Mensaje de confirmaci贸n de empleado agregado a la lista
            JOptionPane.showMessageDialog(this, "El empleado ha sido agregado", "Mensaje", JOptionPane.INFORMATION_MESSAGE, null);
            limpiarCampos();
        } catch (Exception e) {
            /* Si se produce alg煤n tipo de error, se muestra un mensaje */
            JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de numero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}