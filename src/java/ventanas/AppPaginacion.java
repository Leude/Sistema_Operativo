package ventanas;

import algos.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPaginacion {
    private JComboBox algoritmoMemoriacomboBox;
    private JSpinner cantidad_marcos;
    private JSpinner cantidad_tokens;
    private JButton boton_iniciar;
    private JPanel panelPaginacion;
    private JTextPane textPane1;
    private JLabel hit;
    private JLabel ratio;
    private JLabel fault;

    public AppPaginacion() {
        boton_iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarPaginacion(algoritmoMemoriacomboBox.getSelectedIndex());
            }
        });
    }

    public void iniciarPaginacion(int opcion) {
        switch (opcion) {
            case 1 -> {
                FIFO fifo = new FIFO();
                fifo.num_frames((int)cantidad_marcos.getValue());
                fifo.cantidadReferencias((int)cantidad_tokens.getValue());
                fifo.proceso();
                textPane1.setText(fifo.getResultado());
                hit.setText(String.valueOf(fifo.getHit()));
                ratio.setText(String.valueOf(fifo.getHitRatio()));
                fault.setText(String.valueOf(fifo.getFault()));
            }
            case 2 -> {
                LRU lru = new LRU();
                lru.num_frames((int)cantidad_marcos.getValue());
                lru.cantidadReferencias((int)cantidad_tokens.getValue());
                lru.proceso();
                textPane1.setText(lru.getResultado());
                hit.setText(String.valueOf(lru.getHit()));
                ratio.setText(String.valueOf(lru.getHitRatio()));
                fault.setText(String.valueOf(lru.getFault()));

            }
            case 3 -> {
                OPTIMAL optimal = new OPTIMAL();
                optimal.num_frames((int)cantidad_marcos.getValue());
                optimal.cantidadReferencias((int)cantidad_tokens.getValue());
                optimal.proceso();
                textPane1.setText(optimal.getResultado());
                hit.setText(String.valueOf(optimal.getHit()));
                ratio.setText(String.valueOf(optimal.getHitRatio()));
                fault.setText(String.valueOf(optimal.getFault()));
            }
            default -> {
                SECOND scnd = new SECOND();
                scnd.num_frames((int)cantidad_marcos.getValue());
                scnd.cantidadReferencias((int)cantidad_tokens.getValue());
                scnd.proceso();
                textPane1.setText(scnd.getResultado());
                hit.setText(String.valueOf(scnd.getHit()));
                ratio.setText(String.valueOf(scnd.getHitRatio()));
                fault.setText(String.valueOf(scnd.getFault()));

            }
        }
        //memoriaTabla.setModel(remplazo.remplazarPaginas((int) cantidad_marcos.getValue(), tokens));
    }

    public JPanel getPanelPaginacion() {
        return panelPaginacion;
    }
}
