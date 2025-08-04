package VentaBoletosVistas;

import Builders.BoletoBuilder;
import DTOs.BoletoDto;
import DTOs.FuncionDto;
import DTOs.PeliculaDto;
import DTOs.SalaDto;
import Modelo.BoletoModel;
import Modelo.SalaModel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SeleccionDeAsientos extends JFrame {

    private int cantidadAComprar;

    private SalaModel salaModel;
    private BoletoModel boletoModel;
    
    private FuncionDto funcion;
    private PeliculaDto pelicula;
    private SalaDto sala;
    
    private BoletoDto preBoleto;
    
    public JFrame parent;

    private List<String> asientosSeleccionados = new ArrayList<>();

    public SeleccionDeAsientos(FuncionDto funcion, SalaDto sala, BoletoDto preBoleto, PeliculaDto pelicula,int cantidadAComprar) throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        
        this.cantidadAComprar = cantidadAComprar;
        this.boletoModel = new BoletoModel();
        
        this.funcion = funcion;
        this.sala = sala;
        this.pelicula = pelicula;
        
        this.preBoleto = preBoleto;
        
        setTitle("TicketNet | Selección de Asientos");
        
        List<String> asientosSeleccionadosAsListFromDb = Arrays.asList(boletoModel.getSelectedAsientosByFuncionId(funcion.getId()));
        
        System.out.println("Funcion: " + funcion.getId());
        
        asientosSeleccionados.addAll(asientosSeleccionadosAsListFromDb);
        
        titulo_jlbl.setText(pelicula.getNombre());
        titulo_jlbl.setHorizontalAlignment(JLabel.CENTER);

        pantalla_jbtn.setText("Pantalla | " + sala.getNombre());
        
        agregarAsientos();
    }

    private void agregarAsientos() {
        int filas = (int) Math.ceil( (float) sala.getCantAsientos()/8);
        int columnas = 8;
        
        jPanel4.setLayout(new java.awt.GridLayout(filas, columnas, 10, 10));
        jPanel4.removeAll();
        
        int contadorCantidadAsientos = sala.getCantAsientos();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas && contadorCantidadAsientos > 0; j++, contadorCantidadAsientos--) {
                String nombreAsiento = (char) ('A' + i) + String.valueOf(j + 1);
                JButton asiento = new JButton(nombreAsiento);
                asiento.setPreferredSize(new Dimension(40, 40));
                asiento.setFocusPainted(false);

                if (asientosSeleccionados.contains(nombreAsiento)) {
                    asiento.setBackground(Color.YELLOW);
                    asiento.setEnabled(false); 
                } else {
                    asiento.setBackground(Color.GREEN);
                    asiento.addActionListener(e -> {
                        int seleccionadosEnPanel = contarSeleccionEnPanel(jPanel4);

                        if (asiento.getBackground().equals(Color.GREEN)) {
                            if (seleccionadosEnPanel < cantidadAComprar) {
                                asiento.setBackground(Color.YELLOW);
                            } 
                        } else if (asiento.getBackground().equals(Color.YELLOW)) {
                            asiento.setBackground(Color.GREEN);
                        }
                    });
                }
                
                jPanel4.add(asiento);
            }
        }

        jPanel4.revalidate();
        jPanel4.repaint();
    }

    private int contarSeleccionEnPanel(javax.swing.JPanel panel) {
        int count = 0;
        for (java.awt.Component comp : panel.getComponents()) {
            if (comp instanceof JButton && comp.getBackground().equals(Color.YELLOW) && comp.isEnabled()) {
                count++;
            }
        }
        return count;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        icono_central_jlb = new javax.swing.JLabel();
        titulo_jlbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        pantalla_jbtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        confirmar_jbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(48, 48, 48));

        icono_central_jlb.setBackground(new java.awt.Color(25, 28, 28));
        icono_central_jlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logofinal2.png"))); // NOI18N
        icono_central_jlb.setPreferredSize(new java.awt.Dimension(1024, 1536));

        titulo_jlbl.setFont(new java.awt.Font("SansSerif", 1, 26)); // NOI18N
        titulo_jlbl.setForeground(new java.awt.Color(255, 255, 255));
        titulo_jlbl.setText("Lilo y Stich");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Selecciona tus asientos");

        jPanel4.setBackground(new java.awt.Color(48, 48, 48));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 350));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        pantalla_jbtn.setBackground(new java.awt.Color(49, 49, 49));
        pantalla_jbtn.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        pantalla_jbtn.setForeground(new java.awt.Color(102, 153, 255));
        pantalla_jbtn.setText("Pantalla | Sala 3");
        pantalla_jbtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pantalla_jbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pantalla_jbtnActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        confirmar_jbtn.setBackground(new java.awt.Color(33, 72, 149));
        confirmar_jbtn.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        confirmar_jbtn.setForeground(new java.awt.Color(255, 255, 255));
        confirmar_jbtn.setText("Confirmar selección");
        confirmar_jbtn.setBorder(null);
        confirmar_jbtn.setPreferredSize(new java.awt.Dimension(111, 41));
        confirmar_jbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmar_jbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(147, 147, 147))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(icono_central_jlb, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(confirmar_jbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(pantalla_jbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(titulo_jlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(icono_central_jlb, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo_jlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addComponent(pantalla_jbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmar_jbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 540, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pantalla_jbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pantalla_jbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pantalla_jbtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
        
        parent.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void confirmar_jbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmar_jbtnActionPerformed
        try {
        List<String> seleccionadosSesion = new ArrayList<>();

        for (java.awt.Component comp : jPanel4.getComponents()) {
            if (comp instanceof JButton && comp.getBackground().equals(Color.YELLOW) && comp.isEnabled()) {
                String nombre = ((JButton) comp).getText();
                seleccionadosSesion.add(nombre);
            }
        }

        if (seleccionadosSesion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No seleccionaste ningún asiento.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            BoletoDto boleto = new BoletoBuilder()
                                                 .withNinos(preBoleto.getNinos())
                                                 .withAdultos(preBoleto.getAdultos())
                                                 .withFuncionId(preBoleto.getFuncion_id())
                                                 .withUsuarioId(preBoleto.getUsuario_id())
                                                 .withAsientos(String.join(",", seleccionadosSesion))
                                                 .build();

             boletoModel.createBoleto(boleto);
        
             JOptionPane.showMessageDialog(this, "Boletos creados exítosamente, generando ticket...");
        
             setVisible(false);
             parent.setVisible(true);
             
             // Generando ticket...
             
             
        }
       } catch(Exception e) {
            e.printStackTrace();
      }
    }//GEN-LAST:event_confirmar_jbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmar_jbtn;
    private javax.swing.JLabel icono_central_jlb;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton pantalla_jbtn;
    private javax.swing.JLabel titulo_jlbl;
    // End of variables declaration//GEN-END:variables
}
