package contact.directory.controller;

import contact.directory.view.interfaces.CityView;
import contact.directory.enums.ValidationMessage;
import contact.directory.exception.ValidationException;
import contact.directory.model.City;
import contact.directory.service.CityService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author C.Mateo
 */
public class CityController implements ActionListener {

    private final CityService cityService;
    private Map<String, CityView> viewRegistry;

    public CityController(CityService cityService) {
        this.cityService = cityService;
        viewRegistry = new HashMap<>();
    }

    public void suscribeView(String viewId, CityView cityView) {
        this.viewRegistry.put(viewId, cityView);
        loadCitiesAndUpdateView(cityView);
    }

    public void loadCitiesAndUpdateView(CityView cityView) {
        cityView.loadCitiesInView(cityService.getAll());
    }

    public String saveCity(City city) {
        try {

            if (!city.isValid()) {
                throw new ValidationException(ValidationMessage.CAMPOS_OBLIGATORIOS.getMessage());
            }

            cityService.save(city);

        } catch (ValidationException e) {
            return e.getMessage();
        }
        return ValidationMessage.CIUDAD_GUARDADA.getMessage();
    }

    public void searchCity(String key) {
        // view.updateCitiesList(cityService.getByKey(key));
    }

    public String deleteCity(City city) {
        cityService.delete(city.getId());
        return ValidationMessage.CIUDAD_ELIMINADA.getMessage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        System.out.println(e.getActionCommand() + "\n" + e.getSource());

        String[] parts = e.getActionCommand().split("_");

        String command = parts[1];

        CityView view = viewRegistry.get(parts[0]);

        switch (command) {
            case "Guardar":
                System.out.println("guardar desde vista");
                break;
            case "eliminar":
                System.out.println("vista preciono eliminar");
                break;
            default:
                System.out.println("algo paso " + command);
        }
    }

}
