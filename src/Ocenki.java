import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ocenki {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final String judgeCount = reader.readLine();

        String[] input = reader.readLine().split(" ");

        final double firstScore = Double.parseDouble(input[0]);
        final double secondScore = Double.parseDouble(input[1]);

        double minScore = Math.min(firstScore, secondScore);
        double maxScore = Math.max(firstScore, secondScore);

        double finalScore = firstScore + secondScore;

        for (int i = 2; i < input.length; i++) {
            int current = Integer.parseInt(input[i]);

            if (current >= maxScore) {
                maxScore = current;
            } else if (current <= minScore) {
                minScore = current;
            }

            finalScore += current;
        }

        if (minScore != maxScore) {
            finalScore -= (minScore + maxScore);
            finalScore /= input.length - 2;
        } else {
            finalScore /= input.length;
        }

        int finalScore2 = (int) Math.round(finalScore);
        System.out.println(finalScore2);
    }
}