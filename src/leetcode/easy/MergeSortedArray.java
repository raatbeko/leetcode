package leetcode.easy;

import java.util.Arrays;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        if (m == 0) {
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
        }
        int mStart = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (m - 1 < i) {
                nums1[i] = nums2[mStart];
                mStart++;
            } else if (nums1[i] > nums2[mStart]) {
                int i1 = nums1[i];
                nums1[i] = nums2[mStart];
                nums2[mStart] = i1;
                Arrays.sort(nums2);
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {4, 5, 6, 0, 0, 0};
        merge(ints, 3, new int[]{1, 2, 3}, 3);
        System.out.println(Arrays.toString(ints));
    }
}
