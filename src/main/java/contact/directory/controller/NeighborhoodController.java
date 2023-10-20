package contact.directory.controller;

import contact.directory.enums.ValidationMessage;
import contact.directory.exception.ValidationException;
import contact.directory.model.Neighborhood;
import contact.directory.model.Commune;
import contact.directory.service.NeighborhoodService;
import contact.directory.view.form.NeighborhoodForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author C.Mateo
 */
public class NeighborhoodController implements ActionListener {

    private final NeighborhoodForm view;
    private final NeighborhoodService neighborhoodService;

    public NeighborhoodController(NeighborhoodForm view, NeighborhoodService neighborhoodService) {
        this.view = view;
        this.neighborhoodService = neighborhoodService;
    }

    public void init() {
        view.setActionListener(this);
    }

    public String getNeighborhoodByCommune(Commune commune) {
        try {

            if (commune == null) {
                throw new ValidationException(ValidationMessage.COMUNA_INVALIDA.getMessage());
            }
            view.cargarBarrios(neighborhoodService.getNeighborhoodByCommune(commune.getId()));

        } catch (ValidationException e) {
            return e.getMessage();
        }
        return ValidationMessage.OPERACION_EXITOSA.getMessage();
    }

    public String searchNeighborhoodByCommune(Commune commune, String key) {
        try {

            if (commune == null) {
                throw new ValidationException(ValidationMessage.COMUNA_INVALIDA.getMessage());
            }

            view.cargarBarrios(neighborhoodService.searchNeighborhoodByCommune(commune, key));

        } catch (ValidationException e) {
            return e.getMessage();
        }

        return ValidationMessage.OPERACION_EXITOSA.getMessage();
    }

    public void saveNeightborhood() {
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
    }

    public String deleteNeighborhood(Neighborhood neighborhood) {
        neighborhoodService.delete(neighborhood.getId());
        int id = neighborhood.getCommune().getId();
        view.cargarBarrios(neighborhoodService.getNeighborhoodByCommune(id));
        return ValidationMessage.BARRIO_ELIMINADO.getMessage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Guardar")) {
            saveNeightborhood();
        }
    }

}
