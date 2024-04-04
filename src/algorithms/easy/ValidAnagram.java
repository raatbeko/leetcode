package algorithms.easy;

import java.util.Arrays;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Create copies of the strings
        s = s.toLowerCase();  // Assuming case doesn't matter
        t = t.toLowerCase();

        // Convert strings to character arrays for easier manipulation
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        // Sort the character arrays
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        // Check if the sorted character arrays are equal
        return Arrays.equals(sChars, tChars);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("aacc", "ccac"));
    }
}
