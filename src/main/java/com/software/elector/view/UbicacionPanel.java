package com.software.elector.view;

import com.software.elector.view.form.BarrioForm;
import com.software.elector.view.form.CiudadForm;
import com.software.elector.view.form.ComunaForm;

/**
 *
 * @author C.Mateo
 */
public class UbicacionPanel extends javax.swing.JPanel {

    /**
     * Creates new form UbicacionPanel
     */
    public UbicacionPanel() {
        initComponents();
        init();
    }
    
    private void init(){
        ciudadForm.setComunaForm(comunaForm);
        comunaForm.setBarrioForm(barrioForm);
    }

    public CiudadForm getCiudadForm() {
        return ciudadForm;
    }
    
    public ComunaForm getComunaForm(){
        return comunaForm;
    }
    
    public BarrioForm getBarrioForm(){
        return barrioForm;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ciudadForm = new com.software.elector.view.form.CiudadForm();
        comunaForm = new com.software.elector.view.form.ComunaForm();
        barrioForm = new com.software.elector.view.form.BarrioForm();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(ciudadForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(comunaForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barrioForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barrioForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(comunaForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ciudadForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.software.elector.view.form.BarrioForm barrioForm;
    private com.software.elector.view.form.CiudadForm ciudadForm;
    private com.software.elector.view.form.ComunaForm comunaForm;
    // End of variables declaration//GEN-END:variables
}
