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
import static java.lang.Integer.parseInt;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class AltaDeUsuario2 extends javax.swing.JInternalFrame {

	private final AltaDeUsuario1 padre;
	private String ruta;
	private final ICtrlUsuarios ictrlU;

	public AltaDeUsuario2(AltaDeUsuario1 padre, String nickname, String email, ICtrlUsuarios ictrlU) {

		setTitle("Alta de Usuario");
		this.padre = padre;
		this.nickname = nickname;
		this.email = email;
		initComponents();
		this.ictrlU = ictrlU;
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

        grupoBotones = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPaneNombre = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPaneApellido = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        labelImagen = new javax.swing.JLabel();
        buttonSeleccionar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboBoxMeses = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        textPaneAnio = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        radioButtonCliente = new javax.swing.JRadioButton();
        radioButtonProveedor = new javax.swing.JRadioButton();
        labelNombreEmpresa = new javax.swing.JLabel();
        scrollPaneNombreEmpresa = new javax.swing.JScrollPane();
        textPaneNombreEmpresa = new javax.swing.JTextPane();
        labelLinkEmpresa = new javax.swing.JLabel();
        scrollPaneLinkEmpresa = new javax.swing.JScrollPane();
        textPaneLinkEmpresa = new javax.swing.JTextPane();
        buttonAtras = new javax.swing.JButton();
        buttonConfirmar = new javax.swing.JButton();
        buttonSalir = new javax.swing.JButton();
        jComboBoxDia = new javax.swing.JComboBox();

        grupoBotones.add(radioButtonCliente);
        grupoBotones.add(radioButtonProveedor);

        setPreferredSize(new java.awt.Dimension(690, 435));

        jLabel1.setText("Complete los datos del nuevo Usuario");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jScrollPane1.setViewportView(textPaneNombre);

        jScrollPane2.setViewportView(textPaneApellido);

        jLabel4.setText("Imágen");

        labelImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonSeleccionar.setText("Seleccionar");
        buttonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSeleccionarActionPerformed(evt);
            }
        });

        jLabel6.setText("Fecha de Nacimiento");

        jLabel7.setText("Día");

        jLabel8.setText("Mes");

        jLabel9.setText("Año");

        comboBoxMeses.setModel(new javax.swing.DefaultComboBoxModel(meses));
        comboBoxMeses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMesesActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(textPaneAnio);

        jLabel10.setText("Tipo de Usuario");

        radioButtonCliente.setText("Cliente");
        radioButtonCliente.setSelected(true);
        radioButtonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonClienteActionPerformed(evt);
            }
        });

        radioButtonProveedor.setText("Proveedor");
        radioButtonCliente.setSelected(false);
        radioButtonProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonProveedorActionPerformed(evt);
            }
        });

        labelNombreEmpresa.setVisible(false);
        labelNombreEmpresa.setText("Nombre de la Empresa ");

        scrollPaneNombreEmpresa.setVisible(false);

        textPaneNombreEmpresa.setVisible(false);
        scrollPaneNombreEmpresa.setViewportView(textPaneNombreEmpresa);

        labelLinkEmpresa.setVisible(false);
        labelLinkEmpresa.setText("Link de la Empresa");

        scrollPaneLinkEmpresa.setVisible(false);

        textPaneLinkEmpresa.setVisible(false);
        scrollPaneLinkEmpresa.setViewportView(textPaneLinkEmpresa);

        buttonAtras.setText("Atras");
        buttonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtrasActionPerformed(evt);
            }
        });

        buttonConfirmar.setText("Confirmar");
        buttonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmarActionPerformed(evt);
            }
        });

        buttonSalir.setText("Salir");
        buttonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });

        jComboBoxDia.setModel(new javax.swing.DefaultComboBoxModel(dias));
        jComboBoxDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabel4)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addComponent(buttonSeleccionar))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboBoxMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelLinkEmpresa)
                                            .addComponent(labelNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(scrollPaneNombreEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                            .addComponent(scrollPaneLinkEmpresa)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonAtras)
                                        .addGap(26, 26, 26)
                                        .addComponent(buttonConfirmar))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(174, 174, 174)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(radioButtonCliente)
                                                .addGap(18, 18, 18)
                                                .addComponent(radioButtonProveedor)))))))
                        .addGap(0, 59, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonSalir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(comboBoxMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(radioButtonCliente)
                                .addComponent(radioButtonProveedor)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonSeleccionar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(scrollPaneNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelNombreEmpresa))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(labelLinkEmpresa))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(scrollPaneLinkEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonAtras)
                            .addComponent(buttonConfirmar))
                        .addGap(5, 5, 5)
                        .addComponent(buttonSalir)))
                .addContainerGap())
        );

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

	private boolean isWhiteSpace(String s) {
		return s.matches("^\\s*$");
	}
	
	private boolean hasWhiteSpace(String s) {
		return s.matches("\\s");
	}

    private void radioButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonClienteActionPerformed
		// TODO add your handling code here:
		scrollPaneNombreEmpresa.setVisible(false);
		scrollPaneLinkEmpresa.setVisible(false);
		labelNombreEmpresa.setVisible(false);
		labelLinkEmpresa.setVisible(false);
		textPaneNombreEmpresa.setVisible(false);
		textPaneLinkEmpresa.setVisible(false);
    }//GEN-LAST:event_radioButtonClienteActionPerformed

    private void radioButtonProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonProveedorActionPerformed
		// TODO add your handling code here:
		scrollPaneNombreEmpresa.setVisible(true);
		scrollPaneLinkEmpresa.setVisible(true);
		labelNombreEmpresa.setVisible(true);
		labelLinkEmpresa.setVisible(true);
		textPaneNombreEmpresa.setVisible(true);
		textPaneLinkEmpresa.setVisible(true);
    }//GEN-LAST:event_radioButtonProveedorActionPerformed

    private void buttonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmarActionPerformed
		String nombre = textPaneNombre.getText();
		String apellido = textPaneApellido.getText();
		int dia = (Integer) jComboBoxDia.getSelectedItem();
		int mes = comboBoxMeses.getSelectedIndex() + 1;
		String anioString = textPaneAnio.getText();
		boolean proveedor = radioButtonProveedor.isSelected();

		// Verificar nombre y apellido
		boolean okNombre = !isWhiteSpace(nombre);
		boolean okApellido = !isWhiteSpace(apellido);

		// Verificacion del año
		int anio = parseInt(anioString);
		boolean okAnio = (anio >= 1900) && (anio <= 2015);

		// Verificacion de empresa y webEmpresa
		String nombreEmpresa = "Empresa por defecto";
		String linkEmpresa = "empresa.com";
		boolean okNombreEmpresa = false;
		boolean okLinkEmpresa = false;
		if (proveedor) {
			nombreEmpresa = textPaneNombreEmpresa.getText();
			linkEmpresa = textPaneLinkEmpresa.getText();
			okNombreEmpresa = !isWhiteSpace(nombreEmpresa);
			okLinkEmpresa = !isWhiteSpace(linkEmpresa) && !hasWhiteSpace(linkEmpresa);
		}

		// Mando los datos al controlador
		if (okNombre && okApellido && okAnio) {
			Date fechaNacimiento = new Date(anio, mes, dia);
			DTUsuario dtU = new DTUsuario(nickname, nombre, apellido, email, rutaImagen, fechaNacimiento);
			ictrlU.ingresarDatosUsuario(dtU, proveedor);
			if (proveedor && okNombreEmpresa && okLinkEmpresa) {
				ictrlU.ingresarDatosProveedor(nombreEmpresa, linkEmpresa);
			}
		}

		// Creo Usuario
		boolean okCliente = okNombre && okApellido && okAnio;
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
			this.dispose();
		} else {
			String error = "";
			if (!okNombre) {
				error = "El nombre ingresado no es correcto.";
			} else if (!okApellido) {
				error = "El apellido ingresado no es correcto.";
			} else if (!okAnio) {
				error = "El año ingresado no es correcto.\nDebe ingresar una fecha entre 1900 y 2015.";
			} else if (!okNombreEmpresa) {
				error = "El nombre de empresa ingresado no es correcto.";
			} else if (!okLinkEmpresa) {
				error = "El link de empresa ingresado no es correcto.";
			}
			JOptionPane.showMessageDialog(this, "Error! " + error, "Alta de Usuario", JOptionPane.INFORMATION_MESSAGE);
		}
    }//GEN-LAST:event_buttonConfirmarActionPerformed

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
		// TODO add your handling code here:
		this.dispose();
    }//GEN-LAST:event_buttonSalirActionPerformed

    private void buttonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtrasActionPerformed
		this.setVisible(false);
		padre.setVisible(true);
    }//GEN-LAST:event_buttonAtrasActionPerformed

    private void jComboBoxDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDiaActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDiaActionPerformed

    private void comboBoxMesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMesesActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMesesActionPerformed

	String nickname;
	String email;
	String rutaImagen = "";
	//Fabrica fabrica;
	//CtrlUsuarios ctrlU ;
	private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre",
		"Octubre", "Noviembre", "Diciembre"};
	private Integer[] dias = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAtras;
    private javax.swing.JButton buttonConfirmar;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JButton buttonSeleccionar;
    private javax.swing.JComboBox comboBoxMeses;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JComboBox jComboBoxDia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelLinkEmpresa;
    private javax.swing.JLabel labelNombreEmpresa;
    private javax.swing.JRadioButton radioButtonCliente;
    private javax.swing.JRadioButton radioButtonProveedor;
    private javax.swing.JScrollPane scrollPaneLinkEmpresa;
    private javax.swing.JScrollPane scrollPaneNombreEmpresa;
    private javax.swing.JTextPane textPaneAnio;
    private javax.swing.JTextPane textPaneApellido;
    private javax.swing.JTextPane textPaneLinkEmpresa;
    private javax.swing.JTextPane textPaneNombre;
    private javax.swing.JTextPane textPaneNombreEmpresa;
    // End of variables declaration//GEN-END:variables
}
