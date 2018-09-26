import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PodobniMasivi {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstArrayLenght = reader.readLine();
        String[] firstArrayInput = reader.readLine().split(" ");

        String secondArrayLenght = reader.readLine();
        String[] secondArrayInput = reader.readLine().split(" ");

        SortedSet<Integer> firstArrayAsSet = new TreeSet<>(); //Използваме SortedSet, защото така се отърваваме от повторенията и ни искат резултатите сортирани.
        Set<Integer> secondArrayAsSet = new HashSet<>(); //Използваме HashSet, за да се отървен от повторенията

        for (int i = 0; i < firstArrayInput.length; i++) {
            firstArrayAsSet.add(Integer.parseInt(firstArrayInput[i]));
        }

        for (int i = 0; i < secondArrayInput.length; i++) {
            secondArrayAsSet.add(Integer.parseInt(secondArrayInput[i]));
        }

        StringBuilder difference = new StringBuilder();

        int counter = 0;

        Iterator iter = firstArrayAsSet.iterator();
        while (iter.hasNext()) {
            Integer currentFirst = (Integer) iter.next();
            if (!secondArrayAsSet.contains(currentFirst)) difference.append(currentFirst).append(" ");
            else counter++;
        }

        if (difference.length() != 0) System.out.println(difference);
        else System.out.println(counter);
    }
}