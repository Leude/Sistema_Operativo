package windows;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static file.Storage.*;

public class AppFile {
    private JButton modificarButton;
    private JButton agregarButton;
    private JButton removerButton;
    private JComboBox buscarBox;
    private JTextField buscarField;
    protected JButton buscarButton;
    protected JTable tableProductos;
    private JPanel panel;
    private JComboBox algoritmo;

    protected DefaultTableModel model = new DefaultTableModel();

    public AppFile() {
        agregarButton.addActionListener(e -> {
            Format format = new Format(this);
            format.setLocation(panel.getWidth() / 2, panel.getHeight() / 2);
            format.pack();
            format.setVisible(true);
        });
        modificarButton.addActionListener(e -> {
            Format format = new Format(this);
            format.setEditar();
            format.setLocation(panel.getWidth() / 2, panel.getHeight() / 2);
            format.pack();
            format.setVisible(true);
        });
        removerButton.addActionListener(e -> {
            removerArchivo((String) model.getValueAt(tableProductos.getSelectedRow(), 0));
            buscarButton.doClick();
        });
        buscarButton.addActionListener(e -> {
            model = new DefaultTableModel();
            model.setDataVector(
                    buscarArchivo(buscarField.getText(), buscarBox.getSelectedIndex()),
                    columna);
            tableProductos.setModel(model);
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}