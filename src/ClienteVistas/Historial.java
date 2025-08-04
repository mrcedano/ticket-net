/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ClienteVistas;

import JObjects.SideBarBuilder;
import Utils.Global;
import Vista.InicioSesion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Historial extends javax.swing.JFrame {

public Historial() throws Exception {
    initComponents();
    setLocationRelativeTo(null);
    setLayout(null); // Use absolute layout for precise control
    
    JPanel sidebar = new SideBarBuilder()
            .addOption("Cartelera", () -> {
                try {
                    new Cartelera().setVisible(true);
                } catch (Exception ex) {
                }
            })
            .addOption("Ver Historial", () -> {
                // Already in Historial view
            })
            .addOption("Cerrar Sesión", () -> {
                Global.destroySession();
                new InicioSesion().setVisible(true);
                setVisible(false);
            })
            .build(0, 69, 167, 500);
    
    getContentPane().add(sidebar);
    
    JLabel titleLabel = new JLabel("Mi Historial de Compras");
    titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
    titleLabel.setBounds(200, 15, 400, 30);
    getContentPane().add(titleLabel);
    
    JPanel historyContainer = new JPanel();
    historyContainer.setLayout(new BoxLayout(historyContainer, BoxLayout.Y_AXIS));
    historyContainer.setBackground(new Color(240, 240, 240)); // Light gray background to match screenshot
    
    JScrollPane scrollPane = new JScrollPane(historyContainer);
    scrollPane.setBounds(200, 60, 550, 400);
    scrollPane.setBorder(null);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    getContentPane().add(scrollPane);
    
    addHistoryItem(historyContainer, "Avatar 2", 2, 1, 120, "resources/271_el-telefono-negro.jpg");
    addHistoryItem(historyContainer, "Avengers: Endgame", 1, 1, 90, "resources/371_matrix.jpg");
    addHistoryItem(historyContainer, "Star Wars", 2, 1, 150, "resources/748_superman.jpg");
}

private void addHistoryItem(JPanel container, String movieTitle, int adults, int children, 
                       int total, String imagePath) {
    JPanel itemPanel = new JPanel();
    itemPanel.setLayout(null);
    itemPanel.setPreferredSize(new Dimension(530, 120));
    itemPanel.setMaximumSize(new Dimension(1050, 120));
    itemPanel.setBackground(new Color(255, 255, 255));
    
    try {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(80, 100, Image.SCALE_SMOOTH);
        ImageIcon posterIcon = new ImageIcon(scaledImage);
        
        JLabel posterLabel = new JLabel(posterIcon);
        posterLabel.setBounds(15, 10, 80, 100);
        itemPanel.add(posterLabel);
    } catch (Exception e) {
        JLabel placeholderLabel = new JLabel("No Image");
        placeholderLabel.setBounds(15, 10, 80, 100);
        placeholderLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        placeholderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemPanel.add(placeholderLabel);
    }
    
    JLabel titleLabel = new JLabel(movieTitle);
    titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
    titleLabel.setBounds(110, 10, 400, 25);
    itemPanel.add(titleLabel);
    
    JLabel adultsLabel = new JLabel("Adultos: " + adults + "  Niños: " + children);
    adultsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    adultsLabel.setBounds(110, 40, 200, 20);
    itemPanel.add(adultsLabel);
    
    JLabel totalLabel = new JLabel("Total: $" + total + " MXN");
    totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
    totalLabel.setBounds(110, 70, 200, 20);     
    itemPanel.add(totalLabel);
    
    JButton printButton = new JButton("Imprimir");  
    printButton.setBounds(400, 70, 100, 30); 
    printButton.setFocusPainted(false);
    printButton.setVisible(true);
    printButton.setOpaque(true);
    printButton.setBorderPainted(true); 
    printButton.addActionListener(e -> {
        JOptionPane.showMessageDialog(itemPanel, 
            "Imprimiendo boleto para " + movieTitle, 
            "Imprimir Boleto", 
            JOptionPane.INFORMATION_MESSAGE);
    });
    
    // Make sure it's added and brought to front
    itemPanel.add(printButton);
    itemPanel.setComponentZOrder(printButton, 0); // Bring to front
    
    container.add(itemPanel);
    container.add(Box.createRigidArea(new Dimension(0, 20))); // Space between items
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(857, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
