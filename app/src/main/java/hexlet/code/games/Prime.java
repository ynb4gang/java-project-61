package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
public class Prime {
    private static final int DIVISOR_6 = 3;
    private static final int DIVISOR_5 = 5;
    private static final int RANDOM_NUMBER_200 = 200;
    public static void play() {
        getRulesPrime();
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.run(questionsAndAnswers);
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.MAGIC_NUMBER_3][2];
        for (int iterationLimit = 0; iterationLimit < Engine.MAGIC_NUMBER_3; iterationLimit++) {
            int number = Utils.getRandomNumber(1, RANDOM_NUMBER_200);
            String numberString = String.valueOf(number);
            questionsAndAnswers[iterationLimit][0] = numberString;
            questionsAndAnswers[iterationLimit][1] = isPrime(number) ? "yes" : "no";
        }
        return questionsAndAnswers;
    }
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2 || number == DIVISOR_6) {
            return true;
        }
        if (number % 2 == 0 || number % DIVISOR_6 == 0) {
            return false;
        }
        int divisor = DIVISOR_5;
        int step = 2;
        while (divisor * divisor <= number) {
            if (number % divisor == 0) {
                return false;
            }
            divisor += step;
            step = DIVISOR_6 - step;
        }
        return true;
    }
    public static void getRulesPrime() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }
}
