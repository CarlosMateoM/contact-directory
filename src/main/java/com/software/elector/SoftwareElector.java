package com.software.elector;

import com.formdev.flatlaf.FlatLightLaf;
import com.software.elector.config.AppConfig;
import com.software.elector.controller.BarrioController;
import com.software.elector.controller.CiudadController;
import com.software.elector.controller.ComunaController;
import com.software.elector.controller.VotanteController;
import com.software.elector.service.BarrioService;
import com.software.elector.service.CiudadService;
import com.software.elector.service.ComunaService;
import com.software.elector.service.DireccionService;
import com.software.elector.service.PersonaService;
import com.software.elector.view.MainFrame;

/**
 *
 * @author C.Mateo
 */
public class SoftwareElector {

    public static void main(String[] args) {
        
        FlatLightLaf.setup();
        
        MainFrame mainFrame = new MainFrame();
        
        BarrioService barrioService = AppConfig.createBarrioService();
        ComunaService comunaService = AppConfig.createComunaService();
        CiudadService ciudadService = AppConfig.createCiudadService();
        PersonaService personaService = AppConfig.createPersonaService();
        DireccionService direccionService = AppConfig.createDireccionService();
        
        ComunaController comunaController = new ComunaController(
                mainFrame.getUbicacionPanel().getComunaForm(),
                comunaService
        );
        
        CiudadController ciudadController = new CiudadController(
                mainFrame.getUbicacionPanel().getCiudadForm(),
                ciudadService
        );
        
        BarrioController barrioController = new BarrioController(
                mainFrame.getUbicacionPanel().getBarrioForm(),
                barrioService
        );
        
        VotanteController votanteController = new VotanteController(
                mainFrame.getVotanteForm(),
                mainFrame.getVotantePanel(),
                barrioService,
                comunaService,
                ciudadService,
                personaService,
                direccionService
        );
        
        mainFrame.getVotanteForm().setVotanteController(votanteController);
        mainFrame.getVotantePanel().setVotanteController(votanteController);
        
        mainFrame.getUbicacionPanel().getCiudadForm().setCiudadController(ciudadController);
        mainFrame.getUbicacionPanel().getComunaForm().setComunacontroller(comunaController);
        mainFrame.getUbicacionPanel().getBarrioForm().setBarrioController(barrioController);
        
        java.awt.EventQueue.invokeLater(() -> {
            mainFrame.setVisible(true);
        });
        
        votanteController.initView();
        ciudadController.initView();
   
     
        
        
    }
}
