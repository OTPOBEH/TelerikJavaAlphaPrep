import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetMax {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int maxNum = Integer.parseInt(input[0]);

        for (int i = 1; i < input.length; i++) {
            int current = Integer.parseInt(input[i]);
            if (current > maxNum) maxNum = current;
        }
        System.out.println(maxNum);
    }
}