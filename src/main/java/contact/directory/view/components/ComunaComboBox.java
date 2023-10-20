package contact.directory.view.components;

import contact.directory.model.Commune;

/**
 *
 * @author C.Mateo
 */
public class ComunaComboBox extends ComboBox<Commune>{

    public ComunaComboBox() {
        super();
        init();
    }

    private void init() {
        setTitle("Comuna: ");
    }
    
    
}
