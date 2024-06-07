package Java4c2.GK;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private JTextField[] textFields = new JTextField[5];
    private JButton checkButton;
    private JButton newButton;
    private JButton solutionButton;
    private JLabel resultLabel;
    private GraphicPanel graphicPanel;

    public View() {
        setTitle("Mastermind");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(1, 5));

        for (int i = 0; i < 5; i++) {
            textFields[i] = new JTextField();
            topPanel.add(textFields[i]);
        }

        checkButton = new JButton("Check");
        newButton = new JButton("Neu");
        solutionButton = new JButton("Lösung");

        resultLabel = new JLabel("Versuche die 5 Zahlen von 0–9 zu erraten", SwingConstants.CENTER);

        JPanel controlPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(controlPanel, BoxLayout.Y_AXIS);
        controlPanel.setLayout(boxLayout);

        controlPanel.add(checkButton);
        controlPanel.add(newButton);
        controlPanel.add(solutionButton);

        graphicPanel = new GraphicPanel();

        add(topPanel, BorderLayout.NORTH);
        add(graphicPanel, BorderLayout.CENTER);

        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        resultPanel.add(resultLabel);

        add(resultPanel, BorderLayout.SOUTH);
        add(controlPanel, BorderLayout.EAST);

        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    public JTextField[] getTextFields() {
        return textFields;
    }

    public JButton getCheckButton() {
        return checkButton;
    }

    public JButton getNewButton() {
        return newButton;
    }

    public JButton getSolutionButton() {
        return solutionButton;
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }

    public GraphicPanel getGraphicPanel() { return graphicPanel; }

    public void resetGraphicsPanel(){
        graphicPanel.reset();
    }
}