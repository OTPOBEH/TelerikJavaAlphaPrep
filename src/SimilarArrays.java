import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SimilarArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        reader.readLine();
        String[] inputFirstArray = reader.readLine().split(" ");
        Set<Integer> noDuplicatesArrayOne = new HashSet<>();

        for (int i = 0; i < inputFirstArray.length; i++) {
            noDuplicatesArrayOne.add(Integer.parseInt(inputFirstArray[i]));
        }

        reader.readLine();
        String[] inputSecondArray = reader.readLine().split(" ");
        Set<Integer> noDuplicatesArrayOTwo = new HashSet<>();

        for (int i = 0; i < inputSecondArray.length; i++) {
            noDuplicatesArrayOTwo.add(Integer.parseInt(inputSecondArray[i]));
        }

        ArrayList<Integer> similarityLog = new ArrayList<>();
        ArrayList<Integer> differenceLog = new ArrayList<>();

        Iterator firstIter = noDuplicatesArrayOne.iterator();
        Iterator secondIter = noDuplicatesArrayOTwo.iterator();


if (noDuplicatesArrayOne.size() == noDuplicatesArrayOTwo.size()){




}



    }
}
