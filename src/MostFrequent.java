import java.util.*;

public class MostFrequent {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        int maxKey = 0;
        int maxValue = 0;

        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < size; i++) {
            int current = in.nextInt();
            if (numbers.containsKey(current)) numbers.put(current, numbers.get(current) + 1);
            else numbers.put(current, 1);

            if (numbers.get(current) > maxValue) {
                maxKey = current;
                maxValue = numbers.get(current);
            }
        }
        numbers.forEach((k, v) -> System.out.println(k));
        System.out.printf("%d(%d times)", maxKey, maxValue);
    }
}