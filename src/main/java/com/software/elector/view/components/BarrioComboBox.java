package com.software.elector.view.components;

import com.software.elector.model.Barrio;

/**
 *
 * @author C.Mateo
 */
public class BarrioComboBox extends ComboBox<Barrio>{

    public BarrioComboBox() {
        super();
        init();
    }

    private void init() {
        setTitle("Barrio: ");
    }
   
    
}
