package ExtraEKs.graphicRenderer;

import java.awt.*;
import javax.swing.*;
import ExtraEKs.graphicRenderer.Shapes.*;
public class Renderer {
    public static void main(String[] args) {
        // Create a JFrame to hold the shapes
        JFrame frame = new JFrame("Shape Renderer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Create different shapes
        CustomShape rectangle = new JRectangle(100, 100, 50, 50);
        CustomShape triangle = new Jtriangle(new int[]{200, 250, 300}, new int[]{200, 100, 200});

        // Add shapes to panels
        ShapeView rectanglePanel = new ShapeView(rectangle);
        ShapeView trianglePanel = new ShapeView(triangle);

        // Add panels to the frame
        frame.setLayout(new GridLayout(1, 2));
        frame.add(rectanglePanel);
        frame.add(trianglePanel);

        // Display the frame
        frame.setVisible(true);
    }
}