package contact.directory.service;

import contact.directory.model.City;
import java.util.List;
import contact.directory.dao.CityDao;

/**
 *
 * @author C.Mateo
 */
public class CityService implements GenericService<City, Integer> {
    
    private final CityDao cityDao;

    public CityService(CityDao cityDao) {
        this.cityDao = cityDao;
    }
    
    @Override
    public City getById(Integer id) {
        return cityDao.getById(id);
    }

    @Override
    public List<City> getAll() {
        return cityDao.getAll();
    }

    @Override
    public List<City> getByKey(String key) {
        return cityDao.getByKey(key);
    }

    @Override
    public int save(City t) {
        return cityDao.save(t);
    }

    @Override
    public void update(City t) {
        cityDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        cityDao.delete(id);
    }
    
}
