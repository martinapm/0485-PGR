package es.foc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main extends JFrame {
    private JTextField txtCodigo, txtNombre, txtCantidad, txtDescripcion;
    private JButton btnInsertar, btnBuscar, btnModificar, btnBorrar, btnMostrar, btnSalir;
    private JTextArea textArea;
    private ProductoController controller;

    public Main() {
        controller = new ProductoController();
        initComponents();
    }

    private void initComponents() {
        setTitle("Gestión de Productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Panel para datos del producto
        JPanel panelNorth = new JPanel(new GridLayout(5, 2, 5, 5));
        panelNorth.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));

        panelNorth.add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        panelNorth.add(txtCodigo);

        panelNorth.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelNorth.add(txtNombre);

        panelNorth.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        panelNorth.add(txtCantidad);

        panelNorth.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField();
        panelNorth.add(txtDescripcion);

        // Panel de botones
        JPanel panelButtons = new JPanel(new GridLayout(1, 6, 5, 5));
        btnInsertar = new JButton("Insertar");
        btnBuscar = new JButton("Buscar");
        btnModificar = new JButton("Modificar");
        btnBorrar = new JButton("Borrar");
        btnMostrar = new JButton("Mostrar");
        btnSalir = new JButton("Salir");

        panelButtons.add(btnInsertar);
        panelButtons.add(btnBuscar);
        panelButtons.add(btnModificar);
        panelButtons.add(btnBorrar);
        panelButtons.add(btnMostrar);
        panelButtons.add(btnSalir);

        // Área de texto para mostrar el listado de productos
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Listado de Productos"));

        // Distribución en el Frame
        setLayout(new BorderLayout());
        add(panelNorth, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Acciones de los botones
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarProducto();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarProducto();
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarProducto();
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarProductos();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.cerrar();
                System.exit(0);
            }
        });
    }

    // Método para insertar un producto
    private void insertarProducto() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            String nombre = txtNombre.getText().trim();
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());
            String descripcion = txtDescripcion.getText().trim();

            Producto producto = new Producto(codigo, nombre, cantidad, descripcion);
            controller.insertarProducto(producto);
            JOptionPane.showMessageDialog(this, "Producto insertado correctamente.");
            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al insertar el producto: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para buscar un producto por código
    private void buscarProducto() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            Producto producto = controller.buscarProducto(codigo);
            if (producto != null) {
                txtNombre.setText(producto.getNombre());
                txtCantidad.setText(String.valueOf(producto.getCantidad()));
                txtDescripcion.setText(producto.getDescripcion());
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Buscar", JOptionPane.WARNING_MESSAGE);
                limpiarCampos();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un código válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para modificar un producto
    private void modificarProducto() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            String nombre = txtNombre.getText().trim();
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());
            String descripcion = txtDescripcion.getText().trim();

            Producto productoExistente = controller.buscarProducto(codigo);
            if (productoExistente != null) {
                Producto producto = new Producto(codigo, nombre, cantidad, descripcion);
                controller.modificarProducto(producto);
                JOptionPane.showMessageDialog(this, "Producto modificado correctamente.");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Modificar", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese datos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para borrar un producto
    private void borrarProducto() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de borrar el producto?");
            if (confirm == JOptionPane.YES_OPTION) {
                controller.borrarProducto(codigo);
                JOptionPane.showMessageDialog(this, "Producto borrado correctamente.");
                limpiarCampos();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un código válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para mostrar todos los productos
    private void mostrarProductos() {
        List<Producto> productos = controller.listarProductos();
        StringBuilder sb = new StringBuilder();
        for (Producto p : productos) {
            sb.append(p.toString()).append("\n");
        }
        textArea.setText(sb.toString());
    }

    // Limpia los campos del formulario
    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtCantidad.setText("");
        txtDescripcion.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
