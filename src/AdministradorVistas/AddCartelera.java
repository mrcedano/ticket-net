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

/**
 *
 * @author cedsc
 */
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
        
        fromDateChooser.setTextField(from_date_txtfield);
        fromDateChooser.setLabelCurrentDayVisible(true);
        fromDateChooser.setDateSelectionMode(DateChooser.DateSelectionMode.SINGLE_DATE_SELECTED);
        
        toDateChooser.setTextField(to_date_txtfield);
        toDateChooser.setLabelCurrentDayVisible(false);
        toDateChooser.setDateSelectionMode(DateChooser.DateSelectionMode.SINGLE_DATE_SELECTED); 
        
        from_date_txtfield.setText("");
        to_date_txtfield.setText("");
        
        fromDateChooser.setDateFormat(formatForDates);
        toDateChooser.setDateFormat(formatForDates);
        
        boolean isCartelerasActivated = !carteleraModel.isThereACarteleraActivated();

        isActivated_chkbx.setSelected(isCartelerasActivated);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_jlbl = new javax.swing.JLabel();
        cerrar_jbtn = new javax.swing.JButton();
        crear_jbtn = new javax.swing.JButton();
        from_date_txtfield = new javax.swing.JTextField();
        date_range_jlbl = new javax.swing.JLabel();
        to_date_txtfield = new javax.swing.JTextField();
        date_range_jlbl1 = new javax.swing.JLabel();
        section1_jlbl = new javax.swing.JLabel();
        isActivated_chkbx = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_jlbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title_jlbl.setText("Creación de Cartelera");

        cerrar_jbtn.setText("Cerrar");
        cerrar_jbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar_jbtnActionPerformed(evt);
            }
        });

        crear_jbtn.setText("Crear");
        crear_jbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_jbtnActionPerformed(evt);
            }
        });

        date_range_jlbl.setText("Hasta");

        date_range_jlbl1.setText("Desde");

        section1_jlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        section1_jlbl.setText("Duración");

        isActivated_chkbx.setText("Activado");
        isActivated_chkbx.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(title_jlbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(cerrar_jbtn)
                        .addGap(18, 18, 18)
                        .addComponent(crear_jbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(from_date_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_range_jlbl1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date_range_jlbl)
                            .addComponent(to_date_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(section1_jlbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(isActivated_chkbx)
                        .addGap(60, 60, 60))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(title_jlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(section1_jlbl)
                    .addComponent(isActivated_chkbx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date_range_jlbl)
                    .addComponent(date_range_jlbl1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(to_date_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(from_date_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cerrar_jbtn)
                    .addComponent(crear_jbtn))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crear_jbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_jbtnActionPerformed
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 
        LocalDate fromDate = LocalDate.parse(from_date_txtfield.getText(), dateFormatter);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar_jbtn;
    private javax.swing.JButton crear_jbtn;
    private javax.swing.JLabel date_range_jlbl;
    private javax.swing.JLabel date_range_jlbl1;
    private javax.swing.JTextField from_date_txtfield;
    private javax.swing.JCheckBox isActivated_chkbx;
    private javax.swing.JLabel section1_jlbl;
    private javax.swing.JLabel title_jlbl;
    private javax.swing.JTextField to_date_txtfield;
    // End of variables declaration//GEN-END:variables
}
