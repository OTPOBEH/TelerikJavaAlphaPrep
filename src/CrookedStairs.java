import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CrookedStairs {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] numbers = new BigInteger[3];

        numbers[0] = new BigInteger(reader.readLine());
        numbers[1] = new BigInteger(reader.readLine());
        numbers[2] = new BigInteger(reader.readLine());

        int l = Integer.parseInt(reader.readLine());

        if (l == 1) {
            System.out.println(numbers[0]);
            return;
        }

        if (l == 2) {
            System.out.println(numbers[0]);
            System.out.print(numbers[1]);
            System.out.println(numbers[2]);
            return;
        }

        StringBuilder printout = new StringBuilder().
                append(numbers[0]).append("\n").
                append(numbers[1]).append(' ').append(numbers[2]).append("\n");

        int currentNumberInSequence = 4;

        for (int i = 3; i <= l; i++) {
            for (int j = 1; j <= i; j++) {
                printout.append(calculateForthNumber(numbers, currentNumberInSequence)).append(' ');
                currentNumberInSequence++;
            }
            printout.append("\n");
        }

        System.out.println(printout);
    }

    private static BigInteger calculateForthNumber(BigInteger[] numbers, int currentNumberInSequence) {
        BigInteger forthNum = numbers[0].add(numbers[1]).add(numbers[2]);
        int currentIndex = (currentNumberInSequence - 1) % 3;
        numbers[currentIndex] = forthNum;
        return forthNum;
    }
}