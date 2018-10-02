import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BinToHex {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        HashMap<String, Character> binHexTable = new HashMap<>();

        binHexTable.put("0000", '0');
        binHexTable.put("0001", '1');
        binHexTable.put("0010", '2');
        binHexTable.put("0011", '3');
        binHexTable.put("0100", '4');
        binHexTable.put("0101", '5');
        binHexTable.put("0110", '6');
        binHexTable.put("0111", '7');
        binHexTable.put("1000", '8');
        binHexTable.put("1001", '9');
        binHexTable.put("1010", 'A');
        binHexTable.put("1011", 'B');
        binHexTable.put("1100", 'C');
        binHexTable.put("1101", 'D');
        binHexTable.put("1110", 'E');
        binHexTable.put("1111", 'F');

        StringBuilder printout = new StringBuilder();
        int j = 0;

        int firstNuberLength = input.length() % 4;

        if (firstNuberLength != 0) {
            StringBuilder temp = new StringBuilder();

            for (int i = 0; i < 4 - firstNuberLength; i++) {
                temp.append('0');
            }

            String current = temp.append(input, 0, firstNuberLength).toString();
            printout.append(binHexTable.get(current));
            j = firstNuberLength;
        }

        for (; j <= input.length() - 4; j += 4) {
            String current = input.substring(j, j + 4);
            printout.append(binHexTable.get(current));
        }

        System.out.println(printout);
    }
}