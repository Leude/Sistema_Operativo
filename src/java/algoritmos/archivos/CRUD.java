package algoritmos.archivos;

import java.util.Hashtable;

public class CRUD {


    Hashtable<String, Producto> map;

    private int contador = 8;

    public CRUD() {
        this.map = new Hashtable<>();
        map.put("P1", new Producto("iPhone13", 18999, "Apple"));
        map.put("P2", new Producto("Monopoly", 364, "Hasbro"));
        map.put("P3", new Producto("UNO", 99, "Mattel"));
        map.put("P4", new Producto("Taladro Atornillador", 1851, "Airona"));
        map.put("P5", new Producto("Raqueta de Tenis", 519, "Wilson"));
        map.put("P6", new Producto("Mesa de Ping Pong", 19999, "Stiga"));
        map.put("P7", new Producto("Balón de Básquetbol", 899, "Wilson"));
    }

    public Hashtable<String, Producto> buscarProducto(String busqueda, int tipoBusqueda) {
        Hashtable<String, Producto> hashtable = new Hashtable<>();
        switch (tipoBusqueda) {
            case 1 -> {
                //Descripcion
                for (String s : map.keySet()) {
                    if (map.get(s).getDescripcion().equalsIgnoreCase(busqueda)) {
                        hashtable.put(s, map.get(s));
                    }
                }
            }
            case 2 -> {
                //Precio
                for (String s : map.keySet()) {
                    if (map.get(s).getPrecio() == Integer.valueOf(busqueda)) {
                        hashtable.put(s, map.get(s));
                    }
                }
            }
            case 3 -> {
                //Marca
                for (String s : map.keySet()) {
                    if (map.get(s).getMarca().equalsIgnoreCase(busqueda)) {
                        hashtable.put(s, map.get(s));
                    }
                }
            }
            default -> {
                //ID
                hashtable.put(busqueda, map.get(busqueda));
            }
        }
        return hashtable;
    }
                //Bajas//
    public void removerProducto(String key) {
        map.remove(key);
    }
                //Altas//
    public void agregarProducto(String descricion, int precio, String marca) {
        map.put("P" + contador, new Producto(descricion, precio, marca));
        contador += 1;
    }
                //Cambios//
    public void modificarProducto(String key, String descricion, int precio, String marca) {
        Producto producto = map.get(key);
        producto.setDescripcion(descricion);
        producto.setPrecio(precio);
        producto.setMarca(marca);
        contador += 1;
    }

    public Hashtable<String, Producto> getMap() {
        return map;
    }
}
