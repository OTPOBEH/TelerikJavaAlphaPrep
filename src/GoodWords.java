import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoodWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(reader.readLine());
        int vowelsCount = 0;
        int consonantsCount = 0;

        final Character[] VOWELS_VALUES = new Character[]{'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U', 'y', 'Y'};
        final Set<Character> vowels = new HashSet<>(Arrays.asList(VOWELS_VALUES));

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if ((currentChar >= 65 && currentChar <= 90) || (currentChar >= 97 && currentChar <= 122)) {
                if (vowels.contains(currentChar)) vowelsCount++;
                else consonantsCount++;
            }
        }
        if (vowelsCount == consonantsCount) System.out.println("Yes");
        else System.out.printf("%d %d", vowelsCount, consonantsCount);
    }
}