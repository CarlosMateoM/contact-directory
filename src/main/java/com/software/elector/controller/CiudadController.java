package com.software.elector.controller;

import com.software.elector.enums.ValidationMessage;
import com.software.elector.exception.ValidationException;
import com.software.elector.model.Ciudad;
import com.software.elector.service.CiudadService;
import com.software.elector.view.form.CiudadForm;

/**
 *
 * @author C.Mateo
 */
public class CiudadController {

    private final CiudadForm view;
    private final CiudadService ciudadService;

    public CiudadController(CiudadForm view, CiudadService ciudadService) {
        this.view = view;
        this.ciudadService = ciudadService;
    }

    public void initView() {
        cargarCiudades();
    }

    public void cargarCiudades() {
        view.cargarCiudades(ciudadService.getAll());
    }

    public String guardarCiudad(Ciudad ciudad) {
        try {
            if (!ciudad.isValid()) {
                throw new ValidationException(ValidationMessage.CAMPOS_OBLIGATORIOS.getMessage());
            }
            ciudadService.save(ciudad);
        } catch (ValidationException e) {
            return e.getMessage();
        }
        return ValidationMessage.CIUDAD_GUARDADA.getMessage();
    }

    public void buscarCiudad(String key) {
        view.cargarCiudades(ciudadService.getByKey(key));
    }

}
