package algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        subset(nums, 0, lists, new ArrayList<>());
        return lists;
    }

    private static void subset(int[] nums, int next, List<List<Integer>> lists, List<Integer> integers) {
        if (nums.length == next)
            return;

        for (int i = next; i < nums.length; i++) {
            integers.add(nums[i]);
            lists.add(new ArrayList<>(integers));

            subset(nums, i + 1, lists, new ArrayList<>(integers));
            integers.remove(integers.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{}));
    }
}
