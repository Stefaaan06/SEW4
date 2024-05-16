package Java4c2.Erweiterung;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class View extends JFrame {

    private JTextField[] textFields = new JTextField[5];
    private JButton checkButton;
    private JButton newButton;
    private JButton solutionButton;
    private JLabel resultLabel;
    private GraphicPanel graphicPanel;

    private static JToggleButton easyModeButton;
    private JButton historyButton;



    public View() {
        setTitle("Mastermind");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(1, 6));
        for (int i = 0; i < 5; i++) {
            textFields[i] = new JTextField();
            topPanel.add(textFields[i]);
        }

        checkButton = new JButton("Check");
        newButton = new JButton("Neu");
        solutionButton = new JButton("Lösung");
        resultLabel = new JLabel("Versuche die 5 Zahlen von 0–9 zu erraten", SwingConstants.CENTER);

        JPanel controlPanel = new JPanel(new GridLayout(4, 1));
        controlPanel.add(checkButton);
        controlPanel.add(newButton);
        controlPanel.add(solutionButton);

        easyModeButton = new JToggleButton("Leicht-Modus");
        historyPanel = new JPanel(new GridLayout(16, 1));

        controlPanel.add(easyModeButton);

        add(historyPanel, BorderLayout.WEST);

        historyButton = new JButton("Historie anzeigen");
        controlPanel.add(historyButton);

        historyButton.addActionListener(e -> showHistory());



        graphicPanel = new GraphicPanel();

        add(topPanel, BorderLayout.NORTH);
        add(graphicPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);
        add(controlPanel, BorderLayout.EAST);

        setSize(600, 400);
        setLocationRelativeTo(null);
    }



    private void showHistory() {
        JFrame historyFrame = new JFrame("Historie");
        historyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        historyFrame.setLayout(new BorderLayout());

        // Erstellt ein neues Panel für die Historie, um das Original nicht zu beeinflussen
        JPanel historyPanelCopy = new JPanel(new GridLayout(16, 1));
        for (Component component : historyPanel.getComponents()) {
            if (component instanceof JLabel) {
                historyPanelCopy.add(new JLabel(((JLabel) component).getText()));
            }
        }

        historyFrame.add(new JScrollPane(historyPanelCopy), BorderLayout.CENTER);
        historyFrame.setSize(300, 400);
        historyFrame.setLocationRelativeTo(null);
        historyFrame.setVisible(true);
    }


    public JToggleButton getEasyModeButton() {
        return easyModeButton;
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

    public GraphicPanel getGraphicPanel() {
        return graphicPanel;
    }

    public static class GraphicPanel extends JPanel {
        private int correctPosition = 0;
        private int correctNumber = 0;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getWidth();
            int circleDiameter = (width - 60) / 5;
            int yPosition = getHeight() / 2 - circleDiameter / 2;

            for (int i = 0; i < correctPosition; i++) {
                g.setColor(Color.GREEN);
                g.fillOval(i * (circleDiameter + 10), yPosition, circleDiameter, circleDiameter);
            }
            for (int i = 0; i < correctNumber; i++) {
                g.setColor(Color.ORANGE);
                g.drawOval((correctPosition + i) * (circleDiameter + 10), yPosition, circleDiameter, circleDiameter);
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
}