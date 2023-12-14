package algorithms.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1 || s.length() == 0)
            return s.length();
        Map<Character, Integer> index = new HashMap<>();

        StringBuilder longest = new StringBuilder();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!index.containsKey(ch)) {
                index.put(ch, i);
                str.append(ch);
            } else {
                String sub = s.substring(index.get(ch), i);
                if (sub.length() >= str.length()) {
                    index.put(ch, i);
                } else {
                    if (longest.length() < str.length()){
                        longest = str;
                    }
                    str = new StringBuilder(String.valueOf(ch));
                }
            }
        }
        return longest.length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
