package tarea5swing;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagerFrame extends JFrame {

    // Declaración de componentes de la interfaz
    private JTextField codigoField, nombreField, cantidadField, precioField, descripcionField;
    private JTextArea productosArea;
    private JButton insertarButton, buscarButton, mostrarButton, limpiarButton, salirButton;

    // Nombre del archivo donde se guardarán los productos
    private static final String FILENAME = "tudni.txt";

    // Constructor: configura la ventana y llama al método para crear la interfaz
    public ProductManagerFrame() {
        setTitle("Gestión de Productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setSize(500, 500); // Tama?o de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        iniciarComponentes(); // Llama al método para inicializar y agregar los componentes a la ventana
    }

    // Método para crear y organizar los componentes de la interfaz
    private void iniciarComponentes() {
        // Panel para los campos de entrada
        JPanel panelFields = new JPanel(new GridLayout(5, 2, 5, 5));
        panelFields.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Se a?aden etiquetas y campos de texto
        panelFields.add(new JLabel("Código Producto:"));
        codigoField = new JTextField();
        panelFields.add(codigoField);

        panelFields.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panelFields.add(nombreField);

        panelFields.add(new JLabel("Cantidad:"));
        cantidadField = new JTextField();
        panelFields.add(cantidadField);

        panelFields.add(new JLabel("Precio:"));
        precioField = new JTextField();
        panelFields.add(precioField);

        panelFields.add(new JLabel("Descripción:"));
        descripcionField = new JTextField();
        panelFields.add(descripcionField);

        // Panel para los botones (usa FlowLayout para organizarlos en línea)
        JPanel panelButtons = new JPanel(new FlowLayout());
        insertarButton = new JButton("Insertar");
        buscarButton = new JButton("Buscar");
        mostrarButton = new JButton("Mostrar");
        limpiarButton = new JButton("Limpiar");
        salirButton = new JButton("Salir");
        panelButtons.add(insertarButton);
        panelButtons.add(buscarButton);
        panelButtons.add(mostrarButton);
        panelButtons.add(limpiarButton);
        panelButtons.add(salirButton);

        // Área de texto para listar productos, que se coloca dentro de un JScrollPane para poder desplazarse
        productosArea = new JTextArea(10, 40);
        productosArea.setEditable(false); // Se hace de solo lectura
        JScrollPane scrollPane = new JScrollPane(productosArea);

        // Panel para el listado: contiene un JLabel con el texto "Listado de productos:" y el área de texto debajo
        JPanel panelListado = new JPanel(new BorderLayout());
        JLabel labelListado = new JLabel("Listado de productos:");
        labelListado.setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto del label
        panelListado.add(labelListado, BorderLayout.NORTH);
        panelListado.add(scrollPane, BorderLayout.CENTER);

        // Organiza los paneles en la ventana principal (JFrame) usando BorderLayout
        setLayout(new BorderLayout());
        add(panelFields, BorderLayout.NORTH);      // Panel superior con campos de entrada
        add(panelButtons, BorderLayout.CENTER);      // Panel central con botones
        add(panelListado, BorderLayout.SOUTH);       // Panel inferior con el listado de productos

        // Asignar los ActionListeners a cada botón usando expresiones lambda
        insertarButton.addActionListener(e -> insertarProducto());
        buscarButton.addActionListener(e -> buscarProducto());
        mostrarButton.addActionListener(e -> mostrarProductos());
        limpiarButton.addActionListener(e -> limpiarCampos());
        salirButton.addActionListener(e -> System.exit(0)); // Cierra la aplicación
    }

    // Método para insertar un producto
    private void insertarProducto() {
        // Verifica que ningún campo esté vacío (se usa trim para eliminar espacios en blanco)
        if (codigoField.getText().trim().isEmpty() || nombreField.getText().trim().isEmpty()
                || cantidadField.getText().trim().isEmpty() || precioField.getText().trim().isEmpty()
                || descripcionField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        try {
            // Convierte los valores numéricos de cantidad y precio
            int cantidad = Integer.parseInt(cantidadField.getText().trim());
            double precio = Double.parseDouble(precioField.getText().trim());

            // Crea un objeto Producto con los datos ingresados
            Producto producto = new Producto(
                    codigoField.getText().trim(),
                    nombreField.getText().trim(),
                    cantidad,
                    precio,
                    descripcionField.getText().trim()
            );

            // Guarda el producto en el archivo (al final del archivo se agrega)
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
                writer.write(String.format("%s,%s,%d,%.2f,%s%n",
                        producto.getCodigo(), producto.getNombre(),
                        producto.getCantidad(), producto.getPrecio(),
                        producto.getDescripcion()));
            }

            // Actualiza el área de texto (a?ade una nueva línea con el producto insertado si hay productos)
            String contenidoActual = productosArea.getText();
            String nuevoProducto = producto.toString();
            productosArea.setText(contenidoActual.isEmpty() ? nuevoProducto : contenidoActual + "\n" + nuevoProducto);

            // Actualiza los campos de entrada con los datos del producto insertado
            actualizarCampos(producto);

        } catch (NumberFormatException ex) {
            // Se produce si no se puede convertir la cantidad o el precio a número
            JOptionPane.showMessageDialog(this, "Error: La cantidad y el precio deben ser numéricos.");
        } catch (IOException ex) {
            // Error al escribir en el archivo
            JOptionPane.showMessageDialog(this, "Error al guardar el producto.");
        }
    }

    // Método para buscar un producto por código
    private void buscarProducto() {
        String codigo = codigoField.getText().trim();
        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduce un código para buscar.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String linea;
            boolean encontrado = false;
            // Lee el archivo línea por línea
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                // Se asume que el primer elemento es el código
                if (datos[0].equals(codigo)) {
                    // Actualiza los campos con los datos del producto encontrado
                    nombreField.setText(datos[1]);
                    cantidadField.setText(datos[2]);
                    precioField.setText(datos[3]);
                    descripcionField.setText(datos[4]);
                    productosArea.setText("Producto encontrado:\n" + linea);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                productosArea.setText("Producto no encontrado.");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo.");
        }
    }

    // Método para mostrar todos los productos y actualizar los campos con el primer producto
    private void mostrarProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                try {
                    // Convierte la cantidad y el precio y crea un objeto Producto
                    int cantidad = Integer.parseInt(datos[2]);
                    double precio = Double.parseDouble(datos[3]);
                    Producto p = new Producto(datos[0], datos[1], cantidad, precio, datos[4]);
                    listaProductos.add(p);
                    contenido.append(p.toString()).append("\n");
                } catch (NumberFormatException ex) {
                    // Si hay error en el formato, se ignora esa línea
                }
            }
            productosArea.setText(contenido.toString());
            // Si se encontró al menos un producto, actualiza los campos con el primer producto
            if (!listaProductos.isEmpty()) {
                actualizarCampos(listaProductos.get(0));
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo.");
        }
    }

    // Método para actualizar los campos de entrada con los datos de un producto
    private void actualizarCampos(Producto producto) {
        codigoField.setText(producto.getCodigo());
        nombreField.setText(producto.getNombre());
        cantidadField.setText(String.valueOf(producto.getCantidad()));
        precioField.setText(String.format("%.2f", producto.getPrecio()));
        descripcionField.setText(producto.getDescripcion());
    }

    // Método para limpiar todos los campos de entrada
    private void limpiarCampos() {
        codigoField.setText("");
        nombreField.setText("");
        cantidadField.setText("");
        precioField.setText("");
        descripcionField.setText("");
    }

}
