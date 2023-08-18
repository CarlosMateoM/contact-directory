package com.software.elector.service;

import com.software.elector.dao.CiudadDao;
import com.software.elector.model.Ciudad;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public class CiudadService implements GenericService<Ciudad, Integer> {
    
    private final CiudadDao ciudadDao;

    public CiudadService(CiudadDao ciudadDao) {
        this.ciudadDao = ciudadDao;
    }
    
    @Override
    public Ciudad getById(Integer id) {
        return ciudadDao.getById(id);
    }

    @Override
    public List<Ciudad> getAll() {
        return ciudadDao.getAll();
    }

    @Override
    public List<Ciudad> getByKey(String key) {
        return ciudadDao.getByKey(key);
    }

    @Override
    public int save(Ciudad t) {
        return ciudadDao.save(t);
    }

    @Override
    public void update(Ciudad t) {
        ciudadDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        ciudadDao.delete(id);
    }
    
}
