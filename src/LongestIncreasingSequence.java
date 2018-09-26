/**
 * Longest Increasing Sequence
 *
 * https://judge.telerikacademy.com/problem/05maxincreasingseq
 *
 * Write a program that finds the length of the maximal increasing sequence in an array of N integers.
 * Input
 *
 * Read from the standard input
 *
 *     On the first line you will receive the number N
 *     On the next N lines the numbers of the array will be given
 *
 * Output
 *
 * Print to the standard output
 *
 *     Print the length of the maximal increasing sequence
 *
 * Constraints
 *
 *     1 <= N <= 1024
 *     Time limit: 0.1s
 *     Memory limit: 16MB
 *
 * Sample tests
 *
 * Input    Output
 * 8
 * 7
 * 3
 * 2
 * 3
 * 5
 * 2
 * 2
 * 4        3
 */

import java.util.Scanner;

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int arraySize = in.nextInt();

        int longestSequence = 0;
        int currentSequence = 1;

        int previousNumber = in.nextInt();

        for (int i = 1; i < arraySize; i++) {
            int currentNumber = in.nextInt();

            if (currentNumber > previousNumber) {
                currentSequence++;
                if (currentSequence > longestSequence) longestSequence = currentSequence;
            }
            else currentSequence = 1;
            previousNumber = currentNumber;
        }
        System.out.println(longestSequence);
    }
}