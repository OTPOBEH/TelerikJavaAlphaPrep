import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class GolemiChisla {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        StringBuilder completeNumber = new StringBuilder();

        Stack<Integer> check = new Stack<>();

        char current;

        for (int i = 0; i < 3; i++) {
            current = input.charAt(i);
            if (current != ' ') {
                completeNumber.append(current);
            }
        }

        char previous = completeNumber.charAt(0);
        current = completeNumber.charAt(1);
        char next = completeNumber.charAt(2);


        for (int i = 4; i < input.length(); i++) {
            current = input.charAt(i);
            if (current != ' ') {


                completeNumber.append(current);
            }


            System.out.println();


        }
    }
}
