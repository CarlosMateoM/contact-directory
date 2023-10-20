package contact.directory;

import com.formdev.flatlaf.FlatLightLaf;
import contact.directory.config.AppConfig;
import contact.directory.controller.NeighborhoodController;
import contact.directory.controller.CityController;
import contact.directory.controller.CommuneController;
import contact.directory.controller.PersonController;
import contact.directory.exception.DatabaseAccessException;
import contact.directory.service.NeighborhoodService;
import contact.directory.service.CityService;
import contact.directory.service.CommuneService;
import contact.directory.service.AddressService;
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

            NeighborhoodService barrioService = AppConfig.createBarrioService();
            CommuneService comunaService = AppConfig.createComunaService();
            CityService ciudadService = AppConfig.createCiudadService();
            PersonService personaService = AppConfig.createPersonaService();
            AddressService direccionService = AppConfig.createDireccionService();

            CommuneController comunaController = new CommuneController(
                    mainFrame.getUbicacionPanel().getComunaForm(),
                    comunaService
            );

            CityController ciudadController = new CityController(
                    mainFrame.getUbicacionPanel().getCiudadForm(),
                    ciudadService
            );

            NeighborhoodController barrioController = new NeighborhoodController(
                    mainFrame.getUbicacionPanel().getBarrioForm(),
                    barrioService
            );
            
            barrioController.init();

            PersonController votanteController = new PersonController(
                    mainFrame.getPersonForm(),
                    mainFrame.getVotantePanel(),
                    barrioService,
                    comunaService,
                    ciudadService,
                    personaService,
                    direccionService
            );

            mainFrame.getPersonForm().setVotanteController(votanteController);
            mainFrame.getVotantePanel().setVotanteController(votanteController);

            mainFrame.getUbicacionPanel().getCiudadForm().setCiudadController(ciudadController);
            mainFrame.getUbicacionPanel().getComunaForm().setComunacontroller(comunaController);
            mainFrame.getUbicacionPanel().getBarrioForm().setBarrioController(barrioController);
            
            votanteController.initView();
            ciudadController.initView();
            
            java.awt.EventQueue.invokeLater(() -> {
                mainFrame.setVisible(true);
            });

        } catch (DatabaseAccessException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}
