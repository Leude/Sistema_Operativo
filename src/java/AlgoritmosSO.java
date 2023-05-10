import util.Reloj;

import ventanas.VentanaComputadora;

import javax.swing.*;

public class AlgoritmosSO {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("SimuladorSO");

        VentanaComputadora simulador = new VentanaComputadora();
        jFrame.setContentPane(simulador.getPanelPrincipal());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.pack();

        Thread reloj = new Reloj(simulador.getRelojLabel());
        reloj.run();
    }
}
