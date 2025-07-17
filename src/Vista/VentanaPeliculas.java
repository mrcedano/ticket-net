package Vista;

import AdministradorVistas.AddMovie;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class VentanaPeliculas {
    public static void main(String[] args) {
        
        
    }

    void setVisible(boolean b) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Añadir Película");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new AddMovie());
            frame.setSize(500, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
