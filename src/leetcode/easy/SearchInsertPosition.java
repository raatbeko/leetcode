package leetcode.easy;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int indx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
            if (nums[i] < target) {
                indx++;
                if (i + 1 == nums.length)
                    return indx;
            }
            if (nums[i] < target && nums[i + 1] > target)
                return i + 1;
        }
        return indx;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6, 8}, 7));
    }
}
