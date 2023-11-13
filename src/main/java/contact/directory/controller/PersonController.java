package contact.directory.controller;

import contact.directory.view.interfaces.PersonView;
import contact.directory.model.Person;
import contact.directory.service.PersonService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author C.Mateo
 */
public class PersonController implements ActionListener {

    private final Map<String, PersonView> viewRegistry;
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
        viewRegistry = new HashMap<>();
    }

    public void suscribeView(String viewId, PersonView personView) {
        this.viewRegistry.put(viewId, personView);
        loadPeopleAndUpdateView(personView);
    }

    public void loadPeopleAndUpdateView(PersonView personView) {
        personView.loadPeopleInView(personService.getAll());
    }

    public void loadPeopleAndUpdateViews() {
        for (String viewId : viewRegistry.keySet()) {
            PersonView personView = viewRegistry.get(viewId);
            loadPeopleAndUpdateView(personView);
        }
    }
    
    public void updateViewAfterDeletePerson(PersonView personView){
        String key = personView.getSearchTextPerson();
        if(key.isEmpty()){
            loadPeopleAndUpdateView(personView);
        } else {
            personView.loadPeopleInView(personService.getByKey(key));
        }
    }

    public void savePerson(PersonView personView) {
        Person person = personView.getPersonData();
        personService.save(person);
        loadPeopleAndUpdateViews();
    }

    public void deletePerson(PersonView personView) {
        Person person = personView.getPersonData();
        if(person != null){
            System.out.println(person.getId());
            personService.delete(person.getId());
            updateViewAfterDeletePerson(personView);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String[] parts = e.getActionCommand().split("_");
        String command = parts[1];
        PersonView view = viewRegistry.get(parts[0]);

        switch (command) {
            case "save":
                savePerson(view);
                break;
            case "delete":
                deletePerson(view);
                break;
        }
    }
}
