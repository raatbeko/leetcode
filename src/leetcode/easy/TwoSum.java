package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x = target - nums[i];
            if (integerIntegerHashMap.containsKey(x)) {
                Integer i1 = integerIntegerHashMap.get(x);
                return new int[]{i1, i};
            } else {
                integerIntegerHashMap.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
    }
}
