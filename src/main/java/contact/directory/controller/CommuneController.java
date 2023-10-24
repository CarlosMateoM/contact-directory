package contact.directory.controller;

import contact.directory.view.interfaces.CommuneView;
import contact.directory.enums.ValidationMessage;
import contact.directory.exception.ValidationException;
import contact.directory.model.City;
import contact.directory.model.Commune;
import contact.directory.service.CommuneService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author C.Mateo
 */
public class CommuneController implements ActionListener {

    private final CommuneService communeService;
    private final Map<String, CommuneView> viewRegistry;

    public CommuneController(CommuneService communeService) {
        this.communeService = communeService;
        viewRegistry = new HashMap<>();
    }
    
     public void suscribeView(String viewId, CommuneView communeView) {
        viewRegistry.put(viewId, communeView);
        loadCommunesByCityAndUpdateView(communeView, communeView.getCommuneData().getCity());
    }

    public void loadCommunesByCityAndUpdateView(CommuneView communeView, City city) {
        communeView.loadCommuneInView(communeService.getCommunesByCity(city.getId()));
    }

    public String saveCommune(Commune commune, CommuneView communeView) {

        try {
            if (!commune.isValid()) {
                throw new ValidationException(ValidationMessage.CAMPOS_OBLIGATORIOS.getMessage());
            }

            if (commune.getCity() == null) {
                throw new ValidationException(ValidationMessage.CIUDAD_INVALIDA.getMessage());
            }

            communeService.save(commune);

            loadCommunesByCityAndUpdateView(communeView, commune.getCity());

        } catch (ValidationException e) {
            return e.getMessage();
        }
        return ValidationMessage.COMUNA_GUARDADA.getMessage();
    }

    public String getCommunesByCity(City city, CommuneView communeView) {
        try {

            if (city == null) {
                throw new ValidationException(ValidationMessage.CIUDAD_INVALIDA.getMessage());
            }

            loadCommunesByCityAndUpdateView(communeView, city);

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
            //view.cargarComunas(communes);

        } catch (ValidationException e) {
            return e.getMessage();
        }

        return ValidationMessage.OPERACION_EXITOSA.getMessage();
    }

    public String deleteCommune(Commune comuna) {
        communeService.delete(comuna.getId());
        //int id = comuna.getCity().getId();
        //view.cargarComunas(communeService.getCommunesByCity(id));
        return ValidationMessage.COMUNA_ELIMINADA.getMessage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String[] parts = e.getActionCommand().split("_");

        String command = parts[1];
        
        CommuneView communeView = viewRegistry.get(parts[0]);

        switch (command) {
            case "cityComboBox":
                loadCommunesByCityAndUpdateView(communeView, communeView.getCommuneData().getCity());
                break;
        }
    }

}
