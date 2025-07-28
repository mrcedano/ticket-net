/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AdministradorVistas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author cincinrooting
 */
public class PanelPeliculas extends javax.swing.JFrame {
    
    public PanelPeliculas() {
        initComponents();
        setTitle("TicketNet | Panel de Películas");
        
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        consultar_btn = new javax.swing.JButton();
        agregar_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        consultar_btn.setText("Consultar Pelicula");
        consultar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultar_btnActionPerformed(evt);
            }
        });

        agregar_btn.setText("Agregar Películas");
        agregar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consultar_btn)
                    .addComponent(agregar_btn))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(agregar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(consultar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultar_btnActionPerformed
        try {
            setVisible(false);
            IndexMovies searchMovie = new IndexMovies();
            
            searchMovie.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            searchMovie.setVisible(true);
            
            searchMovie.addWindowListener(new WindowListener() {
                @Override
                public void windowClosing(WindowEvent e) {
                    searchMovie.setVisible(false);
                    
                    setVisible(true);
                }
                
                @Override
                public void windowOpened(WindowEvent we) {
                }
                
                @Override
                public void windowClosed(WindowEvent we) {
                }
                
                @Override
                public void windowIconified(WindowEvent we) {
                }
                
                @Override
                public void windowDeiconified(WindowEvent we) {
                }
                
                @Override
                public void windowActivated(WindowEvent we) {
                }
                
                @Override
                public void windowDeactivated(WindowEvent we) {
                }
            });
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_consultar_btnActionPerformed

    private void agregar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_btnActionPerformed
        setVisible(false);
        AddMovie addMovie = new AddMovie();
        
        addMovie.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addMovie.setVisible(true);
        
        addMovie.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
              addMovie.setVisible(false);
              
              setVisible(true);
            }

            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosed(WindowEvent we) {
            }

            @Override
            public void windowIconified(WindowEvent we) {
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
            }

            @Override
            public void windowActivated(WindowEvent we) {
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
            }
        });
        
    }//GEN-LAST:event_agregar_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_btn;
    private javax.swing.JButton consultar_btn;
    // End of variables declaration//GEN-END:variables
}
