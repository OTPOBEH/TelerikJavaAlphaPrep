import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Tribonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] numbers = new BigInteger[3];
        numbers[0] = new BigInteger(reader.readLine());
        numbers[1] = new BigInteger(reader.readLine());
        numbers[2] = new BigInteger(reader.readLine());

        int n = Integer.parseInt(reader.readLine());

        if (n < 4) {        //В случай, че ни подадат n < 4, какъвто е тест №6
            System.out.println(numbers[n - 1]);
            return;
        }

        BigInteger forthNum = numbers[0].add(numbers[1]).add(numbers[2]);

        for (int i = 3; i < n - 1; i++) {
            int currentIndex = i  % 3;
            numbers[currentIndex] = forthNum;
            forthNum = numbers[0].add(numbers[1]).add(numbers[2]);
        }
        System.out.println(forthNum);
    }
}