import javax.swing.*;
import java.awt.*;

class HospitalStyling {
    private static final Color BACKGROUND_COLOR = new Color(240, 240, 240);
    private static final Color PANEL_BACKGROUND_COLOR = new Color(255, 255, 255);
    private static final Font PANEL_TITLE_FONT = new Font("Arial", Font.BOLD, 20);

    public static void applyStyle(Container container) {
        container.setBackground(BACKGROUND_COLOR);
        if (container instanceof JPanel) {
            JPanel panel = (JPanel) container;
            panel.setBackground(PANEL_BACKGROUND_COLOR);
            if (panel.getName() != null && panel.getName().equals("titlePanel")) {
                JLabel titleLabel = (JLabel) panel.getComponent(0);
                titleLabel.setFont(PANEL_TITLE_FONT);
                titleLabel.setForeground(Color.BLUE); 
            }
        }
    }
}