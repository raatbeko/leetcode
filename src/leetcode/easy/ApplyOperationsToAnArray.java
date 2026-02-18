package leetcode.easy;

import java.util.Arrays;

public class ApplyOperationsToAnArray {

    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i + 1] = 0;
                nums[i] = nums[i] * 2;
            }
        }

        int lasZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[lasZero] == 0 && nums[i] != 0) {
                nums[lasZero] = nums[i];
                nums[i] = 0;
                lasZero++;
            } else if (nums[lasZero] != 0) {
                if (nums[i] == 0) {
                    lasZero = i;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ApplyOperationsToAnArray().applyOperations(new int[]{1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,1,1,1,1,1})));
    }
}
