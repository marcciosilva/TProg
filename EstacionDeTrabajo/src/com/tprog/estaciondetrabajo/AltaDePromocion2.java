/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.interfaces.ICtrlProductos;
import com.tprog.logica.interfaces.ICtrlUsuarios;
import java.util.Set;
import javax.swing.JOptionPane;

public class AltaDePromocion2 extends javax.swing.JInternalFrame {

    private AltaDePromocion padre;
    private ICtrlProductos ctrlProductos;
    private ICtrlUsuarios ctrlUsuarios;
    private String proveedor;
    Set<DTMinServicio> servicios;

    /**
     * Creates new form AltaDeServicio3
     *
     * @param padre
     * @param ctrlProductos
     */
    public AltaDePromocion2(AltaDePromocion padre, Set<DTMinServicio> servicios, ICtrlUsuarios ctrlUsuarios, ICtrlProductos ctrlProductos, String proveedor) {
        this.proveedor = proveedor;
        this.padre = padre;
        this.ctrlProductos = ctrlProductos;
        this.ctrlUsuarios = ctrlUsuarios;
        this.servicios = servicios;
        initComponents();
		getRootPane().setDefaultButton(buttonSiguiente);
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
        buttonSiguiente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPaneNombrePromocion = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        buttonAtras = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Alta de Promoción - Nombre");
        setPreferredSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ingrese el nombre de la nueva Promoción y haga click en \"Siguiente\".");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, 20));

        buttonSiguiente.setText("Siguiente >");
        buttonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 120, -1));

        jScrollPane1.setViewportView(textPaneNombrePromocion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 161, 199, -1));

        jLabel2.setText("Nombre de la Promoción");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 128, -1, -1));

        buttonAtras.setText("< Atras");
        buttonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void dispose() {
        padre.dispose();
        super.dispose();
    }

    private boolean isWhiteSpace(String s) {
        return (s.matches("^\\s*$") || s.matches("^\\s.*"));
    }

    private void buttonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSiguienteActionPerformed
        String nombrePromocion = textPaneNombrePromocion.getText();
        String error = "";
        boolean ok1 = !isWhiteSpace(nombrePromocion);
        boolean ok2 = ((ok1) && (ctrlProductos.idPromocionDisponible(nombrePromocion)));
        if (ok2) {
            DTMinPromocion dtmPromocion = new DTMinPromocion(proveedor, nombrePromocion);
            ctrlProductos.seleccionarPromocion(dtmPromocion);
            AltaDePromocion3 ap3 = new AltaDePromocion3(this, servicios, ctrlUsuarios, ctrlProductos, proveedor);
            this.setVisible(false);
            getParent().add(ap3);
            ap3.setLocation(this.getLocation());
            ap3.setVisible(true);
        } else {
            if (!ok1) {
                error = "Por favor ingrese un nombre antes de avanzar.";
            } else if (!ok2) {
                error = "Ya existe una Promoción con ese nombre.";
            }
            JOptionPane.showMessageDialog(this, error, "Alta de Promoción", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buttonSiguienteActionPerformed

    private void buttonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtrasActionPerformed
        this.setVisible(false);
        this.padre.setVisible(true);
    }//GEN-LAST:event_buttonAtrasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAtras;
    private javax.swing.JButton buttonSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane textPaneNombrePromocion;
    // End of variables declaration//GEN-END:variables
}
