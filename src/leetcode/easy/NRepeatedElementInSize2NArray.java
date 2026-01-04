package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NRepeatedElementInSize2NArray {

    public int repeatedNTimes(int[] nums) {
        Set<Integer> count = new HashSet<>();
        int n = nums.length / 2;

        for (int num : nums) {
            if (count.contains(num)) return num;
            count.add(num);
        }
        return 0;
    }
}
