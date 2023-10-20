package contact.directory.view.components;

import contact.directory.model.Neighborhood;

/**
 *
 * @author C.Mateo
 */
public class BarrioComboBox extends ComboBox<Neighborhood>{

    public BarrioComboBox() {
        super();
        init();
    }

    private void init() {
        setTitle("Barrio: ");
    }
   
    
}
