package ExtraEKs.graphicRenderer.Shapes;

import java.awt.*;

public class Jtriangle implements CustomShape {
    private int[] xPoints;
    private int[] yPoints;

    public Jtriangle(int[] xPoints, int[] yPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }
    @Override
    public void draw(Graphics2D g) {
        g.drawPolygon(xPoints, yPoints, 3);
    }
}