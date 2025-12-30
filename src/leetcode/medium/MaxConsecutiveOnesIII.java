package leetcode.medium;

public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {
        int maxLength = 0, start = 0, end = 0, zeroCount = 0;
        while (end != nums.length) {
            if (nums[end] == 0) {
                zeroCount++;
            }
            if (zeroCount > k) {
                if (nums[start] == 0) zeroCount--;
                start++;
                end++;
                continue;
            }
            if (maxLength < end - start + 1 && zeroCount <= k)
                maxLength = end - start + 1;

            end++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0,0,0,1}, 4));
    }
}
