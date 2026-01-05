package leetcode.easy;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int[] ints = new int[nums.length];
        int end = nums.length - 1;
        int start = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                ints[start] = num;
                start++;
            } else {
                ints[end] = num;
                end--;
            }
        }
        return ints;
    }
}
