import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MissCat {
    public static void main(String[] args) throws Exception {

        int[] catScores = new int[11];

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int judgesCount = Integer.parseInt(in.readLine());

        int maxScoreCat = 0;

        for (int i = 0; i < judgesCount; i++) {

            int judgeVote = Integer.parseInt(in.readLine());
            catScores[judgeVote]++;
            if (catScores[judgeVote] > catScores[maxScoreCat]) maxScoreCat = judgeVote;
        }

        System.out.print(maxScoreCat);
    }
}