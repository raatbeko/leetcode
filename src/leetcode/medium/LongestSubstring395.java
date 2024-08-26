package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring395 {

    public static int longestSubstring(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!counts.containsKey(c)) {
                counts.put(c, 1);
            } else {
                int val = counts.get(c);
                counts.put(c, val + 1);
            }
        }
        int count = 0;
        for (var item : counts.entrySet()){
            if (item.getValue() >= k){
                count += item.getValue();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
    }
}
