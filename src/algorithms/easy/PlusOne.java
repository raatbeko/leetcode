package algorithms.easy;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int[] arr = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            int res = digits[i] + 1;
            if (res / 10 != 1) {
                digits[i] = res;
                return digits;
            }
            digits[i] = 0;
            arr[i + 1] = 0;
            if (i == 0) {
                arr[0] = 1;
                return arr;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,9})));
    }
}
