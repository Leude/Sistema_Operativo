package algoritmos.paginacion;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.Vector;

public class RemplazoLRU extends Remplazo{



    @Override
    public DefaultTableModel remplazarPaginas(int numero_marcos, Vector<String> tokens) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Solicitud:"}, 0);
        for (int i = 0; i < numero_marcos; i++) {
            model.addRow(new Object[]{"Marco " + i + ":"});
        }
        Vector<String> vector_columna = new Vector<>();
        LinkedList<String> pila = new LinkedList();
        int posicion_columna = 0;
        for (int i = 0; i < tokens.size(); i++) {
            System.out.println(pila);
            String token = tokens.get(i);
            if (vector_columna.contains(token)) {
                model.addColumn(token, vector_columna);
                pila.remove(token);
                pila.addFirst(token);
                continue;
            }
            if (vector_columna.size() < numero_marcos) {
                vector_columna.add(token);
                model.addColumn(token, vector_columna);
                pila.addFirst(token);
            } else {
                posicion_columna = vector_columna.indexOf(pila.removeLast());
                pila.addFirst(token);
                vector_columna.set(posicion_columna, token);
                model.addColumn(token, vector_columna);
            }
        }
        return model;
    }
}
