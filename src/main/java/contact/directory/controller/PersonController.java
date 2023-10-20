package contact.directory.controller;

import contact.directory.enums.ValidationMessage;
import contact.directory.exception.DatabaseAccessException;
import contact.directory.exception.ServiceException;
import contact.directory.exception.ValidationException;
import contact.directory.model.Neighborhood;
import contact.directory.model.City;
import contact.directory.model.Commune;
import contact.directory.model.Person;
import contact.directory.view.form.PersonForm;
import contact.directory.service.NeighborhoodService;
import contact.directory.service.CityService;
import contact.directory.service.CommuneService;
import contact.directory.service.AddressService;
import contact.directory.service.PersonService;
import contact.directory.view.PersonPanel;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public class PersonController {

    private final PersonForm form;
    private final PersonPanel view;
    private final NeighborhoodService barrioService;
    private final CommuneService comunaService;
    private final CityService ciudadService;
    private final PersonService personaService;
    private final AddressService direccionService;

    public PersonController(
            PersonForm form,
            PersonPanel view,
            NeighborhoodService barrioService,
            CommuneService comunaService,
            CityService ciudadService,
            PersonService personaService,
            AddressService direccionService
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
        loadPeopleAndUpdateView();
        form.cargarCiudades(ciudadService.getAll());
    }

    public String loadPeopleAndUpdateView() {
        try {
            view.cargarVontantes(personaService.getAll());
        } catch (DatabaseAccessException e) {
            return e.getMessage();
        }
        return ValidationMessage.OPERACION_EXITOSA.getMessage();
    }

    public String savePerson(Person person) {
        try {
            if (!person.isValid() || !person.getAddress().isValid()) {
                throw new ValidationException(ValidationMessage.CAMPOS_OBLIGATORIOS.getMessage());
            }
            personaService.save(person);
            loadPeopleAndUpdateView();
        } catch (DatabaseAccessException | ValidationException e) {
            return e.getMessage();
        }
        return ValidationMessage.VOTANTE_GUARDADO.getMessage();
    }

    public String searchPeople(String key) {
        try {
            view.cargarVontantes(personaService.getByKey(key));
        } catch (ServiceException e) {
            return e.getMessage();
        }
        return ValidationMessage.OPERACION_EXITOSA.getMessage();
    }
    
    public void onCommuneSelected(Commune commune) {
        List<Neighborhood> barrios = barrioService.getNeighborhoodByCommune(commune.getId());
        form.cargarBarrios(barrios);
    }
    
    public void onCitySelected(City city) {
        List<Commune> comunas = comunaService.getCommunesByCity(city.getId());
        form.cargarComunas(comunas);
    }
}
