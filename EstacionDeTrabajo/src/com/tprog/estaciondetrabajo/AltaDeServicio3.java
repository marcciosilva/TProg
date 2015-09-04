/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.interfaces.ICtrlProductos;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author User
 */
public class AltaDeServicio3 extends javax.swing.JInternalFrame {
    private AltaDeServicio2 padre;
    private ICtrlProductos ctrlProductos;
    private String proveedor;

    /**
     * Creates new form AltaDeServicio3
     * @param padre
     * @param ctrlProductos
     */
    public AltaDeServicio3(AltaDeServicio2 padre, ICtrlProductos ctrlProductos, String proveedor) {
        setTitle("Alta de Servicio");
        this.proveedor = proveedor;
        this.padre = padre;
        this.ctrlProductos = ctrlProductos;
        initComponents();
        BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
        for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
            basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
        }        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPaneNombreServicio = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        buttonSalir = new javax.swing.JButton();
        buttonAtras = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ingrese el nombre del nuevo Servicio y haga click en \"Siguiente\".");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, 20));

        buttonAceptar.setText("Siguiente >");
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 120, -1));

        jScrollPane1.setViewportView(textPaneNombreServicio);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 161, 199, -1));

        jLabel2.setText("Nombre del Servicio");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 128, -1, -1));

        buttonSalir.setText("Salir");
        buttonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, -1, -1));

        buttonAtras.setText("Atras");
        buttonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_buttonSalirActionPerformed

    @Override
    public void dispose() {
        super.dispose(); //To change body of generated methods, choose Tools | Templates.
        padre.dispose();
    }
    
    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        // TODO add your handling code here:
        String nombreServicio = textPaneNombreServicio.getText();
        String error = "";
        boolean ok1 = (!nombreServicio.isEmpty());   
        boolean ok2 = ((ok1) && (ctrlProductos.idServicioDisponible(nombreServicio)));
            if (ok2){
                DTMinServicio dtmServicio = new DTMinServicio(proveedor, nombreServicio);
                ctrlProductos.seleccionarServicio(dtmServicio);
                AltaDeServicio4 as4 = new AltaDeServicio4(this, ctrlProductos);
//                getContentPane().add(as4, BorderLayout.CENTER);
                as4.setBounds(10, 10, 100, 100);
                this.setVisible(false);
                as4.setVisible(true);
                getParent().add(as4); 
            }
            else {
                 if (!ok1) error = "Por favor ingrese el nombre del Servicio.";
                 else if(!ok2) error ="Ya existe un Servicio con ese nombre.";
                JOptionPane.showMessageDialog(this, "Error! ", "Alta de Servicio", JOptionPane.INFORMATION_MESSAGE); 
            }
    }//GEN-LAST:event_buttonAceptarActionPerformed

    private void buttonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtrasActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.padre.setVisible(true);
    }//GEN-LAST:event_buttonAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonAtras;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane textPaneNombreServicio;
    // End of variables declaration//GEN-END:variables
}
