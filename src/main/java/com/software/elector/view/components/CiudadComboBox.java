package com.software.elector.view.components;

import com.software.elector.model.Ciudad;

/**
 *
 * @author C.Mateo
 */
public class CiudadComboBox extends ComboBox<Ciudad>{

    public CiudadComboBox() {
        super();
        init();
    }
    
    private void init(){
        setTitle("Ciudad: ");
    }
    
}
