/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTMinProveedor;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTProveedor;
import com.tprog.logica.interfaces.ICtrlUsuarios;
import java.awt.Image;
import java.io.File;
import java.util.Set;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VerInformacionDeProveedor extends javax.swing.JInternalFrame {

    /**
     * Creates new form VerInformacionDeCliente
     *
     */
    public VerInformacionDeProveedor(ICtrlUsuarios ctrlUsuarios) {
        this.ctrlUsuarios = ctrlUsuarios;
        initComponents();
    }

    void cargarDatos() {
        //listaClientes
        Set<DTMinProveedor> setProveedores = ctrlUsuarios.listarProveedores();
        //construyo un vector con la informacion a mostrar, porque
        //el comboBox solo funciona con Vector o List
        if (!setProveedores.isEmpty()) {
            for (DTMinProveedor dt : setProveedores) {
                listaProveedores.add(dt.getNickname());
            }
            listaProveedores.sort(null);
        } else {
            JOptionPane.showMessageDialog(this, "No hay proveedores en el sistema.", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
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

        listaProveedoresInterfaz = new javax.swing.JComboBox(listaProveedores);
        label = new javax.swing.JLabel();
        imagenUsuarioHolder = new javax.swing.JLabel();
        panelUsuario = new javax.swing.JScrollPane();
        detalleUsuario = new javax.swing.JTextArea();
        botonServicios = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Ver Información de Proveedor");
        setPreferredSize(new java.awt.Dimension(640, 480));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaProveedoresInterfaz.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                listaProveedoresInterfazInterfazComponentAdded(evt);
            }
        });
        listaProveedoresInterfaz.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaProveedoresInterfazItemStateChanged(evt);
            }
        });
        listaProveedoresInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaProveedoresInterfazInterfazActionPerformed(evt);
            }
        });
        getContentPane().add(listaProveedoresInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 270, -1));

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Seleccione un proveedor del Sistema para ver su información");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 440, 30));
        label.getAccessibleContext().setAccessibleDescription("");

        imagenUsuarioHolder.setMaximumSize(new java.awt.Dimension(50, 50));
        imagenUsuarioHolder.setPreferredSize(new java.awt.Dimension(50, 50));
        getContentPane().add(imagenUsuarioHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 140, 140));

        detalleUsuario.setEditable(false);
        detalleUsuario.setColumns(20);
        detalleUsuario.setLineWrap(true);
        detalleUsuario.setRows(5);
        detalleUsuario.setWrapStyleWord(true);
        panelUsuario.setViewportView(detalleUsuario);

        getContentPane().add(panelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 230, 190));

        botonServicios.setText("Ver servicios");
        botonServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonServiciosActionPerformed(evt);
            }
        });
        getContentPane().add(botonServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        cargarDatos();
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        listaProveedores.clear();
        servicios = null;
        imagenUsuarioHolder.setIcon(null);
        listaProveedoresInterfaz.setSelectedItem(null);
        detalleUsuario.setText("");
    }//GEN-LAST:event_formComponentHidden

    private void listaProveedoresInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaProveedoresInterfazInterfazActionPerformed
        //seleccionarProveedor
        String proveedor = (String) listaProveedoresInterfaz.getSelectedItem();
        if (proveedor != null) {
            ctrlUsuarios.seleccionarProveedor(proveedor);
            //muestro Text Area para la información del proveedor
            detalleUsuario.setVisible(true);
            try {
                DTProveedor dt = ctrlUsuarios.infoProveedor();
                detalleUsuario.setText(dt.toString());
                String imagen = dt.getImagen();
                if (imagen != null) {
                    File f = new File(dt.getImagen());
                    Image img = ImageIO.read(f);
                    Image dimg = img.getScaledInstance(imagenUsuarioHolder.getWidth(), imagenUsuarioHolder.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon imageIcon = new ImageIcon(dimg);
                    imagenUsuarioHolder.setIcon(imageIcon);
                } else {
                    imagenUsuarioHolder.setIcon(null);
                }
                //cargo la lista de servicios del proveedor
                servicios = ctrlUsuarios.listarServiciosProveedor();
            } catch (Exception e) {
                System.out.println("La imagen no pudo ser cargada");
                imagenUsuarioHolder.setIcon(null);
            }
        }
    }//GEN-LAST:event_listaProveedoresInterfazInterfazActionPerformed

    private void listaProveedoresInterfazInterfazComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listaProveedoresInterfazInterfazComponentAdded

    }//GEN-LAST:event_listaProveedoresInterfazInterfazComponentAdded

    private void listaProveedoresInterfazItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaProveedoresInterfazItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listaProveedoresInterfazItemStateChanged

    private void botonServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonServiciosActionPerformed
        String cliente = (String) listaProveedoresInterfaz.getSelectedItem();
        if (cliente != null) {
            ServiciosProveedor s = new ServiciosProveedor(this, servicios, ctrlUsuarios);
            this.setVisible(false);
            getParent().add(s);
            s.setLocation(this.getLocation());
            s.setVisible(true);
        }
    }//GEN-LAST:event_botonServiciosActionPerformed

    Set<DTMinServicio> servicios;
    ICtrlUsuarios ctrlUsuarios;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonServicios;
    private javax.swing.JTextArea detalleUsuario;
    private javax.swing.JLabel imagenUsuarioHolder;
    private javax.swing.JLabel label;
    private javax.swing.JComboBox listaProveedoresInterfaz;
    private Vector<String> listaProveedores = new Vector<>();
    private javax.swing.JScrollPane panelUsuario;
    // End of variables declaration//GEN-END:variables
}
