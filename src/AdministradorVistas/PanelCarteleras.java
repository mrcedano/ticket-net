package AdministradorVistas;

import Modelo.CarteleraModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class PanelCarteleras extends javax.swing.JFrame {



    public PanelCarteleras() {
        initComponents();
        setLocationRelativeTo(null);
    
        setTitle("TicketNet | Panel de Carteleras");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crear_cartelera_btn = new javax.swing.JButton();
        consultar_cartelera_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        crear_cartelera_btn.setText("Crear Cartelera");
        crear_cartelera_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_cartelera_btnActionPerformed(evt);
            }
        });

        consultar_cartelera_btn.setText("Consultar Carteleras");
        consultar_cartelera_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultar_cartelera_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(consultar_cartelera_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crear_cartelera_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(crear_cartelera_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(consultar_cartelera_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crear_cartelera_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_cartelera_btnActionPerformed
       
        try {
            setVisible(false);
            
            AddCartelera addCartelera = new AddCartelera();
            
            addCartelera.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            
            addCartelera.setVisible(true);
            addCartelera.parent = this;
            
            addCartelera.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    addCartelera.setVisible(false);
                    
                    setVisible(true);
                }
            });
        } catch (Exception ex) {
        }
        
    }//GEN-LAST:event_crear_cartelera_btnActionPerformed

    private void consultar_cartelera_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultar_cartelera_btnActionPerformed
        try {
            setVisible(false);
            
            IndexCarteleras searchCarteleras = new IndexCarteleras();
            
            searchCarteleras.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            
            searchCarteleras.setVisible(true);
            searchCarteleras.parent = this;
            
            searchCarteleras.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    searchCarteleras.setVisible(false);
                    
                    setVisible(true);
                }
            });
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_consultar_cartelera_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consultar_cartelera_btn;
    private javax.swing.JButton crear_cartelera_btn;
    // End of variables declaration//GEN-END:variables
}
