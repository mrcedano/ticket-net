package ClienteVistas;

import DTOs.PeliculaDto;
import JObjects.SideBarBuilder;
import Modelo.CarteleraModel;
import Utils.Global;
import Vista.InicioSesion;
import Vista.PV_Cantidad;
import java.awt.Component;
import java.awt.Image;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class panel extends javax.swing.JFrame { 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cartelera_jlbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        soon_movies_pnl = new javax.swing.JPanel();
        profile_pnl = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cartelera_jlbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cartelera_jlbl.setText("Ahora mismo en Cartelera!");

        javax.swing.GroupLayout soon_movies_pnlLayout = new javax.swing.GroupLayout(soon_movies_pnl);
        soon_movies_pnl.setLayout(soon_movies_pnlLayout);
        soon_movies_pnlLayout.setHorizontalGroup(
            soon_movies_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        soon_movies_pnlLayout.setVerticalGroup(
            soon_movies_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(soon_movies_pnl);

        profile_pnl.setBackground(new java.awt.Color(255, 102, 102));
        profile_pnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Comprar Boletos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(profile_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartelera_jlbl))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(266, 266, 266))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(cartelera_jlbl))
                    .addComponent(profile_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PV_Cantidad objCan = new PV_Cantidad();
        objCan.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    public panel() throws Exception {
    initComponents();
    
    setLocationRelativeTo(null);
    setTitle("TicketNet | Cartelera de Películas | Usuario << " + Global.user.getUsername() + " >>"); 
   
    CarteleraModel carteleraModel = new CarteleraModel();
    PeliculaDto[] peliculas = carteleraModel.getAllPeliculasFromCarteleras();
    soon_movies_pnl.setLayout(new BoxLayout(soon_movies_pnl, BoxLayout.LINE_AXIS));
    for (int i = 0; i < peliculas.length; i++) {
        PeliculaDto pelicula = peliculas[i];
        
        JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.PAGE_AXIS));

      ImageIcon ico = new ImageIcon(
            new ImageIcon(pelicula.getLogo()).getImage().getScaledInstance(120, 180, Image.SCALE_SMOOTH)
        );
        JLabel poster = new JLabel(ico);
        poster.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel(pelicula.getNombre());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        moviePanel.add(poster);
        moviePanel.add(Box.createVerticalStrut(5));
        moviePanel.add(title);

        soon_movies_pnl.add(moviePanel);
        soon_movies_pnl.add(Box.createHorizontalStrut(5));

        if (i < peliculas.length - 1) {
            soon_movies_pnl.add(Box.createHorizontalStrut(5));
        }
    }
 
    jScrollPane2.setViewportView(soon_movies_pnl);
    jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    JPanel sidebar = new SideBarBuilder()
                         .addOption("Cartelera", () -> {
                             System.out.println("You clicked on Cartelera!");
                         })
                         .addOption("Ver Historial", () -> {
                             System.out.println("You clicked on Ver Historial");
                         })
                         .addOption("Ver promociones", () -> {
                            System.out.println("You clicked on Ver Promociones");
                         })
                         .addOption("Cerrar Sesión", () -> {
                             
                             Global.destroySession();
                             
                             new InicioSesion().setVisible(true);
                             setVisible(false);
                         })
                         .build(0, 69, 167, 500);
    
    getContentPane().add(sidebar);

    profile_pnl.setBounds(0, 0, 300, 10);
}
   
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cartelera_jlbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel profile_pnl;
    private javax.swing.JPanel soon_movies_pnl;
    // End of variables declaration//GEN-END:variables
}
