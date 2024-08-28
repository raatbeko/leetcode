package algorithms.medium;

import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                // Найти элемент справа, который больше nums[i - 1]
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[i - 1] < nums[j]) {
                        // Поменять местами nums[i - 1] и nums[j]
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        // Развернуть подмассив справа от i
                        reverseArray(nums, i);
                        System.out.println(Arrays.toString(nums));
                        return;
                    }
                }
            }
        }
        // Если следующей перестановки нет, перевернуть весь массив (минимальная перестановка)
        reverseArray(nums, 0);
        System.out.println(Arrays.toString(nums));
    }

    private static void reverseArray(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{0,1,-1});
    }
}
