package algorithms.base;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(binarySearch(nums, 5, 0, nums.length - 1));
    }

    public static int binarySearch(int[] nums, int item, int low, int high) {
        int mid = (low + high) / 2;

        int guess = nums[mid];
        if (guess == item)
            return mid;
        if (guess > item)
            mid = binarySearch(nums, item, low, mid - 1);
        else
            mid = binarySearch(nums, item, mid + 1, high);

        return mid;
    }
}
