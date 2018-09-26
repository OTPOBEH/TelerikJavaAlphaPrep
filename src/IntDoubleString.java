import java.util.Scanner;

/**
 * Int, Double, String
 * https://judge.telerikacademy.com/problem/09intdoublestring
 * <p>
 * Write a program that, depending on the first line of the input, reads an int, double or string variable.
 * <p>
 * If the variable is int or double, the program increases it by one.
 * If the variable is a string, the program appends * at the end.
 * Print the result at the console. Use switch statement.
 * <p>
 * Input
 * <p>
 * On the first line you will receive the type of input as string in the following form:
 * integer for int
 * real for double
 * text for string
 * On the second line you will be given the value of the variable.
 * <p>
 * Output
 * <p>
 * Write a single line on the console - the value transformed according to the rules from the description.
 * Print all double variables with exactly 2-digits precision after the floating point. _Example:_ 0.99
 * <p>
 * Constraints
 * <p>
 * The input will always be valid and in the described format.
 * All input numbers will be between -1000 and 1000.
 * Time limit: 0.1s
 * Memory limit: 16MB
 * <p>
 * Sample tests
 * Input 	Output
 * integer
 * 2 	3
 * real
 * -2.5 	-1.50
 * text
 * gosho
 */

public class IntDoubleString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String inputType = in.nextLine();
        String inputAsStr = in.nextLine();

        switch (inputType.charAt(0)) {
            case 'i':
                int inputInt = Integer.parseInt(inputAsStr);
                inputInt++;
                System.out.println(inputInt);
                break;
            case 'r':
                double inputDouble = Double.parseDouble(inputAsStr);
                inputDouble++;
                System.out.printf("%.2f", inputDouble);
                break;
            case 't':
                System.out.println(inputAsStr + "*");
                break;
        }
    }
}
