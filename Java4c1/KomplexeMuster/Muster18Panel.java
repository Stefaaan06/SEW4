package Java4c1.KomplexeMuster;

import javax.swing.*;
import java.awt.*;

class Muster18Panel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        int numSteps = 10;
        int stepWidth = width / numSteps;
        int stepHeight = height / numSteps;

        for (int i = numSteps; i >= 0; i--) {
            int x = (width - (i * stepWidth)) / 2;
            int y = (height - (numSteps - i) * stepHeight);

            int currentWidth = i * stepWidth;
            int blockWidth = stepWidth;

            for (int j = 0; j < i; j++) {
                g2.drawRect(x + j * blockWidth, y, blockWidth, stepHeight);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}