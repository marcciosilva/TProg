/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTCliente;
import com.tprog.logica.dt.DTMinCliente;
import com.tprog.logica.dt.DTMinReserva;
import com.tprog.logica.interfaces.Fabrica;
import com.tprog.logica.interfaces.ICtrlUsuarios;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Set;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class VerInformacionDeCliente extends javax.swing.JInternalFrame {

	/**
	 * Creates new form VerInformacionDeCliente
	 */
	public VerInformacionDeCliente() {
		initComponents();
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
		for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
			basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
		}
	}

	void cargarDatos() {
		//pedir controlador
		Fabrica f = Fabrica.getInstance();
		ctrlUsuarios = f.getICtrlUsuarios();
		
		//listaClientes
		Set<DTMinCliente> setClientes = ctrlUsuarios.listarClientes();
        //construyo un vector con la informacion a mostrar, porque
		//el comboBox solo funciona con Vector o List
		if (!setClientes.isEmpty()) {
			for (DTMinCliente dt : setClientes) {
				listaClientes.add(dt.getNickname());
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

        botonSalir = new javax.swing.JButton();
        listaClientesInterfaz = new javax.swing.JComboBox(listaClientes);
        label = new javax.swing.JLabel();
        imagenUsuario = new javax.swing.JLabel();
        panelUsuario = new javax.swing.JScrollPane();
        detalleUsuario = new javax.swing.JTextArea();
        botonReservas = new javax.swing.JButton();

        setBorder(null);
        setToolTipText("");
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

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, -1, -1));

        listaClientesInterfaz.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                listaClientesInterfazInterfazComponentAdded(evt);
            }
        });
        listaClientesInterfaz.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaClientesInterfazItemStateChanged(evt);
            }
        });
        listaClientesInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaClientesInterfazInterfazActionPerformed(evt);
            }
        });
        getContentPane().add(listaClientesInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 270, -1));

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Seleccione un cliente del Sistema para ver su información");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 420, 30));
        label.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(imagenUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 140, 130));

        detalleUsuario.setEditable(false);
        detalleUsuario.setColumns(20);
        detalleUsuario.setLineWrap(true);
        detalleUsuario.setRows(5);
        detalleUsuario.setWrapStyleWord(true);
        panelUsuario.setViewportView(detalleUsuario);

        getContentPane().add(panelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 230, 190));

        botonReservas.setText("Ver reservas");
        botonReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReservasActionPerformed(evt);
            }
        });
        getContentPane().add(botonReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
		//pido de nuevo los datos en caso de que hayan cambiado
		cargarDatos();
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
		listaClientes.clear();
		reservas = null;
		imagenUsuario.setIcon(null);
		listaClientesInterfaz.setSelectedItem(null);
		detalleUsuario.setText("");
		detalleUsuario.setVisible(false);
    }//GEN-LAST:event_formComponentHidden

    private void listaClientesInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaClientesInterfazInterfazActionPerformed
		//seleccionarCliente
		String cliente = (String) listaClientesInterfaz.getSelectedItem();
		if (cliente != null) {
			ctrlUsuarios.seleccionarCliente(cliente);
			//muestro Text Area para la información del cliente
			detalleUsuario.setVisible(true);
			DTCliente dt = ctrlUsuarios.infoCliente();
			detalleUsuario.setText(dt.toString());
			try {
				File f = new File(dt.getImagen());
				Image img = ImageIO.read(f);
				Image dimg = img.getScaledInstance(imagenUsuario.getWidth(), imagenUsuario.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(dimg);
				imagenUsuario.setIcon(imageIcon);
			} catch (Exception e) {
				System.out.println("La imagen no pudo ser cargada");
			}
			
			//cargo la lista de reservas del usuario
			reservas = dt.getReservas();
		}
    }//GEN-LAST:event_listaClientesInterfazInterfazActionPerformed

    private void listaClientesInterfazInterfazComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listaClientesInterfazInterfazComponentAdded

    }//GEN-LAST:event_listaClientesInterfazInterfazComponentAdded

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
		this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void listaClientesInterfazItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaClientesInterfazItemStateChanged

    }//GEN-LAST:event_listaClientesInterfazItemStateChanged

    private void botonReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReservasActionPerformed
		String cliente = (String) listaClientesInterfaz.getSelectedItem();
		if (cliente != null) {
			ReservasCliente r = new ReservasCliente(this, reservas, ctrlUsuarios);
			this.setVisible(false);
			r.setVisible(true);
			getParent().add(r);
		}
    }//GEN-LAST:event_botonReservasActionPerformed

	Set<DTMinReserva> reservas;
	ICtrlUsuarios ctrlUsuarios;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonReservas;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextArea detalleUsuario;
    private javax.swing.JLabel imagenUsuario;
    private javax.swing.JLabel label;
    private javax.swing.JComboBox listaClientesInterfaz;
    private Vector<String> listaClientes = new Vector<>();
    private javax.swing.JScrollPane panelUsuario;
    // End of variables declaration//GEN-END:variables
}
