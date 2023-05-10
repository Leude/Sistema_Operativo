package algoritmos.paginacion;


import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public abstract class Remplazo {


    public abstract DefaultTableModel remplazarPaginas(int numero_marcos, Vector<String> tokens);
}
