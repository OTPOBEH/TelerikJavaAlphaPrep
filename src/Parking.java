import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Parking {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] parkingSize = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        final int bigCarSize = 4;

        String [][] parkingConfig = new String[parkingSize[0]][parkingSize[1]];

        for (int row = 0; row < parkingSize[0]; row++) {
            String inputLine = reader.readLine();

            for (int col = 0; col < parkingSize[1]; col++) {
                parkingConfig[row][col] = String.valueOf(inputLine.charAt(col));
            }
        }

        int[] slotsByCars = new int[5];

        final int[] checkRow = new int[]{0, 0, 1, 1};
        final int[] checkCol = new int[]{0, 1, 0, 1};

        for (int i = 0; i < parkingConfig.length - 1; i++) {
            for (int j = 0; j < parkingConfig[1].length - 1; j++) {
                int cars = 0;
                boolean building = false;

                for (int k = 0; k < bigCarSize; k++) {
                    if (parkingConfig[i + checkRow[k]][j + checkCol[k]].equals("#")) {
                        building = true;
                        break;
                    } else if (parkingConfig[i + checkRow[k]][j + checkCol[k]].equals("X")) cars++;
                }

                if (!building) slotsByCars[cars]++;
            }
        }

        StringBuilder printout = new StringBuilder();

        for (int i = 0; i < slotsByCars.length; i++) {
            printout.append(slotsByCars[i]).append("\n");
        }

        System.out.print(printout);
    }
}