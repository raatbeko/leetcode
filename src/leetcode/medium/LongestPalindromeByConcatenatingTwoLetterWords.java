package leetcode.medium;

import java.util.HashMap;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    public static int longestPalindrome(String[] words) {
        int length = 0;
        int polindrom = 0;
        HashMap<String, Integer> strings = new HashMap<>();
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder(word);
            String reversed = stringBuilder.reverse().toString();

            if (reversed.equals(word)) {
                if (strings.containsKey(reversed)) {
                    strings.remove(reversed);
                    length += 4;
                    polindrom -= 2;
                } else {
                    strings.put(word, 1);
                    polindrom += 2;
                }
                continue;
            }
            if (strings.containsKey(reversed) && strings.get(reversed) > 0) {
                strings.put(reversed, strings.get(reversed) - 1);
                length += 4;
            } else {
                strings.put(word, strings.getOrDefault(word, 0) + 1);
            }
        }
        return polindrom > 0 ? length + 2 : length;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome(new String[]{"qo", "fo", "fq", "qf", "fo", "ff", "qq", "qf", "of", "of", "oo", "of", "of", "qf", "qf", "of"}));
    }
}
