/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTUsuario;
import com.tprog.logica.interfaces.ICtrlUsuarios;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class AltaDeUsuario2 extends javax.swing.JInternalFrame {

	private final AltaDeUsuario1 anterior;
	private String ruta;
	private final ICtrlUsuarios ictrlU;

	public AltaDeUsuario2(AltaDeUsuario1 anterior, String nickname, String email, ICtrlUsuarios ictrlU) {

		setTitle("Alta de Usuario");
		this.anterior = anterior;
		this.nickname = nickname;
		this.email = email;

		this.ictrlU = ictrlU;
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
		for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
			basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
		}
		initComponents();
	}

	private boolean isWhiteSpace(String s) {
		return s.matches("^\\s*$");
	}

	private boolean hasWhiteSpace(String s) {
		return s.matches("\\s");
	}

	private void exit() {
		// dispose a AltaDeUsuario1
		anterior.dispose();
		// dispose de esta ventana
		this.dispose();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelImagen = new javax.swing.JLabel();
        buttonSeleccionar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        radioButtonCliente = new javax.swing.JRadioButton();
        radioButtonProveedor = new javax.swing.JRadioButton();
        labelNombreEmpresa = new javax.swing.JLabel();
        labelLinkEmpresa = new javax.swing.JLabel();
        buttonAtras = new javax.swing.JButton();
        buttonConfirmar = new javax.swing.JButton();
        buttonSalir = new javax.swing.JButton();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldEmpresa = new javax.swing.JTextField();
        jTextFieldLinkEmpresa = new javax.swing.JTextField();
        jComboBoxAnios = new com.tprog.estaciondetrabajo.customComponents.JComboBoxAnios();
        jComboBoxMeses = new com.tprog.estaciondetrabajo.customComponents.JComboBoxMeses();
        jComboBoxDias = new com.tprog.estaciondetrabajo.customComponents.JComboBoxDias();

        grupoBotones.add(radioButtonCliente);
        grupoBotones.add(radioButtonProveedor);

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Complete los datos del nuevo Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabelNombre.setText("Nombre");
        getContentPane().add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 57, -1));

        jLabelApellido.setText("Apellido");
        getContentPane().add(jLabelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel4.setText("Imágen");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        labelImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(labelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 140, 140));

        buttonSeleccionar.setText("Seleccionar...");
        buttonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        jLabel6.setText("Fecha de Nacimiento");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        jLabel7.setText("Día");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        jLabel8.setText("Mes");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        jLabel9.setText("Año");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, -1, -1));

        jLabel10.setText("Tipo de Usuario");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        radioButtonCliente.setText("Cliente");
        radioButtonCliente.setSelected(true);
        radioButtonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonClienteActionPerformed(evt);
            }
        });
        getContentPane().add(radioButtonCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        radioButtonProveedor.setText("Proveedor");
        radioButtonCliente.setSelected(false);
        radioButtonProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(radioButtonProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));

        labelNombreEmpresa.setVisible(false);
        labelNombreEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelNombreEmpresa.setText("Nombre de la Empresa ");
        labelNombreEmpresa.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(labelNombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));

        labelLinkEmpresa.setVisible(false);
        labelLinkEmpresa.setText("Link de la Empresa");
        getContentPane().add(labelLinkEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));

        buttonAtras.setText("< Atras");
        buttonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, -1, -1));

        buttonConfirmar.setText("Confirmar");
        buttonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        buttonSalir.setText("Salir");
        buttonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, -1, -1));
        getContentPane().add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 140, -1));
        getContentPane().add(jTextFieldApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 140, -1));

        jTextFieldEmpresa.setVisible(false);
        getContentPane().add(jTextFieldEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 310, -1));

        jTextFieldLinkEmpresa.setVisible(false);
        getContentPane().add(jTextFieldLinkEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 310, -1));
        getContentPane().add(jComboBoxAnios, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, -1, -1));
        getContentPane().add(jComboBoxMeses, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));
        getContentPane().add(jComboBoxDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSeleccionarActionPerformed
		// File Chooser
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Imágenes JPG & PNG ", "jpg", "png");
		fc.setFileFilter(filter);
		int seleccion = fc.showDialog(this, "Seleccione una imágen");
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			// Para guardar la imagen
			File file = fc.getSelectedFile();
			ruta = file.getPath();
			try {
				Image img = ImageIO.read(file);
				Image dimg = img.getScaledInstance(labelImagen.getWidth(), labelImagen.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(dimg);
				labelImagen.setIcon(imageIcon);
				labelImagen.setHorizontalAlignment(JLabel.CENTER);
				labelImagen.setVerticalAlignment(JLabel.CENTER);
				rutaImagen = ruta;
			} catch (IOException e) {
				e.getMessage();
				rutaImagen = null;
			}
		}
    }//GEN-LAST:event_buttonSeleccionarActionPerformed

	private void radioButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {
		jTextFieldEmpresa.setVisible(false);
		jTextFieldLinkEmpresa.setVisible(false);
		labelNombreEmpresa.setVisible(false);
		labelLinkEmpresa.setVisible(false);
		jTextFieldEmpresa.setVisible(false);
		jTextFieldLinkEmpresa.setVisible(false);
	}

    private void radioButtonProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonProveedorActionPerformed
		jTextFieldEmpresa.setVisible(true);
		jTextFieldLinkEmpresa.setVisible(true);
		labelNombreEmpresa.setVisible(true);
		labelLinkEmpresa.setVisible(true);
		jTextFieldEmpresa.setVisible(true);
		jTextFieldLinkEmpresa.setVisible(true);
    }//GEN-LAST:event_radioButtonProveedorActionPerformed

    private void buttonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmarActionPerformed
		String nombre = jTextFieldNombre.getText();
		String apellido = jTextFieldApellido.getText();
		int dia = (Integer) jComboBoxDias.getSelectedItem();
		int mes = jComboBoxMeses.getSelectedIndex() + 1;
		int anio = (Integer) jComboBoxAnios.getSelectedItem();
		boolean proveedor = radioButtonProveedor.isSelected();

		// Verificar nombre y apellido
		boolean okNombre = !isWhiteSpace(nombre);
		boolean okApellido = !isWhiteSpace(apellido);

		// Verificacion de empresa y webEmpresa
		String nombreEmpresa = "Empresa por defecto";
		String linkEmpresa = "empresa.com";
		boolean okNombreEmpresa = false;
		boolean okLinkEmpresa = false;
		if (proveedor) {
			nombreEmpresa = jTextFieldEmpresa.getText();
			linkEmpresa = jTextFieldLinkEmpresa.getText();
			okNombreEmpresa = !isWhiteSpace(nombreEmpresa);
			okLinkEmpresa = !isWhiteSpace(linkEmpresa) && !hasWhiteSpace(linkEmpresa);
		}

		// Mando los datos al controlador
		if (okNombre && okApellido) {
			Date fechaNacimiento = new Date(anio, mes, dia);
			DTUsuario dtU = new DTUsuario(nickname, nombre, apellido, email, rutaImagen, fechaNacimiento);
			ictrlU.ingresarDatosUsuario(dtU, proveedor);
			if (proveedor && okNombreEmpresa && okLinkEmpresa) {
				ictrlU.ingresarDatosProveedor(nombreEmpresa, linkEmpresa);
			}
		}

		// Creo Usuario
		boolean okCliente = okNombre && okApellido;
		boolean okProveedor = okCliente && okNombreEmpresa && okLinkEmpresa;
		boolean creado = false;
		if (proveedor) {
			if (okProveedor) {
				ictrlU.altaUsuario();
				creado = true;
			}
		} else {
			if (okCliente) {
				ictrlU.altaUsuario();
				creado = true;
			}
		}

		// Salir con éxito o reportar errores
		if (creado) {
			JOptionPane.showMessageDialog(this, "Usuario creado con éxito", "Alta de Usuario", JOptionPane.INFORMATION_MESSAGE);
			exit();
		} else {
			String error = "";
			if (!okNombre) {
				error = "El nombre ingresado no es correcto.";
			} else if (!okApellido) {
				error = "El apellido ingresado no es correcto.";
			} else if (!okNombreEmpresa) {
				error = "El nombre de empresa ingresado no es correcto.";
			} else if (!okLinkEmpresa) {
				error = "El link de empresa ingresado no es correcto.";
			}
			JOptionPane.showMessageDialog(this, "Error! " + error, "Alta de Usuario", JOptionPane.INFORMATION_MESSAGE);
		}
    }//GEN-LAST:event_buttonConfirmarActionPerformed

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
		exit();
    }//GEN-LAST:event_buttonSalirActionPerformed

	private void buttonAtrasActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
		anterior.setVisible(true);
	}

	String nickname = null;
	String email = null;
	String rutaImagen = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAtras;
    private javax.swing.JButton buttonConfirmar;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JButton buttonSeleccionar;
    private javax.swing.ButtonGroup grupoBotones;
    private com.tprog.estaciondetrabajo.customComponents.JComboBoxAnios jComboBoxAnios;
    private com.tprog.estaciondetrabajo.customComponents.JComboBoxDias jComboBoxDias;
    private com.tprog.estaciondetrabajo.customComponents.JComboBoxMeses jComboBoxMeses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldEmpresa;
    private javax.swing.JTextField jTextFieldLinkEmpresa;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelLinkEmpresa;
    private javax.swing.JLabel labelNombreEmpresa;
    private javax.swing.JRadioButton radioButtonCliente;
    private javax.swing.JRadioButton radioButtonProveedor;
    // End of variables declaration//GEN-END:variables
}
