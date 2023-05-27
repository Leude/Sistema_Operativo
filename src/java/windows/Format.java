package windows;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import static file.Storage.agregarArchivo;
import static file.Storage.modificarArchivo;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
import static javax.swing.KeyStroke.getKeyStroke;

public class Format extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JFormattedTextField id_text;
    private JFormattedTextField nombre_text;
    private JFormattedTextField apellido_text;
    private JFormattedTextField edad_text;
    private JFormattedTextField calle_text;
    private JFormattedTextField numero_text;
    private JFormattedTextField cp_text;
    private JFormattedTextField email_text;
    private AppFile appFile;

    private boolean editar = false;

    public Format(AppFile appFile) {
        this.appFile = appFile;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), getKeyStroke(KeyEvent.VK_ESCAPE, 0), WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        if (editar) {
            modificarArchivo(id_text.getText(),
                    nombre_text.getText(),
                    apellido_text.getText(),
                    parseInt(edad_text.getText()),
                    calle_text.getText(),
                    parseLong(numero_text.getText()),
                    parseInt(cp_text.getText()),
                    email_text.getText());

        } else {
            agregarArchivo(nombre_text.getText(),
                    apellido_text.getText(),
                    parseInt(edad_text.getText()),
                    calle_text.getText(),
                    parseLong(numero_text.getText()),
                    parseInt(cp_text.getText()),
                    email_text.getText());
        }
        appFile.buscarButton.doClick();
        dispose();
    }

    public void setEditar() {
        editar = true;
        id_text.setText((String) appFile.model.getValueAt(appFile.tableProductos.getSelectedRow(), 0));
        nombre_text.setText((String) appFile.model.getValueAt(appFile.tableProductos.getSelectedRow(), 1));
        apellido_text.setText(String.valueOf(appFile.model.getValueAt(appFile.tableProductos.getSelectedRow(), 2)));
        edad_text.setText((String) appFile.model.getValueAt(appFile.tableProductos.getSelectedRow(), 3));
        calle_text.setText((String) appFile.model.getValueAt(appFile.tableProductos.getSelectedRow(), 4));
        numero_text.setText((String) appFile.model.getValueAt(appFile.tableProductos.getSelectedRow(), 5));
        cp_text.setText((String) appFile.model.getValueAt(appFile.tableProductos.getSelectedRow(), 6));
        email_text.setText((String) appFile.model.getValueAt(appFile.tableProductos.getSelectedRow(), 7));
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        try {
            MaskFormatter nameFormatter = new MaskFormatter("*".repeat(10));
            MaskFormatter edadFormat = new MaskFormatter("#".repeat(2));
            MaskFormatter calleFormatter = new MaskFormatter("*".repeat(15));
            MaskFormatter numeroFormat = new MaskFormatter("#".repeat(10));
            MaskFormatter cpFormat = new MaskFormatter("#".repeat(5));
            MaskFormatter emailFormatter = new MaskFormatter("*".repeat(35));

            nombre_text = new JFormattedTextField(nameFormatter);
            apellido_text = new JFormattedTextField(nameFormatter);
            edad_text = new JFormattedTextField(edadFormat);
            calle_text = new JFormattedTextField(calleFormatter);
            numero_text = new JFormattedTextField(numeroFormat);
            cp_text = new JFormattedTextField(cpFormat);
            email_text = new JFormattedTextField(emailFormatter);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
