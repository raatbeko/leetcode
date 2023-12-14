package algorithms.easy;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {
    public static void main(String[] args) {
        int num = 0;
        System.out.println(++num);
    }

    private static char findTheDifference(String s, String t) {
        if (s.length() == 0)
            return t.charAt(0);
        Map<Character, Integer> stringMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (stringMap.containsKey(s.charAt(i))) {
                int num = stringMap.get(s.charAt(i));
                stringMap.put(s.charAt(i), num + 1);
            } else {
                stringMap.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (!stringMap.containsKey(t.charAt(i))) {
                return t.charAt(i);
            }
            int num = stringMap.get(t.charAt(i)) - 1;
            if (num < 0)
                return t.charAt(i);
            stringMap.put(t.charAt(i), num);
        }
        return ' ';
    }
}
