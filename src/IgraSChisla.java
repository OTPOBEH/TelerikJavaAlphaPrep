import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IgraSChisla {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = reader.readLine().split(" ");
        int biggestScore = 0;

        int lonisNum = Integer.parseInt(input1[1]);

        StringBuilder winningNumbers = new StringBuilder();

        String[] input2 = reader.readLine().split(" ");

        for (int i = 0; i < input2.length; i++) {
            int currentNum = Integer.parseInt(input2[i]);
            int gcd = gcd(lonisNum, currentNum);

            int result = 0;
            for (int j = 2; j <= Math.sqrt(gcd); j++) {

                if (gcd % j == 0) {
                    if (gcd / j == j) result += 1;
                    else result += 2;
                }
            }

            if (result > biggestScore) {
                biggestScore = result;
                winningNumbers = new StringBuilder().append(i + 1).append(' ');

            } else if (result != 0 && result == biggestScore) {
                winningNumbers.append(i + 1).append(' ');
            }
        }

        biggestScore++;
        if (winningNumbers.length() == 0) {
            System.out.println("No winners");
            return;
        }

        System.out.println(biggestScore);
        System.out.print(winningNumbers);
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }
}
