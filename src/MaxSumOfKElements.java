/*
Max Sum of K elements

https://judge.telerikacademy.com/problem/06maxksum

Write a program that reads two integer numbers N and K and and array of N elements from the console.
Find the maximal sum of K elements in the array.
Input:

    On the first line you will receive the number N
    On the second line you will receive the number K
    On the next N lines the numbers of the array will be given

Output:

    Print the maximal sum of K elements in the array

Constraints:

    1 <= N <= 1024
    1 <= K <= N

Sample tests:
Input 	Output
8           16
3
3
2
3
-2
5
4
2
7
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSumOfKElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        Integer[] numbers = new Integer[n];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(numbers);

        int result = 0;

        for (int i = numbers.length - 1; i > numbers.length - 1 - k; i--) {
            result += numbers[i];
        }
        System.out.println(result);
    }
}
