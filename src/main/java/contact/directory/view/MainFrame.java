
package contact.directory.view;

import contact.directory.view.form.AddressForm;
import contact.directory.view.form.PersonForm;

/**
 *
 * @author C.Mateo
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form TestFrame
     */
    public MainFrame() {
        initComponents();
        init();
    }
    
    private void init(){
        votantePanel.setVotanteForm(votanteForm);
    }

    public PersonForm getPersonForm() {
        return votanteForm;
    }
    
    public PersonPanel getVotantePanel(){
        return votantePanel;
    }

    public AddressForm getUbicacionPanel() {
        return ubicacionPanel;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        votanteForm = new contact.directory.view.form.PersonForm();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        votantePanel = new contact.directory.view.PersonPanel();
        ubicacionPanel = new contact.directory.view.form.AddressForm();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Software Elector");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jTabbedPane1.addTab("VOTANTES", votantePanel);
        jTabbedPane1.addTab("UBICACION", ubicacionPanel);

        getContentPane().add(jTabbedPane1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    private contact.directory.view.form.AddressForm ubicacionPanel;
    private contact.directory.view.form.PersonForm votanteForm;
    private contact.directory.view.PersonPanel votantePanel;
    // End of variables declaration//GEN-END:variables
}
