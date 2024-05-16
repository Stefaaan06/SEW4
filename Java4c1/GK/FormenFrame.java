package Java4c1.GK;

import javax.swing.*;
import java.awt.*;

public class FormenFrame extends JFrame {
    public FormenFrame() {
        super("Verschiedene Formen Crasnianec");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar bar = new JMenuBar();
        bar.setPreferredSize(new Dimension(500, 20));
        this.setJMenuBar(bar);

        FormenPanel panel = new FormenPanel();
        this.add(panel);

        this.pack();
        this.setLocation(500, 500);
        this.setVisible(true);
    }
}
