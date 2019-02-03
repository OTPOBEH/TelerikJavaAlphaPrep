import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Numerology {

    private static int[] countingNums = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] input = reader.readLine().toCharArray();

        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            nums.add(input[i] - '0');
        }

        Intermediate_Zada4a_Na_Purviq_Den_Sled_Lekciqta(nums);

        StringBuilder sb = new StringBuilder();

        for (int countingNum : countingNums) {
            sb.append(countingNum).append(" ");
        }

        System.out.println(sb);
    }

    static void Intermediate_Zada4a_Na_Purviq_Den_Sled_Lekciqta(ArrayList<Integer> list) {

        if (list.size() <= 1) {
            countingNums[list.get(0)]++;
            return;
        }

        for (int i = 1; i < list.size(); i++) {
            int a = list.get(i - 1);
            int b = list.get(i);
            int res = (a + b) * (a ^ b) % 10;

            list.remove(i);
            list.set(i - 1, res);

            Intermediate_Zada4a_Na_Purviq_Den_Sled_Lekciqta(list);

            list.set(i - 1, a);
            list.add(i,b);
        }
    }
}