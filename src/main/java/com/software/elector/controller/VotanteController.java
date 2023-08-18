package com.software.elector.controller;

import com.software.elector.enums.ValidationMessage;
import com.software.elector.exception.ValidationException;
import com.software.elector.model.Barrio;
import com.software.elector.model.Ciudad;
import com.software.elector.model.Comuna;
import com.software.elector.model.Persona;
import com.software.elector.view.form.VotanteForm;
import com.software.elector.service.BarrioService;
import com.software.elector.service.CiudadService;
import com.software.elector.service.ComunaService;
import com.software.elector.service.DireccionService;
import com.software.elector.service.PersonaService;
import com.software.elector.view.VotantePanel;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public class VotanteController {

    private final VotanteForm form;
    private final VotantePanel view;
    private final BarrioService barrioService;
    private final ComunaService comunaService;
    private final CiudadService ciudadService;
    private final PersonaService personaService;
    private final DireccionService direccionService;

    public VotanteController(
            VotanteForm form,
            VotantePanel view,
            BarrioService barrioService,
            ComunaService comunaService,
            CiudadService ciudadService,
            PersonaService personaService,
            DireccionService direccionService
    ) {
        this.form = form;
        this.view = view;
        this.barrioService = barrioService;
        this.comunaService = comunaService;
        this.ciudadService = ciudadService;
        this.personaService = personaService;
        this.direccionService = direccionService;
    }

    public void initView() {
        cargarVotantes();
        form.cargarCiudades(ciudadService.getAll());
    }

    public void cargarVotantes() {
        view.cargarVontantes(personaService.getAll());
    }

    public void onCiudadSelected(Ciudad ciudad) {
        List<Comuna> comunas = comunaService.getComunasByCiudad(ciudad.getId());
        form.cargarComunas(comunas);
    }

    public void onComunaSelected(Comuna comuna) {
        List<Barrio> barrios = barrioService.getBarriosByComuna(comuna.getId());
        form.cargarBarrios(barrios);
    }

    public String guardarVotante(Persona persona) {
        try {
            int id = direccionService.save(persona.getDireccion());
            persona.getDireccion().setId(id);
            if(!persona.isValid() || !persona.getDireccion().isValid()){
                throw new ValidationException(ValidationMessage.CAMPOS_OBLIGATORIOS.getMessage());
            }
            personaService.save(persona);
            view.cargarVontantes(personaService.getAll());
        } catch (ValidationException e) {
            return e.getMessage();
        }
        return ValidationMessage.VOTANTE_GUARDADO.getMessage();
    }

    public void buscarPorClave(String key) {
        view.cargarVontantes(personaService.getByKey(key));
    }
}
