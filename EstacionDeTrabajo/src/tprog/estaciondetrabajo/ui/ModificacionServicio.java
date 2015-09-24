package tprog.estaciondetrabajo.ui;

import javax.swing.JOptionPane;
import tprog.logica.dt.DTServicio;
import tprog.logica.dt.DTUbicacion;
import tprog.logica.interfaces.ICtrlProductos;

public class ModificacionServicio extends javax.swing.JInternalFrame {

	public ModificacionServicio(ActualizarServicio padre, DTServicio servicio, ICtrlProductos ctrlProductos) {
		this.padre = padre;
		this.servicio = servicio;
		this.ctrlProductos = ctrlProductos;
		initComponents();
		descripcionInterfaz.setText(servicio.getDescripcion());
		precioInterfaz.setText(Float.toString(servicio.getPrecio()));
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonModificarCategorias = new javax.swing.JButton();
        botonModificarImagenes = new javax.swing.JButton();
        descripcionInterfaz = new javax.swing.JTextField();
        precioInterfaz = new javax.swing.JTextField();
        botonModificarUbicacion = new javax.swing.JButton();
        actualizarDescripcion = new javax.swing.JButton();
        actualizarPrecio = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Actualizar Servicio - Datos Básicos");
        setPreferredSize(new java.awt.Dimension(640, 480));
        setVisible(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("<html>Datos del servicio seleccionado</html>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        jLabel2.setText("Descripcion");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jLabel3.setText("Precio");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        botonModificarCategorias.setText("Modificar categorias");
        botonModificarCategorias.setAlignmentX(0.5F);
        botonModificarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarCategoriasActionPerformed(evt);
            }
        });
        getContentPane().add(botonModificarCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

        botonModificarImagenes.setText("Modificar imagenes");
        botonModificarImagenes.setAlignmentX(0.5F);
        botonModificarImagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarImagenesActionPerformed(evt);
            }
        });
        getContentPane().add(botonModificarImagenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 180, -1));
        getContentPane().add(descripcionInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 320, -1));
        getContentPane().add(precioInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 120, -1));

        botonModificarUbicacion.setText("Modificar origen y destino");
        botonModificarUbicacion.setAlignmentX(0.5F);
        botonModificarUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarUbicacionActionPerformed(evt);
            }
        });
        getContentPane().add(botonModificarUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));

        actualizarDescripcion.setText("Guardar");
        actualizarDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarDescripcionActionPerformed(evt);
            }
        });
        getContentPane().add(actualizarDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));

        actualizarPrecio.setText("Guardar");
        actualizarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarPrecioActionPerformed(evt);
            }
        });
        getContentPane().add(actualizarPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

	@Override
	public void dispose() {
		super.dispose();
		padre.dispose();
	}

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
		servicio = ctrlProductos.infoServicio();
		descripcionInterfaz.setText(servicio.getDescripcion());
		precioInterfaz.setText(Float.toString(servicio.getPrecio()));
    }//GEN-LAST:event_formComponentShown

    private void actualizarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarPrecioActionPerformed
		try {
			ctrlProductos.cambiarPrecio(Float.parseFloat(precioInterfaz.getText()));
			JOptionPane.showMessageDialog(this, "El precio fue modificado", "Exito", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Por favor ingrese un precio valido", "Precio invalido", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(e.getMessage()); //debugging
		}
    }//GEN-LAST:event_actualizarPrecioActionPerformed

    private void actualizarDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarDescripcionActionPerformed
		ctrlProductos.cambiarDescripcion(descripcionInterfaz.getText());
		JOptionPane.showMessageDialog(this, "Descripción modificada con éxito", "Exito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_actualizarDescripcionActionPerformed

    private void botonModificarUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarUbicacionActionPerformed
		ModificacionUbicacion m = new ModificacionUbicacion(this, ctrlProductos.listarCiudades(), ctrlProductos);
		this.setVisible(false);
		getParent().add(m);
		m.setLocation(this.getLocation());
		m.setVisible(true);
    }//GEN-LAST:event_botonModificarUbicacionActionPerformed

    private void botonModificarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarCategoriasActionPerformed
		ModificacionCategorias m = new ModificacionCategorias(this, ctrlProductos);
		this.setVisible(false);
		getParent().add(m);
		m.setLocation(this.getLocation());
		m.setVisible(true);
    }//GEN-LAST:event_botonModificarCategoriasActionPerformed

    private void botonModificarImagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarImagenesActionPerformed
		ModificacionImagenes m = new ModificacionImagenes(this, ctrlProductos);
		this.setVisible(false);
		getParent().add(m);
		m.setLocation(this.getLocation());
		m.setVisible(true);

    }//GEN-LAST:event_botonModificarImagenesActionPerformed

	DTUbicacion nuevoOrigen;
	DTUbicacion nuevoDestino;
	ICtrlProductos ctrlProductos;
	DTServicio servicio;
	ActualizarServicio padre;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarDescripcion;
    private javax.swing.JButton actualizarPrecio;
    private javax.swing.JButton botonModificarCategorias;
    private javax.swing.JButton botonModificarImagenes;
    private javax.swing.JButton botonModificarUbicacion;
    private javax.swing.JTextField descripcionInterfaz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField precioInterfaz;
    // End of variables declaration//GEN-END:variables
}
