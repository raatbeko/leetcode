package leetcode.medium;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0, start = 0, end = nums.length - 1;
        while (start < end) {
            int startI = nums[start];
            int endI = nums[end];
            if (endI >= k) {
                end--;
                endI = nums[end];
            }
            if (end != start && startI + endI == k) {
                start++;
                end--;

                count++;
            } else if (startI + endI > k) {
                end--;
            } else {
                start++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3}, 2));
    }
}
