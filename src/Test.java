import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String word = reader.readLine();

        if (isConstant(word)) System.out.println("constant");
        else if (isField(word)) System.out.println("field");
        else if (isPascal(word)) System.out.println("pascal");
        else if (isElephant(word)) System.out.println("elephant");
        else System.out.println("mismatch");
    }

    private static boolean isConstant(@NotNull String word) {
        // all letters are capital, i.e. “USA”. Only letters are used.
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i)) || !Character.isUpperCase(word.charAt(i))) return false;
        }
        return true;
    }

    private static boolean isField(@NotNull String word) {
        //all letters are lower. i.e. “bambi”. Only letters are used.
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i)) || Character.isUpperCase(word.charAt(i))) return false;
        }
        return true;
    }

    private static boolean isPascal(@NotNull String word) {
        //starts with capital letter and has only lower-case letters after that, i.e. “Mind”. Only letters are used.
        if (word.length() == 1) return false;
        if (!Character.isLetter(word.charAt(0)) || !Character.isUpperCase(word.charAt(0))) return false;

        for (int i = 1; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i)) || Character.isUpperCase(word.charAt(i))) return false;
        }
        return true;
    }

    private static boolean isElephant(@NotNull String word) {
        if (word.length() == 1) return false;
        if (!Character.isLetter(word.charAt(0)) || Character.isUpperCase(word.charAt(0))) return false;

        int index = 1;
        while (Character.isLowerCase(word.charAt(index))) {
            index++;
        }

        for (int i = index; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i)) || !Character.isUpperCase(word.charAt(i))) return false;
        }
        return true;
    }
}