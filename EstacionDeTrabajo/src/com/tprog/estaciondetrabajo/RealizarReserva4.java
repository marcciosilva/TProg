/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTLineaReserva;
import com.tprog.logica.dt.DTMinPromocion;
import com.tprog.logica.dt.DTMinServicio;
import com.tprog.logica.dt.DTPromocion;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.dt.DTServicio;
import com.tprog.logica.interfaces.Fabrica;
import com.tprog.logica.interfaces.ICtrlProductos;
import com.tprog.logica.interfaces.ICtrlReservas;
import com.tprog.logica.interfaces.ICtrlUsuarios;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author marccio
 */
public class RealizarReserva4 extends javax.swing.JInternalFrame {
    //private Vector<String> listaServicios = new Vector<>();
    
    /**
     * Creates new form ReservasCliente
     * @param padre
     * @param <error>
     * @param ctrlReservas
     */
    public RealizarReserva4(RealizarReserva2 padre, ICtrlUsuarios ctrlUsuarios, ICtrlReservas ctrlReservas,
            boolean proveedorSeleccionado) {
        //asignación de atributos
        this.proveedorSeleccionado = proveedorSeleccionado;
        this.padre = padre;
        this.ctrlUsuarios = ctrlUsuarios;
        this.ctrlReservas = ctrlReservas;
        f = Fabrica.getInstance();
        this.ctrlProductos = f.getICtrlProductos();
        initComponents();
        setTitle("Realizar Reserva");
        //non-draggable
        BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
        for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
            basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
        }
        //obtengo los servicios a mostrar
        //si nunca elegí alguno, se muestran todos
        //si no, se muestran sólo los de ese proveedor
        Set<DTMinPromocion> setPromociones = this.ctrlReservas.listarPromociones();
        Set<DTMinPromocion> setPromocionesP = null;
        if (proveedorSeleccionado){
            //muestro solo los servicios del proveedor seleccionado
            setPromocionesP = this.ctrlReservas.listarPromocionesProveedor();
            //construyo un vector con la informacion a mostrar, porque
            //el comboBox solo funciona con Vector o List
            if (setPromocionesP != null) {
                for (DTMinPromocion dt : setPromocionesP) {
                    listaServicios.add(dt.getIdPromocion());
                }
            }
        } else {
            if (setPromociones != null) {
                for (DTMinPromocion dt : setPromociones) {
                    listaServicios.add(dt.getIdPromocion());
                }
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

        listaPromocionesInterfaz = new javax.swing.JComboBox(listaServicios);
        panelUsuario = new javax.swing.JScrollPane();
        detallePromocion = new javax.swing.JTextArea();
        botonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buttonVolver = new javax.swing.JButton();
        buttonAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPaneCantidad = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboBoxMeses1 = new javax.swing.JComboBox();
        comboBoxDias1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboBoxDias2 = new javax.swing.JComboBox();
        comboBoxMeses2 = new javax.swing.JComboBox();
        textFieldAnio1 = new javax.swing.JTextField();
        textFieldAnio2 = new javax.swing.JTextField();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(690, 435));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaPromocionesInterfaz.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                listaPromocionesInterfazInterfazComponentAdded(evt);
            }
        });
        listaPromocionesInterfaz.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaPromocionesInterfazItemStateChanged(evt);
            }
        });
        listaPromocionesInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaPromocionesInterfazInterfazActionPerformed(evt);
            }
        });
        getContentPane().add(listaPromocionesInterfaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 300, -1));

        detallePromocion.setEditable(false);
        detallePromocion.setColumns(20);
        detallePromocion.setLineWrap(true);
        detallePromocion.setRows(5);
        detallePromocion.setWrapStyleWord(true);
        panelUsuario.setViewportView(detallePromocion);

        getContentPane().add(panelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 269, 128));

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, -1, -1));

        jLabel1.setText("<html>Seleccione algun servicio del sistema para ver su información</html>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        buttonVolver.setText("Volver");
        buttonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolverActionPerformed(evt);
            }
        });
        getContentPane().add(buttonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, -1, -1));

        buttonAgregar.setText("Agregar");
        buttonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, -1, -1));

        jLabel2.setText("Cantidad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        jLabel3.setText("Fecha de Inicio");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        jLabel4.setText("Fecha de Fin");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, -1, -1));

        jScrollPane1.setViewportView(textPaneCantidad);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 122, -1));

        jLabel5.setText("Día");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        jLabel6.setText("Mes");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        jLabel7.setText("Año");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, -1, -1));

        comboBoxMeses1.setModel(new javax.swing.DefaultComboBoxModel(meses));
        getContentPane().add(comboBoxMeses1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 100, -1));

        comboBoxDias1.setModel(new javax.swing.DefaultComboBoxModel(dias));
        getContentPane().add(comboBoxDias1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 62, -1));

        jLabel8.setText("Día");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, -1, -1));

        jLabel9.setText("Mes");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, -1, -1));

        jLabel10.setText("Año");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, -1, -1));

        comboBoxDias2.setModel(new javax.swing.DefaultComboBoxModel(dias));
        getContentPane().add(comboBoxDias2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 50, -1));

        comboBoxMeses2.setModel(new javax.swing.DefaultComboBoxModel(meses));
        getContentPane().add(comboBoxMeses2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 100, -1));
        getContentPane().add(textFieldAnio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 80, -1));
        getContentPane().add(textFieldAnio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void listaPromocionesInterfazInterfazComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listaPromocionesInterfazInterfazComponentAdded
        
    }//GEN-LAST:event_listaPromocionesInterfazInterfazComponentAdded
    
    private void listaPromocionesInterfazItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaPromocionesInterfazItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listaPromocionesInterfazItemStateChanged
    
    private void listaPromocionesInterfazInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPromocionesInterfazInterfazActionPerformed
        String promocion = (String) listaPromocionesInterfaz.getSelectedItem();
        if (promocion != null) {
            //buscar servicio
            DTMinPromocion dt = null;
            promociones = ctrlReservas.listarPromociones();
            Iterator it = promociones.iterator();
            boolean found = false;
            while (it.hasNext() && !found) {
                //System.out.println("323");
                DTMinPromocion tmp = (DTMinPromocion) it.next();
                if (tmp.getIdPromocion().equals(promocion)){
                    dt = tmp; //es imposible que dt sea null al final del loop
                    //System.out.println("aaaasd");
                }
                
            }
            //ctrlReservas.seleccionarServicio(dt);
            ctrlProductos.seleccionarPromocion(dt);
            DTPromocion dtPromocion = ctrlProductos.infoPromocion();
            //imagenes
            detallePromocion.setVisible(true);
            detallePromocion.setText(dt.toString());
        }
    }//GEN-LAST:event_listaPromocionesInterfazInterfazActionPerformed
    
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed
    
    @Override
    public void dispose() {
        super.dispose();
        padre.dispose();
    }
    
    private void buttonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolverActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.padre.setVisible(true);
    }//GEN-LAST:event_buttonVolverActionPerformed
    
    private void buttonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarActionPerformed
        // TODO add your handling code here:
        String promocion = (String) listaPromocionesInterfaz.getSelectedItem();
        if (promocion != null) {
            //DTServicio dtS = ctrlUsuarios.infoServicio();
            //detalleServicio.setVisible(true);
            //detalleServicio.setText(dtS.toString());
            DTMinPromocion dtmP = ctrlProductos.infoMinPromocion();
            String proveedor = dtmP.getNicknameP();
            ctrlReservas.seleccionarProveedor(proveedor);
            ctrlReservas.seleccionarPromocion(dtmP);
            // qe wea ermano
            ctrlProductos.seleccionarPromocion(dtmP);
            //leer cantidad y fechas
            //validar cantidad
            boolean okCant = false;
            int cant = 0;
            String cantString = textPaneCantidad.getText();
            okCant = ((!cantString.isEmpty()) && ( cantString.matches("([0-9]|)+")));
            if (okCant){
                cant = Integer.parseInt(cantString);
            }
            //validar fechas
            int diaI = (Integer) comboBoxDias1.getSelectedItem();
            int diaF = (Integer) comboBoxDias2.getSelectedItem();
            int mesI = comboBoxMeses1.getSelectedIndex()+1;
            int mesF = comboBoxMeses2.getSelectedIndex()+1;
            String anioIString = textFieldAnio1.getText();
            String anioFString = textFieldAnio2.getText();
            int anioI = 0;
            int anioF = 0;
            int anio;
            boolean okAnioI = (((!anioIString.isEmpty()))&&(anioIString.matches("([0-9]|)+")));
            if (okAnioI)
                anioI = Integer.parseInt(anioIString);
            okAnioI = ((okAnioI) && ( anioI >= 2015));
            boolean okAnioF = (((!anioIString.isEmpty()))&&(anioFString.matches("([0-9]|)+")));
            if (okAnioF)
                anioF = Integer.parseInt(anioFString);
            okAnioF = ((okAnioF) && (okAnioI) && ( anioF >= anioI));
            //creo fechas
            if ((okCant) && (okAnioI)&&(okAnioF)){//todo ok
                Date fI = new Date(anioI, mesI, diaI);
                Date fF = new Date(anioF, mesF, diaF);
                ctrlReservas.ingresarLineaReserva(cant, fI, fF);
                DTReserva dtR = ctrlReservas.mostrarReservaTemporal();
                Set<DTLineaReserva> lineasReserva = dtR.getLineasReserva();
                this.setVisible(false);
                this.padre.setVisible(true);
            }
            else{ //hay algun dato erroneo
                String error = "";
                if (!okCant)
                    error = "La cantidad ingresada no es correcta.";
                else if ((!okAnioI)|| (!okAnioF))
                    error = "La fecha ingresada no es correcta";
                JOptionPane.showMessageDialog(this, "Error! " + error, "Realizar Reserva", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Seleccione una Promoción por favor. ", "Realizar Reserva", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_buttonAgregarActionPerformed
    
    
    
    
    //booleano que determina si lo que se agrega es el primer servicio o producto
    //es para saber cuando seleccionar proveedor o no
    
    private ICtrlUsuarios ctrlUsuarios;
    private ICtrlReservas ctrlReservas;
    private ICtrlProductos ctrlProductos;
    private boolean proveedorSeleccionado;
    Fabrica f;
    Set<DTMinPromocion> promociones;
    RealizarReserva2 padre;
    private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre",
        "Octubre", "Noviembre", "Diciembre"};
    private Integer[] dias = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};                     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton buttonAgregar;
    private javax.swing.JButton buttonVolver;
    private javax.swing.JComboBox comboBoxDias1;
    private javax.swing.JComboBox comboBoxDias2;
    private javax.swing.JComboBox comboBoxMeses1;
    private javax.swing.JComboBox comboBoxMeses2;
    private javax.swing.JTextArea detallePromocion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox listaPromocionesInterfaz;
    private Vector<String> listaServicios = new Vector<>();
    private javax.swing.JScrollPane panelUsuario;
    private javax.swing.JTextField textFieldAnio1;
    private javax.swing.JTextField textFieldAnio2;
    private javax.swing.JTextPane textPaneCantidad;
    // End of variables declaration//GEN-END:variables
}
