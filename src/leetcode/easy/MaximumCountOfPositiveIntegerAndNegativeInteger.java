package leetcode.easy;

public class MaximumCountOfPositiveIntegerAndNegativeInteger {

    public static int maximumCount(int[] nums) {

        int negativeCount = 0;
        int positiveCount = 0;

        int left = 0;
        int right = nums.length - 1;

//        int target = 0;
//
//        int mid = left + (right - left) / 2;
//        left = mid;
//        right = mid;
//        while (true) {
//
//            if (nums[mid] == target) {
//                left--;
//                right++;
//            } else if (nums[mid] < target) {
//                left++;
//            } else {
//                right--;
//            }
//            target = nums[mid];
//        }

        while (left <= right) {
            if (nums[left] < 0) {
                negativeCount++;
            } else if (nums[left] > 0) {
                positiveCount++;
            }
            if (left == right) return Math.max(negativeCount, positiveCount);
            if (nums[right] < 0) {
                negativeCount++;
            } else if (nums[right] > 0) {
                positiveCount++;
            }
            left++;
            right--;
        }
        return Math.max(negativeCount, positiveCount);
    }

    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{-3, -2, -1, -2, 0, 1, 2}));
    }
}
