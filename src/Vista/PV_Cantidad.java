package Vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;
import Vista.Asientos;

public class PV_Cantidad extends javax.swing.JFrame {
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Asientos().setVisible(true);
        });
    }
    private static final Logger logger = Logger.getLogger(PV_Cantidad.class.getName());
    public static int boletosDisponibles = 0;
    private JSpinner jSpinnerAdultos;
    private JSpinner jSpinnerNinos;
    private JButton jButtonCalcular;

        @SuppressWarnings("unchecked")

    public PV_Cantidad() {
        initComponents();  
        setTitle("Cantidad de Boletos");
        setLocationRelativeTo(null);

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        icono_central_jlb = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(28, 28, 28));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(48, 48, 48));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 650));

        icono_central_jlb.setBackground(new java.awt.Color(25, 28, 28));
        icono_central_jlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logofinal2.png"))); 
        icono_central_jlb.setPreferredSize(new java.awt.Dimension(1024, 1536));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 22)); 
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Boletos de adulto $50");

        jSpinner1.setFont(new java.awt.Font("SansSerif", 0, 20)); 
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 300, 1));
        jSpinner1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jSpinner2.setFont(new java.awt.Font("SansSerif", 0, 20)); 
        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 300, 1));

        jLabel3.setFont(new java.awt.Font("Nimbus Sans", 0, 12)); 
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagenpelicula.jpg"))); 

        jButton2.setBackground(new java.awt.Color(49, 49, 49));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 20)); 
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(240, 74, 74));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 20)); 
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Siguiente");
        jButton1.setBorder(null);
        jButton1.setPreferredSize(new java.awt.Dimension(111, 39));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 22)); 
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Boletos de niño $30");

        jButton3.setBackground(new java.awt.Color(49, 49, 49));
        jButton3.setFont(new java.awt.Font("SansSerif", 1, 20)); 
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Calcular Total");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icono_central_jlb, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icono_central_jlb, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 570, 580));

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    int cantidadAdultos = (int) jSpinner1.getValue();
    int cantidadNiños = (int) jSpinner2.getValue();
    int boletosNuevos = cantidadAdultos + cantidadNiños;

    int yaSeleccionados = Utils.AsientosGlobales.getTotalSeleccionados();

    if (boletosNuevos == 0) {
        JOptionPane.showMessageDialog(this, "No has elegido cuántos boletos vas a comprar", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (yaSeleccionados + boletosNuevos > 48) {
        JOptionPane.showMessageDialog(this, "Solo puedes seleccionar un máximo de 48 asientos.\nActualmente has seleccionado: " + yaSeleccionados, "Límite alcanzado", JOptionPane.ERROR_MESSAGE);
        return;
    }

    PV_Cantidad.boletosDisponibles = boletosNuevos;

    try {
        new Asientos(boletosNuevos).setVisible(true); 
        this.dispose(); 
    } catch (Exception ex) {
        logger.log(Level.SEVERE, "Error al abrir la ventana de Asientos", ex);
        JOptionPane.showMessageDialog(this, "Ocurrió un error al abrir la ventana de asientos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            new ClienteVistas.panel().setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        int cantidadAdultos = (int) jSpinner1.getValue();
        int cantidadNinos = (int) jSpinner2.getValue();
        int total = (cantidadAdultos * 50) + (cantidadNinos * 30);
        JOptionPane.showMessageDialog(this, "Total a pagar: $" + total);
    }

    private void jLabel1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
    }               
   
    private javax.swing.JLabel icono_central_jlb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    
}
