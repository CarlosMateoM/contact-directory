package com.software.elector.service;

import com.software.elector.dao.DireccionDao;
import com.software.elector.model.Direccion;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public class DireccionService implements GenericService<Direccion, Integer>{
    
    private final DireccionDao direccionDao;

    public DireccionService(DireccionDao direccionDao) {
        this.direccionDao = direccionDao;
    }
    
    @Override
    public Direccion getById(Integer id) {
        return direccionDao.getById(id);
    }

    @Override
    public List<Direccion> getAll() {
        return direccionDao.getAll();
    }

    @Override
    public List<Direccion> getByKey(String key) {
        return direccionDao.getByKey(key);
    }

    @Override
    public int save(Direccion t) {
        return direccionDao.save(t);
    }

    @Override
    public void update(Direccion t) {
        direccionDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        direccionDao.delete(id);
    }
    
}
