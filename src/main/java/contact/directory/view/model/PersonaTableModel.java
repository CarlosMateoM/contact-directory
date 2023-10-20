package contact.directory.view.model;

import contact.directory.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PersonaTableModel extends AbstractTableModel {

    private List<Person> listaPersonas;
    private final String COLUMN_NAMES[];

    public PersonaTableModel() {
        listaPersonas = new ArrayList<>();
        this.COLUMN_NAMES = new String[]{"Nombres", "Apellidos", "Cedula", "Telefono", "Direccion", "Barrio", "Comuna", "Ciudad"};
    }

    public List<Person> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Person> listaPersonas) {
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
        Person persona = listaPersonas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return String.format(
                        "%s %s",
                        persona.getFirstName(),
                        persona.getMiddleName()
                );

            case 1:
                return String.format(
                        "%s %s",
                        persona.getLastName(),
                        persona.getSecondLastName()
                );
            case 2:
                return persona.getIdentification();
            case 3:
                return persona.getPhone();
            case 4:
                return String.format(
                        "Calle %s Carrera %s Nro %s Sobre %s",
                        persona.getAddress().getStreet(),
                        persona.getAddress().getAvenue(),
                        persona.getAddress().getNumber(),
                        persona.getAddress().getOn()
                );
            case 5:return persona.getAddress().getNeighborhood().getName();
            case 6: return persona.getAddress().getNeighborhood().getCommune().getName();
            case 7: return persona.getAddress().getNeighborhood().getCommune().getCity().getName();

        }
        return persona;
    }

}
