package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberOfOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> iCount = new HashMap<>();
        for (int i : arr) {
            iCount.put(i, iCount.getOrDefault(i, 0) + 1);
        }
        HashSet<Integer> integers = new HashSet<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : iCount.entrySet()) {
            if (integers.contains(integerIntegerEntry.getValue())) return false;
            integers.add(integerIntegerEntry.getValue());
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{26, 2, 16, 16, 5, 5, 26, 2, 5, 20, 20, 5, 2, 20, 2, 2, 20, 2, 16, 20, 16, 17, 16, 2, 16, 20, 26, 16}));
    }
}
