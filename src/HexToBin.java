import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HexToBin {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String input = reader.readLine();

        HashMap<Character, Integer> hexTable = new HashMap<>();
        int i = 0;
        char currentChar = '0';

        if (input.length() == 1 && input.charAt(0) == '0') {
            System.out.println("0000");
            return;
        }

        for (; i < 10; i++) {
            hexTable.put(currentChar, i);
            currentChar++;
        }

        currentChar = 'A';

        for (; i < 16; i++) {
            hexTable.put(currentChar, i);
            currentChar++;
        }

            char currentHexNumber = input.charAt(0);
            int valueOfHex = hexTable.get(currentHexNumber);
            StringBuilder convert = new StringBuilder();

            while (valueOfHex > 0) {
                convert = new StringBuilder().append(valueOfHex % 2).append(convert);
                valueOfHex /= 2;
            }

            result.append(convert);

        for (int j = 1; j < input.length(); j++) {
            currentHexNumber = input.charAt(j);
            valueOfHex = hexTable.get(currentHexNumber);
            convert = new StringBuilder("0000");
            int digitCounter = 0;
            int currentIndex = 3;
            while (valueOfHex > 0) {
                convert.setCharAt(currentIndex - digitCounter, (char)(valueOfHex % 2 + '0'));

                valueOfHex /= 2;
                digitCounter++;
            }
            result.append(convert);
        }

        System.out.println(result);
    }
}