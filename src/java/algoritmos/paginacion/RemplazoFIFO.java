package algoritmos.paginacion;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class RemplazoFIFO extends Remplazo{




    @Override
    public DefaultTableModel remplazarPaginas(int numero_marcos, Vector<String> tokens) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Solicitud:"}, 0);
        for (int i = 0; i < numero_marcos; i++) {
            model.addRow(new Object[]{"Marco " + i + ":"});
        }
        Vector<String> vector_columna = new Vector<>();
        int posicion_columna = 0;
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (vector_columna.contains(token)) {
                model.addColumn(token, vector_columna);
                continue;
            }
            if (vector_columna.size() < numero_marcos) {
                vector_columna.add(token);
                model.addColumn(token, vector_columna);
            } else {
                vector_columna.set(posicion_columna, token);
                model.addColumn(token, vector_columna);
                posicion_columna += 1;
                if (posicion_columna >= numero_marcos) {
                    posicion_columna = 0;
                }
            }
        }
        return model;
    }
}
