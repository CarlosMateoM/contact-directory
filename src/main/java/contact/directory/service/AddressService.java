package contact.directory.service;

import contact.directory.model.Address;
import java.util.List;
import contact.directory.dao.AddressDao;

/**
 *
 * @author C.Mateo
 */
public class AddressService implements GenericService<Address, Integer>{
    
    private final AddressDao addressDao;

    public AddressService(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
    
    @Override
    public Address getById(Integer id) {
        return addressDao.getById(id);
    }

    @Override
    public List<Address> getAll() {
        return addressDao.getAll();
    }

    @Override
    public List<Address> getByKey(String key) {
        return addressDao.getByKey(key);
    }

    @Override
    public int save(Address t) {
        return addressDao.save(t);
    }

    @Override
    public void update(Address t) {
        addressDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        addressDao.delete(id);
    }
    
}
