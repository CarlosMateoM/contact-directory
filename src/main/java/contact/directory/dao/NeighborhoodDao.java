package contact.directory.dao;

import contact.directory.model.Neighborhood;
import contact.directory.model.Commune;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public interface NeighborhoodDao extends GenericDao<Neighborhood, Integer>{

    List<Neighborhood> getNeighborhoodsByCommune(int id);
    List<Neighborhood> searchNeighborhoodByCommune(Commune comuna, String key);
}
