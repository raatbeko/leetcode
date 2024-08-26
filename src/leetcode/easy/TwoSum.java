package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> twoSum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (var item : twoSum.entrySet()) {
                if (item.getValue() + nums[i] == target){
                    return new int[]{item.getKey(), i};
                }
            }
            if (nums[i] <= target){
                twoSum.put(i, nums[i]);
            }
            if (nums[i] < 0 && nums[i] >= target){
                twoSum.put(i, nums[i]);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{-1,-2,-3,-4,-5}, -8)));
    }
}
