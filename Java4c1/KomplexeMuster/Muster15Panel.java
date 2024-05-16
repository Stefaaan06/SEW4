package Java4c1.KomplexeMuster;

import javax.swing.*;
import java.awt.*;

class Muster15Panel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        int outerRectWidth = width / 3;
        int outerRectHeight = height / 2;
        int innerRectWidth = outerRectWidth - 20;
        int innerRectHeight = outerRectHeight - 20;
        int circleCount = 5;

        int xCenter = width / 2;
        int yCenter = height / 2;

        int outerRectX = xCenter - outerRectWidth / 2;
        int outerRectY = yCenter - outerRectHeight / 2;
        int innerRectX = xCenter - innerRectWidth / 2;
        int innerRectY = yCenter - innerRectHeight / 2;

        g2d.drawRoundRect(outerRectX, outerRectY, outerRectWidth, outerRectHeight, 20, 20);

        g2d.drawRoundRect(innerRectX, innerRectY, innerRectWidth, innerRectHeight, 20, 20);

        int roundRectWidth = innerRectWidth - 120;
        int roundRectHeight = innerRectHeight - 20;
        for (int i = 0; i < circleCount; i++) {
            int x = innerRectX + (innerRectWidth - roundRectWidth) / 2;
            int y = innerRectY + (innerRectHeight - roundRectHeight) / 2;
            g2d.drawRoundRect(x, y, roundRectWidth, roundRectHeight, roundRectHeight, roundRectHeight);
            roundRectWidth += 20;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 100);
    }
}
