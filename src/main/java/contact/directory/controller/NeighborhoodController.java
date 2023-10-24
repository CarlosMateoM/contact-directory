package contact.directory.controller;

import contact.directory.view.interfaces.NeighborhoodView;
import contact.directory.enums.ValidationMessage;
import contact.directory.exception.ValidationException;
import contact.directory.model.Neighborhood;
import contact.directory.model.Commune;
import contact.directory.service.NeighborhoodService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author C.Mateo
 */
public class NeighborhoodController implements ActionListener {

    private final NeighborhoodService neighborhoodService;
    private final Map<String, NeighborhoodView> viewRegistry;

    public NeighborhoodController(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
        viewRegistry = new HashMap<>();
    }
    
    public void suscribeView(String viewId, NeighborhoodView neighborhoodView) {
        viewRegistry.put(viewId, neighborhoodView);
        loadNeighborhoodByCommune(neighborhoodView, neighborhoodView.getNeighborhoodData().getCommune());
    }

    public void loadNeighborhoodByCommune(NeighborhoodView neighborhoodView, Commune commune) {
        if(commune == null){
            neighborhoodView.loadNeighborhoodByCommune(new ArrayList<>());
        } else {
            neighborhoodView.loadNeighborhoodByCommune(neighborhoodService.getNeighborhoodByCommune(commune.getId()));
        }
    }

    public String searchNeighborhoodByCommune(NeighborhoodView neighborhoodView, Commune commune) {
        try {
            
            String key = neighborhoodView.getSearchTxtNeigborhood();

            if (commune == null) {
                throw new ValidationException(ValidationMessage.COMUNA_INVALIDA.getMessage());
            }
            
            neighborhoodView.loadNeighborhoodByCommune(neighborhoodService.searchNeighborhoodByCommune(commune, key));
            
        } catch (ValidationException e) {
            return e.getMessage();
        }

        return ValidationMessage.OPERACION_EXITOSA.getMessage();
    }

    public void saveNeightborhood() {
        /*
        try {

            Neighborhood neighborhood = view.getBarrio();

            if (neighborhood.getCommune() == null) {
                throw new ValidationException(ValidationMessage.COMUNA_INVALIDA.getMessage());
            }

            if (neighborhood.getName().isEmpty()) {
                throw new ValidationException(ValidationMessage.CAMPOS_OBLIGATORIOS.getMessage());
            }

            neighborhoodService.save(neighborhood);

            view.cargarBarrios(
                    neighborhoodService.getNeighborhoodByCommune(
                            neighborhood.getCommune().getId()
                    )
            );

            view.limpiarCampos();

        } catch (ValidationException e) {

            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage()
            );

        }

        JOptionPane.showMessageDialog(
                null,
                ValidationMessage.BARRIO_GUARDADO.getMessage()
        );
         */
    }

    public String deleteNeighborhood(Neighborhood neighborhood) {
        neighborhoodService.delete(neighborhood.getId());
        int id = neighborhood.getCommune().getId();
        //view.cargarBarrios(neighborhoodService.getNeighborhoodByCommune(id));
        return ValidationMessage.BARRIO_ELIMINADO.getMessage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         
        String[] parts = e.getActionCommand().split("_");

        String command = parts[1];
        
        NeighborhoodView neighborhoodView = viewRegistry.get(parts[0]);

        switch (command) {
            case "Guardar":
                saveNeightborhood();
                break;
            case "searchNeighborhood":
                
            case "communeComboBox":
                loadNeighborhoodByCommune(neighborhoodView, neighborhoodView.getNeighborhoodData().getCommune());
                break;
        }
    }

}
