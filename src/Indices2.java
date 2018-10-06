import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Indices2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String size = reader.readLine();

        String[] input = reader.readLine().split(" ");

        HashMap<Integer, Integer> indexTracing = new HashMap<>();

        ArrayList<Integer> printingRow = new ArrayList<>();

        int index = 0;
        int arrangement = 0;
        indexTracing.put(index, arrangement);
        printingRow.add(0);
        index = Integer.parseInt(input[index]);
        boolean cycleDetected = false;

        if (index == 0) {
            System.out.println("(0)");
            return;
        }

        while (index >= 0 && index <= input.length) {
            printingRow.add(index);
            arrangement++;
            indexTracing.put(index, arrangement);
            index = Integer.parseInt(input[index]);
            if (indexTracing.containsKey(index)) {
                cycleDetected = true;
                break;
            }
        }

        StringBuilder printout = new StringBuilder();
        if (cycleDetected) {
            int key = indexTracing.get(index);
            if (key == 0) {
                printout.append('(');
                int i = 0;
                for (;i < printingRow.size() - 1; i++) {
                    printout.append(printingRow.get(i)).append(" ");
                }
                printout.append(printingRow.get(i));
            } else {
                for (int i = 0; i < index; i++) {
                    printout.append(" ");
                    printout.append(printingRow.get(i));
                }
                printout.append('(');
                int i = index;
                for (; i < printingRow.size() - 1; i++) {
                    printout.append(printingRow.get(i)).append(" ");
                }
                printout.append(printingRow.get(i));
            }
            printout.append(')');
        } else {
            for (int i = 0; i < printingRow.size(); i++) {
                printout.append(printingRow.get(i)).append(" ");
            }
        }

        System.out.println(printout);
    }
}