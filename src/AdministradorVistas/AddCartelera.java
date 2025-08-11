/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AdministradorVistas;

import Builders.CarteleraBuilder;
import DTOs.CarteleraDto;
import Modelo.CarteleraModel;
import com.raven.datechooser.DateChooser;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class AddCartelera extends javax.swing.JFrame {
    
    DateChooser fromDateChooser = new DateChooser();
    DateChooser toDateChooser = new DateChooser();
    
    CarteleraModel carteleraModel;
    
    JFrame parent = null;
    
    public AddCartelera() throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        
        carteleraModel = new CarteleraModel();
        
        setTitle("TicketNet | Agregar cartelera");
        
        SimpleDateFormat formatForDates = new SimpleDateFormat("yyyy-MM-dd");
        
        fromDateChooser.setTextField(from_date_txtfield1);
        fromDateChooser.setLabelCurrentDayVisible(true);
        fromDateChooser.setDateSelectionMode(DateChooser.DateSelectionMode.SINGLE_DATE_SELECTED);
        
        toDateChooser.setTextField(to_date_txtfield);
        toDateChooser.setLabelCurrentDayVisible(false);
        toDateChooser.setDateSelectionMode(DateChooser.DateSelectionMode.SINGLE_DATE_SELECTED); 
        
        to_date_txtfield.setText("");
        to_date_txtfield.setText("");
        
        fromDateChooser.setDateFormat(formatForDates);
        toDateChooser.setDateFormat(formatForDates);
        
        boolean isCartelerasActivated = !carteleraModel.isThereACarteleraActivated();

        isActivated_chkbx.setSelected(isCartelerasActivated);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        title_jlbl = new javax.swing.JLabel();
        section1_jlbl = new javax.swing.JLabel();
        date_range_jlbl1 = new javax.swing.JLabel();
        isActivated_chkbx = new javax.swing.JCheckBox();
        date_range_jlbl = new javax.swing.JLabel();
        to_date_txtfield = new javax.swing.JTextField();
        cerrar_jbtn = new javax.swing.JButton();
        crear_jbtn = new javax.swing.JButton();
        icono_central_jlb = new javax.swing.JLabel();
        from_date_txtfield1 = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(45, 45, 45));

        title_jlbl.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        title_jlbl.setForeground(new java.awt.Color(255, 255, 255));
        title_jlbl.setText("Creación de Cartelera");

        section1_jlbl.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        section1_jlbl.setForeground(new java.awt.Color(255, 255, 255));
        section1_jlbl.setText("Duración");

        date_range_jlbl1.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        date_range_jlbl1.setForeground(new java.awt.Color(255, 255, 255));
        date_range_jlbl1.setText("Desde");

        isActivated_chkbx.setBackground(new java.awt.Color(45, 45, 45));
        isActivated_chkbx.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        isActivated_chkbx.setForeground(new java.awt.Color(255, 255, 255));
        isActivated_chkbx.setText("Activado");
        isActivated_chkbx.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        isActivated_chkbx.setEnabled(false);
        isActivated_chkbx.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                isActivated_chkbxAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        isActivated_chkbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isActivated_chkbxActionPerformed(evt);
            }
        });

        date_range_jlbl.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        date_range_jlbl.setForeground(new java.awt.Color(255, 255, 255));
        date_range_jlbl.setText("Hasta");

        cerrar_jbtn.setBackground(new java.awt.Color(153, 153, 153));
        cerrar_jbtn.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        cerrar_jbtn.setForeground(new java.awt.Color(255, 255, 255));
        cerrar_jbtn.setText("Cerrar");
        cerrar_jbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar_jbtnActionPerformed(evt);
            }
        });

        crear_jbtn.setBackground(new java.awt.Color(33, 72, 149));
        crear_jbtn.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        crear_jbtn.setForeground(new java.awt.Color(255, 255, 255));
        crear_jbtn.setText("Crear");
        crear_jbtn.setMaximumSize(new java.awt.Dimension(83, 31));
        crear_jbtn.setMinimumSize(new java.awt.Dimension(83, 31));
        crear_jbtn.setPreferredSize(new java.awt.Dimension(83, 31));
        crear_jbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_jbtnActionPerformed(evt);
            }
        });

        icono_central_jlb.setBackground(new java.awt.Color(25, 28, 28));
        icono_central_jlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logofinal2.png"))); // NOI18N
        icono_central_jlb.setPreferredSize(new java.awt.Dimension(1024, 1536));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(icono_central_jlb, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title_jlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(section1_jlbl)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(date_range_jlbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(from_date_txtfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cerrar_jbtn)
                        .addGap(57, 57, 57)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(isActivated_chkbx, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(date_range_jlbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(to_date_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(crear_jbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(80, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(icono_central_jlb, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(title_jlbl)))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isActivated_chkbx)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(date_range_jlbl)
                            .addComponent(date_range_jlbl1)
                            .addComponent(from_date_txtfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(to_date_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(section1_jlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(55, 55, 55))))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cerrar_jbtn)
                    .addComponent(crear_jbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crear_jbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_jbtnActionPerformed
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 
        LocalDate fromDate = LocalDate.parse(to_date_txtfield.getText(), dateFormatter);
        LocalDate toDate = LocalDate.parse(to_date_txtfield.getText(), dateFormatter);
        int isActivated = isActivated_chkbx.isSelected() ?  1 : 0;
        
        CarteleraDto cartelera = new CarteleraBuilder()
                                     .withIsActivated(isActivated)
                                     .withFromDate(fromDate)
                                     .withToDate(toDate)
                                     .build();
        
        try {
            carteleraModel.addCartelera(cartelera);
        } catch(Exception e) {
        }
        
        JOptionPane.showMessageDialog(this, "Se ha creado una cartelera exítosamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        closeWindow();
    }//GEN-LAST:event_crear_jbtnActionPerformed

    public void closeWindow() {
        setVisible(false);
        
        if (parent != null) {
            parent.setVisible(true);
        }
    }
    
    private void cerrar_jbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar_jbtnActionPerformed
        closeWindow();
    }//GEN-LAST:event_cerrar_jbtnActionPerformed

    private void isActivated_chkbxAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_isActivated_chkbxAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_isActivated_chkbxAncestorAdded

    private void isActivated_chkbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isActivated_chkbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isActivated_chkbxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar_jbtn;
    private javax.swing.JButton crear_jbtn;
    private javax.swing.JLabel date_range_jlbl;
    private javax.swing.JLabel date_range_jlbl1;
    private javax.swing.JTextField from_date_txtfield1;
    private javax.swing.JLabel icono_central_jlb;
    private javax.swing.JCheckBox isActivated_chkbx;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel section1_jlbl;
    private javax.swing.JLabel title_jlbl;
    private javax.swing.JTextField to_date_txtfield;
    // End of variables declaration//GEN-END:variables
}
