package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayPairsAreDivisibleByK {

    public static boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> keyAndCount = new HashMap<>();
        for (int i : arr) {
            int r = (i % k + k) % k;
            if (keyAndCount.containsKey(k - r)) {
                Integer count = keyAndCount.get(k - r);
                if (count == 1) {
                    keyAndCount.remove(k - r);
                } else {
                    keyAndCount.replace(k - r, count - 1);
                }
                continue;
            }
            if (r == 0 && keyAndCount.containsKey(0)) {
                keyAndCount.remove(0);
                continue;
            }
            if (keyAndCount.containsKey(r)) {
                Integer count = keyAndCount.get(r);
                keyAndCount.replace(r, count + 1);
            } else {
                keyAndCount.put(r, 1);
            }
        }
        return keyAndCount.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(reverse("name"));
    }

    private static String reverse(String string) {
        StringBuilder s = new StringBuilder();
        for (int length = string.length() - 1; length >= 0; length--) {
            s.append(string.charAt(length));
        }
        return s.toString();
    }
}
