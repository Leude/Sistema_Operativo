package file;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Vector;

public class Storage {

    public static Vector<String> columna = new Vector<>(
            Arrays.asList("ID", "NOMBRE", "APELLIDO", "EDAD", "CALLE", "NUMERO", "C.P", "EMAIL"));

    public static LinkedHashMap<String, File> archivos = new LinkedHashMap<>();

    static {
        File file = new File("Jorge", "Diaz", 34, "Felipe_Villa", 763, 50122, "jd99@yahoo.com");
        File file1 = new File("Eduardo", "Diaz", 32, "Felipe_Villa", 763, 50122, "ed97@yahoo.com");
        File file2 = new File("Mauricio", "Diaz", 28, "Felipe_Villa", 763, 50122, "md98@yahoo.com");
        File file3 = new File("Ana", "Diaz", 33, "Felipe_Villa", 763, 50122, "ad92@yahoo.com");
        File file4 = new File("Rosa", "Diaz", 35, "Felipe_Villan", 763, 50122, "rd93@yahoo.com");
        archivos.put(String.valueOf(file.hashCode()), file);
        archivos.put(String.valueOf(file1.hashCode()), file1);
        archivos.put(String.valueOf(file2.hashCode()), file2);
        archivos.put(String.valueOf(file3.hashCode()), file3);
        archivos.put(String.valueOf(file4.hashCode()), file4);
    }

    private Storage() {

    }

    public static Vector<Vector<String>> buscarArchivo(String busqueda, int tipoBusqueda) {
        System.out.println("BUSCANDO" + Storage.archivos.size());
        Vector<Vector<String>> vectors = new Vector<>();

        if (busqueda.isEmpty()) {
            Storage.archivos.forEach((s, file) -> vectors.add(crearVector(s, file)));
            return vectors;
        }

        switch (tipoBusqueda) {
            case 0 -> {
                //ID
                Storage.archivos.forEach((s, file) -> {
                    if (s.equalsIgnoreCase(busqueda)) vectors.add(crearVector(s, file));
                });
            }
            case 1 -> {
                //Nombre
                Storage.archivos.forEach((s, file) -> {
                    if (file.getNombre().startsWith(busqueda)) vectors.add(crearVector(s, file));
                });
            }
            case 2 -> {
                //Apellido
                Storage.archivos.forEach((s, file) -> {
                    if (file.getApellido().startsWith(busqueda)) vectors.add(crearVector(s, file));
                });
            }
            case 3 -> {
                //Edad
                Storage.archivos.forEach((s, file) -> {
                    if (String.valueOf(file.getEdad()).startsWith(busqueda)) vectors.add(crearVector(s, file));
                });
            }
            case 4 -> {
                //Calle
                Storage.archivos.forEach((s, file) -> {
                    if (file.getCalle().startsWith(busqueda)) vectors.add(crearVector(s, file));
                });
            }
            case 5 -> {
                //Numero
                Storage.archivos.forEach((s, file) -> {
                    if (String.valueOf(file.getNumero()).startsWith(busqueda)) vectors.add(crearVector(s, file));
                });
            }
            case 6 -> {
                //CP
                Storage.archivos.forEach((s, file) -> {
                    if (String.valueOf(file.getCp()).startsWith(busqueda)) vectors.add(crearVector(s, file));
                });
            }
            case 7 -> {
                //Email
                Storage.archivos.forEach((s, file) -> {
                    if (file.getEmail().startsWith(busqueda)) vectors.add(crearVector(s, file));
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
    public static void agregarArchivo(String nombre, String apellido, int edad, String calle, long numero, int cp, String email) {
        File file = new File(nombre, apellido, edad, calle, numero, cp, email);
        archivos.put(String.valueOf(file.hashCode()), file);
    }

    //Cambios//
    public static void modificarArchivo(String key, String nombre, String apellido, int edad, String calle, long numero, int cp, String email) {
        File file = archivos.get(key);
        file.setNombre(nombre);
        file.setApellido(apellido);
        file.setEdad(edad);
        file.setCalle(calle);
        file.setNumero(numero);
        file.setCp(cp);
        file.setEmail(email);
    }

    public static Vector<String> crearVector(String s, File file) {
        Vector<String> strings = new Vector<>();
        strings.add(s);
        strings.add(file.getNombre());
        strings.add(file.getApellido());
        strings.add(String.valueOf(file.getEdad()));
        strings.add(file.getCalle());
        strings.add(String.valueOf(file.getNumero()));
        strings.add(String.valueOf(file.getCp()));
        strings.add(file.getEmail());
        return strings;
    }
}
