package algorithms.medium;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        return find(nums, target, 0, nums.length - 1);
    }

    private static int find(int[] nums, int target, int left, int right) {
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3, 5}, 5));
    }
}
