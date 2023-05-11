package archivos;

import java.lang.reflect.Array;
import java.util.*;

public class Almacenamiento {

    public static Vector<String> columna = new Vector<>(
            Arrays.asList("ID","NOMBRE", "APELLIDO", "EDAD", "CALLE", "NUMERO", "C.P", "EMAIL"));

    public static LinkedHashMap<String, Archivo> archivos = new LinkedHashMap<>();

    public Almacenamiento() {
        Archivo archivo = new Archivo("Jorge", "Diaz", 34, "Felipe_Villanueva", 763, 50122, "jd99@yahoo.com");
        Archivo archivo1 = new Archivo("Eduardo", "Diaz", 32, "Felipe_Villanueva", 763, 50122, "ed97@yahoo.com");
        Archivo archivo2 = new Archivo("Mauricio", "Diaz", 28, "Felipe_Villanueva", 763, 50122, "md98@yahoo.com");
        Archivo archivo3 = new Archivo("Ana", "Diaz", 33, "Felipe_Villanueva", 763, 50122, "ad92@yahoo.com");
        Archivo archivo4 = new Archivo("Rosa", "Diaz", 35, "Felipe_Villanueva", 763, 50122, "rd93@yahoo.com");
        archivos.put(String.valueOf(archivo.hashCode()), archivo);
        archivos.put(String.valueOf(archivo1.hashCode()), archivo1);
        archivos.put(String.valueOf(archivo2.hashCode()), archivo2);
        archivos.put(String.valueOf(archivo3.hashCode()), archivo3);
        archivos.put(String.valueOf(archivo4.hashCode()), archivo4);
    }

    public static Vector<Vector<String>> buscarArchivo(String busqueda, int tipoBusqueda) {
        System.out.println("BUSCANDO" + Almacenamiento.archivos.size());
        Vector<Vector<String>> vectors = new Vector<>();

        if (busqueda.isEmpty()) {
            Almacenamiento.archivos.forEach((s, archivo) -> vectors.add(crearVector(s, archivo)));
            return vectors;
        }

        switch (tipoBusqueda) {
            case 0 -> {
                //ID
                Almacenamiento.archivos.forEach((s, archivo) -> {
                    if (s.equalsIgnoreCase(busqueda)) vectors.add(crearVector(s, archivo));
                });
            }
            case 1 -> {
                //Nombre
                Almacenamiento.archivos.forEach((s, archivo) -> {
                    if (archivo.getNombre().startsWith(busqueda)) vectors.add(crearVector(s, archivo));
                });
            }
            case 2 -> {
                //Apellido
                Almacenamiento.archivos.forEach((s, archivo) -> {
                    if (archivo.getApellido().startsWith(busqueda)) vectors.add(crearVector(s, archivo));
                });
            }
            case 3 -> {
                //Edad
                Almacenamiento.archivos.forEach((s, archivo) -> {
                    if (String.valueOf(archivo.getEdad()).startsWith(busqueda)) vectors.add(crearVector(s, archivo));
                });
            }
            case 4 -> {
                //Calle
                Almacenamiento.archivos.forEach((s, archivo) -> {
                    if (archivo.getCalle().startsWith(busqueda)) vectors.add(crearVector(s, archivo));
                });
            }
            case 5 -> {
                //Numero
                Almacenamiento.archivos.forEach((s, archivo) -> {
                    if (String.valueOf(archivo.getNumero()).startsWith(busqueda)) vectors.add(crearVector(s, archivo));
                });
            }
            case 6 -> {
                //CP
                Almacenamiento.archivos.forEach((s, archivo) -> {
                    if (String.valueOf(archivo.getCp()).startsWith(busqueda)) vectors.add(crearVector(s, archivo));
                });
            }
            case 7 -> {
                //Email
                Almacenamiento.archivos.forEach((s, archivo) -> {
                    if (archivo.getEmail().startsWith(busqueda)) vectors.add(crearVector(s, archivo));
                });
            }
        }
        return vectors;
    }

    //Bajas//
    public static void removerArchivo(String key) {
        archivos.remove(key);
    }

    //Altas//
    public static void agregarArchivo(String nombre, String apellido, int edad, String calle, int numero, int cp, String email) {
        Archivo archivo = new Archivo(nombre, apellido, edad, calle, numero, cp, email);
        archivos.put(String.valueOf(archivo.hashCode()), archivo);
    }

    //Cambios//
    public static void modificarArchivo(String key, String nombre, String apellido, int edad, String calle, int numero, int cp, String email) {
        Archivo archivo = archivos.get(key);
        archivo.setNombre(nombre);
        archivo.setApellido(apellido);
        archivo.setEdad(edad);
        archivo.setCalle(calle);
        archivo.setNumero(numero);
        archivo.setCp(cp);
        archivo.setEmail(email);
    }

    public static Vector<String> crearVector(String s, Archivo archivo) {
        Vector<String> strings = new Vector<>();
        strings.add(s);
        strings.add(archivo.getNombre());
        strings.add(archivo.getApellido());
        strings.add(String.valueOf(archivo.getEdad()));
        strings.add(archivo.getCalle());
        strings.add(String.valueOf(archivo.getNumero()));
        strings.add(String.valueOf(archivo.getCp()));
        strings.add(archivo.getEmail());
        return strings;
    }
}
