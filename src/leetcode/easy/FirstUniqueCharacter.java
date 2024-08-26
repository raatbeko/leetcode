package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public static int firstUniqChar(String s) {
        Map<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            counts.put(currentChar, counts.getOrDefault(currentChar, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (counts.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("nnaamme"));
    }

}
