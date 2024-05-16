package Java4c1.KomplexeMuster;

import javax.swing.*;
import java.awt.*;

public class MusterGUI extends JFrame {
    public MusterGUI() {
        setTitle("Grafikmuster");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 3));

        add(new Muster9Panel());
        add(new Muster15Panel());
        add(new Muster18Panel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MusterGUI frame = new MusterGUI();
            frame.setVisible(true);
        });
    }
}
