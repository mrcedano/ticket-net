package ClienteVistas;

import DTOs.FuncionDto;
import DTOs.PeliculaDto;
import JObjects.SideBarBuilder;
import Modelo.CarteleraModel;
import Modelo.FuncionModel;
import Utils.Global;
import Vista.InicioSesion;
import VentaBoletosVistas.CompraBoletos;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.format.DateTimeFormatter;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class Cartelera extends javax.swing.JFrame {
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cartelera_jlbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        soon_movies_pnl = new javax.swing.JPanel();
        profile_pnl = new javax.swing.JPanel();
        funciones_jtxtpn = new javax.swing.JScrollPane();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(profile_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(funciones_jtxtpn)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(cartelera_jlbl))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(cartelera_jlbl)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(profile_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(funciones_jtxtpn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Cartelera() throws Exception {
        initComponents();

        setLocationRelativeTo(null);
        setTitle("TicketNet | Cartelera de Películas | Usuario << " + Global.user.getUsername() + " >>");

        CarteleraModel carteleraModel = new CarteleraModel();
        PeliculaDto[] peliculas = carteleraModel.getPeliculasFromCarteleraById(carteleraModel.getCarteleraActivated().getId());
        int carteleraId = carteleraModel.getCarteleraActivated().getId();

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

        jScrollPane2.setBorder(null);
        jScrollPane2.setViewportView(soon_movies_pnl);
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        FuncionModel funcionModel = new FuncionModel();

        JPanel moviesContainer = new JPanel();
        moviesContainer.setLayout(new BoxLayout(moviesContainer, BoxLayout.PAGE_AXIS));
        moviesContainer.setBorder(new EmptyBorder(10, 10, 10, 10));

        for (PeliculaDto pelicula : peliculas) {
            FuncionDto[] funciones = funcionModel.getFuncionesByCarteleraIdAndPeliculaId(carteleraId, pelicula.getId());

            JPanel moviePanel = new JPanel();
            moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.LINE_AXIS));
            moviePanel.setBorder(new EmptyBorder(10, 0, 20, 0));

            ImageIcon ico = new ImageIcon(
                    new ImageIcon(pelicula.getLogo()).getImage().getScaledInstance(120, 180, Image.SCALE_SMOOTH)
            );
            JLabel poster = new JLabel(ico);
            poster.setPreferredSize(new Dimension(120, 180));
            moviePanel.add(poster);
            moviePanel.add(Box.createHorizontalStrut(15));

            JPanel detailsPanel = new JPanel();
            detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.PAGE_AXIS));

            JLabel title = new JLabel(pelicula.getNombre());
            title.setFont(new Font("Segoe UI", Font.BOLD, 18));
            title.setAlignmentX(Component.LEFT_ALIGNMENT);
            detailsPanel.add(title);
            detailsPanel.add(Box.createVerticalStrut(10));

            JPanel showtimesPanel = new JPanel();
            showtimesPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
            showtimesPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            boolean foundFunctions = funciones.length > 0;

            for (FuncionDto funcion : funciones) {

                JButton timeButton = new JButton(funcion.getActivoDesde().format(timeFormatter));
                timeButton.setPreferredSize(new Dimension(70, 30));

                timeButton.addActionListener(e -> {
                    try {
                        setVisible(false);

                        CompraBoletos compraBoletos = new CompraBoletos(funcion.getId());
                        compraBoletos.setVisible(true);
                        compraBoletos.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

                        compraBoletos.parent = this;

                        compraBoletos.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosing(WindowEvent e) {
                                compraBoletos.setVisible(false);

                                setVisible(true);
                            }
                        });
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });

                showtimesPanel.add(timeButton);
            }

            if (!foundFunctions) {
                JLabel noShowtimes = new JLabel("No hay funciones disponibles");
                showtimesPanel.add(noShowtimes);
            }

            detailsPanel.add(showtimesPanel);
            moviePanel.add(detailsPanel);

            moviesContainer.add(moviePanel);
        }

        funciones_jtxtpn.setBorder(null);
        funciones_jtxtpn.setViewportView(moviesContainer);
        funciones_jtxtpn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        funciones_jtxtpn.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JPanel sidebar = new SideBarBuilder()
                .addOption("Cartelera", () -> {
                })
                .addOption("Ver Historial", () -> {
                    try {
                        new Historial().setVisible(true);
                    } catch (Exception ex) {
                    }

                    setVisible(false);
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
    private javax.swing.JScrollPane funciones_jtxtpn;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel profile_pnl;
    private javax.swing.JPanel soon_movies_pnl;
    // End of variables declaration//GEN-END:variables
}
