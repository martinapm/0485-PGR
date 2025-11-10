package es.foc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;


public class InterfazApp extends JFrame {

    // Componentes de la interfaz
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtLocalizacion;
    private JTextField txtManager;
    private JTextField txtBusqueda;
    private JTable tablaDepartamentos;
    private JTextArea areaDepartamentos;
    private JButton btnInsertar;
    private JButton btnModificar;
    private JButton btnBorrar;
    private JButton btnMostrar;
    private JButton btnBuscar;
    private JButton btnLimpiar;

    // Modelo para la tabla
    private DefaultTableModel modeloTabla;

    // DAO para operaciones con departamentos
    private DepartamentoDAO departamentoDAO;


    public InterfazApp() {
        // Inicializar el DAO
        departamentoDAO = new DepartamentoDAO();
        departamentoDAO.crearTablaSiNoExiste();

        // Configura la ventana
        configurarVentana();

        // Inicializa componentes
        inicializarComponentes();

        // Configura eventos
        configurarEventos();

        // Carga datos iniciales
        cargarDatos();
    }


    private void configurarVentana() {
        setTitle("Gestión de Departamentos - Martina Pérez Muñoz (78003602E)");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Evento al cerrar la ventana para cerrar la conexión a la BD
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ConexionBD.cerrarConexion();
            }
        });
    }


    private void inicializarComponentes() {
        // Panel de datos
        JPanel panelDatos = new JPanel(new GridLayout(5, 2, 10, 10));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos del Departamento"));

        panelDatos.add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        panelDatos.add(txtCodigo);

        panelDatos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("ID Localización:"));
        txtLocalizacion = new JTextField();
        panelDatos.add(txtLocalizacion);

        panelDatos.add(new JLabel("ID Manager:"));
        txtManager = new JTextField();
        panelDatos.add(txtManager);

        panelDatos.add(new JLabel("Búsqueda (código o nombre):"));
        txtBusqueda = new JTextField();
        panelDatos.add(txtBusqueda);

        // Panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 6, 5, 5));

        btnInsertar = new JButton("Insertar");
        btnModificar = new JButton("Modificar");
        btnBorrar = new JButton("Borrar");
        btnMostrar = new JButton("Mostrar Todos");
        btnBuscar = new JButton("Buscar");
        btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnInsertar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnBorrar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnLimpiar);

        // Panel de resultados con tabla
        JPanel panelResultados = new JPanel(new BorderLayout());
        panelResultados.setBorder(BorderFactory.createTitledBorder("Departamentos"));

        // Crear modelo de tabla
        modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // No permitir edición directa en la tabla
            }
        };

        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("ID Localización");
        modeloTabla.addColumn("ID Manager");

        tablaDepartamentos = new JTable(modeloTabla);
        tablaDepartamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollTabla = new JScrollPane(tablaDepartamentos);

        panelResultados.add(scrollTabla, BorderLayout.CENTER);

        // Panel para área de texto
        areaDepartamentos = new JTextArea();
        areaDepartamentos.setEditable(false);
        JScrollPane scrollArea = new JScrollPane(areaDepartamentos);
        scrollArea.setBorder(BorderFactory.createTitledBorder("Información Detallada"));

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelPrincipal.add(panelDatos, BorderLayout.NORTH);
        panelPrincipal.add(panelResultados, BorderLayout.CENTER);
        panelPrincipal.add(scrollArea, BorderLayout.SOUTH);

        // Agregar paneles a la ventana
        add(panelPrincipal, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }


    private void configurarEventos() {
        // Botón Insertar
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarDepartamento();
            }
        });

        // Botón Modificar
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarDepartamento();
            }
        });

        // Botón Borrar
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarDepartamento();
            }
        });

        // Botón Mostrar Todos
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarDatos();
            }
        });

        // Botón Buscar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarDepartamento();
            }
        });

        // Botón Limpiar
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        // Evento para cargar datos al seleccionar una fila de la tabla
        tablaDepartamentos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tablaDepartamentos.getSelectedRow() != -1) {
                int fila = tablaDepartamentos.getSelectedRow();
                txtCodigo.setText(tablaDepartamentos.getValueAt(fila, 0).toString());
                txtNombre.setText(tablaDepartamentos.getValueAt(fila, 1).toString());
                txtLocalizacion.setText(tablaDepartamentos.getValueAt(fila, 2).toString());
                txtManager.setText(tablaDepartamentos.getValueAt(fila, 3).toString());
            }
        });
    }


    private void cargarDatos() {
        List<Departamento> departamentos = departamentoDAO.obtenerTodos();

        // Limpiar tabla
        modeloTabla.setRowCount(0);

        // Limpiar área de texto
        areaDepartamentos.setText("");

        // Añadir departamentos a la tabla
        for (Departamento dep : departamentos) {
            modeloTabla.addRow(new Object[]{
                    dep.getCodigo(),
                    dep.getNombre(),
                    dep.getIdLocalizacion(),
                    dep.getIdManager()
            });

            // Añadir información al área de texto
            areaDepartamentos.append(dep.toString() + "\n");
        }
    }


    private void insertarDepartamento() {
        try {
            // Validar campos
            if (txtCodigo.getText().isEmpty() || txtNombre.getText().isEmpty() ||
                    txtLocalizacion.getText().isEmpty() || txtManager.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear objeto departamento con los datos del formulario
            Departamento departamento = new Departamento(
                    Integer.parseInt(txtCodigo.getText()),
                    txtNombre.getText(),
                    Integer.parseInt(txtLocalizacion.getText()),
                    Integer.parseInt(txtManager.getText())
            );

            // Insertar en la BD
            boolean resultado = departamentoDAO.insertar(departamento);

            if (resultado) {
                JOptionPane.showMessageDialog(this, "Departamento insertado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Recargar datos
                cargarDatos();
                // Limpiar formulario
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo insertar el departamento", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Los campos código, localización y manager deben ser números", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void modificarDepartamento() {
        try {
            // Validar que haya un código
            if (txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe introducir un código de departamento", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int codigo = Integer.parseInt(txtCodigo.getText());

            // Verificar que el departamento existe
            Departamento existente = departamentoDAO.buscarPorCodigo(codigo);

            if (existente == null) {
                JOptionPane.showMessageDialog(this, "No existe un departamento con ese código", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar resto de campos
            if (txtNombre.getText().isEmpty() || txtLocalizacion.getText().isEmpty() || txtManager.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear objeto departamento con los nuevos datos
            Departamento departamento = new Departamento(
                    codigo,
                    txtNombre.getText(),
                    Integer.parseInt(txtLocalizacion.getText()),
                    Integer.parseInt(txtManager.getText())
            );

            // Actualizar en la BD
            boolean resultado = departamentoDAO.actualizar(departamento);

            if (resultado) {
                JOptionPane.showMessageDialog(this, "Departamento modificado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Recargar datos
                cargarDatos();
                // Limpiar formulario
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo modificar el departamento", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Los campos código, localización y manager deben ser números", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void borrarDepartamento() {
        try {
            // Validar que haya un código
            if (txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe introducir un código de departamento", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int codigo = Integer.parseInt(txtCodigo.getText());

            // Verificar que el departamento existe
            Departamento existente = departamentoDAO.buscarPorCodigo(codigo);

            if (existente == null) {
                JOptionPane.showMessageDialog(this, "No existe un departamento con ese código", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Mostrar confirmación
            int confirmacion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro de que desea eliminar el departamento " + existente.getNombre() + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                boolean resultado = departamentoDAO.eliminar(codigo);

                if (resultado) {
                    JOptionPane.showMessageDialog(this, "Departamento eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    // Recargar datos
                    cargarDatos();
                    // Limpiar formulario
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el departamento", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El código debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void buscarDepartamento() {
        String textoBusqueda = txtBusqueda.getText().trim();

        if (textoBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe introducir un término de búsqueda", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Intentar buscar por código si es un número
            int codigo = Integer.parseInt(textoBusqueda);
            Departamento departamento = departamentoDAO.buscarPorCodigo(codigo);

            if (departamento != null) {
                // Encontrado un departamento por código
                mostrarResultadoBusqueda(departamento);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún departamento con ese código", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            // No es un número, buscar por nombre
            List<Departamento> departamentos = departamentoDAO.buscarPorNombre(textoBusqueda);

            if (departamentos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron departamentos con ese nombre", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else if (departamentos.size() == 1) {
                // Un solo resultado
                mostrarResultadoBusqueda(departamentos.get(0));
            } else {
                // Múltiples resultados
                JOptionPane.showMessageDialog(this,
                        "Se encontraron " + departamentos.size() + " departamentos. Por favor, sea más específico en su búsqueda.",
                        "Múltiples resultados",
                        JOptionPane.INFORMATION_MESSAGE);

                // Mostrar resultados en la tabla
                modeloTabla.setRowCount(0);
                areaDepartamentos.setText("");

                for (Departamento dep : departamentos) {
                    modeloTabla.addRow(new Object[]{
                            dep.getCodigo(),
                            dep.getNombre(),
                            dep.getIdLocalizacion(),
                            dep.getIdManager()
                    });

                    areaDepartamentos.append(dep.toString() + "\n");
                }
            }
        }
    }


    private void mostrarResultadoBusqueda(Departamento departamento) {
        // Crear ventana modal
        JDialog dialog = new JDialog(this, "Departamento Encontrado", true);
        dialog.setLayout(new BorderLayout(10, 10));
        dialog.setSize(400, 200);
        dialog.setLocationRelativeTo(this);

        // Panel de información
        JPanel panelInfo = new JPanel(new GridLayout(4, 2, 5, 5));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInfo.add(new JLabel("Código:"));
        panelInfo.add(new JLabel(String.valueOf(departamento.getCodigo())));

        panelInfo.add(new JLabel("Nombre:"));
        panelInfo.add(new JLabel(departamento.getNombre()));

        panelInfo.add(new JLabel("ID Localización:"));
        panelInfo.add(new JLabel(String.valueOf(departamento.getIdLocalizacion())));

        panelInfo.add(new JLabel("ID Manager:"));
        panelInfo.add(new JLabel(String.valueOf(departamento.getIdManager())));

        // Botón de cerrar
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dialog.dispose());

        // Añadir componentes al diálogo
        dialog.add(panelInfo, BorderLayout.CENTER);
        dialog.add(btnCerrar, BorderLayout.SOUTH);

        // Mostrar diálogo
        dialog.setVisible(true);
    }


    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtLocalizacion.setText("");
        txtManager.setText("");
        txtBusqueda.setText("");
        txtCodigo.requestFocus();
    }
}