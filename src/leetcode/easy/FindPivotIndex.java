package leetcode.easy;

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {
        int[] right = new int[nums.length];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i];
        }

        int[] left = new int[nums.length];
        left[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (left[i] == right[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{2,1,-1}));
    }
}
