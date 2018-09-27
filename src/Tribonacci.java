import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Tribonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger firstNum = new BigInteger(reader.readLine());
        BigInteger secondNum = new BigInteger(reader.readLine());
        BigInteger thirdNum = new BigInteger(reader.readLine());
        BigInteger forthNum = firstNum.add(secondNum).add(thirdNum);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 5; i <= n; i++) {
            firstNum = secondNum;
            secondNum = thirdNum;
            thirdNum = forthNum;
            forthNum = firstNum.add(secondNum).add(thirdNum);
        }
        System.out.println(forthNum);
    }
}

//9 / 10