/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTUbicacion;
import com.tprog.logica.interfaces.ICtrlProductos;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author marccio
 */
public class ModificacionUbicacion extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReservasCliente
     * @param idCliente
     * @param padre
     */
    public ModificacionUbicacion(ModificacionServicio padre, DefaultMutableTreeNode arbolCiudades, ICtrlProductos ctrlProductos) {
        this.padre = padre;
        this.ctrlProductos = ctrlProductos;
        this.arbolCiudades = arbolCiudades;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolCiudadesOrigenInterfaz = new javax.swing.JTree(arbolCiudades);
        jScrollPane2 = new javax.swing.JScrollPane();
        arbolCiudadesDestinoInterfaz = new javax.swing.JTree(arbolCiudades);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonConfirmar = new javax.swing.JButton();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(690, 435));
        setVisible(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, -1));

        arbolCiudadesOrigenInterfaz.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                arbolCiudadesOrigenInterfazValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(arbolCiudadesOrigenInterfaz);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 200, 210));

        arbolCiudadesDestinoInterfaz.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                arbolCiudadesDestinoInterfazValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(arbolCiudadesDestinoInterfaz);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 200, 210));

        jLabel1.setText("Seleccione un nuevo origen");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel2.setText("Seleccione un nuevo destino");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        jLabel3.setText("<html>Las ciudades seleccionadas son las ubicaciones actuales del servicio</html>");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        botonConfirmar.setText("Confirmar cambios");
        botonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(botonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        arbolCiudades.removeAllChildren();
        this.dispose();
        padre.setVisible(true);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        /*
        descripcionInterfaz.setText(servicio.getDescripcion());
        precioInterfaz.setText(Float.toString(servicio.getPrecio()));
        */        
    }//GEN-LAST:event_formComponentShown

    private void arbolCiudadesOrigenInterfazValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_arbolCiudadesOrigenInterfazValueChanged
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) arbolCiudadesOrigenInterfaz.getLastSelectedPathComponent();
        if (nodo != null) {
            System.out.println("Seleccionaste " + nodo.toString());
        }
    }//GEN-LAST:event_arbolCiudadesOrigenInterfazValueChanged

    private void arbolCiudadesDestinoInterfazValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_arbolCiudadesDestinoInterfazValueChanged
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) arbolCiudadesOrigenInterfaz.getLastSelectedPathComponent();
        if (nodo != null) {
            System.out.println("Seleccionaste " + nodo.toString());
        }
    }//GEN-LAST:event_arbolCiudadesDestinoInterfazValueChanged

    private void botonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarActionPerformed
        //construir DTUbicacion's en base a la hoja seleccionada y al padre
        //origen
        DefaultMutableTreeNode nodoOrigen = (DefaultMutableTreeNode) arbolCiudadesOrigenInterfaz.getLastSelectedPathComponent();
        DefaultMutableTreeNode nodoDestino = (DefaultMutableTreeNode) arbolCiudadesDestinoInterfaz.getLastSelectedPathComponent();
        if (nodoOrigen != null && nodoDestino != null && nodoOrigen.isLeaf() && nodoDestino.isLeaf()) {
            DTUbicacion dtOrigen = new DTUbicacion(nodoOrigen.toString(), nodoOrigen.getParent().toString());
            DTUbicacion dtDestino = new DTUbicacion(nodoDestino.toString(), nodoDestino.getParent().toString());
            ctrlProductos.cambiarOrigen(dtOrigen);
            ctrlProductos.cambiarDestino(dtDestino);
            JOptionPane.showMessageDialog(this, "Cambio realizado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } else
            JOptionPane.showMessageDialog(this, "Por favor seleccione ciudades validas", "Seleccion invalida", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonConfirmarActionPerformed

    
    
    
    DefaultMutableTreeNode arbolCiudades;
    ICtrlProductos ctrlProductos;
    ModificacionServicio padre;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolCiudadesDestinoInterfaz;
    private javax.swing.JTree arbolCiudadesOrigenInterfaz;
    private javax.swing.JButton botonConfirmar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
