package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class СanConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransom = new HashMap<>();
        int count = 0;
        for (char c : ransomNote.toCharArray()) {
            if (ransom.containsKey(c)) {
                int num = ransom.get(c) + 1;
                ransom.put(c, num);
                continue;
            }
            ransom.put(c, 0);
            count++;
        }
        for (char c : magazine.toCharArray()) {
            if (ransom.containsKey(c)) {
                int num = ransom.get(c) - 1;
                ransom.put(c, num);
                if (num == -1)
                    count--;
            }
        }
        return count == 0;
    }
}
