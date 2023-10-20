package contact.directory.view.model;

import contact.directory.model.Commune;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author C.Mateo
 */
public class ComunaTableModel extends AbstractTableModel {

    private List<Commune> listaComunas;
    private final String COLUMN_NAMES[];

    public ComunaTableModel() {
        this.COLUMN_NAMES = new String[]{"Nombre"};
        listaComunas = new ArrayList<>();
    }

    public List<Commune> getListaComunas() {
        return listaComunas;
    }

    public void setListaComunas(List<Commune> listaComunas) {
        this.listaComunas = listaComunas;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listaComunas.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Commune comuna = listaComunas.get(rowIndex);
        return comuna.getName();
    }

}
