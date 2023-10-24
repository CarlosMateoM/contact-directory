
package contact.directory.view.interfaces;

import contact.directory.model.City;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public interface CityView {
    
    public void loadCitiesInView(List<City> cities);
    public City getCityData();
}
