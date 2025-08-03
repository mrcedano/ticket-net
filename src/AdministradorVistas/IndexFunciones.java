package AdministradorVistas;

import Builders.FuncionBuilder;
import Builders.SalasBuilder;
import DTOs.CarteleraDto;
import DTOs.FuncionDto;
import DTOs.PeliculaDto;
import DTOs.SalaDto;
import Modelo.CarteleraModel;
import Modelo.FuncionModel;
import Modelo.PeliculaModel;
import Modelo.SalaModel;
import Utils.ImageCellRenderer;
import Utils.ImageMagic;
import Utils.Media;
import com.raven.datechooser.DateChooser;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class IndexFunciones extends javax.swing.JFrame {

    private enum RowEvent {
        DELETE_ROW,
        UPDATE_ROW,
        VIEW_ROW
    }

    private FuncionModel funcionModel;

    private CarteleraModel carteleraModel;
    private PeliculaModel peliculaModel;
    private SalaModel salaModel;
    
    CarteleraDto carteleraDto;

    public JFrame parent;

    private DefaultTableModel tableModel;
    private final List<Integer> indexesOfActionColumns = List.of(5, 6);

    public IndexFunciones() throws Exception {
        initComponents();

        jTable1.setRowHeight(30);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        carteleraModel = new CarteleraModel();
        funcionModel = new FuncionModel();
        salaModel = new SalaModel();
        peliculaModel = new PeliculaModel();
        
        carteleraDto = carteleraModel.getCarteleraActivated();

        setTitle("TicketNet | Busqueda de Funciones");
        setLocationRelativeTo(null);

        tableModel = (DefaultTableModel) jTable1.getModel();

        TableColumn updateColumn = jTable1.getColumn("U");
        TableColumn deleteColumn = jTable1.getColumn("D");

        updateColumn.setCellRenderer(new ImageCellRenderer());
        deleteColumn.setCellRenderer(new ImageCellRenderer());

        HashMap<FuncionDto, HashMap<SalaDto, PeliculaDto>>[] funciones = funcionModel.getFuncionesFromCarteleraById(carteleraDto.getId());

        if (funciones != null && funciones.length > 0) {

            for (HashMap<FuncionDto, HashMap<SalaDto, PeliculaDto>> funcionMap : funciones) {
                for (Map.Entry<FuncionDto, HashMap<SalaDto, PeliculaDto>> funcionEntry : funcionMap.entrySet()) {

                    FuncionDto funcion = funcionEntry.getKey();
                    HashMap<SalaDto, PeliculaDto> salaPeliculaMap = funcionEntry.getValue();

                    for (Map.Entry<SalaDto, PeliculaDto> innerEntry : salaPeliculaMap.entrySet()) {
                        SalaDto sala = innerEntry.getKey();
                        PeliculaDto pelicula = innerEntry.getValue();

                        Object[] rowData = new Object[]{
                            funcion.getId(),
                            funcion.getActivoDesde().toString(),
                            funcion.getActiveHasta().toString(),
                            pelicula.getNombre(),
                            sala.getNombre(),
                            Media.Pen,
                            Media.Trashbin
                        };

                        tableModel.addRow(rowData);
                    }
                }
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
            HashMap<FuncionDto, HashMap<SalaDto, PeliculaDto>> funcionWithDetails = funcionModel.getFuncionAndSalaAndPeliculaByFuncionId(id);
            DateChooser dateChooser = new DateChooser();

            if (funcionWithDetails == null || funcionWithDetails.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontró la función con el ID: " + id, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            FuncionDto funcion = null;
            SalaDto sala = null;
            PeliculaDto pelicula = null;
    
            for (Map.Entry<FuncionDto, HashMap<SalaDto, PeliculaDto>> funcionEntry : funcionWithDetails.entrySet()) {
                funcion = funcionEntry.getKey();
                HashMap<SalaDto, PeliculaDto> innerMap = funcionEntry.getValue();
                
                for (Map.Entry<SalaDto, PeliculaDto> innerEntry : innerMap.entrySet()) {
                    sala = innerEntry.getKey();
                    pelicula = innerEntry.getValue();
                }
            }
            
            if (funcion == null || sala == null || pelicula == null) {
                throw new IllegalStateException("The retrieved function data is incomplete.");
            }
    
            PeliculaDto[] allPeliculas = peliculaModel.getAllMovies();
            SalaDto[] allSalas = salaModel.getSalas();
    
            JLabel posterImageLabel = new JLabel();
            posterImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            posterImageLabel.setPreferredSize(new Dimension(120, 180));
    
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    
            JTextField diaField = new JTextField(funcion.getActivoDesde().format(dateFormatter));
            JTextField horaInicioField = new JTextField(funcion.getActivoDesde().format(timeFormatter));
            JTextField horaFinField = new JTextField(funcion.getActiveHasta().format(timeFormatter));
            
            dateChooser.setTextField(diaField);
    
            JComboBox<PeliculaDto> peliculaComboBox = new JComboBox<>(allPeliculas);
            JComboBox<SalaDto> salaComboBox = new JComboBox<>(allSalas);
    
            peliculaComboBox.setSelectedItem(pelicula);
            salaComboBox.setSelectedItem(sala);
            
            ImageIcon initialPoster = ImageMagic.resizeImage(new ImageIcon(pelicula.getLogo()), 120, 180);
            posterImageLabel.setIcon(initialPoster);
    
            peliculaComboBox.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    PeliculaDto newPelicula = (PeliculaDto) e.getItem();
                    
                    ImageIcon newPoster = ImageMagic.resizeImage(new ImageIcon(newPelicula.getLogo()), 120, 180);
                    
                    posterImageLabel.setIcon(newPoster);
                     
                }
            });
    
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.add(Box.createVerticalStrut(10));
            mainPanel.add(posterImageLabel);
            mainPanel.add(Box.createVerticalStrut(20));
    
            JPanel fieldsPanel = new JPanel(new GridLayout(0, 2, 5, 5));
            fieldsPanel.add(new JLabel("Película:"));
            fieldsPanel.add(peliculaComboBox);
            fieldsPanel.add(new JLabel("Sala:"));
            fieldsPanel.add(salaComboBox);
            fieldsPanel.add(new JLabel("Día (YYYY-MM-DD):"));
            fieldsPanel.add(diaField);
            fieldsPanel.add(new JLabel("Hora de inicio (HH:MM):"));
            fieldsPanel.add(horaInicioField);
            fieldsPanel.add(new JLabel("Hora de terminación (HH:MM):"));
            fieldsPanel.add(horaFinField);
    
            mainPanel.add(fieldsPanel);
    
            int result = JOptionPane.showConfirmDialog(
                    null, mainPanel, "Actualizar Función",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
            );
    
            if (result == JOptionPane.OK_OPTION) {
                PeliculaDto selectedPelicula = (PeliculaDto) peliculaComboBox.getSelectedItem();
                SalaDto selectedSala = (SalaDto) salaComboBox.getSelectedItem();
    
                String newStartDateStr = diaField.getText() + " " + horaInicioField.getText();
                String newEndDateStr = diaField.getText() + " " + horaFinField.getText();
    
                DateTimeFormatter fullFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                LocalDateTime newActivoDesde = LocalDateTime.parse(newStartDateStr, fullFormatter);
                LocalDateTime newActivoHasta = LocalDateTime.parse(newEndDateStr, fullFormatter);

                FuncionDto updatedFuncion = new FuncionBuilder()
                        .withId(id)
                        .withPeliculaId(selectedPelicula.getId())
                        .withSalaId(selectedSala.getId())
                        .withActivoDesde(newActivoDesde)
                        .withActivoHasta(newActivoHasta)
                        .build();
    
                funcionModel.updateFuncion(updatedFuncion);
                
                tableModel.setValueAt(updatedFuncion.getActivoDesde(), row, 1);
                tableModel.setValueAt(updatedFuncion.getActiveHasta(), row, 2);
                tableModel.setValueAt(selectedPelicula.getNombre(), row, 3);
                tableModel.setValueAt(selectedSala.getNombre(), row, 4);
            }
        }


    public void dialogToDeleteCartelera(int id, int row) throws Exception {
        String message = "¿Estás seguro en eliminar la función?";

        String title = "Eliminación de Función";

        int response = JOptionPane.showConfirmDialog(
                null,
                message,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            funcionModel.deleteFuncion(id);
            
            tableModel.removeRow(row);
        }
    }

    private RowEvent getEventByColumn(int column) {
        return switch (column) {
            case 5 ->
                RowEvent.UPDATE_ROW;
            case 6 ->
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
        title_jlbl.setText("Busquedas de Funciones");

        status_cartelera_jlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Activa Desde", "Activa Hasta", "Pelicula", "Sala", "U", "D"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
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
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
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
