import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NaPlaj {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();

        int[] timeInterval = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int loniArrivalTime = timeInterval[0] * 100 +
                timeInterval[1];

        int loniDepartureTime = timeInterval[2] * 100 +
                timeInterval[3];

        int moniArrivalTime = timeInterval[4] * 100 +
                timeInterval[5];

        int moniDepartureTime = timeInterval[6] * 100 +
                timeInterval[7];

        int[] loniInterval = new int[]{-1, -1, -1, -1};
        int[] moniInterval = new int[]{-1, -1, -1, -1};

        if (loniArrivalTime <= moniArrivalTime) {
            loniInterval[0] = loniArrivalTime;
            moniInterval[1] = moniArrivalTime;
        } else {
            loniInterval[1] = loniArrivalTime;
            moniInterval[0] = moniArrivalTime;
        }

        if (loniDepartureTime <= moniDepartureTime) {
            loniInterval[2] = loniDepartureTime;
            moniInterval[3] = moniDepartureTime;
        } else {
            loniInterval[3] = loniDepartureTime;
            moniInterval[2] = moniDepartureTime;
        }

        //(StartL <= EndM) and (EndL >= StartM)

        int startInterval = Math.max(loniInterval[1], moniInterval[1]);
        int endInterval = Math.max(loniInterval[2], moniInterval[2]);

        if (startInterval > endInterval) result.append("No");
        else {

            result.append(startInterval / 100).append(' ').append(startInterval % 100).append(' ').
                    append(endInterval / 100).append(' ').append(endInterval % 100);
        }

        System.out.print(result);

    }
}