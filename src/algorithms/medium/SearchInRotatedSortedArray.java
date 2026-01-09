package algorithms.medium;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (nums[left] > nums[right]) {
            if (nums[right] == target) {
                return right;
            }
            if (nums[left] > nums[right]) {
                right--;
            }
        }

        return binarySearch(nums, target, left, right);
    }

    public static int binarySearch(int[] nums, int item, int low, int high) {
        if (low > high) return -1;

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

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 4));
    }
}
