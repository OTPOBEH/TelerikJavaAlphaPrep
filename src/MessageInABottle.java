import java.io.*;
import java.util.*;

public class MessageInABottle {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String message = reader.readLine();
        String code = reader.readLine();
        String[] secretCode = code.split("[^A-Z0-9]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])");
        int n = secretCode.length / 2;
        String[] letters = new String[n];
        String[] codes = new String[n];
        for (int i = 0; i < 2 * n; i += 2) {
            letters[i / 2] = secretCode[i];
            codes[i / 2] = secretCode[i + 1];
        }

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(codes[i], letters[i]);
        }

        Set<String> gSet = new TreeSet<>();

        codesCheck(message, map, gSet, new StringBuilder());

        System.out.println(gSet.size());
        for (String s : gSet) {
            System.out.println(s);
        }
    }

    private static void codesCheck(String message, Map<String, String> map, Set<String> gSet, StringBuilder sb) {
        if (message.length() == 0) {
            gSet.add(sb.toString());
            return;
        }
        for (String str : map.keySet()) {
            if (message.startsWith(str)) {
                String newMsg = message.substring(str.length());
                sb.append(map.get(str));
                codesCheck(newMsg, map, gSet, sb);
                sb.setLength(sb.length() - map.get(str).length());
            }
        }
    }
}