import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ElMessage {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        int maxString = 0;
        int currentString = 0;
        for (int index = 0; index < input.length(); index++) {
            char current = input.charAt(index);
            if (current == '.') break;
            if      ((current >= 'a' && current <= 'z') ||
                    (current >= 'A' && current <= 'Z') ||
                    (current >= '0' && current <= '9') ||
                    current == ' ') {
                    currentString = 0;
            } else {
                currentString++;
                if (currentString > maxString) maxString = currentString;
            }
        }

        System.out.println(maxString);
    }
}