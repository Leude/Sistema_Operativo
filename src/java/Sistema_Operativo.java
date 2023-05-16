
import archivos.Almacenamiento;
import archivos.Archivo;
import ventanas.VentanaComputadora;

import javax.swing.*;

public class Sistema_Operativo {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Sistema_Operativo");
        VentanaComputadora simulador = new VentanaComputadora();
        jFrame.setContentPane(simulador.getPanelPrincipal());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.pack();
    }
}
