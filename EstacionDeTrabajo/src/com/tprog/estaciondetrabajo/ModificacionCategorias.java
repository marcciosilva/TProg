/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.tprog.estaciondetrabajo;

import com.tprog.logica.interfaces.ICtrlProductos;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author marccio
 */
public class ModificacionCategorias extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form ReservasCliente
     * @param servicios
     * @param ctrlProductos
     * @param padre
     */
    public ModificacionCategorias(ModificacionServicio padre, ICtrlProductos ctrlProductos) {
        this.padre = padre;
        this.ctrlProductos = ctrlProductos;
        initComponents();
        //construyo lista para la interfaz usando el set
        categoriasServicio = ctrlProductos.listarCategoriasServicio();
        for (String s : categoriasServicio) {
            listaServicio.add(s);
        }
        DefaultMutableTreeNode categoriasSistema = ctrlProductos.listarCategorias();
        Enumeration en = categoriasSistema.depthFirstEnumeration();
        while (en.hasMoreElements()) {
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) en.nextElement();
            listaSistema.add(nodo.toString());
        }
        //disable dragging
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

        botonSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaServicioInterfaz = new javax.swing.JList(listaServicio);
        botonQuitar = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaSistemaInterfaz = new javax.swing.JList(listaSistema);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonConfirmar = new javax.swing.JButton();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(690, 435));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, -1, -1));

        jScrollPane1.setViewportView(listaServicioInterfaz);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 160, 210));

        botonQuitar.setText("->");
        botonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarActionPerformed(evt);
            }
        });
        getContentPane().add(botonQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        botonAgregar.setText("<-");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        jScrollPane2.setViewportView(listaSistemaInterfaz);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 160, 210));

        jLabel1.setText("Categorias del servicio");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jLabel2.setText("Categorias del sistema");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        botonConfirmar.setText("Confirmar cambios");
        botonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(botonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        listaSistema.clear();
        listaServicio.clear();
        listaServicioInterfaz.updateUI();
        listaSistemaInterfaz.updateUI();
        this.dispose();
        padre.setVisible(true);
    }//GEN-LAST:event_botonSalirActionPerformed
    
    private void botonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarActionPerformed
        //quitar
        List selected = listaServicioInterfaz.getSelectedValuesList();
        Iterator it1 = selected.iterator();
        while (it1.hasNext()){
            String actual = (String) it1.next();
            Iterator it2 = listaServicio.iterator();
            while (it2.hasNext()) {
                if (it2.next().equals(actual)) {
                    it2.remove();
                }
            }
            //listaSistema.add(actual); no es necesario porque ya estan las cosas
        }
        listaServicioInterfaz.updateUI();
    }//GEN-LAST:event_botonQuitarActionPerformed
    
    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        List selected = listaSistemaInterfaz.getSelectedValuesList();
        Iterator it1 = selected.iterator();
        while (it1.hasNext()){
            String actual = (String) it1.next();
            Iterator it2 = listaServicio.iterator();
            boolean yaEstaAsignado = false;
            while (it2.hasNext() && !yaEstaAsignado) {
                if (it2.next().equals(actual)) {
                    yaEstaAsignado = true;
                }
            }
            if (!yaEstaAsignado)
                listaServicio.add(actual);
        }
        listaServicioInterfaz.updateUI();
    }//GEN-LAST:event_botonAgregarActionPerformed
    
    private void botonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarActionPerformed
        try {
            //primero recorro el set de categorias original, y a aquellas
            //categorias que no esten en mi lista nueva, les aplico quitar
            for (String s : categoriasServicio) {
                Iterator it = listaServicio.iterator();
                boolean found = false;
                //mientras no encuentre la categoria sigo buscandola
                while (it.hasNext() && !found) {
                    if (it.next().toString().equals(s))
                        //si la encuentro no la quito
                        found = true;
                }
                //si no la encontré, la saco
                if (!found) {
                    ctrlProductos.quitarCategoria(s);
                }
            }
            
            //ahora recorro la lista nueva, y cada elemento que no esté en mi
            //set de categorías original, lo agrego a las categorias del servicio
            
            Iterator it = listaServicio.iterator();
            while (it.hasNext()) {
                //si la categoria actual no esta dentro de las originales
                //del servicio, la agrego
                String categoria = it.next().toString();
                System.out.println("Linea 198: " + categoria);
                if (!categoriasServicio.contains(categoria))
                    ctrlProductos.agregarCategoria(categoria);
            }
            JOptionPane.showMessageDialog(this, "Categorías modificadas con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            padre.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage().toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_botonConfirmarActionPerformed
    
    Set<String> categoriasServicio;
    ICtrlProductos ctrlProductos;
    ModificacionServicio padre;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonConfirmar;
    private javax.swing.JButton botonQuitar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaServicioInterfaz;
    private Vector<String> listaServicio = new Vector<>();
    private javax.swing.JList listaSistemaInterfaz;
    private Vector<String> listaSistema = new Vector<>();
    // End of variables declaration//GEN-END:variables
}
