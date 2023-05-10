package algoritmos.calendarización;

public class Proceso {
    private String nombre;
    private int tiempoEjecucion;
    private int tiempoServicio;
    private int prioridad;

    public Proceso(String nombre, int tiempoEjecucion) {
        this.nombre = nombre;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public Proceso(String nombre, int tiempoEjecucion, int prioridad) {
        this.nombre = nombre;
        this.tiempoEjecucion = tiempoEjecucion;
        this.prioridad = prioridad;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public void setTiempoServicio(int tiempoServicio) {
        this.tiempoServicio = tiempoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public int getTiempoServicio() {
        return tiempoServicio;
    }

    public int getPrioridad() {
        return prioridad;
    }


}
