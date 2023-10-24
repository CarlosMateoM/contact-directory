package contact.directory.view.interfaces;

import contact.directory.model.Person;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public interface PersonView {
    
    public Person getPersonData();
    public Person getPersonToDelete();
    public String getSearchTextPerson();
    public void loadPeopleInView(List<Person> people);
    
    
}
