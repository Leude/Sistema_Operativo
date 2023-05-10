package ventanas;

import algoritmos.archivos.CRUD;
import algoritmos.archivos.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;

public class AppFile {
    private JPanel panelCRUD;
    private JTextField idField;
    private JTextField descripcionField;
    private JTextField precioField;
    private JTextField marcaField;
    private JButton agregarButton;
    private JButton removerButton;
    private JButton modificarButton;
    private JComboBox buscarBox;
    private JTextField buscarField;
    private JButton buscarButton;
    private JTable tableProductos;

    private DefaultTableModel model;

    public AppFile() {
        model = new DefaultTableModel(new Object[]{"ID", "Descripcion", "Precio", "Marca"}, 0);
        tableProductos.setModel(model);
        CRUD crud = new CRUD();
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crud.agregarProducto(descripcionField.getText(), Integer.valueOf(precioField.getText()), marcaField.getText());
                buscarButton.doClick();
            }
        });
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crud.removerProducto(idField.getText());
                buscarButton.doClick();
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crud.modificarProducto(idField.getText(), descripcionField.getText(), Integer.valueOf(precioField.getText()), marcaField.getText());
                buscarButton.doClick();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model = new DefaultTableModel(new Object[]{"ID", "Descripcion", "Precio", "Marca"}, 0);
                tableProductos.setModel(model);
                Hashtable<String, Producto> map;
                if (buscarField.getText().equals("")) {
                    map = crud.getMap();

                } else {
                    map = crud.buscarProducto(buscarField.getText(), buscarBox.getSelectedIndex());

                }
                for (String s : map.keySet()) {
                    Producto producto = map.get(s);
                    model.addRow(new Object[]{s, producto.getDescripcion(), producto.getPrecio(), producto.getMarca()});
                }
            }
        });
        tableProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                idField.setText((String) model.getValueAt(tableProductos.getSelectedRow(),0));
                descripcionField.setText((String) model.getValueAt(tableProductos.getSelectedRow(),1));
                precioField.setText(String.valueOf(model.getValueAt(tableProductos.getSelectedRow(),2)));
                marcaField.setText((String) model.getValueAt(tableProductos.getSelectedRow(),3));
            }
        });
    }

    public JPanel getPanelCRUD() {
        return panelCRUD;
    }
}
