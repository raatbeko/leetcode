package algorithms.easy;

import java.util.Arrays;
import java.util.Objects;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]){
                continue;
            }
            nums[k] = nums[i];
            k++;
        }
        return k;
    }

    private static int[] delete(int[] nums, int index) {
        for (int i = index; i < nums.length - 1; i++) {
            int num = nums[i + 1];
            nums[i + 1] = nums[index];
            nums[index] = num;
            index++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 0, 0, 0, 3, 3};
        System.out.println(removeDuplicates(nums));
//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(Arrays.toString(arr));
//        reverseArray(arr);
//        System.out.println(Arrays.toString(arr));
    }

    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Обмен значений между элементами left и right
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Перемещение указателей внутрь массива
            left++;
            right--;
        }
    }
}
