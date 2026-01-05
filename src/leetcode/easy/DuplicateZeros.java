package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class DuplicateZeros {

    public static void duplicateZeros(int[] arr) {
        int zeros = 0;
        for (int num : arr) {
            if (num == 0) zeros++;
        }

        int n = arr.length;
        int i = n - 1;
        int j = n + zeros - 1;

        while (i >= 0) {
            if (j < n) {
                arr[j] = arr[i];
            }

            if (arr[i] == 0) {
                j--;
                if (j < n) {
                    arr[j] = 0;
                }
            }

            i--;
            j--;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
    }
}
