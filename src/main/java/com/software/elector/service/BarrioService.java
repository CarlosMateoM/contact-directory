package com.software.elector.service;

import com.software.elector.dao.BarrioDao;
import com.software.elector.model.Barrio;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public class BarrioService implements GenericService<Barrio, Integer>{

    private final BarrioDao barrioDao;

    public BarrioService(BarrioDao barrioDao) {
        this.barrioDao = barrioDao;
    }
    
    @Override
    public Barrio getById(Integer id) {
       return barrioDao.getById(id);
    }

    @Override
    public List<Barrio> getAll() {
       return barrioDao.getAll();
    }

    @Override
    public List<Barrio> getByKey(String key) {
        return barrioDao.getByKey(key);
    }

    @Override
    public int save(Barrio t) {
        return barrioDao.save(t);
    }

    @Override
    public void update(Barrio t) {
        barrioDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        barrioDao.delete(id);
    }
    
    public List<Barrio> getBarrioByComuna(int id) {
       return barrioDao.getBarrioByComuna(id);
    }
    
}
