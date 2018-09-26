/**
 * https://judge.telerikacademy.com/problem/15balancednumbers
 */

import java.util.Scanner;

public class BalancedNumbers {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int sum = 0;

        while (true) {
            char[] current = in.nextLine().toCharArray();

            int firstNum = current[0] - '0';
            int secondNum = current[1] - '0';
            int thirdNum = current[2] - '0';

            if (firstNum + thirdNum != secondNum) break;

            sum += (firstNum * 100 + secondNum * 10 + thirdNum);
        }
        System.out.println(sum);
    }
}