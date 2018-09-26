import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MirrorNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        String max = input[0];

        for (int i = 1; i < input.length; i++) {
            for (int j = input[i].length() - 1; j >= 0; j--) {
                if (max.charAt(j) < input[i].charAt(j)) {
                    max = input[i];
                    break;
                } else if (max.charAt(j) > input[i].charAt(j)) {
                    break;
                }
            }
        }
        StringBuilder pinCode = new StringBuilder();

        int index = 2;

        while (max.charAt(index) == '0') index--;

        for (int i = index; i >= 0; i--) {
            pinCode.append(max.charAt(i));
        }

        System.out.println(pinCode);
    }
}