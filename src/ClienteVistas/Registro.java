package ClienteVistas;

import DTOs.UserDto;
import Modelo.UserModel;
import Utils.Global;
import javax.swing.JFrame;


public class Registro extends javax.swing.JFrame {

    private UserModel userModel;
    public JFrame parent;

    public Registro() throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        setTitle("TicketNet | Registro");

        userModel = new UserModel();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        icono_central_jlb = new javax.swing.JLabel();
        crear_jbtn1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        icono_central_jlb1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username_jtxtfld = new javax.swing.JTextField();
        password_jtxtfld = new javax.swing.JPasswordField();
        email_jtxtfld = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        crear_jbtn2 = new javax.swing.JButton();
        cerrar_jbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        icono_central_jlb.setBackground(new java.awt.Color(25, 28, 28));
        icono_central_jlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logofinal2.png"))); // NOI18N
        icono_central_jlb.setPreferredSize(new java.awt.Dimension(1024, 1536));

        crear_jbtn1.setBackground(new java.awt.Color(33, 72, 149));
        crear_jbtn1.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        crear_jbtn1.setForeground(new java.awt.Color(255, 255, 255));
        crear_jbtn1.setText("Crear");
        crear_jbtn1.setMaximumSize(new java.awt.Dimension(83, 31));
        crear_jbtn1.setMinimumSize(new java.awt.Dimension(83, 31));
        crear_jbtn1.setPreferredSize(new java.awt.Dimension(83, 31));
        crear_jbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_jbtn1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(45, 45, 45));
        jPanel2.setDoubleBuffered(false);

        icono_central_jlb1.setBackground(new java.awt.Color(25, 28, 28));
        icono_central_jlb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logofinal2.png"))); // NOI18N
        icono_central_jlb1.setPreferredSize(new java.awt.Dimension(1024, 1536));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Registro");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");

        username_jtxtfld.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        password_jtxtfld.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        password_jtxtfld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_jtxtfldActionPerformed(evt);
            }
        });

        email_jtxtfld.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Correo");

        crear_jbtn2.setBackground(new java.awt.Color(33, 72, 149));
        crear_jbtn2.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        crear_jbtn2.setForeground(new java.awt.Color(255, 255, 255));
        crear_jbtn2.setText("Crear");
        crear_jbtn2.setMaximumSize(new java.awt.Dimension(83, 31));
        crear_jbtn2.setMinimumSize(new java.awt.Dimension(83, 31));
        crear_jbtn2.setPreferredSize(new java.awt.Dimension(83, 31));
        crear_jbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_jbtn2ActionPerformed(evt);
            }
        });

        cerrar_jbtn.setBackground(new java.awt.Color(153, 153, 153));
        cerrar_jbtn.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        cerrar_jbtn.setForeground(new java.awt.Color(255, 255, 255));
        cerrar_jbtn.setText("Cerrar");
        cerrar_jbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar_jbtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 65, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icono_central_jlb1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(username_jtxtfld, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cerrar_jbtn)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(crear_jbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password_jtxtfld, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email_jtxtfld, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(icono_central_jlb1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(46, 46, 46)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_jtxtfld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_jtxtfld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_jtxtfld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cerrar_jbtn)
                    .addComponent(crear_jbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 430, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crear_jbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_jbtn1ActionPerformed

    }//GEN-LAST:event_crear_jbtn1ActionPerformed

    private void crear_jbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_jbtn2ActionPerformed
          try {
            String username = username_jtxtfld.getText();
            String password = new String(password_jtxtfld.getPassword());
            String email = email_jtxtfld.getText();
            
            UserDto user = new UserDto(0, username, password, email, (short) 2, 2);

            userModel.addUserFromClient(user);

            UserDto lastUser = userModel.getLastUserCreated();

            Global.user = lastUser;

            setVisible(false);

            new Cartelera().setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        };
    }//GEN-LAST:event_crear_jbtn2ActionPerformed

    private void cerrar_jbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar_jbtnActionPerformed
        setVisible(false);
        
        if (parent != null) {
            parent.setVisible(true);
        }
    }//GEN-LAST:event_cerrar_jbtnActionPerformed

    private void password_jtxtfldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_jtxtfldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_jtxtfldActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
//            logger.log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> new Registro().setVisible(true));
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar_jbtn;
    private javax.swing.JButton crear_jbtn1;
    private javax.swing.JButton crear_jbtn2;
    private javax.swing.JTextField email_jtxtfld;
    private javax.swing.JLabel icono_central_jlb;
    private javax.swing.JLabel icono_central_jlb1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField password_jtxtfld;
    private javax.swing.JTextField username_jtxtfld;
    // End of variables declaration//GEN-END:variables
}
