/**
 * https://judge.telerikacademy.com/problem/11cartesiancoords
 */

import java.util.Scanner;

public class CartesianCoordinates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double coordX = in.nextDouble();
        double coordY = in.nextDouble();

        if (coordX > 0) {
            if (coordY > 0) System.out.println(1);
            else if (coordY < 0) System.out.println(4);
            else System.out.println(6);
        } else if (coordX < 0) {
            if (coordY > 0) System.out.println(2);
            else if (coordY < 0) System.out.println(3);
            else System.out.println(6);
        } else {
            if (coordY == 0) System.out.println(0);
            else System.out.println(5);
        }
    }
}