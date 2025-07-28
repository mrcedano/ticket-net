package AdministradorVistas;

import Builders.CarteleraBuilder;
import DTOs.CarteleraDto;
import DTOs.PeliculaDto;
import Modelo.CarteleraModel;
import Modelo.PeliculaModel;
import Utils.ImageMagic;
import com.raven.datechooser.DateChooser;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AddMoviesToCartelera extends JFrame {

    private CarteleraDto cartelera;

    private CarteleraModel carteleraModel;
    private PeliculaModel peliculaModel;

    private DateChooser fromDateChooser, toDateChooser;
    private JTextField activoDesdeField, activoHastaField;
    private JCheckBox activarCheckbox;

    private JPanel moviesPanel;

    private ArrayList<Integer> selectedMoviesIds;

    private int id;

    public AddMoviesToCartelera(int id) throws Exception {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        setTitle("TicketNet | Editar cartelera");

        this.id = id;
        this.selectedMoviesIds = new ArrayList<>();

        fromDateChooser = new DateChooser();
        toDateChooser = new DateChooser();

        carteleraModel = new CarteleraModel();
        peliculaModel = new PeliculaModel();

        cartelera = carteleraModel.getCarteleraById(id);

        JPanel mainPanel = new JPanel(new BorderLayout());

        mainPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 0, true),
                "Editar Cartelera",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 16)
        ));
        mainPanel.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(Color.WHITE);
        activarCheckbox = new JCheckBox("Activar", true);
        activarCheckbox.setFont(new Font("Arial", Font.PLAIN, 14));
        topPanel.add(activarCheckbox);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.WHITE);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBackground(Color.WHITE);
        JLabel searchLabel = new JLabel("Search movie");
        searchLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        JTextField searchField = new JTextField(15);
        searchPanel.add(searchLabel);
        searchPanel.add(Box.createVerticalStrut(5));
        searchPanel.add(searchField);

        JPanel moviesContainer = new JPanel(new BorderLayout());
        moviesContainer.setBackground(Color.WHITE);

        JLabel moviesTitle = new JLabel("Librería de Películas", JLabel.CENTER);
        moviesTitle.setFont(new Font("Arial", Font.BOLD, 14));
        moviesContainer.add(moviesTitle, BorderLayout.NORTH);

        moviesPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // 0 rows = unlimited rows, 2 columns
        moviesPanel.setBackground(Color.WHITE);
        moviesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane moviesScrollPane = new JScrollPane(moviesPanel);
        moviesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        moviesScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        moviesScrollPane.getVerticalScrollBar().setUnitIncrement(16); // Smoother scrolling
        moviesScrollPane.setPreferredSize(new Dimension(300, 400)); // Set a fixed height to ensure scrolling
        moviesScrollPane.setBackground(Color.WHITE);

        moviesContainer.add(moviesScrollPane, BorderLayout.CENTER);

        leftPanel.add(searchPanel, BorderLayout.NORTH);
        leftPanel.add(moviesContainer, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel activoDesdeLabel = new JLabel("Activo desde");
        activoDesdeLabel.setFont(new Font("Arial", Font.BOLD, 12));
        activoDesdeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        activoDesdeField = new JTextField();
        activoDesdeField.setMaximumSize(new Dimension(150, 30));
        activoDesdeField.setAlignmentX(Component.CENTER_ALIGNMENT);
        activoDesdeField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

        JLabel activoHastaLabel = new JLabel("Activo hasta");
        activoHastaLabel.setFont(new Font("Arial", Font.BOLD, 12));
        activoHastaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        activoHastaField = new JTextField();
        activoHastaField.setMaximumSize(new Dimension(150, 30));
        activoHastaField.setAlignmentX(Component.CENTER_ALIGNMENT);
        activoHastaField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

        SimpleDateFormat formatForDates = new SimpleDateFormat("YYYY-MM-dd");
        fromDateChooser.setTextField(activoDesdeField);
        toDateChooser.setTextField(activoHastaField);

        fromDateChooser.setDateFormat(formatForDates);
        toDateChooser.setDateFormat(formatForDates);

        fromDateChooser.setDateSelectionMode(DateChooser.DateSelectionMode.SINGLE_DATE_SELECTED);
        toDateChooser.setDateSelectionMode(DateChooser.DateSelectionMode.SINGLE_DATE_SELECTED);

        JButton funcionesButton = new JButton("Funciones");
        funcionesButton.setMaximumSize(new Dimension(120, 35));
        funcionesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        funcionesButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        funcionesButton.setBackground(Color.WHITE);

        funcionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Functions button click
                JOptionPane.showMessageDialog(AddMoviesToCartelera.this,
                        "Funciones button clicked!",
                        "Funciones",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton guardarButton = new JButton("Guardar");
        guardarButton.setMaximumSize(new Dimension(120, 35));
        guardarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        guardarButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        guardarButton.setBackground(Color.WHITE);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveCartelera();

                    JOptionPane.showMessageDialog(AddMoviesToCartelera.this,
                            "Cartelera guardada exitosamente!",
                            "Guardar",
                            JOptionPane.INFORMATION_MESSAGE);

                    dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add components to right panel with spacing
        rightPanel.add(activoDesdeLabel);
        rightPanel.add(Box.createVerticalStrut(5));
        rightPanel.add(activoDesdeField);
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(activoHastaLabel);
        rightPanel.add(Box.createVerticalStrut(5));
        rightPanel.add(activoHastaField);
        rightPanel.add(Box.createVerticalStrut(40));
        rightPanel.add(funcionesButton);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(guardarButton);
        rightPanel.add(Box.createVerticalStrut(20));

        centerPanel.add(leftPanel, BorderLayout.CENTER);
        centerPanel.add(rightPanel, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(Color.WHITE);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);

        loadCarteleraInformationFromDatabase();

        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void saveCartelera() throws Exception {
        LocalDate fromDate = LocalDate.parse(activoDesdeField.getText());
        LocalDate toDate = LocalDate.parse(activoHastaField.getText());
        int estaActivado = activarCheckbox.isSelected() ? 1 : 0;

        CarteleraDto cartelera = new CarteleraBuilder()
                .withFromDate(fromDate)
                .withToDate(toDate)
                .withIsActivated(estaActivado)
                .build();

        carteleraModel.updateCarteleraById(id, cartelera);

        if (selectedMoviesIds.size() > 0) {
            carteleraModel.addMovieToCarteleraById(id, selectedMoviesIds.stream().mapToInt(Integer::intValue).toArray());
        } else {
            carteleraModel.removeMoviesFromCarteleraById(id);
        }
    }

    private void loadCarteleraInformationFromDatabase() throws Exception {
        activoDesdeField.setText(cartelera.getActiveSince().toString());
        activoHastaField.setText(cartelera.getActiveUntil().toString());
        activarCheckbox.setSelected(cartelera.getIsActivated() == 1);

        PeliculaDto[] peliculas = peliculaModel.getMovies();
        PeliculaDto[] selectedPeliculas = carteleraModel.getPeliculasFromCarteleraById(id);

        Set<PeliculaDto> pelicutasAsSet = new HashSet<>(Arrays.asList(peliculas));
        Set<PeliculaDto> selectedPelicualasAsSet = new HashSet<>(Arrays.asList(selectedPeliculas));

        pelicutasAsSet.removeAll(selectedPelicualasAsSet);

        selectedPelicualasAsSet.forEach((n) -> {
            moviesPanel.add(createMoviePanel(n, true));
            selectedMoviesIds.add(n.getId());
        });

        pelicutasAsSet.forEach((n) -> {
            moviesPanel.add(createMoviePanel(n, false));
        });

    }

    private JPanel createMoviePanel(PeliculaDto pelicula, boolean isChecked) {
        JPanel moviePanel = new JPanel(new BorderLayout());
        moviePanel.setBackground(Color.blue);
        moviePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        JPanel checkboxPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        checkboxPanel.setBackground(Color.WHITE);
        JCheckBox movieCheckbox = new JCheckBox();
        movieCheckbox.setSelected(isChecked);
        movieCheckbox.setBackground(Color.WHITE);
        checkboxPanel.add(movieCheckbox);

        Runnable handleSelectionChange = () -> {
            if (movieCheckbox.isSelected()) {
                if (!selectedMoviesIds.contains(pelicula.getId())) {
                    selectedMoviesIds.add(pelicula.getId());
                }
            } else {
                selectedMoviesIds.removeIf(id -> id == pelicula.getId());
            }

            updatePanelAppearance(moviePanel, movieCheckbox.isSelected());
        };

        movieCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                handleSelectionChange.run();
            }
        });

        JPanel posterPanel = new JPanel(new BorderLayout());
        posterPanel.setBackground(Color.white);

        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        try {
            String imagePath = pelicula.getLogo();

            if (imagePath != null) {
                ImageIcon originalIcon = new ImageIcon(imagePath);
                ImageIcon scaledIcon = ImageMagic.resizeImage(originalIcon, 300, 350);
                imageLabel.setIcon(scaledIcon);
            }
        } catch (Exception e) {
            imageLabel.setText("Image Error");
        }

        posterPanel.add(imageLabel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel(pelicula.getNombre(), JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.BLACK);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

        posterPanel.add(titleLabel, BorderLayout.SOUTH);

        moviePanel.add(checkboxPanel, BorderLayout.NORTH);
        moviePanel.add(posterPanel, BorderLayout.CENTER);

        MouseAdapter clickListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                movieCheckbox.setSelected(!movieCheckbox.isSelected());
            }
        };

        moviePanel.addMouseListener(clickListener);
        posterPanel.addMouseListener(clickListener);
        imageLabel.addMouseListener(clickListener);
        titleLabel.addMouseListener(clickListener);

        updatePanelAppearance(moviePanel, isChecked);

        if (isChecked && !selectedMoviesIds.contains(pelicula.getId())) {
            selectedMoviesIds.add(pelicula.getId());
        }

        return moviePanel;
    }

    private void updatePanelAppearance(JPanel moviePanel, boolean isSelected) {
        if (isSelected) {
            moviePanel.setBackground(new Color(173, 216, 230));
        } else {
            moviePanel.setBackground(Color.BLUE);
        }
        moviePanel.repaint();
    }
}
