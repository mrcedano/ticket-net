package Vista;

import DTOs.UserDto;
import Modelo.UserModel;
import javax.swing.JOptionPane;
import Utils.EmailSender;
import java.awt.Color;

public class OlvidoContrasenia extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(OlvidoContrasenia.class.getName());

    public OlvidoContrasenia() {
        initComponents();
        Regresar.setText("<html><u>Regresar al inicio</u></html>");
        Regresar.setForeground(Color.white);
        Regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            new InicioSesion().setVisible(true);
            dispose();
        }       
    });
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        icono_central_jlb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Regresar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(32, 72, 149), 1, true));
        jTextField1.setPreferredSize(new java.awt.Dimension(2, 35));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 340, 40));

        jLabel3.setText("¿Se te olvidó la contraseña? Inserta tu correo electrónico");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 185, 0, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 26)); 
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("¿Se te olvidó la contraseña?");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 13)); 
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("<html>al presionar \"Restablecer Contraseña\" se te enviará<br>un correo con el link para restablecer la contraseña.</html>   ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, 30));

        icono_central_jlb.setBackground(new java.awt.Color(25, 28, 28));
        icono_central_jlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logofinal2.png"))); 
        icono_central_jlb.setPreferredSize(new java.awt.Dimension(1024, 1536));
        getContentPane().add(icono_central_jlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, -10, 220, 147));

        jPanel1.setBackground(new java.awt.Color(48, 48, 48));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 20)); 
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Correo Electrónico ");

        jButton1.setBackground(new java.awt.Color(32, 72, 149));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 20)); 
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Restabalecer Contraseña");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Regresar.setText("jLabel1");
        Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegresarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(Regresar)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Regresar)
                .addGap(30, 30, 30))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 470, 500));

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    String correoDestino = jTextField1.getText().trim();

    if (correoDestino.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingresa un correo electrónico.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (!esCorreoValido(correoDestino)) {
        JOptionPane.showMessageDialog(this, "El correo no tiene un formato válido o no es de un dominio aceptado.", "Correo inválido", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String idStr = JOptionPane.showInputDialog(this, "¿Cuál es tu ID?");
    if (idStr == null || idStr.trim().isEmpty()) return;

    int id;
    try {
        id = Integer.parseInt(idStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String rolStr = JOptionPane.showInputDialog(this, "¿Cuál es tu rol?\n1 = Administrador\n2 = Cajero\n3 = Cliente");
    if (rolStr == null || rolStr.trim().isEmpty()) return;

    int rol;
    try {
        rol = Integer.parseInt(rolStr);
        if (rol < 1 || rol > 3) throw new NumberFormatException();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Rol inválido. Debe ser 1, 2 o 3.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        UserModel userModel = new UserModel();
        UserDto user = userModel.findUserByIdAndRole(id, rol);

        if (user == null) {
            JOptionPane.showMessageDialog(this, "No se encontró un usuario con ese ID y rol.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String asunto = "Recuperación de contraseña";
        String mensaje = "Hola,\n\n"
                + "Has solicitado recuperar tu contraseña.\n\n"
                + "Tu usuario es: " + user.getUsername() + "\n"
                + "Tu contraseña es: " + user.getPassword() + "\n\n"
                + "Recomendamos cambiarla después de iniciar sesión.\n\n"
                + "Saludos,\nTicketNet";

        Utils.EmailSender.enviarCorreo(correoDestino, asunto, mensaje);

        new CorreoRecuperacionEnviado().setVisible(true);
        this.dispose();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al enviar correo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }

    private void RegresarMouseClicked(java.awt.event.MouseEvent evt) {

    }

        private boolean esCorreoValido(String correo) {
    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
    java.util.regex.Matcher matcher = pattern.matcher(correo);

    if (!matcher.matches()) return false;

    String dominio = matcher.group(1).toLowerCase();
    String[] permitidos = {"gmail.com", "hotmail.com", "outlook.com", "yahoo.com", "icloud.com", "live.com"};

    for (String d : permitidos) {
        if (dominio.equals(d)) return true;
    }

    return false;
}

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
        
        java.awt.EventQueue.invokeLater(() -> new OlvidoContrasenia().setVisible(true));
    }

    private javax.swing.JLabel Regresar;
    private javax.swing.JLabel icono_central_jlb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    
}
