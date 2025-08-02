package AdministradorVistas;

import JObjects.SideBarBuilder;
import Utils.Global;
import Vista.InicioSesion;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JPanel;

public class Panel extends javax.swing.JFrame {

    public Panel() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Ticketnet | Panel de Administrador");

        JPanel sidebar = new SideBarBuilder()
                .addOption("Mi cuenta", () -> {
                    System.out.println("You clicked on Mi cuenta!");
                })
                .addOption("Cerrar Sesión", () -> {
                    Global.destroySession();
                             
                    new InicioSesion().setVisible(true);
                    setVisible(false);
                })
                .build(0, 69, 167, 250);

        getContentPane().add(sidebar);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Funciones = new javax.swing.JButton();
        cartelaras_btn = new javax.swing.JButton();
        peliculas_btn = new javax.swing.JButton();
        salas_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Funciones.setText("Funciones");
        Funciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FuncionesActionPerformed(evt);
            }
        });

        cartelaras_btn.setText("Carteleras");
        cartelaras_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartelaras_btnActionPerformed(evt);
            }
        });

        peliculas_btn.setText("Peliculas");
        peliculas_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peliculas_btnActionPerformed(evt);
            }
        });

        salas_btn.setText("Salas");
        salas_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salas_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(salas_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(Funciones, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cartelaras_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(peliculas_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cartelaras_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peliculas_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salas_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Funciones, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void peliculas_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peliculas_btnActionPerformed
        setVisible(false);
        
        PanelPeliculas panelPeliculas = new PanelPeliculas();
        
        panelPeliculas.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        panelPeliculas.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
              panelPeliculas.setVisible(false);
              
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
        
        panelPeliculas.setVisible(true);
    }//GEN-LAST:event_peliculas_btnActionPerformed

    private void cartelaras_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartelaras_btnActionPerformed
        setVisible(false);
        
        PanelCarteleras panelCarteleras = new PanelCarteleras();
        
        panelCarteleras.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        panelCarteleras.setVisible(true);
        
        panelCarteleras.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
             panelCarteleras.setVisible(false);
             setVisible(true);
        }
      });
    }//GEN-LAST:event_cartelaras_btnActionPerformed

    private void FuncionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FuncionesActionPerformed
        try {
            setVisible(false);
            
            PanelFunciones panelFunciones = new PanelFunciones();
            
            panelFunciones.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            
            panelFunciones.setVisible(true);
            
            panelFunciones.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    panelFunciones.setVisible(false);
                    setVisible(true);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_FuncionesActionPerformed

    private void salas_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salas_btnActionPerformed
        try {
            setVisible(false);
            
            PanelSalas panelSalas = new PanelSalas();
            
            panelSalas.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            
            panelSalas.setVisible(true);
            
            panelSalas.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    panelSalas.setVisible(false);
                    setVisible(true);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_salas_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Funciones;
    private javax.swing.JButton cartelaras_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton peliculas_btn;
    private javax.swing.JButton salas_btn;
    // End of variables declaration//GEN-END:variables
}
