package leetcode.medium;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int inx = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= inx){
                inx = i;
            }
        }
        return inx == 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }
}
