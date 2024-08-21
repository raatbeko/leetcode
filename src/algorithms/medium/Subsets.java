package algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        subset(nums, 0, lists);
        return lists;
    }

    private static void subset(int[] nums, int curren, List<List<Integer>> lists) {
        if (nums.length == curren)
            return;

        for (int i = curren; i < nums.length; i++) {

        }
        subset(nums, curren + 1, lists);
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2}));
    }
}
