package com.software.elector.view.components;

import com.software.elector.model.Comuna;

/**
 *
 * @author C.Mateo
 */
public class ComunaComboBox extends ComboBox<Comuna>{

    public ComunaComboBox() {
        super();
        init();
    }

    private void init() {
        setTitle("Comuna: ");
    }
    
    
}
