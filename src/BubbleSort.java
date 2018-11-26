import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BubbleSort ob = new BubbleSort();
        int razmer = 5;
        int vavedeno[] = new int[razmer];

        int[] povtorenia = new int[30];

        for (int i = 0; i < razmer; i++) {
            vavedeno[i] = Integer.parseInt(reader.readLine());
            povtorenia[vavedeno[i]]++;
        }

        int[] indexes = new int[30];

        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }

        ob.bubbleSort(povtorenia, indexes);
        System.out.println();
        System.out.println("Повторенията са:");
        ob.printArray(indexes, povtorenia);
    }

    void bubbleSort(int povtorenia[], int[] indexes) {
        int n = povtorenia.length;


        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (povtorenia[j] < povtorenia[j + 1]) {
                    // swap temp and vavedeno[i] 
                    int temp = povtorenia[j];
                    povtorenia[j] = povtorenia[j + 1];
                    povtorenia[j + 1] = temp;
                    temp = indexes[j];
                    indexes[j] = indexes[j + 1];
                    indexes[j + 1] = temp;
                }
    }

    /* Prints the vavedenoay */
    void printArray(int vavedeno[], int[] indexes) {
        int n = vavedeno.length;
        for (int i = 0; i < n; ++i)
        {
            String zaDobavqne = " пъти";
            if(indexes[i] == 1) zaDobavqne = " път";
            System.out.println(vavedeno[i] + ": " + indexes[i] +zaDobavqne);
        }
    }
}