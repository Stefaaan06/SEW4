package Java4c2.GK;

import javax.swing.*;
import java.awt.*;
public class GraphicPanel extends JPanel {
    private int correctPosition = 0;
    private int correctNumber = 0;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int circleDiameter = (width - 60) / 5;
        int yPosition = getHeight() / 2 - circleDiameter;

        for (int i = 0; i < correctPosition; i++) {
            g.setColor(Color.GREEN);
            g.fillOval(i * (circleDiameter + 10), yPosition, circleDiameter, circleDiameter);
        }
        for (int i = 0; i < correctNumber; i++) {
            g.setColor(Color.ORANGE);
            g.drawOval(i * (circleDiameter + 10), yPosition + circleDiameter + 10, circleDiameter, circleDiameter);
        }
        if (correctPosition == 5) {
            g.setColor(Color.GREEN);
            g.setFont(new Font("SansSerif", Font.BOLD, 24));
            g.drawString("GEWONNEN!", width / 2 - 60, yPosition + circleDiameter + 30);
        }
    }

    public void updateCircles(int correctPosition, int correctNumber) {
        this.correctPosition = correctPosition;
        this.correctNumber = correctNumber;
        repaint();
    }

    public void reset() {
        correctPosition = 0;
        correctNumber = 0;
        repaint();
    }
}