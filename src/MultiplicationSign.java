import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int numbers = 3;
        int countNegative = 0;
        for (int i = 0; i < numbers; i++) {
            double currentNumber = in.nextDouble();

            if (currentNumber < 0) countNegative++;
            else if (currentNumber == 0) {
                System.out.println("0");
                return;
            }
        }

        if (countNegative % 2 == 0) System.out.println("+");
        else System.out.println("-");
    }
}