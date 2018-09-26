/**
 * https://judge.telerikacademy.com/problem/15primenumbers
 * Biggest Primer Number
 * Write a program that finds and prints the biggest prime number which is <= N.
 * Input:
 *
 *     On the first line you will receive the number N
 *
 * Output:
 *
 *     Print the biggest prime number which is <= N
 *
 * Constraints:
 *
 *     2 <= N <= 10 000 000
 *
 * Sample tests
 * Input 	Output
 * 13 	    13
 * 126 	    113
 * 26 	    23
 */

import java.util.Scanner;

public class BiggestPrimeNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int number = in.nextInt();

        if (number % 2 == 0) number -= 1;//Start iterating from a not even number(even numbers are not prime).

        boolean notAPrime;

        for (int i = number; i >= 1; i -= 2) {//Only iterate trough not even numbers.
            if (i < 4) {
                System.out.println(i);
                return;
            }

            notAPrime = false;

            for (int j = 3; j * j <= i; j++) {
                if (i % j == 0) {
                    notAPrime = true;
                    break;
                }
            }

            if (notAPrime) continue;

            System.out.println(i);
            return;
        }
    }
}