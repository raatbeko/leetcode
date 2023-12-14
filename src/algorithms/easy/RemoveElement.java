package algorithms.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int n = nums[k];
                nums[k] = nums[i];
                nums[i] = n;
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1, 1, 2}, 2));
    }
}
