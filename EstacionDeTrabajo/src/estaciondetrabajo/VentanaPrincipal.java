/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estaciondetrabajo;

import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JInternalFrame;

/**
 *
 * @author marccio.silva
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
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

        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        menu = new javax.swing.JMenuBar();
        menuRegistros = new javax.swing.JMenu();
        menuItemAltaUsuario = new javax.swing.JMenuItem();
        menuItemAltaCategoria = new javax.swing.JMenuItem();
        menuItemAltaServicio = new javax.swing.JMenuItem();
        menuItemAltaPromocion = new javax.swing.JMenuItem();
        menuItemActualizarServicio = new javax.swing.JMenuItem();
        menuItemRealizarReserva = new javax.swing.JMenuItem();
        menuItemActualizarEstadoReserva = new javax.swing.JMenu();
        menuConsultas = new javax.swing.JMenu();
        menuItemVerInfoCliente = new javax.swing.JMenuItem();
        menuItemVerInfoProveedor = new javax.swing.JMenuItem();
        menuItemVerInfoServicio = new javax.swing.JMenuItem();
        menuItemVerInfoPromocion = new javax.swing.JMenuItem();
        menuItemVerInfoReserva = new javax.swing.JMenuItem();
        menuBorrados = new javax.swing.JMenu();
        menuItemCancelarReserva = new javax.swing.JMenuItem();

        jMenuItem6.setText("jMenuItem6");

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        menuRegistros.setText("Registros");

        menuItemAltaUsuario.setText("Alta de Usuario");
        menuItemAltaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAltaUsuarioActionPerformed(evt);
            }
        });
        menuRegistros.add(menuItemAltaUsuario);

        menuItemAltaCategoria.setText("Alta de Categoría");
        menuRegistros.add(menuItemAltaCategoria);

        menuItemAltaServicio.setText("Alta de Servicio");
        menuRegistros.add(menuItemAltaServicio);

        menuItemAltaPromocion.setText("Alta de Promoción");
        menuRegistros.add(menuItemAltaPromocion);

        menuItemActualizarServicio.setText("Actualizar Servicio");
        menuRegistros.add(menuItemActualizarServicio);

        menuItemRealizarReserva.setText("Realizar Reserva");
        menuRegistros.add(menuItemRealizarReserva);

        menuItemActualizarEstadoReserva.setText("Actualizar estado de Reserva");
        menuRegistros.add(menuItemActualizarEstadoReserva);

        menu.add(menuRegistros);

        menuConsultas.setText("Consultas");

        menuItemVerInfoCliente.setText("Ver Información de Cliente");
        menuItemVerInfoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuItemVerInfoClienteMouseClicked(evt);
            }
        });
        menuItemVerInfoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVerInfoClienteActionPerformed(evt);
            }
        });
        menuConsultas.add(menuItemVerInfoCliente);

        menuItemVerInfoProveedor.setText("Ver Información de Proveedor");
        menuItemVerInfoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVerInfoProveedorActionPerformed(evt);
            }
        });
        menuConsultas.add(menuItemVerInfoProveedor);

        menuItemVerInfoServicio.setText("Ver Información de Servicio");
        menuConsultas.add(menuItemVerInfoServicio);

        menuItemVerInfoPromocion.setText("Ver Información de Promoción");
        menuConsultas.add(menuItemVerInfoPromocion);

        menuItemVerInfoReserva.setText("Ver Información de Reserva");
        menuConsultas.add(menuItemVerInfoReserva);

        menu.add(menuConsultas);

        menuBorrados.setText("Borrados");

        menuItemCancelarReserva.setText("Cancelar Reserva");
        menuBorrados.add(menuItemCancelarReserva);

        menu.add(menuBorrados);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemAltaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAltaUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemAltaUsuarioActionPerformed
   
    private void menuItemVerInfoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerInfoClienteActionPerformed
        if (verInformacionDeCliente == null) {
            verInformacionDeCliente = new VerInformacionDeCliente();
            verInformacionDeCliente.setSize(rootPane.size());
            //verInformacionDeCliente.moveToFront();
            getContentPane().add(verInformacionDeCliente);
            internalFrames.put("verInformacionDeCliente", verInformacionDeCliente);
            for (Map.Entry<String, JInternalFrame> internalFrame : internalFrames.entrySet()) {
                if (internalFrame.getKey() != "verInformacionDeCliente") {
                    internalFrame.getValue().setVisible(false);
                } else internalFrame.getValue().setVisible(true);
            }
            /*
             if (verInformacionDeProveedor != null) verInformacionDeProveedor.setVisible(false);
             if (verInformacionDePromocion != null) verInformacionDePromocion.setVisible(false);
             if (verInformacionDeReserva != null) verInformacionDeReserva.setVisible(false);
             if (verInformacionDeServicio != null) verInformacionDeServicio.setVisible(false);
             if (cancelarReserva != null) cancelarReserva.setVisible(false);
             */
        } else if (!verInformacionDeCliente.isVisible()) {
            for (Map.Entry<String, JInternalFrame> internalFrame : internalFrames.entrySet()) {
                if (internalFrame.getKey() != "verInformacionDeCliente") {
                    internalFrame.getValue().setVisible(false);
                } else internalFrame.getValue().setVisible(true);
            }
            verInformacionDeCliente.setVisible(rootPaneCheckingEnabled);
            verInformacionDeCliente.moveToFront();
        }
    }//GEN-LAST:event_menuItemVerInfoClienteActionPerformed

    private void menuItemVerInfoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuItemVerInfoClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemVerInfoClienteMouseClicked

    private void menuItemVerInfoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerInfoProveedorActionPerformed
        if (verInformacionDeProveedor == null) {
            verInformacionDeProveedor = new VerInformacionDeProveedor();
            getContentPane().add(verInformacionDeProveedor);
            verInformacionDeProveedor.setSize(rootPane.size());
            //verInformacionDeCliente.moveToFront();
            internalFrames.put("verInformacionDeProveedor", verInformacionDeProveedor);
            for (Map.Entry<String, JInternalFrame> internalFrame : internalFrames.entrySet()) {
                if (internalFrame.getKey() != "verInformacionDeProveedor") {
                    internalFrame.getValue().setVisible(false);
                } else internalFrame.getValue().setVisible(true);
            }
        } else if (!verInformacionDeProveedor.isVisible()) {  
            for (Map.Entry<String, JInternalFrame> internalFrame : internalFrames.entrySet()) {
                if (internalFrame.getKey() != "verInformacionDeProveedor") {
                    internalFrame.getValue().setVisible(false);
                } else internalFrame.getValue().setVisible(true);
            }
            //verInformacionDeProveedor.setVisible(rootPaneCheckingEnabled);
            verInformacionDeCliente.moveToFront();
        }
    }//GEN-LAST:event_menuItemVerInfoProveedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
    
    HashMap<String, JInternalFrame> internalFrames = new HashMap<String, JInternalFrame>();
    //Variables nuestras
    private VerInformacionDeCliente verInformacionDeCliente;
    private VerInformacionDePromocion verInformacionDePromocion;
    private VerInformacionDeProveedor verInformacionDeProveedor;
    private VerInformacionDeReserva verInformacionDeReserva;
    private VerInformacionDeServicio verInformacionDeServicio;
    private CancelarReserva cancelarReserva;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuBorrados;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JMenu menuItemActualizarEstadoReserva;
    private javax.swing.JMenuItem menuItemActualizarServicio;
    private javax.swing.JMenuItem menuItemAltaCategoria;
    private javax.swing.JMenuItem menuItemAltaPromocion;
    private javax.swing.JMenuItem menuItemAltaServicio;
    private javax.swing.JMenuItem menuItemAltaUsuario;
    private javax.swing.JMenuItem menuItemCancelarReserva;
    private javax.swing.JMenuItem menuItemRealizarReserva;
    private javax.swing.JMenuItem menuItemVerInfoCliente;
    private javax.swing.JMenuItem menuItemVerInfoPromocion;
    private javax.swing.JMenuItem menuItemVerInfoProveedor;
    private javax.swing.JMenuItem menuItemVerInfoReserva;
    private javax.swing.JMenuItem menuItemVerInfoServicio;
    private javax.swing.JMenu menuRegistros;
    // End of variables declaration//GEN-END:variables
}
