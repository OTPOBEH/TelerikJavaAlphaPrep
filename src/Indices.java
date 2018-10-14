import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Indices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String elements = reader.readLine();

        String[] arrayInput = reader.readLine().split(" ");
        boolean[] visited = new boolean[arrayInput.length];
        visited[0] = true;

        int nextIndex = Integer.parseInt(arrayInput[0]);

        ArrayList<Integer> visitingSequence = new ArrayList<>();
        visitingSequence.add(0);

        StringBuilder printout = new StringBuilder().append(0);

        while (nextIndex >= 0 && nextIndex < arrayInput.length) {
            if (visited[nextIndex] == true) {
                printout = new StringBuilder();

                for (int i = 0; i < visitingSequence.size(); i++) {
                    if (i == visitingSequence.indexOf(nextIndex)) {
                        printout.append('(').append(visitingSequence.get(i));
                    }
                    else if (i != 0) printout.append(" ").append(visitingSequence.get(i));
                    else printout.append(visitingSequence.get(i));
                }
                printout.append(')');
                break;
            }
            visited[nextIndex] = true;
            visitingSequence.add(nextIndex);
            printout.append(" ").append(nextIndex);
            nextIndex = Integer.parseInt(arrayInput[nextIndex]);
        }

        System.out.println(printout);
    }
}
//Indices 8/10