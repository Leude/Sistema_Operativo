package algoritmos.calendarización;

import java.util.Vector;

public class SchedulingFCFS extends Scheduling {

    @Override
    public Vector<Proceso> calanderizarProcesos(Vector<Proceso> procesos) {
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
}
