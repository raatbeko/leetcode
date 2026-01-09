package leetcode.medium;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int currentSum = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (currentSum < 0) {
                currentSum = num;
            } else {
                currentSum += num;
            }
            if (max < currentSum) {
                max = currentSum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {5,4,-1,7,8}));
    }
}
