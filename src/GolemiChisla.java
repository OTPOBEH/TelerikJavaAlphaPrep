import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GolemiChisla {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String someNumber = reader.readLine();
        String input = reader.readLine();

        String biggest = longestPalindromeString(input);

        System.out.println(biggest);
    }

    static private String intermediatePalindrome(String s, int left, int right) {
        if (left > right) return null;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right) && s.charAt(left) != 0) {
            left--;
            while (left >= 0 && s.charAt(left) == ' ') left--;
            right++;
            while (right < s.length() && s.charAt(right) == ' ') right++;
        }

        return s.substring(left + 1, right);
    }

    // O(n^2)
    private static String longestPalindromeString(String s) {
        if (s == null) return null;
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            //odd cases like 121
            String palindromeInterm = intermediatePalindrome(s, i, i);
            String palindrome = palindromeInterm.replaceAll(" ", "");

            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            } else if (palindrome.length() == longest.length() && palindrome.compareTo(longest) > 0) {
                longest = palindrome;
            }
            //even cases like 1221
            palindromeInterm = intermediatePalindrome(s, i, i + 1);
            palindrome = palindromeInterm.replaceAll(" ", "");

            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            } else if (palindrome.length() == longest.length() && palindrome.compareTo(longest) > 0) {
                longest = palindrome;
            }
        }
        return longest;
    }
}