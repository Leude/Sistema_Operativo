package algoritmos.calendarización;

import java.util.Vector;

public abstract class Scheduling {
    protected Vector<Proceso> schedulingProcesos = new Vector<>();
    public abstract Vector<Proceso> calanderizarProcesos(Vector<Proceso> procesos);
    public abstract float calcularTiempoMedioEspera();


}
