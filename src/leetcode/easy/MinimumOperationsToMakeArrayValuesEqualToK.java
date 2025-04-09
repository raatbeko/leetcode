package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class MinimumOperationsToMakeArrayValuesEqualToK {
    public int minOperations(int[] nums, int k) {
        Set<Integer> integers = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            if (num > k && !integers.contains(num)) {
                integers.add(num);
                count++;
            }
            if (num < k) return -1;
        }

        return count;
    }
}
