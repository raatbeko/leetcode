package leetcode.easy;

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
        int i = 0;
        for (i = 0; i < 10; i++) {

        }
        System.out.println(i);
    }
}
