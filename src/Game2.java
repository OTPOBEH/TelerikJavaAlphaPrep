import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game2 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] number = reader.readLine().toCharArray();

        int num1 = number[0] - '0';
        int num2 = number[1] - '0';
        int num3 = number[2] - '0';

        int var1 = num1 + num2 + num3;
        int var2 = num1 * num2 + num3;
        int var3 = num1 + num2 * num3;
        int var4 = num1 * num2 * num3;

        int max = Math.max(Math.max(var1, var2), Math.max(var3, var4));

        System.out.println(max);
    }
}