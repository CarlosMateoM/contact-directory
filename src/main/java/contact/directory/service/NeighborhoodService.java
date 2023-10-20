package contact.directory.service;

import contact.directory.model.Neighborhood;
import contact.directory.model.Commune;
import java.util.List;
import contact.directory.dao.NeighborhoodDao;

/**
 *
 * @author C.Mateo
 */
public class NeighborhoodService implements GenericService<Neighborhood, Integer>{

    private final NeighborhoodDao barrioDao;

    public NeighborhoodService(NeighborhoodDao barrioDao) {
        this.barrioDao = barrioDao;
    }
    
    @Override
    public Neighborhood getById(Integer id) {
       return barrioDao.getById(id);
    }

    @Override
    public List<Neighborhood> getAll() {
       return barrioDao.getAll();
    }

    @Override
    public List<Neighborhood> getByKey(String key) {
        return barrioDao.getByKey(key);
    }

    @Override
    public int save(Neighborhood t) {
        return barrioDao.save(t);
    }

    @Override
    public void update(Neighborhood t) {
        barrioDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        barrioDao.delete(id);
    }
    
    public List<Neighborhood> getNeighborhoodByCommune(int id) {
       return barrioDao.getNeighborhoodsByCommune(id);
    }
    
    public List<Neighborhood> searchNeighborhoodByCommune(Commune comuna, String key) {
       return barrioDao.searchNeighborhoodByCommune(comuna, key);
    }
    
}
