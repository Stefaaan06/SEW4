package Java4c2.Erweiterung;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Model {
    private int[] secretNumbers = new int[5];

    public Model() {
        generateNewNumbers(true);
    }

    public void generateNewNumbers(boolean easyMode) {
        Random rand = new Random();
        Set<Integer> usedNumbers = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            int num;
            do {
                num = rand.nextInt(10);
            } while (easyMode && !usedNumbers.add(num));
            secretNumbers[i] = num;
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