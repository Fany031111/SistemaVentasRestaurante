/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemadeventa;

import Conexion.Conexion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import Conexion.Conexion;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fanny
 */
public class AgregarInventario extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form AgregarInventario
     */
    public static Conexion objeto = new Conexion();
    public static DefaultTableModel modelo;

    public AgregarInventario() {
        initComponents();
        setSize(1200, 740);
        this.setLocationRelativeTo(null);
        this.setTitle("Agregar Ingrediente - SISTEMA DE VENTAS");

        try {
            ResultSet respuesta = objeto.consultarRegistros("SELECT unidad from tb_unidad");
            while (respuesta.next()) {
                cbxunidad.addItem(respuesta.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgregarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        //FECHA Y HORA
        h1 = new Thread((Runnable) this);
        h1.start();
        //fecha
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        if (mes < 10 && dia < 10) {
            fechalbl.setText("0" + String.valueOf(dia) + "-0" + String.valueOf(mes) + "-" + String.valueOf(año));
        } else if (mes < 10) {
            fechalbl.setText(String.valueOf(dia) + "-0" + String.valueOf(mes) + "-" + String.valueOf(año));
        } else if (dia < 10) {
            fechalbl.setText("0" + String.valueOf(dia) + "-" + String.valueOf(mes) + "-" + String.valueOf(año));
        } else {
            fechalbl.setText(String.valueOf(dia) + "-" + String.valueOf(mes) + "-" + String.valueOf(año));
        }
        //termina fecha
        //termina hora

    }
    static int hora, minutos, segundos;
    Calendar calendario;
    static Thread h1;

    static public void calcula() {
        Calendar calendario = new GregorianCalendar();
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        hora = hora;
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            if (hora < 10 && minutos < 10 && segundos < 10) {
                horalbl.setText("0" + hora + ":0" + minutos + ":0" + segundos);
            } else if (hora < 10 && minutos < 10) {
                horalbl.setText("0" + hora + ":0" + minutos + ":" + segundos);
            } else if (hora < 10 && segundos < 10) {
                horalbl.setText("0" + hora + ":" + minutos + ":0" + segundos);
            } else if (minutos < 10 && segundos < 10) {
                horalbl.setText(hora + ":0" + minutos + ":0" + segundos);
            } else if (hora < 10) {
                horalbl.setText("0" + hora + ":" + minutos + ":" + segundos);
            } else if (minutos < 10) {
                horalbl.setText(hora + ":0" + minutos + ":" + segundos);
            } else if (segundos < 10) {
                horalbl.setText(hora + ":" + minutos + ":0" + segundos);
            } else {
                horalbl.setText(hora + ":" + minutos + ":" + segundos);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

    void limpiarDatos() {
        txtnombre.setText("");
        spcantidad.setValue(0);
        cbxunidad.setSelectedIndex(0);

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
        jLabel12 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        spcantidad = new javax.swing.JSpinner();
        cbxunidad = new javax.swing.JComboBox<>();
        btnagregar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        fechalbl = new javax.swing.JLabel();
        horalbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_nuevo_usuario = new javax.swing.JMenuItem();
        jMenuItem_gestionar_usuario = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem_nuevo_producto = new javax.swing.JMenuItem();
        jMenuItem_gestionar_producto = new javax.swing.JMenuItem();
        jMenuItem_actualizar_stock = new javax.swing.JMenuItem();
        jMenuItem_actualizar_stock1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem_nuevo_cliente = new javax.swing.JMenuItem();
        jMenuItem_gestionar_cliente = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem_nueva_categoria = new javax.swing.JMenuItem();
        jMenuItem_gestionar_categoria = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem_nueva_venta = new javax.swing.JMenuItem();
        jMenuItem_gestionar_ventas = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem_reportes_clientes = new javax.swing.JMenuItem();
        jMenuItem_reportes_productos = new javax.swing.JMenuItem();
        jMenuItem_reportes_ventas = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem_ver_historial = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem_cerrar_sesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Inventario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1200, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Para agregar un ingrediente al inventario, completa el siguiente formulario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 900, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nombre:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, -1, 40));

        txtnombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 320, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Unidad:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, -1, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cantidad:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, 30));
        getContentPane().add(spcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 90, 40));

        cbxunidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxunidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una unidad" }));
        cbxunidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxunidadActionPerformed(evt);
            }
        });
        getContentPane().add(cbxunidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 240, 30));

        btnagregar.setBackground(new java.awt.Color(204, 255, 204));
        btnagregar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, -1, 50));

        btnlimpiar.setBackground(new java.awt.Color(204, 255, 255));
        btnlimpiar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 550, -1, 50));

        fechalbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fechalbl.setForeground(new java.awt.Color(255, 255, 255));
        fechalbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(fechalbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 90, 20));

        horalbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        horalbl.setForeground(new java.awt.Color(255, 255, 255));
        horalbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(horalbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 620, 90, 20));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, 20, 20));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 650));

        jMenu1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 204, 255), null, null));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N
        jMenu1.setText("Usuario");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nuevo_usuario.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_nuevo_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo-cliente.png"))); // NOI18N
        jMenuItem_nuevo_usuario.setText("Nuevo Usuario");
        jMenuItem_nuevo_usuario.setPreferredSize(new java.awt.Dimension(240, 30));
        jMenuItem_nuevo_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nuevo_usuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_nuevo_usuario);

        jMenuItem_gestionar_usuario.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_gestionar_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuraciones.png"))); // NOI18N
        jMenuItem_gestionar_usuario.setText("Gestionar Usuarios");
        jMenuItem_gestionar_usuario.setPreferredSize(new java.awt.Dimension(240, 30));
        jMenuItem_gestionar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestionar_usuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_gestionar_usuario);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cliente.png"))); // NOI18N
        jMenuItem1.setText("Gestionar Puestos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 204, 255), null, null));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/producto.png"))); // NOI18N
        jMenu2.setText("Producto");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nuevo_producto.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_nuevo_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo-producto.png"))); // NOI18N
        jMenuItem_nuevo_producto.setText("Nuevo Producto");
        jMenuItem_nuevo_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nuevo_productoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_nuevo_producto);

        jMenuItem_gestionar_producto.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_gestionar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N
        jMenuItem_gestionar_producto.setText("Gestionar Producto");
        jMenuItem_gestionar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestionar_productoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_gestionar_producto);

        jMenuItem_actualizar_stock.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_actualizar_stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carrito.png"))); // NOI18N
        jMenuItem_actualizar_stock.setText("Agregar Stock");
        jMenuItem_actualizar_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_actualizar_stockActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_actualizar_stock);

        jMenuItem_actualizar_stock1.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_actualizar_stock1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/producto.png"))); // NOI18N
        jMenuItem_actualizar_stock1.setText("Gestionar Stock");
        jMenuItem_actualizar_stock1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_actualizar_stock1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_actualizar_stock1);

        jMenuBar1.add(jMenu2);

        jMenu3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 204, 255), null, null));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cliente.png"))); // NOI18N
        jMenu3.setText("Clientes");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nuevo_cliente.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_nuevo_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo-cliente.png"))); // NOI18N
        jMenuItem_nuevo_cliente.setText("Nuevo Cliente");
        jMenuItem_nuevo_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nuevo_clienteActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_nuevo_cliente);

        jMenuItem_gestionar_cliente.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_gestionar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cliente.png"))); // NOI18N
        jMenuItem_gestionar_cliente.setText("Gestionar Clientes");
        jMenuItem_gestionar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestionar_clienteActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_gestionar_cliente);

        jMenuBar1.add(jMenu3);

        jMenu4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 204, 255), null, null));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/categorias.png"))); // NOI18N
        jMenu4.setText("Categoría");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nueva_categoria.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_nueva_categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        jMenuItem_nueva_categoria.setText("Nueva Categoría");
        jMenuItem_nueva_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nueva_categoriaActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem_nueva_categoria);

        jMenuItem_gestionar_categoria.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_gestionar_categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/categorias.png"))); // NOI18N
        jMenuItem_gestionar_categoria.setText("Gestionar Categoría");
        jMenuItem_gestionar_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestionar_categoriaActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem_gestionar_categoria);

        jMenuBar1.add(jMenu4);

        jMenu5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 204, 255), null, null));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carrito.png"))); // NOI18N
        jMenu5.setText("Ventas");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu5.setMinimumSize(new java.awt.Dimension(120, 50));
        jMenu5.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nueva_venta.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_nueva_venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N
        jMenuItem_nueva_venta.setText("Nueva Venta");
        jMenuItem_nueva_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nueva_ventaActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem_nueva_venta);

        jMenuItem_gestionar_ventas.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_gestionar_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuraciones.png"))); // NOI18N
        jMenuItem_gestionar_ventas.setText("Gestionar Ventas");
        jMenuItem_gestionar_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestionar_ventasActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem_gestionar_ventas);

        jMenuBar1.add(jMenu5);

        jMenu6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 204, 255), null, null));
        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporte1.png"))); // NOI18N
        jMenu6.setText("Reportes");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu6.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_reportes_clientes.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_reportes_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporte1.png"))); // NOI18N
        jMenuItem_reportes_clientes.setText("Reportes Clientes");
        jMenuItem_reportes_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reportes_clientesActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_reportes_clientes);

        jMenuItem_reportes_productos.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_reportes_productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporte1.png"))); // NOI18N
        jMenuItem_reportes_productos.setText("Reportes Productos");
        jMenuItem_reportes_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reportes_productosActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_reportes_productos);

        jMenuItem_reportes_ventas.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_reportes_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporte1.png"))); // NOI18N
        jMenuItem_reportes_ventas.setText("Reportes Ventas");
        jMenuItem_reportes_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reportes_ventasActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_reportes_ventas);

        jMenuBar1.add(jMenu6);

        jMenu7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 204, 255), null, null));
        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/historial1.png"))); // NOI18N
        jMenu7.setText("Historial");
        jMenu7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu7.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_ver_historial.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_ver_historial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/historial1.png"))); // NOI18N
        jMenuItem_ver_historial.setText("Ver Historial");
        jMenuItem_ver_historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ver_historialActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem_ver_historial);

        jMenuBar1.add(jMenu7);

        jMenu8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 204, 255), null, null));
        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"))); // NOI18N
        jMenu8.setText("Cerrar Sesión");
        jMenu8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenu8.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_cerrar_sesion.setFont(new java.awt.Font("Maku", 1, 16)); // NOI18N
        jMenuItem_cerrar_sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"))); // NOI18N
        jMenuItem_cerrar_sesion.setText("Cerrar Sesion");
        jMenuItem_cerrar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_cerrar_sesionActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem_cerrar_sesion);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxunidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxunidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxunidadActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtnombre.getText())
                || Integer.parseInt(spcantidad.getValue().toString()) == 0
                || cbxunidad.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Error: llene los espacios correspondientes.");
        } else {
            try {
                int unidad = 0;
                ResultSet respuesta = objeto.consultarRegistros("Select idunidad from tb_unidad where unidad='" + cbxunidad.getSelectedItem().toString() + "'");
                respuesta.next();
                unidad = (respuesta.getInt("idunidad"));
                objeto.agregarIngrediente(txtnombre.getText(),
                        Integer.parseInt(spcantidad.getValue().toString()),
                        unidad);
                limpiarDatos();

            } catch (SQLException ex) {
                Logger.getLogger(AgregarInventario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        // TODO add your handling code here:
        limpiarDatos();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void jMenuItem_nuevo_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nuevo_usuarioActionPerformed
        // TODO add your handling code here:
        AgregarUsuario n = new AgregarUsuario();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_nuevo_usuarioActionPerformed

    private void jMenuItem_gestionar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestionar_usuarioActionPerformed
        // TODO add your handling code here:
        GestionarUsuarios n = new GestionarUsuarios();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_gestionar_usuarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        GestionarPuestos n = new GestionarPuestos();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem_nuevo_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nuevo_productoActionPerformed
        // TODO add your handling code here:
        AgregarProducto n = new AgregarProducto();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_nuevo_productoActionPerformed

    private void jMenuItem_gestionar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestionar_productoActionPerformed
        // TODO add your handling code here:
        GestionarProductos n = new GestionarProductos();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_gestionar_productoActionPerformed

    private void jMenuItem_actualizar_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_actualizar_stockActionPerformed
        // TODO add your handling code here:
        AgregarInventario ai = new AgregarInventario();
        ai.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_actualizar_stockActionPerformed

    private void jMenuItem_actualizar_stock1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_actualizar_stock1ActionPerformed
        // TODO add your handling code here:
        GestionarInventario n = new GestionarInventario();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_actualizar_stock1ActionPerformed

    private void jMenuItem_nuevo_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nuevo_clienteActionPerformed
        // TODO add your handling code here:
        AgregarCliente n = new AgregarCliente();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_nuevo_clienteActionPerformed

    private void jMenuItem_gestionar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestionar_clienteActionPerformed
        // TODO add your handling code here:
        GestionarClientes n = new GestionarClientes();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_gestionar_clienteActionPerformed

    private void jMenuItem_nueva_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nueva_categoriaActionPerformed
        AgregarCategoria n = new AgregarCategoria();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_nueva_categoriaActionPerformed

    private void jMenuItem_gestionar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestionar_categoriaActionPerformed
        // TODO add your handling code here:
        GestionarCategorias n = new GestionarCategorias();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_gestionar_categoriaActionPerformed

    private void jMenuItem_nueva_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nueva_ventaActionPerformed
        // TODO add your handling code here:
        AgregarVenta n = new AgregarVenta();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_nueva_ventaActionPerformed

    private void jMenuItem_gestionar_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestionar_ventasActionPerformed
        // TODO add your handling code here:
        GestionarVentas n = new GestionarVentas();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_gestionar_ventasActionPerformed

    private void jMenuItem_reportes_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reportes_clientesActionPerformed
        // TODO add your handling code here:
        ReporteClientes b = new ReporteClientes();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_reportes_clientesActionPerformed

    private void jMenuItem_reportes_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reportes_productosActionPerformed
        // TODO add your handling code here:
        ReporteProductos b = new ReporteProductos();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_reportes_productosActionPerformed

    private void jMenuItem_reportes_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reportes_ventasActionPerformed
        // TODO add your handling code here:
        ReporteVentas b = new ReporteVentas();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_reportes_ventasActionPerformed

    private void jMenuItem_ver_historialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ver_historialActionPerformed
        // TODO add your handling code here:
        Bitacora b = new Bitacora();
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_ver_historialActionPerformed

    private void jMenuItem_cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_cerrar_sesionActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.YES_NO_OPTION;
        int resul = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Cerrar sesión", a);
        if (resul == 0) {
            Login l = new Login();
            l.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem_cerrar_sesionActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JComboBox<String> cbxunidad;
    public static javax.swing.JLabel fechalbl;
    private javax.swing.JLabel fondo;
    public static javax.swing.JLabel horalbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem_actualizar_stock;
    private javax.swing.JMenuItem jMenuItem_actualizar_stock1;
    private javax.swing.JMenuItem jMenuItem_cerrar_sesion;
    private javax.swing.JMenuItem jMenuItem_gestionar_categoria;
    private javax.swing.JMenuItem jMenuItem_gestionar_cliente;
    private javax.swing.JMenuItem jMenuItem_gestionar_producto;
    private javax.swing.JMenuItem jMenuItem_gestionar_usuario;
    private javax.swing.JMenuItem jMenuItem_gestionar_ventas;
    private javax.swing.JMenuItem jMenuItem_nueva_categoria;
    private javax.swing.JMenuItem jMenuItem_nueva_venta;
    private javax.swing.JMenuItem jMenuItem_nuevo_cliente;
    private javax.swing.JMenuItem jMenuItem_nuevo_producto;
    private javax.swing.JMenuItem jMenuItem_nuevo_usuario;
    private javax.swing.JMenuItem jMenuItem_reportes_clientes;
    private javax.swing.JMenuItem jMenuItem_reportes_productos;
    private javax.swing.JMenuItem jMenuItem_reportes_ventas;
    private javax.swing.JMenuItem jMenuItem_ver_historial;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner spcantidad;
    public static javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
