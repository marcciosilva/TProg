/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.interfaces.ICtrlProductos;
import java.awt.Image;
import java.io.File;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ModificacionImagenes extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReservasCliente
     *
     * @param idCliente
     * @param padre
     */
    public ModificacionImagenes(ModificacionServicio padre, ICtrlProductos ctrlProductos) {
        this.padre = padre;
        this.ctrlProductos = ctrlProductos;
        initComponents();
        actualizarImagenes();
    }

    public void actualizarImagenes() {
        cantidadImagenes = 0;
        modelComboBox.clear();
        Set<String> imagenes = ctrlProductos.listarImagenes();
        for (String ruta : imagenes) {
            try {
                //obtengo archivo desde ruta
                File f = new File(ruta);
                //creo imagen
                Image img = ImageIO.read(f);
                //redimensiono para que entre en la JLabel
                int width = 120;
                int height = img.getHeight(null) * width / img.getWidth(null);
                Image dimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                //armo el ImageIcon
                ImageIcon imageIcon = new ImageIcon(dimg);
                imageIcon.setDescription(ruta);
                //lo asocio a la JLabel
                modelComboBox.add(imageIcon);
                cantidadImagenes++;

            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        System.out.println("Cantidad de imágenes tras actualización = " + Integer.toString(cantidadImagenes));
        comboboxImagenes.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAtras = new javax.swing.JButton();
        comboboxImagenes = new javax.swing.JComboBox(modelComboBox);
        botonQuitar = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("Actualizar Servicio - Imágenes");
        setPreferredSize(new java.awt.Dimension(640, 480));
        setVisible(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonAtras.setText("< Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        comboboxImagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxImagenesActionPerformed(evt);
            }
        });
        getContentPane().add(comboboxImagenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 160, 120));

        botonQuitar.setText("Quitar");
        botonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarActionPerformed(evt);
            }
        });
        getContentPane().add(botonQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        this.dispose();
        padre.setVisible(true);
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        /*
         descripcionInterfaz.setText(servicio.getDescripcion());
         precioInterfaz.setText(Float.toString(servicio.getPrecio()));
         */
    }//GEN-LAST:event_formComponentShown

    private void botonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarActionPerformed
        ImageIcon imagen = (ImageIcon) comboboxImagenes.getSelectedItem();
        if (imagen != null) {
            try {
                ctrlProductos.quitarImagen(imagen.getDescription());
                comboboxImagenes.removeItem(imagen);
                cantidadImagenes--;
            } catch (Exception ex) {
                Logger.getLogger(ModificacionImagenes.class.getName()).log(Level.SEVERE, null, ex);
            }
            actualizarImagenes();
        } else {
            JOptionPane.showMessageDialog(this, "No hay ninguna imágen seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonQuitarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        if (cantidadImagenes < 3) {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File imagen = chooser.getSelectedFile();
            String nombreImagen = imagen.getAbsolutePath();
            try {
                ctrlProductos.agregarImagen(nombreImagen);
                cantidadImagenes++;
            } catch (Exception ex) {
                Logger.getLogger(ModificacionImagenes.class.getName()).log(Level.SEVERE, null, ex);
            }
            actualizarImagenes();
        }
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void comboboxImagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxImagenesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxImagenesActionPerformed

    Vector<ImageIcon> modelComboBox = new Vector<>();
    ICtrlProductos ctrlProductos;
    ModificacionServicio padre;
    int cantidadImagenes = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonQuitar;
    private javax.swing.JComboBox comboboxImagenes;
    // End of variables declaration//GEN-END:variables
}
