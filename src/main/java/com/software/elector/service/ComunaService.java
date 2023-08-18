package com.software.elector.service;

import com.software.elector.dao.ComunaDao;
import com.software.elector.model.Ciudad;
import com.software.elector.model.Comuna;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public class ComunaService implements GenericService<Comuna, Integer>{

    
    private final ComunaDao comunaDao;
    
    public ComunaService(ComunaDao comunaDao) {
        this.comunaDao = comunaDao;
    }
    

    @Override
    public Comuna getById(Integer id) {
       return null;
    }

    @Override
    public List<Comuna> getAll() {
              return null;

    }

    @Override
    public List<Comuna> getByKey(String key) {
              return null;

    }

    @Override
    public int save(Comuna t) {
       return comunaDao.save(t);
    }

    @Override
    public void update(Comuna t) {
       
    }

    @Override
    public void delete(Integer id) {
       comunaDao.delete(id);
    }
    
    public List<Comuna> getComunasByCiudad(int id){
        return comunaDao.getComunasByCiudad(id);
    }
    
     public List<Comuna> getComunasByCiudad(Ciudad ciudad, String key){
        return comunaDao.getComunasByCiudad(ciudad, key);
    }
    
}
