package Java4c2.GK;

import java.util.Random;

public class Model {
    private int[] secretNumbers = new int[5];

    public Model() {
        generateNewNumbers();
    }

    public void generateNewNumbers() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            secretNumbers[i] = rand.nextInt(10);
        }
    }

    public int[] getSecretNumbers() {
        return secretNumbers;
    }

    public Result checkGuess(int[] guess) {
        int correctPosition = 0;
        int correctNumber = 0;

        boolean[] guessed = new boolean[5];
        boolean[] checked = new boolean[5];

        for (int i = 0; i < 5; i++) {
            if (guess[i] == secretNumbers[i]) {
                correctPosition++;
                guessed[i] = true;
                checked[i] = true;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (!guessed[i]) {
                for (int j = 0; j < 5; j++) {
                    if (!checked[j] && guess[i] == secretNumbers[j]) {
                        correctNumber++;
                        checked[j] = true;
                        break;
                    }
                }
            }
        }

        return new Result(correctPosition, correctNumber);
    }

    public record Result(int correctPosition, int correctNumber) {
    }
}