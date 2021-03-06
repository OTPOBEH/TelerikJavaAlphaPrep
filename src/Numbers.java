/**
 *
 * https://judge.telerikacademy.com/problem/14numbers
 * Coki loves numbers. He also loves operations with them.
 *
 * Since the regular arithmetic operations are too mainstream for him, he decided he wants a brand new calculator.
 *
 * The calculator supports the following operations:
 *
 *     set NUMBER
 *     Sets the current value to number
 *     front-add DIGIT
 *     Adds the digit DIGIT to the front (at the leftmost)
 *     front-remove
 *     Removes the first (the leftmost) digit
 *         does nothing if there are no digits
 *     back-add DIGIT
 *     Adds the digit DIGIT to the back (at the rightmost)
 *     back-remove
 *     Removes the last (the rightmost) digit
 *         does nothing if there are no digits
 *     reverse
 *     Reverses the digits of the current number
 *     print
 *     Prints the current number
 *         prints an empty line if there are no digits
 *     end
 *     Stops the program
 *
 * Sadly, Coki is not smart enough to implement the calculator. Pleeeeeease, help him, he is annoying!!
 * Input
 *
 * You will receive an array of strings as only parameter of the solve(args) function
 *
 *     Each array item will be one of the operations
 *
 * Output
 *
 * Print to the standard output
 *
 *     For each print command, print the current value of the number on a separate line
 *
 * Constraints
 *
 *     The commands will be less than 220
 *     The number can be very very very big, i.e. 1010000 is a possible value
 *
 * Sample tests
 * Input
 *
 * set 2
 * print
 * front-add 1
 * print
 * back-add 2
 * print
 * front-remove
 * print
 * set 4
 * print
 * print
 * front-add 1
 * print
 * back-add 3
 * print
 * reverse
 * print
 * end
 *
 * Output
 *
 * 2
 * 12
 * 122
 * 22
 * 4
 * 4
 * 14
 * 143
 * 341
 */

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String numberAsString = "";
        String input = in.nextLine();
        while (!input.equals("end")) {
            String[] inputElements = input.split(" ");

            switch (inputElements[0]) {
                case "set":
                    numberAsString = inputElements[1];
                    break;
                case "front-add":
                    numberAsString = inputElements[1] + numberAsString;
                    break;
                case "front-remove":
                    if (numberAsString.length() > 1)
                        numberAsString = numberAsString.substring(1);
                    else numberAsString = "";
                    break;
                case "back-add":
                    numberAsString = numberAsString + inputElements[1];
                    break;
                case "back-remove":
                    if (numberAsString.length() > 1)
                        numberAsString = numberAsString.substring(0, numberAsString.length() - 1);
                    else numberAsString = "";
                    break;
                case "reverse":
                    if (numberAsString.length() != 0)
                    numberAsString = new StringBuilder(numberAsString).reverse().toString();
                    break;
                case "print":
                    System.out.println(numberAsString);
                    break;
            }

            input = in.nextLine();
        }
    }
}