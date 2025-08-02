package AdministradorVistas;

import Builders.SalasBuilder;
import DTOs.SalaDto;
import Modelo.CarteleraModel;
import Modelo.SalaModel;
import Utils.ImageCellRenderer;
import Utils.Media;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class IndexSalas extends javax.swing.JFrame {

    private enum RowEvent {
        DELETE_ROW,
        UPDATE_ROW,
        VIEW_ROW
    }

    private CarteleraModel carteleraModel;
    private SalaModel salaModel;

    public JFrame parent;

    private DefaultTableModel tableModel;
    private final List<Integer> indexesOfActionColumns = List.of(4, 5);

    public IndexSalas() throws Exception {
        initComponents();

        jTable1.setRowHeight(30);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        salaModel = new SalaModel();

        setTitle("TicketNet | Busqueda de Salas");
        setLocationRelativeTo(null);

        tableModel = (DefaultTableModel) jTable1.getModel();

        TableColumn updateColumn = jTable1.getColumn("U");
        TableColumn deleteColumn = jTable1.getColumn("D");

        updateColumn.setCellRenderer(new ImageCellRenderer());
        deleteColumn.setCellRenderer(new ImageCellRenderer());

        SalaDto[] salas = salaModel.getSalas();

        if (salas != null && salas.length > 0) {
            for (SalaDto sala : salas) {
                int id = sala.getId();
                String nombre = sala.getNombre();
                int asientos = sala.getCantAsientos();
                String estaDisponible = sala.getDisponibilidad() == 1 ? "✅" : "❌";

                Object dto[] = new Object[]{id, nombre, asientos, estaDisponible, Media.Pen, Media.Trashbin};

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
        SalaDto sala = salaModel.getSala(id);

        JTextField nombreField = new JTextField(sala.getNombre());
        JTextField tipoField = new JTextField(sala.getTipo());
        JTextField asientosField = new JTextField(String.valueOf(sala.getCantAsientos()));
        JCheckBox disponibleCheckBox = new JCheckBox("Disponible");
        disponibleCheckBox.setSelected(sala.getDisponibilidad() == 1);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nombre"), gbc);
        gbc.gridx = 1;
        panel.add(nombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Tipo"), gbc);
        gbc.gridx = 1;
        panel.add(tipoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Asientos"), gbc);
        gbc.gridx = 1;
        panel.add(asientosField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(disponibleCheckBox, gbc);

        Object[] options = {"Cancelar", "Guardar"};
        int result = JOptionPane.showOptionDialog(
                null,
                panel,
                "Actualizar Sala", // Updated title for clarity
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[1]
        );

        if (result == 0) { // Cancelar

        } else if (result == 1) { // Guardar
            SalaDto updatedSala = new SalasBuilder()
                    .withId(id)
                    .withNombre(nombreField.getText())
                    .withTipo(tipoField.getText())
                    .withCantAsientos(Integer.parseInt(asientosField.getText()))
                    .withDisponibilidad(disponibleCheckBox.isSelected() ? 1 : 0)
                    .build();

            tableModel.setValueAt(nombreField.getText(), row, 1);
            tableModel.setValueAt(tipoField.getText(), row, 2);
            tableModel.setValueAt(disponibleCheckBox.isSelected() ?  "✅" : "❌", row, 3);

            salaModel.updateSala(updatedSala);
        }
    }

    public void dialogToDeleteCartelera(int id, int row) throws Exception {
        String message = "¿Estás seguro en eliminar la sala?";

        String title = "Eliminación de Sala";

        int response = JOptionPane.showConfirmDialog(
                null,
                message,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            salaModel.deleteSala(id);

            tableModel.removeRow(row);
        }
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
        title_jlbl.setText("Busquedas de Salas");

        status_cartelera_jlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Tipo", "Disponible", "U", "D"
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
                        .addComponent(status_cartelera_jlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(title_jlbl)))
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
