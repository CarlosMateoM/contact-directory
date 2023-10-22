package contact.directory.controller;

import contact.directory.enums.ValidationMessage;
import contact.directory.exception.DatabaseAccessException;
import contact.directory.exception.ServiceException;
import contact.directory.exception.ValidationException;
import contact.directory.model.Person;
import contact.directory.view.form.PersonForm;
import contact.directory.service.PersonService;
import contact.directory.view.PersonPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author C.Mateo
 */
public class PersonController implements ActionListener {

    private final PersonForm form;
    private final PersonPanel view;
    private final PersonService personService;

    public PersonController(
            PersonForm form,
            PersonPanel view,
            PersonService personaService
    ) {
        this.form = form;
        this.view = view;
        this.personService = personaService;
    }

    public void initView() {
        
        loadPeopleAndUpdateView();
        //form.cargarCiudades(ciudadService.getAll());
    }

    public String loadPeopleAndUpdateView() {
        try {
            view.cargarVontantes(personService.getAll());
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
            personService.save(person);
            loadPeopleAndUpdateView();
        } catch (DatabaseAccessException | ValidationException e) {
            return e.getMessage();
        }
        return ValidationMessage.VOTANTE_GUARDADO.getMessage();
    }

    public String searchPeople(String key) {
        try {
            view.cargarVontantes(personService.getByKey(key));
        } catch (ServiceException e) {
            return e.getMessage();
        }
        return ValidationMessage.OPERACION_EXITOSA.getMessage();
    }

    /*
    public void onCommuneSelected(Commune commune) {
        List<Neighborhood> barrios = barrioService.getNeighborhoodByCommune(commune.getId());
        form.cargarBarrios(barrios);
    }
    
    public void onCitySelected(City city) {
        List<Commune> comunas = comunaService.getCommunesByCity(city.getId());
        form.cargarComunas(comunas);
    }
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "save": if(true);
                break;
            case "unsaved" : if(true);
                break;
        }

    }
}
    