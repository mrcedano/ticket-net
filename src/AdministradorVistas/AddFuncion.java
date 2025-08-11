/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AdministradorVistas;

import Builders.FuncionBuilder;
import DTOs.CarteleraDto;
import DTOs.FuncionDto;
import DTOs.PeliculaDto;
import DTOs.SalaDto;
import Modelo.CarteleraModel;
import Modelo.FuncionModel;
import Modelo.SalaModel;
import Utils.ImageMagic;
import com.raven.datechooser.DateChooser;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddFuncion extends javax.swing.JFrame {
                                                                                    
    public JFrame parent = null;
    private DateChooser dateChooser;

    private CarteleraModel carteleraModel;
    private FuncionModel funcionModel;
    private SalaModel salaModel;

    private CarteleraDto carteleraDto;
    private FuncionDto funcionDto;

    private int assignedId;

    public AddFuncion() throws Exception {
        initComponents();

        setTitle("TicketNet | Agregar Función Nueva");
        setLocationRelativeTo(null);
        
        setResizable(false);
        setSize(550, 430);

        dateChooser = new DateChooser();
        carteleraModel = new CarteleraModel();
        funcionModel = new FuncionModel();
        salaModel = new SalaModel();

        dateChooser.setTextField(fecha_inicio_txtfld);

        carteleraDto = carteleraModel.getCarteleraActivated();

        if (carteleraDto == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "¡Error con la cartelera, intenta más tarde!",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        PeliculaDto[] peliculasFromCartelera = carteleraModel.getPeliculasFromCarteleraById(carteleraDto.getId());
        SalaDto[] salas = salaModel.getSalas();

        peliculas_cmbx.setModel(new DefaultComboBoxModel<>(peliculasFromCartelera));
        salas_cmbx.setModel(new DefaultComboBoxModel<>(salas));

        peliculas_cmbx.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PeliculaDto selectedPelicula = (PeliculaDto) peliculas_cmbx.getSelectedItem();
                if (selectedPelicula != null) {
                    loadMovie(selectedPelicula);
                }
            }
        });

        if (peliculas_cmbx.getItemCount() > 0) {
            peliculas_cmbx.setSelectedIndex(0);
        }

        assignedId = funcionModel.getLatestFuncionId(carteleraDto.getId()) + 1;

        id_txtfld.setText("" + assignedId);

    }

    public void loadMovie(PeliculaDto movie) {
        ImageIcon poster = new ImageIcon(movie.getLogo());
        ImageIcon resizedPoster = ImageMagic.resizeImage(poster, 133, 208);
        movie_poster_jlbl.setIcon(resizedPoster);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        peliculas_cmbx = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        pelicula_jlbl = new javax.swing.JLabel();
        starting_hour_lbl = new javax.swing.JLabel();
        final_hour_lbl = new javax.swing.JLabel();
        crear_jbtn = new javax.swing.JButton();
        id_jlbl = new javax.swing.JLabel();
        sala_lbl = new javax.swing.JLabel();
        icono_central_jlb = new javax.swing.JLabel();
        salas_cmbx = new javax.swing.JComboBox<>();
        hora_final_txtfld = new javax.swing.JTextField();
        id_txtfld = new javax.swing.JTextField();
        fecha_inicio_txtfld = new javax.swing.JTextField();
        hora_inicio_txtfl = new javax.swing.JTextField();
        movie_poster_jlbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        regresar_jbtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(45, 45, 45));

        peliculas_cmbx.setModel(new DefaultComboBoxModel<PeliculaDto>());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Película");

        pelicula_jlbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        pelicula_jlbl.setForeground(new java.awt.Color(255, 255, 255));
        pelicula_jlbl.setText("Película");

        starting_hour_lbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        starting_hour_lbl.setForeground(new java.awt.Color(255, 255, 255));
        starting_hour_lbl.setText("Hora Inicio");

        final_hour_lbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        final_hour_lbl.setForeground(new java.awt.Color(255, 255, 255));
        final_hour_lbl.setText("Hora Final");

        crear_jbtn.setBackground(new java.awt.Color(0, 128, 0));
        crear_jbtn.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        crear_jbtn.setForeground(new java.awt.Color(255, 255, 255));
        crear_jbtn.setText("Crear");
        crear_jbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_jbtnActionPerformed(evt);
            }
        });

        id_jlbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        id_jlbl.setForeground(new java.awt.Color(255, 255, 255));
        id_jlbl.setText("ID");

        sala_lbl.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        sala_lbl.setForeground(new java.awt.Color(255, 255, 255));
        sala_lbl.setText("Sala");

        icono_central_jlb.setBackground(new java.awt.Color(25, 28, 28));
        icono_central_jlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logofinal2.png"))); // NOI18N
        icono_central_jlb.setPreferredSize(new java.awt.Dimension(1024, 1536));

        salas_cmbx.setModel(new DefaultComboBoxModel<SalaDto>());
        salas_cmbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salas_cmbxActionPerformed(evt);
            }
        });

        hora_final_txtfld.setText("00:00");

        id_txtfld.setEditable(false);
        id_txtfld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_txtfldActionPerformed(evt);
            }
        });

        fecha_inicio_txtfld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecha_inicio_txtfldActionPerformed(evt);
            }
        });

        hora_inicio_txtfl.setText("00:00");
        hora_inicio_txtfl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hora_inicio_txtflActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Día de inicio");

        regresar_jbtn1.setBackground(new java.awt.Color(153, 153, 153));
        regresar_jbtn1.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        regresar_jbtn1.setForeground(new java.awt.Color(255, 255, 255));
        regresar_jbtn1.setText("Regresar");
        regresar_jbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresar_jbtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(id_jlbl)
                                    .addComponent(sala_lbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fecha_inicio_txtfld, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addComponent(id_txtfld)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(icono_central_jlb, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(starting_hour_lbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(final_hour_lbl, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(pelicula_jlbl, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(hora_inicio_txtfl, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(hora_final_txtfld, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                            .addComponent(salas_cmbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(peliculas_cmbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(18, 18, 18)
                        .addComponent(movie_poster_jlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(regresar_jbtn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(crear_jbtn)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(icono_central_jlb, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 227, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_jlbl, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(id_txtfld, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sala_lbl)
                            .addComponent(fecha_inicio_txtfld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hora_inicio_txtfl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(starting_hour_lbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hora_final_txtfld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(final_hour_lbl))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salas_cmbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(peliculas_cmbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pelicula_jlbl))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(movie_poster_jlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crear_jbtn)
                    .addComponent(regresar_jbtn1))
                .addGap(39, 39, 39))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 550, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void id_txtfldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_txtfldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_txtfldActionPerformed

    private void hora_inicio_txtflActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hora_inicio_txtflActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hora_inicio_txtflActionPerformed

    private void crear_jbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_jbtnActionPerformed
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        try {
            String date = fecha_inicio_txtfld.getText();
            String startingHour = hora_inicio_txtfl.getText();
            String finalHour = hora_final_txtfld.getText();

            LocalDateTime activoDesde = LocalDateTime.parse(date + " " + startingHour, formatter);
            LocalDateTime activoHasta = LocalDateTime.parse(date + " " + finalHour, formatter);

            int peliculaId = ((PeliculaDto) peliculas_cmbx.getSelectedItem()).getId();
            int carteleraId = carteleraDto.getId();

            // PATCH: Use selected Sala from combo box
            int salaId = ((SalaDto) salas_cmbx.getSelectedItem()).getId();

            FuncionDto funcionDto = new FuncionBuilder()
                    .withActivoDesde(activoDesde)
                    .withActivoHasta(activoHasta)
                    .withPeliculaId(peliculaId)
                    .withCarteleraId(carteleraId)
                    .withSalaId(salaId)
                    .build();

            funcionModel.createFuncion(funcionDto);

            JOptionPane.showMessageDialog(this, "Función creada exitosamente");
            setVisible(false);
            if (parent != null) {
                parent.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_crear_jbtnActionPerformed

    private void salas_cmbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salas_cmbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salas_cmbxActionPerformed

    private void fecha_inicio_txtfldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecha_inicio_txtfldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fecha_inicio_txtfldActionPerformed

    private void regresar_jbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresar_jbtn1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        
        parent.setVisible(true);
    }//GEN-LAST:event_regresar_jbtn1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crear_jbtn;
    private javax.swing.JTextField fecha_inicio_txtfld;
    private javax.swing.JLabel final_hour_lbl;
    private javax.swing.JTextField hora_final_txtfld;
    private javax.swing.JTextField hora_inicio_txtfl;
    private javax.swing.JLabel icono_central_jlb;
    private javax.swing.JLabel id_jlbl;
    private javax.swing.JTextField id_txtfld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel movie_poster_jlbl;
    private javax.swing.JLabel pelicula_jlbl;
    private javax.swing.JComboBox<PeliculaDto> peliculas_cmbx;
    private javax.swing.JButton regresar_jbtn1;
    private javax.swing.JLabel sala_lbl;
    private javax.swing.JComboBox<SalaDto> salas_cmbx;
    private javax.swing.JLabel starting_hour_lbl;
    // End of variables declaration//GEN-END:variables
}
