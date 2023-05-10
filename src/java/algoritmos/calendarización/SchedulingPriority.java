package algoritmos.calendarización;


import java.util.Vector;

public class SchedulingPriority extends Scheduling {

    @Override
    public Vector<Proceso> calanderizarProcesos(Vector<Proceso> procesos) {
        ordenarPorPrioridad(procesos);
        int suma = 0;
        for (Proceso proceso : procesos) {
            schedulingProcesos.add(proceso);
            proceso.setTiempoServicio(suma);
            suma += proceso.getTiempoEjecucion();
        }
        return schedulingProcesos;
    }

    @Override
    public float calcularTiempoMedioEspera() {
        float suma = 0;
        for (Proceso proceso : schedulingProcesos) {
            suma += proceso.getTiempoServicio();
        }
        return suma/schedulingProcesos.size();
    }

    public void ordenarPorPrioridad(Vector<Proceso> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if ( list.get(i).getPrioridad() <  list.get(j).getPrioridad()) {
                    Proceso aux = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, aux);
                }
            }
        }
    }
}
