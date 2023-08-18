package com.software.elector.controller;

import com.software.elector.enums.ValidationMessage;
import com.software.elector.exception.ValidationException;
import com.software.elector.model.Barrio;
import com.software.elector.service.BarrioService;
import com.software.elector.view.form.BarrioForm;

/**
 *
 * @author C.Mateo
 */
public class BarrioController {
    
    private final BarrioForm view;
    private final BarrioService barrioService;

    public BarrioController(BarrioForm view, BarrioService barrioService) {
        this.view = view;
        this.barrioService = barrioService;
    }
    
    public String guardarBarrio(Barrio barrio){
        try {
            
        } catch (ValidationException e) {
            return e.getMessage();
        }
        return ValidationMessage.BARRIO_GUARDADO.getMessage();
    }

    public void getBarriosByComuna(int id) {
        view.cargarBarrios(barrioService.getBarrioByComuna(id));
    }
}
