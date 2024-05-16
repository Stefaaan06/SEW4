package Java4c2.Erweiterung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class Controller {
    private Model model;
    private View view;
    private int round = 0;
    private boolean easyMode = false;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.getCheckButton().addActionListener(e -> checkGuess());
        view.getNewButton().addActionListener(e -> newGame());
        view.getSolutionButton().addActionListener(e -> showSolution());
        view.getEasyModeButton().addActionListener(e -> toggleEasyMode());

        newGame();
    }

    private void newGame() {
        model.generateNewNumbers(easyMode);
        view.getGraphicPanel().reset();
        view.getResultLabel().setText("Versuche die 5 Zahlen von 0–9 zu erraten");
        for (JTextField textField : view.getTextFields()) {
            textField.setText("");
            textField.setEditable(true);
        }
        for (JLabel label : historyLabels) {
            label.setText("");
        }
        view.getCheckButton().setEnabled(true);
        round = 0;
    }

    private void showSolution() {
        StringBuilder solution = new StringBuilder("Lösung: ");
        for (int num : model.getSecretNumbers()) {
            solution.append(num).append(" ");
        }
        view.getResultLabel().setText(solution.toString());
        for (JTextField textField : view.getTextFields()) {
            textField.setEditable(false);
        }
        view.getCheckButton().setEnabled(false);
    }

    private void checkGuess() {
        int[] guess = new int[5];
        try {
            for (int i = 0; i < 5; i++) {
                guess[i] = Integer.parseInt(view.getTextFields()[i].getText());
            }
        } catch (NumberFormatException e) {
            view.getResultLabel().setText("Bitte geben Sie gültige Zahlen ein.");
            return;
        }

        if (easyMode && !isValidGuess(guess)) {
            view.getResultLabel().setText("Im Leicht-Modus darf jede Ziffer nur einmal vorkommen.");
            return;
        }

        Model.Result result = model.checkGuess(guess);
        view.getGraphicPanel().updateCircles(result.correctPosition(), result.correctNumber());
        historyLabels[round].setText(view.getResultLabel().getText());
        round++;

        if (result.correctPosition() == 5){
            view.getResultLabel().setText("Gewonnen, du hast meine Zahlen erraten!");
            view.getCheckButton().setEnabled(false);
        } else if (round == 16) {
            showSolution();
        } else {
            view.getResultLabel().setText(result.correctPosition() + " Zahl(en) richtig, " + result.correctNumber() + " Zahl(en) an der falschen Stelle");
        }
    }

    private void toggleEasyMode() {
        easyMode = view.getEasyModeButton().isSelected();
        view.getResultLabel().setText("Easy-Mode " + (easyMode ? "aktiviert" : "deaktiviert"));

    }

    private boolean isValidGuess(int[] guess) {
        Set<Integer> digits = new HashSet<>();
        for (int num : guess) {
            if (!digits.add(num)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        new Controller(model, view);
        view.setVisible(true);
    }
}