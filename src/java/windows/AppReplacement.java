package windows;

import replacement.FIFO;
import replacement.LRU;
import replacement.OPTIMAL;
import replacement.SECOND;

import javax.swing.*;

import static java.lang.String.valueOf;

public class AppReplacement {
    private JComboBox algoritmo;
    private JSpinner no_frames;
    private JSpinner no_tokens;
    private JButton boton_iniciar;
    private JPanel panel_principal;
    private JLabel hit;
    private JLabel ratio;
    private JLabel fault;
    private JTextArea textArea1;

    public AppReplacement() {
        boton_iniciar.addActionListener(e -> iniciarPaginacion(algoritmo.getSelectedIndex()));
    }

    public void iniciarPaginacion(int opcion) {
        switch (opcion) {
            case 0 -> {
                FIFO fifo = new FIFO();
                fifo.setFrames((int) no_frames.getValue());
                fifo.setRef_len((int) no_tokens.getValue());
                fifo.execute();
                textArea1.setText(fifo.getOutString());
                hit.setText(valueOf(fifo.getHit()));
                ratio.setText(valueOf(fifo.getHitRatio()));
                fault.setText(valueOf(fifo.getFault()));
            }
            case 1 -> {
                LRU lru = new LRU();
                lru.setFrames((int) no_frames.getValue());
                lru.setRef_len((int) no_tokens.getValue());
                lru.execute();
                textArea1.setText(lru.getOutString());
                hit.setText(valueOf(lru.getHit()));
                ratio.setText(valueOf(lru.getHitRatio()));
                fault.setText(valueOf(lru.getFault()));
            }
            case 2 -> {
                OPTIMAL optimal = new OPTIMAL();
                optimal.setFrames((int) no_frames.getValue());
                optimal.setRef_len((int) no_tokens.getValue());
                optimal.execute();
                textArea1.setText(optimal.getOutString());
                hit.setText(valueOf(optimal.getHit()));
                ratio.setText(valueOf(optimal.getHitRatio()));
                fault.setText(valueOf(optimal.getFault()));
            }
            case 3 -> {
                SECOND scnd = new SECOND();
                scnd.setFrames((int) no_frames.getValue());
                scnd.setRef_len((int) no_tokens.getValue());
                scnd.execute();
                textArea1.setText(scnd.getOutString());
                hit.setText(valueOf(scnd.getHit()));
                ratio.setText(valueOf(scnd.getHitRatio()));
                fault.setText(valueOf(scnd.getFault()));

            }
        }
    }

    public JPanel getPanelPaginacion() {
        return panel_principal;
    }
}
