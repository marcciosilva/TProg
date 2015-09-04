/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTServicio;
import com.tprog.logica.interfaces.ICtrlProductos;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author marccio
 */
public class RealizarReserva4 extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReservasCliente
     * @param padre
     */
    public RealizarReserva4(RealizarReserva2 padre) {
        this.padre = padre;
        setTitle("Realizar Reserva");
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

        listaServiciosInterfaz = new javax.swing.JComboBox(listaServicios);
        panelUsuario = new javax.swing.JScrollPane();
        detalleServicio = new javax.swing.JTextArea();
        botonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buttonVolver = new javax.swing.JButton();
        buttonAgregar = new javax.swing.JButton();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(690, 435));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaServiciosInterfaz.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                listaServiciosInterfazInterfazComponentAdded(evt);
            }
        });
        listaServiciosInterfaz.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaServiciosInterfazItemStateChanged(evt);
            }
        });
        listaServiciosInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaServiciosInterfazInterfazActionPerformed(evt);
            }
        });
        getContentPane().add(listaServiciosInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 418, -1));

        detalleServicio.setEditable(false);
        detalleServicio.setColumns(20);
        detalleServicio.setLineWrap(true);
        detalleServicio.setRows(5);
        detalleServicio.setWrapStyleWord(true);
        panelUsuario.setViewportView(detalleServicio);

        getContentPane().add(panelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 269, 128));

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, -1, -1));

        jLabel1.setText("<html>Seleccione alguna promoción para ver su información</html>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        buttonVolver.setText("Volver");
        buttonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolverActionPerformed(evt);
            }
        });
        getContentPane().add(buttonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        buttonAgregar.setText("Agregar");
        getContentPane().add(buttonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaServiciosInterfazInterfazComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listaServiciosInterfazInterfazComponentAdded

    }//GEN-LAST:event_listaServiciosInterfazInterfazComponentAdded

    private void listaServiciosInterfazItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaServiciosInterfazItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listaServiciosInterfazItemStateChanged

    private void listaServiciosInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaServiciosInterfazInterfazActionPerformed
        String servicio = (String) listaServiciosInterfaz.getSelectedItem();
        if (servicio != null) {
            //buscar servicio
            DTMinServicio dt = null;
            Iterator it = servicios.iterator();
            boolean found = false;
            while (it.hasNext() && !found) {
                DTMinServicio tmp = (DTMinServicio) it.next();
                if (tmp.getIdServicio().equals(servicio))
                    dt = tmp; //es imposible que dt sea null al final del loop
            }
            ctrlProductos.seleccionarServicio(dt);
            DTServicio dtServicio = ctrlProductos.infoServicio();
            //imagenes
            detalleServicio.setVisible(true);
            detalleServicio.setText(dt.toString()); 
        }
    }//GEN-LAST:event_listaServiciosInterfazInterfazActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    @Override
    public void dispose() {
        super.dispose();
        padre.dispose();
    }
    
    private void buttonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolverActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.padre.setVisible(true);
    }//GEN-LAST:event_buttonVolverActionPerformed

    ICtrlProductos ctrlProductos;
    Set<DTMinServicio> servicios;
    RealizarReserva2 padre;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton buttonAgregar;
    private javax.swing.JButton buttonVolver;
    private javax.swing.JTextArea detalleServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox listaServiciosInterfaz;
    private Vector<String> listaServicios = new Vector<>();
    private javax.swing.JScrollPane panelUsuario;
    // End of variables declaration//GEN-END:variables
}
