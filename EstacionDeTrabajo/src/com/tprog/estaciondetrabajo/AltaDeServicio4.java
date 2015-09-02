/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.interfaces.Fabrica;
import com.tprog.logica.interfaces.ICtrlProductos;
import java.awt.BorderLayout;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author marccio.silva
 */
public class AltaDeServicio4 extends javax.swing.JInternalFrame {
    private final AltaDeServicio3 padre;

    /**
     * Creates new form VerInformacionDeCliente
     * @param padre
     * @param ctrlProductos
     */
    public AltaDeServicio4(AltaDeServicio3 padre, ICtrlProductos ctrlProductos) {
        setTitle("Alta de Servicio");
        initComponents();
        this.padre = padre;
        this.ctrlProductos = ctrlProductos;
    }
    
    void cargarDatos() {
        Fabrica f = Fabrica.getInstance();
        ctrlProductos = f.getICtrlProductos();
        DefaultMutableTreeNode raiz = ctrlProductos.listarCategorias();
        arbolCategorias.removeAll();
        arbolCategorias.setModel(new DefaultTreeModel(raiz));
        arbolCategorias.updateUI();
        /*
        Set<String> setCategorias = ctrlProductos.listarCategorias();
        //construyo un vector con la informacion a mostrar, porque
        //el comboBox solo funciona con Vector o List
        if (setCategorias != null) {
            for (String categoria : setCategorias) {
                listaCategorias.add(categoria);
            }
        }
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabInfo = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        buttonSeleccionar = new javax.swing.JButton();
        buttonAtras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolCategorias = new javax.swing.JTree();

        setBorder(null);
        setToolTipText("");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Seleccione la Categoría \"hoja\" a la que pertenece el nuevo Servicio.");

        buttonSeleccionar.setText("Seleccionar");
        buttonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSeleccionarActionPerformed(evt);
            }
        });

        buttonAtras.setText("Atras");
        buttonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtrasActionPerformed(evt);
            }
        });

        arbolCategorias.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                arbolCategoriasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(arbolCategorias);

        javax.swing.GroupLayout tabInfoLayout = new javax.swing.GroupLayout(tabInfo);
        tabInfo.setLayout(tabInfoLayout);
        tabInfoLayout.setHorizontalGroup(
            tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabInfoLayout.createSequentialGroup()
                .addGap(0, 200, Short.MAX_VALUE)
                .addGroup(tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabInfoLayout.createSequentialGroup()
                        .addComponent(botonSalir)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabInfoLayout.createSequentialGroup()
                        .addComponent(buttonAtras)
                        .addGap(96, 96, 96)
                        .addComponent(buttonSeleccionar)
                        .addGap(264, 264, 264))))
            .addGroup(tabInfoLayout.createSequentialGroup()
                .addGroup(tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabInfoLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabInfoLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabInfoLayout.setVerticalGroup(
            tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabInfoLayout.createSequentialGroup()
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSeleccionar)
                    .addComponent(buttonAtras))
                .addGap(35, 35, 35)
                .addComponent(botonSalir)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        label.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(tabInfo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        //pido de nuevo los datos en caso de que hayan cambiado
        cargarDatos();
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        reservas = null;
    }//GEN-LAST:event_formComponentHidden

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void buttonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSeleccionarActionPerformed
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) arbolCategorias.getLastSelectedPathComponent();
            String categoria = null;
            if (nodo != null)
             categoria = nodo.toString();
            boolean okCategoria = ctrlProductos.agregarCategoria(categoria);
            AltaDeServicio5 as5 = new AltaDeServicio5(this, ctrlProductos);
            getContentPane().add(as5, BorderLayout.CENTER);
            as5.setBounds(10, 10, 100, 100);
            this.setVisible(false);
            as5.setVisible(true);
            getParent().add(as5);  
    }//GEN-LAST:event_buttonSeleccionarActionPerformed

    private void buttonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtrasActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.padre.setVisible(true);
    }//GEN-LAST:event_buttonAtrasActionPerformed

    private void arbolCategoriasValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_arbolCategoriasValueChanged
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) arbolCategorias.getLastSelectedPathComponent();
        if (nodo != null) {
            System.out.println("Seleccionaste " + nodo.toString());
        }
    }//GEN-LAST:event_arbolCategoriasValueChanged
    
    Set<DTMinServicio> listaServicios;
    Set<DTMinReserva> reservas;
    ICtrlProductos ctrlProductos;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolCategorias;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton buttonAtras;
    private javax.swing.JButton buttonSeleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JPanel tabInfo;
    // End of variables declaration//GEN-END:variables
}