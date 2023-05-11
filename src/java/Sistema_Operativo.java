
import ventanas.VentanaComputadora;

import javax.swing.*;

public class Sistema_Operativo {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("SimuladorSO");

        VentanaComputadora simulador = new VentanaComputadora();
        jFrame.setContentPane(simulador.getPanelPrincipal());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        jFrame.pack();
    }
}
