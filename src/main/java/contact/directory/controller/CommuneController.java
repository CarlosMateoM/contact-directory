package contact.directory.controller;

import contact.directory.enums.ValidationMessage;
import contact.directory.exception.ValidationException;
import contact.directory.model.City;
import contact.directory.model.Commune;
import contact.directory.service.CommuneService;
import contact.directory.view.form.CommuneForm;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public class CommuneController {

    private final CommuneForm view;
    private final CommuneService communeService;

    public CommuneController(CommuneForm view, CommuneService communeService) {
        this.view = view;
        this.communeService = communeService;
    }

    public void loadCommunesByCityAndUpdateView(City city) {
        view.cargarComunas(communeService.getCommunesByCity(city.getId()));
    }

    public String saveCommune(Commune commune) {

        try {
            if (!commune.isValid()) {
                throw new ValidationException(ValidationMessage.CAMPOS_OBLIGATORIOS.getMessage());
            }

            if (commune.getCity() == null) {
                throw new ValidationException(ValidationMessage.CIUDAD_INVALIDA.getMessage());
            }

            communeService.save(commune);
            loadCommunesByCityAndUpdateView(commune.getCity());

        } catch (ValidationException e) {
            return e.getMessage();
        }
        return ValidationMessage.COMUNA_GUARDADA.getMessage();
    }

    public String getCommunesByCity(City city) {
        try {

            if (city == null) {
                throw new ValidationException(ValidationMessage.CIUDAD_INVALIDA.getMessage());
            }

            loadCommunesByCityAndUpdateView(city);

        } catch (ValidationException e) {
            return e.getMessage();
        }

        return ValidationMessage.OPERACION_EXITOSA.getMessage();
    }

    public String searchCommunesByCity(City city, String key) {
        try {

            if (city == null) {
                throw new ValidationException(ValidationMessage.CIUDAD_INVALIDA.getMessage());
            }

            List<Commune> communes = communeService.searchCommunesByCity(city, key);
            view.cargarComunas(communes);

        } catch (ValidationException e) {
            return e.getMessage();
        }

        return ValidationMessage.OPERACION_EXITOSA.getMessage();
    }

    public String deleteCommune(Commune comuna) {
        communeService.delete(comuna.getId());
        int id = comuna.getCity().getId();
        view.cargarComunas(communeService.getCommunesByCity(id));
        return ValidationMessage.COMUNA_ELIMINADA.getMessage();
    }

}
