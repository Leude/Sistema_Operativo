package algoritmos.archivos;

public class Producto {

    private String descripcion;
    private int precio;
    private String marca;

    public Producto(String descripcion, int precio, String marca) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
