/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.interfaces.ICtrlReservas;
import java.awt.event.MouseListener;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author marccio
 */
public class CancelarReserva extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form ReservasCliente
     */
    public CancelarReserva(ICtrlReservas ctrlReservas) {
        this.ctrlReservas = ctrlReservas;
        initComponents();
        BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
        for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
            basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
        }
    }
    
    void cargarDatos() {
        //listaClientes
        Set<DTMinReserva> setReservas = ctrlReservas.listarReservas();
        //construyo un vector con la informacion a mostrar, porque
        //el comboBox solo funciona con Vector o List
        if (setReservas != null) {
            for (DTMinReserva dt : setReservas) {
                listaReservas.add(Integer.toString(dt.getIdReserva()));
            }
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

        listaReservasInterfaz = new javax.swing.JComboBox(listaReservas);
        botonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonEliminar = new javax.swing.JButton();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(640, 480));
        setVisible(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaReservasInterfaz.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                listaReservasInterfazInterfazComponentAdded(evt);
            }
        });
        listaReservasInterfaz.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaReservasInterfazItemStateChanged(evt);
            }
        });
        listaReservasInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaReservasInterfazInterfazActionPerformed(evt);
            }
        });
        getContentPane().add(listaReservasInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 350, -1));

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, -1, -1));

        jLabel1.setText("<html>Seleccione alguna reserva del sistema para eliminarla</html>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void listaReservasInterfazInterfazComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listaReservasInterfazInterfazComponentAdded
        
    }//GEN-LAST:event_listaReservasInterfazInterfazComponentAdded
    
    private void listaReservasInterfazItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaReservasInterfazItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listaReservasInterfazItemStateChanged
    
    private void listaReservasInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaReservasInterfazInterfazActionPerformed
        String reservaSeleccionada = (String) listaReservasInterfaz.getSelectedItem();
        if (reservaSeleccionada != null) {
            int reserva = Integer.parseInt(reservaSeleccionada);
            ctrlReservas.seleccionarReserva(reserva);
            DTReserva dt = ctrlReservas.infoReserva();
        }
    }//GEN-LAST:event_listaReservasInterfazInterfazActionPerformed
    
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed
    
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        cargarDatos();
    }//GEN-LAST:event_formComponentShown
    
    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        listaReservas.clear();
        reservas = null;
        listaReservasInterfaz.setSelectedItem(null);
    }//GEN-LAST:event_formComponentHidden
    
    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        String reservaSeleccionada = (String) listaReservasInterfaz.getSelectedItem();
        if (reservaSeleccionada != null) {
            boolean eliminada = ctrlReservas.eliminarReserva();
            if (eliminada) {
                JOptionPane.showMessageDialog(this, "La reserva fue eliminada exitosamente", "Cancelación de Reserva", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, "La reserva no pudo ser eliminada", "Cancelación de Reserva", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed
    
    ICtrlReservas ctrlReservas;
    Set<DTMinReserva> reservas;
    VerInformacionDeCliente padre;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox listaReservasInterfaz;
    private Vector<String> listaReservas = new Vector<>();
    // End of variables declaration//GEN-END:variables
}
