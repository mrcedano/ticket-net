import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarCarteleraPanel extends JPanel {
    
    public EditarCarteleraPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        // Main content panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK, 2, true), 
            "Editar Cartelera", 
            TitledBorder.CENTER, 
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 16)
        ));
        mainPanel.setBackground(Color.WHITE);
        
        // Top panel with checkbox
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(Color.WHITE);
        JCheckBox activarCheckbox = new JCheckBox("Activar", true);
        activarCheckbox.setFont(new Font("Arial", Font.PLAIN, 14));
        topPanel.add(activarCheckbox);
        
        // Center panel with movies and controls
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        
        // Left side - Search and movies
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.WHITE);
        
        // Search panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBackground(Color.WHITE);
        JLabel searchLabel = new JLabel("Search movie");
        searchLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        JTextField searchField = new JTextField(15);
        searchPanel.add(searchLabel);
        searchPanel.add(Box.createVerticalStrut(5));
        searchPanel.add(searchField);
        
        // Movies panel with title
        JPanel moviesContainer = new JPanel(new BorderLayout());
        moviesContainer.setBackground(Color.WHITE);
        
        JLabel moviesTitle = new JLabel("Librería de Películas", JLabel.CENTER);
        moviesTitle.setFont(new Font("Arial", Font.BOLD, 14));
        moviesContainer.add(moviesTitle, BorderLayout.NORTH);
        
        // Movies grid panel with scroll - THIS IS THE KEY CHANGE
        JPanel moviesPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // 0 rows = unlimited rows, 2 columns
        moviesPanel.setBackground(Color.WHITE);
        moviesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create movie panels - now we can add as many as we want
        moviesPanel.add(createMoviePanel("Minecraft Movie", true));
        moviesPanel.add(createMoviePanel("The Net", true));
        moviesPanel.add(createMoviePanel("Toy Story 4", true));
        moviesPanel.add(createMoviePanel("Superman", false));
        moviesPanel.add(createMoviePanel("Five Nights At Freddys 2", false));
        moviesPanel.add(createMoviePanel("Avatar", false));
        moviesPanel.add(createMoviePanel("Inception", false));
        moviesPanel.add(createMoviePanel("The Matrix", true));
        moviesPanel.add(createMoviePanel("Interstellar", false));
        moviesPanel.add(createMoviePanel("Spider-Man", true));
        
        // Wrap the movies panel in a JScrollPane - THIS ADDS THE VERTICAL SLIDER
        JScrollPane moviesScrollPane = new JScrollPane(moviesPanel);
        moviesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        moviesScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        moviesScrollPane.getVerticalScrollBar().setUnitIncrement(16); // Smoother scrolling
        moviesScrollPane.setPreferredSize(new Dimension(300, 400)); // Set a fixed height to ensure scrolling
        moviesScrollPane.setBackground(Color.WHITE);
        
        moviesContainer.add(moviesScrollPane, BorderLayout.CENTER);
        
        leftPanel.add(searchPanel, BorderLayout.NORTH);
        leftPanel.add(moviesContainer, BorderLayout.CENTER);
        
        // Right side - Controls
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Active from section
        JLabel activoDesdeLabel = new JLabel("Activo desde");
        activoDesdeLabel.setFont(new Font("Arial", Font.BOLD, 12));
        activoDesdeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JTextField activoDesdeField = new JTextField("2025-01-01");
        activoDesdeField.setMaximumSize(new Dimension(150, 30));
        activoDesdeField.setAlignmentX(Component.CENTER_ALIGNMENT);
        activoDesdeField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        
        // Active until section
        JLabel activoHastaLabel = new JLabel("Activo hasta");
        activoHastaLabel.setFont(new Font("Arial", Font.BOLD, 12));
        activoHastaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JTextField activoHastaField = new JTextField("2025-01-30");
        activoHastaField.setMaximumSize(new Dimension(150, 30));
        activoHastaField.setAlignmentX(Component.CENTER_ALIGNMENT);
        activoHastaField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        
        // Functions button
        JButton funcionesButton = new JButton("Funciones");
        funcionesButton.setMaximumSize(new Dimension(120, 35));
        funcionesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        funcionesButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        funcionesButton.setBackground(Color.WHITE);
        
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
        rightPanel.add(Box.createVerticalGlue());
        
        centerPanel.add(leftPanel, BorderLayout.CENTER);
        centerPanel.add(rightPanel, BorderLayout.EAST);
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(Color.WHITE);
        JLabel sliderNote = new JLabel("This layout now has a vertical slider");
        sliderNote.setFont(new Font("Arial", Font.ITALIC, 12));
        sliderNote.setForeground(Color.GRAY);
        bottomPanel.add(sliderNote);
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        add(mainPanel, BorderLayout.CENTER);
    }
    
    private JPanel createMoviePanel(String movieName, boolean isChecked) {
        JPanel moviePanel = new JPanel(new BorderLayout());
        moviePanel.setBackground(Color.WHITE);
        moviePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        moviePanel.setPreferredSize(new Dimension(120, 160));
        
        // Checkbox in top-right corner
        JPanel checkboxPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        checkboxPanel.setBackground(Color.WHITE);
        JCheckBox movieCheckbox = new JCheckBox();
        movieCheckbox.setSelected(isChecked);
        movieCheckbox.setBackground(Color.WHITE);
        checkboxPanel.add(movieCheckbox);
        
        // Movie poster placeholder
        JPanel posterPanel = new JPanel();
        posterPanel.setBackground(getMovieColor(movieName));
        posterPanel.setPreferredSize(new Dimension(100, 120));
        
        // Movie title
        JLabel titleLabel = new JLabel(movieName, JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(posterPanel.getBackground());
        titleLabel.setForeground(Color.WHITE);
        
        posterPanel.setLayout(new BorderLayout());
        posterPanel.add(titleLabel, BorderLayout.SOUTH);
        
        moviePanel.add(checkboxPanel, BorderLayout.NORTH);
        moviePanel.add(posterPanel, BorderLayout.CENTER);
        
        return moviePanel;
    }
    
    private Color getMovieColor(String movieName) {
        // Different colors for different movies to simulate posters
        switch (movieName) {
            case "Minecraft Movie": return new Color(46, 125, 50);
            case "The Net": return new Color(13, 71, 161);
            case "Toy Story 4": return new Color(183, 28, 28);
            case "Superman": return new Color(191, 54, 12);
            case "Five Nights At Freddys 2": return new Color(142, 36, 170);
            case "Avatar": return new Color(0, 150, 136);
            case "Inception": return new Color(96, 125, 139);
            case "The Matrix": return new Color(76, 175, 80);
            case "Interstellar": return new Color(255, 152, 0);
            case "Spider-Man": return new Color(244, 67, 54);
            default: return Color.GRAY;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Editar Cartelera");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            
            EditarCarteleraPanel panel = new EditarCarteleraPanel();
            frame.add(panel);
            
            frame.setVisible(true);
        });
    }
}