/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AdministradorVistas;

import DTOs.PeliculaDto;
import Modelo.PeliculaModel;
import Utils.ImageCellRenderer;
import Utils.Media;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class SearchMovie extends javax.swing.JFrame {

    private enum RowEvent {
        DELETE_ROW,
        UPDATE_ROW,
        VIEW_ROW
    }
    // Update this when adding new actionable columns!
    private final List<Integer> indexesOfActionColumns = List.of(4, 5, 6);
    private PeliculaModel peliculaModel;

    private final DefaultTableModel tableModel;

    public SearchMovie() throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("TicketNet | Buscador de Películas");

        peliculaModel = new PeliculaModel();

        jTable2.setRowHeight(30);
        tableModel = (DefaultTableModel) jTable2.getModel();

        TableColumn deleteColumn = jTable2.getColumn("B");
        TableColumn updateColumn = jTable2.getColumn("U");

        deleteColumn.setCellRenderer(new ImageCellRenderer());
        updateColumn.setCellRenderer(new ImageCellRenderer());

        PeliculaDto[] movies = peliculaModel.getAllMovies();

        if (movies != null && movies.length > 0) {
            for (PeliculaDto movie : movies) {
                int id = movie.getId();
                String title = movie.getNombre();
                String duration = movie.getDuration();
                String created = "01/01/2005"; // Se añadirá este atributo después en el DTO

                Object dto[] = new Object[]{id, title, duration, created, Media.Trashbin, Media.Pen};

                tableModel.addRow(dto);
            }
        }

        jTable2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Point point = e.getPoint();
                    int row = jTable2.rowAtPoint(point);
                    int col = jTable2.columnAtPoint(point);
                    RowEvent eventSelected = getEventByColumn(col);

                    if (indexesOfActionColumns.contains(col) == false) {
                        return;
                    }

                    if (row == -1) {
                        System.err.println("Unexisting Row");

                        return;
                    }

                    if (eventSelected == null) {
                        System.err.println("Error when selecting an event");

                        return;
                    }

                    int id = (int) jTable2.getValueAt(row, 0);

                    switch (eventSelected) {
                        case DELETE_ROW ->
                            dialogToDeleteMovie(id, row);
                        case UPDATE_ROW ->
                            dialogToUpdateMovie(id, row);
                        case VIEW_ROW ->
                            dialogToViewMovie(id);
                    }
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
    }

   public void dialogToUpdateMovie(int id, int row) {
    JTextField titleField = new JTextField((String) tableModel.getValueAt(row, 1));
    
    String currentDuration = String.valueOf(tableModel.getValueAt(row, 2)); 
    JTextField durationField = new JTextField(currentDuration);

    JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
    panel.add(new JLabel("Título:"));
    panel.add(titleField);
    panel.add(new JLabel("Duración:"));
    panel.add(durationField);

    int result = JOptionPane.showConfirmDialog(
        null,
        panel, 
        "Actualizar película: ", 
        JOptionPane.OK_CANCEL_OPTION, 
        JOptionPane.PLAIN_MESSAGE
    );

    if (result == JOptionPane.OK_OPTION) {
        String newTitle = titleField.getText();
        String newDuration = durationField.getText();

            tableModel.setValueAt(newTitle, row, 1);
            tableModel.setValueAt(newDuration, row, 2);
    }
 }

    public void dialogToViewMovie(int id) {

    }

    public void dialogToDeleteMovie(int id, int row) throws Exception {
        String message = "¿Estás seguro en eliminar la película?";

        String title = "Eliminación de Película";

        int response = JOptionPane.showConfirmDialog(
                null,
                message,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            peliculaModel.deleteMovie(id);
            tableModel.removeRow(row);
        }
    }

    private RowEvent getEventByColumn(int column) {
        return switch (column) {
            case 4 ->
                RowEvent.DELETE_ROW;
            case 5 ->
                RowEvent.UPDATE_ROW;
            case 6 ->
                RowEvent.VIEW_ROW;
            default ->
                null;
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        regresar_btn = new javax.swing.JButton();
        buscar_btn = new javax.swing.JButton();
        buscador_txtfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        regresar_btn.setText("Regresar");
        regresar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresar_btnActionPerformed(evt);
            }
        });

        buscar_btn.setText("Buscar");
        buscar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Buscador de Películas");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Título", "Duración", "Fecha. creación", "B", "U"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(35);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(30);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buscador_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscar_btn)
                        .addGap(24, 24, 24)))
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(regresar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar_btn)
                    .addComponent(buscador_txtfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(regresar_btn)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresar_btnActionPerformed

    }//GEN-LAST:event_regresar_btnActionPerformed

    private void buscar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_btnActionPerformed

    }//GEN-LAST:event_buscar_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscador_txtfield;
    private javax.swing.JButton buscar_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton regresar_btn;
    // End of variables declaration//GEN-END:variables
}
