/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AdministradorVistas;

import ClienteVistas.Cartelera;
import ClienteVistas.Historial;
import DTOs.UserDto;
import Enums.UserTypes;
import static Enums.UserTypes.ADMINISTRADOR;
import static Enums.UserTypes.CAJERO;
import static Enums.UserTypes.CLIENTE;
import JObjects.SideBarBuilder;
import Modelo.UserModel;
import Utils.Global;
import static Utils.Global.user;
import Utils.ImageCellRenderer;
import Utils.Media;
import Vista.InicioSesion;
import Vista.MiCuenta;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author cedsc
 */
public class IndexUsuarios extends javax.swing.JFrame {

    private enum RowEvent {
        DELETE_ROW,
        UPDATE_ROW,
    }

    private final List<Integer> indexesOfActionColumns = List.of(3, 4);

    private UserModel userModel;

    private final DefaultTableModel tableModel;

    public IndexUsuarios() throws Exception {
        initComponents();
        setTitle("TickeNet | Índice de Usuarios");
        setLocationRelativeTo(null);

        userModel = new UserModel();

        tableModel = (DefaultTableModel) jTable1.getModel();

        jTable1.setRowHeight(30);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        TableColumn updateColumn = jTable1.getColumn("U");
        TableColumn deleteColumn = jTable1.getColumn("D");

        updateColumn.setCellRenderer(new ImageCellRenderer());
        deleteColumn.setCellRenderer(new ImageCellRenderer());

        UserDto[] users = userModel.getUsers();

        if (users != null && users.length > 0) {
            for (UserDto user : users) {
                int id = user.getId();
                UserTypes type = user.getType();
                String name = user.getUsername();
                String password = user.getPassword();
                String email = user.getCorreo();
                String status = user.getStatus() == 1 ? "✅" : "❌";

                Object dto[] = new Object[]{id, name, status, Media.Pen, Media.Trashbin};

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
                            dialogToUpdateUsuario(id, row);
                        case DELETE_ROW ->
                            dialogToDeleteUsuario(id, row);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        JPanel sidebar = new SideBarBuilder()
                .addOption("Panel", () -> {
                    try {
                        new AdministradorVistas.Panel().setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    setVisible(false);
                })
                .addOption("Mi cuenta", () -> {
                    try {
                        new MiCuenta(Global.user).setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    setVisible(false);
                })
                .addOption("Usuarios", () -> {
                })
                .addOption("Cerrar Sesión", () -> {
                    Global.destroySession();

                    new InicioSesion().setVisible(true);
                    setVisible(false);
                })
                .build(0, 0, 167, 700);

        getContentPane().add(sidebar);
    }

    public void dialogToUpdateUsuario(int id, int rowFromTableModel) throws Exception {
        UserDto user = userModel.findUserById(id);

        JTextField usernameField = new JTextField(user.getUsername());
        JTextField passwordField = new JTextField(user.getPassword());
        JTextField emailField = new JTextField(user.getCorreo());

        String[] roles = {"Administrador", "Cajero", "Cliente"};
        String[] statuses = {"Activo", "Inactivo"};

        JComboBox<String> roleCombo = new JComboBox<>(roles);
        JComboBox<String> statusCombo = new JComboBox<>(statuses);

        int typeAsNumber = 0;

        switch (user.getType()) {
            case ADMINISTRADOR ->
                typeAsNumber = 0;
            case CAJERO ->
                typeAsNumber = 1;
            case CLIENTE ->
                typeAsNumber = 2;
        }

        roleCombo.setSelectedIndex(typeAsNumber);
        statusCombo.setSelectedIndex(user.getStatus() == 1 ? 0 : 1);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;

        int row = 0;

        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Username"), gbc);
        gbc.gridx = 1;
        panel.add(usernameField, gbc);
        row++;

        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Password"), gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);
        row++;

        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Email"), gbc);
        gbc.gridx = 1;
        panel.add(emailField, gbc);
        row++;

        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Rol"), gbc);
        gbc.gridx = 1;
        panel.add(roleCombo, gbc);
        row++;

        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Estado"), gbc);
        gbc.gridx = 1;
        panel.add(statusCombo, gbc);
        row++;

        Object[] options = {"Cancelar", "Guardar"};

        int result = JOptionPane.showOptionDialog(
                null,
                panel,
                "Actualizar Usuario",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[1]
        );

        if (result == 1) {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String email = emailField.getText();
            int role = roleCombo.getSelectedIndex();
            int status = statusCombo.getSelectedIndex() == 1 ? 0 : 1;

            UserDto userToUpdate = new UserDto(id, username, password, email, (short) role, status);

            userModel.updateUser(userToUpdate);

            tableModel.setValueAt(username, rowFromTableModel, 1);
            tableModel.setValueAt(status == 0 ? "❌" : "✅", rowFromTableModel, 2);
        }
    }

    public void dialogToDeleteUsuario(int id, int row) throws Exception {
        userModel.desactivateUserById(id);

        tableModel.setValueAt("❌", row, 2);
    }
    
    public void dialogToAddUsuario() throws Exception {
     JTextField usernameField = new JTextField();
        JTextField passwordField = new JTextField();
        JTextField emailField = new JTextField();

        String[] roles = {"Administrador", "Cajero", "Cliente"};
        String[] statuses = {"Activo", "Inactivo"};

        JComboBox<String> roleCombo = new JComboBox<>(roles);
        JComboBox<String> statusCombo = new JComboBox<>(statuses);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;

        int row = 0;

        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Usuario"), gbc);
        gbc.gridx = 1;
        panel.add(usernameField, gbc);
        row++;

        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Contraseña"), gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);
        row++;

        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Correo"), gbc);
        gbc.gridx = 1;
        panel.add(emailField, gbc);
        row++;

        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Rol"), gbc);
        gbc.gridx = 1;
        panel.add(roleCombo, gbc);
        row++;

        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Estado"), gbc);
        gbc.gridx = 1;
        panel.add(statusCombo, gbc);
        row++;

        Object[] options = {"Cancelar", "Guardar"};

        int result = JOptionPane.showOptionDialog(
                null,
                panel,
                "Actualizar Usuario",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[1]
        );

        if (result == 1) {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String email = emailField.getText();
            int role = roleCombo.getSelectedIndex();
            int status = statusCombo.getSelectedIndex() == 1 ? 0 : 1;
            String statusAsText = status == 1 ? "✅" : "❌";
            
            UserDto userToAdd = new UserDto(0, username, password, email, (short) role, status);

            userModel.addUser(userToAdd);
            
            UserDto lastUser = userModel.getLastUserCreated();
            
            Object dto[] = new Object[]{lastUser.getId(), username, statusAsText, Media.Pen, Media.Trashbin};

            tableModel.addRow(dto);
        }
    }

    private RowEvent getEventByColumn(int column) {
        return switch (column) {
            case 3 ->
                RowEvent.UPDATE_ROW;
            case 4 ->
                RowEvent.DELETE_ROW;
            default ->
                null;
        };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        agregar_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Status", "U", "D"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Usuarios");

        agregar_btn.setText("Agregar");
        agregar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(agregar_btn))
                            .addComponent(jLabel1))
                        .addGap(161, 161, 161)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregar_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_btnActionPerformed
        try {
            dialogToAddUsuario();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_agregar_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
