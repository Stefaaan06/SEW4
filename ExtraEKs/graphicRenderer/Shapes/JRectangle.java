package ExtraEKs.graphicRenderer.Shapes;

import java.awt.*;

public class JRectangle implements CustomShape {
    private int x;
    private int y;
    private int width;
    private int height;

    public JRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawRect(x, y, width, height);
    }
}