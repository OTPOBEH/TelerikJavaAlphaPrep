import java.util.Scanner;

public class ExchangeIfGreater {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double firstNum = in.nextDouble();
        double secondNum = in.nextDouble();
        String firstNumberAsString;
        String secondNumberAsString;


        if (firstNum == (int) firstNum) firstNumberAsString = String.valueOf((int) firstNum);
        else firstNumberAsString = String.valueOf(firstNum);

        if (secondNum == (int) secondNum) secondNumberAsString = String.valueOf((int) secondNum);
        else secondNumberAsString = String.valueOf(secondNum);

        if (firstNum <= secondNum) {
            System.out.printf("%s %s", firstNumberAsString, secondNumberAsString);
        } else {
            System.out.printf("%s %s", secondNumberAsString, firstNumberAsString);
        }
    }
}