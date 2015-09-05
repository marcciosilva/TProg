/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.interfaces.ICtrlReservas;
import java.util.Set;
import java.util.Vector;

public class VerInformacionDeReserva extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReservasCliente
     */
    public VerInformacionDeReserva(ICtrlReservas ctrlReservas) {
        this.ctrlReservas = ctrlReservas;
        initComponents();
        cargarDatos();
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
            listaReservas.sort(null);
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
        panelUsuario = new javax.swing.JScrollPane();
        detalleReserva = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Ver Información de Reserva");
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
        getContentPane().add(listaReservasInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 330, -1));

        detalleReserva.setEditable(false);
        detalleReserva.setColumns(20);
        detalleReserva.setLineWrap(true);
        detalleReserva.setRows(5);
        detalleReserva.setWrapStyleWord(true);
        panelUsuario.setViewportView(detalleReserva);

        getContentPane().add(panelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 270, 250));

        jLabel1.setText("<html>Seleccione alguna reserva del sistema para ver su información</html>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaReservasInterfazInterfazComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listaReservasInterfazInterfazComponentAdded

    }//GEN-LAST:event_listaReservasInterfazInterfazComponentAdded

    private void listaReservasInterfazItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaReservasInterfazItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listaReservasInterfazItemStateChanged

    private void listaReservasInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaReservasInterfazInterfazActionPerformed
        String reservaSeleccionada = (String) listaReservasInterfaz.getModel().getSelectedItem();
        if (reservaSeleccionada != null) {
            int reserva = Integer.parseInt(reservaSeleccionada);
            ctrlReservas.seleccionarReserva(reserva);
            DTReserva dt = ctrlReservas.infoReserva();
            detalleReserva.setVisible(true);
            detalleReserva.setText(dt.toString()); //imprimir lineas de reserva
        }
    }//GEN-LAST:event_listaReservasInterfazInterfazActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        cargarDatos();
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        listaReservas.clear();
        reservas = null;
        listaReservasInterfaz.setSelectedItem(null);
        detalleReserva.setText("");
        detalleReserva.setVisible(false);
    }//GEN-LAST:event_formComponentHidden

    ICtrlReservas ctrlReservas;
    Set<DTMinReserva> reservas;
    VerInformacionDeCliente padre;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea detalleReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox listaReservasInterfaz;
    private Vector<String> listaReservas = new Vector<>();
    private javax.swing.JScrollPane panelUsuario;
    // End of variables declaration//GEN-END:variables
}
