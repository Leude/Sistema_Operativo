package ventanas;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AppSchedule {
    private JSpinner tiempoSpinner;
    private JSpinner prioridadSpinner;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JComboBox algoritmoProcesosComboBox;
    private JTable procesosTable;
    private JTable schedulingTable;
    private JButton ejecutarButton;
    private JSpinner quantumSpinner;
    private JLabel tiempoMedioLabel;
    private JPanel panelCalendarizacion;

    private DefaultTableModel modelProcesoss;

    private int contador;

    public AppSchedule(){
        modelProcesoss = new DefaultTableModel(new Object[]{"Nivel Prioridad", "Nombre", "Tiempo de Ejecucion"}, 0);
        procesosTable.setModel(modelProcesoss);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelProcesoss.addRow(new Object[]{prioridadSpinner.getValue(), "P" + contador, tiempoSpinner.getValue()});
                contador += 1;
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelProcesoss.removeRow(procesosTable.getSelectedRow());
            }
        });
        ejecutarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //iniciarScheduling(algoritmoProcesosComboBox.getSelectedIndex(), (int) quantumSpinner.getValue());
            }
        });
    }
/*
    public void iniciarScheduling(int opcion, int quantum) {
        DefaultTableModel modelScheduling = new DefaultTableModel(new Object[]{"Nombre", "Tiempo de Espera"}, 0);
        schedulingTable.setModel(modelScheduling);
        Vector<Proceso> procesos = new Vector<>();
        Scheduling scheduling;
        switch (opcion) {
            case 1 -> {
                scheduling = new SchedulingSJF();
                for (Vector vector : modelProcesoss.getDataVector()) {
                    procesos.add(new Proceso((String) vector.get(1), (int) vector.get(2)));
                }
            }
            case 2 -> {
                scheduling = new SchedulingPriority();
                for (Vector vector : modelProcesoss.getDataVector()) {
                    procesos.add(new Proceso((String) vector.get(1), (int) vector.get(2), (int) vector.get(0)));
                }
            }
            case 3 -> {
                scheduling = new SchedulingRR(quantum);
                for (Vector vector : modelProcesoss.getDataVector()) {
                    procesos.add(new Proceso((String) vector.get(1), (int) vector.get(2)));
                }
            }
            default -> {
                scheduling = new SchedulingFCFS();
                for (Vector vector : modelProcesoss.getDataVector()) {
                    procesos.add(new Proceso((String) vector.get(1), (int) vector.get(2)));
                }
            }
        }
        for (Proceso proceso : scheduling.calanderizarProcesos(procesos)) {
            modelScheduling.addRow(new Object[]{proceso.getNombre(), proceso.getTiempoServicio()});
        }

        tiempoMedioLabel.setText(String.valueOf(scheduling.calcularTiempoMedioEspera()));
    }
*/
    public JPanel getPanelCalendarizacion() {
        return panelCalendarizacion;
    }
}
