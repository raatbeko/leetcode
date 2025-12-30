package leetcode.medium;

public class LongestSubarrayOfFirstAfterDeletingOneElement {

    public static int longestSubarray(int[] nums) {
        int maxLength = 0, start = 0, end = 0, zeroCount = 0;
        while (end != nums.length) {
            if (nums[end] == 0) {
                zeroCount++;
            }
            if (zeroCount > 1) {
                if (nums[start] == 0) zeroCount--;
                start++;
                end++;
                continue;
            }
            if (maxLength < end - start)
                maxLength = end - start;

            end++;
        }
        return maxLength;
    }
}
