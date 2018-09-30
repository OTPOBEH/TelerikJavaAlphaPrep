import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nagrada {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        boolean isAllowed = true;
        StringBuilder stars = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int currentChar = input.charAt(i);
            if (currentChar == '2') {
                isAllowed = false;
                break;
            }
            if (currentChar == '6') stars.append('*');
        }

        System.out.println(isAllowed ? stars : "No");
    }
}