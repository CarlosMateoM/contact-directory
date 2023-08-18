package com.software.elector.controller;

import com.software.elector.enums.ValidationMessage;
import com.software.elector.exception.ValidationException;
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
    
    public String guaradarComuna(Comuna comuna){
        
        try {
            if(!comuna.isValid()){
                throw new ValidationException(ValidationMessage.CAMPOS_OBLIGATORIOS.getMessage());
            }
            
            if(comuna.getCiudad() == null){
               throw new ValidationException(ValidationMessage.CIUDAD_INVALIDA.getMessage());
            }
            
            comunaService.save(comuna);
            view.cargarComunas(comunaService.getComunasByCiudad(comuna.getCiudad().getId()));
            
        } catch (ValidationException e) {
            return e.getMessage();
        }
        return ValidationMessage.COMUNA_GUARDADA.getMessage();
    }
    
    public void getComunasByCiudad(int id) {
        List<Comuna> comunas = comunaService.getComunasByCiudad(id);
        view.cargarComunas(comunas);
    }
    
    
}
