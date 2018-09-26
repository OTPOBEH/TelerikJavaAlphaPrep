/**
 * Longest Sequence of Equal
 *
 * https://judge.telerikacademy.com/problem/04maxequalseq
 *
 * Write a program that finds the length of the maximal sequence of equal elements in an array of N integers.
 *
 * Input:
 *
 *     On the first line you will receive the number N
 *     On the next N lines the numbers of the array will be given
 *
 * Output:
 *
 *     Print the length of the maximal sequence
 *
 * Constraints:
 *
 *     1 <= N <= 1024
 *
 * Sample tests
 * Input 	Output
 * 10
 * 2
 * 1
 * 1
 * 2
 * 3
 * 3
 * 2
 * 2
 * 2
 * 1 	        3
 */
import java.util.Scanner;

public class LongestSequenceOfEqual {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int arraySize = in.nextInt();

        int longestSequence = 0;
        int currentSequence = 1;

        int previousNumber = in.nextInt();

        for (int i = 1; i < arraySize; i++) {
            int currentNumber = in.nextInt();

            if (currentNumber == previousNumber) {
                currentSequence++;
                if (currentSequence > longestSequence) longestSequence = currentSequence;
            }
            else currentSequence = 1;
            previousNumber = currentNumber;
        }
        System.out.println(longestSequence);
    }
}