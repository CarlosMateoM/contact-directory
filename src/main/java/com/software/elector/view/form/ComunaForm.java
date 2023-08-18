package com.software.elector.view.form;

import com.software.elector.controller.ComunaController;
import com.software.elector.enums.ValidationMessage;
import com.software.elector.exception.ValidationException;
import com.software.elector.model.Ciudad;
import com.software.elector.model.Comuna;
import com.software.elector.view.model.ComunaTableModel;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author C.Mateo
 */
public class ComunaForm extends javax.swing.JPanel {

    private Ciudad ciudad;
    private BarrioForm barrioForm;
    private ComunaTableModel tableComunas;
    private ComunaController comunaController;

    /**
     * Creates new form ComunaForm
     */
    public ComunaForm() {
        initComponents();
        init();
    }

    private void init() {
        tableComunas = new ComunaTableModel();
        jTableComunas.setModel(tableComunas);

        ListSelectionModel selectionModel = jTableComunas.getSelectionModel();
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = jTableComunas.getSelectedRow();
                if (selectedRow >= 0) {
                    try {
                        Comuna comuna = tableComunas.getListaComunas().get(selectedRow);
                        barrioForm.setComuna(comuna);
                    } catch (ValidationException ex) {
                        javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
        ciudadNameLb.setText(ciudad.getNombre());
        comunaController.getComunasByCiudad(ciudad);
    }

    public void setBarrioForm(BarrioForm barrioForm) {
        this.barrioForm = barrioForm;
    }

    public void setComunacontroller(ComunaController comunaController) {
        this.comunaController = comunaController;
    }

    public void cargarComunas(List<Comuna> listaComunas) {
        tableComunas.setListaComunas(listaComunas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableComunas = new javax.swing.JTable();
        buscarTxt = new javax.swing.JTextField();
        nombreTxt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ciudadNameLb = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTableComunas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nombre"
            }
        ));
        jScrollPane1.setViewportView(jTableComunas);

        buscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarTxtKeyReleased(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Ciudad Cargada: ");

        ciudadNameLb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-search-20.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buscarTxt)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel2)))
                        .addGap(1, 1, 1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(nombreTxt)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton2))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ciudadNameLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(ciudadNameLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String nombre = nombreTxt.getText();
        Comuna comuna = new Comuna(-1, nombre, ciudad);
        String response = comunaController.guaradarComuna(comuna);
        if (response.equals(ValidationMessage.COMUNA_GUARDADA.getMessage())) {
            nombreTxt.setText("");
        }
        javax.swing.JOptionPane.showMessageDialog(null, response);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buscarTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarTxtKeyReleased
        // TODO add your handling code here:
        String response;
        String key = buscarTxt.getText();
        
        if (!key.isEmpty()) {
            response = comunaController.getComunaByCiudad(ciudad, key);
        } else {
            response = comunaController.getComunasByCiudad(ciudad);
        }
        
        if(!response.equals(ValidationMessage.OPERACION_EXITOSA.getMessage())){
            javax.swing.JOptionPane.showMessageDialog(null, response);
        }
    }//GEN-LAST:event_buscarTxtKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int index = jTableComunas.getSelectedRow();
        Comuna comuna = tableComunas.getListaComunas().get(index);
        String response = comunaController.eliminarComuna(comuna);
        javax.swing.JOptionPane.showMessageDialog(null, response);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JLabel ciudadNameLb;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableComunas;
    private javax.swing.JTextField nombreTxt;
    // End of variables declaration//GEN-END:variables

}
