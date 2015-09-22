/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tprog.estaciondetrabajo.ui;

import tprog.logica.dt.DTMinReserva;
import tprog.logica.interfaces.ICtrlProductos;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author marccio
 */
public class AltaCategoria extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReservasCliente
     */
    public AltaCategoria(ICtrlProductos ctrlProductos) {
        this.ctrlProductos = ctrlProductos;
        initComponents();
        cargarDatos();
		getRootPane().setDefaultButton(botonCrear);
    }

    private void cargarDatos() {
        DefaultMutableTreeNode raiz = ctrlProductos.listarCategorias();
        arbolCategorias.removeAll();
        arbolCategoriasModelo = new DefaultTreeModel(raiz);
        arbolCategorias.setModel(arbolCategoriasModelo);
        if (!casillaPadre.isSelected()) {
            arbolCategorias.clearSelection();
            arbolCategorias.setEnabled(false);
        }
//		arbolCategorias.updateUI();
        this.updateUI();
    }

    private boolean isWhiteSpace(String s) {
        return (s.matches("^\\s*$") || s.matches("^\\s.*"));
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
        casillaPadre = new javax.swing.JCheckBox();
        nombreCategoria = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolCategorias = new javax.swing.JTree();
        jLabel2 = new javax.swing.JLabel();
        botonCrear = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Alta de Categoría");
        setPreferredSize(new java.awt.Dimension(640, 480));
        setVisible(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("<html>Nombre de la nueva categoria</html>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        casillaPadre.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        casillaPadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casillaPadreActionPerformed(evt);
            }
        });
        getContentPane().add(casillaPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 180, 20, 20));

        nombreCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(nombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 220, 20));

        arbolCategorias.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                arbolCategoriasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(arbolCategorias);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 230, 300));

        jLabel2.setText("<html>Tiene una categoría padre</html>");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        botonCrear.setText("Crear");
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });
        getContentPane().add(botonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        cargarDatos();
    }//GEN-LAST:event_formComponentShown

    private void nombreCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreCategoriaActionPerformed

    private void arbolCategoriasValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_arbolCategoriasValueChanged
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) arbolCategorias.getLastSelectedPathComponent();
        if (nodo != null) {
            System.out.println("Seleccionaste " + nodo.toString());
        }
    }//GEN-LAST:event_arbolCategoriasValueChanged

    private void casillaPadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casillaPadreActionPerformed
        if (!casillaPadre.isSelected()) {
            arbolCategorias.clearSelection();
            arbolCategorias.setEnabled(false);
        } else {
            arbolCategorias.setEnabled(true);
        }
    }//GEN-LAST:event_casillaPadreActionPerformed

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {

        String categoriaNueva = nombreCategoria.getText();
        if (!isWhiteSpace(categoriaNueva)) {
            if (casillaPadre.isSelected()) {
                DefaultMutableTreeNode categoriaPadreNodo = (DefaultMutableTreeNode) arbolCategorias.getLastSelectedPathComponent();
                if (categoriaPadreNodo != null) {
                    String categoriaPadre = categoriaPadreNodo.toString();
                    if (!ctrlProductos.seleccionarCategoriaPadre(categoriaPadre)) {
                        JOptionPane.showMessageDialog(this, "Esa categoria tiene servicios asociados; escoja otra", "Categoria padre erronea", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (!ctrlProductos.idCategoriaDisponible(categoriaNueva)) {
                            JOptionPane.showMessageDialog(this, "El nombre escogido esta en uso; escoja otro", "Nombre invalido", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            ctrlProductos.altaCategoria();
                            JOptionPane.showMessageDialog(this, "La categoria fue creada con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                            this.dispose();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Seleccione una categoria", "Categoria no seleccionada", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                if (!ctrlProductos.idCategoriaDisponible(categoriaNueva)) {
                    JOptionPane.showMessageDialog(this, "El nombre escogido esta en uso; escoja otro", "Nombre invalido", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    ctrlProductos.seleccionarCategoriaPadre(null);
                    ctrlProductos.altaCategoria();
                    JOptionPane.showMessageDialog(this, "La categoria fue creada con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "El nombre de categoría ingresado no es válido", "Campo vacio", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    DefaultTreeModel arbolCategoriasModelo;
    ICtrlProductos ctrlProductos;
    Set<DTMinReserva> reservas;
    VerInformacionDeCliente padre;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolCategorias;
    private javax.swing.JButton botonCrear;
    private javax.swing.JCheckBox casillaPadre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreCategoria;
    // End of variables declaration//GEN-END:variables
}