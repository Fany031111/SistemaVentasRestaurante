/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemadeventa;

import Conexion.Conexion;
import javax.swing.table.DefaultTableModel;
import Conexion.Conexion;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import Conexion.Conexion;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fanny
 */
public class BuscarCliente extends javax.swing.JFrame {

    /**
     * Creates new form BuscarCliente
     */
    public static Conexion objeto = new Conexion();
    public static DefaultTableModel modelo;

    public BuscarCliente() {
        initComponents();
        this.setSize(new Dimension(580, 630));

        this.setLocationRelativeTo(null);
        this.setTitle("Buscar cliente - SISTEMA DE VENTAS");
        scroll1.setOpaque(false); // Hacer transparente el JScrollPane
        scroll1.getViewport().setOpaque(false); // Hacer transparente el JViewport
        scroll1.setBorder(null);

        try {

            ConsultarDatos(txtnombre.getText(), txtape.getText());

        } catch (SQLException ex) {
            Logger.getLogger(GestionarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void ConsultarDatos(String nombre, String ape) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet respuesta = null;
        try {
            // Reutilizar la conexión estática
            Connection cx = objeto.conexionReturn();

            // Preparar la consulta base
            StringBuilder query = new StringBuilder("SELECT idcliente, nombre, apellido FROM tb_cliente WHERE 1=1");
            List<Object> params = new ArrayList<>();

            // Agregar filtros según los parámetros
            if (!nombre.equals("")) {
                query.append(" AND nombre LIKE ?");
                params.add(nombre + "%");
            }

            if (!ape.equals("")) {
                query.append(" AND apellido LIKE ?");
                params.add(ape + "%");
            }

            // Preparar la consulta SQL
            stmt = cx.prepareStatement(query.toString());
            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }

            respuesta = stmt.executeQuery();

            // Modelo para la tabla de aluminio
            Object[] usuarios = new Object[3];
            modelo = (DefaultTableModel) tproducto.getModel();
            while (respuesta.next()) {
                usuarios[0] = respuesta.getInt(1);
                usuarios[1] = respuesta.getString(2);
                usuarios[2] = respuesta.getString(3);

                modelo.addRow(usuarios);
            }
            tproducto.setModel(modelo);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos, pero no la conexión
            if (respuesta != null) try {
                respuesta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtape = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        limpiarfiltro = new javax.swing.JButton();
        scroll1 = new javax.swing.JScrollPane();
        tproducto = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Buscar cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 560, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Apellidos:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombres:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 30));

        txtape.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtape.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtapeKeyReleased(evt);
            }
        });
        getContentPane().add(txtape, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 370, 30));

        txtnombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
        });
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 370, 30));

        limpiarfiltro.setBackground(new java.awt.Color(255, 204, 204));
        limpiarfiltro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        limpiarfiltro.setText("x");
        limpiarfiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarfiltroActionPerformed(evt);
            }
        });
        getContentPane().add(limpiarfiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 40, 30));

        tproducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre(s)", "Apellidos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tproducto.setRowHeight(30);
        tproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tproductoMouseClicked(evt);
            }
        });
        scroll1.setViewportView(tproducto);

        getContentPane().add(scroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 500, 300));

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Seleccionar cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, -1, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarfiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarfiltroActionPerformed
        // TODO add your handling code here:

        txtnombre.setText("");
        txtape.setText("");
    }//GEN-LAST:event_limpiarfiltroActionPerformed

    private void tproductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tproductoMouseClicked
        // TODO add your handling code here:
        idcliente = Integer.parseInt(tproducto.getValueAt(tproducto.getSelectedRow(), 0).toString());
        nombrecliente = (tproducto.getValueAt(tproducto.getSelectedRow(), 1).toString());

    }//GEN-LAST:event_tproductoMouseClicked
    public static int idcliente = 0;
    public static String nombrecliente = "";
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AgregarVenta.txtcliente.setText(nombrecliente);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    void limpiarDatosTabla() {
        int fila = tproducto.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        // TODO add your handling code here:
        try {
            limpiarDatosTabla();
            ConsultarDatos(txtnombre.getText(), txtape.getText());

        } catch (SQLException ex) {
            Logger.getLogger(GestionarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtnombreKeyReleased

    private void txtapeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapeKeyReleased
        // TODO add your handling code here:
        try {
            limpiarDatosTabla();
            ConsultarDatos(txtnombre.getText(), txtape.getText());

        } catch (SQLException ex) {
            Logger.getLogger(GestionarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtapeKeyReleased

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
            java.util.logging.Logger.getLogger(BuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton limpiarfiltro;
    private static javax.swing.JScrollPane scroll1;
    public static javax.swing.JTable tproducto;
    private javax.swing.JTextField txtape;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
