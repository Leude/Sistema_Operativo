package ventanas;

import remplazo.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPageReplacement {
    private JComboBox algoritmo;
    private JSpinner no_frames;
    private JSpinner no_tokens;
    private JButton boton_iniciar;
    private JPanel panel_principal;
    private JLabel hit;
    private JLabel ratio;
    private JLabel fault;
    private JTextArea textArea1;

    public AppPageReplacement() {
        boton_iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarPaginacion(algoritmo.getSelectedIndex());
            }
        });
    }

    public void iniciarPaginacion(int opcion) {
        switch (opcion) {
            case 0 -> {
                FIFO fifo = new FIFO();
                fifo.num_frames((int) no_frames.getValue());
                fifo.cantidadReferencias((int) no_tokens.getValue());
                fifo.proceso();
                textArea1.setText(fifo.getResultado());
                hit.setText(String.valueOf(fifo.getHit()));
                ratio.setText(String.valueOf(fifo.getHitRatio()));
                fault.setText(String.valueOf(fifo.getFault()));
            }
            case 1 -> {
                LRU lru = new LRU();
                lru.num_frames((int) no_frames.getValue());
                lru.cantidadReferencias((int) no_tokens.getValue());
                lru.proceso();
                textArea1.setText(lru.getResultado());
                hit.setText(String.valueOf(lru.getHit()));
                ratio.setText(String.valueOf(lru.getHitRatio()));
                fault.setText(String.valueOf(lru.getFault()));

            }
            case 2 -> {
                OPTIMAL optimal = new OPTIMAL();
                optimal.num_frames((int) no_frames.getValue());
                optimal.cantidadReferencias((int) no_tokens.getValue());
                optimal.proceso();
                textArea1.setText(optimal.getResultado());
                hit.setText(String.valueOf(optimal.getHit()));
                ratio.setText(String.valueOf(optimal.getHitRatio()));
                fault.setText(String.valueOf(optimal.getFault()));
            }
            case 3 -> {
                SECOND scnd = new SECOND();
                scnd.num_frames((int) no_frames.getValue());
                scnd.cantidadReferencias((int) no_tokens.getValue());
                scnd.proceso();
                textArea1.setText(scnd.getResultado());
                hit.setText(String.valueOf(scnd.getHit()));
                ratio.setText(String.valueOf(scnd.getHitRatio()));
                fault.setText(String.valueOf(scnd.getFault()));

            }
        }
    }

    public JPanel getPanelPaginacion() {
        return panel_principal;
    }
}
