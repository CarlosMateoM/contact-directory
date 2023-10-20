package contact.directory.dao;


/**
 *
 * @author C.Mateo
 */
public interface FactoryDao {
    
    CityDao getCityDao();
    NeighborhoodDao getNeighborhoodDao();
    CommuneDao getCommuneDao();
    AddressDao getAddressDao();
    PersonDao getPersonDao();
}
