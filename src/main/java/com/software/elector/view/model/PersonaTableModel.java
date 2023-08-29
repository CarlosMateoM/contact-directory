package com.software.elector.view.model;

import com.software.elector.model.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PersonaTableModel extends AbstractTableModel {

    private List<Persona> listaPersonas;
    private final String COLUMN_NAMES[];

    public PersonaTableModel() {
        listaPersonas = new ArrayList<>();
        this.COLUMN_NAMES = new String[]{"Nombres", "Apellidos", "Cedula", "Telefono", "Direccion", "Barrio", "Comuna", "Ciudad"};
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public int getRowCount() {
        return listaPersonas.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona persona = listaPersonas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return String.format(
                        "%s %s",
                        persona.getPrimerNombre(),
                        persona.getSegundoNombre()
                );

            case 1:
                return String.format(
                        "%s %s",
                        persona.getPrimerApellido(),
                        persona.getSegundoApellido()
                );
            case 2:
                return persona.getCedula();
            case 3:
                return persona.getTelefono();
            case 4:
                return String.format(
                        "Calle %s Carrera %s Nro %s Sobre %s",
                        persona.getDireccion().getCalle(),
                        persona.getDireccion().getCarrera(),
                        persona.getDireccion().getNumero(),
                        persona.getDireccion().getSobre()
                );
            case 5:return persona.getDireccion().getBarrio().getNombre();
            case 6: return persona.getDireccion().getBarrio().getComuna().getNombre();
            case 7: return persona.getDireccion().getBarrio().getComuna().getCiudad().getNombre();

        }
        return persona;
    }

}
