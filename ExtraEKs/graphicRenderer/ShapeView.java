package ExtraEKs.graphicRenderer;

import java.awt.*;
import javax.swing.*;
import ExtraEKs.graphicRenderer.Shapes.CustomShape;

class ShapeView extends JPanel {
    private CustomShape customShape;

    ShapeView(CustomShape customShape) {
        this.customShape = customShape;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        customShape.draw(g2d);
        g2d.dispose();
    }
}