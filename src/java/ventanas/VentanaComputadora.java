package ventanas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaComputadora {
    private JPanel panelPrincipal;
    private JPanel monitor;
    private JButton procesosButton;
    private JButton memoriaButton;
    private JButton archivosButton;
    private JPanel escritorio;
    private JLabel relojLabel;
    private JPanel programa;
    private JButton cerrarButton;

    public VentanaComputadora() {

        procesosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame();
                jFrame.setContentPane(new AppSchedule().getPanelCalendarizacion());
                jFrame.setVisible(true);
                jFrame.setLocation(procesosButton.getLocation());
                jFrame.pack();
            }
        });

        memoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame();
                jFrame.setContentPane(new AppPaginacion().getPanelPaginacion());
                jFrame.setVisible(true);
                jFrame.setLocation(procesosButton.getLocation());
                jFrame.pack();
            }
        });
        archivosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame();
                jFrame.setContentPane(new AppFile().getPanelCRUD());
                jFrame.setVisible(true);
                jFrame.setLocation(procesosButton.getLocation());
                jFrame.pack();
            }
        });

    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public JLabel getRelojLabel(){
        return relojLabel;
    }

}
