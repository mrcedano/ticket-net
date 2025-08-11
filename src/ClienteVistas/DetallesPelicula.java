package ClienteVistas;

import DTOs.PeliculaDto;
import Utils.ImageMagic;
import Vista.Pelicula;
import javax.swing.*;
import java.awt.*;

public class DetallesPelicula extends JFrame {

    private JLabel lblTitulo, lblPoster, lblDuracion, lblClasificacion, lblIdioma, lblFormato, lblReparto;
    private JTextArea txtSinopsis;
    private JButton btnComprar, btnRegresar;
    
    public JFrame parent;

    public DetallesPelicula(PeliculaDto peli) {
        setTitle("Detalles de Película");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(48, 48, 48)); // Fondo oscuro uniforme

        Font fuenteTitulo = new Font("SansSerif", Font.BOLD, 28);
        Font fuenteTexto = new Font("SansSerif", Font.BOLD, 18);
        Font fuenteBoton = new Font("SansSerif", Font.BOLD, 16);

        lblTitulo = new JLabel(peli.getNombre(), SwingConstants.CENTER);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setBounds(0, 20, 900, 35);
        add(lblTitulo);

        lblPoster = new JLabel();
        lblPoster.setBounds(50, 70, 800, 300);
        lblPoster.setHorizontalAlignment(JLabel.CENTER);
        
        if (peli.getLogo() != "") {
            ImageIcon poster = new ImageIcon(peli.getLogo());
            Image img = ImageMagic.resizeImage(poster, 300, 300).getImage();
            lblPoster.setIcon(new ImageIcon(img));
        } else {
            lblPoster.setText("Imagen no encontrada");
            lblPoster.setForeground(Color.RED);
            lblPoster.setHorizontalAlignment(SwingConstants.CENTER);
        }
        add(lblPoster);

        // Información técnica
        int xInfo = 60;
        int yBase = 390;
        int espacio = 30;

        lblDuracion = crearLabel("Duración: " + peli.getDuration(), xInfo, yBase, fuenteTexto);
        lblClasificacion = crearLabel("Clasificación: " + peli.getPublic_objetive(), xInfo, yBase + espacio, fuenteTexto);
        lblIdioma = crearLabel("Idioma: " + "Español", xInfo, yBase + espacio * 2, fuenteTexto);
        lblFormato = crearLabel("Formato: " + "Normal", xInfo, yBase + espacio * 3, fuenteTexto);
        lblReparto = crearLabel("Reparto: " + peli.getDirectors() + " | " + peli.getActors(), xInfo, yBase + espacio * 4, fuenteTexto);

        add(lblDuracion);
        add(lblClasificacion);
        add(lblIdioma);
        add(lblFormato);
        add(lblReparto);

        // Sinopsis sin bordes ni fondo distinto
        txtSinopsis = new JTextArea("Sinopsis: " + "Una Película muy interesante!");
        txtSinopsis.setWrapStyleWord(true);
        txtSinopsis.setLineWrap(true);
        txtSinopsis.setEditable(false);
        txtSinopsis.setFont(fuenteTexto);
        txtSinopsis.setForeground(Color.WHITE);
        txtSinopsis.setBackground(new Color(48, 48, 48)); // Igual al fondo
        txtSinopsis.setBounds(470, yBase, 380, 150);
        txtSinopsis.setBorder(null); // Sin borde
        add(txtSinopsis);

        // Botón Comprar
        btnComprar = new JButton("Comprar");
        btnComprar.setBounds(680, 550, 150, 45);
        btnComprar.setBackground(new Color(0, 153, 51));
        btnComprar.setForeground(Color.WHITE);
        btnComprar.setFont(fuenteBoton);
        btnComprar.setFocusPainted(false);
        btnComprar.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnComprar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "¡Gracias por tu compra!\nDisfruta la función");
        });
        add(btnComprar);

        // Botón Regresar
        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(60, 550, 150, 45);
        btnRegresar.setBackground(new Color(200, 0, 0));
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setFont(fuenteBoton);
        btnRegresar.setFocusPainted(false);
        btnRegresar.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnRegresar.addActionListener(e -> dispose());
        add(btnRegresar);

        setVisible(true);
    }

    private JLabel crearLabel(String texto, int x, int y, Font fuente) {
        JLabel lbl = new JLabel(texto);
        lbl.setForeground(Color.WHITE);
        lbl.setFont(fuente);
        lbl.setBounds(x, y, 400, 25);
        return lbl;
    }
}