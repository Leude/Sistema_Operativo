
import windows.PC;

import javax.swing.*;

public class Sistema_Operativo {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Sistema_Operativo");
        PC simulador = new PC();
        jFrame.setContentPane(simulador.getPanelPrincipal());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.pack();
    }
}
