package contact.directory.config;

import contact.directory.dao.impl.JdbcDaoCity;
import contact.directory.dao.impl.JdbcDaoNeighborhood;
import contact.directory.dao.impl.JdbcDaoCommune;
import contact.directory.dao.impl.JdbcDaoAddress;
import contact.directory.dao.impl.JdbcDaoPerson;
import contact.directory.service.NeighborhoodService;
import contact.directory.service.CityService;
import contact.directory.service.CommuneService;
import contact.directory.service.AddressService;
import contact.directory.service.PersonService;
import contact.directory.util.DatabaseUtil;
import contact.directory.dao.NeighborhoodDao;
import contact.directory.dao.CityDao;
import contact.directory.dao.CommuneDao;
import contact.directory.dao.AddressDao;
import contact.directory.dao.PersonDao;

/**
 *
 * @author C.Mateo
 */
public class AppConfig {
    
    //Métodos para crear la instancia de los DAO's
    
    public static CityDao createCiudadDao(){
        return new JdbcDaoCity(DatabaseUtil.getDataSource());
    }
   
    public static NeighborhoodDao createBarrioDao(){
        return new JdbcDaoNeighborhood(DatabaseUtil.getDataSource());
    }
    
    public static AddressDao createDireccionDao(){
        return new JdbcDaoAddress(DatabaseUtil.getDataSource());
    }
    
    public static CommuneDao createComunaDao(){
        return new JdbcDaoCommune(DatabaseUtil.getDataSource());
    }
    
    public static PersonDao createPersonaDao(){
        return new JdbcDaoPerson(DatabaseUtil.getDataSource());
    }
    
    // Métodos para crear la instancia de los servicios
    
    public static CityService createCiudadService() {
        return new CityService(createCiudadDao());
    }
    
    public static NeighborhoodService createBarrioService(){
        return new NeighborhoodService(createBarrioDao());
    }
    
    public static AddressService createDireccionService(){
        return new AddressService(createDireccionDao());
    }
    
    public static CommuneService createComunaService(){
        return new CommuneService(createComunaDao());
    }

    public static PersonService createPersonaService() {
        return new PersonService(createPersonaDao());
    }
}
