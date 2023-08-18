package com.software.elector.view.model;

import com.software.elector.model.Barrio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author C.Mateo
 */
public class BarrioTableModel extends AbstractTableModel{
    
    private List<Barrio> listaBarrios;
    private final String COLUMN_NAMES [];
    
    public BarrioTableModel(){
        COLUMN_NAMES  = new String [] {"Nombre"};
        listaBarrios = new ArrayList<>();
    }

    public List<Barrio> getListaBarrios() {
        return listaBarrios;
    }

    public void setListaBarrios(List<Barrio> listaBarrios) {
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
        Barrio barrio = listaBarrios.get(rowIndex);
        return barrio.getNombre();
    }
    
    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
    
}
