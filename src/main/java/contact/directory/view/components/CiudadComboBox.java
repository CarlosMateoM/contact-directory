package contact.directory.view.components;

import contact.directory.model.City;

/**
 *
 * @author C.Mateo
 */
public class CiudadComboBox extends ComboBox<City>{

    public CiudadComboBox() {
        super();
        init();
    }
    
    private void init(){
        setTitle("Ciudad: ");
    }
    
}
