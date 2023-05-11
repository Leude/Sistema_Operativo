package archivos;

public class Archivo {

    private String nombre;
    private String apellido;
    private int edad;
    private String calle;
    private int numero;
    private int cp;
    private String email;


    public Archivo(String nombre, String apellido, int edad, String calle, int numero, int cp, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
