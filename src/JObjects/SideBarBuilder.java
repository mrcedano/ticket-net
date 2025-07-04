package JObjects;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SideBarBuilder {

    // Inner class to store both the option text and its action
    private static class SideBarOption {
        final String text;
        final Runnable callback;

        SideBarOption(String text, Runnable callback) {
            this.text = text;
            this.callback = callback;
        }
    }

    private final List<SideBarOption> options;
    private final Color optionDefaultColor = new Color(220, 220, 220);
    private final Color optionHoverColor = new Color(200, 200, 200);


    public SideBarBuilder() {
        this.options = new ArrayList<>();
    }

 
    public SideBarBuilder addOption(String text, Runnable callback) {
        this.options.add(new SideBarOption(text, callback));
        return this;
    }


    public JPanel build(int x, int y, int width, int height) {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setBounds(x, y, width, height);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));

        for (SideBarOption option : this.options) {
            JPanel optionPanel = new JPanel(new GridLayout(1, 1));
            optionPanel.setPreferredSize(new Dimension(width - 20, 45));
            optionPanel.setBackground(optionDefaultColor);

            JLabel valueLabel = new JLabel(option.text, SwingConstants.CENTER);
            optionPanel.add(valueLabel);

            // If a callback is provided, add the mouse listener for the event
            if (option.callback != null) {
                optionPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                optionPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // Execute the callback when the panel is clicked
                        option.callback.run();
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        optionPanel.setBackground(optionHoverColor); // Hover effect
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        optionPanel.setBackground(optionDefaultColor); // Restore original color
                    }
                });
            }

            mainPanel.add(optionPanel);
        }

        return mainPanel;
    }
}