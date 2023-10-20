package contact.directory.view.model;

import contact.directory.model.Neighborhood;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author C.Mateo
 */
public class BarrioTableModel extends AbstractTableModel{
    
    private List<Neighborhood> listaBarrios;
    private final String COLUMN_NAMES [];
    
    public BarrioTableModel(){
        COLUMN_NAMES  = new String [] {"Nombre"};
        listaBarrios = new ArrayList<>();
    }

    public List<Neighborhood> getListaBarrios() {
        return listaBarrios;
    }

    public void setListaBarrios(List<Neighborhood> listaBarrios) {
        this.listaBarrios = listaBarrios;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return listaBarrios.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Neighborhood barrio = listaBarrios.get(rowIndex);
        return barrio.getName();
    }
    
    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
    
}
