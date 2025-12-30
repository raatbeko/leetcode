package leetcode.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = getPrefix(nums);
        int[] suffix = getSuffix(nums);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefix[i] * suffix[i];
        }
        return nums;
    }

    private static int[] getPrefix(int[] arr) {
        int n = arr.length;
        int[] prefixProduct = new int[n];

        prefixProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * arr[i - 1];
        }
        return prefixProduct;
    }

    private static int[] getSuffix(int[] arr) {
        int length = arr.length;
        int[] suffixProduct = new int[length];

        suffixProduct[length - 1] = 1; // Последний элемент — справа ничего нет

        for (int i = length - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * arr[i + 1];
        }
        return suffixProduct;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
