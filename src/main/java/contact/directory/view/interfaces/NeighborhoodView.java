package contact.directory.view.interfaces;

import contact.directory.model.Neighborhood;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public interface NeighborhoodView {
    public void loadNeighborhoodByCommune(List<Neighborhood> neighborhoods);
    public Neighborhood getNeighborhoodData();
    public String getSearchTxtNeigborhood();
}
