import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HexToBin2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        HashMap<Character, String> hexBinTable = new HashMap<>();

        hexBinTable.put('0', "0000");
        hexBinTable.put('1', "0001");
        hexBinTable.put('2', "0010");
        hexBinTable.put('3', "0011");
        hexBinTable.put('4', "0100");
        hexBinTable.put('5', "0101");
        hexBinTable.put('6', "0110");
        hexBinTable.put('7', "0111");
        hexBinTable.put('8', "1000");
        hexBinTable.put('9', "1001");
        hexBinTable.put('A', "1010");
        hexBinTable.put('B', "1011");
        hexBinTable.put('C', "1100");
        hexBinTable.put('D', "1101");
        hexBinTable.put('E', "1110");
        hexBinTable.put('F', "1111");

        StringBuilder printout = new StringBuilder();

        String firstNumber = hexBinTable.get(input.charAt(0));
        char currentChar = firstNumber.charAt(0);

        int i = 0;
        while (currentChar == '0') {
            currentChar = firstNumber.charAt(++i);
        }

        for (; i < firstNumber.length(); i++) {
            currentChar = firstNumber.charAt(i);
            printout.append(currentChar);
        }

        for (int j = 1; j < input.length(); j++) {
            currentChar = input.charAt(j);
            printout.append(hexBinTable.get(currentChar));
        }

        System.out.println(printout);
    }
}