package Java4c1.GK;

import javax.swing.*;
import java.awt.*;

public class FormenFrame extends JFrame {
    public FormenFrame() {
        super("Verschiedene Formen Crasnianec");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FormenPanel panel = new FormenPanel();
        this.add(panel);

        this.pack();
        this.setLocation(500, 500);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormenFrame::new);
    }
}
