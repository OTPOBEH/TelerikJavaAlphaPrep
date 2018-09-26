import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String number = in.nextLine();

        int firstDigit = number.charAt(0) - '0';
        int secondDigit = number.charAt(1) - '0';
        int thirdDigit = number.charAt(2) - '0';

        int result = Integer.MIN_VALUE;

        result = Math.max(result, (firstDigit + secondDigit + thirdDigit));
        result = Math.max(result, (firstDigit * secondDigit * thirdDigit));
        result = Math.max(result, (firstDigit * secondDigit + thirdDigit));
        result = Math.max(result, (firstDigit + secondDigit * thirdDigit));

        System.out.println(result);
    }
}