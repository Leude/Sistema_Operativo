package algoritmos.calendarización;


import java.util.Vector;

public class SchedulingRR extends Scheduling {

    private int quantum;

    public SchedulingRR(int quantum) {
        this.quantum = quantum;
    }

    @Override
    public Vector<Proceso> calanderizarProcesos(Vector<Proceso> procesos) {

        int suma_espera = 0;
        int cantidad_procesos = procesos.size();

        while (true) {
            int cantida_saltos = 0;
            for (Proceso proceso : procesos) {
                if (proceso.getTiempoEjecucion() == 0) {
                    cantida_saltos += 1;
                    continue;
                }
                if (proceso.getTiempoEjecucion() >= quantum) {
                    Proceso nuevo_proceso = new Proceso(proceso.getNombre(),proceso.getTiempoEjecucion());
                    nuevo_proceso.setTiempoServicio(suma_espera);
                    schedulingProcesos.add(nuevo_proceso);

                    int tiempo_restante = proceso.getTiempoEjecucion() - quantum;
                    suma_espera += quantum;
                    proceso.setTiempoEjecucion(tiempo_restante);

                } else {
                    Proceso nuevo_proceso = new Proceso(proceso.getNombre(),proceso.getTiempoEjecucion());
                    nuevo_proceso.setTiempoServicio(suma_espera);
                    schedulingProcesos.add(nuevo_proceso);

                    int tiempo_restante = proceso.getTiempoEjecucion() - proceso.getTiempoEjecucion();
                    suma_espera += proceso.getTiempoEjecucion();
                    proceso.setTiempoEjecucion(tiempo_restante);
                }
            }
            if (cantida_saltos == cantidad_procesos) break;
        }

        return schedulingProcesos;
    }

    @Override
    public float calcularTiempoMedioEspera() {
        float suma = 0;
        for (Proceso proceso : schedulingProcesos) {
            suma += proceso.getTiempoServicio();
        }
        return suma / schedulingProcesos.size();
    }
}
