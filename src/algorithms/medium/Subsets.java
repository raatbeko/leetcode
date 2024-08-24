package algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        subset(nums, 0, lists, new ArrayList<>());
        return lists;
    }

    private static void subset(int[] nums, int next, List<List<Integer>> lists, List<Integer> integers) {
        lists.add(new ArrayList<>(integers));

        for (int i = next; i < nums.length; i++) {
            if (i > next && nums[i] == nums[i - 1]) {
                continue;
            }

            integers.add(nums[i]);
            subset(nums, i + 1, lists, new ArrayList<>(integers));
            integers.remove(integers.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
