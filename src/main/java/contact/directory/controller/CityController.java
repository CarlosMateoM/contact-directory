package contact.directory.controller;

import contact.directory.enums.ValidationMessage;
import contact.directory.exception.ValidationException;
import contact.directory.model.City;
import contact.directory.service.CityService;
import contact.directory.view.form.CityForm;

/**
 *
 * @author C.Mateo
 */
public class CityController {

    private final CityForm view;
    private final CityService cityService;

    public CityController(CityForm view, CityService cityService) {
        this.view = view;
        this.cityService = cityService;
    }

    public void initView() {
        loadCitiesAndUpdateView();
    }

    public void loadCitiesAndUpdateView() {
        view.updateCitiesList(cityService.getAll());
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
        view.updateCitiesList(cityService.getByKey(key));
    }
    
    public String deleteCity(City city){
        cityService.delete(city.getId());
        return ValidationMessage.CIUDAD_ELIMINADA.getMessage();
    }

}
