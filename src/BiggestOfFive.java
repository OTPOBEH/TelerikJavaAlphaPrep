import java.util.Scanner;

public class BiggestOfFive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int numbers = 5;
        double biggest = -Double.MAX_VALUE;

        for (int i = 0; i < numbers; i++) {
            double currentNumber = in.nextDouble();
            if (currentNumber > biggest) biggest = currentNumber;
        }

        if (biggest == (int)biggest) System.out.println((int)biggest);
        else System.out.println(biggest);
    }
}