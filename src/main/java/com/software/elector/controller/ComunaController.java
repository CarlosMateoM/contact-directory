package com.software.elector.controller;

import com.software.elector.enums.ValidationMessage;
import com.software.elector.exception.ValidationException;
import com.software.elector.model.Ciudad;
import com.software.elector.model.Comuna;
import com.software.elector.service.ComunaService;
import com.software.elector.view.form.ComunaForm;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public class ComunaController {

    private final ComunaForm view;
    private final ComunaService comunaService;

    public ComunaController(ComunaForm view, ComunaService comunaService) {
        this.view = view;
        this.comunaService = comunaService;
    }
    
    public String eliminarComuna(Comuna comuna){
        comunaService.delete(comuna.getId());
        int id = comuna.getCiudad().getId();
        view.cargarComunas(comunaService.getComunasByCiudad(id));
        return ValidationMessage.COMUNA_ELIMINADA.getMessage();
    }

    public String guaradarComuna(Comuna comuna) {

        try {
            if (!comuna.isValid()) {
                throw new ValidationException(ValidationMessage.CAMPOS_OBLIGATORIOS.getMessage());
            }

            if (comuna.getCiudad() == null) {
                throw new ValidationException(ValidationMessage.CIUDAD_INVALIDA.getMessage());
            }

            comunaService.save(comuna);
            view.cargarComunas(comunaService.getComunasByCiudad(comuna.getCiudad().getId()));

        } catch (ValidationException e) {
            return e.getMessage();
        }
        return ValidationMessage.COMUNA_GUARDADA.getMessage();
    }

    public String getComunasByCiudad(Ciudad ciudad) {
        try {

            if (ciudad == null) {
                throw new ValidationException(ValidationMessage.CIUDAD_INVALIDA.getMessage());
            }
            
            List<Comuna> comunas = comunaService.getComunasByCiudad(ciudad.getId());
            view.cargarComunas(comunas);
            
        } catch (ValidationException e) {
            return e.getMessage();
        }

        return ValidationMessage.OPERACION_EXITOSA.getMessage();
    }

    public String getComunaByCiudad(Ciudad ciudad, String key) {
        try {

            if (ciudad == null) {
                throw new ValidationException(ValidationMessage.CIUDAD_INVALIDA.getMessage());
            }

            List<Comuna> comunas = comunaService.getComunasByCiudad(ciudad, key);
            view.cargarComunas(comunas);

        } catch (ValidationException e) {
            return e.getMessage();
        }

        return ValidationMessage.OPERACION_EXITOSA.getMessage();
    }

}
