package contact.directory.service;

import contact.directory.enums.ValidationMessage;
import contact.directory.exception.ServiceException;
import contact.directory.exception.ValidationException;
import contact.directory.model.Person;
import java.util.List;
import contact.directory.dao.PersonDao;

/**
 *
 * @author C.Mateo
 */
public class PersonService implements GenericService<Person, Integer> {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Person getById(Integer id) {
        return personDao.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public List<Person> getByKey(String key) {
        try {
            return personDao.getByKey(key);
        } catch (Exception e) {
            throw new ServiceException("Error al acceder al servicio de persona.\n" + e.getMessage(), e);
            
        }
    }

    @Override
    public int save(Person t) {

        if (personDao.isIdentificationInUse(t.getIdentification())) {
            throw new ValidationException(ValidationMessage.CEDULA_EN_USO.getMessage());
        }
        if (personDao.isPhoneInUse(t.getPhone())) {
            throw new ValidationException(ValidationMessage.TELEFONO_EN_USO.getMessage());
        }

        return personDao.save(t);
    }

    @Override
    public void update(Person t) {
        personDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        personDao.delete(id);
    }

}
