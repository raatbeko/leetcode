package leetcode.easy;

public class MaximumAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        int i = 0, j = k - 1, preI = 0;
        Double maxAverage = null;
        double preAverage = 0d;
        while (j != nums.length) {
            if (maxAverage == null) {
                maxAverage = countAverage(nums, i, j);
                preAverage = maxAverage;
            } else {
                double average1 = preAverage - nums[preI] + nums[j];
                preI = i;

                if (maxAverage / k < average1 / k) {
                    maxAverage = average1;
                }
                preAverage = average1;
            }
            i++;
            j++;
        }
        return maxAverage == null ? countAverage(nums, i, j) / k : maxAverage / k;
    }

    private static double countAverage(int[] nums, int start, int end) {
        if (end == nums.length) end--;

        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
