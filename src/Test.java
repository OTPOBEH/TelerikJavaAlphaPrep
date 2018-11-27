import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = "pipi";

        String result = changePi(input);
        System.out.println(result);

    }

    private static String changePi(String str) {
        if (str.length() < 2) return str;

        if(str.charAt(0) == 'p' && str.charAt(1) == 'i'){
            return "3.14" + changePi(str.substring(2));
        }
        return str.charAt(0) + changePi(str.substring(1));
    }
}