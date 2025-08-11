package CajeroVistas;

import DTOs.CarteleraDto;
import DTOs.FuncionDto;
import DTOs.PeliculaDto;
import JObjects.SideBarBuilder;
import Modelo.CarteleraModel;
import Modelo.FuncionModel;
import Utils.Global;
import VentaBoletosVistas.CompraBoletos;
import Vista.InicioSesion;
import Vista.MiCuenta;
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
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EmptyBorder;

public class Venta extends javax.swing.JFrame {

    private final CarteleraModel carteleraModel;
    private final FuncionModel funcionModel;

    private PeliculaDto[] peliculas;
    private final CarteleraDto cartelera;

    private JPanel horarios_jpnl;

    private final LocalDate today = LocalDate.now();

    private JPanel previousDateSelected;
    private String dateSelectedAsString;

    private JPanel showtimesPanel, moviesContainer;

    public Venta() throws Exception {
        initComponents();

        setTitle("TicketNet | Venta de boletos");
        setLocationRelativeTo(null);

        carteleraModel = new CarteleraModel();
        funcionModel = new FuncionModel();

        cartelera = carteleraModel.getCarteleraActivated();

        FuncionDto[] funcionesDelMes = funcionModel.getFuncionesByMonthAndYearAndCarteleraId(today.getMonth().getValue(), today.getYear(), cartelera.getId());

        if (cartelera == null) {
            JOptionPane.showMessageDialog(this, "No hay ninguna cartelera activa, por favor notificar a un administrador", "Mensaje", JOptionPane.WARNING_MESSAGE);

            return;
        }

        JPanel sidebar = new SideBarBuilder()
                .addOption("Panel", () -> {
                    try {
                        new Panel().setVisible(true);
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
                .addOption("Cerrar Sesión", () -> {
                    Global.destroySession();

                    new InicioSesion().setVisible(true);
                    setVisible(false);
                })
                .build(0, 0, 167, 400);

        getContentPane().add(sidebar);

        peliculas = carteleraModel.getPeliculasFromCarteleraById(cartelera.getId());

        moviesContainer = new JPanel();
        moviesContainer.setLayout(new BoxLayout(moviesContainer, BoxLayout.PAGE_AXIS));
        moviesContainer.setBorder(new EmptyBorder(10, 10, 10, 10));

        cinema_shows_jscllpn.setBorder(null);
        cinema_shows_jscllpn.setViewportView(moviesContainer);
        cinema_shows_jscllpn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        cinema_shows_jscllpn.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

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

        horarios_jscllpn.setViewportView(horarios_jpnl);
        horarios_jscllpn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        horarios_jscllpn.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
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
        
            cinema_shows_jscllpn.revalidate();
            cinema_shows_jscllpn.repaint();
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

        verticalGroup.setPreferredSize(new Dimension(90, 50));

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
                } catch (Exception ex) {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        horarios_jscllpn = new javax.swing.JScrollPane();
        cinema_shows_jscllpn = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Venta de boleto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(cinema_shows_jscllpn, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(horarios_jscllpn)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(147, 147, 147))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(horarios_jscllpn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cinema_shows_jscllpn, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane cinema_shows_jscllpn;
    private javax.swing.JScrollPane horarios_jscllpn;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
