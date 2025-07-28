package AdministradorVistas;

import DTOs.CarteleraDto;
import Modelo.CarteleraModel;
import Utils.ImageCellRenderer;
import Utils.Media;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class IndexCarteleras extends javax.swing.JFrame {

    private enum RowEvent {
        DELETE_ROW,
        UPDATE_ROW,
        VIEW_ROW
    }

    private CarteleraModel carteleraModel;

    public JFrame parent;

    private DefaultTableModel tableModel;
    private final List<Integer> indexesOfActionColumns = List.of(4, 5);

    public IndexCarteleras() throws Exception {
        initComponents();

        // Hiding the ID column
        jTable1.setRowHeight(30);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        carteleraModel = new CarteleraModel();

        setTitle("TicketNet | Busqueda de Carteleras");
        setLocationRelativeTo(null);

        boolean IsThereACarteleraActivated = carteleraModel.isThereACarteleraActivated();

        if (IsThereACarteleraActivated == true) {
            status_cartelera_jlbl.setForeground(new Color(0, 128, 0));
            status_cartelera_jlbl.setText("✅ Hay una cartelera activa");
        } else {
            status_cartelera_jlbl.setForeground(Color.red);
            status_cartelera_jlbl.setText("❌ No hay ninguna cartelera activa");
        }

        tableModel = (DefaultTableModel) jTable1.getModel();

        TableColumn updateColumn = jTable1.getColumn("U");
        TableColumn deleteColumn = jTable1.getColumn("D");

        updateColumn.setCellRenderer(new ImageCellRenderer());
        deleteColumn.setCellRenderer(new ImageCellRenderer());

        CarteleraDto[] carteleras = carteleraModel.getCarteleras();

        if (carteleras != null && carteleras.length > 0) {
            for (CarteleraDto cartelera : carteleras) {
                int id = cartelera.getId();
                LocalDate fromDate = cartelera.getActiveSince();
                LocalDate toDate = cartelera.getActiveUntil();
                String isActivated = cartelera.getIsActivated() == 1 ? "✅" : "❌";

                Object dto[] = new Object[]{id, fromDate, toDate, isActivated, Media.Pen, Media.Trashbin};

                tableModel.addRow(dto);
            }
        }
        
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Point point = e.getPoint();
                    int row = jTable1.rowAtPoint(point);
                    int col = jTable1.columnAtPoint(point);
                    RowEvent rowEvent = getEventByColumn(col);

                    if (indexesOfActionColumns.contains(col) == false) {
                        return;
                    }

                    if (row == -1) {
                        return;
                    }

                    int id = (int) jTable1.getValueAt(row, 0);

                    switch (rowEvent) {
                        case UPDATE_ROW ->
                            dialogToUpdateCartelera(id, row);
                        case DELETE_ROW ->
                            dialogToDeleteCartelera(id, row);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

    public void dialogToUpdateCartelera(int id, int row) throws Exception {
        AddMoviesToCartelera addMoviesToCarteleras = new AddMoviesToCartelera(id);
        
        addMoviesToCarteleras.setVisible(true);
    }

    public void dialogToDeleteCartelera(int id, int row) throws Exception {

    }

    private RowEvent getEventByColumn(int column) {
        return switch (column) {
            case 4 ->
                RowEvent.UPDATE_ROW;
            case 5 ->
                RowEvent.DELETE_ROW;
            default ->
                null;
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title_jlbl = new javax.swing.JLabel();
        status_cartelera_jlbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title_jlbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title_jlbl.setText("Busquedas de Carteleras");

        status_cartelera_jlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha Desde", "Fecha Hasta", "Status", "U", "D"
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
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(status_cartelera_jlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(title_jlbl)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(title_jlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(status_cartelera_jlbl)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel status_cartelera_jlbl;
    private javax.swing.JLabel title_jlbl;
    // End of variables declaration//GEN-END:variables
}
