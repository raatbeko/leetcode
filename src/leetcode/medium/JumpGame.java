package leetcode.medium;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;

        int n = nums[0];
        int i = 1;
        while (true) {
            if (i + n >= nums.length)
                return true;

            int min = 0;
            int K = i + n;
            for (int j = i; j < K; j++) {
                if (nums[j] > n) {
                    i = j+1;
                    min = nums[j];
                    break;
                } else if (nums[j] != 0 && nums[j] <= n) {
                    if (min < nums[j]) {
                        min = nums[j];
                        i = j+1;
                    }
                }
            }
            if (min == 0) return false;
            else n = min;
        }
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }
}
