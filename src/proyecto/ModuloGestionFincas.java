package proyecto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import proyecto.Potrero;

public class ModuloGestionFincas extends JFrame {
    
    private static final int MAX_FINCAS = 10;
    private Finca[] fincasPreCargadas = new Finca[MAX_FINCAS];
    private int numFincasCargadas = 0;
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton btnAgregarFinca;
    private JButton btnSeleccionarFinca;
    private Finca fincaSeleccionada1 = null;
    private Finca fincaSeleccionada2 = null;
    private JLabel lblFincasSeleccionadas;
    
    public void cargarFincasIniciales() {
    // Inicializar el arreglo y el contador
    fincasPreCargadas = new Finca[MAX_FINCAS];
    numFincasCargadas = 3; // inicialmente no hay fincas cargadas

    // Crear potreros de ejemplo
    Potrero[] potrerosEjemplo = new Potrero[5]; // Hay un array de 5 potreros por finca. (Asegúrate de inicializar este arreglo correctamente más tarde si es necesario)

    // Agregar información preproyectada a fincasPreCargadas
        fincasPreCargadas[0] = new Finca("Finca 1", "Heredia, San Lorenzo", 100.0, "Pedro Perez", "Juan Lopez", "119440886", "8721-1231", 20, 100, 2000, "Descanso", 150, potrerosEjemplo);
        fincasPreCargadas[1] = new Finca("Finca 2", "Alajuela, Grecia", 150.0, "Pedro Perez", "Carlos Rodriguez", "410240192", "8216-2193", 40, 200, 3000, "Descanso", 300, potrerosEjemplo);
        fincasPreCargadas[2] = new Finca("Finca 3", "Alajuela, San Carlos", 200.0, "Pedro Perez", "Roberto Fernandez", "319381728", "8172-1231", 50, 250, 4000, "Libre", 400, potrerosEjemplo);
        
}
        public Finca[] getFincasSeleccionadas() {
        int[] rowIndices = table.getSelectedRows();
        if (rowIndices.length > 0) {
            Finca[] fincasSeleccionadas = new Finca[rowIndices.length];
            for (int i = 0; i < rowIndices.length; i++) {
                if(rowIndices[i] < fincasPreCargadas.length) { // Validación del índice
                    fincasSeleccionadas[i] = fincasPreCargadas[rowIndices[i]];
                } else {
                    JOptionPane.showMessageDialog(null, "Índice de finca inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                   
                }
            }
            return fincasSeleccionadas;
        } else {
            return new Finca[0];
        }
    }


    public ModuloGestionFincas() {
         
        cargarFincasIniciales();
        
         lblFincasSeleccionadas = new JLabel("Seleccione dos fincas para rotar ganado."); 
         add(lblFincasSeleccionadas, BorderLayout.NORTH);
        setTitle("Gestión de Fincas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createTableModel();
        createTable();

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        btnAgregarFinca = new JButton("Agregar Finca");
        btnAgregarFinca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaAgregarFinca();
                
            }
        });

        JPanel panelInferior = new JPanel();
        panelInferior.add(btnAgregarFinca);
        add(panelInferior, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);

    JButton btnRotarGanado = new JButton("Rotar Ganado");
    btnRotarGanado.addActionListener(e -> {
    if (fincaSeleccionada1 != null && fincaSeleccionada2 != null) {
        // Aquí irá la lógica para rotar el ganado
        int ganadoFinca1 = fincaSeleccionada1.getCantidadTotalAnimales();
        int ganadoFinca2 = fincaSeleccionada2.getCantidadTotalAnimales();
        
        fincaSeleccionada1.setCantidadTotalAnimales(ganadoFinca2);
        fincaSeleccionada2.setCantidadTotalAnimales(ganadoFinca1);
        
        updateTableModel();
        
        JOptionPane.showMessageDialog(null, "El ganado ha rotado con éxito entre " + fincaSeleccionada1.getNombre() + " y " + fincaSeleccionada2.getNombre(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        fincaSeleccionada1 = null;
        fincaSeleccionada2 = null;
        lblFincasSeleccionadas.setText("Seleccione dos fincas para rotar ganado.");
    }
    else {
        JOptionPane.showMessageDialog(null, "Debe seleccionar exactamente dos fincas para la rotación", "Error", JOptionPane.ERROR_MESSAGE);
    }
});
panelInferior.add(btnRotarGanado);

add(panelInferior, BorderLayout.SOUTH);    

    }


    public void createTable() {
    table = new JTable(tableModel);
    // Cambia la selección de fila única a múltiple
    table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    // Añadir listener para limitar la selección a dos filas máximo
    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int[] selectedRows = table.getSelectedRows();
            
            if (selectedRows.length == 1) {
                fincaSeleccionada1 = fincasPreCargadas[selectedRows[0]];
                lblFincasSeleccionadas.setText("Finca 1 seleccionada: " + fincaSeleccionada1.getNombre() + ". Seleccione otra para rotar.");
            }
            else if (selectedRows.length == 2) {
                fincaSeleccionada1 = fincasPreCargadas[selectedRows[0]];
                fincaSeleccionada2 = fincasPreCargadas[selectedRows[1]];
                lblFincasSeleccionadas.setText("Finca 1: " + fincaSeleccionada1.getNombre() + " y Finca 2: " + fincaSeleccionada2.getNombre() + " seleccionadas.");
            }
            else if (selectedRows.length > 2) {
                JOptionPane.showMessageDialog(null, "Solo puede seleccionar dos fincas", "Error", JOptionPane.ERROR_MESSAGE);
                table.clearSelection();  // Limpia la selección
            }
        }
    }
});
}

    public void mostrarVentanaAgregarFinca() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre de la finca:");
        if (nombre != null && !nombre.isEmpty()) {
            String ubicacion = JOptionPane.showInputDialog(this, "Ingrese la ubicación de la finca:");
            String nombreEncargado = JOptionPane.showInputDialog(this, "Ingrese el nombre del encargado:");
            String telefonoEncargado = JOptionPane.showInputDialog(this, "Ingrese el teléfono del encargado:");
            String estado = JOptionPane.showInputDialog(this, "Ingrese el estado de la Finca:");
            int cantidadTotalAnimales = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la cantidad total de animales:"));

         
            String cedulaEncargado = "12345678"; 
            int cantidadPotreros = 5; 
            double extension = 50.0; 

            Potrero[] potreros = new Potrero[cantidadPotreros]; 
            Finca nuevaFinca = new Finca(nombre, ubicacion, extension, "PropietarioNoDefinido", nombreEncargado, cedulaEncargado, telefonoEncargado, cantidadPotreros, cantidadTotalAnimales, MAX_FINCAS, estado, cantidadTotalAnimales, potreros);
            agregarNuevaFinca(nuevaFinca);


        }
    }

    public void agregarNuevaFinca(Finca nuevaFinca) {
        if (numFincasCargadas < MAX_FINCAS) {
            fincasPreCargadas[numFincasCargadas] = nuevaFinca;
            numFincasCargadas++;
            updateTableModel();
        } else {
            JOptionPane.showMessageDialog(this, "Límite de fincas alcanzado", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    void updateTableModel() {
        String[] columnNames = {"Nombre", "Ubicación", "Encargado", "Teléfono", "Estado", "Ganado"};
        Object[][] data = new Object[numFincasCargadas][6];

        for (int i = 0; i < numFincasCargadas; i++) {
            Finca finca = fincasPreCargadas[i];
            data[i][0] = finca.getNombre();
            data[i][1] = finca.getUbicacion();
            data[i][2] = finca.getNombreEncargado();
            data[i][3] = finca.getTelefonoEncargado();
            data[i][4] = finca.getEstado();
            data[i][5] = finca.getCantidadTotalAnimales();
        }
        
        tableModel.setDataVector(data, columnNames);
    }
    public Finca getFincaSeleccionada() {
    int rowIndex = table.getSelectedRow();
    if (rowIndex >= 0 && rowIndex < numFincasCargadas) {
        return fincasPreCargadas[rowIndex];
    } else {
        return null;
    }
}


    public void createTableModel() {
    String[] columnNames = {"Nombre", "Ubicación", "Encargado", "Teléfono", "Estado", "Ganado"};
    Object[][] data = new Object[numFincasCargadas][6];

    for (int i = 0; i < numFincasCargadas; i++) {
        Finca finca = fincasPreCargadas[i];
        data[i][0] = finca.getNombre();
        data[i][1] = finca.getUbicacion();
        data[i][2] = finca.getNombreEncargado();
        data[i][3] = finca.getTelefonoEncargado();
        data[i][4] = finca.getEstado();  
        data[i][5] = finca.getCantidadTotalAnimales();
    }

     tableModel = new DefaultTableModel(data, columnNames) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Esto hace que las celdas no sean editables.
            }
        };
    }
    public void actualizarVistaTabla() {
    //la columna "Ganado" está en el índice 5
    int columnaGanado = 5;

    for (int i = 0; i < numFincasCargadas; i++) {
        Finca finca = fincasPreCargadas[i];
        tableModel.setValueAt(finca.getCantidadTotalAnimales(), i, columnaGanado);
    }

    table.repaint(); // Refresca la tabla para reflejar los cambios.
}

    
}






