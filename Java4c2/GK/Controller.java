package Java4c2.GK;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.getCheckButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        view.getNewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });

        view.getSolutionButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSolution();
            }
        });

        newGame();
    }

    private void newGame() {
        model.generateNewNumbers();
        view.getGraphicPanel().reset();
        view.getResultLabel().setText("Versuche die 5 Zahlen von 0–9 zu erraten");
        for (JTextField textField : view.getTextFields()) {
            textField.setText("");
            textField.setEditable(true);
        }
        view.getCheckButton().setEnabled(true);
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

        Model.Result result = model.checkGuess(guess);
        view.getGraphicPanel().updateCircles(result.correctPosition(), result.correctNumber());
        if (result.correctPosition() == 5){
            view.getResultLabel().setText("Gewonnen, du hast meine Zahlen erraten!");
        } else {
            view.getResultLabel().setText(result.correctPosition() + " Zahl(en) richtig, " + result.correctNumber() + " Zahl(en) an der falschen Stelle");
        }
    }

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        new Controller(model, view);
        view.setVisible(true);
    }
}