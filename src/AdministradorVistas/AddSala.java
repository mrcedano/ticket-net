/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AdministradorVistas;

import Builders.SalasBuilder;
import DTOs.SalaDto;
import Modelo.SalaModel;
import javax.swing.JFrame;

/**
 *
 * @author cedsc
 */
public class AddSala extends javax.swing.JFrame {

    public JFrame parent = null;
    private SalaModel salaModel = null;

    public AddSala() throws Exception {
        initComponents();
        salaModel = new SalaModel();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelar_jbtn = new javax.swing.JButton();
        crear_sala_jbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre_jtxtfld = new javax.swing.JTextField();
        asientos_jtxtfld = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tipo_jtxtfld = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cancelar_jbtn.setText("Cancelar");
        cancelar_jbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_jbtnActionPerformed(evt);
            }
        });

        crear_sala_jbtn.setText("Crear");
        crear_sala_jbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_sala_jbtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre de Sala");

        jLabel2.setText("Asientos");

        asientos_jtxtfld.setText("50");

        jLabel3.setText("Tipo");

        tipo_jtxtfld.setText("2D");
        tipo_jtxtfld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipo_jtxtfldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(cancelar_jbtn)
                        .addGap(18, 18, 18)
                        .addComponent(crear_sala_jbtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombre_jtxtfld)
                            .addComponent(tipo_jtxtfld, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(asientos_jtxtfld, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(nombre_jtxtfld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(tipo_jtxtfld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(asientos_jtxtfld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crear_sala_jbtn)
                    .addComponent(cancelar_jbtn))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipo_jtxtfldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipo_jtxtfldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipo_jtxtfldActionPerformed

    private void crear_sala_jbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_sala_jbtnActionPerformed
        String nombre = nombre_jtxtfld.getText();   
        String tipo = tipo_jtxtfld.getText();
        int cantAsientos = Integer.parseInt(asientos_jtxtfld.getText());

        SalaDto sala = new SalasBuilder()
                .withNombre(nombre)
                .withTipo(tipo)
                .withCantAsientos(cantAsientos)
                .build();

        try {
            salaModel.createSala(sala);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_crear_sala_jbtnActionPerformed

    private void cancelar_jbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_jbtnActionPerformed
        setVisible(false);
        parent.setVisible(true);
    }//GEN-LAST:event_cancelar_jbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField asientos_jtxtfld;
    private javax.swing.JButton cancelar_jbtn;
    private javax.swing.JButton crear_sala_jbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nombre_jtxtfld;
    private javax.swing.JTextField tipo_jtxtfld;
    // End of variables declaration//GEN-END:variables
}
