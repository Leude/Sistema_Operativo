package algoritmos.paginacion;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedHashMap;
import java.util.Vector;

public class RemplazoClock extends Remplazo {


    @Override
    public DefaultTableModel remplazarPaginas(int numero_marcos, Vector<String> tokens) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Solicitud:"}, 0);
        for (int i = 0; i < numero_marcos; i++) {
            model.addRow(new Object[]{"Marco " + i + ":"});
        }
        LinkedHashMap<String, Integer> map_columna = new LinkedHashMap<>();
        Vector<String> vector_columna = new Vector();
        int apuntador = 0;
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (vector_columna.contains(token)) {
                map_columna.put(token, 1);
                model.addColumn(token, vector_columna);
                continue;
            }

            if (vector_columna.size() < numero_marcos) {
                map_columna.put(token, 1);
                vector_columna.add(token);
                model.addColumn(token, vector_columna);
                continue;
            }

            while (!vector_columna.contains(token)) {
                System.out.println(vector_columna);
                if (map_columna.get(vector_columna.get(apuntador)) == 0) {
                    map_columna.remove(vector_columna.get(apuntador));
                    vector_columna.set(apuntador, token);
                    map_columna.put(token, 1);
                } else {
                    map_columna.put(vector_columna.get(apuntador), 0);
                    System.out.println("Cambio: " + map_columna.get(token));
                }
                apuntador += 1;
                if (apuntador >= numero_marcos) {
                    apuntador = 0;
                }
            }
            model.addColumn(token, vector_columna);
        }
        return model;
    }
}
