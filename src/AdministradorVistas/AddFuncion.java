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

/**
 *
 * @author cedsc
 */
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
        ImageIcon resizedPoster = ImageMagic.resizeImage(poster, 211, 305);
        movie_poster_jlbl.setIcon(resizedPoster);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        movie_poster_jlbl = new javax.swing.JLabel();
        id_txtfld = new javax.swing.JTextField();
        id_jlbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        peliculas_cmbx = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        fecha_inicio_txtfld = new javax.swing.JTextField();
        starting_hour_lbl = new javax.swing.JLabel();
        hora_final_txtfld = new javax.swing.JTextField();
        final_hour_lbl = new javax.swing.JLabel();
        hora_inicio_txtfl = new javax.swing.JTextField();
        sala_lbl = new javax.swing.JLabel();
        crear_jbtn = new javax.swing.JButton();
        regresar_jbtn = new javax.swing.JButton();
        salas_cmbx = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        id_txtfld.setEditable(false);
        id_txtfld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_txtfldActionPerformed(evt);
            }
        });

        id_jlbl.setText("ID");

        jLabel1.setText("Película");

        peliculas_cmbx.setModel(new DefaultComboBoxModel<PeliculaDto>());
        peliculas_cmbx.setOpaque(true);

        jLabel2.setText("Día de inicio");

        starting_hour_lbl.setText("Hora Inicio");

        hora_final_txtfld.setText("00:00");

        final_hour_lbl.setText("Hora Final");

        hora_inicio_txtfl.setText("00:00");
        hora_inicio_txtfl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hora_inicio_txtflActionPerformed(evt);
            }
        });

        sala_lbl.setText("Sala");

        crear_jbtn.setText("Crear");
        crear_jbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_jbtnActionPerformed(evt);
            }
        });

        regresar_jbtn.setText("Regresar");
        regresar_jbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresar_jbtnActionPerformed(evt);
            }
        });

        salas_cmbx.setModel(new DefaultComboBoxModel<SalaDto>());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(movie_poster_jlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(id_jlbl)
                                    .addComponent(jLabel2)
                                    .addComponent(starting_hour_lbl)
                                    .addComponent(final_hour_lbl)
                                    .addComponent(sala_lbl))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(id_txtfld)
                                    .addComponent(fecha_inicio_txtfld)
                                    .addComponent(hora_final_txtfld, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addComponent(hora_inicio_txtfl, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addComponent(salas_cmbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(regresar_jbtn)
                                .addGap(18, 18, 18)
                                .addComponent(crear_jbtn))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(peliculas_cmbx, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(peliculas_cmbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(movie_poster_jlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_jlbl)
                            .addComponent(id_txtfld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(fecha_inicio_txtfld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(starting_hour_lbl)
                            .addComponent(hora_inicio_txtfl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(final_hour_lbl)
                            .addComponent(hora_final_txtfld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sala_lbl)
                            .addComponent(salas_cmbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(crear_jbtn)
                            .addComponent(regresar_jbtn))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

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
           
            int sala = 1;

            FuncionDto funcionDto = new FuncionBuilder()
                    .withActivoDesde(activoDesde)
                    .withActivoHasta(activoHasta)
                    .withPeliculaId(peliculaId)
                    .withCarteleraId(carteleraId)
                    .withSalaId(sala)
                    .build();

            funcionModel.createFuncion(funcionDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_crear_jbtnActionPerformed

    private void regresar_jbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresar_jbtnActionPerformed
        // TODO add your handling code here:

        setVisible(false);

        if (parent != null) {
            parent.setVisible(true);
        }
    }//GEN-LAST:event_regresar_jbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crear_jbtn;
    private javax.swing.JTextField fecha_inicio_txtfld;
    private javax.swing.JLabel final_hour_lbl;
    private javax.swing.JTextField hora_final_txtfld;
    private javax.swing.JTextField hora_inicio_txtfl;
    private javax.swing.JLabel id_jlbl;
    private javax.swing.JTextField id_txtfld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel movie_poster_jlbl;
    private javax.swing.JComboBox<PeliculaDto> peliculas_cmbx;
    private javax.swing.JButton regresar_jbtn;
    private javax.swing.JLabel sala_lbl;
    private javax.swing.JComboBox<SalaDto> salas_cmbx;
    private javax.swing.JLabel starting_hour_lbl;
    // End of variables declaration//GEN-END:variables
}
