/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tprog.estaciondetrabajo;

import com.tprog.logica.dt.DTLineaReserva;
import com.tprog.logica.dt.DTReserva;
import com.tprog.logica.interfaces.ICtrlReservas;
import com.tprog.logica.interfaces.ICtrlUsuarios;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author ignacio.prandi
 */
public class RealizarReserva2 extends javax.swing.JInternalFrame {
    private final RealizarReserva1 padre;
    private final ICtrlUsuarios ctrlUsuarios;
    private final ICtrlReservas ctrlReservas;
    private Vector<String> listaLineasReserva = new Vector<>();

    /**
     * Creates new form RealizarReserva2
     * @param padre
     * @param ctrlUsuarios
     * @param ctrlReservas
     */
    public RealizarReserva2(RealizarReserva1 padre, ICtrlUsuarios ctrlUsuarios, ICtrlReservas ctrlReservas) {
        initComponents();
        setTitle("Realizar Reserva");
        this.padre = padre;
        this.ctrlUsuarios = ctrlUsuarios;
        this.ctrlReservas = ctrlReservas;
        BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
        for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
            basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
        }        
    }
    
    void cargarDatos() {
        //pedir controlador
        DTReserva dtR = ctrlReservas.mostrarReservaTemporal();
        String precio = Float.toString(dtR.getPrecioTotal());
        textPanePrecio.setText(precio);
        //falta fecha
        
        //listaClientes
//        int contador = 0;
       Set<DTLineaReserva> lineasReserva = dtR.getLineasReserva();
       Iterator it = lineasReserva.iterator();
       int i = 1;
       while (it.hasNext()) {
           hashLineasReserva.put(i, (DTLineaReserva) it.next());
           i++;
       }
       Iterator it2 = hashLineasReserva.entrySet().iterator();
       while (it2.hasNext()) {
           Map.Entry pair = (Map.Entry)it.next();
           listaLineasReserva.add(Integer.toString((Integer) pair.getKey()));
       }
       /*
       
       if (lineasReserva != null) {
            for (DTLineaReserva dt : lineasReserva) {
                listaLineasReserva.add(Integer.toString(contador));
                //textAreaServicios.setText((dt.toString()));
                contador++;
            }
        }
       */
        /*for (int i = 1; i <= lineasReserva.size(); i++){
            for (DTLineaReserva linea : lineasReserva){
                textAreaServicios.setText((linea.toString()));
            }
         */   
        
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
        buttonAgregarReserva = new javax.swing.JButton();
        buttonAgregarPromocion = new javax.swing.JButton();
        buttonAtras = new javax.swing.JButton();
        buttonConfirmar = new javax.swing.JButton();
        buttonSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPanePrecio = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        listaServiciosInterfaz = new javax.swing.JComboBox(listaLineasReserva);
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPaneFecha = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaServicios = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(690, 435));

        jLabel1.setText("Ingrese los datos de la Reserva");

        buttonAgregarReserva.setText("Agregar Servicio");
        buttonAgregarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarReservaActionPerformed(evt);
            }
        });

        buttonAgregarPromocion.setText("Agregar Promocion");
        buttonAgregarPromocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarPromocionActionPerformed(evt);
            }
        });

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

        jLabel2.setText("Ver Servicios disponibles");

        jLabel3.setText("Ver Promociones disponibles");

        jLabel4.setText("Precio total:");

        textPanePrecio.setEditable(false);
        jScrollPane1.setViewportView(textPanePrecio);

        jLabel5.setText("Servicios y Promociones de la Reserva");

        listaServiciosInterfaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaServiciosInterfazActionPerformed(evt);
            }
        });

        jLabel6.setText("Fecha:");

        textPaneFecha.setEditable(false);
        jScrollPane2.setViewportView(textPaneFecha);

        textAreaServicios.setColumns(20);
        textAreaServicios.setRows(5);
        jScrollPane3.setViewportView(textAreaServicios);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setText("Datos actuales de la Reserva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(buttonAtras)
                .addGap(42, 42, 42)
                .addComponent(buttonConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonSalir)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonAgregarReserva)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(buttonAgregarPromocion)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listaServiciosInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonAgregarReserva)
                                .addComponent(buttonAgregarPromocion))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(jLabel5)
                                    .addGap(3, 3, 3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel6))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(listaServiciosInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(42, 42, 42))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(69, 69, 69)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonSalir)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonAtras)
                            .addComponent(buttonConfirmar))
                        .addGap(60, 60, 60))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAgregarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarReservaActionPerformed
        // TODO add your handling code here:
        RealizarReserva3 rr3 = new RealizarReserva3(this, ctrlUsuarios, ctrlReservas);
        getContentPane().add(rr3, BorderLayout.CENTER);
                rr3.setBounds(10, 10, 100, 100);
                this.setVisible(false);
                rr3.setVisible(true);
                getParent().add(rr3); 
    }//GEN-LAST:event_buttonAgregarReservaActionPerformed

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_buttonSalirActionPerformed

    private void buttonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtrasActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.padre.setVisible(true);
    }//GEN-LAST:event_buttonAtrasActionPerformed

    private void buttonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonConfirmarActionPerformed

    private void buttonAgregarPromocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarPromocionActionPerformed
        // TODO add your handling code here:
        RealizarReserva4 rr4 = new RealizarReserva4(this);
        getContentPane().add(rr4, BorderLayout.CENTER);
                rr4.setBounds(10, 10, 100, 100);
                this.setVisible(false);
                rr4.setVisible(true);
                getParent().add(rr4); 
    }//GEN-LAST:event_buttonAgregarPromocionActionPerformed

    private void listaServiciosInterfazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaServiciosInterfazActionPerformed
        // TODO add your handling code here:
        String servicio = (String) listaServiciosInterfaz.getSelectedItem();
        if (servicio != null){
            int indice = Integer.parseInt(servicio);
            DTLineaReserva dt = (DTLineaReserva) hashLineasReserva.get(indice);
            textAreaServicios.setText(dt.toString());

        }
    }//GEN-LAST:event_listaServiciosInterfazActionPerformed
    private void formComponentShown(java.awt.event.ComponentEvent evt) {                                    
        //pido de nuevo los datos en caso de que hayan cambiado
        cargarDatos();
    }        

    Map<Integer, DTLineaReserva> hashLineasReserva = new HashMap<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAgregarPromocion;
    private javax.swing.JButton buttonAgregarReserva;
    private javax.swing.JButton buttonAtras;
    private javax.swing.JButton buttonConfirmar;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox listaServiciosInterfaz;
    private javax.swing.JTextArea textAreaServicios;
    private javax.swing.JTextPane textPaneFecha;
    private javax.swing.JTextPane textPanePrecio;
    // End of variables declaration//GEN-END:variables
    
}
