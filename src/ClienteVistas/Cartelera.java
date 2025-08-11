package ClienteVistas;

import DTOs.CarteleraDto;
import DTOs.FuncionDto;
import DTOs.PeliculaDto;
import JObjects.SideBarBuilder;
import Modelo.CarteleraModel;
import Modelo.FuncionModel;
import Utils.Global;
import Vista.InicioSesion;
import VentaBoletosVistas.CompraBoletos;
import Vista.MiCuenta;
import com.raven.datechooser.DateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class Cartelera extends javax.swing.JFrame {

    private FuncionModel funcionModel;
    private CarteleraModel carteleraModel;

    private JPanel showtimesPanel, moviesContainer;
    private final LocalDate today = LocalDate.now();
    private JPanel previousDateSelected;
    private String dateSelectedAsString;

    public JFrame parent;
    public boolean isSuccessInConstructor;

    private PeliculaDto[] peliculas;
    private CarteleraDto cartelera;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cartelera_jlbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        soon_movies_pnl = new javax.swing.JPanel();
        funciones_jtxtpn = new javax.swing.JScrollPane();
        horarios_jspn = new javax.swing.JScrollPane();
        horarios_jpnl = new javax.swing.JPanel();

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

        javax.swing.GroupLayout horarios_jpnlLayout = new javax.swing.GroupLayout(horarios_jpnl);
        horarios_jpnl.setLayout(horarios_jpnlLayout);
        horarios_jpnlLayout.setHorizontalGroup(
            horarios_jpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        horarios_jpnlLayout.setVerticalGroup(
            horarios_jpnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        horarios_jspn.setViewportView(horarios_jpnl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(funciones_jtxtpn)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(cartelera_jlbl)
                    .addComponent(horarios_jspn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(cartelera_jlbl)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(horarios_jspn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(funciones_jtxtpn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Cartelera() throws Exception {
        initComponents();

        setLocationRelativeTo(null);
        setTitle("TicketNet | Cartelera de Películas | Usuario << " + Global.user.getUsername() + " >>");

        DateChooser dateChooser = new DateChooser();

        funcionModel = new FuncionModel();
        carteleraModel = new CarteleraModel();

        cartelera = carteleraModel.getCarteleraActivated();
        peliculas = carteleraModel.getPeliculasFromCarteleraById(cartelera.getId());

        if (cartelera == null) {
            Global.destroySession();

            JOptionPane.showMessageDialog(this, "No hay una cartelera activa", "Mensaje", JOptionPane.WARNING_MESSAGE);

            isSuccessInConstructor = false;

            return;
        }

        FuncionDto[] funcionesDelMes = funcionModel.getFuncionesByMonthAndYearAndCarteleraId(today.getMonth().getValue(), today.getYear(), cartelera.getId());

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

            moviePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            moviePanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    DetallesPelicula detallesPelicula = new DetallesPelicula(pelicula);
                    detallesPelicula.setVisible(true);

                    detallesPelicula.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

                    detallesPelicula.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            detallesPelicula.setVisible(false);

                            setVisible(true);
                        }
                    });

                    setVisible(false);

                    detallesPelicula.setVisible(true);
                }
            });

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

        moviesContainer = new JPanel();
        moviesContainer.setLayout(new BoxLayout(moviesContainer, BoxLayout.PAGE_AXIS));
        moviesContainer.setBorder(new EmptyBorder(10, 10, 10, 10));

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
                        ex.printStackTrace();
                    }

                    setVisible(false);
                })
                .addOption("Mi cuenta", () -> {
                    try {
                        new MiCuenta(Global.user).setVisible(true);
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                    
                    setVisible(false);
                })
                .addOption("Cerrar Sesión", () -> {
                    Global.destroySession();

                    new InicioSesion().setVisible(true);
                    setVisible(false);
                })
                .build(0, 0, 167, 700);

        getContentPane().add(sidebar);

        horarios_jpnl = new JPanel();
        horarios_jpnl.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        horarios_jpnl.setBorder(null);
        
        for (FuncionDto funcion : funcionesDelMes) {
            LocalDateTime startDate = funcion.getActivoDesde();

            DateTimeFormatter formatterForDayAndMonth = DateTimeFormatter.ofPattern("d MMM", Locale.of("es"));
            DateTimeFormatter formatterForNameOfDayOfWeek = DateTimeFormatter.ofPattern("EEEE", Locale.of("es"));

            String day_month = startDate.format(formatterForDayAndMonth);
            String nameOfDayOfWeek = startDate.format(formatterForNameOfDayOfWeek);

            boolean isSelectedDay = today.isEqual(startDate.toLocalDate());
 
            horarios_jpnl.add(createVerticalLabelGroup(day_month, nameOfDayOfWeek, startDate.toLocalDate(), isSelectedDay));
        }

        horarios_jspn.setViewportView(horarios_jpnl);
        horarios_jspn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        horarios_jspn.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        isSuccessInConstructor = true;
        
        loadFuncionesFromDate(today);
    }

    public final void loadFuncionesFromDate(LocalDate date) throws Exception {
        moviesContainer.removeAll();
        
        for (PeliculaDto pelicula : peliculas) {
            FuncionDto[] funciones = funcionModel.getFuncionesOfMovieByDateAndPeliculaIdAndCarteleraId(date, pelicula.getId(), cartelera.getId());
            
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

            showtimesPanel = new JPanel();
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
            funciones_jtxtpn.revalidate();
            funciones_jtxtpn.repaint();
        }
    }

    private JPanel createVerticalLabelGroup(String topText, String bottomText, LocalDate date, boolean isSelectedDay) throws Exception {
        JPanel verticalGroup = new JPanel();
        verticalGroup.setName(topText);

        verticalGroup.setLayout(new BoxLayout(verticalGroup, BoxLayout.Y_AXIS));

        JLabel labelTop = new JLabel(topText);
        labelTop.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelTop.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelBottom = new JLabel(bottomText);
        labelBottom.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        labelBottom.setAlignmentX(Component.CENTER_ALIGNMENT);

        verticalGroup.setPreferredSize(new Dimension(90, 100));

        verticalGroup.add(Box.createVerticalGlue());
        verticalGroup.add(labelTop);
        verticalGroup.add(Box.createVerticalStrut(5)); // The 5px vertical gap
        verticalGroup.add(labelBottom);
        verticalGroup.add(Box.createVerticalGlue());

        verticalGroup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        verticalGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                verticalGroup.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (verticalGroup.getName().equals(dateSelectedAsString)) {
                    return;
                }

                verticalGroup.setBackground(null);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (previousDateSelected != null) {
                    previousDateSelected.setBackground(null);
                }
                
                dateSelectedAsString = verticalGroup.getName();
                previousDateSelected = verticalGroup;
                verticalGroup.setBackground(Color.YELLOW);
                
                try {
                    loadFuncionesFromDate(date);
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        if (isSelectedDay) {
            verticalGroup.setBackground(Color.YELLOW);
            previousDateSelected = verticalGroup;
            dateSelectedAsString = verticalGroup.getName();
        }

        return verticalGroup;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cartelera_jlbl;
    private javax.swing.JScrollPane funciones_jtxtpn;
    private javax.swing.JPanel horarios_jpnl;
    private javax.swing.JScrollPane horarios_jspn;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel soon_movies_pnl;
    // End of variables declaration//GEN-END:variables
}
