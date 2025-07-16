package AdministradorVistas;

import JObjects.SideBarBuilder;
import Utils.Global;
import Vista.InicioSesion;
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
    private void initComponents() {

        Funciones = new javax.swing.JButton();
        cartelaras_btn = new javax.swing.JButton();
        peliculas_btn = new javax.swing.JButton();
        salas_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Funciones.setText("Funciones");

        cartelaras_btn.setText("Carteleras");

        peliculas_btn.setText("Peliculas");
        peliculas_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peliculas_btnActionPerformed(evt);
            }
        });

        salas_btn.setText("Salas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(192, Short.MAX_VALUE)
                        .addComponent(salas_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(Funciones, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(190, Short.MAX_VALUE)
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
    }

    private void peliculas_btnActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        PanelPeliculas panelPeliculas = new PanelPeliculas();
    }

    private javax.swing.JButton Funciones;
    private javax.swing.JButton cartelaras_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton peliculas_btn;
    private javax.swing.JButton salas_btn;
}
