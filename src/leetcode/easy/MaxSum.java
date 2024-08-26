package leetcode.easy;

public class MaxSum {

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{31, 25, 72, 79, 74}));
    }

    public static int maxSum(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (maxNum(nums[i]) == maxNum(nums[j]))
                    if ((nums[i] + nums[j] > max)) {
                        max = nums[i] + nums[j];
                    }
            }
        }
        return max == 0 ? -1 : max;
    }

    private static int maxNum(int num) {
        int max = 0;

        while (num != 0) {
            if ((num % 10) > max)
                max = num % 10;
            num /= 10;
        }
        return max;
    }
}
