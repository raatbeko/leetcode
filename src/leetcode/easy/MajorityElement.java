package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> numCounts = new HashMap<>();
        int totalCount = nums.length / 2;
        int element = 0;
        for (int num : nums) {
            if (!numCounts.containsKey(num)) {
                numCounts.put(num, 1);
            } else {
                int count = numCounts.get(num) + 1;
                numCounts.replace(num, count);
                if (count >= totalCount) {
                    totalCount = count;
                    element = num;
                }
            }
        }
        return element;
    }
}
