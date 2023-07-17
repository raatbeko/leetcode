package algorithms.medium;

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 8, 8, 8}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        int start = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (!flag) {
                    start = i;
                    flag = true;
                }
                if (i + 1 != nums.length && nums[i + 1] != target || i == nums.length - 1) {
                    return new int[]{start, i};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
