package windows;

import scheduling.FCFS;
import scheduling.PRIORITY;
import scheduling.RR;

import javax.swing.*;

public class AppScheduling {
    private JTextArea textArea;
    private JButton boton_iniciar;
    private JComboBox algoritmo;
    private JPanel panel;

    public AppScheduling() {
        boton_iniciar.addActionListener(e -> iniciar(algoritmo.getSelectedIndex()));
    }

    public void iniciar(int opcion) {
        switch (opcion) {
            case 0 -> {
                textArea.setText(new FCFS().getOutString());
            }
            case 1 -> {
                textArea.setText(new PRIORITY().getOutString());
            }
            case 2 -> {
                textArea.setText(new RR().getOutString());
            }
            case 3 -> {
                //new SJF();
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
