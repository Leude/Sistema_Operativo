package windows;

import javax.swing.*;

public class PC {
    private JPanel panelPrincipal;
    private JButton procesosButton;
    private JButton memoriaButton;
    private JButton archivosButton;
    private JPanel escritorio;
    private JPanel monitor;

    public PC() {

        procesosButton.addActionListener(e -> {
            JFrame jFrame = new JFrame();
            jFrame.setContentPane(new AppScheduling().getPanel());
            jFrame.setVisible(true);
            jFrame.setLocation(escritorio.getWidth() / 4, escritorio.getHeight() / 4);
            jFrame.pack();
        });

        memoriaButton.addActionListener(e -> {
            JFrame jFrame = new JFrame();
            jFrame.setContentPane(new AppReplacement().getPanelPaginacion());
            jFrame.setVisible(true);
            jFrame.setLocation(escritorio.getWidth() / 4, escritorio.getHeight() / 4);
            jFrame.pack();
        });
        archivosButton.addActionListener(e -> {
            JFrame jFrame = new JFrame();
            jFrame.setContentPane(new AppFile().getPanel());
            jFrame.setVisible(true);
            jFrame.setLocation(escritorio.getWidth() / 4, escritorio.getHeight() / 4);
            jFrame.pack();
        });
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

}
