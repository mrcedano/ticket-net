package VentaBoletosVistas;

import Builders.BoletoBuilder;
import DTOs.BoletoDto;
import DTOs.FuncionDto;
import DTOs.PeliculaDto;
import DTOs.SalaDto;
import Modelo.BoletoModel;
import Modelo.FuncionModel;
import Utils.Global;
import Utils.ImageMagic;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.*;

public class CompraBoletos extends javax.swing.JFrame {

    private JSpinner jSpinnerAdultos;
    private JSpinner jSpinnerNinos;
    private JButton jButtonCalcular;

    private FuncionModel funcionModel;
    private BoletoModel boletoModel;

    private FuncionDto funcion;
    private PeliculaDto pelicula;
    private SalaDto sala;

    public JFrame parent = null;

    @SuppressWarnings("unchecked")
    public CompraBoletos(int funcionId) throws Exception {
        initComponents();
        setTitle("Cantidad de Boletos");
        setLocationRelativeTo(null);

        funcionModel = new FuncionModel();
        boletoModel = new BoletoModel();

        HashMap<FuncionDto, HashMap<SalaDto, PeliculaDto>> funcionWithSalaAndPelicula = funcionModel.getFuncionAndSalaAndPeliculaByFuncionId(funcionId);

        sala = null;
        pelicula = null;
        funcion = null;

        for (Map.Entry<FuncionDto, HashMap<SalaDto, PeliculaDto>> funcionEntry : funcionWithSalaAndPelicula.entrySet()) {
            funcion = funcionEntry.getKey();
            HashMap<SalaDto, PeliculaDto> salaPeliculaMap = funcionEntry.getValue();

            for (Map.Entry<SalaDto, PeliculaDto> innerEntry : salaPeliculaMap.entrySet()) {
                sala = innerEntry.getKey();
                pelicula = innerEntry.getValue();
                break;
            }
            break;
        }

        if (sala == null || pelicula == null || funcion == null) {
            System.err.println("One DTO is null");

            return;
        }

        ImageIcon portadaDePelicula = new ImageIcon(pelicula.getLogo());

        portada_jlbl.setIcon(ImageMagic.resizeImage(portadaDePelicula, 200, 300));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        icono_central_jlb = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        adulto_jpn = new javax.swing.JSpinner();
        nino_jpn = new javax.swing.JSpinner();
        portada_jlbl = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        siguiente_jbtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(28, 28, 28));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(48, 48, 48));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 650));

        icono_central_jlb.setBackground(new java.awt.Color(25, 28, 28));
        icono_central_jlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logofinal2.png"))); // NOI18N
        icono_central_jlb.setPreferredSize(new java.awt.Dimension(1024, 1536));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Boletos de adulto $50");

        adulto_jpn.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        adulto_jpn.setModel(new javax.swing.SpinnerNumberModel(0, 0, 300, 1));
        adulto_jpn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        nino_jpn.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        nino_jpn.setModel(new javax.swing.SpinnerNumberModel(0, 0, 300, 1));

        portada_jlbl.setFont(new java.awt.Font("Nimbus Sans", 0, 12)); // NOI18N

        jButton2.setBackground(new java.awt.Color(49, 49, 49));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        siguiente_jbtn.setBackground(new java.awt.Color(240, 74, 74));
        siguiente_jbtn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        siguiente_jbtn.setForeground(new java.awt.Color(255, 255, 255));
        siguiente_jbtn.setText("Siguiente");
        siguiente_jbtn.setBorder(null);
        siguiente_jbtn.setPreferredSize(new java.awt.Dimension(111, 39));
        siguiente_jbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguiente_jbtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Boletos de niño $30");

        jButton3.setBackground(new java.awt.Color(49, 49, 49));
        jButton3.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
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
                    .addComponent(portada_jlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(nino_jpn, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addComponent(siguiente_jbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(adulto_jpn, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(adulto_jpn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nino_jpn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portada_jlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(siguiente_jbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 570, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguiente_jbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguiente_jbtnActionPerformed
        try {

            int cantidadAdultos = (int) adulto_jpn.getValue();
            int cantidadNiños = (int) nino_jpn.getValue();
            int cantBoletosASeleccionar = cantidadAdultos + cantidadNiños;

            int yaSeleccionados = boletoModel.getNumberOfSelectedAsientosByFuncionId(funcion.getId());

            if (cantBoletosASeleccionar == 0) {
                JOptionPane.showMessageDialog(this, "No has elegido cuántos boletos vas a comprar", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (yaSeleccionados + cantBoletosASeleccionar > sala.getCantAsientos()) {
                JOptionPane.showMessageDialog(this, "Solo puedes seleccionar un máximo de 48 asientos.\nActualmente has seleccionado: " + yaSeleccionados, "Límite alcanzado", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            BoletoDto preBoleto = new BoletoBuilder()
                                                    .withNinos(cantidadNiños)
                                                    .withAdultos(cantidadAdultos)
                                                    .withFuncionId(funcion.getId())
                                                    .withUsuarioId(Global.user.getId())
                                                    .build();

            SeleccionDeAsientos seleccionAsientos = new SeleccionDeAsientos(funcion, sala, preBoleto, pelicula, cantBoletosASeleccionar);

            seleccionAsientos.parent = parent;
            
            seleccionAsientos.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

            setVisible(false);
            seleccionAsientos.setVisible(true);
            
            seleccionAsientos.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    seleccionAsientos.setVisible(false);

                    setVisible(true);
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_siguiente_jbtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            parent.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int cantidadAdultos = (int) adulto_jpn.getValue();
        int cantidadNinos = (int) nino_jpn.getValue();
        int total = (cantidadAdultos * 50) + (cantidadNinos * 30);
        JOptionPane.showMessageDialog(this, "Total a pagar: $" + total);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner adulto_jpn;
    private javax.swing.JLabel icono_central_jlb;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner nino_jpn;
    private javax.swing.JLabel portada_jlbl;
    private javax.swing.JButton siguiente_jbtn;
    // End of variables declaration//GEN-END:variables
}
