import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Indices {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();

        HashMap<Integer, Integer> passedFields = new HashMap<>();

        StringBuilder result = new StringBuilder();


        String[] arrInput = reader.readLine().split(" ");

        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        passedFields.put(0, 0);

        boolean cycleDetected = false;
        int step = 1;

        int currentIndex = 0;
        int indexBeforCycle = 0;

        while (passedFields.size() < arrInput.length) {
            currentIndex = Integer.parseInt(arrInput[currentIndex]);
            if (currentIndex >= arrInput.length || currentIndex < 0) break;

            if (passedFields.containsKey(currentIndex)) {
                cycleDetected = true;
                indexBeforCycle = passedFields.get(currentIndex);
                break;
            }

            path.add(currentIndex);
            passedFields.put(currentIndex, step);
            step++;
        }


        if (cycleDetected) {
            for (int i = 0; i < indexBeforCycle; i++) {
                result.append(path.get(i)).append(" ");
            }
            result.setLength(Math.max(result.length() - 1, 0));
            result.append("(");

            for (int i = indexBeforCycle; i < path.size(); i++) {
                result.append(path.get(i)).append(" ");
            }

            result.setLength(result.length() - 1);

            result.append(")\n");
        } else {
            for (int i = 0; i < path.size(); i++) {
                result.append(path.get(i)).append(" ");
            }
        }

        System.out.println(result);
    }
}
