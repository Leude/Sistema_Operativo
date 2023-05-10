package algoritmos.paginacion;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.Vector;


public class RemplazoOPT extends Remplazo {



    @Override
    public DefaultTableModel remplazarPaginas(int numero_marcos, Vector<String> tokens) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Solicitud:"}, 0);
        for (int i = 0; i < numero_marcos; i++) {
            model.addRow(new Object[]{"Marco " + i + ":"});
        }
        LinkedList<String> columna = new LinkedList();
        Vector vector_columna = new Vector<>();

        for (int j = 0; j < tokens.size(); j++) {
            String token = tokens.get(j);
            if (columna.contains(token)) {
                model.addColumn(token, vector_columna);
                continue;
            }
            if (columna.size() < numero_marcos) {
                columna.add(token);
            } else {
                int posicion_columna = 0;
                int numero_alto = 0;
                for (int i = 0; i < columna.size(); i++) {
                    int numero = tokens.indexOf(columna.get(i), j);
                    if (numero == -1) {
                        posicion_columna = i;
                        break;
                    }
                    if (numero > numero_alto) {
                        numero_alto = numero;
                        posicion_columna = i;
                    }
                }
                columna.set(posicion_columna, token);
            }
            vector_columna = new Vector();
            for (int i = 0; i < columna.size(); i++) {
                vector_columna.add(columna.get(i));
            }
            model.addColumn(token, vector_columna);
        }
        return model;
    }
}
