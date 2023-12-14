package algorithms.medium;

import java.util.Objects;

public class SearchMatrix {


    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        matrix[0][0] = 1;
        matrix[0][1] = 3;
        matrix[0][2] = 5;
        matrix[0][3] = 7;

        matrix[1][0] = 10;
        matrix[1][1] = 11;
        matrix[1][2] = 15;
        matrix[1][3] = 20;

        matrix[2][0] = 23;
        matrix[2][1] = 30;
        matrix[2][2] = 34;
        matrix[2][3] = 60;
        System.out.println(searchMatrix(matrix, 0));
//        int[] nums = new int[]{1, 2, 3, 4, 5};
//        System.out.println(binarySearch(nums, 4, 0, nums.length - 1));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] arr : matrix) {
            Integer t = binarySearch(arr, target, 0, arr.length - 1);
            if (t != null && t == target)
                return true;
        }
        return false;
    }

    public static Integer binarySearch(int[] nums, int item, int low, int high) {
        Integer mid = (low + high) / 2;

        int guess = nums[mid];
        if (guess == item)
            return nums[mid];
        if (mid == high || high < 0)
            return null;
        if (guess > item)
            mid = binarySearch(nums, item, low, mid - 1);
        else
            mid = binarySearch(nums, item, mid + 1, high);

        return mid;
    }
}
