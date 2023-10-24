package contact.directory;

import com.formdev.flatlaf.FlatLightLaf;
import contact.directory.config.AppConfig;
import contact.directory.controller.NeighborhoodController;
import contact.directory.controller.CityController;
import contact.directory.controller.CommuneController;
import contact.directory.controller.PersonController;
import contact.directory.controller.SearchPersonController;
import contact.directory.exception.DatabaseAccessException;
import contact.directory.service.NeighborhoodService;
import contact.directory.service.CityService;
import contact.directory.service.CommuneService;
import contact.directory.service.PersonService;
import contact.directory.view.MainFrame;

/**
 *
 * @author C.Mateo
 */
public class ContactDirectory {

    public static void main(String[] args) {

        try {

            FlatLightLaf.setup();
            
            MainFrame mainFrame = new MainFrame();

            NeighborhoodService neighborhoodService = AppConfig.createBarrioService();
            CommuneService communeService = AppConfig.createComunaService();
            CityService cityService = AppConfig.createCiudadService();
            PersonService personService = AppConfig.createPersonaService();
            
            CityController cityController = new CityController(cityService);
            CommuneController communeController = new CommuneController(communeService);
            PersonController personController = new PersonController(personService);
            SearchPersonController searchPersonController = new SearchPersonController(personService);
            NeighborhoodController neighborhoodController = new NeighborhoodController(neighborhoodService);
            
            personController.suscribeView("view1", mainFrame.getPersonPanel());
            personController.suscribeView("view2", mainFrame.getPersonForm());
            searchPersonController.suscribeView(mainFrame.getPersonPanel().getSearchPeopleTxt(), mainFrame.getPersonPanel());
            cityController.suscribeView("view2", mainFrame.getPersonForm());
            communeController.suscribeView("view2", mainFrame.getPersonForm());
            neighborhoodController.suscribeView("view2", mainFrame.getPersonForm());
            
            mainFrame.getPersonPanel().addKeyStrokeListener(searchPersonController);
            mainFrame.getPersonForm().addActionListener(communeController);
            mainFrame.getPersonForm().addActionListener(cityController);
            mainFrame.getPersonForm().addActionListener(personController);
            mainFrame.getPersonForm().addActionListener(neighborhoodController);
            mainFrame.getPersonPanel().addActionListener(personController);
            mainFrame.getUbicacionPanel().getCiudadForm().setCiudadController(cityController);
            mainFrame.getUbicacionPanel().getBarrioForm().setBarrioController(neighborhoodController);
            
            java.awt.EventQueue.invokeLater(() -> {
                mainFrame.setVisible(true);
            });

        } catch (DatabaseAccessException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}
