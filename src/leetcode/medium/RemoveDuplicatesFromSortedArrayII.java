package leetcode.medium;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1)
            return 1;
        int length = 0;
        int start = 0;
        int end = 1;
        while (end < nums.length) {
            if (nums[start] == nums[end]) {
                end++;
            } else {
                while (start != end - 1) {
                    if (end == nums.length - 1) {
                        nums[end - 1] = nums[end];
                    } else {
                        int num = nums[end];
                        nums[end] = nums[end + 1];
                    }
                    end--;
                    length++;
                }
                if (start == end - 1) {
                    start = end + 1;
                    end++;
                }
            }
            if (end + 1 == nums.length) {
                System.out.println(start);
                System.out.println(end);
            }
        }
        return length;
    }

    private static void setToEnd(int[] nums, int inx) {
        for (int i = inx + 1; i < nums.length - 1; i++) {
//            nums[i + 1]
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 2, 3, 3, 333};
        System.out.println(removeDuplicates(ints));
        System.out.println(Arrays.toString(ints));
        System.out.println(ints.length);
    }
}
