package contact.directory.service;

import contact.directory.model.City;
import contact.directory.model.Commune;
import java.util.List;
import contact.directory.dao.CommuneDao;

/**
 *
 * @author C.Mateo
 */
public class CommuneService implements GenericService<Commune, Integer> {

    private final CommuneDao communeDao;

    public CommuneService(CommuneDao communeDao) {
        this.communeDao = communeDao;
    }

    @Override
    public Commune getById(Integer id) {
        return null;
    }

    @Override
    public List<Commune> getAll() {
        return null;

    }

    @Override
    public List<Commune> getByKey(String key) {
        return null;

    }

    @Override
    public int save(Commune t) {
        return communeDao.save(t);
    }

    @Override
    public void update(Commune t) {
        
    }

    @Override
    public void delete(Integer id) {
        communeDao.delete(id);
    }

    public List<Commune> getCommunesByCity(int id) {
        return communeDao.getCommunesByCity(id);
    }

    public List<Commune> searchCommunesByCity(City ciudad, String key) {
        return communeDao.searchCommunesByCity(ciudad, key);
    }

}
