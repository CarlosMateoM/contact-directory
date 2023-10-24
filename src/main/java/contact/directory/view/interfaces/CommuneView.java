
package contact.directory.view.interfaces;

import contact.directory.model.Commune;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author C.Mateo
 */
public interface CommuneView {
    
    public void addActionListener(ActionListener actionListener);
    public void loadCommuneInView(List<Commune> communes);
    public Commune getCommuneData();
    
}
