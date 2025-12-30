package leetcode.medium;

import java.util.*;

public class DetermineIfTwoStringsAreClose {
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        HashMap<Character, Integer> word1Map = new HashMap<>();
        HashMap<Character, Integer> word2Map = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            word1Map.put(word1.charAt(i), word1Map.getOrDefault(word1.charAt(i), 0) + 1);
            word2Map.put(word2.charAt(i), word2Map.getOrDefault(word2.charAt(i), 0) + 1);
        }
        if (!word1Map.keySet().equals(word2Map.keySet())) return false;

        List<Integer> freq1 = new ArrayList<>(word1Map.values());
        List<Integer> freq2 = new ArrayList<>(word2Map.values());
        Collections.sort(freq1);
        Collections.sort(freq2);
        return freq1.equals(freq2);

    }

    public static void main(String[] args) {
        System.out.println(closeStrings("abbzzca", "babzzcz"));
    }
}
