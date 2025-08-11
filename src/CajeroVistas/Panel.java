package CajeroVistas;

import JObjects.SideBarBuilder;
import Modelo.CarteleraModel;
import Utils.Global;
import Vista.InicioSesion;
import Vista.MiCuenta;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class Panel extends javax.swing.JFrame {
    
    private final CarteleraModel carteleraModel;
    
    public Panel() throws Exception {
        initComponents();

        setLocationRelativeTo(null);
        setTitle("TicketNet | Panel de Cajero");

        carteleraModel = new CarteleraModel();
        
        if (carteleraModel.getNumberOfCartelerasActivated() <= 0) {
            JOptionPane.showMessageDialog(this, "No hay ninguna cartelera activa, por favor notificar a un administrador", "Mensaje", JOptionPane.WARNING_MESSAGE);
            
            return;
        }
        
        title_jlbl.setText(title_jlbl.getText() + " " + Global.user.getUsername() + "!");

        JPanel sidebar = new SideBarBuilder()
                .addOption("Panel", () -> {
                })
                .addOption("Mi cuenta", () -> {
                    try {
                        new MiCuenta(Global.user).setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    setVisible(false);
                })
                .addOption("Cerrar Sesión", () -> {
                    Global.destroySession();

                    new InicioSesion().setVisible(true);
                    setVisible(false);
                })
                .build(0, 0, 167, 300);

        getContentPane().add(sidebar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        venta_boleto_jbtn = new javax.swing.JButton();
        title_jlbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        venta_boleto_jbtn.setText("Venta");
        venta_boleto_jbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venta_boleto_jbtnActionPerformed(evt);
            }
        });

        title_jlbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title_jlbl.setText("¡Bienvenido, ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(title_jlbl)
                    .addComponent(venta_boleto_jbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(title_jlbl)
                .addGap(61, 61, 61)
                .addComponent(venta_boleto_jbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void venta_boleto_jbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venta_boleto_jbtnActionPerformed
        try {
            setVisible(false);

            Venta panelVenta = new Venta();

            panelVenta.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

            panelVenta.setVisible(true);

            panelVenta.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    panelVenta.setVisible(false);
                    
                    setVisible(true);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_venta_boleto_jbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel title_jlbl;
    private javax.swing.JButton venta_boleto_jbtn;
    // End of variables declaration//GEN-END:variables
}
