import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HexToDecimal {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final String input = reader.readLine();

        HashMap<Character, Integer> hexNumberTable = new HashMap<>();
        hexNumberTable.put('0', 0);
        hexNumberTable.put('1', 1);
        hexNumberTable.put('2', 2);
        hexNumberTable.put('3', 3);
        hexNumberTable.put('4', 4);
        hexNumberTable.put('5', 5);
        hexNumberTable.put('6', 6);
        hexNumberTable.put('7', 7);
        hexNumberTable.put('8', 8);
        hexNumberTable.put('9', 9);
        hexNumberTable.put('A', 10);
        hexNumberTable.put('B', 11);
        hexNumberTable.put('C', 12);
        hexNumberTable.put('D', 13);
        hexNumberTable.put('E', 14);
        hexNumberTable.put('F', 15);

        long result = 0;
        int pow = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            result += (hexNumberTable.get(input.charAt(i)) * Math.pow(16, pow++));
        }
        System.out.println(result);
    }
}