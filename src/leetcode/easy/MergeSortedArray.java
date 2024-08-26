package leetcode.easy;

import java.util.Arrays;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        if (m == 0) {
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
        }
        int length = m + n;
        int l = length - n;
        for (int i = 0; i < length; i++) {
            if (n - 1 >= i) {
                if (nums1[i] == nums2[i]) {
                    int num = nums1[i + 1];
                    nums1[i + 1] = nums2[i];
                    nums1[m] = num;
                    m++;
                } else if (nums1[i] > nums1[i]) {
                    int num = nums1[i];
                    nums1[i] = nums2[i];
                    nums1[m] = num;
                    m++;
                } else {
                    nums1[m] = nums2[i];
                    m++;
                }
                continue;
            }
            if (l == i)
                l--;
            if (l < length && nums1[l] > nums1[i]) {
                int num = nums1[i];
                nums1[i] = nums1[l];
                nums1[l] = num;
                l++;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        merge(new int[]{2,0}, 1, new int[]{1}, 1);
    }
}
