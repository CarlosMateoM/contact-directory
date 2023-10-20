package contact.directory.dao;

/**
 *
 * @author C.Mateo
 */
public class JdbcDaoFactory implements FactoryDao {
    
    private final CityDao cityDao;
    private final CommuneDao communeDao;
    private final NeighborhoodDao neighborhoodDao;
    private final PersonDao personDao;
    private final AddressDao addressDao;

    public JdbcDaoFactory(
            CityDao cityDao, 
            CommuneDao communeDao, 
            NeighborhoodDao neighborhoodDao, 
            PersonDao personDao,
            AddressDao addressDao
    ) {
        this.cityDao = cityDao;
        this.communeDao = communeDao;
        this.neighborhoodDao = neighborhoodDao;
        this.personDao = personDao;
        this.addressDao = addressDao;
    }
    
    
    @Override
    public CityDao getCityDao() {
        return cityDao;
    }

    @Override
    public NeighborhoodDao getNeighborhoodDao() {
        return neighborhoodDao;
    }

    @Override
    public CommuneDao getCommuneDao() {
        return communeDao;
    }

    @Override
    public AddressDao getAddressDao() {
        return addressDao;
    }

    @Override
    public PersonDao getPersonDao() {
        return personDao;
    }
    
}
