package contact.directory.dao;

import contact.directory.model.City;
import contact.directory.model.Commune;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public interface CommuneDao extends GenericDao<Commune, Integer> {
    List<Commune> getCommunesByCity(int id);
    List<Commune> searchCommunesByCity(City ciudad, String key);
}
