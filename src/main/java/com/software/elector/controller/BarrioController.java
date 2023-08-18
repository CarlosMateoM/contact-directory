package com.software.elector.controller;

import com.software.elector.enums.ValidationMessage;
import com.software.elector.exception.ValidationException;
import com.software.elector.model.Barrio;
import com.software.elector.model.Comuna;
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
    
    public String eliminarBarrio(Barrio barrio) {
        barrioService.delete(barrio.getId());
        int id = barrio.getComuna().getId();
        view.cargarBarrios(barrioService.getBarriosByComuna(id));
        return ValidationMessage.BARRIO_ELIMINADO.getMessage();
    }

    public String getBarriosByComuna(Comuna comuna) {
        try {

            if (comuna == null) {
                throw new ValidationException(ValidationMessage.COMUNA_INVALIDA.getMessage());
            }
            view.cargarBarrios(barrioService.getBarriosByComuna(comuna.getId()));

        } catch (ValidationException e) {
            return e.getMessage();
        }
        return ValidationMessage.OPERACION_EXITOSA.getMessage();
    }

    public String getBarriosByComuna(Comuna comuna, String key) {
        try {

            if (comuna == null) {
                throw new ValidationException(ValidationMessage.COMUNA_INVALIDA.getMessage());
            }

            view.cargarBarrios(barrioService.getBarriosByComuna(comuna, key));

        } catch (ValidationException e) {
            return e.getMessage();
        }

        return ValidationMessage.OPERACION_EXITOSA.getMessage();
    }

    public String guardarBarrio(Barrio barrio) {
        try {

            if (barrio.getComuna() == null) {
                throw new ValidationException(ValidationMessage.COMUNA_INVALIDA.getMessage());
            }

            if (barrio.getNombre().isEmpty()) {
                throw new ValidationException(ValidationMessage.CAMPOS_OBLIGATORIOS.getMessage());
            }

            barrioService.save(barrio);
            view.cargarBarrios(barrioService.getBarriosByComuna(barrio.getComuna().getId()));

        } catch (ValidationException e) {
            return e.getMessage();
        }
        return ValidationMessage.BARRIO_GUARDADO.getMessage();
    }

    
}
