package com.software.elector.service;

import com.software.elector.dao.PersonaDao;
import com.software.elector.enums.ValidationMessage;
import com.software.elector.exception.ValidationException;
import com.software.elector.model.Persona;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public class PersonaService implements GenericService<Persona, Integer> {

    private final PersonaDao personaDao;

    public PersonaService(PersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    @Override
    public Persona getById(Integer id) {
        return personaDao.getById(id);
    }

    @Override
    public List<Persona> getAll() {
        return personaDao.getAll();
    }

    @Override
    public List<Persona> getByKey(String key) {
        return personaDao.getByKey(key);
    }

    @Override
    public int save(Persona t) {
        
        if (personaDao.isCedulaInUse(t.getCedula())) {
            throw new ValidationException(ValidationMessage.CEDULA_EN_USO.getMessage());
        }
        if (personaDao.isTelefonoInUse(t.getTelefono())) {
            throw new ValidationException(ValidationMessage.TELEFONO_EN_USO.getMessage());
        }
        
        return personaDao.save(t);
    }

    @Override
    public void update(Persona t) {
        personaDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        personaDao.delete(id);
    }

}
