package com.software.elector.view.model;

import com.software.elector.model.Ciudad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author C.Mateo
 */
public class CiudadTableModel extends AbstractTableModel {

    private List<Ciudad> listaCiudades;
    private final String COLUMN_NAMES [];

    public CiudadTableModel() {
        this.COLUMN_NAMES = new String[]{"Nombre"};
        listaCiudades = new ArrayList<>();
    }
    
    public void setListaCiudades(List<Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
        fireTableDataChanged();
    }

    public List<Ciudad> getListaCiudades() {
        return listaCiudades;
    }
    
    @Override
    public int getRowCount() {
        return listaCiudades.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ciudad ciudad = listaCiudades.get(rowIndex);
        return ciudad.getNombre();
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    
}
