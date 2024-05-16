package ExtraEKs.graphicRenderer;

import java.awt.*;
import javax.swing.*;
import ExtraEKs.graphicRenderer.Shapes.*;
public class Renderer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Shape Renderer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        CustomShape rectangle = new JRectangle(100, 100, 50, 50);
        CustomShape rectangl2 = new JRectangle(100, 100, 100, 50);
        CustomShape triangle = new Jtriangle(new int[]{200, 250, 300}, new int[]{200, 100, 200});

        ShapeView rectanglePanel = new ShapeView(rectangle);
        ShapeView trianglePanel = new ShapeView(triangle);
        ShapeView rectanglePanel2 = new ShapeView(rectangl2);

        frame.setLayout(new GridLayout(1, 2));
        frame.add(rectanglePanel);
        frame.add(trianglePanel);
        frame.add(rectanglePanel2);

        frame.setVisible(true);
    }
}