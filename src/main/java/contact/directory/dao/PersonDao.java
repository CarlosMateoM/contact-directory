package contact.directory.dao;

import contact.directory.model.Person;

/**
 *
 * @author C.Mateo
 */
public interface PersonDao extends GenericDao<Person, Integer> {

    boolean isPhoneInUse(String phone);
    boolean isIdentificationInUse(String identification);
}
