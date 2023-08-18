package com.software.elector.view.model;

import com.software.elector.model.Comuna;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author C.Mateo
 */
public class ComunaTableModel extends AbstractTableModel {

    private List<Comuna> listaComunas;
    private final String COLUMN_NAMES[];

    public ComunaTableModel() {
        this.COLUMN_NAMES = new String[]{"Nombre"};
        listaComunas = new ArrayList<>();
    }

    public List<Comuna> getListaComunas() {
        return listaComunas;
    }

    public void setListaComunas(List<Comuna> listaComunas) {
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
        Comuna comuna = listaComunas.get(rowIndex);
        return comuna.getNombre();
    }

}
