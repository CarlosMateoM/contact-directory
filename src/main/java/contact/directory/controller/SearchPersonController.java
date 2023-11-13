package contact.directory.controller;

import contact.directory.service.PersonService;
import contact.directory.view.interfaces.KeyReleasedListener;
import contact.directory.view.interfaces.PersonView;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author C.Mateo
 */
public class SearchPersonController implements KeyReleasedListener {

    private final Map<Component, PersonView> viewRegistry;
    private final PersonService personService;

    public SearchPersonController(PersonService personService) {
        this.personService = personService;
        viewRegistry = new HashMap<>();
    }

    public void suscribeView(Component component, PersonView peopleView) {
        this.viewRegistry.put(component, peopleView);
    }

    public void loadPeopleAndUpdateView(PersonView peopleView) {
        peopleView.loadPeopleInView(personService.getAll());
    }
    
    public void searchPeople(PersonView peopleView) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                String key = peopleView.getSearchTextPerson();
                if (!key.isEmpty()) {
                    peopleView.loadPeopleInView(personService.getByKey(key));
                } else {
                    loadPeopleAndUpdateView(peopleView);
                }

            }
        };
        
        thread.start();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Component sourceComponent = (Component) e.getSource();
        PersonView view = viewRegistry.get(sourceComponent);
        if (view != null) {
            searchPeople(view);
        }
    }

}
