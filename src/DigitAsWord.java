import java.util.Scanner;

/**
 * Digit as Word
 * https://judge.telerikacademy.com/problem/08digitasword
 * <p>
 * Write a program that read a digit [0-9] from the console, and depending on the input, shows the digit as a word (in English).
 * <p>
 * Print "not a digit" in case of invalid input.
 * Use a switch statement.
 * <p>
 * Input
 * <p>
 * The input consists of one line only, which contains the digit.
 * <p>
 * Output
 * <p>
 * Output a single line - should the input be a valid digits, print the english word for the digits. Otherwise, print "not a digit".
 * <p>
 * Constraints
 * <p>
 * The input will never be an empty line.
 * Time limit: 0.1s
 * Memory limit: 16MB
 * <p>
 * Sample tests
 * Input 	Output
 * -0.1 	not a digit
 * 1 	one
 * 9 	nine
 * -9 	not a digit
 * kek 	not a digit
 */
public class DigitAsWord {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        switch (input) {
            case "0":
                System.out.println("zero");
                break;
            case "1":
                System.out.println("one");
                break;
            case "2":
                System.out.println("two");
                break;
            case "3":
                System.out.println("three");
                break;
            case "4":
                System.out.println("four");
                break;
            case "5":
                System.out.println("five");
                break;
            case "6":
                System.out.println("six");
                break;
            case "7":
                System.out.println("seven");
                break;
            case "8":
                System.out.println("eight");
                break;
            case "9":
                System.out.println("nine");
                break;
            default:
                System.out.println("not a digit");
        }
    }
}