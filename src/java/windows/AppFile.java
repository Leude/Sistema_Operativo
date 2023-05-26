package windows;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static file.Storage.*;

public class AppFile {
    private JPanel panelCRUD;
    private JTextField idField;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField edadField;
    private JTextField calleField;
    private JTextField numeroField;
    private JTextField cpField;
    private JTextField emailField;
    private JButton agregarButton;
    private JButton removerButton;
    private JButton modificarButton;
    private JComboBox buscarBox;
    private JTextField buscarField;
    private JButton buscarButton;
    private JTable tableProductos;

    DefaultTableModel model = new DefaultTableModel();

    public AppFile() {
        tableProductos.setModel(model);
        agregarButton.addActionListener(e -> {
            agregarArchivo(nombreField.getText(), apellidoField.getText(), Integer.valueOf(edadField.getText()), calleField.getText(), Integer.valueOf(numeroField.getText()), Integer.valueOf(cpField.getText()), emailField.getText());
            buscarButton.doClick();
        });
        removerButton.addActionListener(e -> {
            removerArchivo(idField.getText());
            buscarButton.doClick();
        });
        modificarButton.addActionListener(e -> {
            modificarArchivo(idField.getText(), nombreField.getText(), apellidoField.getText(), Integer.valueOf(edadField.getText()), calleField.getText(), Integer.valueOf(numeroField.getText()), Integer.valueOf(cpField.getText()), emailField.getText());
            buscarButton.doClick();
        });
        buscarButton.addActionListener(e -> {
            model = new DefaultTableModel();
            model.setDataVector(
                    buscarArchivo(buscarField.getText(), buscarBox.getSelectedIndex()),
                    columna);
            tableProductos.setModel(model);
        });
        tableProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                idField.setText((String) model.getValueAt(tableProductos.getSelectedRow(), 0));
                nombreField.setText((String) model.getValueAt(tableProductos.getSelectedRow(), 1));
                apellidoField.setText(String.valueOf(model.getValueAt(tableProductos.getSelectedRow(), 2)));
                edadField.setText((String) model.getValueAt(tableProductos.getSelectedRow(), 3));
                calleField.setText((String) model.getValueAt(tableProductos.getSelectedRow(), 4));
                numeroField.setText((String) model.getValueAt(tableProductos.getSelectedRow(), 5));
                cpField.setText((String) model.getValueAt(tableProductos.getSelectedRow(), 6));
                emailField.setText((String) model.getValueAt(tableProductos.getSelectedRow(), 7));
            }
        });
    }

    public JPanel getPanelCRUD() {
        return panelCRUD;
    }
}
