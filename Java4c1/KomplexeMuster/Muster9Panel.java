package Java4c1.KomplexeMuster;

import javax.swing.*;
import java.awt.*;

class Muster9Panel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;

        int numCircles = 10;
        int maxRadius = Math.min(width, height) / 2;

        int initialRadius = maxRadius / numCircles;
        int centerY = initialRadius;

        for (int i = 0; i < numCircles; i++) {
            int radius = initialRadius * (i + 1);

            g2.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

            centerY += initialRadius;
        }
    }
}
